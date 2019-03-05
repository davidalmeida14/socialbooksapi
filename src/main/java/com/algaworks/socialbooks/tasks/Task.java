package com.algaworks.socialbooks.tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.algaworks.socialbooks.domain.DadosReais;



public class Task implements Runnable{

	List<Integer> listaProcessar;
	String urlHml = "http://10.60.33.73:7000/v2/api/cartoes/{id}/consultar-dados-reais";
	String urlProd = "http://api.conductor.com.br/pier/v2/api/cartoes/{id}/consultar-dados-reais";
	String diretorioOutput = "C:\\Users\\david\\Desktop\\";
	
	public static Logger log = LoggerFactory.getLogger("INFO");
	public Task(List<Integer> listaProcessar) {
		this.listaProcessar = listaProcessar;
	}
	
	
	@Override
	public void run() {
		
		this.listaProcessar.forEach(p->{
			RestTemplate restTemplate = new RestTemplate();
			
			RequestEntity<Void> requestCard = createRequest(urlProd, p.toString());
			log.info("Enviando request para o Pier | idCartao: " + p.toString());
			
			ResponseEntity<DadosReais> response = restTemplate.exchange(requestCard, DadosReais.class);
			DadosReais resposta = response.getBody();
			
			String urlLimites = "http://api.conductor.com.br/pier/v2/api/limites-disponibilidades?idConta=" + resposta.getIdConta().toString();
			RequestEntity<Void> requestLimites = RequestEntity.get(URI.create(urlLimites))
												  .header("access_token", "DRchdtpgK1MQ")
												  .header("client_id", "9j8F0m65VF7R").build();
			ResponseEntity<Object> responseEntityLimites = restTemplate.exchange(requestLimites, Object.class);
			Object respostaLimites = responseEntityLimites.getBody();
			
			
			String jsonResposta = 
					"{idCartao: " + resposta.getIdCartao() + " idConta: " + resposta.getIdConta() + 
					" numeroCartao: " + resposta.getNumeroCartao() + " dataValidade: " + resposta.getDataValidade() + 
					" cvv2: " + resposta.getCvv2() + " nomePlastico: " + resposta.getNomePlastico()
					+ "}"
					+ "\n ----------------------------------------\n";

			log.info("Resposta PIER: " + jsonResposta);			

			byte[] jsonByte = jsonResposta.getBytes();
			try {
				File f = new File(diretorioOutput);
				if (!f.exists()) {
					f.mkdirs();
				}
				FileOutputStream out = new FileOutputStream(diretorioOutput + "outputCard.txt", true);
				out.write(jsonByte);
				out.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
	}


	private RequestEntity<Void> createRequest(String urlProd2, String idCartao) {
		  return RequestEntity.get(URI.create(urlProd.replace("{id}", idCartao.toString())))
		  .header("access_token", "DRchdtpgK1MQ")
		  .header("client_id", "9j8F0m65VF7R")
		  .build();
	}

	
}
