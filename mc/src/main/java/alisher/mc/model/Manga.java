package alisher.mc.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;
    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mangaka_id")
    private Mangaka mangaka;
    @JsonManagedReference
    @OneToMany(mappedBy = "rate_id")
    private List<Rate> rates = new ArrayList<>();

    @Override
    public String toString(){
        return "manga with id : " + manga_id + " { " +
                "id:" + manga_id + ", name:" + manga_name + ", rate:" + rate + ", year_of_issue:" +
                year_of_issue + ", genre id:" + genre.getGenre_id() + ", mangaka_id:" +
                mangaka.getMangaka_id() + /*", last comment:" + rates.get(rates.size()-1).getComment() +*/ " }";
    }
}
