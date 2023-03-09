package project.africa.emailing_app.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Value("${cloudinary.cloud.name}")
    private String cloudName;

    @Value("${cloudinary.api.key}")
    private String apiKey;

    @Value("${cloudinary.api.secret}")
    private String apiSecret;
    @Value("${sendinblue.mail.url}")
    private  String mailUrl;

    @Value("${sendinblue.mail.apikey}")
    private String mailApiKey;

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(
                ObjectUtils.asMap("cloud_name",cloudName,
                        "api_key",apiKey,
                        "api_secret",apiSecret));

    }

    @Bean
    public MailConfig mailConfig(){
        return new MailConfig(mailUrl, mailApiKey);
    }
}
