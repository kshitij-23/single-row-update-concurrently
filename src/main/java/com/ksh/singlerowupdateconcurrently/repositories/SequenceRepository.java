package com.ksh.singlerowupdateconcurrently.repositories;

import com.ksh.singlerowupdateconcurrently.model.Sequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;

@Repository
public interface SequenceRepository extends JpaRepository<Sequence, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Transactional
    @Query("select s from Sequence s where s.id = ?1")
    Sequence getById(Long aLong);

    @Modifying
    @Query("update Sequence s set s.sequenceCurrent = ?1 where s.id = ?2")
    int updateCurrentValue(long currentValue, long id);
}
