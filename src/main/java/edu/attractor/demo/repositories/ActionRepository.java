package edu.attractor.demo.repositories;

import edu.attractor.demo.entities.ActionParking;
import edu.attractor.demo.entities.Place;
import edu.attractor.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActionRepository extends JpaRepository<ActionParking, Long> {
    Optional<ActionParking> findById(Long id);

    List<ActionParking>findByPlace(Long place);
}
