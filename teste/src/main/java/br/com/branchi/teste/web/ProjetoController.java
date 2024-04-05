package br.com.branchi.teste.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.branchi.teste.exception.AppException;
import br.com.branchi.teste.model.projeto.Projeto;
import br.com.branchi.teste.model.projeto.ProjetoDTO;
import br.com.branchi.teste.service.ProjetoService;

@Controller
@RequestMapping("/projetos")
public class ProjetoController {
	
	@Autowired
    private ProjetoService projetoService;

    @GetMapping
    public String getAllProjetos(Model model) {
        try {
            List<Projeto> projetos = projetoService.buscaLista();
            model.addAttribute("projetos", projetos);
        } catch (AppException e) {
        	model.addAttribute("erro", e.getMessage());
        } catch (Exception e) {
        	model.addAttribute("erro", e.getMessage());
        }
        return "projeto/projetoList";
    }
    
    @GetMapping("/novo")
    public String novo(Model model) {
    	model.addAttribute("atributosDTO", projetoService.buscaAtributos());
        return "projeto/novo";
    }

    @GetMapping("/{id}")
    public String getProjetoById(@PathVariable("id") Long id, Model model) {
        try {
            ProjetoDTO projetoDTO = projetoService.buscarProjetoPorId(id);
            model.addAttribute("projetoDTO", projetoDTO);
            model.addAttribute("atributosDTO", projetoService.buscaAtributos());
        } catch (AppException e) {
        	model.addAttribute("erro", e.getMessage());
        } catch (Exception e) {
        	model.addAttribute("erro", e.getMessage());
        }
        return "projeto/editar";
    }

    @PostMapping
    public String saveProjeto(@ModelAttribute("projeto") ProjetoDTO projetoDTO, Model model) {
        try {
            projetoService.salvar(projetoDTO);
            model.addAttribute("sucesso", "Projeto salvo com sucesso!");
        } catch (AppException e) {
        	model.addAttribute("erro", e.getMessage());
        } catch (Exception e) {
        	model.addAttribute("erro", e.getMessage());
        }
        return "redirect:/projetos";
    }

    @PutMapping("/{id}")
    public String updateProjeto(@PathVariable("id") Long id, @ModelAttribute("projeto") ProjetoDTO projetoDTO, Model model) {
        try {
            projetoService.alterar(id, projetoDTO);
            model.addAttribute("sucesso", "Projeto alterado com sucesso!");
        } catch (AppException e) {
        	model.addAttribute("erro", e.getMessage());
        } catch (Exception e) {
        	model.addAttribute("erro", e.getMessage());
        }
        return "redirect:/projetos";
    }

    @DeleteMapping("/{id}")
    public String deleteProjeto(@PathVariable("id") Long id, Model model) {
        try {
            projetoService.delete(id);
            model.addAttribute("sucesso", "Projeto apagado com sucesso!");
        } catch (AppException e) {
        	model.addAttribute("erro", e.getMessage());
        } catch (Exception e) {
        	model.addAttribute("erro", e.getMessage());
        }
        return "redirect:/projetos";
    }
}

