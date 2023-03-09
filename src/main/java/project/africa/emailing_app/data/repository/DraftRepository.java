package project.africa.emailing_app.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.africa.emailing_app.data.model.Draft;

public interface DraftRepository extends JpaRepository <Draft, Long>{

}
