package com.algaworks.socialbooks.tasks;

import java.util.List;

public class Task implements Runnable{

	List<Integer> listaProcessar;
	
	public Task(List<Integer> listaProcessar) {
		this.listaProcessar = listaProcessar;
	}
	@Override
	public void run() {
		
		System.out.println("O tamanho da lista passada é: " + this.listaProcessar.size());
		
	}

}
