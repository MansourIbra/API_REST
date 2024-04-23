package gn.orange.gestionetudiantv.controller;

import gn.orange.gestionetudiantv.model.Cours;
import gn.orange.gestionetudiantv.services.CoursService;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cours")
@AllArgsConstructor
public class CoursController {
    private final CoursService coursService;
    @PostMapping("/createCours")
    public Cours createCours(@RequestBody Cours cours){
        return coursService.createCours(cours);
    }
    @GetMapping("/getAll")
    public List<Cours> read(){
        return coursService.getAllCours();
    }
    @GetMapping("/getCoursById/{codeCours}")
    public Optional<Cours> getCoursById(@PathVariable String codeCours){
        return coursService.getCoursById(codeCours);
    }
    @PutMapping("updateCours/{codeCours}")
    public Cours updateCours(@PathVariable String codeCours, @RequestBody Cours cours){
        return coursService.updateCours(codeCours,cours);
    }
    @DeleteMapping("/deleteCours/{codeCours}")
    public void deleteCoursById(@PathVariable String codeCours){
        coursService.deleteCoursById(codeCours);

    }

}
