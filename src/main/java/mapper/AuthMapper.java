package mapper;

import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthMapper implements RowMapper<User>{

    @Override
    public User mapRow(ResultSet rs) {
        try {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setCreate_at(rs.getTimestamp("create_at"));
            user.setUpdate_up(rs.getTimestamp("update_at") );
            System.out.println(user.getName());
            return user;
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
