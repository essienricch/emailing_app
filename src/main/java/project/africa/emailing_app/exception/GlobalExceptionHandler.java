package project.africa.emailing_app.exception;

import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {UserDbException.class, ImageUploadException.class, JsonPatchException.class})
    public ResponseEntity <?> userExceptionHandler(Exception e, WebRequest request){
        AppErrorException errorException = new AppErrorException(
            e.getMessage(), request.getDescription(false), new Date());
        return ResponseEntity.badRequest().body(errorException);
    }
}
