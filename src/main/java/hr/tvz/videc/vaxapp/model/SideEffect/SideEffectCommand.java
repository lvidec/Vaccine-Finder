package hr.tvz.videc.vaxapp.model.SideEffect;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SideEffectCommand {

    @NotBlank(message = "Short description cannot be empty!")
    private String shortDescription;

    @NotBlank(message = "Long description cannot be empty!")
    private String description;

    @NotNull(message = "Frequency of occurrences cannot be empty!")
    @Max(message = "Frequency of occurrences must be lower than 100", value = 100)
    private float frequency;

    public SideEffectCommand(String shortDescription, String description, float frequency) {
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
