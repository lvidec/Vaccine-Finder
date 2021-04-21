package hr.tvz.videc.vaxapp.model;

public class Vaccine {

    private String vaxName;
    private String compName;
    private String type;
    private int neededDoses;
    private long warehouseDoses;
//    private SideEffect sideEffect;

    public Vaccine(String vaxName, String compName, String type, int neededDoses, long warehouseDoses/*, SideEffect sideEffect*/) {
        this.vaxName = vaxName;
        this.compName = compName;
        this.type = type;
        this.neededDoses = neededDoses;
        this.warehouseDoses = warehouseDoses;
//        this.sideEffect = sideEffect;
    }

    public Vaccine(){}

    public void setVaxName(String vaxName) {
        this.vaxName = vaxName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNeededDoses(int neededDoses) {
        this.neededDoses = neededDoses;
    }

    public void setWarehouseDoses(long warehouseDoses) {
        this.warehouseDoses = warehouseDoses;
    }

//    public void setSideEffect(SideEffect sideEffect) { this.sideEffect = sideEffect; }

    public String getVaxName() {
        return vaxName;
    }

    public String getCompName() {
        return compName;
    }

    public String getType() {
        return type;
    }

    public int getNeededDoses() {
        return neededDoses;
    }

    public long getWarehouseDoses() {
        return warehouseDoses;
    }

//    public SideEffect getSideEffect() { return sideEffect; }

}
