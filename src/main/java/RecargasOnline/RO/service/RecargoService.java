package RecargasOnline.RO.service;

import RecargasOnline.RO.models.Recharger;
import RecargasOnline.RO.repository.RecargoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecargoService {

    private final RecargoRepository rechargerRepository;

    public RecargoService(RecargoRepository rechargerRepository) {
        this.rechargerRepository = rechargerRepository;
    }

    public List<Recharger> getAllRechargers() {
        return rechargerRepository.findAll();
    }

    public Recharger saveRecargo(Recharger recharger) {

        return rechargerRepository.save(recharger);
    }

    public void deleteRecargo(Long id) {
        rechargerRepository.deleteById(id);
    }
}
