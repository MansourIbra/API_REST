package gn.orange.gestionetudiantv.repository;

import gn.orange.gestionetudiantv.model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoursRepository extends JpaRepository<Cours, String > {

}
