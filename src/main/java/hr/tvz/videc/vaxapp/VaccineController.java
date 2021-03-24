package hr.tvz.videc.vaxapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("vaccine")
public class VaccineController {

    private final VaccineService vaccineService;

    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping
    public List<VaccineDTO> getAllVaccines(){
        return vaccineService.findAll();
    }

    @GetMapping("/")
    public VaccineDTO getByResearchName(@RequestParam final String vaxName){
        return vaccineService.findVaccineByResearchName(vaxName);
    }

}
