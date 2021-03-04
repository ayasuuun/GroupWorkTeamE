package poly.enshu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import poly.sample.DBManager;

public class DeleteDataById {

    public static void main(String[] args) {

        String id = "S";
        int input = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("削除する商品番号（数字4桁）を入力してください：S");

        input = scanner.nextInt();
        id += String.valueOf((String.format("%04d", input)));

        try (Connection con = DBManager.getConnection(); Statement st = con.createStatement()) {

            int count = st.executeUpdate("DELETE FROM product2 WHERE id=\'" + id + "\'");
            System.out.println("update count:" + count);
            System.out.println(id);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
