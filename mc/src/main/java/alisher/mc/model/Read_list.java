package alisher.mc.model;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;


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
    private int read_list_id;
    @ManyToOne
    @JoinColumn(name="manga_id")
    private Manga manga_id;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user_id;
}
