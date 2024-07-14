package com.gunes.crud.dao;

import com.gunes.crud.entity.Instructor;
import com.gunes.crud.entity.InstructorDetail;


public interface AppDao {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}
