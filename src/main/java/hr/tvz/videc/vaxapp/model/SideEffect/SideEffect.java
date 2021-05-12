package hr.tvz.videc.vaxapp.model.SideEffect;

import hr.tvz.videc.vaxapp.model.Vaccine.Vaccine;

import javax.persistence.*;

@Entity
public class SideEffect {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String shortDescription;

    @Column
    private String description;

    @Column
    private float frequency;

    @ManyToOne
    @JoinColumn(name = "vaccine_id", nullable = false)
    private Vaccine vaccine;

    public SideEffect(String shortDescription, String description, float frequency, Vaccine vaccine) {
        this.shortDescription = shortDescription;
        this.description = description;
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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDesc) {
        this.shortDescription = shortDesc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String longDesc) {
        this.description = longDesc;
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
