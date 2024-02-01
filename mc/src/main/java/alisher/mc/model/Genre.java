package alisher.mc.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


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
    @JsonBackReference
    @OneToOne(mappedBy = "genre")
    private Manga manga;
}
