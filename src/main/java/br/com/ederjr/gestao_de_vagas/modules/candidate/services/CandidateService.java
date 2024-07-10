package br.com.ederjr.gestao_de_vagas.modules.candidate.services;

import br.com.ederjr.gestao_de_vagas.exceptions.NoUsersException;
import br.com.ederjr.gestao_de_vagas.exceptions.UserFoundException;
import br.com.ederjr.gestao_de_vagas.modules.candidate.entities.CandidateEntity;
import br.com.ederjr.gestao_de_vagas.modules.candidate.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity createCandidate(CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsername(candidateEntity.getUsername())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        return this.candidateRepository.save(candidateEntity);
    }

    public List<CandidateEntity> listCandidates() {
        List<CandidateEntity> candidates = candidateRepository.findAll();
        if (candidates.isEmpty()) {
            throw new NoUsersException();
        }
        return candidates;
    }

    public CandidateEntity searchCandidate(String username) {
        var candidate = this.candidateRepository.findByUsername(username);
        if (candidate.isEmpty()) {
            throw new NoUsersException();
        }
        return candidate.get();
    }

    public CandidateEntity updateCandidate(String username, CandidateEntity candidateEntity) {
        var candidate = this.candidateRepository.findByUsername(username)
                .orElseThrow(NoUsersException::new);
        candidate.setName(candidateEntity.getName());
        candidate.setUsername(candidateEntity.getUsername());
        candidate.setEmail(candidateEntity.getEmail());
        candidate.setDescription(candidateEntity.getDescription());
        candidate.setPassword(candidateEntity.getPassword());

        return this.candidateRepository.save(candidate);
    }
}
