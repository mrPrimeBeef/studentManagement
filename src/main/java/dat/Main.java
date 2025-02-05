package dat;

import dat.DAO.PersonDao;
import dat.config.HibernateConfig;
import dat.entities.Person;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        final EntityManagerFactory EMF = HibernateConfig.getEntityManagerFactory();

        Person person1 = new Person("Bent",60);

        PersonDao dao = PersonDao.getInstance(EMF);

        dao.createPerson(person1);

        EMF.close();
    }
}