package servlet;

import dao.docDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateftip")
public class updateftip extends HttpServlet {
    docDao dao=new docDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String title=request.getParameter("doctitle");
        String ftip=request.getParameter("ftip");
        String ans=request.getParameter("ans");
        String status="";
        System.out.println(title+ftip+ans);
        if(ans.equals("同意"))
            status="3";
        else
            status="2";
        if(dao.updateftip(title,ftip,status))
            response.getWriter().write("yes");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

