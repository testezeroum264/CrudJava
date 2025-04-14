package CrudJava.demo.Model;

import CrudJava.demo.Enum.CargoPessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Trabalho {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    private CargoPessoa cargo;

    public Trabalho(long id, CargoPessoa cargo) {
        this.id = id;
        this.cargo = cargo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CargoPessoa getCargo() {
        return cargo;
    }

    public void setCargo(CargoPessoa cargo) {
        this.cargo = cargo;
    }
}

