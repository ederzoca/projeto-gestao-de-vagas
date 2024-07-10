package br.com.ederjr.gestao_de_vagas.modules.candidate.controllers;

import br.com.ederjr.gestao_de_vagas.exceptions.NoUsersException;
import br.com.ederjr.gestao_de_vagas.modules.candidate.services.CandidateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.ederjr.gestao_de_vagas.modules.candidate.entities.CandidateEntity;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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
          var result = this.candidateService.listCandidates();
          return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/list/{username}")
    public ResponseEntity<Object> searchCandidate(@PathVariable String username) {
        try {
            var result = this.candidateService.searchCandidate(username);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<Object> updateCandidate(@PathVariable String username, @Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            var result = this.candidateService.updateCandidate(username, candidateEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<Object> deleteCandidate(@PathVariable String username) {
        try {
            this.candidateService.deleteCandidate(username);
            return ResponseEntity.ok().body("Usuário deletado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
