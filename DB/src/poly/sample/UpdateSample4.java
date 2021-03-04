package poly.sample;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateSample4 {
    public static void main(String[] args) {

        try (
                Connection con = DBManager.getConnection();
                Statement st = con.createStatement()) {

            int count = st.executeUpdate("insert into product values(20, 'プリン', 100)");
            System.out.println("update count:" + count);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
