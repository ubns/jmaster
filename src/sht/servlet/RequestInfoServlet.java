package sht.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestInfoServlet
 */
@WebServlet("/RequestInfoServlet")
public class RequestInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>RequestInfomation</title></head><body>");
		out.println("リクエスト情報を表示します<br><br>");
		
		// リクエスト情報の表示
		out.print("リモートIPアドレス : " + request.getRemoteAddr() + "<br/>");
		out.print("リクエストURI : " + request.getRequestURI() + "<br/>");
		out.print("HTTPメソッド : " + request.getMethod() + "<br/>");
		out.print("ブラウザの種類 : " + request.getHeader("User-Agent") + "<br/>");
		out.print("利用可能ファイル種別 : " + request.getHeader("Accept") + "<br/>");
		out.print("利用可能言語 : " + request.getHeader("Accept-Language") + "<br/>");
		out.print("</body></html>");
	}

}
