import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/swastikdb?useSSL=false", "root", "");
            String sql = "insert into tblstudent (Id, Name, Gender, Address) values (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            for (int i=1; i<=5; i++) {
                System.out.println("Student " + i + ":");
                System.out.print("Enter id: ");
                String id = sc.nextLine();
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter gender: ");
                
                String gender = sc.nextLine();
                System.out.print("Enter address: ");
                String address = sc.nextLine();
                ps.setString(1, id);
                ps.setString(2, name);
                ps.setString(3, gender);
                ps.setString(4, address);
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
            sc.close();
            con.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
