package uz.nt.storehouse.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {
    private String field;
    private String error;
}
