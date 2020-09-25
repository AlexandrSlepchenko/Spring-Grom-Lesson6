package com.Lesson6.Service.Implementation;

import com.Lesson6.DAO.PassengerDAO;
import com.Lesson6.Model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl {
    PassengerDAO passengerDAO;

    @Autowired
    public PassengerServiceImpl (PassengerDAO passengerDAO){
        this.passengerDAO = passengerDAO;
    }

    public Passenger save(Passenger passenger){
        return passengerDAO.save(passenger);
    }

    public Passenger update(Passenger passenger){
        return passengerDAO.update(passenger);
    }

    public void delete(Long id){
        passengerDAO.deleteById(id);
    }

    public Passenger findPassengerById(Long id){
        return passengerDAO.findById(id);
    }
}
