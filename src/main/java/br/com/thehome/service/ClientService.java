package br.com.thehome.service;
import br.com.thehome.dto.request.ClientRequestDTO;
import br.com.thehome.dto.response.ClientResponseDTO;
import br.com.thehome.model.Client;
import br.com.thehome.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<ClientResponseDTO> findAll() {
        List<Client> clients = clientRepository.findAll();
        List<ClientResponseDTO> clientsResponseDTOS = new ArrayList<>();
        for (Client client : clients) {
            clientsResponseDTOS.add(toResponseFromEntity(client));
        }
        return clientsResponseDTOS;
    }

    public ClientResponseDTO findById(Long id) {
        Client client = clientRepository.findById(id).get();
        return toResponseFromEntity(client);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public ClientResponseDTO update(Long id, ClientRequestDTO clientRequestDTO) {
        Client client = clientRepository.findById(id).get();
        client.setName(clientRequestDTO.getName());
        client.setCpfCnpj(clientRequestDTO.getCpfCnpj());
        client.setTelephone(clientRequestDTO.getTelephone());
        client.setEmail(clientRequestDTO.getEmail());
        return toResponseFromEntity(clientRepository.save(client));
    }

    public ClientResponseDTO createEntityFromRequest(ClientRequestDTO clientRequestDTO) {
        Client client = toEntityFromRequest(clientRequestDTO);
        clientRepository.save(client);
        return toResponseFromEntity(client);
    }

    public ClientResponseDTO toResponseFromEntity(Client entity) {
        return ClientResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .cpfCnpj(entity.getCpfCnpj())
                .telephone(entity.getTelephone())
                .email(entity.getEmail())
                .build();
    }

    public Client toEntityFromRequest(ClientRequestDTO request) {
        return Client
                .builder()
                .name(request.getName())
                .cpfCnpj(request.getCpfCnpj())
                .telephone(request.getTelephone())
                .email(request.getEmail())
                .build();
    }
}
