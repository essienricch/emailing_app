package project.africa.emailing_app.data.dto.emailDto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class SendEmailResponse {

    private String message;
    private LocalDate sentTime;
}
