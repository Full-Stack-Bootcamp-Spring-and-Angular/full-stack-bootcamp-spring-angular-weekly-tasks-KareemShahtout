package main.com.userapp.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Setter
@Getter
@Scope("prototype")
public class UserData {
    private String firstname;
    private String lastname;
    private String email;
    private Date dateOfBirth;
    private String city;

    public UserData() {

    }
}
