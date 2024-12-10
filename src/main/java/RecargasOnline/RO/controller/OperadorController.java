package RecargasOnline.RO.controller;

import RecargasOnline.RO.models.Operador;
import RecargasOnline.RO.service.OperadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/operadores")
public class OperadorController {

    private final OperadorService operadorService;

    public OperadorController(OperadorService operadorService) {
        this.operadorService = operadorService;
    }
    @GetMapping("/{id}")
    public Operador getOperadorById(@PathVariable int id) {
        return operadorService.findById(id);
    }

    @GetMapping
    public List<Operador> getAllOperadores() {
        return operadorService.getAllOperadores();
    }

    @PostMapping
    public Operador saveOperador(@RequestBody Operador operador) {
        return operadorService.saveOperador(operador);
    }

    @DeleteMapping("/{id}")
    public void deleteOperador(@PathVariable int id) {
        operadorService.deleteOperador(id);
    }
}
