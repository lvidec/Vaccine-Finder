package hr.tvz.videc.vaxapp.model;

public class SideEffect {

    private String shortDesc;
    private String longDesc;
    private float frequency;

    public SideEffect(String shortDesc, String longDesc, float frequency) {
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.frequency = frequency;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public float getFrequency() {
        return frequency;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }
}
