package gn.orange.gestionetudiantv.services;

import gn.orange.gestionetudiantv.Exception.EntityNotFoundException;
import gn.orange.gestionetudiantv.Exception.InvalidEntityException;
import gn.orange.gestionetudiantv.model.Etudiant;
import gn.orange.gestionetudiantv.repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.openmbean.InvalidOpenTypeException;
import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class EtudiantServiceImpl implements EtudiantService {

    private final EtudiantRepository etudiantRepository;

    @Override
    public Etudiant createEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Optional<Etudiant> getEtudiantsById(String matricule) {
        Optional<Etudiant> etudiantOptional = etudiantRepository.findById(matricule);
        if(etudiantOptional.isPresent()){
            return etudiantRepository.findById(matricule);
        }else{
            throw new EntityNotFoundException("Ce Cours n'existe dans la BD");
        }

    }

    @Override
    public Etudiant updateEtudiant(String matricule, Etudiant etudiant) {
        return etudiantRepository.findById(matricule).map(etudiant1 -> {
            etudiant.setMatricule(etudiant.getMatricule());
            etudiant.setNom(etudiant.getNom());
            etudiant.setPrenom(etudiant.getPrenom());
            etudiant.setDateNaissance(etudiant.getDateNaissance());
            etudiant.setSexe(etudiant.getSexe());
            return etudiantRepository.save(etudiant1); // Retourner le cours mis à jour
        }).orElseThrow(() -> new RuntimeException("etudiant  non trouvé !"));
    }

    @Override
    public void deleteEtudiantById(String matricule) {
        Optional<Etudiant> optionalEtudiant = etudiantRepository.findById(matricule);
        if( optionalEtudiant.isPresent()){
            etudiantRepository.deleteById(matricule);
            throw new InvalidEntityException("Etudiant supprimer avec success");
        }
        else {
            throw new InvalidOpenTypeException("impossible de supprimer un id qui n'exite pas");
        }
    }

}
