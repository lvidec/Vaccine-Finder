package hr.tvz.videc.vaxapp.model;


public class VaccineDTO {
    private String vaxName;
    private String compName;
    private int neededDoses;

    public VaccineDTO(String vaxName, String compName, int neededDoses) {
        this.vaxName = vaxName;
        this.compName = compName;
        this.neededDoses = neededDoses;
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

}