package Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Bean.World;
import Dao.predao;

/**
 * Servlet implementation class getdead
 */
@WebServlet("/getdead")
public class getdead extends HttpServlet {
	private static final long serialVersionUID = 1L;
	predao dao=new predao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getdead() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String Time = dateFormat.format(now);//格式化然后放入字符串中
		String data=Time.substring(0,10);
		ArrayList<World> list=dao.getdead(data);
		Gson gson = new Gson();		
		response.setContentType("text/html;charset=utf-8");
		String json = gson.toJson(list);
		response.getWriter().write(json);
		//System.out.println(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
