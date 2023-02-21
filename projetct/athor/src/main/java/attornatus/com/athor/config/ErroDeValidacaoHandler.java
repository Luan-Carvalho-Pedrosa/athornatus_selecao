package attornatus.com.athor.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ErroDeValidacaoHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroDeValidacaoDTO> handle(MethodArgumentNotValidException exception){


        List<ErroDeValidacaoDTO> DTO = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

        fieldErrors.forEach(
            e -> {
                String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
                ErroDeValidacaoDTO erro = new ErroDeValidacaoDTO(e.getField(), mensagem);
                DTO.add(erro);
            }
        );

        return DTO;

    }
    
}
