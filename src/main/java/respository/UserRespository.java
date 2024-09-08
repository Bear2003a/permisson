package respository;

import entity.User;
import mapper.AuthMapper;
import mapper.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import respository.Connect.DBContext;
import respository.respositoryInterface.IUserRespository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserRespository extends AbstractRespository<User> implements IUserRespository {

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = super.findAll(sql, new AuthMapper() );
        return users;
    }

    @Override
    public void update(User user) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String formattedDate = formatter.format(now);
        String sql = "update user set name = ?, password= ?, update_at = ? where id = ?";
        super.update(sql, user.getName(), user.getPassword(), formattedDate, user.getId());

    }

    @Override
    public User findById(int id) {
        String sql = "select * from user where id = ?";
        User u = super.findOne(sql,new AuthMapper() , id);
        return u;
    }


}
