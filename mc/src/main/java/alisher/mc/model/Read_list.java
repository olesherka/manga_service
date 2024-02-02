package alisher.mc.model;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private Integer manga_id;
    @Column(name = "user_id")
    @JoinColumn(name = "user_id")
    private Integer user_id;
}
