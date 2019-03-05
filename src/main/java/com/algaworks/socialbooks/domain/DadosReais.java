package com.algaworks.socialbooks.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DadosReais {

	private String numeroCartao;

	private LocalDate dataValidade;
	private String cvv2;
	private String nomePlastico;
	private Long idConta;
	private Long idCartao;
	private Long numeroAgencia;
	private String numeroContaCorrente;
	private int idStatusConta;
	private String statusConta;
	private int idStatusCartao;
	private String statusCartao;
	private boolean flagVirtual;
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}
	public String getCvv2() {
		return cvv2;
	}
	public void setCvv2(String cvv2) {
		this.cvv2 = cvv2;
	}
	public String getNomePlastico() {
		return nomePlastico;
	}
	public void setNomePlastico(String nomePlastico) {
		this.nomePlastico = nomePlastico;
	}
	public Long getIdConta() {
		return idConta;
	}
	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}
	public Long getIdCartao() {
		return idCartao;
	}
	public void setIdCartao(Long idCartao) {
		this.idCartao = idCartao;
	}
	public Long getNumeroAgencia() {
		return numeroAgencia;
	}
	public void setNumeroAgencia(Long numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	public String getNumeroContaCorrente() {
		return numeroContaCorrente;
	}
	public void setNumeroContaCorrente(String numeroContaCorrente) {
		this.numeroContaCorrente = numeroContaCorrente;
	}
	public int getIdStatusConta() {
		return idStatusConta;
	}
	public void setIdStatusConta(int idStatusConta) {
		this.idStatusConta = idStatusConta;
	}
	public String getStatusConta() {
		return statusConta;
	}
	public void setStatusConta(String statusConta) {
		this.statusConta = statusConta;
	}
	public int getIdStatusCartao() {
		return idStatusCartao;
	}
	public void setIdStatusCartao(int idStatusCartao) {
		this.idStatusCartao = idStatusCartao;
	}
	public String getStatusCartao() {
		return statusCartao;
	}
	public void setStatusCartao(String statusCartao) {
		this.statusCartao = statusCartao;
	}
	public boolean isFlagVirtual() {
		return flagVirtual;
	}
	public void setFlagVirtual(boolean flagVirtual) {
		this.flagVirtual = flagVirtual;
	}
	

}
