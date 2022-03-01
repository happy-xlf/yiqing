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
import java.util.ArrayList;

@WebServlet("/chinagetall")
public class chinagetall extends HttpServlet {
    Prodao dao=new Prodao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ArrayList<Pro> list=dao.getall();
        Gson gson = new Gson();
        response.setContentType("text/html;charset=utf-8");
        String json = gson.toJson(list);
        response.getWriter().write(json);
        System.out.println("日期变化曲线！");
        System.out.println(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

