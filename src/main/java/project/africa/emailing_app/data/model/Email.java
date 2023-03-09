package project.africa.emailing_app.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String subject;
    private String body;
    private LocalDateTime timeSent;

    @OneToOne(cascade = CascadeType.ALL)
    private Sender sender;

    @OneToMany(cascade = CascadeType.ALL)
    private Set <Recipient> recipients;

    @Transient
    private MultipartFile attachments;
}
