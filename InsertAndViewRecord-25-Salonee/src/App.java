import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swastikdb?useSSL=false", "root", "");
            String sql = "insert into tblstudent (Id, Name, Gender, Address) values (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            String[][] students = {
                {"1", "Salonee", "Female", "Thimi"},
                {"2", "Simran", "Female", "Baneshwor"},
                {"3", "Seokjin", "Male", "Bhaktapur"},
                {"4", "Krisha", "Female", "Lalitpur"},
                {"5", "Lalit", "Male", "Kathmandu"}
            };
            for (String[] student : students) {
                ps.setString(1, student[0]);
                ps.setString(2, student[1]);
                ps.setString(3, student[2]);
                ps.setString(4, student[3]);
                ps.executeUpdate();
            }
            System.out.println("Records inserted successfully.");

            String selectSql = "select * from tblstudent order by Name asc";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(selectSql);
            System.out.println("ID\tName\tGender\tAddress");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("Id") + "\t" +
                    rs.getString("Name") + "\t" +
                    rs.getString("Gender") + "\t" +
                    rs.getString("Address")
                );
            }
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
