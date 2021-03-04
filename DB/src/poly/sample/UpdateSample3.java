package poly.sample;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateSample3 {
    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;

        try {
            con = DBManager.getConnection();
            st = con.createStatement();
            int count = st.executeUpdate("insert into product values(20, 'プリン', 100)");
            System.out.println("update count:" + count);

        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            if (st != null) {
                try {
                    st.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        if (con != null) {
            try {
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}