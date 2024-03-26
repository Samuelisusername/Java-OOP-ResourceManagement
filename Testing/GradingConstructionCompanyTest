import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class GradingConstructionCompanyTest {
	
	/** a) **/
	
	@Test
	public void testA01() {
		CCompany company = new CCompany();
		CSite site = company.createCSite(Set.of(2), 1);
		
		Resource r1 = new GradingResource(2);
		Resource r2 = new GradingResource(3);
		
		assertEquals(Set.of(), site.resources());
		
		assertTrue(site.canAdd(r1));
		
		site.add(r1);
		
		assertEquals(Set.of(r1), site.resources());
		
		site.use(r1);
		
		assertEquals(Set.of(), site.resources());
		
		assertFalse(site.canAdd(r2));
	}
	
	@Test
	public void testA02() {
		CCompany company = new CCompany();
		CSite site = company.createCSite(Set.of(4,5), 3);
		
		Resource r1 = new GradingResource(4);
		Resource r2 = new GradingResource(4);
		Resource r3 = new GradingResource(4);
		Resource r4 = new GradingResource(4);
		Resource r5 = new GradingResource(5);
		
		assertEquals(Set.of(), site.resources());
		
		site.add(r1);
		site.add(r2);
		site.add(r3);
		
		assertEquals(Set.of(r1,r2,r3), site.resources());
		
		assertFalse(site.canAdd(r4));
		
		assertTrue(site.canAdd(r5));
		
		site.add(r5);
		
		assertEquals(Set.of(r1,r2,r3,r5), site.resources());
	}
	
	@Test
	public void testA03ResourcesEmpty() {
		CCompany company = new CCompany();
		CSite site = company.createCSite(Set.of(19,100,200), 1);
		assertEquals(Set.of(), site.resources());
	}
	
	@Test
	public void testA04Add1() {
		CCompany company = new CCompany();
		CSite site = company.createCSite(Set.of(19), 20);
		Resource r1 = new GradingResource(19);

		site.add(r1);
		
		assertEquals(1, site.resources().size());
	}
	
	@Test
	public void testA05Add2() {
		CCompany company = new CCompany();
		CSite site = company.createCSite(Set.of(34), 9);

		Resource r1 = new GradingResource(34);
		Resource r2 = new GradingResource(34);
		Resource r3 = new GradingResource(34);
		Resource r4 = new GradingResource(34);

		site.add(r1);
		site.add(r2);
		site.add(r3);
		site.add(r4);
		
		assertEquals(Set.of(r1, r2, r3, r4), site.resources());
	}
	
	@Test
	public void testA06Add3() {
		CCompany company = new CCompany();
		CSite site = company.createCSite(Set.of(9,21), 3);
		
		Resource r9a = new GradingResource(9);
		Resource r9b = new GradingResource(9);
		Resource r9c = new GradingResource(9);
		
		Resource r21a = new GradingResource(21);
		Resource r21b = new GradingResource(21);
		Resource r21c = new GradingResource(21);

		site.add(r9a);
		site.add(r21a);
		
		assertEquals(Set.of(r9a, r21a), site.resources());
		
		site.add(r9b);
		site.add(r9c);
		site.add(r21b);
		
		assertEquals(Set.of(r9a, r9b, r9c, r21a, r21b), site.resources());
		
		site.add(r21c);
		
		assertEquals(Set.of(r9a, r9b, r9c, r21a, r21b, r21c), site.resources());		
	}
	
	@Test
	public void testA07Add4() {
		CCompany company = new CCompany();
		CSite site = company.createCSite(Set.of(34), 2);
		
		assertThrows(IllegalArgumentException.class, () -> site.add(new GradingResource(35)));
		
		site.add(new GradingResource(34));
		site.add(new GradingResource(34));
		
		assertThrows(IllegalArgumentException.class, () -> site.add(new GradingResource(34)));		
	}	
	
	@Test
	public void testA08CanAdd1() {
		CCompany company = new CCompany();		
		CSite site = company.createCSite(Set.of(4), 1);
		
		Resource r1 = new GradingResource(4);
		Resource r2 = new GradingResource(4);
		Resource r3 = new GradingResource(10);
		
		assertTrue(site.canAdd(r1));
		assertTrue(site.canAdd(r2));
		assertFalse(site.canAdd(r3));
	}
	
	@Test
	public void testA09CanAdd2() {
		CCompany company = new CCompany();		
		CSite site = company.createCSite(Set.of(4), 2);
		
		Resource r1 = new GradingResource(4);
		Resource r2 = new GradingResource(4);
		Resource r3 = new GradingResource(4);

		
		assertTrue(site.canAdd(r1));
		assertTrue(site.canAdd(r2));
		assertTrue(site.canAdd(r3));
		
		site.add(r1);
		
		assertTrue(site.canAdd(r2));
		assertTrue(site.canAdd(r3));
		
		site.add(r3);
		
		assertFalse(site.canAdd(r2));
	}
	
	@Test
	public void testA10CanAdd3() {
		CCompany company = new CCompany();		
		CSite site = company.createCSite(Set.of(4,9,10,20), 3);

		for(int i = 0; i < 3; i++) {
			assertTrue(site.canAdd(new GradingResource(4)));
			assertTrue(site.canAdd(new GradingResource(9)));
			assertTrue(site.canAdd(new GradingResource(10)));
			assertTrue(site.canAdd(new GradingResource(20)));
			
			site.add(new GradingResource(4));
			site.add(new GradingResource(9));
			site.add(new GradingResource(10));
			site.add(new GradingResource(20));
		}
		
		for(int i = 0; i < 3; i++) {
			assertFalse(site.canAdd(new GradingResource(4)));
			assertFalse(site.canAdd(new GradingResource(9)));
			assertFalse(site.canAdd(new GradingResource(10)));
			assertFalse(site.canAdd(new GradingResource(20)));
		}
	}
	
	@Test
	public void testA11Use1() {
		CCompany company = new CCompany();
		CSite site = company.createCSite(Set.of(12), 1);

		GradingResource r12 = new GradingResource(12);
		
		site.add(r12);
		
		assertEquals(1, site.resources().size());
		
		site.use(r12);
		
		assertEquals(0, site.resources().size());
	}
	
	@Test
	public void testA12Use2() {
		CCompany company = new CCompany();
		CSite site = company.createCSite(Set.of(9), 1);
		
		GradingResource r0 = new GradingResource(9);
		GradingResource r1 = new GradingResource(9);
		GradingResource r2 = new GradingResource(9);

		site.add(r0);
		
		assertFalse(site.canAdd(r1));
		assertFalse(site.canAdd(r2));
		
		site.use(r0);
		
		assertTrue(site.canAdd(r1));
		assertTrue(site.canAdd(r2));
		
		site.add(r1);
		
		assertFalse(site.canAdd(r2));
		
		site.use(r1);
	
		assertTrue(site.canAdd(r2));		
	}
	
	@Test
	public void testA13Use3() {
		CCompany company = new CCompany();
		CSite site = company.createCSite(Set.of(10,19,23), 3);
		
		GradingResource r10a = new GradingResource(10);
		GradingResource r10b = new GradingResource(10);

		GradingResource r19a = new GradingResource(19);

		GradingResource r23a = new GradingResource(23);
		GradingResource r23b = new GradingResource(23);
		
		site.add(r10a);
		site.add(r10b);
		
		site.add(r19a);
		
		site.add(r23a);
		site.add(r23b);
		
		assertEquals(Set.of(r10a, r10b, r19a, r23a, r23b), site.resources());
		
		site.use(r23b);
		
		assertEquals(Set.of(r10a, r10b, r19a, r23a), site.resources());

		site.use(r10a);
		
		assertEquals(Set.of(r10b, r19a, r23a), site.resources());
	}
	
	@Test
	public void testA14Use4() {
		CCompany company = new CCompany();
		CSite site = company.createCSite(Set.of(9), 2);
		
		assertThrows(IllegalArgumentException.class, () -> site.use(new GradingResource(0)));
	}
	
	@Test
	public void testA15() {
		CCompany companyA = new CCompany();
		CCompany companyB = new CCompany();

		CSite csiteA1 = companyA.createCSite(Set.of(4,15), 2);
		CSite csiteA2 = companyA.createCSite(Set.of(4,8,15), 3);
		CSite csiteA3 = companyA.createCSite(Set.of(1), 1);
		CSite csiteB = companyB.createCSite(Set.of(5,15), 2);
		
		GradingResource res4a = new GradingResource(4);

		csiteA1.add(res4a);
		assertTrue(csiteA1.canAdd(new GradingResource(4)));
		assertTrue(csiteA1.canAdd(new GradingResource(15)));		
		
		assertEquals(Set.of(res4a), csiteA1.resources());
		assertEquals(Set.of(), csiteA2.resources());
		assertEquals(Set.of(), csiteA3.resources());
		assertEquals(Set.of(), csiteB.resources());
		
		GradingResource res4c = new GradingResource(4);		
		GradingResource res8a = new GradingResource(8);
		GradingResource res8b = new GradingResource(8);
		GradingResource res8c = new GradingResource(8);
		
		csiteA2.add(res4c);
		csiteA2.add(res8a);
		csiteA2.add(res8b);
		csiteA2.add(res8c);;
		
		assertFalse(csiteA2.canAdd(new GradingResource(8)));
		assertTrue(csiteA2.canAdd(new GradingResource(4)));
		
		assertEquals(Set.of(res4a), csiteA1.resources());
		assertEquals(Set.of(res4c, res8a, res8b, res8c), csiteA2.resources());
		assertEquals(Set.of(), csiteA3.resources());
		assertEquals(Set.of(), csiteB.resources());

		csiteB.add(new GradingResource(5));
		csiteB.add(new GradingResource(5));
		csiteB.add(new GradingResource(15));
		
		assertFalse(csiteB.canAdd(new GradingResource(5)));
		assertFalse(csiteB.canAdd(new GradingResource(25)));
		assertTrue(csiteB.canAdd(new GradingResource(15)));
		
		csiteB.add(new GradingResource(15));
		
		assertFalse(csiteB.canAdd(new GradingResource(15)));
		
		assertEquals(Set.of(res4a), csiteA1.resources());
		assertEquals(Set.of(res4c, res8a, res8b, res8c), csiteA2.resources());
		assertEquals(Set.of(), csiteA3.resources());
		assertEquals(4, csiteB.resources().size());
	}

	/** b) */

		@Test
	public void testB01() {
		CCompany company = new CCompany();
		CSite site = company.createCSite(2);
		
		Resource r1 = new GradingResource(2);
		Resource r2 = new GradingResource(3);
		Resource r3 = new GradingResource(2);
		Resource r4 = new GradingResource(2);
		Resource r5 = new GradingResource(2);
		
		company.add(r1);
		company.add(r2);
		company.add(r3);
		company.add(r4);
		company.add(r5);
		
		assertEquals(Set.of(r1, r2, r3, r4, r5), company.resources());
		
		assertEquals(Set.of(), site.resources());
		
		company.nextDay();
		
		assertEquals(Set.of(r1, r3), site.resources());
		
		site.use(r1);
		
		assertEquals(Set.of(r3), site.resources());
		
		company.nextDay();
		
		assertEquals(Set.of(r3, r4), site.resources());
		
		site.use(r4);
		
		site.close();
		
		company.nextDay();
		
		assertEquals(Set.of(r2, r5), company.resources());
	}
	
	@Test
	public void testB02() {
		CCompany company = new CCompany();
		CSite site1 = company.createCSite(2);
		CSite site2 = company.createCSite(2);
		CSite site3 = company.createCSite(3);
		
		Resource r1 = new GradingResource(2);
		Resource r2 = new GradingResource(3);
		Resource r3 = new GradingResource(2);
		Resource r4 = new GradingResource(2);
		
		company.add(r1);
		company.add(r2);
		company.add(r3);
		company.add(r4);
		
		company.nextDay();
		
		assertEquals(Set.of(r1, r3), site1.resources());
		assertEquals(Set.of(r4), site2.resources());
		assertEquals(Set.of(r2), site3.resources());
		
		CSite site4 = company.createCSite(2);
		
		Resource r5 = new GradingResource(2);
		
		company.add(r5);
		
		site2.close();
		
		company.nextDay();
		
		assertEquals(Set.of(r5), site4.resources());
	}
	
	@Test
	public void testB03EmptyResources() {
		CCompany company = new CCompany();
		assertEquals(Set.of(), company.resources());
	}
	
	@Test
	public void testB04Add1() {
		CCompany company = new CCompany();
		company.add(new GradingResource(0));
		assertNotNull(company.resources());
		assertEquals(1, company.resources().size());
	}
	
	@Test
	public void testB05Add2() {
		CCompany company = new CCompany();
		
		GradingResource r1 = new GradingResource(0);		
		company.add(r1);
		
		assertEquals(Set.of(r1), company.resources());
		
		GradingResource r2 = new GradingResource(1);
		company.add(r2);
		
		assertEquals(Set.of(r1, r2), company.resources());
		
		GradingResource r3 = new GradingResource(2);
		company.add(r3);
		
		assertEquals(Set.of(r1, r2, r3), company.resources());

		GradingResource r4 = new GradingResource(2);
		company.add(r4);
		
		assertEquals(Set.of(r1, r2, r3, r4), company.resources());

		GradingResource r5 = new GradingResource(0);
		company.add(r5);
		
		assertEquals(Set.of(r1, r2, r3, r4, r5), company.resources());

		GradingResource r6 = new GradingResource(0);
		company.add(r6);
		
		assertEquals(Set.of(r1, r2, r3, r4, r5, r6), company.resources());
	}
	
	@Test
	public void testB06NextDay1() {
		CCompany company = new CCompany();
		
		GradingResource r1 = new GradingResource(7);
		GradingResource r2 = new GradingResource(7);
		
		company.add(r1);
		company.add(r2);
		
		CSite site = company.createCSite(7);
		
		assertEquals(Set.of(r1, r2), company.resources());
		
		company.nextDay();
		
		assertEquals(Set.of(), company.resources());
		assertEquals(Set.of(r1, r2), site.resources());
	}
	
	@Test
	public void testB07NextDay2() {
		CCompany company = new CCompany();
		
		GradingResource r1 = new GradingResource(7);
		GradingResource r2 = new GradingResource(9);
		GradingResource r3 = new GradingResource(9);
		GradingResource r4 = new GradingResource(5);
		
		company.add(r1);
		company.add(r2);
		company.add(r3);
		company.add(r4);
		
		CSite site = company.createCSite(9);
		
		assertEquals(Set.of(), site.resources());
		
		company.nextDay();

		assertEquals(Set.of(r2,r3), site.resources());
	}
	
	@Test
	public void testB08NextDay3() {
		CCompany company = new CCompany();
		
		CSite site1 = company.createCSite(0);
		CSite site2 = company.createCSite(1);
		
		GradingResource r1 = new GradingResource(0);
		GradingResource r2 = new GradingResource(1);
		GradingResource r3 = new GradingResource(0);
		
		company.add(r1);
		company.add(r2);
		company.add(r3);
		
		assertEquals(Set.of(), site1.resources());
		assertEquals(Set.of(), site2.resources());
		
		company.nextDay();

		assertEquals(Set.of(r1,r3), site1.resources());		
		assertEquals(Set.of(r2), site2.resources());
		
		GradingResource r5 = new GradingResource(1);
		
		company.add(r5);		
		company.nextDay();
		
		assertEquals(Set.of(r1,r3), site1.resources());
		assertEquals(Set.of(r2,r5), site2.resources());
	}
	
	@Test
	public void testB08NextDay4() {
		CCompany company = new CCompany();
		
		CSite site1 = company.createCSite(1);
		
		GradingResource r1 = new GradingResource(1);	
		
		company.add(r1);
				
		company.nextDay();
		
		assertEquals(Set.of(r1), site1.resources());
		
		GradingResource r2 = new GradingResource(1);
		GradingResource r3 = new GradingResource(1);
		GradingResource r4 = new GradingResource(1);

		company.add(r2);
		company.add(r3);
		company.add(r4);
		
		company.nextDay();
		
		assertEquals(Set.of(r1, r2), site1.resources());
		
		assertEquals(Set.of(r3, r4), company.resources());
	}
	
	@Test
	public void testB09NextDay5() {
		CCompany company = new CCompany();

		CSite csite1 = company.createCSite(1);
		CSite csite2 = company.createCSite(2);
		CSite csite3 = company.createCSite(1);
		CSite csite4 = company.createCSite(1);
		CSite csite5 = company.createCSite(2);
		
		GradingResource r1 = new GradingResource(1);
		GradingResource r2 = new GradingResource(2);
		GradingResource r3 = new GradingResource(2);

		company.add(r1);
		company.add(r2);
		company.add(r3);
		
		company.nextDay();
		
		assertEquals(Set.of(r1), csite1.resources());
		assertEquals(Set.of(r2, r3), csite2.resources());
		assertEquals(Set.of(), csite3.resources());
		assertEquals(Set.of(), csite4.resources());
		assertEquals(Set.of(), csite5.resources());
				
		GradingResource r5 = new GradingResource(2);
		GradingResource r6 = new GradingResource(1);
		GradingResource r7 = new GradingResource(1);
		GradingResource r8 = new GradingResource(1);
		
		company.add(r5);
		company.add(r6);
		company.add(r7);
		company.add(r8);
		
		company.nextDay();
		
		assertEquals(Set.of(r1,r6), csite1.resources());
		assertEquals(Set.of(r2, r3), csite2.resources());
		assertEquals(Set.of(r7,r8), csite3.resources());
		assertEquals(Set.of(), csite4.resources());
		assertEquals(Set.of(r5), csite5.resources());
	}
	
	@Test
	public void testB10NextDay6() {
		CCompany company = new CCompany();
		
		CSite csite1 = company.createCSite(Set.of(1,2,3), 3);
		CSite csite2 = company.createCSite(Set.of(1,5), 2);
		CSite csite3 = company.createCSite(Set.of(1,5), 2);
		
		GradingResource r1 = new GradingResource(5);
		GradingResource r2 = new GradingResource(1);
		GradingResource r3 = new GradingResource(1);
		GradingResource r4 = new GradingResource(1);
		
		company.add(r1);
		company.add(r2);
		company.add(r3);
		company.add(r4);
		
		company.nextDay();

		assertEquals(Set.of(r2, r3, r4), csite1.resources());
		assertEquals(Set.of(r1), csite2.resources());
		assertEquals(Set.of(), csite3.resources());

		GradingResource r5 = new GradingResource(1);
		GradingResource r6 = new GradingResource(1);
		GradingResource r7 = new GradingResource(5);
		GradingResource r8 = new GradingResource(5);
		
		company.add(r5);
		company.add(r6);
		company.add(r7);
		company.add(r8);
		
		company.nextDay();
		
		assertEquals(Set.of(r2, r3, r4), csite1.resources());
		assertEquals(Set.of(r1, r5, r6, r7), csite2.resources());
		assertEquals(Set.of(r8), csite3.resources());
	}
	
	@Test
	public void testB11Close1() {
		CCompany company = new CCompany();
		
		CSite csite1 = company.createCSite(1);
		
		GradingResource r1 = new GradingResource(1);
				
		company.add(r1);
		
		assertEquals(Set.of(r1), company.resources());
		assertEquals(Set.of(), csite1.resources());
		
		company.nextDay();
		
		assertEquals(Set.of(), company.resources());
		assertEquals(Set.of(r1), csite1.resources());
		
		company.add(new GradingResource(1));
		
		csite1.close();
		
		company.nextDay();
		
		assertNotNull(company.resources());
		assertEquals(1, company.resources().size());
	}
	
	@Test
	public void testB11Close2() {	
		CCompany company = new CCompany();
		
		CSite csite1 = company.createCSite(1);
		CSite csite2 = company.createCSite(1);
		
		GradingResource r1 = new GradingResource(1);
		
		company.add(r1);

		csite1.close();
		
		company.nextDay();
		
		assertEquals(Set.of(), company.resources());
		assertEquals(Set.of(r1), csite2.resources());		
	}

	/** c) */
	
		@Test
	public void testC01() {
		CCompany company = new CCompany();
		CSite site = company.createCSite(Set.of(2), 2, 1);
		
		Resource r1 = new GradingResource(2);
		Resource r2 = new GradingResource(2);
		Resource r3 = new GradingResource(2);
		
		company.add(r1);
		company.add(r2);
		company.add(r3);
		
		company.nextDay();
		
		assertEquals(Set.of(r1, r2), site.resources());
		
		company.nextDay();
		
		assertEquals(2, site.resources().size());
		assertTrue(site.resources().contains(r3));
	}
	
	@Test
	public void testC02() {
		CCompany company = new CCompany();
		CSite site = company.createCSite(Set.of(4,2,3), 2, 1);
		
		Resource r1 = new GradingResource(4);
		Resource r2 = new GradingResource(4);
		Resource r3 = new GradingResource(4);
		Resource r4 = new GradingResource(2);
		Resource r5 = new GradingResource(2);
		Resource r6 = new GradingResource(2);
		Resource r7 = new GradingResource(3);
		
		company.add(r1);
		company.add(r2);
		company.add(r3);
		company.add(r4);
		company.add(r5);
		company.add(r6);
		company.add(r7);
		
		company.nextDay();
		
		assertEquals(Set.of(r1, r2, r4, r5, r7), site.resources());
		
		company.nextDay();
		
		assertEquals(5, site.resources().size());
		assertTrue(site.resources().contains(r3));
		assertTrue(site.resources().contains(r6));
		assertTrue(site.resources().contains(r7));
	}
	
	@Test
	public void testC03() {
		CCompany company = new CCompany();
		CSite site = company.createCSite(Set.of(5), 1, 0);
		
		company.add(new GradingResource(5));
		
		company.nextDay();
		
		GradingResource r2 = new GradingResource(5);
		
		company.add(r2);
		
		company.nextDay();
		
		assertEquals(Set.of(r2), site.resources());
	}

	@Test
	public void testC04() {
		CCompany company = new CCompany();
		CSite site = company.createCSite(Set.of(5), 4, 3);
		
		GradingResource r1 = new GradingResource(5);
		
		company.add(r1);
		
		company.nextDay();
		
		assertEquals(Set.of(r1), site.resources());
		
		GradingResource r2 = new GradingResource(5);
		GradingResource r3 = new GradingResource(5);
		GradingResource r4 = new GradingResource(5);

		company.add(r2);
		company.add(r3);
		company.add(r4);
		
		company.nextDay();
		
		assertEquals(Set.of(r1,r2,r3,r4), site.resources());
		
		company.nextDay();

		assertEquals(Set.of(r1,r2,r3,r4), site.resources());
		
		GradingResource r5 = new GradingResource(5);
		company.add(r5);
		
		company.nextDay();
		
		assertEquals(4, site.resources().size());
		assertEquals(1, company.resources().size());
		
		assertTrue(site.resources().contains(r5));
	}
	
	@Test
	public void testC05() {
		CCompany company = new CCompany();
		
		CSite site = company.createCSite(Set.of(12), 2, 0);
		
		GradingResource r1 = new GradingResource(12);
		GradingResource r2 = new GradingResource(12);
		company.add(r1);
		company.add(r2);
		
		company.nextDay();
		
		assertEquals(2, site.resources().size());
		
		GradingResource r3 = new GradingResource(12);
		GradingResource r4 = new GradingResource(12);		
		company.add(r3);
		company.add(r4);
		
		company.nextDay();
		
		assertEquals(Set.of(r3, r4), site.resources());
		assertEquals(Set.of(r1, r2), company.resources());
	}
	
	@Test
	public void testC06() {
		CCompany company = new CCompany();
		
		CSite site1 = company.createCSite(Set.of(3), 2, 1);
		CSite site2 = company.createCSite(Set.of(3), 2, 1);
		
		GradingResource r1 = new GradingResource(3);
		GradingResource r2 = new GradingResource(3);
		GradingResource r3 = new GradingResource(3);
		
		company.add(r1);
		company.add(r2);
		company.add(r3);
		
		company.nextDay();
		
		assertEquals(Set.of(r1, r2), site1.resources());
		assertEquals(Set.of(r3), site2.resources());
		
		company.nextDay();
		
		assertEquals(Set.of(r1, r2), site1.resources());
		assertEquals(Set.of(r3), site2.resources());
		
		GradingResource r4 = new GradingResource(3);
		GradingResource r5 = new GradingResource(3);

		company.add(r4);
		company.add(r5);
		
		company.nextDay();
		
		assertEquals(2, site1.resources().size());
		assertEquals(2, site2.resources().size());
		
		assertTrue(site1.resources().contains(r4));
		assertTrue(site2.resources().contains(r5));
	}
	
	@Test
	public void testC07() {
		CCompany company = new CCompany();

		CSite site1 = company.createCSite(Set.of(1,2,3), 3, 2);
		CSite site2 = company.createCSite(Set.of(2,5,7), 2, 1);
		CSite site3 = company.createCSite(Set.of(5), 2, 1);
		
		company.add(new GradingResource(3));
		company.add(new GradingResource(1));
		company.add(new GradingResource(2));
		
		company.add(new GradingResource(2));
		company.add(new GradingResource(3));
		company.add(new GradingResource(1));
				
		company.add(new GradingResource(2));
		
		company.add(new GradingResource(5));
		company.add(new GradingResource(5));
		company.add(new GradingResource(2));
		company.add(new GradingResource(2));
		
		company.add(new GradingResource(5));
		company.add(new GradingResource(5));
		
		company.nextDay();
		
		assertEquals(7, site1.resources().size());
		assertEquals(4, site2.resources().size());
		assertEquals(2, site3.resources().size());
		
		GradingResource r2a = new GradingResource(2);
		GradingResource r2b = new GradingResource(2);
		GradingResource r5a = new GradingResource(5);
		GradingResource r5b = new GradingResource(5);
		
		company.add(r2a);
		company.add(r2b);
		company.add(r5a);
		company.add(r5b);
				
		company.nextDay();
		
		assertEquals(7, site1.resources().size());
		assertEquals(4, site2.resources().size());
		assertEquals(2, site3.resources().size());
		
		assertTrue(site1.resources().contains(r2a));
		assertTrue(site2.resources().contains(r2b));
		assertTrue(site2.resources().contains(r5a));
		assertTrue(site3.resources().contains(r5b));
	}
	
	@Test
	public void testC08() {
		CCompany company = new CCompany();

		CSite site1 = company.createCSite(Set.of(2), 4, 2);
		CSite site2 = company.createCSite(Set.of(2), 2);		
		
		GradingResource r1 = new GradingResource(2);
		GradingResource r2 = new GradingResource(2);
		GradingResource r3 = new GradingResource(2);
		GradingResource r4 = new GradingResource(2);
		GradingResource r5 = new GradingResource(2);
		GradingResource r6 = new GradingResource(2);
		
		company.add(r1);
		company.add(r2);
		company.add(r3);
		company.add(r4);
		company.add(r5);
		company.add(r6);
		
		company.nextDay();
		
		assertEquals(Set.of(r1, r2, r3, r4), site1.resources());
		assertEquals(Set.of(r5, r6), site2.resources());
		
		GradingResource r7 = new GradingResource(2);
		GradingResource r8 = new GradingResource(2);
		GradingResource r9 = new GradingResource(2);
		GradingResource r10 = new GradingResource(2);
		
		company.add(r7);
		company.add(r8);
		company.add(r9);
		company.add(r10);
		
		company.nextDay();
		
		assertEquals(4, site1.resources().size());
		assertTrue(site1.resources().contains(r7));
		assertTrue(site1.resources().contains(r8));
		
		assertEquals(Set.of(r5, r6), site2.resources());
	}

}

class GradingResource implements Resource {
	int typeId;
	GradingResource(int typeId) {
		this.typeId = typeId;
	} 
	
	@Override
	public int type() {
		return typeId;
	}
}
