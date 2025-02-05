package dat.DAO;

import dat.entities.Course;
import dat.entities.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PersonDao {
    private EntityManagerFactory emf;
    private static PersonDao PERSON_DAO;

    private PersonDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public static PersonDao getInstance(EntityManagerFactory emf) {
        if (PERSON_DAO == null) {
            PERSON_DAO = new PersonDao(emf);
        }
        return PERSON_DAO;
    }

    public void createPerson(Person person) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        }
    }

    public Person updatePersonPhone(Person person, String phone) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            person.setPhone(phone);
            Person updatedPerson = em.merge(person);
            em.getTransaction().commit();
            return updatedPerson;
        }
    }
    public Person deletePerson(Person person){
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            em.remove(person);
            em.getTransaction().commit();
            return person;
        }
    }
    public List<Person> getAllPersons(){
        try(EntityManager em = emf.createEntityManager()){
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
            List<Person> listOfPersons = query.getResultList();
            return listOfPersons;
        }
    }

    public List<Course> getAllCoursesForPerson(int personId){
        try(EntityManager em = emf.createEntityManager()){
            TypedQuery<Course> query = em.createQuery(
                    "SELECT c FROM Course c JOIN c.personList p WHERE p.id = :personId",
                    Course.class
            );
            query.setParameter("personId", personId);
            return query.getResultList();
        }
    }
}
