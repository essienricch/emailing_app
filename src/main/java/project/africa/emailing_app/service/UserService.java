package project.africa.emailing_app.service;

import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.data.domain.Page;
import project.africa.emailing_app.data.dto.userDto.request.*;
import project.africa.emailing_app.data.dto.userDto.response.RegisterUserResponse;
import project.africa.emailing_app.data.model.UserContact;

import java.util.Optional;

public interface UserService {

    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);
    UserContact updateUserContact(JsonPatch updatePayload, Long userId) throws JsonPatchException;
    void deleteContact(Long userId);
    UserContact getContactById(Long userId);
    void saveContact(UserContact contact);

    Page <UserContact> getAllContact(int pageNumber);
    Optional <UserContact> getContact(Long userId);



}
