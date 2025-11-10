import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swastikdb?useSSL=false", "root", "");
            String createTable = "CREATE TABLE IF NOT EXISTS tableStudent (" + "id INT PRIMARY KEY, " + "name VARCHAR(50), " + "email VARCHAR(50))";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(createTable);
            System.out.println("Table 'tableStudent' created if not already exists.");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Student Details");
            System.out.print("Enter id: ");
            String id = sc.nextLine();
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter email: ");
            String email = sc.nextLine();
            String insertSql = "INSERT INTO tableStudent (id, name, email) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insertSql);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.executeUpdate();
            System.out.println("Record inserted successfully");
            ResultSet rs = stmt.executeQuery("SELECT * FROM tableStudent");
            System.out.println("ID\tName\t\tEmail");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("email"));
            }
            con.close();
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
