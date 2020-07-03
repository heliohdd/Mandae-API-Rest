package com.api.mandae.jpa.cidade;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.api.mandae.MandaeApplication;
import com.api.mandae.domain.model.Cidade;
import com.api.mandae.domain.repository.CidadeRepository;

public class ListaCidadeMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(MandaeApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);
		
		List<Cidade> cidades = cidadeRepository.listar();
		
		for(Cidade cidade : cidades) {
			System.out.printf("%s - %s %n", cidade.getNome(), cidade.getEstado().getNome());
		}
	}
}
