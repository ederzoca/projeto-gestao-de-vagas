package br.com.ederjr.gestao_de_vagas.modules.company.services;

import br.com.ederjr.gestao_de_vagas.modules.company.entities.JobEntity;
import br.com.ederjr.gestao_de_vagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity createJob(JobEntity jobEntity)  {
        return this.jobRepository.save(jobEntity);
    }
}
