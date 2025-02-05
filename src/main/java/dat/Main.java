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
        Person person2 = new Person("Bent","+4512345678","b@b.b",60, LocalDate.of(2020,1,1));
        Person person3 = new Person("Bent3","+4512345678","b@b.b",60, LocalDate.of(2020,1,1));

        PersonDao dao = PersonDao.getInstance(EMF);

        dao.createPerson(person1);
        dao.createPerson(person2);
        dao.createPerson(person3);
        System.out.println(person1.getId());


        dao.updatePersonPhone(person2,"+46123");

        EMF.close();
    }
}