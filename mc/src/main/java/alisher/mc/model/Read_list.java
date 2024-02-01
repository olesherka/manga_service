package alisher.mc.model;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "read_list")
@ToString
@Getter
@Setter
public class Read_list {
    @Id
    @Column(name="read_list_id")
    private Integer read_list_id;
    @Column(name = "manga_id")
    @OneToMany(mappedBy = "manga_id")
    List <Manga> manga_id;
}
