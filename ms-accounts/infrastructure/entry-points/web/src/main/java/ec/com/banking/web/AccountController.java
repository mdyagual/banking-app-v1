package ec.com.banking.web;

import ec.com.banking.web.dto.request.CreateAccountDTO;
import ec.com.banking.web.dto.request.UpdateAccountDTO;
import ec.com.banking.web.dto.response.AccountDTO;
import ec.com.banking.web.handler.AccountHandler;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {
    private final AccountHandler accountHandler;
    public AccountController(AccountHandler accountHandler) {
        this.accountHandler = accountHandler;
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> findAll() {
        return ResponseEntity.ok().body(accountHandler.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(accountHandler.findById(id));
    }

    @PostMapping
    public ResponseEntity<AccountDTO> save(@Valid @RequestBody CreateAccountDTO accountDTO) {
        return ResponseEntity.ok().body(accountHandler.save(accountDTO));
    }

    @PutMapping
    public ResponseEntity<AccountDTO> update(@Valid @RequestBody UpdateAccountDTO accountDTO) {
        return ResponseEntity.ok().body(accountHandler.update(accountDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        accountHandler.delete(id);
        return ResponseEntity.noContent().build();
    }
}
