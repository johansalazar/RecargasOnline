package RecargasOnline.RO.controller;

import RecargasOnline.RO.models.Vendedor;
import RecargasOnline.RO.service.VendedorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendedores")
public class VendedorController {

    private final VendedorService vendedorService;

    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public Vendedor getVendedorById(@PathVariable Long id) {
        return vendedorService.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Vendedor> getAll() {
        return vendedorService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public Vendedor create(@RequestBody Vendedor vendedor) {
        return vendedorService.save(vendedor);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public Vendedor update(@RequestBody Vendedor vendedor) {
        return vendedorService.update(vendedor);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        vendedorService.delete(id);
    }
}
