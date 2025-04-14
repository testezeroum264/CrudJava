package CrudJava.demo.Model;

import CrudJava.demo.Enum.CargoPessoa;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private CargoPessoa cargo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn( name = "trabalho_id")
    private List<Trabalho> trabalhoList;
    private CargoPessoa cargoPessoa;

    public Pessoa(long id, String nome, CargoPessoa cargo) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CargoPessoa getCargo() {
        return cargo;
    }

    public void setCargo(CargoPessoa cargo) {
        this.cargo = cargo;
    }
}
