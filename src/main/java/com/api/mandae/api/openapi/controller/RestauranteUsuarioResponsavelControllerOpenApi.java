package com.api.mandae.api.openapi.controller;

import com.api.mandae.api.exceptionhandler.Problem;
import com.api.mandae.api.model.UsuarioDTO;
import io.swagger.annotations.*;
import org.springframework.hateoas.CollectionModel;

@Api(tags = "Restaurantes")
public interface RestauranteUsuarioResponsavelControllerOpenApi {

    @ApiOperation("Lista os usuários responsáveis associados a restaurante")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Restaurante não encontrado", response = Problem.class)
    })
    CollectionModel<UsuarioDTO> listar(
            @ApiParam(value = "ID do restaurante", example = "1", required = true)
                    Long restauranteId);

    @ApiOperation("Desassociação de restaurante com usuário responsável")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Desassociação realizada com sucesso"),
            @ApiResponse(code = 404, message = "Restaurante ou usuário não encontrado",
                    response = Problem.class)
    })
    void desassociar(
            @ApiParam(value = "ID do restaurante", example = "1", required = true)
                    Long restauranteId,

            @ApiParam(value = "ID do usuário", example = "1", required = true)
                    Long usuarioId);

    @ApiOperation("Associação de restaurante com usuário responsável")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Associação realizada com sucesso"),
            @ApiResponse(code = 404, message = "Restaurante ou usuário não encontrado",
                    response = Problem.class)
    })
    void associar(
            @ApiParam(value = "ID do restaurante", example = "1", required = true)
                    Long restauranteId,

            @ApiParam(value = "ID do usuário", example = "1", required = true)
                    Long usuarioId);
}
