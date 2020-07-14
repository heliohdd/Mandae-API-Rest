package com.api.mandae.jpa.restaurante;


import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.api.mandae.MandaeApplication;
import com.api.mandae.domain.model.Cozinha;
import com.api.mandae.domain.model.Restaurante;
import com.api.mandae.domain.repository.RestauranteRepository;

public class InclusaoRestauranteMain {


	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(MandaeApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setId(1L);
		
		Cozinha cozinha2 = new Cozinha();
		cozinha2.setId(2L);
		
		Restaurante  restaurante1 = new Restaurante();
		restaurante1.setNome("Oloko bicho");
		restaurante1.setTaxaFrete(new BigDecimal(6.00));
		restaurante1.setCozinha(cozinha1);
		
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("Tá pegando fogoo");
		restaurante2.setTaxaFrete(new BigDecimal(5.57));
		restaurante2.setCozinha(cozinha2);
		
		restaurante1 = restauranteRepository.salvar(restaurante1);
		restaurante2 = restauranteRepository.salvar(restaurante2);
		
		System.out.printf("%d - O Restaurante %s foi salvo %n", restaurante1.getId(), restaurante1.getNome());
		System.out.printf("%d - O Restaurante %s foi salvo %n", restaurante2.getId(), restaurante2.getNome());
		
	}
}
