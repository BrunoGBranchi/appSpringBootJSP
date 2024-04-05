package br.com.branchi.teste.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.branchi.teste.exception.AppException;
import br.com.branchi.teste.model.enums.Risco;
import br.com.branchi.teste.model.enums.Status;
import br.com.branchi.teste.model.projeto.AtributosProjetoDTO;
import br.com.branchi.teste.model.projeto.Projeto;
import br.com.branchi.teste.model.projeto.ProjetoDTO;
import br.com.branchi.teste.repository.ProjetoRepository;
import br.com.branchi.teste.service.PessoaService;
import br.com.branchi.teste.service.ProjetoService;

@Service
public class ProjetoServiceImpl implements ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepository;

	@Autowired
	private PessoaService pessoaService;
	
	@Override
	public List<Projeto> buscaLista() {
		return projetoRepository.findAll();
	}
	
	@Override
	public AtributosProjetoDTO buscaAtributos() {
		AtributosProjetoDTO atributos = new AtributosProjetoDTO();
		atributos.setMembrosList(pessoaService.buscaFuncionarios());
		atributos.setGerentesList(pessoaService.buscaGerentes());
		atributos.setRiscosList(Arrays.asList(Risco.values()));
		atributos.setStatusList(Arrays.asList(Status.values()));
		return atributos;
	}
	
	@Override
	public ProjetoDTO salvar(ProjetoDTO projetoDto) throws AppException {
		Optional<Projeto> projetoBancoOpt = projetoRepository.buscaPorNome(projetoDto.getNome());
		if (projetoBancoOpt.isPresent()) {
			throw new AppException("Já existe um projeto com o mesmo nome");
		}

		Projeto projeto = new Projeto(projetoDto);

		projetoRepository.save(projeto);
		return new ProjetoDTO(projeto);
	}

	@Override
	public ProjetoDTO buscarProjetoPorId(Long id) throws AppException {
		Optional<Projeto> projetoOpt = projetoRepository.buscaPorId(id);
		if (projetoOpt.isPresent()) {
			ProjetoDTO dto = new ProjetoDTO(projetoOpt.get());
			return dto;
		} else {
			throw new AppException("Não existe nenhum projeto com esse Id");
		}
	}

	@Override
	public ProjetoDTO alterar(Long id, ProjetoDTO projetoDTO) throws AppException {
		Optional<Projeto> projetoOpt = projetoRepository.buscaPorId(id);
		if (projetoOpt.isEmpty()) {
			throw new AppException("Não existe nenhum projeto com esse Id");
		}
		projetoRepository.save(new Projeto(id, projetoDTO));
		return projetoDTO;
	}

	@Override
	public void delete(Long id) throws AppException {
		Optional<Projeto> projetoOpt = projetoRepository.buscaPorId(id);
		if (projetoOpt.isEmpty()) {
			throw new AppException("Não existe nenhum projeto com esse Id");
		}
		Status status = projetoOpt.get().getStatus();
		if (Status.INICIADO.equals(status) || Status.EM_ANDAMENTO.equals(status) || Status.ENCERRADO.equals(status)) {
			throw new AppException("Este projeto não pode mais ser excluido");
		}
		projetoRepository.delete(projetoOpt.get());
	}
	
}
