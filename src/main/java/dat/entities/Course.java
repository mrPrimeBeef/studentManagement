package dat.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalTime;

@Getter
@NoArgsConstructor
@ToString
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String teacher;
    private int semester;
    private String classRoom;
    private LocalTime courseTime;

    public Course(String name, String teacher, int semester, String classRoom, LocalTime courseTime) {
        this.name = name;
        this.teacher = teacher;
        this.semester = semester;
        this.classRoom = classRoom;
        this.courseTime = courseTime;
    }
}