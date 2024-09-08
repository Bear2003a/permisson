package respository;



import entity.User;
import mapper.RowMapper;
import respository.Connect.DBContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractRespository<T>{



    public List<T> findAll(String sql, RowMapper<T> mapper, Object ...parameter){
        List<T> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBContext.connect();
            ps = con.prepareStatement(sql);
            if(parameter != null && parameter.length > 0){
                setAttr(ps, parameter);
            }
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(mapper.mapRow(rs));
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            close(con, ps, rs);
        }
        return list;
    }


    public T findOne(String sql, RowMapper<T> mapper, Object ...parameter){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            if(parameter != null && parameter.length > 0){
                setAttr(ps, parameter);
            }
            rs = ps.executeQuery();
            if(rs.next()){
                T object= mapper.mapRow(rs);
                return object;
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            close(con, ps, rs);
        }
        return null;
    }


    public void insert(String sql, Object ...parameter){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBContext.connect();
            ps= con.prepareStatement(sql);
            setAttr(ps, parameter);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            close(con, ps, null);
        }

    }

    public void update(String sql, Object ...parameter){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBContext.connect();
            ps= con.prepareStatement(sql);
            setAttr(ps, parameter);
            ps.executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            close(con, ps, null);
        }
    }

    public void delete(String sql, Object ...parameter){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBContext.connect();
            ps= con.prepareStatement(sql);
            setAttr(ps, parameter);
            ps.executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            close(con, ps, null);
        }
    }


    public void setAttr(PreparedStatement ps, Object ...parameter){
        int count = 1;
         try {
             for(Object o : parameter){
                 if(o instanceof String){
                     ps.setString(count, (String)o);

                 }
                 else if(o instanceof Integer){
                     ps.setInt(count, (Integer)o);

                 }
                 else if(o instanceof Double){
                     ps.setDouble(count, (Double)o);
                 }
                 else if(o instanceof Boolean){
                     ps.setBoolean(count, (Boolean)o);
                 }
                 else if(o instanceof Long){
                     ps.setLong(count, (Long)o);
                 }
                 else if(o instanceof Date){
                     ps.setDate(count, (Date)o);

                 }
                 else if(o instanceof Timestamp){
                     ps.setTimestamp(count, (Timestamp)o);
                 }

                 count++;
             }
         }catch (Exception e) {
             System.out.println(e.getMessage());
         }
    }


    public void close(Connection con , PreparedStatement ps , ResultSet rs){
        try {
            if(con != null){
                con.close();
            }
            if(ps != null){
                ps.close();
            }
            if(rs != null){
                rs.close();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



}
