package mapper;

import domain.User;
import domain.UserQueryVo;

import java.util.List;

public interface UserMapper {

    public void insertUser(User user) throws Exception;

    public User findUserById(int id) throws Exception;

    public List<User> findUserByName(String name) throws Exception;

    public List<User> findUserList(UserQueryVo userQueryVo) throws Exception;

    public int findUserCount(UserQueryVo userQueryVo) throws Exception;
}
