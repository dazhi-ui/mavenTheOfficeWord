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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@WebServlet("/updatauser")
public class updatauser extends HttpServlet {
    userDao dao=new userDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String permissionId=request.getParameter("permissionId");
        String job=request.getParameter("job");
        String status=request.getParameter("status");
        int id=Integer.parseInt(request.getParameter("id"));


        User bean=new User(id,username,password,permissionId,job,status);
        if(dao.updataUser(bean))
            response.getWriter().write("yes");
        else
            response.getWriter().write("no");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
