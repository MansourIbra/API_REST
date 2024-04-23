package gn.orange.gestionetudiantv.services;

import gn.orange.gestionetudiantv.Exception.EntityNotFoundException;
import gn.orange.gestionetudiantv.Exception.InvalidEntityException;
import gn.orange.gestionetudiantv.model.Etudiant;
import gn.orange.gestionetudiantv.model.Inscriptions;
import gn.orange.gestionetudiantv.repository.EtudiantRepository;
import gn.orange.gestionetudiantv.repository.InscriptionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.openmbean.InvalidOpenTypeException;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class InscriptionsServiceImpl implements InscriptionsService{

    private final InscriptionsRepository inscriptionsRepository;

    @Override
    public Inscriptions createInscription(Inscriptions inscriptions) {
        return inscriptionsRepository.save(inscriptions);

    }

    @Override
    public List<Inscriptions> getInscriptionsBy() {
        return inscriptionsRepository.findAll();
    }

    @Override
    public Optional<Inscriptions> getInscriptionsById(Long id) {
        Optional<Inscriptions> inscriptionsOptional = inscriptionsRepository.findById(id);
        if(inscriptionsOptional.isPresent()){
            return inscriptionsRepository.findById(id);
        }else{
            throw new EntityNotFoundException("Ce Cours n'existe dans la BD");
        }
    }

    @Override
    public Inscriptions updateInscriptions(Long id, Inscriptions inscriptions) {
        return inscriptionsRepository.findById(id).map(inscriptions1 -> {
            inscriptions.setId(inscriptions.getId());
            inscriptions.setEtudiant(inscriptions.getEtudiant());
            inscriptions.setCours(inscriptions.getCours());
            inscriptions.setNote( inscriptions.getNote());
            return inscriptionsRepository.save(inscriptions1); // Retourner l'inscription  mis à jour
        }).orElseThrow(() -> new RuntimeException("inscription  non trouvé !"));
    }

    @Override
    public void deleteInscriptionsById(Long id) {
        Optional<Inscriptions> optionalInscriptions = inscriptionsRepository.findById(id);
        if( optionalInscriptions.isPresent()){
            inscriptionsRepository.deleteById(id);
            throw new EntityNotFoundException("cours supprimer avec success");
        }
        else {
            throw new InvalidEntityException("impossible de supprimer un id qui n'exite pas");
        }

    }
}
