package project.africa.emailing_app.data.dto.emailDto.request;


import lombok.*;
import project.africa.emailing_app.data.model.Email;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SendEmailRequest {

    private Email email;
}
