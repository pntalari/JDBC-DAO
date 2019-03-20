import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppRunner {

    static String myURL = "jdbc:mysql://localhost:3306/JDBCDAO";
    static String myUSER = "root";
    static String myPASS = "";

//    public static Connection getConnection() {
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(myURL, myUSER, myPASS);
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return conn;
//    }

    public static void main(String... args) throws SQLException {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(myURL, myUSER, myPASS);

            System.out.println("Connection Established to MySQL Database!");

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }
        finally {
            conn.close();
        }

    }
}
