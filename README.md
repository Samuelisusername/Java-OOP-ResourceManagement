Model of a Company that manages construction sites (MyCSite), each with a resource type limit and flow limit.
Each site tracks the types and quantities of resources it can hold.

Each day, the company checks if construction sites are open and if their resource flow exceeds the limit. If so, resources are overflowed back to the company, managing how many resources each site can retain.
Then, resources are reallocated to open sites that can accept more resources.

In **main** you can find an example use of this system
