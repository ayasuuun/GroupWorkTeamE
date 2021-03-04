
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalcUserAge")
public class CalcUserAge extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Calendar calendar = Calendar.getInstance();
        int nowYear = calendar.get(Calendar.YEAR);

        /* 現在はLocalDateTimeのほうが主流なのでこちらの方がいい
         * LocalDateTime ldt = LocalDateTime.now();
         * int nowYear = ldf.getYear();
         */

        String userName = "politech";
        int userYear = 1995;

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>CalcAge</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>ユーザの年齢を求める（変数代入編）</h1>");
        out.println("<table border=\"2\">");
        out.println("<tr>");
        out.println("<th>ユーザの名前</th>");
        out.println("<th>ユーザの生まれた年</th>");
        out.println("<th>現在の年</th>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<th>"+userName+"</th>");
        out.println("<th>"+userYear+"</th>");
        out.println("<th>"+nowYear+"</th>");
        out.println("</tr>");
        out.println("</table>");
        out.println("<p>" + userName + " の年齢は" + (nowYear - userYear) + " 歳です</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
