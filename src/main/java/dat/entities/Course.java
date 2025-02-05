package dat.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String teacher;
    @Setter
    private int semester;
    private String classRoom;
    private LocalTime courseTime;

    @ManyToMany(mappedBy = "courses")
    List<Person> personList;

    public Course(String name, String teacher, int semester, String classRoom, LocalTime courseTime) {
        this.name = name;
        this.teacher = teacher;
        this.semester = semester;
        this.classRoom = classRoom;
        this.courseTime = courseTime;
    }
}