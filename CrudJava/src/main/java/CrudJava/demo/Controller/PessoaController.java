package CrudJava.demo.Controller;


import CrudJava.demo.Model.Pessoa;
import CrudJava.demo.Service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;

    @PostMapping("/criar")
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
        try {
            return new ResponseEntity<>(pessoaService.cadastrarPessoa(pessoa), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, " Não criado");
        }
    }


        @GetMapping("/listar")
        public ResponseEntity<List<Pessoa>> listarPessoas() {
            List<Pessoa> pessoas = pessoaService.listarPessoas();
            return ResponseEntity.ok().body(pessoas);
        }

        @PatchMapping("/{id}")
        public Pessoa atualizarNome(@PathVariable int id, @RequestBody String nome){
        return pessoaService.atualizarNome(id, nome);
        }

        @DeleteMapping("/{id}")
        public void removerPessoa(@PathVariable int id){
            pessoaService.deletar((long)id);
        }


}
