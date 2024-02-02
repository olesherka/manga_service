package alisher.mc.model;
import alisher.mc.repository.PersonalInformationRepository;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "service_user")
@ToString
@Getter
@Setter

public class User {
    @Id
    @Column(name="user_id")
    private Integer user_id;
    @Column(name="user_nickname")
    private String user_nickname;
    @Column(name="level")
    private Integer level;
    @Column(name="total_read")
    private Integer total_read;
    @JsonBackReference
    @OneToMany(mappedBy = "rate_id")
    private List<Rate> rates;
    @JsonBackReference
    @OneToOne(mappedBy = "user_id")
    private Personal_information personalInformation;
}
