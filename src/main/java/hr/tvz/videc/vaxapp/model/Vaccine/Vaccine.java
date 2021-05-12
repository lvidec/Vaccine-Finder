package hr.tvz.videc.vaxapp.model.Vaccine;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Vaccine {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String researchName;

    @Column
    private String manufacturerName;

    @Column
    private String type;

    @Column
    private int numberOfShots;

    @Column
    private long availableDoses;


    public Vaccine(String researchName, String manufacturerName, String type, int numberOfShots, long availableDoses) {
        this.researchName = researchName;
        this.manufacturerName = manufacturerName;
        this.type = type;
        this.numberOfShots = numberOfShots;
        this.availableDoses = availableDoses;
    }

    public Vaccine(){}

    public void setResearchName(String researchName) {
        this.researchName = researchName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNumberOfShots(int numberOfShots) {
        this.numberOfShots = numberOfShots;
    }

    public void setAvailableDoses(long availableDoses) {
        this.availableDoses = availableDoses;
    }

    public void setId(Long id) { this.id = id; }

    public String getResearchName() {
        return researchName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getType() {
        return type;
    }

    public int getNumberOfShots() {
        return numberOfShots;
    }

    public long getAvailableDoses() {
        return availableDoses;
    }

    public Long getId() { return id; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vaccine)) return false;
        Vaccine vaccine = (Vaccine) o;
        return getNumberOfShots() == vaccine.getNumberOfShots() && getAvailableDoses() == vaccine.getAvailableDoses() && getId().equals(vaccine.getId()) && getResearchName().equals(vaccine.getResearchName()) && getManufacturerName().equals(vaccine.getManufacturerName()) && getType().equals(vaccine.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getResearchName(), getManufacturerName(), getType(), getNumberOfShots(), getAvailableDoses());
    }


}
