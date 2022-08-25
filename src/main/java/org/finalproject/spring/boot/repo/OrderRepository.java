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

//    @Query(value="SELECT ticker FROM Securities WHERE id=?1 ;",nativeQuery = true)
//    String getSecurityNameBySecurityId(int sid);

    @Query(value="SELECT ticker FROM Securities WHERE id=?1 ;",nativeQuery = true)
    String getTickerBySecurityId(int sid);
}
