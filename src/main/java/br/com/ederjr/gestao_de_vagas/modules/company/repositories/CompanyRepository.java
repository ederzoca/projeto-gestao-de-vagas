package br.com.ederjr.gestao_de_vagas.modules.company.repositories;

import br.com.ederjr.gestao_de_vagas.modules.candidate.entities.CandidateEntity;
import br.com.ederjr.gestao_de_vagas.modules.company.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
    Optional<CompanyEntity> findByUsernameOrEmail(String username, String email); // Se ele não encontrar nada, vão ser retornadas algumas opções

}
