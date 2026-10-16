/** Week 2: validate fixed fictitious allocation tokens and grid labels. */
public class ParkingWeek02 {
    public static void main(String[] args) {
        String token = "ORBIT-07";
        String grid = "GRID-A";
        if (isValidToken(token)) {
            System.out.println("Token " + token + " accepted.");
        }
        if (grid.equals("GRID-A")) {
            System.out.println("Grid label " + grid + " accepted.");
        }
        System.out.println("Request ready.");
    }

    static boolean isValidToken(String token) {
        return token.matches("[A-Z]+-\\d{2}");
    }
}
