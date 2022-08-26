package org.finalproject.spring.boot.repo;

import org.finalproject.spring.boot.entities.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Integer> {
    Security getByName(String name);

    Security getByTicker(String ticker);

    Security getById(Integer id);

    @Query(value="SELECT t0 FROM Securities WHERE id=?1 ;",nativeQuery = true)
    double getCurrPriceFromSid(int sid);
}
