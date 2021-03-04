package poly.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    public static Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/training";
        String user = "user18";
        String pass = "user18pass";

        try {
            Connection con = DriverManager.getConnection(url, user, pass);

            return con;

        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection con = getConnection();
        System.out.println("con=" + con);
        con.close();
    }

}
