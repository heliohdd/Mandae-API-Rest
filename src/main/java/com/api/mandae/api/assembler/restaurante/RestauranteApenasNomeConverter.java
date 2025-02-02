package com.api.mandae.api.assembler.restaurante;

import com.api.mandae.api.MandaeLinks;
import com.api.mandae.api.controller.RestauranteController;
import com.api.mandae.api.model.RestauranteApenasNomeDTO;
import com.api.mandae.domain.model.Restaurante;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class RestauranteApenasNomeConverter extends RepresentationModelAssemblerSupport<Restaurante,
        RestauranteApenasNomeDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MandaeLinks mandaeLinks;

    public RestauranteApenasNomeConverter() {
        super(RestauranteController.class, RestauranteApenasNomeDTO.class);
    }

    @Override public RestauranteApenasNomeDTO toModel(Restaurante restaurante) {

        RestauranteApenasNomeDTO restauranteApenasNomeDTO = createModelWithId(restaurante.getId(), restaurante);

        modelMapper.map(restaurante, restauranteApenasNomeDTO);

        restauranteApenasNomeDTO.add(mandaeLinks.linkToRestaurantes("restaurantes"));

        return restauranteApenasNomeDTO;
    }

    @Override
    public CollectionModel<RestauranteApenasNomeDTO> toCollectionModel(Iterable<? extends Restaurante> entities) {
        return super.toCollectionModel(entities)
                .add(mandaeLinks.linkToRestaurantes());
    }
}
