import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HotelDatabase {
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/hotel";
    private static final String DB_USER = "root"; // Zmień na swoją nazwę użytkownika
    private static final String DB_PASSWORD = "admin"; // Zmień na swoje hasło

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Połączono z bazą MySQL.");
        } catch (SQLException e) {
            System.out.println("Błąd połączenia z bazą: " + e.getMessage());
        }
        return conn;
    }

    public static void initializeDatabase() {
        String createRoomsTable = """
                CREATE TABLE IF NOT EXISTS rooms (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    room_number INT NOT NULL UNIQUE,
                    room_type VARCHAR(50) NOT NULL,
                    price_per_night DOUBLE NOT NULL
                );
                """;

        String createCustomersTable = """
                CREATE TABLE IF NOT EXISTS customers (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    first_name VARCHAR(50) NOT NULL,
                    last_name VARCHAR(50) NOT NULL,
                    email VARCHAR(100) NOT NULL UNIQUE,
                    phone VARCHAR(15) NOT NULL
                );
                """;

        String createReservationsTable = """
                CREATE TABLE IF NOT EXISTS reservations (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    room_id INT NOT NULL,
                    customer_id INT NOT NULL,
                    days INT NOT NULL,
                    total_price DOUBLE NOT NULL,
                    FOREIGN KEY (room_id) REFERENCES rooms(id),
                    FOREIGN KEY (customer_id) REFERENCES customers(id)
                );
                """;

        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(createRoomsTable);
            stmt.execute(createCustomersTable);
            stmt.execute(createReservationsTable);
            System.out.println("Tabele zostały pomyślnie utworzone w bazie danych!");
        } catch (SQLException e) {
            System.out.println("Błąd tworzenia tabel: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        initializeDatabase();
    }
}