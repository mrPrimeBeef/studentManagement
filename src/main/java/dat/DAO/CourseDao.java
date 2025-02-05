package dat.DAO;

import jakarta.persistence.EntityManagerFactory;

public class CourseDao {
    private EntityManagerFactory emf;
    private static CourseDao COURSE_DAO;

    private CourseDao(EntityManagerFactory emf){
        this.emf = emf;
    }

    public static CourseDao getInstance(EntityManagerFactory emf){
        if (COURSE_DAO == null){
            COURSE_DAO = new CourseDao(emf);
        }
        return COURSE_DAO;
    }
}
