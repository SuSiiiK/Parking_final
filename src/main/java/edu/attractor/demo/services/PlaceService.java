package edu.attractor.demo.services;

import edu.attractor.demo.entities.Place;
import edu.attractor.demo.entities.State;
import edu.attractor.demo.repositories.PlaceRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;

    @PostConstruct
    public void makePlace(){
        int count ;
        this.placeRepository.deleteAll();
        for (count=1; count<31;count++){
            Place place = new Place();
            place.setNumber(count);
            place.setState(State.FREE);
            place.setNumberCar(0);
            this.placeRepository.save(place);
        }
    }
    public List<Place> getAll(){
        return this.placeRepository.findAll();
    }
}
