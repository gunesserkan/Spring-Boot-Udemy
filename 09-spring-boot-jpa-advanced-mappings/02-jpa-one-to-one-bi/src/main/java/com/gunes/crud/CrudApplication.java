package com.gunes.crud;

import com.gunes.crud.dao.AppDao;
import com.gunes.crud.entity.Instructor;
import com.gunes.crud.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDao appDao) {
        return runner -> {
//			createInstructor(appDao);
//            findInstrutor(appDao);
//            deleteInstructor(appDao);
//            findInstrutorDetail(appDao);
            deleteInstructorDetail(appDao);
        };
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
