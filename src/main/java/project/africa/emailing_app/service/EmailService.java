package project.africa.emailing_app.service;

import project.africa.emailing_app.data.dto.emailDto.request.ComposeEmailRequest;
import project.africa.emailing_app.data.dto.emailDto.request.SendEmailRequest;
import project.africa.emailing_app.data.dto.emailDto.response.ComposeEmailResponse;
import project.africa.emailing_app.data.dto.emailDto.response.SendEmailResponse;
import project.africa.emailing_app.data.model.Email;

public interface EmailService {

    Email getEmailById(Long emailId);
    SendEmailResponse composeAndSendEmail(SendEmailRequest sendEmailRequest);
    ComposeEmailResponse saveEmail(ComposeEmailRequest composeEmailRequest);
    void deleteEmailById(Long EmailId);
}
