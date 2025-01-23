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
    @Column
    private String name;
    @Column
    private String manufacturer;
    @Column
    private String inspectionAgency;
    @Column
    private Integer numberWPQR;
    @Column
    private String cleaning;
    @Column
    private Integer weldingProcedure;
    @Column
    private WeldingType weldingType;
    @Column
    private WeldingPosition weldingPosition;
    @Column
    private String fillerMaterial;
    @Column
    private Float materialThickness2;
    @Column
    private Float materialThickness1;
    @Column
    private Float outsideDiameter1;
    @Column
    private Float outsideDiameter2;
    @Column
    private String backingGas;
    @Column
    private Float backingGasFlowRate;
    @Column
    private String specificationOfBaseMaterial;
    @Column
    private String groupOfAdditionalMaterial;
    @Column
    private String imgWeldingDesign;
    @Column
    private String imgWeldingTechnique;
    @Column
    private float weldSize;
    @Column
    @OneToMany
    private List<WeldingParameters> weldingParametersList;
    @Column
    private String note;

    @Column(name = "created_at", updatable = false, nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;


}
