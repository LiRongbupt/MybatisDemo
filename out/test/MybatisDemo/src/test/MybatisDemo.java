package test;

import domain.User;
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

public class MybatisDemo {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource="SqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user =null;
        try {
            user = sqlSession.selectOne("test.findUserById", 2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        System.out.println(user);
    }

    @Test
    public void testFindUserByName() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> user =null;
        try {
            user = sqlSession.selectList("test.findUserByName", "r");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        for (User u: user) {
            System.out.println(u.toString());
        }
    }

    @Ignore
    public void testInsertUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("someone");
        user.setSex("male");
        user.setBirthday(new Date());
        user.setAddress("shanghai");

        try {
            sqlSession.insert("test.insertUser",user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        System.out.println(user);
        System.out.println("insert successful");
    }

    @Test
    public void TestDeleteUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            sqlSession.delete("test.deleteUser",6);
            sqlSession.commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateUSer() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user1 = null;
        try {
            user1 = sqlSession.selectOne("test.findUserById", 2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        User user = new User();
        user.setId(2);
        user.setUsername("LoveNan");
        user.setAddress(user1.getAddress());
        user.setBirthday(user1.getBirthday());
        user.setSex(user1.getSex());
        try {
            sqlSession.update("test.updateUser",user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}

