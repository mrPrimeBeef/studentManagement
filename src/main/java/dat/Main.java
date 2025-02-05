package dat;

import dat.DAO.CourseDao;
import dat.DAO.PersonDao;
import dat.config.HibernateConfig;
import dat.entities.Course;
import dat.entities.Person;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        final EntityManagerFactory EMF = HibernateConfig.getEntityManagerFactory();

        Person person1 = new Person("Bent", "+4512345678", "b@b.b", 60, LocalDate.of(2020, 1, 1));
        Person person2 = new Person("Bent", "+4512345678", "b@b.b", 60, LocalDate.of(2020, 1, 1));
        Person person3 = new Person("Bent3", "+4512345678", "b@b.b", 60, LocalDate.of(2020, 1, 1));
        Course course1 = new Course("Datamatiker", "John", 1, "3.4D", LocalTime.of(9, 0, 0));
        Course course2 = new Course("Sports Management", "Jørn", 5, "4.1", LocalTime.of(12, 30, 0));
        Course course3 = new Course("Friskolen intro", "Birthe", 1, "48b", LocalTime.of(10, 0, 0));


        PersonDao pDao = PersonDao.getInstance(EMF);
        CourseDao cDao = CourseDao.getInstance(EMF);

        pDao.createPerson(person1);
        pDao.createPerson(person2);
        pDao.createPerson(person3);
        cDao.createCourse(course1);
        cDao.createCourse(course2);
        cDao.createCourse(course3);

        pDao.updatePersonPhone(person2, "+46123");
        cDao.updateCourse(course1, 2);

        pDao.deletePerson(person3);
        cDao.deleteCourse(course1);

        pDao.getAllPersons().forEach(System.out::println);

        cDao.getAllCourses().forEach(System.out::println);

        EMF.close();
    }
}