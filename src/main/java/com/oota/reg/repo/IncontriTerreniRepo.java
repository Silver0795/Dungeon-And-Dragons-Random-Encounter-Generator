package com.oota.reg.repo;

import com.oota.reg.entities.IncontriTerreni;
import com.oota.reg.entities.Luoghi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncontriTerreniRepo extends JpaRepository<IncontriTerreni,Long> {
    List<IncontriTerreni> findAllByidLuogo(Luoghi id);
}
