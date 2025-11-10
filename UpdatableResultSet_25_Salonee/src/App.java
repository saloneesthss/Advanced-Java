import java.util.Scanner;
import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swastikdb?useSSL=false", "root" ,"");
            System.out.println("Enter Employee ID to search: ");
            Scanner sc = new Scanner(System.in);
            int empId = sc.nextInt();
            String sql = "SELECT * FROM emp WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Current Employee Details");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Address: " + rs.getString("address"));
                System.out.println("Enter new name for this employee: ");
                String newName = sc.nextLine();
                rs.updateString("name", newName);
                rs.updateRow();
                System.out.println("Employee name updated successfully.");
            } else {
                System.out.println("No employee found with ID " + empId);
            }
            sc.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
