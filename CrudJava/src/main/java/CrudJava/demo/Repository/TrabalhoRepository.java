package CrudJava.demo.Repository;

import CrudJava.demo.Model.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Integer> {
}
