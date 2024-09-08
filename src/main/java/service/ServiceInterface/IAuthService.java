package service.ServiceInterface;

import entity.User;
import exception.AppException;

public interface IAuthService {
    public boolean login(User user);
    public boolean logout();
    public boolean register(User user) throws AppException;
}
