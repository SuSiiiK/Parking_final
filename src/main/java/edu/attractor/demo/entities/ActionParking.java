package edu.attractor.demo.entities;

import edu.attractor.demo.enums.ActionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ActionParking extends BaseEntity {

    private LocalDateTime time;

    private Integer numberOfCar;

    private Long place;

    private String imagePath;

    private ActionType actionType;

}
