package com.information.learninghibernate.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactEntity {
    private Integer id;
    @NotBlank
    @Pattern(regexp = "^[\\p{L}\\-{4,100}$")
    private String name;
    
    @NotBlank
    @Email
    private String email;
    private String message;

}
