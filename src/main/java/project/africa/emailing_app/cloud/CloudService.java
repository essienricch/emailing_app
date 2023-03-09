package project.africa.emailing_app.cloud;

import org.springframework.web.multipart.MultipartFile;

public interface CloudService {

    String upload(MultipartFile image);
}
