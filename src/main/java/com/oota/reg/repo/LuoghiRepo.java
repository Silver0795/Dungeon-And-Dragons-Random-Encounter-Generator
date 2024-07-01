package com.oota.reg.repo;

import com.oota.reg.entities.Luoghi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LuoghiRepo extends JpaRepository<Luoghi, Long> {

}
