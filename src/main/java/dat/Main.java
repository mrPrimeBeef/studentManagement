package dat;

import dat.DAO.PersonDao;
import dat.config.HibernateConfig;
import dat.entities.Person;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        final EntityManagerFactory EMF = HibernateConfig.getEntityManagerFactory();

        Person person1 = new Person("Bent","+4512345678","b@b.b",60, LocalDate.of(2020,1,1));

        PersonDao dao = PersonDao.getInstance(EMF);

        dao.createPerson(person1);

        EMF.close();
    }
}