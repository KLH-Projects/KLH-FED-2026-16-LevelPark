/** Week 9: model a fictional token, cell, and allocation with objects. */
public class ParkingWeek09 {
    public static void main(String[] args) {
        TrainingToken token = new TrainingToken("NOVA-12");
        GridCell cell = new GridCell("B-01", true);
        Allocation allocation = new Allocation(token.getValue(), cell.getLabel(), "ACTIVE");

        System.out.println(allocation);
        System.out.println("GridCell " + cell.getLabel() + " is " + (cell.isOccupied() ? "occupied." : "free."));
    }

    static class TrainingToken {
        private final String value;

        TrainingToken(String value) {
            this.value = value;
        }

        String getValue() {
            return value;
        }
    }

    static class GridCell {
        private final String label;
        private final boolean occupied;

        GridCell(String label, boolean occupied) {
            this.label = label;
            this.occupied = occupied;
        }

        String getLabel() {
            return label;
        }

        boolean isOccupied() {
            return occupied;
        }
    }

    static class Allocation {
        private final String token;
        private final String cell;
        private final String status;

        Allocation(String token, String cell, String status) {
            this.token = token;
            this.cell = cell;
            this.status = status;
        }

        @Override
        public String toString() {
            return String.format("Allocation{token='%s', cell='%s', status='%s'}", token, cell, status);
        }
    }
}
