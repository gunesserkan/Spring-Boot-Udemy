package com.gunes.crud.dao;

import com.gunes.crud.entity.Instructor;
import com.gunes.crud.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
