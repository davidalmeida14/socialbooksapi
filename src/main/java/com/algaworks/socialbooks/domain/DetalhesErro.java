package com.algaworks.socialbooks.domain;

public class DetalhesErro {

	private Long status;
	
	private String titulo;
	
	private String mensagemDesenvolvedor;
	
	private Long timestamp;
	

	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getMensagemDesenvolvedor() {
		return mensagemDesenvolvedor;
	}


	public void setMensagemDesenvolvedor(String mensagemDesenvolvedor) {
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}


	public Long getStatus() {
		return status;
	}


	public void setStatus(Long status) {
		this.status = status;
	}


	public Long getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}



	
	
}
