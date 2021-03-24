package hr.tvz.videc.vaxapp;

public class Vaccine {

    private String vaxName;
    private String compName;
    private String type;
    private int neededDoses;
    private int warehouseDoses;

    public Vaccine(String vaxName, String compName, String type, int neededDoses, int warehouseDoses) {
        this.vaxName = vaxName;
        this.compName = compName;
        this.type = type;
        this.neededDoses = neededDoses;
        this.warehouseDoses = warehouseDoses;
    }

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

    public void setWarehouseDoses(int warehouseDoses) {
        this.warehouseDoses = warehouseDoses;
    }

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

    public int getWarehouseDoses() {
        return warehouseDoses;
    }

}
