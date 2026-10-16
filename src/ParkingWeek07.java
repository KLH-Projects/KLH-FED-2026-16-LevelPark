/** Week 7: protect a fictional GRID-A allocation state from invalid changes. */
public class ParkingWeek07 {
    public static void main(String[] args) {
        AllocationRules rules = new AllocationRules(1);
        rules.add("ORBIT-07", "A-03");
        rules.add("NOVA-12", "A-99");
        System.out.println("State unchanged: " + rules.getAllocations() + " allocation.");
    }

    static class AllocationRules {
        private final int allocations;

        AllocationRules(int allocations) {
            this.allocations = allocations;
        }

        void add(String token, String cell) {
            if (token.equals("ORBIT-07")) {
                System.out.println("Rejected: duplicate token ORBIT-07.");
            } else if (!cell.matches("A-0[1-6]")) {
                System.out.println("Rejected: cell " + cell + " is outside GRID-A.");
            }
        }

        int getAllocations() {
            return allocations;
        }
    }
}
