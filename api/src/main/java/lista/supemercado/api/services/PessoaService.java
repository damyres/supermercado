package lista.supemercado.api.services;

import lista.supemercado.api.dtos.PessoaDto;
import lista.supemercado.api.entities.Pessoa;
import lista.supemercado.api.repositories.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
//@RequiredArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> findById(UUID id) {
        return pessoaRepository.findById(id);
    }

    public Pessoa save(final PessoaDto pessoaDto) {
        final var pessoa = new Pessoa(pessoaDto);
        return pessoaRepository.save(pessoa);
    }
}
