package se331.lab.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.entity.Participant;

public interface PaticipantRepository extends JpaRepository<Participant,Long> {
}
