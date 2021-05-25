package hr.tvz.videc.vaxapp.controller;

import hr.tvz.videc.vaxapp.model.Vaccine.VaccineCommand;
import hr.tvz.videc.vaxapp.model.Vaccine.VaccineDTO;
import hr.tvz.videc.vaxapp.service.VaccineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("vaccine")
@CrossOrigin(origins = "http://localhost:4200")
public class VaccineController {

    private final VaccineService vaccineService;

    public VaccineController(VaccineService vaccineService) {
        this.vaccineService = vaccineService;
    }

    @GetMapping
    public List<VaccineDTO> getAllVaccines(){
        return vaccineService.findAll();
    }

    @GetMapping("/{researchName}")
    public VaccineDTO getByResearchName(@PathVariable final String researchName){
        return vaccineService.findVaccineByResearchName(researchName);
    }

    @GetMapping(params = "availableDoses")
    public List<VaccineDTO> getByAvailableDosses(@RequestParam final long availableDoses){
        return vaccineService.findVaccineByAvailableDoses(availableDoses);
    }

    @GetMapping("/between")
    public List<VaccineDTO> getVaccinesByNumberOfAvailableDoses(@RequestParam("min") final long availableDossesMin, @RequestParam("max") final long availableDossesMax){
        return vaccineService.findVaccinesByNumberOfAvailableDoses(availableDossesMin, availableDossesMax);
    }

    @PostMapping
    public ResponseEntity<VaccineDTO> addVaccine(@Valid @RequestBody final VaccineCommand vaccineCommand){
        return vaccineService.addVaccine(vaccineCommand).map(
                vaccineDTO -> ResponseEntity.status(HttpStatus.CREATED).body(vaccineDTO)
            ).orElseGet(
                () -> ResponseEntity.status(HttpStatus.CONFLICT).build()
            );
    }

    @PutMapping("/{researchName}")
    public ResponseEntity<VaccineDTO> updateVaccine(@PathVariable String researchName, @Valid @RequestBody final VaccineCommand vaccineCommand){
        return vaccineService.updateVaccine(researchName, vaccineCommand).map(
                vaccineDTO -> ResponseEntity.status(HttpStatus.CREATED).body(vaccineDTO)
            ).orElseGet(
                () -> ResponseEntity.status(HttpStatus.CONFLICT).build()
            );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @Secured({"ROLE_ADMIN", "ROLE_DELETER"})
    @DeleteMapping("/{researchName}")
    public void deleteVaccine(@PathVariable String researchName){
        vaccineService.deleteVaccine(researchName);
    }

}
