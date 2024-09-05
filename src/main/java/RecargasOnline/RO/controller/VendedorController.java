package RecargasOnline.RO.controller;

import RecargasOnline.RO.models.Vendedor;
import RecargasOnline.RO.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendedores")
public class VendedorController {

    private final VendedorService vendedorService;

    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @GetMapping("/{id}")
    public Vendedor getVendedorById(@PathVariable Long id) {
        return vendedorService.findById(id);
    }

    @GetMapping
    public List<Vendedor> getAll() {
        return vendedorService.findAll();
    }

    @PostMapping
    public Vendedor create(@RequestBody Vendedor vendedor) {
        return vendedorService.save(vendedor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        vendedorService.delete(id);
    }
}
