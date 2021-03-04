package poly.enshu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import poly.sample.DBManager;

public class InsertDataPlaceholder {

    public static void main(String[] args) throws SQLException {

        int price = 0;
        int fullPrice = 0;
        double tax = 1.1;
        String id = "S";
        String name = "";

        Scanner scanner = new Scanner(System.in);

        System.out.print("商品番号(数字4桁):");
        id += (String.format("%04d", Integer.parseInt(scanner.nextLine())));

        Connection con = DBManager.getConnection();
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM product2_enshu");

        while (rs.next()) {
            while (rs.getString("id").equals(id) || 5 < id.length()) {
                if ((rs.getString("id").equals(id))) {
                    System.out.println("すでに存在している商品番号です。別の値を入力してください");
                    System.out.print("商品番号(数字4桁):");
                    id = "S" + (String.format("%04d", Integer.parseInt(scanner.nextLine())));
                } else if (5 < id.length()) {
                    System.out.println("4桁の数字でなければいけません。再度入力してください");
                    System.out.print("商品番号(数字4桁):");
                    id = "S" + (String.format("%04d", Integer.parseInt(scanner.nextLine())));
                }
            }
        }

        System.out.print("商品名:");
        name = scanner.nextLine();

        System.out.print("税抜き価格:");
        price = scanner.nextInt();

        while (price < 0) {
            System.out.println("0円未満の商品は登録できません。再度入力してください");
            System.out.print("税抜き価格:");
            price = scanner.nextInt();
        }

        fullPrice = (int) (price * tax);

        PreparedStatement pst = con.prepareStatement("insert into product2_enshu values(?, ?, ?, ?)");

        pst.setString(1, id);
        pst.setString(2, name);
        pst.setInt(3, price);
        pst.setInt(4, fullPrice);

        con.setAutoCommit(false);
        pst.executeUpdate();
        con.commit();
        System.out.println("項目を追加しました");

        st.close();
        con.close();
    }

}
