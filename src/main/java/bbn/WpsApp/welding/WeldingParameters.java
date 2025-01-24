package bbn.WpsApp.welding;

import bbn.WpsApp.entity.Wps;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class WeldingParameters {

    @Id
    private Integer id;

    private String parameterName;

    private String value;

    @ManyToOne
    @JoinColumn(name="wps_id")
    private Wps wps;
}
