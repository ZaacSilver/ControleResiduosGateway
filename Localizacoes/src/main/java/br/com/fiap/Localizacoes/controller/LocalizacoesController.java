package br.com.fiap.Localizacoes.controller;
import br.com.fiap.Localizacoes.dto.LocalizacoesCadastroDto;
import br.com.fiap.Localizacoes.dto.LocalizacoesExibicaoDto;
import br.com.fiap.Localizacoes.model.Localizacoes;
import br.com.fiap.Localizacoes.service.LocalizacoesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LocalizacoesController {

    @Autowired
    private LocalizacoesService localizacoesService;

    @PostMapping("/localizacao")
    @ResponseStatus(HttpStatus.CREATED)
    public LocalizacoesExibicaoDto gravar(@RequestBody @Valid LocalizacoesCadastroDto localizacoesCadastroDto) {
        return localizacoesService.gravar(localizacoesCadastroDto);

    }

    @GetMapping("/local/{nomeLocalizacao}")
    @ResponseStatus(HttpStatus.OK)
    public Localizacoes buscarLocalizacao(@PathVariable String nomeLocalizacao) {
        return  localizacoesService.buscarLocalizacao(nomeLocalizacao);

    }

    @PutMapping("/localizacao")
    @ResponseStatus(HttpStatus.OK)
    public Localizacoes atualizar (@RequestBody Localizacoes localizacoes){
        return localizacoesService.atualizar(localizacoes);
    }

    @DeleteMapping("/localizacao/{idLocalizacao}")
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable Long idLocalizacao) {
        localizacoesService.excluir(idLocalizacao);

    }


}
