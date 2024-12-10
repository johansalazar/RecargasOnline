package RecargasOnline.RO.repository;

import RecargasOnline.RO.models.Recharger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecargoRepository extends JpaRepository<Recharger, Long> {
}
