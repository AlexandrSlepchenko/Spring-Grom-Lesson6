package com.Lesson6.DAO.Implementation;

import com.Lesson6.DAO.PassengerDAO;
import com.Lesson6.Model.Passenger;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class PassengerDAOImpl extends GeneralDAOImpl<Passenger> implements PassengerDAO {

    public PassengerDAOImpl() {
        setClass(Passenger.class);
    }

    private static final String SELECT_REGULAR_PASSENGER = "SELECT * FROM PLANE WHERE " +
            "((select to_number(to_char(sysdate, 'YYYY')) from dual)- year_produced) > 20";

    public List getOldPlanes() {
        Query query = entityManager.createNativeQuery(SELECT_REGULAR_PASSENGER, Passenger.class);
        return query.getResultList();
    }
}
