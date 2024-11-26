package br.com.fiap.Sensores.service;
import br.com.fiap.Sensores.dto.SensoresCadastroDto;
import br.com.fiap.Sensores.dto.SensoresExibicaoDto;
import br.com.fiap.Sensores.model.Sensores;
import br.com.fiap.Sensores.repository.SensoresRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SensoresService {

    @Autowired
    private SensoresRepository sensoresRepository;

    //POST PARA GRAVAR DADOS SENSORES
    public SensoresExibicaoDto gravar(SensoresCadastroDto sensoresCadastroDto){
        Sensores sensores = new Sensores();
        BeanUtils.copyProperties(sensoresCadastroDto, sensores);
        return new SensoresExibicaoDto(sensoresRepository.save(sensores));
    }
    //GET PARA BUSCAR DADOS TIPO
    public Sensores buscarPorNome(String nome){
        Optional<Sensores> sensoresOptional = sensoresRepository.findByNome(nome);
        if (sensoresOptional.isPresent()){
            return sensoresOptional.get();

        }else {

            throw new RuntimeException("Sensor Não Encontrado!");
        }
    }

    //PUT PARA ATUALIZAR POR ID
    public Sensores atualizar (Sensores sensores){
        Optional<Sensores> sensoresOptional = sensoresRepository.findById(sensores.getIdSensor());

        if (sensoresOptional.isPresent()){
            return sensoresRepository.save(sensores);

        }else {
            throw new RuntimeException("Não Encontrado.");
        }
    }
    //DELETE PARA DELETAR UM DADO
    public void excluir (Long idSensor){
        Optional<Sensores> sensoresOptional = sensoresRepository.findById(idSensor);

        if (sensoresOptional.isPresent()){
            sensoresRepository.delete(sensoresOptional.get());
        }else {
            throw new RuntimeException("Não Encontrado");
        }
    }

}