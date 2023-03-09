package project.africa.emailing_app.controller;

import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.africa.emailing_app.data.dto.userDto.request.RegisterUserRequest;
import project.africa.emailing_app.service.UserService;

@AllArgsConstructor
@RequestMapping("/api/v1/user")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity <?> registerUser(@RequestBody RegisterUserRequest registerUserRequest){
        var registerResponse = userService.registerUser(registerUserRequest);
        return new ResponseEntity<>(registerResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity <?> getUserById(@PathVariable Long userId){
        var contact = userService.getContactById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(contact);
    }

    @GetMapping("/all/{pageNumber}")
    public ResponseEntity <?> getAllUser(@PathVariable int pageNumber){
        var response = userService.getAllContact(pageNumber);
        return ResponseEntity.ok(response.getContent());
    }

    @PatchMapping(value = "/update/{userId}", consumes = {"application/json-patch+json"})
    public ResponseEntity <?> updateUserContact(@PathVariable Long userId, @RequestBody JsonPatch updatePayload) throws JsonPatchException {
        var updatedContact = userService.updateUserContact(updatePayload, userId);
        return ResponseEntity.status(HttpStatus.OK).body(updatedContact);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity <?> deleteContact(@PathVariable Long userId){
        userService.deleteContact(userId);
        return ResponseEntity.ok("Contact successfully deleted");
    }
}
