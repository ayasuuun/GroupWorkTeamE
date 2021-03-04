package poly.enshu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import poly.sample.DBManager;

public class SelectOver5000 {

    public static void main(String args[]) throws SQLException {

        double tax = 0;
        String result = "";
        String taxResult = "";

        Connection con = DBManager.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT name, price FROM product2 WHERE price >= 5000");

        while (rs.next()) {
            int price = rs.getInt("price");
            tax = Math.floor(price / 10);

            taxResult = String.format("%,d", (int) Math.floor(price / 10));
            result = String.format("%,d", (int) Math.floor(price + tax));

            System.out.println(
                    rs.getString("name") + "：" + price + "円(消費税：" + taxResult + "円) " + " 税込み：" + result + "円");
        }

        st.close();
        con.close();
    }

}
