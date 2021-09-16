package se331.lab.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Participant;

import java.util.Optional;

@Repository
public class ParticipantDaoImpl implements ParticipantDao{
    @Autowired
    PaticipantRepository paticipantRepository;


    @Override
    public Page<Participant> getParticipant(Pageable pageRequest) {
        return paticipantRepository.findAll(pageRequest);
    }

    @Override
    public Optional<Participant> findById(Long id) {
        return paticipantRepository.findById(id);
    }
}
