package br.com.fiap.Alertas.Advice;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


    @RestControllerAdvice  //Responsavel por tratar todas as Excessões dessa classe
    public class ApplicationExceptionHandler {

        // Map< String, String> Aqui devolvemos pro cliente um atributo chave e valor ou seja, pensando na estrutura JSON
        // (atributo "nome":"", valor: mensagem "mensagem a ser repassada"

        @ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(MethodArgumentNotValidException.class)                                                //<<
        public Map<String, String> manusearArgumentosInvalidos(MethodArgumentNotValidException erro) { //Essa função vai manusear erros do tipo MethodArgumentNotValidException
            Map<String, String> mapaDeErro = new HashMap<>();
            List<FieldError> campos = erro.getBindingResult().getFieldErrors();

            for (FieldError campo : campos) {
                mapaDeErro.put(campo.getField(), campo.getDefaultMessage());
            }
            return mapaDeErro;
        }

        @ResponseStatus(HttpStatus.CONFLICT)
        @ExceptionHandler(DataIntegrityViolationException.class)
        public Map<String, String> manusearIntegridadeDosDados() {
            Map<String, String> mapaErro = new HashMap<>();
            mapaErro.put("erro", "já cadastrado!");
            return mapaErro;
        }

    }


