package servlet;

import dao.docDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/senddoc")
public class senddoc extends HttpServlet {
    docDao dao=new docDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String title=request.getParameter("title");
        String status=request.getParameter("status");
        String owner=dao.findowner_bytitle(title);
        System.out.println(status);
        String newstatus="";
        String receiver="";
        if(status.equals("1"))
        {
            newstatus="7";
            receiver="经理";
        }
        else if(status.equals("3"))
        {
            newstatus="8";
            receiver="总经理";
        }
        else if(status.equals("5"))
        {
            newstatus="9";
            receiver=owner;
        }
        if(dao.send(title,newstatus,receiver))
            response.getWriter().write("yes");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

