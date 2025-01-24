package bbn.WpsApp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Wpqr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;

    private String description;

    @OneToOne(mappedBy = "idWPQR", cascade=CascadeType.ALL, orphanRemoval = true)
    private Wps wps;
}
