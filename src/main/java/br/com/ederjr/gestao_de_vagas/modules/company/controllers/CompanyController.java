package br.com.ederjr.gestao_de_vagas.modules.company.controllers;

import br.com.ederjr.gestao_de_vagas.exceptions.UserFoundException;
import br.com.ederjr.gestao_de_vagas.modules.company.entities.CompanyEntity;
import br.com.ederjr.gestao_de_vagas.modules.company.services.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    
    @PostMapping("/create")
    public ResponseEntity<Object> createCompany(@Valid @RequestBody CompanyEntity companyEntity) {
        try {
            var result = this.companyService.createCompany(companyEntity);
            return ResponseEntity.ok(result);
        } catch (UserFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<Object> listCompany() {
        try {
           var result = this.companyService.listCompany();
           return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<Object> deleteCompany(@PathVariable String username){
        try {
            this.companyService.deleteCompany(username);
            return ResponseEntity.ok().body("Empresa deletada.");
        } catch (UserFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}