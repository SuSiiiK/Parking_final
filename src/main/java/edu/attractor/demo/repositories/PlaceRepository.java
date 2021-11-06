package edu.attractor.demo.repositories;

import edu.attractor.demo.entities.Place;
import edu.attractor.demo.entities.State;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place,Long> {
  Optional<Place>findFirstByState(State state);
  Optional<Place> findById(Long id);
  List<Place>findAll();
}
