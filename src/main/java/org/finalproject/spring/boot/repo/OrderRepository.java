package org.finalproject.spring.boot.repo;
import org.finalproject.spring.boot.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order getById(int id);
    List<Order> getBySecurityId(int sid);
    List<Order> getByOrderType(String orderType);
    void deleteById(int id);


    @Query(value="SELECT Orders.order_type AS order_type, Securities.name AS security_name, Orders.quantity AS quantity, Orders.execute_price AS execute_price, Orders.order_status AS order_status\n" +
            "FROM Orders\n" +
            "LEFT JOIN Securities ON Orders.security_id=Securities.id;",nativeQuery = true)
    List<Order> findAllOrdersWithSecurityName();
}
