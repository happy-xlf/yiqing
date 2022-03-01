package Servlet;

import Bean.Pro;
import Bean.World;
import Dao.Prodao;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/chinagetsum")
public class chinagetsum extends HttpServlet {
    Prodao dao=new Prodao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String Time = dateFormat.format(now);//格式化然后放入字符串中
        String data=Time.substring(0,10);
        ArrayList<Pro> list=dao.getsum(data);
        Gson gson = new Gson();
        response.setContentType("text/html;charset=utf-8");
        String json = gson.toJson(list);
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

