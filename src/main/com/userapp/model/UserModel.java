package main.com.userapp.model;

import lombok.Getter;
import lombok.Setter;
import main.com.userapp.validate.FieldsValueMatch;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Setter
@Getter
@FieldsValueMatch(field = "password", fieldMatch = "confirmPassword", message = "*Password fields do not match")
public class UserModel {
    @NotNull(message = "*First name required")
    @Size(min = 2, message = "*First name required")
    private String firstname;

    @NotNull(message = "*Last name required")
    @Size(min = 2, message = "*Last name required")
    private String lastname;

    private String city;

    @NotNull
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "*Email should be in the format user@domain.com")
    @NotBlank(message = "*Email required")
    private String email;

    @NotNull(message = "*Date required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @NotNull
    @NotEmpty(message = "Password required")
    @Size(min = 7, message = "Password must be at least 7 letters")
    private String password;

    @NotNull
    @NotEmpty(message = "Password required")
    @Size(min = 7, message = "Password must be at least 7 letters")
    private String confirmPassword;


}
