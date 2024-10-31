package com.autowaste.demo.service;

import com.autowaste.demo.model.Coleta;
import com.autowaste.demo.repository.ColetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColetaService {
    @Autowired
    private ColetaRepository coletaRepository;

    public List<Coleta> consultarTodasColetas(){
        return coletaRepository.findAll();
    }

    public Optional<Coleta> consultarColetaPorId(Long id){
        return coletaRepository.findById(id);
    }

    public Coleta cadastrarColeta(Coleta coleta){
        return coletaRepository.save(coleta);
    }

    public Coleta atualizarColeta(Long id, Coleta coletaDetalhes){
        Coleta coleta = coletaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coleta não encontrada"));
        coleta.setDataAgendada(coletaDetalhes.getDataAgendada());
        coleta.setHoraAgendada(coletaDetalhes.getHoraAgendada());

        return coletaRepository.save(coleta);
    }

    public void deletarColeta(Long id){
        coletaRepository.deleteById(id);
    }
}
