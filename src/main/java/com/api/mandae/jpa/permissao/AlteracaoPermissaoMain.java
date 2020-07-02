package com.api.mandae.jpa.permissao;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.api.mandae.MandaeApplication;
import com.api.mandae.domain.model.Permissao;
import com.api.mandae.domain.repository.PermissaoRepository;

public class AlteracaoPermissaoMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new SpringApplicationBuilder(MandaeApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		PermissaoRepository permissaoRepository = applicationContext.getBean(PermissaoRepository.class);
		Permissao permissao = new Permissao();
		permissao.setId(1L);
		permissao.setNome("chefe do adm");
		permissao.setDescricao("pode mais");
		
		permissao = permissaoRepository.salvar(permissao);
		
		System.out.println("Atualização da permissão: " + permissao.getNome());
	}
}
