package project.africa.emailing_app.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MailConfig {
    private String mailUrl;
    private String apiKey;
}
