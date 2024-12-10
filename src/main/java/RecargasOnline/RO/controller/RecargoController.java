package RecargasOnline.RO.controller;


import RecargasOnline.RO.models.Recharger;
import RecargasOnline.RO.service.RecargoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/recargas")
public class RecargoController {

    private final RecargoService recargoService;

    public RecargoController(RecargoService recargoService) {
        this.recargoService = recargoService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Recharger> getAllRechargers() {
        return recargoService.getAllRechargers();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<?> saveRecargo(@RequestBody Recharger recharger) {
        try {
            // Guardar la recarga
            Recharger savedRecargo = recargoService.saveRecargo(recharger);
            return ResponseEntity.ok(savedRecargo);
        } catch (HttpMessageNotReadableException e) {
            // Manejar el error de deserialización
            return ResponseEntity.badRequest().body("Error en el formato de la solicitud JSON: " + e.getMessage());
        } catch (Exception e) {
            // Manejar otros errores
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar la recarga: " + e.getMessage());
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void deleteRecargo(@PathVariable Long id) {
        recargoService.deleteRecargo(id);
    }
}
