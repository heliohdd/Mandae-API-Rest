package com.api.mandae.jpa.permissao;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.api.mandae.MandaeApplication;
import com.api.mandae.domain.model.Permissao;
import com.api.mandae.domain.repository.PermissaoRepository;

public class ListaPermissaoMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(MandaeApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		PermissaoRepository permissaoRepository = applicationContext.getBean(PermissaoRepository.class);
		
		List<Permissao> permissoes = permissaoRepository.listar();
		
		for(Permissao permissao : permissoes) {
			System.out.printf("%s - %s %n", permissao.getNome(), permissao.getDescricao());
		}
	}
}
