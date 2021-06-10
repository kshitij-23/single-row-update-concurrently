package com.ksh.singlerowupdateconcurrently.services;

import com.ksh.singlerowupdateconcurrently.model.Sequence;
import com.ksh.singlerowupdateconcurrently.repositories.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class SequenceService {

    @Autowired
    private SequenceRepository sequenceRepository;

    @Transactional
    public Long getNextSequenceNumber() {
        Sequence sequence = sequenceRepository.getById(1L);
        Long current = sequence.getSequenceCurrent();
        if(current != null) {
            current = current + 1;
        }
        sequence.setSequenceCurrent(current);
        sequence.setUpdatedTs(LocalDateTime.now());
        sequenceRepository.save(sequence);
        return current;
    }

}
