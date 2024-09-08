package respository.respositoryInterface;

import entity.User;
import exception.AppException;

public interface IAuthRespository {
    public  boolean register(User user) throws AppException;
}
