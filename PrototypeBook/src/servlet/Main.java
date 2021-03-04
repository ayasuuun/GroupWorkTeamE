package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import model.Book;

@WebServlet("/Main")
public class Main extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String check = request.getParameter("check");
        String forwardPath = null;

        switch (check) {
        case "1":
            forwardPath="/WEB-INF/jsp/search.jsp";
            break;

        case "2":
        	List<Book> bookList = new ArrayList<>();
        	BookDAO bookDAO = new BookDAO();
        	bookList = bookDAO.findAll();
        	request.setAttribute("bookList", bookList);
            forwardPath="/WEB-INF/jsp/delete.jsp";
            break;

        case "3":

            forwardPath="/WEB-INF/jsp/add.jsp";
            break;

        case "4":
            forwardPath="/WEB-INF/jsp/update.jsp";
            break;

        }
        request.getRequestDispatcher(forwardPath).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String keyword = request.getParameter("keyword");


        List<Book> bookList = new ArrayList<>();
        BookDAO bookDAO = new BookDAO();
        bookList = bookDAO.searchBook(keyword);
        request.setAttribute("bookList", bookList);
        request.getRequestDispatcher("/WEB-INF/jsp/searchResult.jsp").forward(request, response);
    }
}
