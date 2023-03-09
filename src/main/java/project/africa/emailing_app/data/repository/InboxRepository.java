package project.africa.emailing_app.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.africa.emailing_app.data.model.Inbox;

public interface InboxRepository extends JpaRepository<Inbox, Long> {
}
