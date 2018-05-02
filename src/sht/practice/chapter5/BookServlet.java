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

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		out.println("<html><head><title>Auth Page</title></head><body>");
		String name = "";
		
		if (session != null) {
			name = (String) session.getAttribute("name");
			
			out.println("こんにちは" + name + "さん<br><br>");
			out.println("<form action='/jmaster/BookServlet' method='post'>");
			out.println("タイトル：<input type='text' name='title'><br>");
			out.println("価格：<input type='text' name='price'><br>");
			out.println("<input type='submit' value='登録'>");
			out.println("</form>");
			
			out.println("<hr>");
			out.println("Book一覧");
			
			@SuppressWarnings("unchecked")
			ArrayList<Book> booklist = (ArrayList<Book>) session.getAttribute("booklist");
			if (booklist == null) {
				booklist = new ArrayList<Book>();
				session.setAttribute("booklist", booklist);
			}
			
			// 商品の追加
			Book book = (Book) session.getAttribute("books");
			if (book != null) {
				booklist.add(book);
			}
			
			// クライアントごとのカート情報の表示
			out.println("<html><head><title>ShowCart</title></head></html>");
			out.println("現在のカートの中身は下記の通りです。<br><br>");
			for (int i = 0; i < booklist.size(); i++) {
				out.println(i + 1); // 商品点数
				out.println(":" + booklist.get(i).getTitle() + " - " + booklist.get(i).getPrice() + "円<br>");  // 商品名
			}
		}
		out.println("<a href='AuthServlet'>管理者トップへ戻る</a>");
		out.println("<a href='/jmaster/chapter5/index.html'>トップページへ戻る</a>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		String title = request.getParameter("title");
		String Strprice = request.getParameter("price");
		int price = Integer.parseInt(Strprice);
		Book book = new Book();
		book.setTitle(title);
		book.setPrice(price);
		session.setAttribute("books", book);
		doGet(request,response);
	}

}