package com.api.mandae.api.openapi.controller;

import com.api.mandae.api.exceptionhandler.Problem;
import com.api.mandae.api.model.GrupoDTO;
import com.api.mandae.api.model.input.GrupoInput;
import io.swagger.annotations.*;

import java.util.List;

@Api(tags = "Grupos")
public interface GrupoControllerOpenApi {

    @ApiOperation("Lista os grupos")
    List<GrupoDTO> listar();

    @ApiOperation("Busca um grupo por ID")
    @ApiResponses({
            @ApiResponse(code = 400, message = "ID do grupo inválido", response = Problem.class),
            @ApiResponse(code = 404, message = "Grupo não encontrado", response = Problem.class)
    })
    GrupoDTO buscar(@ApiParam(value = "ID de um grupo", example = "1", required = true) Long id);

    @ApiOperation("Cadastra um grupo")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Grupo cadastrado"),
    })
    GrupoDTO adicionar(
            @ApiParam(name = "corpo", value = "Representação de um novo grupo", required = true)
                    GrupoInput grupoInput);

    @ApiOperation("Atualiza um grupo por ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Grupo atualizado"),
            @ApiResponse(code = 404, message = "Grupo não encontrado", response = Problem.class)
    })
    GrupoDTO atualizar(
            @ApiParam(name = "corpo", value = "Representação de um grupo com os novos dados", required = true) GrupoInput grupoInput,
            @ApiParam(value = "ID de um grupo", example = "1", required = true) Long id);

    @ApiOperation("Exclui um grupo por ID")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Grupo excluído"),
            @ApiResponse(code = 404, message = "Grupo não encontrado", response = Problem.class)
    })
    void remover(@ApiParam(value = "ID de um grupo", example = "1", required = true)
            Long grupoId);
}
