package by.tms.springmarket66.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class LoginUserDto {
    @NotNull
    @NotEmpty
    @Email(regexp = ".*@[a-z]*\\.[a-z]{2,}")
    private String email;

    @NotNull
    @NotEmpty(message = "Should be not empty")
    private String password;

}
