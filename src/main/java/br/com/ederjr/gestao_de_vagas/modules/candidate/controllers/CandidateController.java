package br.com.ederjr.gestao_de_vagas.modules.candidate.controllers;

import br.com.ederjr.gestao_de_vagas.exceptions.UserFoundException;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.RestController;

import br.com.ederjr.gestao_de_vagas.modules.candidate.CandidateEntity;
import br.com.ederjr.gestao_de_vagas.modules.candidate.CandidateRepository;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping("/")
    public CandidateEntity create(@Valid @RequestBody CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });


        return this.candidateRepository.save(candidateEntity);
    }
    
}