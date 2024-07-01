package com.oota.reg.repo;

import com.oota.reg.entities.IncontriCreature;
import com.oota.reg.entities.Luoghi;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncontriCreatureRepo extends JpaRepository<IncontriCreature, Long> {
    List<IncontriCreature> findAllByidLuogo(Luoghi id);
}
