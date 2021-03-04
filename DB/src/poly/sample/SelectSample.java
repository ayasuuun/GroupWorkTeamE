package poly.sample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectSample {

    public static void main(String args[]) throws SQLException {

        Connection con = DBManager.getConnection();

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("select * from product");

        while (rs.next()) {
            System.out.println(rs.getInt("id") + "," + rs.getString("name"));
        }

        st.close();
        con.close();
    }

}
