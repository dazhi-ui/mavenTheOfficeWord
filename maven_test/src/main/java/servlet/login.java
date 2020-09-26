package servlet;

import bean.User;
import com.google.gson.Gson;
import dao.userDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class login extends HttpServlet {
    userDao dao=new userDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(username+password);
        User bean=dao.do_login(username,password);
        if(bean!=null)
        {
            Gson gson = new Gson();
            response.setContentType("text/html;charset=utf-8");
            String json = gson.toJson(bean);
            response.getWriter().write(json);
        }
        else
        {
            bean=new User();
            bean.setUsername("null");
            Gson gson = new Gson();
            response.setContentType("text/html;charset=utf-8");
            String json = gson.toJson(bean);
            response.getWriter().write(json);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
