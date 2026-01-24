package main.com.userapp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Setter
@Getter
public class UserData {
    private String firstname;
    private String lastname;
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    private String city;

    public UserData() {

    }



}
