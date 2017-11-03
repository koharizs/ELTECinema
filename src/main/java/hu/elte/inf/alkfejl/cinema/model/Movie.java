package hu.elte.inf.alkfejl.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hu.elte.inf.alkfejl.cinema.enums.AgeLimit;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Movie")
@Table(name = "MOVIES")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie implements ModelInterface {

    @Id
    @Column(name = "MOVIE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private Integer id;

    @Column(name = "TITLE", nullable = false)
    @Getter @Setter private String title;

    @Column(name = "DUBBED", nullable = false)
    @Getter @Setter  private Boolean dubbed;

    @Column(name = "DIRECTOR", nullable = false)
    @Getter @Setter private String director;

    @Column(name = "STORY", nullable = false)
    @Getter @Setter private String story;

    @Column(name = "LENGTH", nullable = false)
    @Getter @Setter private Integer length;

    @Enumerated(EnumType.STRING)
    @Column(name = "AGE_LIMIT", nullable = false)
    @Getter @Setter private AgeLimit ageLimit;

    @Column(name = "TICKET_SOLD")
    @Getter @Setter private Integer ticketSold;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "ACTOR_MOVIE", joinColumns = {
            @JoinColumn(name = "ACTOR_ID", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "MOVIE_ID",
                    nullable = false, updatable = false) })
    @JsonIgnore
    @Getter @Setter private List<Actor> actors;

    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    @Getter @Setter private List<Screening> screenings;

}
