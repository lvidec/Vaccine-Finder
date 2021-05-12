package hr.tvz.videc.vaxapp.model.Vaccine;

import javax.validation.constraints.*;

public class VaccineCommand {

    @NotBlank(message = "Vaccine name cannot be empty!")
    private String researchName;

    @NotBlank(message = "Vaccine company cannot be empty!")
    private String manufacturerName;

    @NotBlank(message = "Vaccine type has to be set to 'mRNA' or 'VIRAL_VECTOR'!")
    private String type;

    @NotNull(message = "Needed doses cannot be empty!")
    @Max(message = "Number of shots cannot be more than 3", value = 3)
    @Positive(message = "Number of shots has to be higher than 0!")
    private int numberOfShots;

    @NotNull(message = "Warehouse number of doses cannot be empty!")
    @Min(message = "Number of warehouse doses cannot be lower than 100", value = 100)
    @Positive(message = "Number of warehouse doses has to be higher than 0!")
    private long availableDoses;

    public VaccineCommand(@NotBlank(message = "Vaccine name cannot be empty!") String researchName, @NotBlank(message = "Vaccine company cannot be empty!") String manufacturerName, @NotBlank(message = "Vaccine type has to be set to 'mRNA' or 'VIRAL_VECTOR'!") String type, @NotNull(message = "Needed doses cannot be empty!") @Max(message = "Number of shots cannot be more than 3", value = 3) @Positive(message = "Number of shots has to be higher than 0!") int numberOfShots, @NotNull(message = "Warehouse number of doses cannot be empty!") @Min(message = "Number of warehouse doses cannot be lower than 100", value = 100) @Positive(message = "Number of warehouse doses has to be higher than 0!") long availableDoses) {
        this.researchName = researchName;
        this.manufacturerName = manufacturerName;
        this.type = type;
        this.numberOfShots = numberOfShots;
        this.availableDoses = availableDoses;
    }

    public String getResearchName() { return researchName; }

    public void setResearchName(String researchName) { this.researchName = researchName; }

    public String getManufacturerName() { return manufacturerName; }

    public void setManufacturerName(String manufacturerName) { this.manufacturerName = manufacturerName; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public int getNumberOfShots() { return numberOfShots; }

    public void setNumberOfShots(int numberOfShots) { this.numberOfShots = numberOfShots; }

    public long getAvailableDoses() { return availableDoses; }

    public void setAvailableDoses(long availableDoses) { this.availableDoses = availableDoses; }
}
