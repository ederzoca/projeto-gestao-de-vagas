package br.com.ederjr.gestao_de_vagas.modules.candidate.services;

import br.com.ederjr.gestao_de_vagas.exceptions.NoUsersException;
import br.com.ederjr.gestao_de_vagas.exceptions.UserFoundException;
import br.com.ederjr.gestao_de_vagas.modules.candidate.entities.CandidateEntity;
import br.com.ederjr.gestao_de_vagas.modules.candidate.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity createCandidate(CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
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
}
