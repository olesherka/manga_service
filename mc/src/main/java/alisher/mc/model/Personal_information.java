package alisher.mc.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "personal_information")
@ToString
@Getter
@Setter

public class Personal_information {
    @Id
    @Column(name="personal_inf_id")
    private Integer personal_inf_id;
    @Column(name="user_name")
    private String name;
    @Column(name="user_lname")
    private String lname;
    @Column(name="user_age")
    private Integer user_age;
    @JsonManagedReference
    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user_id;
}
