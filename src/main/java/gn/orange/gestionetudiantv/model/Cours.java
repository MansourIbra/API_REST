package gn.orange.gestionetudiantv.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "Tb_Cours")

public class Cours {
    @Id
    private String codeCours;
    private String libelle;
    private String volumehoraire;
    private String titulaire;
    @OneToMany(mappedBy = "cours")
    private Collection<Inscriptions>inscriptions;

}
