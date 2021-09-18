package hr.tvz.videc.vaxapp.controller;

import hr.tvz.videc.vaxapp.model.SideEffect.SideEffect;
import hr.tvz.videc.vaxapp.service.SideEffectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("side-effect")
@CrossOrigin(origins = "http://localhost:3000")
public class SideEffectController {

    private final SideEffectService sideEffectService;

    public SideEffectController(SideEffectService sideEffectService) {
        this.sideEffectService = sideEffectService;
    }

    @GetMapping
    public List<SideEffect> findAll(){
        return sideEffectService.findAll();
    }

    @GetMapping(params = "vaccineResearchName")
    public List<SideEffect> findByVaccine_ResearchName(@RequestParam String vaccineResearchName){
        return sideEffectService.findByVaccine_ResearchName(vaccineResearchName);
    }

    @GetMapping("/between/{min}/{max}")
    public List<SideEffect> findByFrequencyGreaterThanEqualAndFrequencyLessThanEqual(@PathVariable("min") final long freqMin, @PathVariable("max") final long freqMax){
        return sideEffectService.findByFrequencyGreaterThanEqualAndFrequencyLessThanEqual(freqMin, freqMax);
    }


}
