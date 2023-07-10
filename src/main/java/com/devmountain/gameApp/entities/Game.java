package com.devmountain.gameApp.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*import javax.persistence.*;*/

@Entity
@Table(name = "Games")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String imageUrl;

    @Column(columnDefinition = "text")
    private String name;

    @Column(columnDefinition = "text")
    private String genre;

    @Column(columnDefinition = "text")
    private String platform;

    @Column(columnDefinition = "varchar(255)")
    private Integer cost;

    @ManyToOne
    @JsonBackReference
    private User user;



}
