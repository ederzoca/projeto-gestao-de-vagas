package br.com.ederjr.gestao_de_vagas.modules.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor                             // Cria um construtor com os argumentos
public class AuthCompanyDTO {

    private String password;
    private String username;

}
