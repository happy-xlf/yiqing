package Dao;

import Bean.Pro;
import Bean.World;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class Prodao {

    public ArrayList<Pro> getdead(String time)
    {
        String sql="select * from china where time like '"+time+"%' and city='"+"Null"+"' order by deadCount desc";
        System.out.println(time);
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        boolean flag=false;
        con= DBUtil.getConn();
        Pro bean=null;
        ArrayList<Pro> list=new ArrayList<Pro>();
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                bean=new Pro();
                bean.setProvinceName(rs.getString("provinceName"));
                bean.setConfirmedCount(rs.getString("confirmedCount"));
                bean.setSuspectedCount(rs.getString("suspectedCount"));
                bean.setCuredCount(rs.getString("curedCount"));
                bean.setDeadCount(rs.getString("deadCount"));
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


    public ArrayList<Pro> getcity(String time,String code)
    {
        String sql="select * from china where time like '"+time+"%' and Code like '"+code+"%' and city!='"+"Null"+"'";
        System.out.println(time);
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        boolean flag=false;
        con= DBUtil.getConn();
        Pro bean=null;
        ArrayList<Pro> list=new ArrayList<Pro>();
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                bean=new Pro();
                bean.setProvinceName(rs.getString("provinceName"));
                bean.setCity(rs.getString("city"));
                bean.setConfirmedCount(rs.getString("confirmedCount"));
                bean.setSuspectedCount(rs.getString("suspectedCount"));
                bean.setCuredCount(rs.getString("curedCount"));
                bean.setDeadCount(rs.getString("deadCount"));
                bean.setCode(rs.getString("Code"));
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

    public ArrayList<Pro> allchina(String time)
    {
        String sql="select * from china where time like '"+time+"%' and city='"+"Null"+"'";
        System.out.println(time);
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        boolean flag=false;
        con= DBUtil.getConn();
        Pro bean=null;
        ArrayList<Pro> list=new ArrayList<Pro>();
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                bean=new Pro();
                bean.setProvinceName(rs.getString("provinceName"));
                bean.setConfirmedCount(rs.getString("confirmedCount"));
                bean.setSuspectedCount(rs.getString("suspectedCount"));
                bean.setCuredCount(rs.getString("curedCount"));
                bean.setDeadCount(rs.getString("deadCount"));
                bean.setCode(rs.getString("Code"));
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

    public ArrayList<Pro> getcured(String time)
    {
        System.out.println(time);
        String sql="select * from china where time like '"+time+"%' and city='"+"Null"+"' order by curedCount desc";
        System.out.println(time);
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        boolean flag=false;
        con= DBUtil.getConn();
        Pro bean=null;
        ArrayList<Pro> list=new ArrayList<Pro>();
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                bean=new Pro();
                bean.setProvinceName(rs.getString("provinceName"));
                bean.setConfirmedCount(rs.getString("confirmedCount"));
                bean.setSuspectedCount(rs.getString("suspectedCount"));
                bean.setCuredCount(rs.getString("curedCount"));
                bean.setDeadCount(rs.getString("deadCount"));
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


    public ArrayList<Pro> getconfirmed(String time)
    {
        String sql="select * from china where time like '"+time+"%' and city='"+"Null"+"' order by confirmedCount desc";
        System.out.println(time);
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        boolean flag=false;
        con= DBUtil.getConn();
        Pro bean=null;
        ArrayList<Pro> list=new ArrayList<Pro>();
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                bean=new Pro();
                bean.setProvinceName(rs.getString("provinceName"));
                bean.setConfirmedCount(rs.getString("confirmedCount"));
                bean.setSuspectedCount(rs.getString("suspectedCount"));
                bean.setCuredCount(rs.getString("curedCount"));
                bean.setDeadCount(rs.getString("deadCount"));
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

    public ArrayList<Pro> getsum(String time)
    {
        String sql="select * from china where time like '"+time+"%' ";
        System.out.println(time);
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        boolean flag=false;
        con= DBUtil.getConn();
        Pro bean=null;
        ArrayList<Pro> list=new ArrayList<Pro>();
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
            bean=new Pro();
            bean.setConfirmedCount(String.valueOf(confirmed));
            bean.setCuredCount(String.valueOf(cured));
            bean.setDeadCount(String.valueOf(dead));
            list.add(bean);
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }


    public ArrayList<Pro> findcured(String time)
    {
        String sql="select * from china where time like '"+time+"%' and city='"+"Null"+"'";
        System.out.println(time);
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        boolean flag=false;
        con= DBUtil.getConn();
        Pro bean=null;
        ArrayList<Pro> list=new ArrayList<Pro>();
        int confirmed=0;
        int cured=0;
        double ans=0;
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                confirmed+=Integer.parseInt(rs.getString("confirmedCount"));
                cured+=Integer.parseInt(rs.getString("curedCount"));
                ans=cured*1.0/confirmed*100;
                ans= (double) Math.round(ans* 100) / 100;
                bean=new Pro();
                bean.setProvinceName(rs.getString("provinceName"));
                bean.setAns(ans);
                if(bean.getProvinceName().equals("北京")||bean.getProvinceName().equals("上海")||bean.getProvinceName().equals("湖北")||bean.getProvinceName().equals("广东")||bean.getProvinceName().equals("河北"))
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

    public ArrayList<Pro> local()
    {
        String sql="select * from china where city='"+"Null"+"' order by time";
        Connection con=null;
        Statement state=null;
        ResultSet rs=null;
        boolean flag=false;
        con=DBUtil.getConn();
        Pro bean=null;
        ArrayList<Pro> list=new ArrayList<Pro>();
        int hb=0;
        int sc=0;
        int xj=0;
        int hlj=0;
        int bj=0;
        int sum=0;
        String data=null;
        try {
            state=con.createStatement();
            rs=state.executeQuery(sql);
            while(rs.next())
            {
                sum++;
                bean=new Pro();
                bean.setDate(rs.getString("time"));
                if(sum==1)
                    data=bean.getDate();
                if(data.equals(bean.getDate()))
                {
                    String local=rs.getString("provinceName");
                    if(local.equals("河北"))
                        hb+=Integer.parseInt(rs.getString("confirmedCount"));
                    else if(local.equals("四川"))
                        sc+=Integer.parseInt(rs.getString("confirmedCount"));
                    else if(local.equals("新疆"))
                        xj+=Integer.parseInt(rs.getString("confirmedCount"));
                    else if(local.equals("黑龙江"))
                        hlj+=Integer.parseInt(rs.getString("confirmedCount"));
                    else if(local.equals("北京"))
                        bj+=Integer.parseInt(rs.getString("confirmedCount"));
                }
                else
                {
                    String timeString=data.substring(0,10);
                    Pro bean2=new Pro();
                    bean2.setDate(timeString);
                    bean2.setProvinceName(String.valueOf(hb));
                    bean2.setConfirmedCount(String.valueOf(sc));
                    bean2.setCuredCount(String.valueOf(xj));
                    bean2.setDeadCount(String.valueOf(hlj));
                    bean2.setSuspectedCount(String.valueOf(bj));
                    sum=1;
                    hb=0;
                    sc=0;
                    xj=0;
                    hlj=0;
                    bj=0;
                    String local=rs.getString("provinceName");
                    if(local.equals("河北"))
                        hb+=Integer.parseInt(rs.getString("confirmedCount"));
                    else if(local.equals("四川"))
                        sc+=Integer.parseInt(rs.getString("confirmedCount"));
                    else if(local.equals("新疆"))
                        xj+=Integer.parseInt(rs.getString("confirmedCount"));
                    else if(local.equals("黑龙江"))
                        hlj+=Integer.parseInt(rs.getString("confirmedCount"));
                    else if(local.equals("北京"))
                        bj+=Integer.parseInt(rs.getString("confirmedCount"));
                    data=rs.getString("time");
                    list.add(bean2);
                }
            }
            bean.setDate(data.substring(0,10));
            bean.setProvinceName(String.valueOf(hb));
            bean.setConfirmedCount(String.valueOf(sc));
            bean.setCuredCount(String.valueOf(xj));
            bean.setDeadCount(String.valueOf(hlj));
            bean.setSuspectedCount(String.valueOf(bj));
            list.add(bean);
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }


    public ArrayList<Pro> getall() {
        String sql = "select * from china where city='"+"Null"+"' order by time";
        Connection con = null;
        Statement state = null;
        ResultSet rs = null;
        boolean flag = false;
        con = DBUtil.getConn();
        Pro bean = null;
        int sum = 0;
        int confirmed = 0;
        int cured = 0;
        int dead = 0;
        String data = null;
        ArrayList<Pro> list = new ArrayList<Pro>();
        try {
            state = con.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                sum++;
                bean = new Pro();
                bean.setProvinceName(rs.getString("time"));
                if (sum == 1)
                    data = bean.getProvinceName();
                bean.setConfirmedCount(rs.getString("confirmedCount"));
                bean.setCuredCount(rs.getString("curedCount"));
                bean.setDeadCount(rs.getString("deadCount"));
                if (data.equals(bean.getProvinceName())) {
                    confirmed += Integer.parseInt(bean.getConfirmedCount());
                    cured += Integer.parseInt(bean.getCuredCount());
                    dead += Integer.parseInt(bean.getDeadCount());
                } else {
                    String timeString = data.substring(0, 10);
                    Pro bean2 = new Pro();
                    bean2.setProvinceName(timeString);
                    bean2.setConfirmedCount(String.valueOf(confirmed));
                    bean2.setCuredCount(String.valueOf(cured));
                    bean2.setDeadCount(String.valueOf(dead));
                    sum = 1;
                    confirmed = 0;
                    cured = 0;
                    dead = 0;
                    confirmed += Integer.parseInt(bean.getConfirmedCount());
                    cured += Integer.parseInt(bean.getCuredCount());
                    dead += Integer.parseInt(bean.getDeadCount());
                    data = bean.getProvinceName();
                    list.add(bean2);
                }
            }
            System.out.println(data);
            bean.setProvinceName(data.substring(0, 10));
            bean.setConfirmedCount(String.valueOf(confirmed));
            bean.setCuredCount(String.valueOf(cured));
            bean.setDeadCount(String.valueOf(dead));
            list.add(bean);
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        DBUtil.close(rs, state, con);
        return list;
    }

}
