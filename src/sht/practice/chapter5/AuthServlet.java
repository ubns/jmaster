package sht.practice.chapter5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String NAME = "user";
	private static final String PASS = "pass";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>Auth Page</title></head><body>");
		out.println("<a href='/jmaster/cart?title=本1&price=200'>本1</a>" );
		
		// 画面ID取得
		String pageId = request.getParameter("pageId");
		
		if (pageId.equals("1")) {
			// ユーザ名・パスワードを取得
			String name = request.getParameter("name");
			String pass = request.getParameter("pass");
			
			// ユーザ名とパスワードがあっているか確認
			if (name.equals(NAME) && pass.equals(PASS)) {
				HttpSession session = request.getSession();
				session.setAttribute("name", name);
				out.println("こんにちは" + name + "さん<br><br>");
				out.println("<a href='/jmaster/BookServlet'>本を追加する</a>");
			} else {
				out.println("ユーザ名またはパスワードが間違っています。");
			}
		}
		
		out.println("<form action='/jmaster/AuthServlet' method='get'> ");
		
		out.println("<input type='submit' value='ログアウト'>");
		out.println("</form><br><br>");
		out.println("</body></html>");
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

}
