/** Week 10: translate invalid fictional simulator commands into exceptions. */
public class ParkingWeek10 {
    public static void main(String[] args) {
        try {
            validateCommand("ALLOCATE ORBIT-07 A-02");
            System.out.println("Accepted command: ALLOCATE ORBIT-07 A-02");
        } catch (InvalidSimulatorCommandException exception) {
            throw new IllegalStateException(exception);
        }
        try {
            validateGrid("GRID-X");
        } catch (InvalidSimulatorCommandException exception) {
            System.out.println("Rejected command: " + exception.getMessage());
        }
        try {
            validateToken("");
        } catch (InvalidSimulatorCommandException exception) {
            System.out.println("Rejected command: " + exception.getMessage());
        }
    }

    static void validateCommand(String command) throws InvalidSimulatorCommandException {
        if (!command.equals("ALLOCATE ORBIT-07 A-02")) {
            throw new InvalidSimulatorCommandException("Unsupported command.");
        }
    }

    static void validateGrid(String grid) throws InvalidSimulatorCommandException {
        if (!grid.equals("GRID-A") && !grid.equals("GRID-B")) {
            throw new InvalidSimulatorCommandException("Unknown grid label.");
        }
    }

    static void validateToken(String token) throws InvalidSimulatorCommandException {
        if (token.isBlank()) {
            throw new InvalidSimulatorCommandException("Token is blank.");
        }
    }

    static class InvalidSimulatorCommandException extends Exception {
        InvalidSimulatorCommandException(String message) {
            super(message);
        }
    }
}
