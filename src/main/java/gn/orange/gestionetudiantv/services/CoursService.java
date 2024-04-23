package gn.orange.gestionetudiantv.services;

import gn.orange.gestionetudiantv.model.Cours;

import java.util.List;
import java.util.Optional;

public interface CoursService {
    // Methode de création
    Cours createCours(Cours cours);
    List<Cours> getAllCours();
    Optional<Cours> getCoursById(String codeCours);
    Cours updateCours(String codeCours, Cours cours);
    void deleteCoursById(String codeCours);

}
