package hr.tvz.videc.vaxapp.model.SideEffect;

import hr.tvz.videc.vaxapp.model.Vaccine.Vaccine;

import javax.persistence.*;

@Entity
@Table(name = "SideEffect")
public class SideEffect {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String shortDesc;

    @Column
    private String longDesc;

    @Column
    private float frequency;

    @ManyToOne
    @JoinColumn(name = "vaccine_id", nullable = false)
    private Vaccine vaccine;

    public SideEffect(String shortDesc, String longDesc, float frequency, Vaccine vaccine) {
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.frequency = frequency;
        this.vaccine = vaccine;
    }

    public SideEffect() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public float getFrequency() {
        return frequency;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    public Vaccine getVaccine() { return vaccine; }

    public void setVaccine(Vaccine vaccine) { this.vaccine = vaccine; }
}
