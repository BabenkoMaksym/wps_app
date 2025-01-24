package bbn.WpsApp.entity;

import bbn.WpsApp.welding.WeldingParameters;
import bbn.WpsApp.welding.WeldingPosition;
import bbn.WpsApp.welding.WeldingType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Wps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String manufacturer;
    private String inspectionAgency;
    @OneToOne
    @JoinColumn(name="wpqr", referencedColumnName = "id")
    private Wpqr idWPQR;
    private String cleaning;
    @Column(name="weld_proc")
    private Integer weldingProcedure;
    @Enumerated(EnumType.STRING)
    @Column(name="weld_type")
    private WeldingType weldingType;
    @Enumerated(EnumType.STRING)
    private WeldingPosition weldingPosition;
    private String fillerMaterial;
    private Float materialThickness2;
    private Float materialThickness1;
    private Float outsideDiameter1;
    private Float outsideDiameter2;
    private String backingGas;
    private Float backingGasFlowRate;
    private String specificationOfBaseMaterial;
    private String groupOfAdditionalMaterial;
    private String imgWeldingDesign;
    private String imgWeldingTechnique;
    private float weldSize;

    @OneToMany(mappedBy = "wps", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<WeldingParameters> weldingParametersList;
    private String note;

    @Column(name = "created_at", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;


}
