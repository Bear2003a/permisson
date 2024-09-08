package respository.respositoryInterface;

import entity.User;

import java.util.List;

public interface IUserRespository {
    public List<User> findAll();
    public void update(User user);
    public User findById(int id);
}
