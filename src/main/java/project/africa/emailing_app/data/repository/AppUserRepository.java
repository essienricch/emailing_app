package project.africa.emailing_app.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.africa.emailing_app.data.model.AppUser;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository <AppUser, Long>  {

    boolean existsByEmailAddress(String emailAddress);
}
