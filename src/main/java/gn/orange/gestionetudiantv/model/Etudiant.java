package gn.orange.gestionetudiantv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Data   //genere les Get et Set
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name="Tb_Etudiant")
public class Etudiant {
    @Id
    private String matricule;
    private String nom;
    @Column(length = 20)
    private String prenom;
    @Column(length = 40)
    private Date dateNaissance;
    @OneToMany(mappedBy = "etudiant")
    private Collection<Inscriptions>inscriptions;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;

}
