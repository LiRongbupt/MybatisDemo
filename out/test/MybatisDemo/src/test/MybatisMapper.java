package test;

import domain.User;
import domain.UserCustom;
import domain.UserQueryVo;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisMapper {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource = "SqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Ignore
    public void findUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(2);
        sqlSession.close();

        System.out.println(user);
    }

    @Ignore
    public void findUserByName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findUserByName("r");
        sqlSession.close();

        System.out.println(users);
    }

    @Ignore
    public void insertUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setUsername("wtf");
        user.setSex("unknown");
        user.setAddress("Earth");
        user.setBirthday(new Date());

        userMapper.insertUser(user);

        sqlSession.commit();
        sqlSession.close();

    }

    @Ignore
    public void findUserList() throws Exception{
        SqlSession sqlSession=sqlSessionFactory.openSession();

        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

        UserQueryVo userQueryVo = new UserQueryVo();
        UserCustom userCustom = new UserCustom();
        userCustom.setUsername("son");
        userQueryVo.setUserCustom(userCustom);
        List<User> users = userMapper.findUserList(userQueryVo);

        sqlSession.close();
        System.out.println(users);
    }

    @Test
    public void findUserCount() throws Exception{
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVo userQueryVo=new UserQueryVo();
        UserCustom userCustom = new UserCustom();

        userCustom.setUsername("r");
        userQueryVo.setUserCustom(userCustom);
        int count = userMapper.findUserCount(userQueryVo);

        sqlSession.close();
        System.out.println("The count is + " + count);
    }



}
