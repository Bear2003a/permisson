package service;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import respository.respositoryInterface.IUserRespository;
import service.ServiceInterface.IUserService;
@Service
public class UserService implements IUserService {
    @Autowired
    IUserRespository i;


    @Override
    public boolean updateUser(User user) {
        return  true;
    }
}
