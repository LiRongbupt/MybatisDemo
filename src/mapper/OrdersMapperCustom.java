package mapper;

import domain.OrderCustom;

import java.util.List;

public interface OrdersMapperCustom {
    public List<OrderCustom> findOrderUserList() throws Exception;
}
