package hr.tvz.videc.vaxapp.model;


public class VaccineDTO {
    private String vaxName;
    private String compName;
    private int neededDoses;
    private SideEffect sideEffect;

    public VaccineDTO(String vaxName, String compName, int neededDoses/*, SideEffect sideEffect*/) {
        this.vaxName = vaxName;
        this.compName = compName;
        this.neededDoses = neededDoses;
//        this.sideEffect = sideEffect;
    }

    public String getCompName() {
        return compName;
    }

    public int getNeededDoses() {
        return neededDoses;
    }

    public String getVaxName() { return vaxName; }

    public SideEffect getSideEffect() { return sideEffect; }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public void setNeededDoses(int neededDoses) {
        this.neededDoses = neededDoses;
    }

    public void setVaxName(String vaxName) { this.vaxName = vaxName; }

    public void setSideEffect(SideEffect sideEffect) { this.sideEffect = sideEffect; }
}