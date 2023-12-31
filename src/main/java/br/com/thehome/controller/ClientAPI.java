package br.com.thehome.controller;
import br.com.thehome.dto.request.ClientRequestDTO;
import br.com.thehome.dto.response.ClientResponseDTO;
import br.com.thehome.view.ErroView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/api/v1/clients")
@CrossOrigin(origins = {"http://localhost:4200", "http://thehome-angular-app.s3-website-us-east-1.amazonaws.com", "https://thehome-web.vercel.app", "http://thehome-web.vercel.app"})
public interface ClientAPI {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Listas todos os clientes.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClientResponseDTO.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErroView.class))}),
            @ApiResponse(responseCode = "403", description = "Forbidden request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErroView.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErroView.class))})
    })
    ResponseEntity<List<ClientResponseDTO>> findAll();

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Listas todos os clientes.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClientResponseDTO.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErroView.class))}),
            @ApiResponse(responseCode = "403", description = "Forbidden request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErroView.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErroView.class))})
    })
    ResponseEntity<ClientResponseDTO> findById(@PathVariable
                                               @Parameter(description = "Código do cliente", required = true)
                                               Long id);

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Criar novos clientes.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClientResponseDTO.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErroView.class))}),
            @ApiResponse(responseCode = "403", description = "Forbidden request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErroView.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErroView.class))})
    })
    ResponseEntity<ClientResponseDTO> create(@Valid @RequestBody ClientRequestDTO clientRequest);

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Atualizar Cliente.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClientResponseDTO.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErroView.class))}),
            @ApiResponse(responseCode = "403", description = "Forbidden request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErroView.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErroView.class))})
    })
    ResponseEntity<ClientResponseDTO> update(@PathVariable
                                             @Parameter(description = "Código do cliente", required = true)
                                             Long id, @Valid @RequestBody ClientRequestDTO clientRequest);

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletar cliente.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ClientResponseDTO.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErroView.class))}),
            @ApiResponse(responseCode = "403", description = "Forbidden request", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErroView.class))}),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErroView.class))})
    })
    ResponseEntity<?> delete(@PathVariable
                             @Parameter(description = "Código do cliente", required = true)
                             Long id);
}

