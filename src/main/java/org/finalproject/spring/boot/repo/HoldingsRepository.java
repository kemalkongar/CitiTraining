package org.finalproject.spring.boot.repo;

import org.finalproject.spring.boot.entities.Holdings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HoldingsRepository extends JpaRepository<Holdings, Integer> {
    Holdings getById(Integer id);
    List<Holdings> getBySecurity(Integer security);
    List<Holdings>  getByLot(Integer lot);
    List<Holdings>  findByBuyPriceBetween(double min, double max);
}
