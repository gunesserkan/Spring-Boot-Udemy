package com.gunes.crud.dao;

import com.gunes.crud.entity.Course;
import com.gunes.crud.entity.Instructor;
import com.gunes.crud.entity.InstructorDetail;

import java.util.List;


public interface AppDao {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCourseByInstructorId(int theId);

    void deleteCourseById(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);

    void save(Course theCourse);

    Course findCourseAndReviewsByCourseId(int theId);
}
