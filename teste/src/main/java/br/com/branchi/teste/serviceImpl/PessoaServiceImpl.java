package br.com.branchi.teste.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.branchi.teste.exception.AppException;
import br.com.branchi.teste.model.pessoa.Pessoa;
import br.com.branchi.teste.model.pessoa.PessoaDTO;
import br.com.branchi.teste.repository.PessoaRepository;
import br.com.branchi.teste.service.PessoaService;

@Service
public class PessoaServiceImpl implements PessoaService {


	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public List<Pessoa> buscaLista() {
		return pessoaRepository.findAll();
	}
	
	@Override
	public List<Pessoa> buscaGerentes() {
		return pessoaRepository.buscaGerentes();
	}
	
	@Override
	public List<Pessoa> buscaFuncionarios() {
		return pessoaRepository.buscaFuncionarios();
	}

	@Override
	public PessoaDTO salvar(PessoaDTO pessoaDto) throws AppException {
		Optional<Pessoa> pessoaBancoOpt = pessoaRepository.buscaPorCpf(pessoaDto.getCpf());
		if (pessoaBancoOpt.isPresent()) {
			throw new AppException("Já existe um pessoa com o mesmo CPF");
		}

		Pessoa pessoa = new Pessoa(pessoaDto);

		pessoaRepository.save(pessoa);
		return new PessoaDTO(pessoa);
	}

	@Override
	public PessoaDTO buscarPessoaPorId(Long id) throws AppException {
		Optional<Pessoa> pessoaOpt = pessoaRepository.buscaPorId(id);
		if (pessoaOpt.isPresent()) {
			PessoaDTO dto = new PessoaDTO(pessoaOpt.get());
			return dto;
		} else {
			throw new AppException("Não existe nenhum pessoa com esse Id");
		}
	}

	@Override
	public PessoaDTO alterar(Long id, PessoaDTO pessoaDTO) throws AppException {
		Optional<Pessoa> pessoaOpt = pessoaRepository.buscaPorId(id);
		if (pessoaOpt.isEmpty()) {
			throw new AppException("Não existe nenhum pessoa com esse Id");
		}
		pessoaRepository.save(new Pessoa(id, pessoaDTO));
		return pessoaDTO;
	}

	@Override
	public void delete(Long id) throws AppException {
		Optional<Pessoa> pessoaOpt = pessoaRepository.buscaPorId(id);
		if (pessoaOpt.isEmpty()) {
			throw new AppException("Não existe nenhum pessoa com esse Id");
		}
		Pessoa pessoa = pessoaOpt.get();
		pessoaRepository.delete(pessoa);
	}
	
}
