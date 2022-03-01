package Dao;

import Bean.World;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class predao {
    public World findworld(String date, String name)
    {
        System.out.println(date+" "+name);
        String sql="select * from world_map where provinceName='"+name+"' and Date like '"+date+"%'";
        System.out.println(sql);
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        boolean flag=false;
        con= DBUtil.getConn();
        if(con==null)
            System.out.println("con为空");
        World bean=null;
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);

            int num = 0;//获取总记录数。


            while(rs.next())
            {
                flag=true;
                bean=new World();
                bean.setName(rs.getString("provinceName"));
                bean.setConfirmed(rs.getString("confirmedCount"));
                bean.setSuspected(rs.getString("suspectedCount"));
                bean.setCured(rs.getString("curedCount"));
                bean.setDead(rs.getString("deadCount"));
                num++;
            }
            if(flag==false)
                System.out.println("未找到");
            System.out.println("数据条数："+num);
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return bean;
    }
    public ArrayList<World> getconfirmed(String time) {
        String sql="select * from world_map where Date like '"+time+"%' order by confirmedCount desc";
        System.out.println(time);
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        boolean flag=false;
        con=DBUtil.getConn();
        World bean=null;
        ArrayList<World> list=new ArrayList<World>();
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                bean=new World();
                bean.setName(rs.getString("provinceName"));
                bean.setConfirmed(rs.getString("confirmedCount"));
                bean.setSuspected(rs.getString("suspectedCount"));
                bean.setCured(rs.getString("curedCount"));
                bean.setDead(rs.getString("deadCount"));
                //System.out.println(bean.getName()+" "+bean.getConfirmed());
                list.add(bean);
            }
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }
    public ArrayList<World> getdead(String time) {
        String sql="select * from world_map where Date like '"+time+"%' order by deadCount desc";
        System.out.println(time);
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        boolean flag=false;
        con=DBUtil.getConn();
        World bean=null;
        ArrayList<World> list=new ArrayList<World>();
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                bean=new World();
                bean.setName(rs.getString("provinceName"));
                bean.setConfirmed(rs.getString("confirmedCount"));
                bean.setSuspected(rs.getString("suspectedCount"));
                bean.setCured(rs.getString("curedCount"));
                bean.setDead(rs.getString("deadCount"));
                //System.out.println(bean.getName()+" "+bean.getConfirmed());
                list.add(bean);
            }
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }
    public ArrayList<World> getcured(String time) {
        String sql="select * from world_map where Date like '"+time+"%' order by curedCount desc";
        System.out.println(time);
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        boolean flag=false;
        con=DBUtil.getConn();
        World bean=null;
        ArrayList<World> list=new ArrayList<World>();
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                bean=new World();
                bean.setName(rs.getString("provinceName"));
                bean.setConfirmed(rs.getString("confirmedCount"));
                bean.setSuspected(rs.getString("suspectedCount"));
                bean.setCured(rs.getString("curedCount"));
                bean.setDead(rs.getString("deadCount"));
                //System.out.println(bean.getName()+" "+bean.getConfirmed());
                list.add(bean);
            }
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }
    public ArrayList<World> allworld(String time) {
        String sql="select * from world_map where Date like '"+time+"%'";
        System.out.println(time);
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        boolean flag=false;
        con=DBUtil.getConn();
        World bean=null;
        ArrayList<World> list=new ArrayList<World>();
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                bean=new World();
                bean.setName(rs.getString("provinceName"));
                bean.setConfirmed(rs.getString("confirmedCount"));
                bean.setSuspected(rs.getString("suspectedCount"));
                bean.setCured(rs.getString("curedCount"));
                bean.setDead(rs.getString("deadCount"));
                //System.out.println(bean.getName()+" "+bean.getConfirmed());
                list.add(bean);
            }
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }
    public ArrayList<World> dataconfirmed() {
        String sql="select * from world_map ";
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        boolean flag=false;
        con=DBUtil.getConn();
        World bean=null;
        int sum=0;
        int ans=0;
        String data=null;
        ArrayList<World> list=new ArrayList<World>();
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                sum++;
                bean=new World();
                bean.setName(rs.getString("Date"));
                if(sum==1)
                    data=bean.getName();
                bean.setConfirmed(rs.getString("confirmedCount"));
                if(data.equals(bean.getName()))
                    ans+=Integer.parseInt(bean.getConfirmed());
                else
                {
                    String timeString=data.substring(0,10);
                    World bean2=new World();
                    bean2.setName(timeString);
                    bean2.setConfirmed(String.valueOf(ans));
                    sum=1;
                    ans=0;
                    ans+=Integer.parseInt(bean.getConfirmed());
                    data=bean.getName();
                    list.add(bean2);
                }
            }
            bean.setName(data.substring(0,10));
            bean.setConfirmed(String.valueOf(ans));
            list.add(bean);
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }
    public ArrayList<World> getall()
    {
        String sql="select * from sum_world ";
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        boolean flag=false;
        con=DBUtil.getConn();
        World bean=null;
        ArrayList<World> list=new ArrayList<World>();
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                bean=new World();
                bean.setName(rs.getString("Date").substring(0,10));
                bean.setConfirmed(rs.getString("confirmedCount"));
                bean.setCured(rs.getString("curedCount"));
                bean.setDead(rs.getString("deadCount"));
                list.add(bean);
            }
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }

    public ArrayList<World> getsum(String time)
    {
        String sql="select * from world_map where Date like '"+time+"%'";
        System.out.println(time);
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        boolean flag=false;
        con=DBUtil.getConn();
        World bean=null;
        ArrayList<World> list=new ArrayList<World>();
        int confirmed=0;
        int cured=0;
        int dead=0;
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                confirmed+=Integer.parseInt(rs.getString("confirmedCount"));
                cured+=Integer.parseInt(rs.getString("curedCount"));
                dead+=Integer.parseInt(rs.getString("deadCount"));
            }
            bean=new World();
            bean.setConfirmed(String.valueOf(confirmed));
            bean.setCured(String.valueOf(cured));
            bean.setDead(String.valueOf(dead));
            list.add(bean);
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }


    public ArrayList<World> findcured(String time)
    {
        String sql="select * from world_map where Date like '"+time+"%'";
        System.out.println(time);
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        boolean flag=false;
        con=DBUtil.getConn();
        World bean=null;
        ArrayList<World> list=new ArrayList<World>();

        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                int confirmed=0;
                int cured=0;
                double ans=0;
                confirmed+=Integer.parseInt(rs.getString("confirmedCount"));
                cured+=Integer.parseInt(rs.getString("curedCount"));
                ans=cured*1.0/confirmed*100;
                ans= (double) Math.round(ans* 100) / 100;
                bean=new World();
                bean.setName(rs.getString("provinceName"));
                bean.setAns(ans);
                if(bean.getName().equals("中国")||bean.getName().equals("美国")||bean.getName().equals("日本")||bean.getName().equals("德国")||bean.getName().equals("俄罗斯"))
                    list.add(bean);
            }
            Collections.sort(list);
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }
    public ArrayList<World> local()
    {
        String sql="select * from local_world";
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        boolean flag=false;
        con=DBUtil.getConn();
        World bean=null;
        ArrayList<World> list=new ArrayList<World>();
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                bean=new World();
                bean.setDate(rs.getString("Date").substring(0,10));
                bean.setName(rs.getString("yz"));
                bean.setConfirmed(rs.getString("bmz"));
                bean.setCured(rs.getString("oz"));
                bean.setDead(rs.getString("dyz"));
                bean.setSuspected(rs.getString("qita"));
                list.add(bean);
            }
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }
}
