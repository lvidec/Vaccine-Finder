package hr.tvz.videc.vaxapp.controller;

import hr.tvz.videc.vaxapp.VaccineCommand;
import hr.tvz.videc.vaxapp.model.Vaccine;
import hr.tvz.videc.vaxapp.model.VaccineDTO;
import hr.tvz.videc.vaxapp.service.VaccineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping(params = "vaxName")
    public VaccineDTO getByResearchName(@RequestParam final String vaxName){
        return vaccineService.findVaccineByResearchName(vaxName);
    }

    @GetMapping(params = "warehouseDosses")
    public List<VaccineDTO> getByWarehouseDosses(@RequestParam final long warehouseDosses){
        return vaccineService.findVaccineByWarehouseDoses(warehouseDosses);
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

    @PutMapping("/{compName}")
    public ResponseEntity<VaccineDTO> updateVaccine(@PathVariable String compName, @Valid @RequestBody final VaccineCommand vaccineCommand){
//        return new ResponseEntity<VaccineDTO>(new VaccineDTO(vaccineCommand.getCompName(), vaccineCommand.getNeededDoses()), HttpStatus.CREATED);
        return vaccineService.updateVaccine(compName, vaccineCommand).map(
                vaccineDTO -> ResponseEntity.status(HttpStatus.CREATED).body(vaccineDTO)
            ).orElseGet(
                () -> ResponseEntity.status(HttpStatus.CONFLICT).build()
            );
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteVaccine(@RequestParam(value = "vaxName") String vaxName){
        vaccineService.deleteVaccine(vaxName);
    }

}
