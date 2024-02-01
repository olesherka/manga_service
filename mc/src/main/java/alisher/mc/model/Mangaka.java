package alisher.mc.model;

import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mangaka")
@ToString
@Getter
@Setter

public class Mangaka {
    @Id
    @Column(name="mangaka_id")
    private Integer mangaka_id;
    @Column(name="name")
    private String name;
    @Column(name="lname")
    private String lname;
    @Column(name="age")
    private Integer age;
}
