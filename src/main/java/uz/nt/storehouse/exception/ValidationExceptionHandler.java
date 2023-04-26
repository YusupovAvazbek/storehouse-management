package uz.nt.storehouse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.nt.storehouse.mapper.validator.AppStatusCodes;
import uz.nt.storehouse.mapper.validator.AppStatusMessages;
import uz.nt.storehouse.response.ErrorDto;
import uz.nt.storehouse.response.ResponseDto;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ResponseDto<Void>> methodArgumentNotValidException (MethodArgumentNotValidException e){
        return ResponseEntity.badRequest().body(
            ResponseDto.<Void>builder()
                    .code(AppStatusCodes.OK_CODE)
                    .status(HttpStatus.BAD_REQUEST.value())
                    .message(AppStatusMessages.VALIDATION_ERROR)
                    .errors(e.getBindingResult().getFieldErrors().stream()
                            .map(f -> new ErrorDto(f.getField(), f.getDefaultMessage()))
                            .collect(Collectors.toList()))
                    .build());
    }
    @ExceptionHandler
    public ResponseEntity<ResponseDto<Void>> runtimeException(RuntimeException e){
        return ResponseEntity.internalServerError().body(
            ResponseDto.<Void>builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .message(e.getMessage())
                    .build()
        );
    }
}
