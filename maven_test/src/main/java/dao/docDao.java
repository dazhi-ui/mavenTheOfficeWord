package dao;

import bean.Doc;
import bean.User;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;

public class docDao {

    public boolean adddoc(Doc b)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con= DBUtil.getConn();
            String sql="insert into doc(title,content,owner,receiver,time,status,del) values(?,?,?,?,?,?,?)";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, b.getTitle());
            pstmt.setString(2, b.getContent());
            pstmt.setString(3, b.getOwner());
            pstmt.setString(4, b.getReceiver());
            pstmt.setString(5, b.getTime());
            pstmt.setString(6, b.getStatus());
            pstmt.setString(7, b.getDel());
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            System.out.println("录入失败");
            e.printStackTrace();
        }
        finally {
            DBUtil.close(rs, pstmt, con);
        }
        return false;
    }

    public ArrayList<Doc> lookstatusdoc(String owner)
    {
        ArrayList<Doc> list=new ArrayList<Doc>();
        String sql="select * from doc where owner='"+owner+"' and status!='"+6+"'";
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        con= DBUtil.getConn();
        Doc bean=null;
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String content=rs.getString("content");
                String receiver=rs.getString("receiver");
                String time=rs.getString("time");
                String status=rs.getString("status");
                bean=new Doc(id,title,content,owner,receiver,time,status);
                list.add(bean);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }
    public ArrayList<Doc> looknormaldoc(String owner)
    {
        ArrayList<Doc> list=new ArrayList<Doc>();
        String sql="select * from doc where owner='"+owner+"' and status=6";
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        con= DBUtil.getConn();
        Doc bean=null;
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String content=rs.getString("content");
                String receiver=rs.getString("receiver");
                String time=rs.getString("time");
                String status=rs.getString("status");
                bean=new Doc(id,title,content,owner,receiver,time,status);
                list.add(bean);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }
    public boolean qianshoudoc(String owner,String title,String status)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con= DBUtil.getConn();
            String sql="update doc set status=? where owner=? and title=?";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, status);
            pstmt.setString(2, owner);
            pstmt.setString(3, title);
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            System.out.println("更新失败");
            e.printStackTrace();
        }
        finally {
            DBUtil.close(rs, pstmt, con);
        }
        return false;
    }
    /*
        收集待发送的公文
    */
    public ArrayList<Doc> notsenddoc()
    {
        ArrayList<Doc> list=new ArrayList<Doc>();
        String sql="select * from doc where (status=0 or status=1 or status=2 or status=3 or status=4 or status=5 ) and del=0;";
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        con= DBUtil.getConn();
        Doc bean=null;
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String owner=rs.getString("owner");
                String content=rs.getString("content");
                String receiver=rs.getString("receiver");
                String time=rs.getString("time");
                String status=rs.getString("status");
                String ftip=rs.getString("ftip");
                String ctip=rs.getString("ctip");
                String del=rs.getString("del");
                bean=new Doc(id,title,content,owner,receiver,time,status,ftip,ctip,del);
                list.add(bean);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }

    /*
    格式化公文
     */
    public boolean formatdoc(String title,String status)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con= DBUtil.getConn();
            String sql="update doc set status=? where title=?";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, status);
            pstmt.setString(2, title);
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            System.out.println("更新失败");
            e.printStackTrace();
        }
        finally {
            DBUtil.close(rs, pstmt, con);
        }
        return false;
    }

    /*
    发送公文
     */
    public boolean send(String title,String status,String receiver)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con= DBUtil.getConn();
            String sql="update doc set status=?,receiver=? where title=?";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, status);
            pstmt.setString(2, receiver);
            pstmt.setString(3, title);
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            System.out.println("更新失败");
            e.printStackTrace();
        }
        finally {
            DBUtil.close(rs, pstmt, con);
        }
        return false;
    }
    /*
    删除公文
     */
    public boolean deldoc(String title,String del)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con= DBUtil.getConn();
            String sql="update doc set del=? where title=?";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, del);
            pstmt.setString(2, title);
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            System.out.println("更新失败");
            e.printStackTrace();
        }
        finally {
            DBUtil.close(rs, pstmt, con);
        }
        return false;
    }
    /*
    获取已发送的公文
     */
    public ArrayList<Doc> get_senddoc()
    {
        ArrayList<Doc> list=new ArrayList<Doc>();
        String sql="select * from doc where status=7 or status=8 or status=9 or status=6 and del=0";
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        con= DBUtil.getConn();
        Doc bean=null;
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String owner=rs.getString("owner");
                String content=rs.getString("content");
                String receiver=rs.getString("receiver");
                String time=rs.getString("time");
                String status=rs.getString("status");
                String ftip=rs.getString("ftip");
                String ctip=rs.getString("ctip");
                String del=rs.getString("del");
                bean=new Doc(id,title,content,owner,receiver,time,status,ftip,ctip,del);
                list.add(bean);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }
    /*
    获取已删除的公文
     */
    public ArrayList<Doc> get_deldoc()
    {
        ArrayList<Doc> list=new ArrayList<Doc>();
        String sql="select * from doc where del=1";
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        con= DBUtil.getConn();
        Doc bean=null;
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String owner=rs.getString("owner");
                String content=rs.getString("content");
                String receiver=rs.getString("receiver");
                String time=rs.getString("time");
                String status=rs.getString("status");
                String ftip=rs.getString("ftip");
                String ctip=rs.getString("ctip");
                String del=rs.getString("del");
                bean=new Doc(id,title,content,owner,receiver,time,status,ftip,ctip,del);
                list.add(bean);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }

    /*
    获取要审查的公文
     */
    public ArrayList<Doc> get_shenhedoc()
    {
        ArrayList<Doc> list=new ArrayList<Doc>();
        String sql="select * from doc where status=7";
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        con= DBUtil.getConn();
        Doc bean=null;
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String owner=rs.getString("owner");
                String content=rs.getString("content");
                String receiver=rs.getString("receiver");
                String time=rs.getString("time");
                String status=rs.getString("status");
                String ftip=rs.getString("ftip");
                String ctip=rs.getString("ctip");
                String del=rs.getString("del");
                bean=new Doc(id,title,content,owner,receiver,time,status,ftip,ctip,del);
                list.add(bean);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }

    /*
    通过标题获取公文
     */

    public Doc getdocby_title(String title)
    {
        String sql="select * from doc where title='"+title+"'";
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        con= DBUtil.getConn();
        Doc bean=null;
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                int id=rs.getInt("id");
                String owner=rs.getString("owner");
                String content=rs.getString("content");
                String receiver=rs.getString("receiver");
                String time=rs.getString("time");
                String status=rs.getString("status");
                String ftip=rs.getString("ftip");
                String ctip=rs.getString("ctip");
                String del=rs.getString("del");
                bean=new Doc(id,title,content,owner,receiver,time,status,ftip,ctip,del);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return bean;
    }

    public boolean updateftip(String title,String ftip,String status)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con= DBUtil.getConn();
            String sql="update doc set ftip=?,status=?,receiver=? where title=?";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, ftip);
            pstmt.setString(2, status);
            pstmt.setString(3, "办公室");
            pstmt.setString(4,title);
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            System.out.println("更新失败");
            e.printStackTrace();
        }
        finally {
            DBUtil.close(rs, pstmt, con);
        }
        return false;
    }

    /*
    获取副厂长所有已发公文
     */
    public ArrayList<Doc> fczsend()
    {
        ArrayList<Doc> list=new ArrayList<Doc>();
        String sql="select * from doc where status=2 or status=3 or status=8 or status=4 or status=5 or status=9 or status=6";
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        con= DBUtil.getConn();
        Doc bean=null;
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String owner=rs.getString("owner");
                String content=rs.getString("content");
                String receiver=rs.getString("receiver");
                String time=rs.getString("time");
                String status=rs.getString("status");
                String ftip=rs.getString("ftip");
                String ctip=rs.getString("ctip");
                String del=rs.getString("del");
                bean=new Doc(id,title,content,owner,receiver,time,status,ftip,ctip,del);
                list.add(bean);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }

    public ArrayList<Doc> get_shenqiandoc()
    {
        ArrayList<Doc> list=new ArrayList<Doc>();
        String sql="select * from doc where status=8";
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        con= DBUtil.getConn();
        Doc bean=null;
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String owner=rs.getString("owner");
                String content=rs.getString("content");
                String receiver=rs.getString("receiver");
                String time=rs.getString("time");
                String status=rs.getString("status");
                String ftip=rs.getString("ftip");
                String ctip=rs.getString("ctip");
                String del=rs.getString("del");
                bean=new Doc(id,title,content,owner,receiver,time,status,ftip,ctip,del);
                list.add(bean);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }

    /*
    更新厂长意见
     */
    public boolean updatectip(String title,String ctip,String status)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con= DBUtil.getConn();
            String sql="update doc set ctip=?,status=?,receiver=? where title=?";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, ctip);
            pstmt.setString(2, status);
            pstmt.setString(3, "办公室");
            pstmt.setString(4,title);
            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            System.out.println("更新失败");
            e.printStackTrace();
        }
        finally {
            DBUtil.close(rs, pstmt, con);
        }
        return false;
    }

    /*
    获取厂长所有已发公文
     */
    public ArrayList<Doc> czsend()
    {
        ArrayList<Doc> list=new ArrayList<Doc>();
        String sql="select * from doc where status=4 or status=5 or status=9 or status=6";
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        con= DBUtil.getConn();
        Doc bean=null;
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String owner=rs.getString("owner");
                String content=rs.getString("content");
                String receiver=rs.getString("receiver");
                String time=rs.getString("time");
                String status=rs.getString("status");
                String ftip=rs.getString("ftip");
                String ctip=rs.getString("ctip");
                String del=rs.getString("del");
                bean=new Doc(id,title,content,owner,receiver,time,status,ftip,ctip,del);
                list.add(bean);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }
    /*
    根据标题找对应的owner
     */

    public String findowner_bytitle(String title)
    {
        String sql="select * from doc where title='"+title+"'";
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        con= DBUtil.getConn();
        String owner="";
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                owner=rs.getString("owner");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return owner;
    }

    public ArrayList<Doc> findnormaldoc_bytime(String owner,String bgtime,String edtime)
    {
        ArrayList<Doc> list=new ArrayList<Doc>();
        String sql="select * from doc where time BETWEEN '"+bgtime+"' and '"+edtime+"' and owner='"+owner+"'";
        System.out.println(sql);
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        con= DBUtil.getConn();
        Doc bean=null;
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                int id=rs.getInt("id");
                String title=rs.getString("title");
                System.out.println(title);
                String content=rs.getString("content");
                String receiver=rs.getString("receiver");
                String time=rs.getString("time");
                String status=rs.getString("status");
                String ftip=rs.getString("ftip");
                String ctip=rs.getString("ctip");
                String del=rs.getString("del");
                bean=new Doc(id,title,content,owner,receiver,time,status,ftip,ctip,del);
                list.add(bean);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }

    public ArrayList<Doc> finddoc_byowner_receiver(String owner,String receiver)
    {
        ArrayList<Doc> list=new ArrayList<Doc>();
        String sql="";
        if((owner!=""&&owner!=null)&&(receiver!=""&&receiver!=null))
            sql="select * from doc where owner='"+owner+"'and receiver='"+receiver+"'";
        else if(receiver!=""&&receiver!=null)
            sql="select * from doc where receiver='"+receiver+"'";
        else if(owner!=""&&owner!=null)
            sql="select * from doc where owner='"+owner+"'";
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        con= DBUtil.getConn();
        Doc bean=null;
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                int id=rs.getInt("id");
                String title=rs.getString("title");
                String owners=rs.getString("owner");
                String content=rs.getString("content");
                String receivers=rs.getString("receiver");
                String time=rs.getString("time");
                String status=rs.getString("status");
                String ftip=rs.getString("ftip");
                String ctip=rs.getString("ctip");
                String del=rs.getString("del");
                bean=new Doc(id,title,content,owners,receivers,time,status,ftip,ctip,del);
                list.add(bean);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }
    public boolean updataDoc(String content,String title)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con= DBUtil.getConn();
            String sql="update doc set content=? where title=?";

            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, content);
            pstmt.setString(2, title);

            pstmt.executeUpdate();
            return true;
        }
        catch (SQLException e) {
            System.out.println("更新失败");
            e.printStackTrace();
        }
        finally {
            DBUtil.close(rs, pstmt, con);
        }
        return false;
    }
}
