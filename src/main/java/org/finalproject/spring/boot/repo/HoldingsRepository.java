package org.finalproject.spring.boot.repo;

import org.finalproject.spring.boot.entities.Holdings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoldingsRepository extends JpaRepository<Holdings, Integer> {
    Holdings getById(Integer id);
    Holdings getBySecurity(Integer security);
    Holdings getByLot(Integer lot);
}
