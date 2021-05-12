package hr.tvz.videc.vaxapp.model.SideEffect;

public class SideEffectDTO {

    private String shortDescription;
    private String description;
    private float frequency;

    public SideEffectDTO(String shortDescription, String description, float frequency) {
        this.shortDescription = shortDescription;
        this.description = description;
        this.frequency = frequency;
    }

    public String getShortDescription() { return shortDescription; }

    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public float getFrequency() { return frequency; }

    public void setFrequency(float frequency) { this.frequency = frequency; }
}
