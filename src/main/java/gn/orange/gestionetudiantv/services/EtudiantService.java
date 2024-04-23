package gn.orange.gestionetudiantv.services;

import gn.orange.gestionetudiantv.model.Etudiant;

import java.util.List;
import java.util.Optional;

public interface EtudiantService {
    Etudiant createEtudiant(Etudiant etudiant);
    List<Etudiant> getAllEtudiant();
    Optional<Etudiant> getEtudiantsById(String matricule);
    Etudiant updateEtudiant(String matricule, Etudiant etudiant);
    void deleteEtudiantById(String matricule);
}
