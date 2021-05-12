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

//    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping
    public List<VaccineDTO> getAllVaccines(){
        return vaccineService.findAll();
    }

    @GetMapping("/{vaxName}")
    public VaccineDTO getByResearchName(@PathVariable final String vaxName){
        return vaccineService.findVaccineByResearchName(vaxName);
    }

    @GetMapping(params = "warehouseDosses")
    public List<VaccineDTO> getByWarehouseDosses(@RequestParam final long warehouseDosses){
        return vaccineService.findVaccineByWarehouseDoses(warehouseDosses);
    }

    @GetMapping("/between")
    public List<VaccineDTO> getVaccinesByNumberOfWarehouseDoses(@RequestParam("min") final long warehouseDossesMin, @RequestParam("max") final long warehouseDosesMax){
        return vaccineService.findVaccinesByNumberOfWarehouseDoses(warehouseDossesMin, warehouseDosesMax);
    }

    @PostMapping
    public ResponseEntity<VaccineDTO> addVaccine(@Valid @RequestBody final VaccineCommand vaccineCommand){
//        return new ResponseEntity<VaccineDTO>(new VaccineDTO(vaccineCommand.getCompName(), vaccineCommand.getNeededDoses()), HttpStatus.CREATED);
        return vaccineService.addVaccine(vaccineCommand).map(
                vaccineDTO -> ResponseEntity.status(HttpStatus.CREATED).body(vaccineDTO)
            ).orElseGet(
                () -> ResponseEntity.status(HttpStatus.CONFLICT).build()
            );
    }

    @PutMapping("/{vaxName}")
    public ResponseEntity<VaccineDTO> updateVaccine(@PathVariable String vaxName, @Valid @RequestBody final VaccineCommand vaccineCommand){
//        return new ResponseEntity<VaccineDTO>(new VaccineDTO(vaccineCommand.getCompName(), vaccineCommand.getNeededDoses()), HttpStatus.CREATED);
        return vaccineService.updateVaccine(vaxName, vaccineCommand).map(
                vaccineDTO -> ResponseEntity.status(HttpStatus.CREATED).body(vaccineDTO)
            ).orElseGet(
                () -> ResponseEntity.status(HttpStatus.CONFLICT).build()
            );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{vaxName}")
    public void deleteVaccine(@PathVariable String vaxName){
        vaccineService.deleteVaccine(vaxName);
    }

}
