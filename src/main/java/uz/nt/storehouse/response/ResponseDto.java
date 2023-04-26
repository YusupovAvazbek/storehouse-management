package uz.nt.storehouse.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
public class ResponseDto<T> implements Serializable {
    private Integer status;
    private int code;
    private boolean success;
    private String message;
    private T data;
    private List<ErrorDto> errors;

}
