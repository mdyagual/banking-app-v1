package ec.com.banking.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    @Test
    void newClientShouldInitializeWithDefaults() {
        Client client = Client.newClient(
                "Alice", "F", 25, "1234567890",
                "Main St", "555-1234", "secret"
        );

        assertAll("factory newClient",
                () -> assertNull(client.getClientId(), "clientId debe iniciar en null"),
                () -> assertEquals("Alice", client.getName()),
                () -> assertEquals("F", client.getGenre()),
                () -> assertEquals(25, client.getAge()),
                () -> assertEquals("1234567890", client.getIdNumber()),
                () -> assertEquals("Main St", client.getAddress()),
                () -> assertEquals("555-1234", client.getPhone()),
                () -> assertEquals("secret", client.getPassword()),
                () -> assertTrue(client.getStatus(), "status debe iniciar en true")
        );
    }

    @Test
    void constructorShouldAssignAllFieldsWhenProvided() {
        Long explicitId = 42L;
        Client client = new Client(
                "Carlos", "M", 40, "99887766",
                "Calle 1", "099999999", explicitId, "mypassword", false
        );

        assertAll("constructor completo",
                () -> assertEquals(explicitId, client.getClientId(), "clientId debe quedar seteado"),
                () -> assertEquals("Carlos", client.getName()),
                () -> assertEquals("M", client.getGenre()),
                () -> assertEquals(40, client.getAge()),
                () -> assertEquals("99887766", client.getIdNumber()),
                () -> assertEquals("Calle 1", client.getAddress()),
                () -> assertEquals("099999999", client.getPhone()),
                () -> assertEquals("mypassword", client.getPassword()),
                () -> assertFalse(client.getStatus(), "status debe reflejar el valor pasado (false)")
        );
    }

}
