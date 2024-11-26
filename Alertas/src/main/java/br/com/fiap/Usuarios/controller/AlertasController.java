import br.com.fiap.Usuarios.dto.AlertasCadastroDto;
import br.com.fiap.Usuarios.dto.AlertasExibicaoDto;
import br.com.fiap.Usuarios.service.AlertasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AlertasController {

    @Autowired
    private AlertasService alertasService;

    @PostMapping("/alertas")
    @ResponseStatus(HttpStatus.CREATED)
    public AlertasExibicaoDto gravar (@RequestBody @Valid AlertasCadastroDto alertasCadastroDto){
        return alertasService.gravar(alertasCadastroDto);
    }
}




