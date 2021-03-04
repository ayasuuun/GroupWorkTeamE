package poly.sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateSample5 {

    public static void main(String[] args) throws SQLException {

        Connection con = DBManager.getConnection();
        PreparedStatement st = con.prepareStatement("insert into product values(?, ?, ?)");

        st.setInt(1,  30);
        st.setString(2, "特選貝柱");
        st.setInt(3, 200);

        con.setAutoCommit(false);

        st.executeUpdate();

        con.commit();

        System.out.println("終了");

        st.close();
        con.close();
    }

}
