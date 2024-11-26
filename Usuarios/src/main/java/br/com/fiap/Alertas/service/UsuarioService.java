package br.com.fiap.Alertas.service;
import br.com.fiap.Alertas.Exception.UsuarioNaoEncontradoException;
import br.com.fiap.Alertas.dto.UsuarioCadastroDto;
import br.com.fiap.Alertas.dto.UsuarioExibicaoDto;
import br.com.fiap.Alertas.model.Usuario;
import br.com.fiap.Alertas.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    //abaixo passamos a senha criptografada pro usuario spring security (as duas linhas abaixos)

    public UsuarioExibicaoDto salvarUsuario(UsuarioCadastroDto usuarioCadastroDto){
        String senhaCriptografada = new BCryptPasswordEncoder().encode(usuarioCadastroDto.senha());

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioCadastroDto, usuario); // <aqui copiamos as informações do cadastrodto para usuario, fazemos isso para conseguirmos chamar o SAVE nas linhas 30 e 31 mais abaixo, analise o codigo.
        usuario.setSenha(senhaCriptografada); // <aqui alteramos a senha simples de usuario,para a criptografada
        //a estrutura são as tres linhas / spring security

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new UsuarioExibicaoDto(usuarioSalvo);
    }

    public UsuarioExibicaoDto buscarPorId(long id){
        Optional<Usuario>usuarioOptional =
                usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()){
            return new UsuarioExibicaoDto(usuarioOptional.get());
        } else {
            throw new UsuarioNaoEncontradoException("Usuario não existe no banco de dados!");
        }
    }
    public List<UsuarioExibicaoDto> listarTodos(){
        return usuarioRepository
                .findAll()
                .stream()
                .map(UsuarioExibicaoDto::new)
                .toList();
    }
}