package ec.com.banking.web;

import ec.com.banking.web.dto.request.CreateTransactionDTO;
import ec.com.banking.web.dto.response.TransactionDTO;
import ec.com.banking.web.handler.TransactionHandler;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/transactions")
public class TransactionController {
    private final TransactionHandler transactionHandler;

    public TransactionController(TransactionHandler transactionHandler) {
        this.transactionHandler = transactionHandler;
    }

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> findAll() {
        return ResponseEntity.ok().body(transactionHandler.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<TransactionDTO> findById(Long id) {
        return ResponseEntity.ok().body(transactionHandler.findById(id));
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> save(@Valid @RequestBody CreateTransactionDTO transactionDTO) {
        return ResponseEntity.ok().body(transactionHandler.save(transactionDTO));
    }


}
