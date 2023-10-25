package by.tms.springmarket66.dto;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateDto {
    @NotNull
    @NotEmpty
    @Email(regexp = ".*@[a-z]*\\.[a-z]{2,}")
    private String email;

    @NotNull
    @NotEmpty(message = "Should be not empty")
    private String password;

    @NotEmpty(message = "Should be not empty")
    Set<String> roles;
}
