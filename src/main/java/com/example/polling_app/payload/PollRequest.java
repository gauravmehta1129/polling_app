package com.example.polling_app.payload;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class PollRequest {
    @NotBlank
    @Size(max = 140)
    private String question;
    @NotNull
    @Size(min = 2, max = 6)
    @Valid
    private List<ChoiceRequest> choices;
    @NotNull
    @Valid
    private PollLength pollLength;

}
