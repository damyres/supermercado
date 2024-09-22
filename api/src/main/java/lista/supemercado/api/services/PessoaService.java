package lista.supemercado.api.services;

import jakarta.transaction.Transactional;
import lista.supemercado.api.dtos.PessoaDto;
import lista.supemercado.api.entities.Pessoa;
import lista.supemercado.api.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;

    @Autowired
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

    public Pessoa update(final Pessoa pessoa) {
        final var update = pessoaRepository.findById(pessoa.getId());
        if (update.isPresent()) {
            update.get().setId(pessoa.getId());
            update.get().setNome(pessoa.getNome());
        }
        return pessoaRepository.save(update.get());
    }

    public void delete(UUID id){
        pessoaRepository.deleteById(id);
    }
}
