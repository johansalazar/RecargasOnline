package RecargasOnline.RO.service;

import RecargasOnline.RO.models.Operador;
import RecargasOnline.RO.models.Vendedor;
import RecargasOnline.RO.repository.VendedorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Vendedor update(Vendedor vendedor) {
        // Verificar si el operador existe en la base de datos
        Optional<Vendedor> existingVendedor= vendedorRepository.findById(vendedor.getId());

        if (existingVendedor.isPresent()) {
            // Actualizar los campos necesarios
            Vendedor operadorToUpdate = existingVendedor.get();
            operadorToUpdate.setNombre(vendedor.getNombre());
            // Agregar otros campos que se necesiten actualizar

            // Guardar y devolver el vendedor actualizado
            return vendedorRepository.save(operadorToUpdate);
        } else {
            // Lanzar una excepción o manejar el caso en el que el operador no exista
            throw new EntityNotFoundException("El vendedor con ID " + vendedor.getId() + " no existe.");
        }
    }
}
