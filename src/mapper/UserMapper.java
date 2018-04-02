package mapper;

import domain.User;

import java.util.List;

public interface UserMapper {

    public void insertUser(User user) throws Exception;

    public User findUserById(int id) throws Exception;

    public List<User> findUserByName(String name) throws Exception;
}
