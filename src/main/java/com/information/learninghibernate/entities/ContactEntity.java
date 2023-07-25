package com.information.learninghibernate.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactEntity {
    private Integer id;
    @NotBlank(message="Le Nom et Prenom sont obligatoires")
    @Pattern(regexp = "^[\\p{L}\\-]{4,100}$", 
    flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.DOTALL},
    message = "{contact.name.regex.message}"
    )
    private String name;
    
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 10, max =1000, message = "Merci de rentrer un message")
    private String message;

}
