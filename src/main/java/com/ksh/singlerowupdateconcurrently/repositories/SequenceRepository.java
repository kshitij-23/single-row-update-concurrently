package com.ksh.singlerowupdateconcurrently.repositories;

import com.ksh.singlerowupdateconcurrently.model.Sequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceRepository extends JpaRepository<Sequence, Long> {
}
