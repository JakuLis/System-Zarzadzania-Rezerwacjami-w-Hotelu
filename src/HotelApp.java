import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HotelApp {

    public static void addRoom(int roomNumber, String roomType, double pricePerNight) {
        String sql = "INSERT INTO rooms (room_number, room_type, price_per_night) VALUES (?, ?, ?)";
        try (Connection conn = HotelDatabase.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, roomNumber);
            pstmt.setString(2, roomType);
            pstmt.setDouble(3, pricePerNight);
            pstmt.executeUpdate();
            System.out.println("Dodano pokój: " + roomNumber);
        } catch (SQLException e) {
            System.out.println("Błąd dodawania pokoju: " + e.getMessage());
        }
    }

    public static void addCustomer(String firstName, String lastName, String email, String phone) {
        String sql = "INSERT INTO customers (first_name, last_name, email, phone) VALUES (?, ?, ?, ?)";
        try (Connection conn = HotelDatabase.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setString(3, email);
            pstmt.setString(4, phone);
            pstmt.executeUpdate();
            System.out.println("Dodano klienta: " + firstName + " " + lastName);
        } catch (SQLException e) {
            System.out.println("Błąd dodawania klienta: " + e.getMessage());
        }
    }

    public static void displayRooms() {
        String sql = "SELECT * FROM rooms";
        try (Connection conn = HotelDatabase.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            System.out.println("Lista pokoi:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Numer pokoju: " + rs.getInt("room_number") +
                        ", Typ: " + rs.getString("room_type") +
                        ", Cena za noc: " + rs.getDouble("price_per_night"));
            }
        } catch (SQLException e) {
            System.out.println("Błąd wyświetlania pokoi: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        HotelDatabase.initializeDatabase();

        addRoom(101, "Single", 200.0);
        addRoom(102, "Double", 350.0);
        addCustomer("John", "Doe", "john.doe@example.com", "123456789");
        addCustomer("Jane", "Smith", "jane.smith@example.com", "987654321");
        displayRooms();
    }
}
