package sht.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sht.beans.PlusBean;

/**
 * Servlet implementation class PludServlet
 */
@WebServlet("/PlusServlet")
public class PlusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		// リクエストパラメータの読み込み
		String num1 = request.getParameter("value1");
		String num2 = request.getParameter("value2");
		if(num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
			// 未入力の場合
			showNotEnterdError(out);
			return;
		}
		
		int i1;
		int i2;
		
		// 足し算の実行
		int answer = 0;
		try {
			i1 = Integer.parseInt(num1);
			i2 = Integer.parseInt(num2);
			answer = i1 + i2;
		} catch (NumberFormatException e) {
			// 整数ではない値が入力された場合
			showNotIntegerError(out);
			return;
		}
		
		// リクエストスコープに必要なデータを入れる
//		request.setAttribute("data1", new Integer(i1));
//		request.setAttribute("data2", new Integer(i2));
//		request.setAttribute("answer", new Integer(answer));
		
		// Beanにまとめる
		PlusBean bean = new PlusBean(i1,i2,answer);
		request.setAttribute("plus", bean);
		
		// リクエストをAnswerServletに転送する
		RequestDispatcher rd = request.getRequestDispatcher("/AnswerServlet");
		rd.forward(request, response);
		
		// 答えの出力
//		out.println("<html><head><title>Plus</title></head><body>");
//		out.println(num1 + "+" + num2 + "=" + answer);
//		out.print("</body></html>");
	}
	
	private void showNotEnterdError(PrintWriter out) {
		out.println("<html><head><title>Plus</title></head><body>");
		out.print("<h1>整数を2つ入力してください</h1>");
		out.print("</body></html>");
	}
	
	private void showNotIntegerError(PrintWriter out) {
		out.println("<html><head><title>Plus</title></head><body>");
		out.print("<h1>整数ではない値が入力されました</h1>");
		out.print("</body></html>");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		doPost(request,response);
	}

}
