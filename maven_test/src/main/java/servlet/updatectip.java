package servlet;

import dao.docDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatectip")
public class updatectip extends HttpServlet {
    docDao dao=new docDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String title=request.getParameter("doctitle");
        String ctip=request.getParameter("ctip");
        String ans=request.getParameter("ans");
        String status="";
        System.out.println(title+ctip+ans);
        if(ans.equals("同意"))
            status="5";
        else
            status="4";
        if(dao.updatectip(title,ctip,status))
            response.getWriter().write("yes");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

