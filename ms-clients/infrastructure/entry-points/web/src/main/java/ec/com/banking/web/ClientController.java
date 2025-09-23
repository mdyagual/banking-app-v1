package ec.com.banking.web;

import ec.com.banking.web.dto.request.CreateClientDTO;
import ec.com.banking.web.dto.request.UpdateClientDTO;
import ec.com.banking.web.dto.response.ClientDTO;
import ec.com.banking.web.handler.ClientHandler;
import jakarta.validation.Valid;
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
        return ResponseEntity.ok().body(clientHandler.findById(id));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> save(@Valid @RequestBody CreateClientDTO clientDTO) {
        return ResponseEntity.ok().body(clientHandler.save(clientDTO));
    }

    @PutMapping
    public ResponseEntity<ClientDTO> update(@Valid @RequestBody UpdateClientDTO clientDTO) {
        return ResponseEntity.ok().body(clientHandler.update(clientDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientHandler.delete(id);
        return ResponseEntity.noContent().build();
    }


}
