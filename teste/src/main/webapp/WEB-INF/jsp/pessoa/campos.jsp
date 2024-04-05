<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="mb-3">
    <label for="nome" class="form-label">Nome</label>
    <input type="text" class="form-control" id="nome" name="nome" value="${pessoaDTO.nome}">
</div>

<div class="mb-3">
    <label for="dataNascimento" class="form-label">Data de Nascimento</label>
    <input type="date" class="form-control" id="dataNascimento" name="dataNascimento" value="${pessoaDTO.dataNascimento}">
</div>

<div class="mb-3">
    <label for="cpf" class="form-label">CPF</label>
    <input type="text" class="form-control" id="cpf" name="cpf" value="${pessoaDTO.cpf}">
</div>

<div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="funcionario" name="funcionario" ${pessoaDTO.funcionario ? 'checked' : ''}>
    <label class="form-check-label" for="funcionario">Funcionário</label>
</div>

<div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="gerente" name="gerente" ${pessoaDTO.gerente ? 'checked' : ''}>
    <label class="form-check-label" for="gerente">Gerente</label>
</div>
