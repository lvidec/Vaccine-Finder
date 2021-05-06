package hr.tvz.videc.vaxapp.controller;

import hr.tvz.videc.vaxapp.model.SideEffect;
import hr.tvz.videc.vaxapp.service.SideEffectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("sideEffect")
@CrossOrigin(origins = "http://localhost:4200")
public class SideEffectController {

    @Autowired
    private final SideEffectService sideEffectService;

    public SideEffectController(SideEffectService sideEffectService) {
        this.sideEffectService = sideEffectService;
    }

    @GetMapping("/{id}")
    public List<SideEffect> findBySideEffectId(@PathVariable Long id){
        return sideEffectService.findBySideEffectId(id);
    }

//    @GetMapping("/{sideEffect}")
//    public List<SideEffect> findByVaxNameLike(@PathVariable String vaxName){
//        return sideEffectService.findByVaxNameLike(vaxName);
//    }

}
