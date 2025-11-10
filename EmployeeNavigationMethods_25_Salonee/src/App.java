import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swastikdb?useSSL=false", "root", "");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery("SELECT * FROM emp");
            if (rs.first()) {
                System.out.println("First Record: ");
                printEmployees(rs);
            }
            if (rs.next()) {
                System.out.println("Next Record: ");
                printEmployees(rs);
            }
            if (rs.last()) {
                System.out.println("Last Record: ");
                printEmployees(rs);
            }
            if (rs.previous()) {
                System.out.println("Previous Record: ");
                printEmployees(rs);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private static void printEmployees(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String email = rs.getString("email");
        String address = rs.getString("address");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
    }
}
