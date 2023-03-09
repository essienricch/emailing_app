package project.africa.emailing_app.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.africa.emailing_app.data.model.Address;

public interface AddressRepository extends JpaRepository <Address, Long> {
}
