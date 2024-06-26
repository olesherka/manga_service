package alisher.mc.model;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;


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

}
