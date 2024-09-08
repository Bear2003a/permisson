package service;

import entity.User;
import exception.AppException;
import exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import respository.respositoryInterface.IAuthRespository;
import service.ServiceInterface.IAuthService;

@Service
public class AuthService implements IAuthService {
    @Autowired
    IAuthRespository authRespository;

    @Override
    public boolean login(User user) {
        return false;
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public boolean register(User user) throws AppException {
        if(user.getName() == null || user.getName().isEmpty()){
            throw new AppException(ErrorCode.USER_NAME_EMPTY);
        }
        if(user.getPassword() == null || user.getPassword().isEmpty()){
            throw new AppException(ErrorCode.USER_PASSWORD_EMPTY);
        }
        if(user.getEmail() == null || user.getEmail().isEmpty()){
            throw new AppException(ErrorCode.USER_EMAIL_EMPTY);
        }
        else{
            authRespository.register(user);
            return true;
        }
    }
}
