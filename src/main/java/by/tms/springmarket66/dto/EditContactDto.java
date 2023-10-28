package by.tms.springmarket66.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EditContactDto {

    private String email;

    @NotNull
    private Set<String> type;

    private String contact;
}
