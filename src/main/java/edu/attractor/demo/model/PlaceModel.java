package edu.attractor.demo.model;

import edu.attractor.demo.entities.State;
import lombok.Data;

@Data
public class PlaceModel {
    private Integer number;

    private State state;

    private int numberOfCar;
}
