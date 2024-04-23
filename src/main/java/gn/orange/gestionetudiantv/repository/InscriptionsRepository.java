package gn.orange.gestionetudiantv.repository;

import gn.orange.gestionetudiantv.model.Inscriptions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InscriptionsRepository extends JpaRepository<Inscriptions, Long> {

}
