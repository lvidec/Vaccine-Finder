package hr.tvz.videc.vaxapp.model.Vaccine;

import javax.validation.constraints.*;

public class VaccineCommand {

    @NotBlank(message = "Vaccine name cannot be empty!")
    private String vaxName;

    @NotBlank(message = "Vaccine company cannot be empty!")
    private String compName;

    @NotBlank(message = "Vaccine type has to be set to 'mRNA' or 'VIRAL_VECTOR'!")
    private String type;

    @NotNull(message = "Needed doses cannot be empty!")
    @Max(message = "Number of shots cannot be more than 3", value = 3)
    @Positive(message = "Number of shots has to be higher than 0!")
    private int neededDoses;

    @NotNull(message = "Warehouse number of doses cannot be empty!")
    @Min(message = "Number of warehouse doses cannot be lower than 100", value = 100)
    @Positive(message = "Number of warehouse doses has to be higher than 0!")
    private long warehouseDoses;

    public VaccineCommand(@NotBlank(message = "Vaccine name cannot be empty!") String vaxName, @NotBlank(message = "Vaccine company cannot be empty!") String compName, @NotBlank(message = "Vaccine type has to be set to 'mRNA' or 'VIRAL_VECTOR'!") String type, @NotNull(message = "Needed doses cannot be empty!") @Max(message = "Number of shots cannot be more than 3", value = 3) @Positive(message = "Number of shots has to be higher than 0!") int neededDoses, @NotNull(message = "Warehouse number of doses cannot be empty!") @Min(message = "Number of warehouse doses cannot be lower than 100", value = 100) @Positive(message = "Number of warehouse doses has to be higher than 0!") long warehouseDoses) {
        this.vaxName = vaxName;
        this.compName = compName;
        this.type = type;
        this.neededDoses = neededDoses;
        this.warehouseDoses = warehouseDoses;
    }

    public String getVaxName() {
        return vaxName;
    }

    public void setVaxName(String vaxName) {
        this.vaxName = vaxName;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNeededDoses() {
        return neededDoses;
    }

    public void setNeededDoses(int neededDoses) {
        this.neededDoses = neededDoses;
    }

    public long getWarehouseDoses() {
        return warehouseDoses;
    }

    public void setWarehouseDoses(long warehouseDoses) {
        this.warehouseDoses = warehouseDoses;
    }

}
