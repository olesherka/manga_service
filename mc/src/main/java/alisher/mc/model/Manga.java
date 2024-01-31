package alisher.mc.model;

import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;


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
    @Column(name="manga_id")
    private Integer manga_id;
    @Column(name="manga_name")
    private String manga_name;
    @Column(name="rate")
    private int rate;
    @Column(name="year_of_issue")
    private LocalDateTime year_of_issue;
    @ManyToOne
    @JoinColumn(name="genre_id")
    private Genre genre;
    @OneToOne
    @JoinColumn(name="mangaka_id")
    private Mangaka mangaka;
}
