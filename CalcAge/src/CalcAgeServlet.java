
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalcAgeServlet")
public class CalcAgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String bornYearStr = request.getParameter("year");

		int bornYear = Integer.parseInt(bornYearStr);

		LocalDateTime ldt = LocalDateTime.now();
        int nowYear = ldt.getYear();

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>CalcAge</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>ユーザの年齢を求める（入力フォーム編）</h2>");
        out.println("<table border=\"2\">");
        out.println("<tr>");
        out.println("<th>ユーザの名前</th>");
        out.println("<th>ユーザの生まれた年</th>");
        out.println("<th>現在の年</th>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<th>"+name+"</th>");
        out.println("<th>"+bornYear+"</th>");
        out.println("<th>"+nowYear+"</th>");
        out.println("</tr>");
        out.println("</table>");
        out.println("<hr>");
        out.println("<p>" + name + " の年齢は" + (nowYear - bornYear) + " 歳です</p>");
        out.println("</body>");
        out.println("</html>");
	}
}
