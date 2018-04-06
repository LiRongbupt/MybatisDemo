package test;

import domain.OrderCustom;
import domain.Orders;
import mapper.OrdersMapperCustom;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DuoTables {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource = "SqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Ignore
    public void testFindOrderUserList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);

        List<OrderCustom> list = ordersMapperCustom.findOrderUserList();
        sqlSession.close();

        System.out.println(list);
    }

    @Test
    public void testFindOrderUserListResultMap() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrdersMapperCustom ordersMapperCustom=sqlSession.getMapper(OrdersMapperCustom.class);
        List<Orders> list = ordersMapperCustom.findOrderUserListResultMap();
        for (Orders o :
                list) {
            System.out.println(o.getNote());
        }
    }
}
