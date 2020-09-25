package com.Lesson6.Service.Implementation;

import com.Lesson6.DAO.FlightDAO;

import com.Lesson6.Model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl {
    FlightDAO flightDAO;

    @Autowired
    public FlightServiceImpl (FlightDAO flightDAO){
        this.flightDAO = flightDAO;
    }

    public Flight saveFlight(Flight flight){
        return flightDAO.save(flight);
    }

    public Flight updateFlight(Flight flight){
        return flightDAO.update(flight);
    }

    public void deleteFlight(Long id){
        flightDAO.deleteById(id);
    }

    public Flight findFlightById(Long id){
        return flightDAO.findById(id);
    }
}
