package br.com.fiap.Usuarios.service;
import br.com.fiap.Usuarios.dto.AlertasCadastroDto;
import br.com.fiap.Usuarios.dto.AlertasExibicaoDto;
import br.com.fiap.Usuarios.model.Alertas;
import br.com.fiap.Usuarios.repository.AlertasRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertasService {

    @Autowired
    AlertasRepository alertasRepository;

    //POST PARA GRAVAR DADOS SENSORES
    public AlertasExibicaoDto gravar(AlertasCadastroDto alertasCadastroDto) {
        Alertas alertas = new Alertas();
        BeanUtils.copyProperties(alertasCadastroDto, alertas);
        return new AlertasExibicaoDto(alertasRepository.save(alertas));
    }

}
