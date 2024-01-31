package alisher.mc.model;
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
    public Integer getPersonal_inf_id() {
        return personal_inf_id;
    }

    @Id
    @Column(name="personal_inf_id")
    private int personal_inf_id;
    @Column(name="name")
    private String name;
    @Column(name="lname")
    private String lname;
    @Column(name="user_age")
    private int user_age;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user_id;
}
