package com.Lesson6.Cpntroller;

import com.Lesson6.Model.Plane;
import com.Lesson6.Service.PlaneService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.Arrays;

@Controller
@RequestMapping("/plane")
public class PlaneController {

    PlaneService planeService;

    @Autowired
    public PlaneController(PlaneService planeService){
        this.planeService = planeService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/order", produces = "text/plain")
    public @ResponseBody
    String test() {
        return "ok";
    }

    @GetMapping("/Get")
    ResponseEntity<String> get(
            @RequestParam("id") long id) {
        try {
            return new ResponseEntity<>(planeService.findPlaneById(id).toString(), HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/Post")
    public @ResponseBody
    String save(InputStream dataStream){
        try {
            planeService.savePlane(new ObjectMapper().readValue(dataStream, Plane.class));
            return "Flight save" ;
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @PutMapping("/Put")
    public @ResponseBody
    String update(InputStream dataStream){
        try {
            planeService.updatePlane(new ObjectMapper().readValue(dataStream, Plane.class));
            return "Flight update";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @DeleteMapping("/Delete")
    ResponseEntity<String> delete(
            @RequestParam("id") long id) {
        try{
            planeService.deletePlane(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
