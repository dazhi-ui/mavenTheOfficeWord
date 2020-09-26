package dao;

import bean.User;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;

public class userDao {

    public User do_login(String username, String password)
    {
        User bean=null;
        String sql="select * from users where username='"+username+"' and password='"+password+"'";
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        con= DBUtil.getConn();
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                String permissionId=rs.getString("permissionId");
                String job=rs.getString("job");
                String status=rs.getString("status");
                bean=new User(username,password,permissionId,job,status);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return bean;
    }

    public boolean updatepsw(String username,String password)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con= DBUtil.getConn();
            String sql="update users set password=? where username=?";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, password);
            pstmt.setString(2, username);
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

    public boolean adduser(User b)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con= DBUtil.getConn();
            String sql="insert into users(username,password,permissionId,job,status) values(?,?,?,?,?)";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, b.getUsername());
            pstmt.setString(2, b.getPassword());
            pstmt.setString(3, b.getPermissionId());
            pstmt.setString(4, b.getJob());
            pstmt.setString(5, b.getStatus());
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

    public ArrayList<User> findalluser()
    {
        ArrayList<User> list=new ArrayList<User>();
        String sql="select * from users";
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        con= DBUtil.getConn();
        User bean=null;
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                String username=rs.getString("username");
                String password=rs.getString("password");
                String job=rs.getString("job");
                String status=rs.getString("status");
                bean=new User(username,password,job,status);
                list.add(bean);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }
    public ArrayList<User> find_User_name(String username)
    {
        ArrayList<User> list=new ArrayList<User>();
        String sql="select * from users where username='"+username+"'";
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        con= DBUtil.getConn();
        User bean=null;
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                int id=Integer.parseInt(rs.getString("id"));
                String username1=rs.getString("username");
                String password=rs.getString("password");
                String job=rs.getString("job");
                String status=rs.getString("status");
                String permissionId=rs.getString("permissionId");
                bean=new User(id,username1,password,permissionId,job,status);
                list.add(bean);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }

    public boolean del(String username)
    {
        String sql="delete from users where username='" + username + "'";
        Connection conn = DBUtil.getConn();
        Statement state = null;
        int a = 0;
        boolean f = false;
        try {
            state = conn.createStatement();
            a = state.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(state, conn);
        }

        if (a > 0) {
            f = true;
        }
        return f;
    }
    public boolean stopuser(String username)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con= DBUtil.getConn();
            String sql="update users set status=? where username=?";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, "0");
            pstmt.setString(2, username);
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

    public boolean startuser(String username)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con= DBUtil.getConn();
            String sql="update users set status=? where username=?";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, "1");
            pstmt.setString(2, username);
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
    public boolean updataUser(User bean)
    {
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            con= DBUtil.getConn();
            String sql="update users set username=?,password=?,permissionId=?,job=?,status=? where id=?";

            pstmt=con.prepareStatement(sql);
            pstmt.setString(1, bean.getUsername());
            pstmt.setString(2, bean.getPassword());
            pstmt.setString(3, bean.getPermissionId());
            pstmt.setString(4, bean.getJob());
            pstmt.setString(5, bean.getStatus());
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
