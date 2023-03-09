package project.africa.emailing_app.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.africa.emailing_app.data.model.Recipient;

public interface RecipientRepository extends JpaRepository <Recipient, Long> {
}
