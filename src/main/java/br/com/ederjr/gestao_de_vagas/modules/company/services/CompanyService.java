package br.com.ederjr.gestao_de_vagas.modules.company.services;

import br.com.ederjr.gestao_de_vagas.exceptions.NoUsersException;
import br.com.ederjr.gestao_de_vagas.exceptions.UserFoundException;
import br.com.ederjr.gestao_de_vagas.modules.company.entities.CompanyEntity;
import br.com.ederjr.gestao_de_vagas.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity createCompany(CompanyEntity companyEntity) {
        this.companyRepository.findByUsername(companyEntity.getUsername())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        return this.companyRepository.save(companyEntity);
    }

    public List<CompanyEntity> listCompany() {
       var company = companyRepository.findAll();
       if (company.isEmpty()) {
           throw new NoUsersException();
       }
       return company;
    }

    public void deleteCompany(String username) {
        var candidate = this.companyRepository.findByUsername(username)
                .orElseThrow(NoUsersException::new);
        companyRepository.delete(candidate);
    }
}