package edu.attractor.demo.services;

import edu.attractor.demo.entities.ActionParking;
import edu.attractor.demo.entities.Place;
import edu.attractor.demo.entities.State;
import edu.attractor.demo.enums.ActionType;
import edu.attractor.demo.exceptions.NotFoundException;
import edu.attractor.demo.repositories.ActionRepository;
import edu.attractor.demo.repositories.PlaceRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ActionService {

    private final PlaceRepository placeRepository;
    private final ActionRepository actionRepository;
    private final String uploadPath = "upload/photo";

   public void addActionIN(Integer numberOfCar,  MultipartFile multipartFile){
       Place place = placeRepository.findFirstByState(State.FREE).orElseThrow(NotFoundException::new);
       ActionParking actionParking = new ActionParking();
       actionParking.setTime(LocalDateTime.now());
       actionParking.setNumberOfCar(numberOfCar);
       actionParking.setImagePath(uploadFile(multipartFile));
       actionParking.setActionType(ActionType.IN);
       actionParking.setPlace(place.getId());
       place.setState(State.BUSY);
       place.setNumberCar(numberOfCar);
       placeRepository.save(place);
       actionRepository.save(actionParking);
   }
    public void addActionOut(Integer numberOfCar,  MultipartFile multipartFile, Long id){
        Place place = placeRepository.findById(id).orElseThrow(NotFoundException::new);
        ActionParking actionParking = new ActionParking();
        actionParking.setTime(LocalDateTime.now());
        actionParking.setNumberOfCar(numberOfCar);
        actionParking.setActionType(ActionType.OUT);
        actionParking.setImagePath(uploadFile(multipartFile));
        actionParking.setPlace(place.getId());
        place.setState(State.FREE);
        place.setNumberCar(0);
        placeRepository.save(place);
        actionRepository.save(actionParking);
    }

    public String uploadFile( MultipartFile file)  {
        String filepath = "";
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File("C:/Users/SONY_Owner/IdeaProjects/Kirya_Parking/upload/photo").getAbsoluteFile();
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();
            try {
                file.transferTo(new File("C:/Users/SONY_Owner/IdeaProjects/Kirya_Parking/upload/photo" + "/" + resultFilename).getAbsoluteFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
            filepath=resultFilename;
        }
        return filepath;
    }

    public ActionParking getById(Long id) {
      return actionRepository.findById(id).orElseThrow(NotFoundException::new);
    }


    public List<ActionParking> getByParkingId(Long id){
        Place place = placeRepository.findById(id).orElseThrow(NotFoundException::new);
        return actionRepository.findByPlace(place.getId());
    }
}
