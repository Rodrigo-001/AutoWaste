package com.autowaste.demo.controller;

import com.autowaste.demo.service.LixeiraService;
import com.autowaste.demo.model.Lixeira;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/lixeira")
public class LixeiraController {
    @Autowired
    private LixeiraService lixeiraService;

//    Obter todas as lixeiras
    @GetMapping
    public List<Lixeira> consultarTodasLixeiras(){
        return lixeiraService.consultarTodasLixeiras();
    }

//    Obter uma lixeira por ID
    @GetMapping("/{id}")
    public ResponseEntity<Lixeira> consultarLixeiraPorId(@PathVariable Long id){
        Optional<Lixeira> lixeira = lixeiraService.consultarLixeiraPorId(id);
        if (lixeira.isPresent()){
            return ResponseEntity.ok(lixeira.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }
//    Criar uma nova lixeira
    @PostMapping
    public ResponseEntity<?> criarLixeira(@RequestBody Lixeira lixeira) {
        if (lixeira.getLocalizacao() == null || lixeira.getLocalizacao().isEmpty() || lixeira.getLocalizacao().length() < 4) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Os dados fornecidos são inválidos.");
        }
        Lixeira novaLixeira = lixeiraService.criarLixeira(lixeira);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(novaLixeira);
    }
    //    Atualizar uma lixeira existente
    @PutMapping("/{id}")
    public ResponseEntity<Lixeira> atualizarLixeira(@PathVariable Long id, @RequestBody Lixeira lixeiraDetalhes){
        try {
            Lixeira lixeiraAtualizada = lixeiraService.atualizarLixeira(id, lixeiraDetalhes);
            return ResponseEntity.ok(lixeiraAtualizada);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
//    Deletar uma lixeira
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLixeira(@PathVariable Long id){
        lixeiraService.deletarLixeira(id);
        return ResponseEntity.noContent().build();
    }
}
