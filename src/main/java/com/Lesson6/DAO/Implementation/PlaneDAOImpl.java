package com.Lesson6.DAO.Implementation;

import com.Lesson6.DAO.PlaneDAO;
import com.Lesson6.Model.Plane;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class PlaneDAOImpl extends GeneralDAOImpl<Plane> implements PlaneDAO {

    public PlaneDAOImpl() {
        setClass(Plane.class);
    }

    private static final String SELECT_OLD_PLANES = "SELECT * FROM PLANE WHERE " +
            "((select to_number(to_char(sysdate, 'YYYY')) from dual)- year_produced) > 20";

    public List getOldPlanes() {
        Query query = entityManager.createNativeQuery(SELECT_OLD_PLANES, Plane.class);
        return query.getResultList();
    }

}

