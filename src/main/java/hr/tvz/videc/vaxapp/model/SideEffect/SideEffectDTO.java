package hr.tvz.videc.vaxapp.model.SideEffect;

public class SideEffectDTO {

    private String shortDescription;
    private String longDescription;
    private float frequency;

    public SideEffectDTO(String shortDescription, String longDescription, float frequency) {
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.frequency = frequency;
    }

    public String getShortDescription() { return shortDescription; }

    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    public String getLongDescription() { return longDescription; }

    public void setLongDescription(String longDescription) { this.longDescription = longDescription; }

    public float getFrequency() { return frequency; }

    public void setFrequency(float frequency) { this.frequency = frequency; }
}
