package br.com.ederjr.gestao_de_vagas.modules.company.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name="company")
public class CompanyEntity {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Pattern(regexp = "\\S+", message = "O campo [username] não pode conter espaço.")
    private String username;

    @Email(message = "O campo [email] deve conter um email válido.")
    private String email;

    @Length(min = 8, max = 30, message = "A [senha] deve conter entre 8 e 30 caracteres.")
    private String password;
    private String website;
    private String cnpj;
    private String name;
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
