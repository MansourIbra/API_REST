package gn.orange.gestionetudiantv.services;

import ch.qos.logback.core.spi.ErrorCodes;
import gn.orange.gestionetudiantv.model.Cours;
import gn.orange.gestionetudiantv.repository.CoursRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.openmbean.InvalidOpenTypeException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class CoursServiceImpl implements CoursService{
    private final CoursRepository coursRepository;
    @Override
    public Cours createCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public List<Cours> getAllCours() {
        return coursRepository.findAll();
    }

    @Override
    public Optional<Cours> getCoursById(String codeCours) {
        Optional<Cours> coursOptional = coursRepository.findById(codeCours);
        if(coursOptional.isPresent()){
            return coursRepository.findById(codeCours);
        }
        else {
            throw new EntityNotFoundException("Ce Cours n'existe dans la BD");
        }
    }

    @Override
    public Cours updateCours(String codeCours, Cours cours) {
        return coursRepository.findById(codeCours).map(cours1 -> {
            cours1.setCodeCours(cours.getCodeCours());
            cours1.setLibelle(cours.getLibelle());
            cours1.setTitulaire(cours.getTitulaire());
            cours1.setVolumehoraire(cours.getVolumehoraire());
            return coursRepository.save(cours1); // Retourner le cours mis à jour
        }).orElseThrow(() -> new RuntimeException("Cours non trouvé !"));
    }

    @Override
    public void deleteCoursById(String codeCours) {
        Optional<Cours> optionalCours = coursRepository.findById(codeCours);
        if( optionalCours.isPresent()){
             coursRepository.deleteById(codeCours);
            throw new InvalidOpenTypeException("Cours supprimer avec success");
        }
        else {
            throw new InvalidOpenTypeException("impossible de supprimer un id qui n'exite pas");
        }
    }
}
