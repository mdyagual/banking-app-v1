package ec.com.banking.web;

import ec.com.banking.web.dto.request.CreateClientDTO;
import ec.com.banking.web.dto.request.UpdateClientDTO;
import ec.com.banking.web.dto.response.ClientDTO;
import ec.com.banking.web.handler.ClientHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/clients")
public class ClientController {
    private final ClientHandler clientHandler;

    public ClientController(ClientHandler clientHandler) {
        this.clientHandler = clientHandler;
    }


    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll() {
        return ResponseEntity.ok().body(clientHandler.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        // Implementation for fetching all clients would go here
        return ResponseEntity.ok().body(clientHandler.findById(id)); // Placeholder response
    }

    @PostMapping
    public ResponseEntity<ClientDTO> save(@RequestBody CreateClientDTO clientDTO) {
        return ResponseEntity.ok().body(clientHandler.save(clientDTO));
    }

    @PutMapping
    public ResponseEntity<ClientDTO> update(@RequestBody UpdateClientDTO clientDTO) {
        return ResponseEntity.ok().body(clientHandler.update(clientDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientHandler.delete(id);
        return ResponseEntity.noContent().build();
    }


}
