package org.finalproject.spring.boot.repo;

import org.finalproject.spring.boot.entities.Holdings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoldingsRepository extends JpaRepository<Holdings, Integer> {
    Holdings getById(Integer id);

    Holdings getBySecurity(Integer security);

    Holdings getBySecurityTicker(String security_ticker);

    Holdings getBySecurityName(String security_name);

    List<Holdings> findByBuyPriceBetween(double min, double max);

    @Query(value="SELECT lot FROM Holdings WHERE security=?1 ;",nativeQuery = true)
    int getLotFromSid(int sid);

    @Query(value="SELECT id FROM Holdings WHERE security=?1 ;",nativeQuery = true)
    int getIdFromSid(int sid);

    @Query(value="SELECT count(*) FROM Holdings WHERE security=?1 ;",nativeQuery = true)
    int checkIfSecurityExist(int sid);
}
