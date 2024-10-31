package com.autowaste.demo.controller;

import com.autowaste.demo.model.Coleta;
import com.autowaste.demo.service.ColetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coleta")
public class ColetaController {
    @Autowired
    private ColetaService coletaService;

    @GetMapping
    public List<Coleta> consultarTodasColetas(){
        return coletaService.consultarTodasColetas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coleta> consultarColetaPorId(@PathVariable Long id){
        Optional<Coleta> coleta = coletaService.consultarColetaPorId(id);
        if (coleta.isPresent()){
            return ResponseEntity.ok(coleta.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Coleta cadastrarColeta(@RequestBody Coleta coleta){
        return coletaService.cadastrarColeta(coleta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coleta> atualizarColeta(@PathVariable Long id, @RequestBody Coleta coletaDetalhes){
        try {
            Coleta coletaAtualizada = coletaService.atualizarColeta(id, coletaDetalhes);
            return ResponseEntity.ok(coletaAtualizada);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarColeta(@PathVariable Long id){
        coletaService.deletarColeta(id);
        return ResponseEntity.noContent().build();
    }



}
