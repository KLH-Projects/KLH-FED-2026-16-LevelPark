/** Week 5: use methods to allocate, release, and inspect a fictional grid. */
public class ParkingWeek05 {
    public static void main(String[] args) {
        int freeSlots = 6;
        boolean allocated = allocate("PIXEL-04", "A-04");
        if (allocated) {
            freeSlots--;
        }
        boolean released = release("A-04");
        if (released) {
            freeSlots++;
        }
        System.out.println("freeSlots() -> " + freeSlots);
    }

    static boolean allocate(String token, String cell) {
        System.out.println("allocate(" + token + ", " + cell + ") -> success");
        return true;
    }

    static boolean release(String cell) {
        System.out.println("release(" + cell + ") -> success");
        return true;
    }
}
