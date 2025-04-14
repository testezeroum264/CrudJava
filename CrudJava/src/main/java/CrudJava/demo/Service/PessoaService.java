package CrudJava.demo.Service;

import CrudJava.demo.Model.Pessoa;
import CrudJava.demo.Repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa cadastrarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
    public Pessoa buscarPorId(int id) {
        Pessoa pessoaSelecionada = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com o id: " + id));
        return pessoaSelecionada;
    }
    public Pessoa atualizarNome(int id, String novoNome) {
        Pessoa pessoaSelecionada = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada com o id: " + id));
        pessoaSelecionada.setNome(novoNome);
        return pessoaRepository.save(pessoaSelecionada);
    }

    public List<Pessoa> listarPessoas(){
        return pessoaRepository.findAll();
    }

    public void deletar(Long id) {
        if (!pessoaRepository.existsById(Math.toIntExact(id))) {
            throw new RuntimeException("Pessoa não encontrada com o id: " + id);
        }
        pessoaRepository.deleteById(Math.toIntExact(id));
    }
}
