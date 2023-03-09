package project.africa.emailing_app.service.userServ;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import project.africa.emailing_app.EmailingAppApplication;
import project.africa.emailing_app.data.dto.userDto.request.RegisterUserRequest;
import project.africa.emailing_app.service.UserService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = EmailingAppApplication.class)
class UserServiceImplTest {

    @Autowired
    private UserService userService;


    @Test
    void registerUserTest(){
        var userRequest = RegisterUserRequest.builder()
                .userName("SDM")
                .emailAddress("sdm-pdp@yahoo.com")
                .password("2023")
                .build();
        var registerResponse = userService.registerUser(userRequest);
        assertThat(registerResponse).isNotNull();

    }

}