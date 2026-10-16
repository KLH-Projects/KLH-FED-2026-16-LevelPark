Input: allocations = \[Allocation("ORBIT-07", "A-02", "GRID-A"), Allocation("NOVA-12", "A-03", "GRID-A"), Allocation("PIXEL-04", "B-01", "GRID-B")]

Execution Steps:

&#x20; 1. Create Stream from allocations list

&#x20; 2. Collect using Collectors.groupingBy(Allocation::grid, LinkedHashMap::new, Collectors.counting())

&#x20;    - Result Map: {GRID-A=2, GRID-B=1}

&#x20; 3. Calculate freeCells = 6 - 3 = 3

&#x20; 4. Print summary report headers and aggregated counts



Terminal Output:

CLASSROOM SLOT-ALLOCATION - FINAL REPORT

Active allocations: 3

Free cells: 3

Grid usage: GRID-A=2, GRID-B=1

Status: simulation complete.

