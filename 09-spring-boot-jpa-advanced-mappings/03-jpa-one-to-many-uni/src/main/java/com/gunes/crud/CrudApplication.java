package com.gunes.crud;

import com.gunes.crud.dao.AppDao;
import com.gunes.crud.entity.Course;
import com.gunes.crud.entity.Instructor;
import com.gunes.crud.entity.InstructorDetail;
import com.gunes.crud.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao) {
        return runner -> {
//            createCourseAndReviews(appDao);
//            retrieveCourseAndReviews(appDao);
            deleteCourseAndReviews(appDao);
        };
    }

    private void deleteCourseAndReviews(AppDao appDao) {
        int theId=10;
        System.out.println("Deleting course id: "+theId);

        appDao.deleteCourseById(theId);

        System.out.println("Done");
    }

    private void retrieveCourseAndReviews(AppDao appDao) {
        int theId=10;
        Course tempCourse=appDao.findCourseAndReviewsByCourseId(theId);

        System.out.println(tempCourse);

        System.out.println(tempCourse.getReviews());

        System.out.println("Done");
    }

    private void createCourseAndReviews(AppDao appDao) {

        Course tempCourse=new Course("Hibernate");

        tempCourse.addReview(new Review("This course is amazing :)"));
        tempCourse.addReview(new Review("You should take this course"));
        tempCourse.addReview(new Review("I love that course"));

        System.out.println("Saving the course");

        System.out.println(tempCourse);

        System.out.println(tempCourse.getReviews());

        appDao.save(tempCourse);

        System.out.println("Done");
    }

    private void updateInstructor(AppDao appDao) {
        int theId=1;
        Instructor tempInstructor=appDao.findInstructorById(theId);
        tempInstructor.setLastName("Tester");

        appDao.update(tempInstructor);

        System.out.println("Done");
    }

    private void findInstructorWithCoursesJoinFetch(AppDao appDao) {
        int theId=1;

        System.out.println("Finding instructor id: "+theId);
        Instructor tempInstructor = appDao.findInstructorByIdJoinFetch(theId);

        System.out.println("tempInstructor: "+tempInstructor);
        System.out.println("the associated courses: "+tempInstructor.getCourses());

        System.out.println("Done");
    }

    private void findCoursesForInstructor(AppDao appDao) {

        int theId = 1;
        System.out.println("Finding instructor id: "+theId);

        Instructor tempInstructor=appDao.findInstructorById(theId);

        System.out.println("tempInstructor: "+tempInstructor);

        List<Course> courses= appDao.findCourseByInstructorId(theId);

        tempInstructor.setCourses(courses);

        System.out.println("the associated courses"+tempInstructor.getCourses());

        System.out.println("Done");

    }

    private void findInstructorWithCourses(AppDao appDao) {

        int theId = 1;
        System.out.println("Finding instructor id: "+theId);

        Instructor tempInstructor=appDao.findInstructorById(theId);

        System.out.println("tempInstructor: "+tempInstructor);
        System.out.println("the associated courses: "+tempInstructor.getCourses());

        System.out.println("Done");
    }

    private void createInstructorWithCourses(AppDao appDao) {

        Instructor tempInstructor =
                new Instructor("test name2", "test surname2", "test2@gmail.com");
        InstructorDetail tempInstructorDeatil =
                new InstructorDetail(
                        "www.test-site2.com",
                        "series2"
                );
        tempInstructor.setInstrustorDetail(tempInstructorDeatil);

        Course tempCourse1=new Course("java");
        Course tempCourse2=new Course("C#");

        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        System.out.println("Svaing Instructor: "+tempInstructor);
        System.out.println("The courses: "+tempInstructor.getCourses());
        appDao.save(tempInstructor);
    }

    private void deleteInstructorDetail(AppDao appDao) {
        int theid=3;
        System.out.println("Deleting instructor detail id: "+theid);

        appDao.deleteInstructorDetailById(theid);

        System.out.println("Done");
    }

    private void findInstrutorDetail(AppDao appDao) {
        int theId=2;
        InstructorDetail tempInstructorDetail = appDao.findInstructorDetailById(theId);

        System.out.println("tempInstructorDetail="+tempInstructorDetail);

        System.out.println("the associated instructor="+tempInstructorDetail.getInstructor());

        System.out.println("Done");
    }
    private void deleteInstructor(AppDao appDao){

        int theid=1;
        System.out.println("Deleting instructor id: "+theid);

        appDao.deleteInstructorById(theid);

        System.out.println("Done");
    }

    private void findInstrutor(AppDao appDao) {

        int theId = 2;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDao.findInstructorById(theId);
        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associated instructorDetail only: " + tempInstructor.getInstrustorDetail());
    }

    private void createInstructor(AppDao appDao) {
        Instructor tempInstructor =
                new Instructor("test name", "test surname", "test@gmail.com");
        InstructorDetail tempInstructorDeatil =
                new InstructorDetail(
                        "www.test-site.com",
                        "series"
                );
        tempInstructor.setInstrustorDetail(tempInstructorDeatil);

        System.out.println("Saving instructor: " + tempInstructor);
        appDao.save(tempInstructor);
        System.out.println("Done");
    }
}
