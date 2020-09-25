package com.Lesson6.Service;

import com.Lesson6.Model.Plane;

public interface PlaneService {

    Plane save(Plane plane);
    Plane update(Plane plane);
    void delete(Long id);
    Plane findById(Long id);

}
