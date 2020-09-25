package com.Lesson6.Cpntroller;

import com.Lesson6.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping("/flight")
public class FlightController {

    FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService){
        this.flightService = flightService;
    }

    @DeleteMapping("/DeleteFlight")
    ResponseEntity<String> delete(
            @RequestParam("longId") long id) {
        try{
            flightService.deleteFlight(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
