package dat.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
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

    @ManyToMany
    @JoinTable(
            name = "link_person_course",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new ArrayList<>();

    private LocalDate enrollmentDate;

    public Person(String name, String phone, String email, int age, LocalDate enrollmentDate) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.age = age;
        this.enrollmentDate = enrollmentDate;
    }
}
