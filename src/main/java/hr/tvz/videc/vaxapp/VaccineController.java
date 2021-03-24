package hr.tvz.videc.vaxapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("vaccine")
public class VaccineController {

    private final VaccineServ vaccineServ;

    public VaccineController(VaccineServ vaccineServ) {
        this.vaccineServ = vaccineServ;
    }

    @GetMapping
    public List<VaccineDTO> getAllVaccines(){
        return vaccineServ.findAll();
    }

    @GetMapping(params = "vaxName")
    public VaccineDTO getByResearchName(@RequestParam final String vaxName){
        return vaccineServ.findVaccineByResearchName(vaxName);
    }

}
