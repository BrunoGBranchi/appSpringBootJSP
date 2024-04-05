package br.com.branchi.teste.service;

import java.util.List;

import br.com.branchi.teste.exception.AppException;
import br.com.branchi.teste.model.projeto.AtributosProjetoDTO;
import br.com.branchi.teste.model.projeto.Projeto;
import br.com.branchi.teste.model.projeto.ProjetoDTO;

public interface ProjetoService {

	List<Projeto> buscaLista();

	ProjetoDTO salvar(ProjetoDTO projetoDto) throws AppException;

	ProjetoDTO buscarProjetoPorId(Long id) throws AppException;

	ProjetoDTO alterar(Long id, ProjetoDTO projetoDTO) throws AppException;

	void delete(Long id) throws AppException;

	AtributosProjetoDTO buscaAtributos();

}
