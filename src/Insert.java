import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {
    public static void main ( String[] args ) {
        Scanner sc = new Scanner (System.in);
        Insert insert = new Insert ();

            String name = sc.nextLine();
            String email = sc.nextLine ();
            String date1 = sc.nextLine ();
            Date date = Date.valueOf (date1);
            insert.createRegistration (name, email, date);

        sc.close ();
    }
    public void createRegistration(String name, String email, Date dateOfBirth) {
        String query = "INSERT INTO Registration (Name, Email, DateOfBirth) VALUES (?, ?, ?)";

        try (Connection conn = Connection1.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setDate(3, dateOfBirth);
            pstmt.executeUpdate();
            System.out.println("Registration created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
