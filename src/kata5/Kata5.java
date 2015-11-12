package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Kata5 {

    public static void main(String[] args) {
        try {
            //Class.forName("org.sqlite.JDBC");
            //Connection c = DriverManager.getConnection("jdbc:sqlite:KATADB");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@10.22.143.90:1521:orcl","system","orcl");
            
            System.out.println("Opened database successfully");

            Statement stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM PEOPLE");
            while (rs.next()) {
                System.out.println("ID = " + rs.getInt("ID"));
                System.out.println("NAME = " + rs.getString("NAME"));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
