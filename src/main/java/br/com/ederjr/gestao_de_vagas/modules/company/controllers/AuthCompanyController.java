package br.com.ederjr.gestao_de_vagas.modules.company.controllers;

import br.com.ederjr.gestao_de_vagas.modules.company.dto.AuthCompanyDTO;
import br.com.ederjr.gestao_de_vagas.modules.company.services.AuthCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthCompanyController {

    @Autowired
    private AuthCompanyService authCompanyService;

    @PostMapping("/company")
    public String create(@RequestBody AuthCompanyDTO authCompanyDTO) {
        return this.authCompanyService.execute(authCompanyDTO);
    }

}
