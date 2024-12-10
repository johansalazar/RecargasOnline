package RecargasOnline.RO.service;

import RecargasOnline.RO.models.Vendedor;
import RecargasOnline.RO.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public List<Vendedor> findAll() {
        return vendedorRepository.findAll();
    }

    public Vendedor save(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    public Vendedor findById(Long id) {
        return vendedorRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        vendedorRepository.deleteById(id);
    }


}
