package poly.sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectSample2 {

    public static void main(String[] args) throws SQLException, InterruptedException {

        Connection con = DBManager.getConnection();
        PreparedStatement st = con.prepareStatement("SELECT * FROM product WHERE price = ? AND name LIKE ?");

        st.setInt(1,  100);
        st.setString(2, "%" + "貝" + "%");

        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getInt("id") + "," + rs.getString("name"));
        }

        st.close();
        con.close();
    }

}
