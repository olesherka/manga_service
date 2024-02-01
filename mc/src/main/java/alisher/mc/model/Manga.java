package alisher.mc.model;

import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "manga")
@ToString
@Getter
@Setter
public class Manga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="manga_id", nullable = false, updatable = false)
    private Integer manga_id;
    @Column(name="manga_name")
    private String manga_name;
    @Column(name="rate")
    private int rate;
    @Column(name="year_of_issue")
    private LocalDateTime year_of_issue;
    @OneToOne()
    private Genre genre;
    @OneToOne()
    private Mangaka mangaka;
    @OneToMany(mappedBy = "rate_id")
    private List<Rate> rates = new ArrayList<>();
}
