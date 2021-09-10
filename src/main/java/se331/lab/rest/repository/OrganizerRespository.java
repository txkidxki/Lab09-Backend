package se331.lab.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.entity.Organizer;

public interface OrganizerRespository extends JpaRepository<Organizer,Long> {

}