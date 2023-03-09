package project.africa.emailing_app.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.threeten.bp.LocalDateTime;
import project.africa.emailing_app.cloud.CloudService;
import project.africa.emailing_app.data.dto.userDto.request.*;
import project.africa.emailing_app.data.dto.userDto.response.RegisterUserResponse;
import project.africa.emailing_app.data.model.AppUser;
import project.africa.emailing_app.data.model.UserContact;
import project.africa.emailing_app.data.repository.ContactRepository;
import project.africa.emailing_app.exception.UserDbException;


import java.util.Optional;

import static project.africa.emailing_app.util.AppUtilities.NUMBER_OF_ITEMS_PER_PAGES;

@AllArgsConstructor
@Slf4j
@Service
public class UserServiceImpl implements UserService {


    private final ContactRepository contactRepository;

    private final CloudService cloudService;

    private final ModelMapper modelMapper;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
            AppUser user = modelMapper.map(registerUserRequest, AppUser.class);
            user.setCreatedAt(LocalDateTime.now());
            UserContact contact = UserContact.builder()
                    .user(user)
                    .build();
           UserContact newContact = contactRepository.save(contact);
           return  RegisterUserResponse.builder()
                   .userId(newContact.getId())
                   .statusCode(HttpStatus.CREATED.value())
                   .message("User created Successfully")
                   .build();
    }

    @Override
    public UserContact updateUserContact(JsonPatch updatePayload, Long userId)  {
        ObjectMapper mapper = new ObjectMapper();
        var contact = getContactById(userId);
        var node = mapper.convertValue(contact, JsonNode.class);

       try{
        var updateNode =  updatePayload.apply(node);
        UserContact updatedContact = mapper.convertValue(updateNode, UserContact.class);
           return contactRepository.save(updatedContact);
       } catch (JsonPatchException e) {
           log.error(e.getMessage());
           throw new RuntimeException();
       }
    }

    @Override
    public void deleteContact(Long userId) {
        contactRepository.deleteById(userId);
    }

    @Override
    public UserContact getContactById(Long userId) {
      return contactRepository.findById(userId)
                .orElseThrow(() -> new UserDbException(
                        String.format("User with id %d not found",userId)));
    }

    @Override
    public void saveContact(UserContact contact) {
        contactRepository.save(contact);
    }

    @Override
    public Page<UserContact> getAllContact(int pageNumber) {
        if (pageNumber < 0) pageNumber = 0;
        else pageNumber -= 1;
        Pageable pageable = PageRequest.of(pageNumber, NUMBER_OF_ITEMS_PER_PAGES);
        return contactRepository.findAll(pageable);
    }

    @Override
    public Optional<UserContact> getContact(Long userId) {
        return contactRepository.findById(userId);
    }


}
