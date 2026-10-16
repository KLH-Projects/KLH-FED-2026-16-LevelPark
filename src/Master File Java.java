import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Unified Parking & Classroom Slot Allocation System
 * Combines all 12 weekly modules into a single, cohesive terminal application.
 */
public class UnifiedParkingSystem {

    private static final String CSV_FILE_PATH = "simulator-state.csv";
    private static final List<String> VALID_CELLS = List.of("A-01", "A-02", "A-03", "A-04", "B-01", "B-02");
    
    // In-memory state tracking active allocations
    private static final Map<String, Allocation> activeAllocations = new LinkedHashMap<>();

    public static void main(String[] args) {
        // Week 1: Basic Initialization
        String simulatorName = "Unified Slot Allocation Simulator";
        System.out.println("==================================================");
        System.out.println("  " + simulatorName.toUpperCase());
        System.out.println("==================================================");
        System.out.println("Total Grid Capacity: " + VALID_CELLS.size() + " cells");

        // Load existing state from file if available (Week 11)
        loadStateFromCSV();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Week 4: Action Replay / Interactive Command Loop
        while (running) {
            printMenu();
            System.out.print("Enter command choice (1-6): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    handleAllocation(scanner);
                    break;
                case "2":
                    handleRelease(scanner);
                    break;
                case "3":
                    handleSearch(scanner);
                    break;
                case "4":
                    runRecursiveInspection();
                    break;
                case "5":
                    generateFinalReport();
                    break;
                case "6":
                    saveStateToCSV();
                    running = false;
                    System.out.println("\nSystem shutting down. Goodbye!");
                    break;
                default:
                    System.out.println("\n[!] Invalid selection. Please enter a option between 1 and 6.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("1. Allocate Cell (Format: TOKEN CELL, e.g., ORBIT-07 A-02)");
        System.out.println("2. Release Cell  (Format: CELL, e.g., A-02)");
        System.out.println("3. Search Token / Cell Status");
        System.out.println("4. Run Recursive Grid Inspection");
        System.out.println("5. Generate Summary Report (Streams)");
        System.out.println("6. Save & Exit");
        System.out.println("--------------------------------------------------");
    }

    // =========================================================================
    // WEEK 2, 3, 5, 7, 10: Allocation Workflow with Validation & Exception Handling
    // =========================================================================
    private static void handleAllocation(Scanner scanner) {
        System.out.print("Enter allocation request (Token Cell): ");
        String input = scanner.nextLine().trim();

        try {
            String[] parts = input.split("\\s+");
            if (parts.length != 2) {
                throw new InvalidSimulatorCommandException("Expected format: TOKEN CELL (e.g., ORBIT-07 A-02)");
            }

            String token = parts[0].toUpperCase();
            String cell = parts[1].toUpperCase();

            // Week 2 & Week 10: Token and Grid Validation
            validateToken(token);
            validateCell(cell);

            // Week 7: Business Rules (Duplicate Token & Occupied Cell Checks)
            for (Allocation alloc : activeAllocations.values()) {
                if (alloc.getToken().equalsIgnoreCase(token)) {
                    throw new InvalidSimulatorCommandException("Duplicate token rejected: " + token + " is already allocated.");
                }
            }

            if (activeAllocations.containsKey(cell)) {
                throw new InvalidSimulatorCommandException("Cell " + cell + " is already occupied.");
            }

            // Week 9: Domain Object Creation
            String grid = cell.startsWith("A") ? "GRID-A" : "GRID-B";
            Allocation newAllocation = new Allocation(token, cell, grid);
            activeAllocations.put(cell, newAllocation);

            System.out.println("[SUCCESS] Allocated: " + newAllocation);
            System.out.println("Remaining Free Slots: " + (VALID_CELLS.size() - activeAllocations.size()));

        } catch (InvalidSimulatorCommandException e) {
            System.out.println("[REJECTED] " + e.getMessage());
        }
    }

    private static void handleRelease(Scanner scanner) {
        System.out.print("Enter Cell label to release: ");
        String cell = scanner.nextLine().trim().toUpperCase();

        try {
            validateCell(cell);

            if (!activeAllocations.containsKey(cell)) {
                System.out.println("[REJECTED] Cell " + cell + " is currently empty.");
                return;
            }

            Allocation removed = activeAllocations.remove(cell);
            System.out.println("[SUCCESS] Released cell " + cell + " (Was allocated to " + removed.getToken() + ")");
            System.out.println("Remaining Free Slots: " + (VALID_CELLS.size() - activeAllocations.size()));

        } catch (InvalidSimulatorCommandException e) {
            System.out.println("[REJECTED] " + e.getMessage());
        }
    }

    // =========================================================================
    // WEEK 6: Linear Array Search & Inspection
    // =========================================================================
    private static void handleSearch(Scanner scanner) {
        System.out.print("Enter Cell or Token to search: ");
        String target = scanner.nextLine().trim().toUpperCase();

        boolean found = false;
        for (String cell : VALID_CELLS) {
            Allocation alloc = activeAllocations.get(cell);
            if (cell.equalsIgnoreCase(target) || (alloc != null && alloc.getToken().equalsIgnoreCase(target))) {
                System.out.println("[FOUND] Cell: " + cell + " | Status: " + 
                        (alloc != null ? "OCCUPIED by " + alloc.getToken() : "FREE"));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("[NOT FOUND] No matching record for target: " + target);
        }
    }

    // =========================================================================
    // WEEK 8: Recursive Grid Inspection
    // =========================================================================
    private static void runRecursiveInspection() {
        boolean[] occupancyArray = new boolean[VALID_CELLS.size()];
        for (int i = 0; i < VALID_CELLS.size(); i++) {
            occupancyArray[i] = activeAllocations.containsKey(VALID_CELLS.get(i));
        }

        int inspectedCount = countInspectedRecursively(occupancyArray, 0);
        int freeCount = countFreeRecursively(occupancyArray, 0);
        int occupiedCount = occupancyArray.length - freeCount;

        System.out.println("\n--- RECURSIVE GRID INSPECTION RESULT ---");
        System.out.println("Total Cells Inspected: " + inspectedCount);
        System.out.println("Occupied Cells: " + occupiedCount);
        System.out.println("Free Cells: " + freeCount);
    }

    private static int countInspectedRecursively(boolean[] arr, int index) {
        if (index == arr.length) return 0;
        return 1 + countInspectedRecursively(arr, index + 1);
    }

    private static int countFreeRecursively(boolean[] arr, int index) {
        if (index == arr.length) return 0;
        return (arr[index] ? 0 : 1) + countFreeRecursively(arr, index + 1);
    }

    // =========================================================================
    // WEEK 12: Stream API Grouping & Final Analytics
    // =========================================================================
    private static void generateFinalReport() {
        System.out.println("\n==================================================");
        System.out.println("          SYSTEM SUMMARY REPORT (STREAMS)         ");
        System.out.println("==================================================");
        System.out.println("Active Allocations Count : " + activeAllocations.size());
        System.out.println("Free Cells Count         : " + (VALID_CELLS.size() - activeAllocations.size()));

        Map<String, Long> gridUsage = activeAllocations.values().stream()
                .collect(Collectors.groupingBy(Allocation::getGrid, LinkedHashMap::new, Collectors.counting()));

        System.out.println("\nGrid Usage Distribution:");
        System.out.println(" GRID-A Usage: " + gridUsage.getOrDefault("GRID-A", 0L));
        System.out.println(" GRID-B Usage: " + gridUsage.getOrDefault("GRID-B", 0L));
        System.out.println("==================================================");
    }

    // =========================================================================
    // WEEK 11: File I/O & CSV Persistence
    // =========================================================================
    private static void saveStateToCSV() {
        try {
            List<String> lines = new ArrayList<>();
            lines.add("token,cell,grid");

            for (Allocation alloc : activeAllocations.values()) {
                lines.add(alloc.getToken() + "," + alloc.getCell() + "," + alloc.getGrid());
            }

            Files.write(Path.of(CSV_FILE_PATH), lines, StandardCharsets.UTF_8);
            System.out.println("\n[PERSISTENCE] State saved successfully to " + CSV_FILE_PATH);
        } catch (IOException e) {
            System.out.println("[ERROR] Failed to save state to file: " + e.getMessage());
        }
    }

    private static void loadStateFromCSV() {
        Path path = Path.of(CSV_FILE_PATH);
        if (!Files.exists(path)) return;

        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            if (lines.size() <= 1) return; // Only header present

            for (int i = 1; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");
                if (parts.length == 3) {
                    Allocation alloc = new Allocation(parts[0], parts[1], parts[2]);
                    activeAllocations.put(parts[1], alloc);
                }
            }
            System.out.println("[PERSISTENCE] Restored " + activeAllocations.size() + " active allocation(s) from " + CSV_FILE_PATH);
        } catch (IOException e) {
            System.out.println("[WARN] Could not read existing state file: " + e.getMessage());
        }
    }

    // =========================================================================
    // Validation Helpers & Exceptions (Week 2 & 10)
    // =========================================================================
    private static void validateToken(String token) throws InvalidSimulatorCommandException {
        if (token == null || !token.matches("[A-Z]+-\\d{2}")) {
            throw new InvalidSimulatorCommandException("Invalid token format! Must match pattern like ORBIT-07 or NOVA-12.");
        }
    }

    private static void validateCell(String cell) throws InvalidSimulatorCommandException {
        if (!VALID_CELLS.contains(cell)) {
            throw new InvalidSimulatorCommandException("Invalid cell label! Must be one of: " + VALID_CELLS);
        }
    }

    static class InvalidSimulatorCommandException extends Exception {
        InvalidSimulatorCommandException(String message) {
            super(message);
        }
    }

    // =========================================================================
    // Domain Model Class (Week 9)
    // =========================================================================
    static class Allocation {
        private final String token;
        private final String cell;
        private final String grid;

        public Allocation(String token, String cell, String grid) {
            this.token = token;
            this.cell = cell;
            this.grid = grid;
        }

        public String getToken() { return token; }
        public String getCell() { return cell; }
        public String getGrid() { return grid; }

        @Override
        public String toString() {
            return String.format("Allocation{token='%s', cell='%s', grid='%s'}", token, cell, grid);
        }
    }
}