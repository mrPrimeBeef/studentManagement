package dat.DAO;

import dat.entities.Course;
import dat.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CourseDao {
    private EntityManagerFactory emf;
    private static CourseDao COURSE_DAO;

    private CourseDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public static CourseDao getInstance(EntityManagerFactory emf) {
        if (COURSE_DAO == null) {
            COURSE_DAO = new CourseDao(emf);
        }
        return COURSE_DAO;
    }

    public Course createCourse(Course course) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
            return course;
        }
    }

    public void updateCourse(Course course, int newSemester) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            course.setSemester(newSemester);
            em.merge(course);
            em.getTransaction().commit();
        }
    }

    public Course deleteCourse(Course course) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.remove(course);
            em.getTransaction().commit();
            return course;
        }
    }

    public List<Course> getAllCourses() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c", Course.class);
            return query.getResultList();
        }
    }
}