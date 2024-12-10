package RecargasOnline.RO.service;

import RecargasOnline.RO.models.Operador;
import RecargasOnline.RO.models.Vendedor;
import RecargasOnline.RO.repository.OperadorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperadorService {

    @Autowired
    private OperadorRepository operadorRepository;

    public List<Operador> getAllOperadores() {
        return operadorRepository.findAll();
    }

    public Operador findById(int id) {
        return operadorRepository.findById(id).orElse(null);
    }

    public Operador saveOperador(Operador operador) {
        return operadorRepository.save(operador);
    }

    public Operador updateOperador(Operador operador) {
        // Verificar si el operador existe en la base de datos
        Optional<Operador> existingOperador = operadorRepository.findById(operador.getId());

        if (existingOperador.isPresent()) {
            // Actualizar los campos necesarios
            Operador operadorToUpdate = existingOperador.get();
            operadorToUpdate.setNombre(operador.getNombre());
            // Agregar otros campos que se necesiten actualizar

            // Guardar y devolver el operador actualizado
            return operadorRepository.save(operadorToUpdate);
        } else {
            // Lanzar una excepción o manejar el caso en el que el operador no exista
            throw new EntityNotFoundException("El operador con ID " + operador.getId() + " no existe.");
        }
    }

    public void deleteOperador(int id) {
        operadorRepository.deleteById(id);
    }
}
