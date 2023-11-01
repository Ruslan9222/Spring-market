package by.tms.springmarket66.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EditProfileDto {

    private Long id;

    private String email;

    @NotNull
    @NotEmpty(message = "Should be not empty")
    private String firstName;

    @NotNull
    @NotEmpty(message = "Should be not empty")
    private String lastName;

    @NotNull
    @NotEmpty(message = "Should be not empty")
    private String username;

    @NotNull
    @NotEmpty(message = "Should be not empty")
    private String password;
}
