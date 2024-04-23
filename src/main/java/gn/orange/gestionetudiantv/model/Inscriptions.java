package gn.orange.gestionetudiantv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name="Tb_Inscriptions")
public class Inscriptions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String note;
    @ManyToOne
    private Cours cours;
    @ManyToOne
    private Etudiant etudiant;
}