package dat.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Setter
    private String phone;
    private String email;
    private int age;
    private LocalDate enrollmentDate;

    public Person(String name, String phone, String email, int age, LocalDate enrollmentDate) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.age = age;
        this.enrollmentDate = enrollmentDate;
    }
}
