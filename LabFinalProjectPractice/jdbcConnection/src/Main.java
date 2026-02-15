import java.sql.*;
import java.util.Scanner;

public class Main {

    static final String URL = "jdbc:mysql://localhost:3306/students";
    static final String USER = "root";
    static final String PASS = "173506";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Scanner sc = new Scanner(System.in)) {

            while (true) {
                System.out.println("\n==== STUDENT CRUD MENU ====");
                System.out.println("1. Insert");
                System.out.println("2. View All");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("0. Exit");
                System.out.print("Choose: ");

                int choice;
                try {
                    choice = Integer.parseInt(sc.nextLine().trim());
                } catch (Exception e) {
                    System.out.println("Invalid input! Enter a number.");
                    continue;
                }

                switch (choice) {
                    case 1 -> insertStudent(conn, sc);
                    case 2 -> viewStudents(conn);
                    case 3 -> updateStudent(conn, sc);
                    case 4 -> deleteStudent(conn, sc);
                    case 0 -> {
                        System.out.println("Bye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // INSERT
    static void insertStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }

        String sql = "INSERT INTO students(name) VALUES (?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Inserted successfully!" : "Insert failed!");
        }
    }

    // VIEW
    static void viewStudents(Connection conn) throws SQLException {
        String sql = "SELECT id, name FROM students ORDER BY id";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- Records ---");
            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println("ID: " + rs.getInt("id") + " | Name: " + rs.getString("name"));
            }

            if (!found) System.out.println("No records found.");
        }
    }

    // UPDATE
    static void updateStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter ID to update: ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Invalid ID!");
            return;
        }

        System.out.print("Enter new name: ");
        String newName = sc.nextLine().trim();

        if (newName.isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }

        String sql = "UPDATE students SET name=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, newName);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Updated successfully!" : "ID not found!");
        }
    }

    // DELETE
    static void deleteStudent(Connection conn, Scanner sc) throws SQLException {
        System.out.print("Enter ID to delete: ");
        int id;
        try {
            id = Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Invalid ID!");
            return;
        }

        String sql = "DELETE FROM students WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Deleted successfully!" : "ID not found!");
        }
    }
}
