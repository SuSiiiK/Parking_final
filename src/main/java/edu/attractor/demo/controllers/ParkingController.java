package edu.attractor.demo.controllers;

import edu.attractor.demo.entities.ActionParking;
import edu.attractor.demo.entities.Place;
import edu.attractor.demo.entities.State;
import edu.attractor.demo.services.ActionService;
import edu.attractor.demo.services.PlaceService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.*;
import java.util.List;

@Controller
@RequestMapping("/parking")
@AllArgsConstructor
@Data
public class ParkingController {
    private final PlaceService placeService;
    private final ActionService actionService;


    @GetMapping()
    public String parking(Model model) {
         List<Place> list = placeService.getAll();
         Integer free = 0;
        Integer busy = 0;
         for (Place place:list
              ) {
             if (place.getState()== State.BUSY) busy+=1;
            if(place.getState()== State.FREE) free+=1;
         }
         model.addAttribute("free", free);
         model.addAttribute("busy", busy);
         model.addAttribute("places", list);
         return "main/main";
     }

     @GetMapping("/parkingIn/{id}")
    public String getFormOfParking (@PathVariable Long id,Model model){
        model.addAttribute("id",id);
        return "main/add";
     }

     @PostMapping("/parkingIn/{id}")
    public String makeParking(@RequestParam MultipartFile multipartFile, @RequestParam String action, @RequestParam Integer numberOfCar,@PathVariable Long id){
        if(action.equals("1")){
            actionService.addActionIN(numberOfCar,multipartFile);
        }
        if (action.equals("0")){
            actionService.addActionOut(numberOfCar,multipartFile,id);
        }
        return"redirect:/parking";
     }

     @GetMapping("/displayParkingSpace/{id}")
     public String displayDetails(@PathVariable Long id,Model model){
        List<ActionParking> list = actionService.getByParkingId(id);
        model.addAttribute("num",id);
         model.addAttribute("spaceHistory",list);
         return "main/spacePage";
     }

}
