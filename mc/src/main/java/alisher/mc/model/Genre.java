package alisher.mc.model;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "genre")
@ToString
@Getter
@Setter

public class Genre {
    @Id
    @Column(name="genre_id")
    private Integer genre_id;
    @Column(name="genre_name")
    private String genre_name;
}
