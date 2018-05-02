package sht.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USER = "jack";
	private static final String PASS = "abc";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// actionリクエストパラメータの読み込み
		String action = request.getParameter("action");
		if (action.equals("login")) {  // ログイン時
			// ユーザ名とパスワードを取得
			String name = request.getParameter("name");
			String password = request.getParameter("pw");
			
			// ユーザ名とパスワードが一致した場合
			if (name.equals(USER) && password.equals(PASS)) {
				// セッション情報の生成
				HttpSession session = request.getSession();
				// ログイン済みの属性を設定
				session.setAttribute("isLogin", "true");
				out.println("<html><head><title>ShowCart</title></head></html>");
				out.println("<h1>ログイン成功</h1>");
			} else {
				out.println("<html><head><title>ShowCart</title></head></html>");
				out.println("<h1>ユーザ名またはパスワードが違います</h1>");
			}
		} else if (action.equals("logout")) {  // ログアウト時
			// すでに作成されているセッション領域を取得する
			HttpSession session = request.getSession();
			if (session != null) {
				// セッション領域を破棄する
				session.invalidate();
				out.println("<html><head><title>ShowCart</title></head></html>");
				out.println("<h1>ログアウトしました</h1>");
			}
		}
		out.println("<a href='/jmaster/selectProduct.html'>戻る</a>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
