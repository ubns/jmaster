package sht.practice.chapter5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>aaa</title></head><body>");
		HttpSession session = request.getSession(false);
		
		Book book = new Book();
		book.setTitle(request.getParameter("title"));
		book.setPrice((Integer.parseInt(request.getParameter("price"))));
		
		@SuppressWarnings("unchecked")
		ArrayList<Book> cart = (ArrayList<Book>) session.getAttribute("cart");
		
		if (cart == null) {
			cart = new ArrayList<Book>();
			session.setAttribute("cart", cart);
		}
		
		cart.add(book);
		
		// カートに追加したBook一覧
		out.println("Book一覧<br>");
		for (Book b : cart) {
			out.println(b.getTitle() + b.getPrice() + "<br>");
		}
		
		out.println("<a href='AuthServlet'>戻る</a>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
