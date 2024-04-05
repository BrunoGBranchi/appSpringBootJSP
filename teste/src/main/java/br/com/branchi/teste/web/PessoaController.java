package br.com.branchi.teste.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.branchi.teste.exception.AppException;
import br.com.branchi.teste.model.pessoa.Pessoa;
import br.com.branchi.teste.model.pessoa.PessoaDTO;
import br.com.branchi.teste.service.PessoaService;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
    private PessoaService pessoaService;

    @GetMapping
    public String getAllPessoas(Model model) {
        try {
            List<Pessoa> pessoas = pessoaService.buscaLista();
            model.addAttribute("pessoas", pessoas);
        } catch (AppException e) {
        	model.addAttribute("erro", e.getMessage());
        } catch (Exception e) {
        	model.addAttribute("erro", e.getMessage());
        }
        return "pessoa/pessoaList";
    }
    
    @GetMapping("/novo")
    public String novo() {
        return "pessoa/novo";
    }

    @GetMapping("/{id}")
    public String getPessoaById(@PathVariable("id") Long id, Model model) {
        try {
            PessoaDTO pessoaDTO = pessoaService.buscarPessoaPorId(id);
            model.addAttribute("pessoaDTO", pessoaDTO);
        } catch (AppException e) {
        	model.addAttribute("erro", e.getMessage());
        } catch (Exception e) {
        	model.addAttribute("erro", e.getMessage());
        }
        return "pessoa/editar";
    }

    @PostMapping
    public ResponseEntity<String> savePessoa(@RequestBody PessoaDTO pessoaDTO) {
        try {
            pessoaService.salvar(pessoaDTO);
            return ResponseEntity.ok("Pessoa adicionada com sucesso!");
        } catch (AppException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar pessoa: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public String updatePessoa(@PathVariable("id") Long id, @ModelAttribute("pessoa") PessoaDTO pessoaDTO, Model model) {
        try {
            pessoaService.alterar(id, pessoaDTO);
            model.addAttribute("sucesso", "Pessoa alterada com sucesso!");
        } catch (AppException e) {
        	model.addAttribute("erro", e.getMessage());
        } catch (Exception e) {
        	model.addAttribute("erro", e.getMessage());
        }
        return "redirect:/pessoas";
    }

    @DeleteMapping("/{id}")
    public String deletePessoa(@PathVariable("id") Long id, Model model) {
        try {
            pessoaService.delete(id);
            model.addAttribute("sucesso", "Pessoa apagada com sucesso!");
        } catch (AppException e) {
        	model.addAttribute("erro", e.getMessage());
        } catch (Exception e) {
        	model.addAttribute("erro", e.getMessage());
        }
        return "redirect:/pessoas";
    }

   
}

