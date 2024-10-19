import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import  java.util.*;
public class Read {

    public static void main ( String[] args ) {
        Read read = new Read ();
        Scanner sc = new Scanner (System.in);
        int id = sc.nextInt();
        read.readRegistration (id);
        System.out.println ("Data Read Done");
        sc.close();
    }
    public void readRegistration(int id) {
        String query = "SELECT * FROM Registration WHERE ID = ?";

        try (Connection conn = Connection1.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("ID"));
                System.out.println("Name: " + rs.getString("Name"));
                System.out.println("Email: " + rs.getString("Email"));
                System.out.println("Date of Birth: " + rs.getDate("DateOfBirth"));
            } else {
                System.out.println("No registration found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
