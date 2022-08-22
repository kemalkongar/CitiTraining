package org.finalproject.spring.boot.repo;
import org.finalproject.spring.boot.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order getById(int id);
    List<Order> getBySecurityId(int sid);
    List<Order> getByOrderType(String orderType);
    void deleteById(int id);


}
