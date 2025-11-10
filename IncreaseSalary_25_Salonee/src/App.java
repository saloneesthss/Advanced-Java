import java.sql.*;

public class App {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swastikdb?useSSL=false", "root", "");
            String sql = "UPDATE tblstudent SET Salary = Salary + (Salary * 0.15) WHERE Salary < 20000";
            PreparedStatement ps = con.prepareStatement(sql);
            int rowsUpdated = ps.executeUpdate();
            System.out.println("Salary updated successfully for " + rowsUpdated + " student(s).");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tblstudent ORDER BY Salary ASC");
            System.out.println("ID\tName\tSalary\tGender");
            System.out.println("------------------------------------------");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("Id") + "\t" +
                    rs.getString("Name") + "\t" +
                    rs.getDouble("Salary") + "\t" +
                    rs.getString("Gender")
                );
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
