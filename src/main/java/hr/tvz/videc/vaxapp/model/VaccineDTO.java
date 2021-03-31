package hr.tvz.videc.vaxapp.model;


import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class VaccineDTO {
    private String compName;
    private int neededDoses;

    public VaccineDTO(String compName, int neededDoses) {
        this.compName = compName;
        this.neededDoses = neededDoses;
    }

    public String getCompName() {
        return compName;
    }

    public int getNeededDoses() {
        return neededDoses;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public void setNeededDoses(int neededDoses) {
        this.neededDoses = neededDoses;
    }

    @Override
    public String toString() {
        return "VaccineDTO{" +
                "compName='" + compName + '\'' +
                ", neededDoses=" + neededDoses +
                '}';
    }

}