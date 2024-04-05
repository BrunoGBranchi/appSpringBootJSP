<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="mb-3">
    <label for="nome" class="form-label">Nome</label>
    <input type="text" class="form-control" id="nome" name="nome" value="${projetoDTO.nome}">
</div>

<div class="mb-3">
    <label for="descricao" class="form-label">Descrição</label>
    <textarea class="form-control" id="descricao" name="descricao">${projetoDTO.descricao}</textarea>
</div>

<div class="mb-3">
    <label for="dataInicio" class="form-label">Data de Início</label>
    <input type="date" class="form-control" id="dataInicio" name="dataInicio" value="${projetoDTO.dataInicio}">
</div>

<div class="mb-3">
    <label for="dataPrevisaoFim" class="form-label">Data Prevista de Fim</label>
    <input type="date" class="form-control" id="dataPrevisaoFim" name="dataPrevisaoFim" value="${projetoDTO.dataPrevisaoFim}">
</div>

<div class="mb-3">
    <label for="dataFim" class="form-label">Data de Fim</label>
    <input type="date" class="form-control" id="dataFim" name="dataFim" value="${projetoDTO.dataFim}">
</div>

<div class="mb-3">
    <label for="orcamento" class="form-label">Orçamento</label>
    <input type="number" step="0.01" class="form-control" id="orcamento" name="orcamento" value="${projetoDTO.orcamento}">
</div>

<div class="mb-3">
    <label for="status" class="form-label">Status</label>
    <select class="form-select" id="status" name="status">
        <c:forEach items="${atributosDTO.statusList}" var="status">
            <option value="${status}" ${projetoDTO.status eq status ? 'selected' : ''}>${status.label}</option>
        </c:forEach>
    </select>
</div>

<div class="mb-3">
    <label for="risco" class="form-label">Risco</label>
    <select class="form-select" id="risco" name="risco">
        <c:forEach items="${atributosDTO.riscosList}" var="risco">
            <option value="${risco}" ${projetoDTO.risco eq risco ? 'selected' : ''}>${risco.label}</option>
        </c:forEach>
    </select>
</div>

<div class="mb-3">
    <label for="gerente" class="form-label">Gerente</label>
    <select class="form-select" id="gerente" name="gerente">
        <c:forEach items="${atributosDTO.gerentesList}" var="gerente">
            <option value="${gerente}" ${projetoDTO.gerente.id == gerente.id ? 'selected' : ''}>${gerente.nome}</option>
        </c:forEach>
    </select>
</div>

<div class="mb-3">
    <label for="membros" class="form-label">Membros</label>
    <select multiple class="form-select" id="membros" name="membros">
        <c:forEach items="${atributosDTO.membrosList}" var="membro">
            <option value="${membro}" ${projetoDTO.membros.contains(membro) ? 'selected' : ''}>${membro.nome}</option>
        </c:forEach>
    </select>
</div>
