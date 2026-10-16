import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Week 12 final report over invented token/cell pairs only.
 * It has no live parking, vehicle, payment, or identity functionality.
 */
public class ParkingWeek12 {
    public static void main(String[] args) {
        List<Allocation> allocations = new ArrayList<>(List.of(
                new Allocation("ORBIT-07", "A-02", "GRID-A"),
                new Allocation("NOVA-12", "A-03", "GRID-A"),
                new Allocation("PIXEL-04", "B-01", "GRID-B")));
        Map<String, Long> usage = allocations.stream()
                .collect(Collectors.groupingBy(Allocation::grid, LinkedHashMap::new, Collectors.counting()));
        int freeCells = 6 - allocations.size();

        System.out.println("CLASSROOM SLOT-ALLOCATION - FINAL REPORT");
        System.out.println("Active allocations: " + allocations.size());
        System.out.println("Free cells: " + freeCells);
        System.out.println("Grid usage: GRID-A=" + usage.get("GRID-A") + ", GRID-B=" + usage.get("GRID-B"));
        System.out.println("Status: simulation complete.");
    }

    static class Allocation {
        private final String token;
        private final String cell;
        private final String grid;

        Allocation(String token, String cell, String grid) {
            this.token = token;
            this.cell = cell;
            this.grid = grid;
        }

        String grid() {
            return grid;
        }
    }
}
