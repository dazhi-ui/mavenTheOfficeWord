package servlet;

import bean.User;
import dao.userDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@WebServlet("/adduser")
public class adduser extends HttpServlet {
    userDao dao=new userDao();
    public static final String KEY_MD5 = "MD5";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        try {
            MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
            md5.update(password.getBytes());
            password= md5.digest().toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


        System.out.println(username+" "+password);
        String permissionId=request.getParameter("permissionId");
        String job=request.getParameter("job");
        String status=request.getParameter("status");
        User bean=new User(username,password,permissionId,job,status);
        if(dao.adduser(bean))
            response.getWriter().write("yes");
        else
            response.getWriter().write("no");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
