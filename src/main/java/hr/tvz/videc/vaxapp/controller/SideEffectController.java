package hr.tvz.videc.vaxapp.controller;

import hr.tvz.videc.vaxapp.model.SideEffect;
import hr.tvz.videc.vaxapp.service.SideEffectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("se")
@CrossOrigin(origins = "http://localhost:4200")
public class SideEffectController {

    private final SideEffectService sideEffectService;

    public SideEffectController(SideEffectService sideEffectService) {
        this.sideEffectService = sideEffectService;
    }

    @GetMapping
    public List<SideEffect> findAll(){
        return sideEffectService.findAll();
    }

//    @GetMapping("/{sideEffect}")
//    public List<SideEffect> findByVaxNameLike(@PathVariable String vaxName){
//        return sideEffectService.findByVaxNameLike(vaxName);
//    }

}
