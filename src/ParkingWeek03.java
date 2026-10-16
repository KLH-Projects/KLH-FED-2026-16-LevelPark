/** Week 3: allocate a fixed fictional token to a fixed grid cell. */
public class ParkingWeek03 {
    public static void main(String[] args) {
        String token = "ORBIT-07";
        String cell = "A-02";
        int freeSlots = 6;
        boolean cellAvailable = true;

        System.out.println("Request: " + token + " -> " + cell);
        if (cellAvailable) {
            freeSlots--;
            System.out.println("Decision: ALLOCATED");
        } else {
            System.out.println("Decision: REJECTED");
        }
        System.out.println("Remaining slots: " + freeSlots);
    }
}
