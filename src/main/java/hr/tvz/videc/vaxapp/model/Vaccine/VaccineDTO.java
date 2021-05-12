package hr.tvz.videc.vaxapp.model.Vaccine;


public class VaccineDTO {
    private String vaxName;
    private String compName;
    private String type;
    private int neededDoses;
    private Long workhouseDoses;

    public VaccineDTO(String vaxName, String compName, String type, int neededDoses, Long workhouseDoses) {
        this.vaxName = vaxName;
        this.compName = compName;
        this.type = type;
        this.neededDoses = neededDoses;
        this.workhouseDoses = workhouseDoses;
    }

    public String getCompName() {
        return compName;
    }

    public int getNeededDoses() {
        return neededDoses;
    }

    public String getVaxName() { return vaxName; }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public void setNeededDoses(int neededDoses) {
        this.neededDoses = neededDoses;
    }

    public void setVaxName(String vaxName) { this.vaxName = vaxName; }

    public Long getWorkhouseDoses() { return workhouseDoses; }

    public void setWorkhouseDoses(Long workhouseDoses) { this.workhouseDoses = workhouseDoses; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }
}