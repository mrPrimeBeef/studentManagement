package dat.DAO;

import dat.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class PersonDao {
    private EntityManagerFactory emf;
    private static PersonDao PERSON_DAO;

    private PersonDao(EntityManagerFactory emf){
        this.emf = emf;
    }

    public static PersonDao getInstance(EntityManagerFactory emf){
        if (PERSON_DAO == null){
            PERSON_DAO = new PersonDao(emf);
        }
        return PERSON_DAO;
    }

    public void createPerson(Person person){
        try (EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        }
    }
}
