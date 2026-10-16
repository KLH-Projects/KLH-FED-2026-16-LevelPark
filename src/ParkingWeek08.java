/** Week 8: recursively inspect a fixed fictional six-cell training grid. */
public class ParkingWeek08 {
    public static void main(String[] args) {
        boolean[] occupied = {true, false, false, false, false, false};
        int inspected = countInspected(occupied, 0);
        int free = countFree(occupied, 0);

        System.out.println("Cells inspected recursively: " + inspected);
        System.out.println("Free cells: " + free);
        System.out.println("Occupied cells: " + (occupied.length - free));
    }

    static int countInspected(boolean[] occupied, int index) {
        if (index == occupied.length) {
            return 0;
        }
        return 1 + countInspected(occupied, index + 1);
    }

    static int countFree(boolean[] occupied, int index) {
        if (index == occupied.length) {
            return 0;
        }
        return (occupied[index] ? 0 : 1) + countFree(occupied, index + 1);
    }
}
