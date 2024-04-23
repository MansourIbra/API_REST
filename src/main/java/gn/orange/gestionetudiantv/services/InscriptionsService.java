package gn.orange.gestionetudiantv.services;

import gn.orange.gestionetudiantv.model.Inscriptions;

import java.util.List;
import java.util.Optional;

public interface InscriptionsService {
    Inscriptions createInscription(Inscriptions inscriptions);
    List<Inscriptions> getInscriptionsBy();
    Optional<Inscriptions> getInscriptionsById(Long id);
    Inscriptions updateInscriptions(Long id, Inscriptions inscriptions);
    void deleteInscriptionsById(Long id);
}
