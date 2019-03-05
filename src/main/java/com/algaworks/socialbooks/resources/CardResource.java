package com.algaworks.socialbooks.resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.socialbooks.tasks.Task;
import com.google.common.collect.Lists;

@RestController
@RequestMapping("/cartoes")
public class CardResource {
	private int totalComponentes;
	private int quantidadeThreads = 4;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public void buscarDadosCartao() {
		String fileName = "C:\\Desenvolvimento\\Python\\java.txt";
		List<String> ids = new ArrayList<String>();
		
		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			ids = stream.collect(Collectors.toList());
			List<Integer> idsInteiros = ids.stream().map(e-> new Integer(e)).collect(Collectors.toList());
			List<List<Integer>> listaTotal = criarListas(idsInteiros);
			List<Task> listaTask = criarTasks(listaTotal);
			
			for(int it=0; it<quantidadeThreads; it++) {
				Thread[] t = new Thread[quantidadeThreads];
				t[it] = new Thread(listaTask.get(it));
				t[it].run();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}	
	

	private void inicio() {
		int quantidadeThreads = 4;
		int i = 100;
		List<Integer> inteiros = new ArrayList<Integer>();
		while(i > 0) {
			inteiros.add(i);
			i--;
		}
		System.out.println("Tamanho da lista: " + inteiros.size());
		
		List<List<Integer>> listaTotal = criarListas(inteiros);
	
		List<Task> listaTask = criarTasks(listaTotal);
		
		for(int it=0; it<quantidadeThreads; it++) {
			Thread[] t = new Thread[quantidadeThreads];
			t[i] = new Thread(listaTask.get(i));
			t[i].run();
		}
	}
	private List<Task> criarTasks(List<List<Integer>> listaTotal) {
		List<Task> listaTask = new ArrayList<Task>();
		listaTotal.forEach(e-> {
			e.forEach(total->{
				Task t = new Task(e);
				listaTask.add(t);
			});
		});
		return listaTask;
	}
	private List<List<Integer>> criarListas(List<Integer> inteiros) {
		List<List<Integer>> total = new ArrayList<List<Integer>>();
		int particoes = (inteiros.size() / 4);
		
		total = Lists.partition(inteiros, particoes);

		
		total.forEach(f-> {
			totalComponentes = totalComponentes + f.size();
		});
		
		System.out.println("Total componentes: " + totalComponentes);
		return total;
	}			
}
