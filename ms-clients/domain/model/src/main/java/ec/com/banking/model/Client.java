package ec.com.banking.model;

public class Client extends Person {
    private Long clienteId;
    private String contrasenia;
    private String estado;

    public Client(Long personaId,
                  String nombre,
                  String genero,
                  Integer edad,
                  String identificacion,
                  String direccion,
                  String telefono,
                  Long clienteId,
                  String contrasenia,
                  String estado) {
        super(personaId, nombre, genero, edad, identificacion, direccion, telefono);
        this.clienteId = clienteId;
        this.contrasenia = contrasenia;
        this.estado = estado;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
