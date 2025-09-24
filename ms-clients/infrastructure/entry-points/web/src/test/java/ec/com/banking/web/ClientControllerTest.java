package ec.com.banking.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import ec.com.banking.web.dto.request.CreateClientDTO;
import ec.com.banking.web.dto.request.UpdateClientDTO;
import ec.com.banking.web.dto.response.ClientDTO;
import ec.com.banking.web.handler.ClientHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {
    private MockMvc mockMvc;

    @Mock
    private ClientHandler clientHandler;

    @InjectMocks
    private ClientController clientController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void shouldReturnAllClients() throws Exception {
        ClientDTO c1 = new ClientDTO(1L, "John Doe", "M", 25, "0935412668", "Sur", "099852366", "password1",true);
        ClientDTO c2 = new ClientDTO(2L, "Jane Doe", "F", 24, "0965874113","Norte","096867266", "password2",true);

        Mockito.when(clientHandler.findAll()).thenReturn(List.of(c1, c2));

        mockMvc.perform(get("/v1/clients")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("John Doe"))
                .andExpect(jsonPath("$[1].name").value("Jane Doe"));

        Mockito.verify(clientHandler, Mockito.times(1)).findAll();
    }

    @Test
    void shouldReturnClientById() throws Exception {
        ClientDTO client = new ClientDTO(1L, "John Doe", "M", 25, "0935412668", "Sur", "099852366", "password1",true);

        Mockito.when(clientHandler.findById(1L)).thenReturn(client);

        mockMvc.perform(get("/v1/clients/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));

        Mockito.verify(clientHandler, Mockito.times(1)).findById(1L);
    }

    @Test
    void shouldSaveClient() throws Exception {
        CreateClientDTO createDto = new CreateClientDTO("Jane Doe", "F", 20, "0957412668","Sur","0995221744","123456789");
        ClientDTO savedDto = new ClientDTO(1L, "Jane Doe", "F", 20, "0957412668","Sur","0995221744","123456789",true);

        Mockito.when(clientHandler.save(Mockito.any(CreateClientDTO.class))).thenReturn(savedDto);

        mockMvc.perform(post("/v1/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Jane Doe"));

        Mockito.verify(clientHandler, Mockito.times(1)).save(Mockito.any(CreateClientDTO.class));
    }

    @Test
    void shouldUpdateClient() throws Exception {
        UpdateClientDTO updateDto = new UpdateClientDTO(1L, "Julia Doe", "F", 20, "0957412668","Sur","0995221744","123456789",true);
        ClientDTO updatedDto = new ClientDTO(1L, "Julia Doe", "F", 20, "0957412668","Sur","0995221744","123456789",true);

        Mockito.when(clientHandler.update(Mockito.any(UpdateClientDTO.class))).thenReturn(updatedDto);

        mockMvc.perform(put("/v1/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Julia Doe"));

        Mockito.verify(clientHandler, Mockito.times(1)).update(Mockito.any(UpdateClientDTO.class));
    }

    @Test
    void shouldDeleteClient() throws Exception {
        Mockito.doNothing().when(clientHandler).delete(1L);

        mockMvc.perform(delete("/v1/clients/1"))
                .andExpect(status().isNoContent());

        Mockito.verify(clientHandler, Mockito.times(1)).delete(1L);
    }

}
