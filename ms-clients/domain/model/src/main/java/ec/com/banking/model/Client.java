package ec.com.banking.model;

public class Client extends Person {
    private Long clientId;
    private String password;
    private Boolean status;

    public Client(String name, String genre, Integer age, String idNumber, String address, String phone, Long clientId, String password, Boolean status) {
        super(name, genre, age, idNumber, address, phone);
        this.clientId = clientId;
        this.password = password;
        this.status = status;
    }

    public static Client newClient(String name, String genre, Integer age, String idNumber, String address, String phone, String password) {
        return new Client(name, genre, age, idNumber, address, phone, null, password, true);
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
