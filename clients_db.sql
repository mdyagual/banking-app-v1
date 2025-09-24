-- =========================================================
-- TABLAS PARA CLIENTES (clients_db)
-- =========================================================

CREATE TABLE clients (
    client_id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    gender CHAR(1) NOT NULL,
    age INT NOT NULL,
    identification VARCHAR(20) UNIQUE NOT NULL,
    address VARCHAR(200),
    phone VARCHAR(20),
    password VARCHAR(100) NOT NULL,
    status BOOLEAN DEFAULT TRUE
);