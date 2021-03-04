package poly.sample;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateSample {
    public static void main(String[] args) throws SQLException {
        Connection con = DBManager.getConnection();

        Statement st = con.createStatement();

        int count = st.executeUpdate("insert into product values(20, 'プリン', 100)");

        System.out.println("update count:" + count);
        st.close();
        con.close();
    }

}
