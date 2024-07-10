package br.com.ederjr.gestao_de_vagas.modules.company.services;

import br.com.ederjr.gestao_de_vagas.exceptions.NoUsersException;
import br.com.ederjr.gestao_de_vagas.modules.company.dto.AuthCompanyDTO;
import br.com.ederjr.gestao_de_vagas.modules.company.repositories.CompanyRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class AuthCompanyService {

    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String execute(AuthCompanyDTO authCompanyDTO) {
        var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername())
                .orElseThrow(NoUsersException::new);

        this.passwordEncoder.matches(authCompanyDTO.getPassword(),company.getPassword());           // Verifica se as duas senhas são iguais
        if (authCompanyDTO.getPassword() != company.getPassword()) {                                // Se não forem iguais, retorna um erro
            try {
                throw new AuthenticationException();
            } catch (AuthenticationException e) {
                throw new RuntimeException(e);
            }
        } else {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);                                     // Gerar token se a senha for igual
            var token = JWT.create().withIssuer("Vagas Java")
                            .withSubject(company.getId().toString())
                            .sign(algorithm);
            return token;
        }
    }
}
