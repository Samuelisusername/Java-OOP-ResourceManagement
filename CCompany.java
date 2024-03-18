import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.*;

public class CCompany {
	HashSet<Resource> companyres = new HashSet<Resource>();
	HashSet<MyCSite> companysites = new HashSet<MyCSite>();
	ArrayList<Resource> companyresources = new ArrayList<Resource>();
	//maybe use copy to do this things
	ArrayList<Resource> copy = new ArrayList<Resource>();
	ArrayList<MyCSite> companyconstructionsites = new ArrayList<MyCSite>();

	public CCompany() {
		// TODO
	}

	public Set<Resource> resources() {
		// TODO
		for (Resource re : companyres) {
			System.out.println(re.type() + "this is the type of what is returned");
		}
		System.out.println("-------------------------");
		System.out.println();

		return companyres;
	}

	public void add(Resource resource) {
		companyres.add(resource);
		companyresources.add(resource);
		copy.add(resource);
		return;
	}

	public void nextDay() {
		//going through all CSites
		for (int i = 0; i < companyconstructionsites.size(); i++) {
			//only the dynamic ones
			if (this.companyconstructionsites.get(i).isopen && this.companyconstructionsites.get(i).flowlimit >= 0) {
				//going through all types
				for (Integer j:companyconstructionsites.get(i).resourcestypes) {
					//overflow?
					if (companyconstructionsites.get(i).map.get(j) >this.companyconstructionsites.get(i).flowlimit) {
						//how much to overflow thing
						int overflow= companyconstructionsites.get(i).map.get(j)-this.companyconstructionsites.get(i).flowlimit;
						// per overflow give one back
						//make copy of arresoursen
						ArrayList<Resource> arrescopy = new ArrayList<Resource>();
						arrescopy.addAll(companyconstructionsites.get(i).arresources);
						//then later replace it
						for (int k=0; k<overflow;k++) {
							//take one from the set resources
							Resource thing =companyconstructionsites.get(i).arresources.get(k);
							
							arrescopy.remove(thing);
							companyconstructionsites.get(i).resources.remove(thing);
							//add one to the companyresources
							companyresources.add(thing);
							companyres.add(thing);
							companyconstructionsites.get(i).map.replace(j, companyconstructionsites.get(i).map.get(j)-1);
							
							//deduce one from the map
							//deduce stuff
						}
						companyconstructionsites.get(i).arresources.clear();
						companyconstructionsites.get(i).arresources.addAll(arrescopy);
						
					}
				}
			}

		}

		
		for (int i = 0; i < companyconstructionsites.size(); i++) {
			ArrayList<Resource> copy = new ArrayList<Resource>();
			copy.addAll(companyresources);
			for(Resource resour: companyresources) {
			
			
				// if I can add it the do this
				
				if (companyconstructionsites.get(i).isopen
						
						&& companyconstructionsites.get(i).canAdd(resour)) {
					// add it to site
					companyconstructionsites.get(i).add(resour);
					
					// take it away from the company resources
				//the problem is if i remove the thing that next round when i call get(j) then j is skipped by one
					copy.remove(resour);
					companyres.remove(resour);
				}
			}
			companyresources.clear();
			companyresources.addAll(copy);
		}

//		Iterator next = companysites.iterator();
//		while (next.hasNext()) {
//			MyCSite d = (MyCSite) next.next();
//			Iterator coms = companyres.iterator();
//			while (coms.hasNext()) {
//				Resource re = (Resource) coms.next();
//				if (d.canAdd(re)) {
//					d.add(re);
//					companyres.remove(re);
//				}
//			}
//		}
//		for (MyCSite site:companysites) {
//			for (Resource resource:companyres) {
//				if (site.canAdd(resource)) {
//					site.add(resource);
//					companyres.remove(resource);
//				}
//			}
//		}
		return;
	}

	public CSite createCSite(int type) {
		// Aendern Sie diese Methode, falls Sie Task (a) nicht geloest haben.

		return createCSite(Set.of(type), 2);
	}

	public CSite createCSite(Set<Integer> types, int limit) {

		return createCSite(types, limit, -1);
	}

	public CSite createCSite(Set<Integer> types, int limit, int flowLimit) {
		// TODO
		MyCSite c2 = new MyCSite(types, limit, flowLimit);
		companysites.add(c2);
		companyconstructionsites.add(c2);
		return c2;
	}
}

class MyCSite implements CSite {
	int limit;
	int flowlimit;
	boolean isopen;
	Set<Integer> resourcestypes;
	//sothat we can find items and delete them
	ArrayList<Resource> arresources = new ArrayList<Resource>();
	//sothat we can return a Set
	Set<Resource> resources;
	//sothat we know how many of a type
	HashMap<Integer, Integer> map;

	public MyCSite(Set<Integer> types, int limit, int flowlimit) {
		this.flowlimit = flowlimit;
		resources = new HashSet<Resource>();
		resourcestypes = types;
		this.limit = limit;
		map = new HashMap<Integer, Integer>();
		for (Integer sth : resourcestypes) {
			map.put(sth, 0);
		}
		isopen = true;
	}

	@Override
	public Set<Resource> resources() {
		// TODO Auto-generated method stub
		Set<Resource> se = new HashSet<Resource>();
		for (Resource d: resources) {
			se.add(d);
		}
		return se;
	}

	@Override
	public boolean canAdd(Resource resource) {
		if (resourcestypes.contains(resource.type())) {
			if (map.get(resource.type()) < limit) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void add(Resource resource) {
		if (this.canAdd(resource)) {
			map.put(resource.type(), map.get(resource.type()) + 1);
			resources.add(resource);
			arresources.add(resource);
			
		} else {
			throw new IllegalArgumentException();
		}

	}

	@Override
	public void use(Resource resource) {
		try {
			if (map.get(resource.type()) > 0) {
				map.put(resource.type(), map.get(resource.type()) - 1);
				resources.remove(resource);
				arresources.remove(resource);
			}
		} catch (Throwable e) {
			throw new IllegalArgumentException();
		}

	}

	@Override
	public void close() {
		isopen = false;

	}

}
