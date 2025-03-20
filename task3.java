import java.util.*;

class Room {
    int roomNumber;
    String category;
    boolean isBooked;

    Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
    }
}

class Hotel {
    List<Room> rooms = new ArrayList<>();
    Map<Integer, String> reservations = new HashMap<>();

    Hotel() {
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(103, "Suite"));
    }

    void showAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (!room.isBooked) {
                System.out.println("Room " + room.roomNumber + " - " + room.category);
            }
        }
    }

    void bookRoom(int roomNumber, String guestName) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && !room.isBooked) {
                room.isBooked = true;
                reservations.put(roomNumber, guestName);
                System.out.println("Room " + roomNumber + " booked for " + guestName);
                return;
            }
        }
        System.out.println("Room not available.");
    }

    void viewBookings() {
        System.out.println("Bookings:");
        for (Map.Entry<Integer, String> entry : reservations.entrySet()) {
            System.out.println("Room " + entry.getKey() + " - Booked by " + entry.getValue());
        }
    }
}
 class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            System.out.println("1. View Available Rooms  2. Book Room  3. View Bookings  4. Exit");
            int choice = scanner.nextInt();
            if (choice == 4) 
                 break;

            if (choice == 1) {
               hotel.showAvailableRooms();
             }
            else if (choice == 2) {
                System.out.print("Enter room number: ");
                int roomNumber = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter your name: ");
                String guestName = scanner.nextLine();
                hotel.bookRoom(roomNumber, guestName);
            } else if (choice == 3){
                  hotel.viewBookings();
             }
        }
        scanner.close();
    }
}