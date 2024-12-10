package RecargasOnline.RO.service;

import RecargasOnline.RO.models.Operador;
import RecargasOnline.RO.models.Vendedor;
import RecargasOnline.RO.repository.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void deleteOperador(int id) {
        operadorRepository.deleteById(id);
    }
}
