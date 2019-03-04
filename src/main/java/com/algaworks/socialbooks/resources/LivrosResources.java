package com.algaworks.socialbooks.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.tasks.Task;

@RestController
public class LivrosResources {
	public static int totalComponentes = 0;
	@RequestMapping(value = "/livros", method = RequestMethod.GET)
	public List<Livro> listar() {
		Livro l1 = new Livro("Rest Aplicado");
		Livro l2 = new Livro("Git passo a passo");
		Livro[] livros = {l1, l2};
		return Arrays.asList(livros);
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

		List<Integer> lista1 = inteiros.subList(0, 25);
		List<Integer> lista2 = inteiros.subList(25, 50);
		List<Integer> lista3 = inteiros.subList(50, 75);
		List<Integer> lista4 = inteiros.subList(75, 100);
		
		total.add(lista1);
		total.add(lista2);
		total.add(lista3);
		total.add(lista4);
		
		total.forEach(f-> {
			totalComponentes = totalComponentes + f.size();
		});
		
		System.out.println(lista1.size());
		System.out.println(lista2.size());
		System.out.println(lista3.size());
		System.out.println(lista4.size());
		System.out.println("Total componentes: " + totalComponentes);
		return total;
	}
	
}
