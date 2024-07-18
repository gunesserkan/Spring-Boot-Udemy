package com.gunes.crud.dao;

import com.gunes.crud.entity.Course;
import com.gunes.crud.entity.Instructor;
import com.gunes.crud.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDaoImpl implements AppDao {

    private EntityManager entityManager;

    public AppDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {

        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        List<Course> courses = tempInstructor.getCourses();

        for (Course course : courses) {
            course.setInstructor(null);
        }

        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {

        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        tempInstructorDetail.getInstructor().setInstrustorDetail(null);

        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCourseByInstructorId(int theId) {

        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id= :data", Course.class);
        query.setParameter("data", theId);

        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {

        Course tempCourse = entityManager.find(Course.class, theId);

        entityManager.remove(tempCourse);
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i "
                        + " JOIN FETCH i.courses "
                        + "JOIN FETCH i.instrustorDetail "
                        + " where i.id=:data ", Instructor.class
        );

        query.setParameter("data", theId);

        Instructor instructor = query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {

        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                        + "JOIN FETCH c.reviews "
                        + "where c.id= :data ", Course.class);
        query.setParameter("data", theId);

        Course course = query.getSingleResult();

        return course;
    }
}
