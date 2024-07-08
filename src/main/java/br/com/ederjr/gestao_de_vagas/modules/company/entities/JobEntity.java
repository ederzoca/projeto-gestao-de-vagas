package br.com.ederjr.gestao_de_vagas.modules.company.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity(name="job")
public class JobEntity {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String description;
    private String benefits;
    private String level;

    @ManyToOne
    @JoinColumn(name = "company_id") // Indica a chave estrangeira que deve ser recebida
    private CompanyEntity companyEntity;

    @Column(name = "company_id")
    private UUID idCompany;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
