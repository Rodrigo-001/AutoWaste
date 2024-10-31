package com.autowaste.demo.service;
import com.autowaste.demo.model.Lixeira;
import com.autowaste.demo.repository.LixeiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LixeiraService {
    @Autowired
    private LixeiraRepository lixeiraRepository;

    public List<Lixeira> consultarTodasLixeiras(){
        return lixeiraRepository.findAll();
    }

    public Optional<Lixeira> consultarLixeiraPorId(Long id){
        return lixeiraRepository.findById(id);
    }

    public Lixeira criarLixeira(Lixeira lixeira){
        return lixeiraRepository.save(lixeira);
    }

    public Lixeira atualizarLixeira(Long id, Lixeira lixeiraDetalhes){
        Lixeira lixeira = lixeiraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lixeira não encontrada"));
        lixeira.setLocalizacao(lixeiraDetalhes.getLocalizacao());
        lixeira.setCapacidadeAtual(lixeiraDetalhes.getCapacidadeAtual());
        lixeira.setCapacidadeTotal(lixeiraDetalhes.getCapacidadeTotal());

        return lixeiraRepository.save(lixeira);
    }

    public void deletarLixeira(Long id){
        lixeiraRepository.deleteById(id);
    }



}


