package respository;

import entity.User;
import exception.AppException;
import org.springframework.stereotype.Repository;
import respository.Connect.DBContext;
import respository.respositoryInterface.IAuthRespository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


@Repository
public class AuthRespository extends AbstractRespository<User> implements IAuthRespository {
    @Override
    public boolean register(User user) throws AppException  {
        String sql = "INSERT INTO `user`(`name`, `password`, `email`, `create_at`, `update_at`) " +
                "   VALUES (?,?,?,?,?)";


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String formattedDate = formatter.format(now);
        Timestamp customTimestamp = Timestamp.valueOf(formattedDate);
        super.insert(sql, user.getName(), user.getPassword(), user.getEmail(), customTimestamp,customTimestamp);
        return true;
    }


}
