package com.example.polling_app.payload;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

@Data
public class ChoiceRequest {
    @NotBlank
    @Size(max = 40)
    private String text;
}
