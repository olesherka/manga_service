package alisher.mc.model;
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
    @JoinColumn(name="manga_id")
    private Manga manga_id;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user_id;
    @Column(name="comment")
    private String comment;
}
