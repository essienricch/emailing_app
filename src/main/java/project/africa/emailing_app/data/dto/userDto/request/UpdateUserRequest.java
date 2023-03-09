package project.africa.emailing_app.data.dto.userDto.request;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.*;
import project.africa.emailing_app.data.model.Address;
import project.africa.emailing_app.data.model.Gender;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateUserRequest {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Address address;
    private Gender gender;

}
