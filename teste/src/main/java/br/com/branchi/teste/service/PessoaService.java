package br.com.branchi.teste.service;

import java.util.List;

import br.com.branchi.teste.exception.AppException;
import br.com.branchi.teste.model.pessoa.Pessoa;
import br.com.branchi.teste.model.pessoa.PessoaDTO;

public interface PessoaService {

	List<Pessoa> buscaLista();

	PessoaDTO salvar(PessoaDTO pessoaDto) throws AppException;

	PessoaDTO buscarPessoaPorId(Long id) throws AppException;

	PessoaDTO alterar(Long id, PessoaDTO pessoaDTO) throws AppException;

	void delete(Long id) throws AppException;

	List<Pessoa> buscaGerentes();

	List<Pessoa> buscaFuncionarios();

}
