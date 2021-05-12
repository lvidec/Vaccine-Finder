package hr.tvz.videc.vaxapp.model.Vaccine;


public class VaccineDTO {
    private String researchName;
    private String manufacturerName;
    private String type;
    private int numberOfShots;
    private Long availableDoses;

    public VaccineDTO(String researchName, String manufacturerName, String type, int numberOfShots, Long availableDoses) {
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

    public Long getAvailableDoses() { return availableDoses; }

    public void setAvailableDoses(Long availableDoses) { this.availableDoses = availableDoses; }
}