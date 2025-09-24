-- =========================================================
-- TABLAS PARA CUENTAS Y TRANSACCIONES (accounts_db)
-- =========================================================
CREATE TABLE accounts (
    account_id BIGSERIAL PRIMARY KEY,
    account_number VARCHAR(20) UNIQUE NOT NULL,
    account_type VARCHAR(20) NOT NULL,
    balance NUMERIC(15,2) NOT NULL,
    status BOOLEAN DEFAULT TRUE,
    client_id BIGINT NOT NULL
    -- Nota: no hay FK hacia clients_db porque
    -- la relación se resuelve vía eventos (RabbitMQ)
);

CREATE TABLE transactions (
    transaction_id BIGSERIAL PRIMARY KEY,
    date DATE NOT NULL,
    transaction_type CHAR(1) NOT NULL, -- D=Debit, C=Credit
    amount NUMERIC(15,2) NOT NULL,
    initial_balance NUMERIC(15,2) NOT NULL,
    final_balance NUMERIC(15,2) NOT NULL,
    account_id BIGINT NOT NULL,
    FOREIGN KEY (account_id) REFERENCES accounts(account_id)
);