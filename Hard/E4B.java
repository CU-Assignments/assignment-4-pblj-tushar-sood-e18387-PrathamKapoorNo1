import java.util.*;

class TicketBookingSystem {
    private final Set<Integer> bookedSeats = new HashSet<>();

    public synchronized boolean bookSeat(int seatNumber) {
        if (bookedSeats.contains(seatNumber)) {
            return false;
        } else {
            bookedSeats.add(seatNumber);
            return true;
        }
    }
}

class BookingThread extends Thread {
    private final TicketBookingSystem system;
    private final int seatNumber;

    public BookingThread(TicketBookingSystem system, int seatNumber, int priority) {
        this.system = system;
        this.seatNumber = seatNumber;
        setPriority(priority);
    }

    @Override
    public void run() {
        synchronized (system) {
            if (system.bookSeat(seatNumber)) {
                System.out.println("Booking Successful! Seat Number :- " + seatNumber);
            } else {
                System.out.println("Booking Failed! Seat Already Booked :- " + seatNumber);
            }
        }
    }
}

public class E4B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketBookingSystem system = new TicketBookingSystem();

        System.out.print("Enter the Number of Bookings :- ");
        int numBookings = scanner.nextInt();

        for (int i = 0; i < numBookings; i++) {
            System.out.print("Enter Seat Number to Book :- ");
            int seatNumber = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter Booking Type (VIP/Regular) :- ");
            String type = scanner.nextLine();

            int priority = type.equalsIgnoreCase("VIP") ? Thread.MAX_PRIORITY : Thread.NORM_PRIORITY;
            BookingThread booking = new BookingThread(system, seatNumber, priority);
            booking.start();

            try {
                booking.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}