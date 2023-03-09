package project.africa.emailing_app.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.africa.emailing_app.data.model.Admin;

public interface AdminRepository extends JpaRepository <Admin, Long> {
}
