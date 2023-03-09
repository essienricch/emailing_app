package project.africa.emailing_app.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.africa.emailing_app.data.model.AppUser;
import project.africa.emailing_app.data.model.UserContact;

import java.util.Optional;

public interface ContactRepository extends JpaRepository <UserContact, Long> {
}
