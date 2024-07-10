package br.com.ederjr.gestao_de_vagas.modules.candidate.controllers;

import br.com.ederjr.gestao_de_vagas.exceptions.NoUsersException;
import br.com.ederjr.gestao_de_vagas.modules.candidate.services.CandidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.ederjr.gestao_de_vagas.modules.candidate.entities.CandidateEntity;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @PostMapping("/create")
    public ResponseEntity<Object> createCandidate(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            var result = this.candidateService.createCandidate(candidateEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/list")
    public ResponseEntity<Object> listCandidates() {
        try {
          List<CandidateEntity> result = this.candidateService.listCandidates();
          return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
