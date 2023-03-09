package project.africa.emailing_app.data.dto.userDto.response;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class RegisterUserResponse {

    private Long userId;
    private int statusCode;
    private String message;

}
