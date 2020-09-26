package servlet;

import bean.Doc;
import dao.docDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/adddoc")
public class adddoc extends HttpServlet {
    docDao dao=new docDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String owner=request.getParameter("username");
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        String receiver="办公室";
        String status="0";
        String delete="0";
        Date date = new Date();


        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=dateFormat.format(date).toString();


        Doc bean=new Doc(title,content,owner,receiver,time,status,delete);
        if(dao.adddoc(bean))
            response.getWriter().write("yes");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
