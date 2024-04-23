package gn.orange.gestionetudiantv.controller;

import gn.orange.gestionetudiantv.model.Etudiant;
import gn.orange.gestionetudiantv.services.EtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/etudiant")
@AllArgsConstructor
public class EtudiantController {

    private final EtudiantService etdService;
    @PostMapping("/createEtudiant")
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant){
        return etdService.createEtudiant(etudiant);
    }
    @GetMapping("/getAll")
    public List<Etudiant> read(){
        return etdService.getAllEtudiant();
    }
    @GetMapping("/getEtudiantById/{matricule}")
    public Optional<Etudiant> getEtudiantsById(@PathVariable String matricule){
        return etdService.getEtudiantsById(matricule);
    }
    @PutMapping("updateEtudiant/{matricule}")
    public Etudiant updateEtudiant(@PathVariable String matricule, @RequestBody Etudiant etudiant){
        return etdService.updateEtudiant(matricule,etudiant);
    }
    @DeleteMapping("/deleteEtudiant/{matricule}")
    public void deleteEtudiantById(@PathVariable String matricule){
        etdService.deleteEtudiantById(matricule);

    }

}
