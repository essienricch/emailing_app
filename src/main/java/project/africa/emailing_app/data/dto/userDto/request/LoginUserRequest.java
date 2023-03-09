package project.africa.emailing_app.data.dto.userDto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class LoginUserRequest {

    private String emailAddress;
    private String password;
}
