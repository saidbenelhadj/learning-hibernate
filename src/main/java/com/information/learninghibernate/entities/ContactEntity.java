package com.information.learninghibernate.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name ="contact")
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message="Le Nom et Prenom sont obligatoires")
    @Pattern(regexp = "^[\\p{L}\\-]{4,100}$", 
    flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.DOTALL},
    message = "{contact.name.regex.message}"
    )
    @Column(nullable = false, length =100)
    private String name;
    
    @NotBlank
    @Email
    @Column(nullable = false, length =100, unique = true)
    private String email;

    @NotBlank
    @Size(min = 10, max =1000, message = "Merci de rentrer un message")
    @Column(columnDefinition = "TEXT", nullable = false)
    private String message;

}
