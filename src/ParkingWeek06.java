import java.util.Arrays;

/** Week 6: store and search a fictional four-cell grid. */
public class ParkingWeek06 {
    public static void main(String[] args) {
        String[] cells = {"A-01", "A-02", "A-03", "A-04"};
        String[] tokens = {"", "ORBIT-07", "", ""};
        int orbitIndex = findCell(cells, "A-02");
        int occupied = countOccupied(tokens);

        System.out.println("Grid cells: " + Arrays.toString(cells));
        System.out.println("Search A-02 -> " + tokens[orbitIndex]);
        System.out.println("Occupied cells: " + occupied);
    }

    static int findCell(String[] cells, String target) {
        for (int index = 0; index < cells.length; index++) {
            if (cells[index].equals(target)) {
                return index;
            }
        }
        return -1;
    }

    static int countOccupied(String[] tokens) {
        int count = 0;
        for (String token : tokens) {
            if (!token.isBlank()) {
                count++;
            }
        }
        return count;
    }
}
