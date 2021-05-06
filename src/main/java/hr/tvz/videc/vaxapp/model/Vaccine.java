package hr.tvz.videc.vaxapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Vaccine")
public class Vaccine {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "vaxName")
    private String vaxName;

    @Column(name = "compName")
    private String compName;

    @Column(name = "type")
    private String type;

    @Column(name = "neededDoses")
    private int neededDoses;

    @Column(name = "warehouseDoses")
    private long warehouseDoses;

//    @Column(name = "sideEffectId")
//    @Enumerated(EnumType.STRING)
//    @JoinTable(name = "SideEffect", joinColumns = @JoinColumn(name = "vaxName"))
//    @JoinColumn(name = "id")
//    private Long sideEffectId;

    public Vaccine(String vaxName, String compName, String type, int neededDoses, long warehouseDoses) {
        this.vaxName = vaxName;
        this.compName = compName;
        this.type = type;
        this.neededDoses = neededDoses;
        this.warehouseDoses = warehouseDoses;
    }

    public Vaccine(){}

    public void setVaxName(String vaxName) {
        this.vaxName = vaxName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNeededDoses(int neededDoses) {
        this.neededDoses = neededDoses;
    }

    public void setWarehouseDoses(long warehouseDoses) {
        this.warehouseDoses = warehouseDoses;
    }

    public void setId(Long id) { this.id = id; }

    public String getVaxName() {
        return vaxName;
    }

    public String getCompName() {
        return compName;
    }

    public String getType() {
        return type;
    }

    public int getNeededDoses() {
        return neededDoses;
    }

    public long getWarehouseDoses() {
        return warehouseDoses;
    }

    @Id
    public Long getId() { return id; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vaccine)) return false;
        Vaccine vaccine = (Vaccine) o;
        return getNeededDoses() == vaccine.getNeededDoses() && getWarehouseDoses() == vaccine.getWarehouseDoses() && getId().equals(vaccine.getId()) && getVaxName().equals(vaccine.getVaxName()) && getCompName().equals(vaccine.getCompName()) && getType().equals(vaccine.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVaxName(), getCompName(), getType(), getNeededDoses(), getWarehouseDoses());
    }


}
