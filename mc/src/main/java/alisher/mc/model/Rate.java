package alisher.mc.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rate")
@ToString
@Getter
@Setter

public class Rate {
    @Id
    @Column(name="rate_id")
    private Integer rate_id;
    @Column(name="detail")
    private Integer detail;
    @Column(name="story")
    private Integer story;
    @Column(name="quality_of_drawing")
    private Integer quality_of_drawing;
    @ManyToOne
    @JoinColumn(name = "manga_id")
    private Manga manga;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name="comment")
    private String comment;
}
