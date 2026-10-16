/** Week 4: replay fixed classroom allocation actions with a loop. */
public class ParkingWeek04 {
    public static void main(String[] args) {
        String[] actions = {"Allocated NOVA-12 -> A-03", "Released A-03", "View GRID-A"};
        int index = 0;

        System.out.println("1 Allocate  2 Release  3 View");
        while (index < actions.length) {
            if (index < 2) {
                System.out.println(actions[index]);
            }
            index++;
        }
        System.out.println("Workflow complete.");
    }
}
