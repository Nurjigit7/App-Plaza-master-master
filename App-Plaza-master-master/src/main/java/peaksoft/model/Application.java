package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.model.enums.AppStatus;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "applications")
@Setter
@Getter
@NoArgsConstructor

public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String developer;
    private String version;
    @Enumerated(EnumType.STRING)
    private AppStatus appStatus;
    private String genreName;
    private LocalDate createDate;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "application_user",
            joinColumns = @JoinColumn(name = "application_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    List<User> users;





}
