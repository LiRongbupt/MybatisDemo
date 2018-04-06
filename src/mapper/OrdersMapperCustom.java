package mapper;

import domain.OrderCustom;
import domain.Orders;

import java.util.List;

public interface OrdersMapperCustom {
    List<OrderCustom> findOrderUserList() throws Exception;

    List<Orders> findOrderUserListResultMap() throws Exception;

}
