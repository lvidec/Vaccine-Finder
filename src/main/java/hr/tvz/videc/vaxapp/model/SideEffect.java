package hr.tvz.videc.vaxapp.model;

import javax.persistence.*;

@Entity
@Table(name = "SideEffect")
public class SideEffect {

    @Id
    @Column(name = "sideEffectId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sideEffectId;

    @Column(name = "shortDesc")
    private String shortDesc;

    @Column(name = "longDesc")
    private String longDesc;

    @Column(name = "frequency")
    private float frequency;

    @ManyToOne
    @JoinColumn(name = "vaccineId")
    private Vaccine vaccine;

    public SideEffect(String shortDesc, String longDesc, float frequency) {
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.frequency = frequency;
    }

    public SideEffect() { }

    @Id
    public Long getSideEffectId() {
        return sideEffectId;
    }

    public void setSideEffectId(Long sideEffectId) {
        this.sideEffectId = sideEffectId;
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
}
