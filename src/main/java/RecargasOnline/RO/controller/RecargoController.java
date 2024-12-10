package RecargasOnline.RO.controller;


import RecargasOnline.RO.models.Recharger;
import RecargasOnline.RO.service.RecargoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/recargas")
public class RecargoController {

    private final RecargoService recargoService;

    public RecargoController(RecargoService recargoService) {
        this.recargoService = recargoService;
    }


    @GetMapping
    public List<Recharger> getAllRechargers() {
        return recargoService.getAllRechargers();
    }

    @PostMapping
    public Recharger saveRecargo(@RequestBody Recharger recharger) {
        return recargoService.saveRecargo(recharger);
    }

    @DeleteMapping("/{id}")
    public void deleteRecargo(@PathVariable Long id) {
        recargoService.deleteRecargo(id);
    }
}
