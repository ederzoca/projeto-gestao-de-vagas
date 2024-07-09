package br.com.ederjr.gestao_de_vagas.modules.company.controllers;

import br.com.ederjr.gestao_de_vagas.modules.company.entities.CompanyEntity;
import br.com.ederjr.gestao_de_vagas.modules.company.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    
    @PostMapping("/create")
    public void create(@RequestBody CompanyEntity companyEntity) {
        this.companyService.execute(companyEntity);
    }
}