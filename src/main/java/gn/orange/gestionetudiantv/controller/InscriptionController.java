package gn.orange.gestionetudiantv.controller;

import gn.orange.gestionetudiantv.services.InscriptionsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inscription")
@AllArgsConstructor
public class InscriptionController {
    private final InscriptionsService inscriptionsService;
}
