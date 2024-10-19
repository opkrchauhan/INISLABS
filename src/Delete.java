import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
    public static void main ( String[] args ) {
        Scanner sc = new Scanner (System.in);
        Delete delete = new Delete ();
        int id = sc.nextInt ();
        delete.deleteRegistration (id);

    }
    public void deleteRegistration(int id) {
        String query = "DELETE FROM Registration WHERE ID = ?";

        try (Connection conn = Connection1.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Registration deleted successfully.");
            } else {
                System.out.println("No registration found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
