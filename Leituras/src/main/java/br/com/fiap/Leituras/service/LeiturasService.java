package br.com.fiap.Leituras.service;
import br.com.fiap.Leituras.dto.LeiturasCadastroDto;
import br.com.fiap.Leituras.dto.LeiturasExibicaoDto;
import br.com.fiap.Leituras.model.Leituras;
import br.com.fiap.Leituras.repository.LeiturasRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LeiturasService {

    @Autowired
    private LeiturasRepository leiturasRepository;

    //POST PARA GRAVAR
    public LeiturasExibicaoDto gravar(LeiturasCadastroDto leiturasCadastroDto) {
        Leituras leituras = new Leituras();
        BeanUtils.copyProperties(leiturasCadastroDto, leituras);
        return new LeiturasExibicaoDto(leiturasRepository.save(leituras));
    }

    //GET PARA BUSCAR
    public List<LeiturasExibicaoDto> listarLeituras(LocalDateTime dataInicial, LocalDateTime dataFinal) {
        return leiturasRepository.listarLeituras(dataInicial, dataFinal)
                .stream()
                .map(LeiturasExibicaoDto::new)
                .toList();

    }
}
