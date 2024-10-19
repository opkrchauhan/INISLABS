import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {
    public static void main ( String[] args ) {
        Scanner sc = new Scanner (System.in);
        Update update = new Update ();
        int id = sc.nextInt ();
        sc.nextLine ();
        String name = sc.nextLine ();
        String email = sc.nextLine ();
        String date1 = sc.nextLine ();
        Date date = Date.valueOf (date1);
        update.updateRegistration (id,name, email, date);
        sc.close ();
    }
    public void updateRegistration(int id, String name, String email, Date dateOfBirth) {
        String query = "UPDATE Registration SET Name = ?, Email = ?, DateOfBirth = ? WHERE ID = ?";

        try (Connection conn = Connection1.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setDate(3, dateOfBirth);
            pstmt.setInt(4, id);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Registration updated successfully.");
            } else {
                System.out.println("No registration found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
