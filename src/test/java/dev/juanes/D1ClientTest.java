package dev.juanes;

import dev.juanes.request.CreateDatabaseRequest;
import dev.juanes.response.CreateDatabaseResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class D1ClientTest {
    private D1Client client;

    @BeforeEach
    void beforeEach() {
        client = D1Client.builder()
                .withDatabaseId("test-database-id")
                .withAccountId("test-account-id")
                .withAccessToken("test-access-token")
                .build();

    }

    @Test
    void getDatabaseId() {
        final String expectedDatabaseId = "test-database-id";
        assertEquals(expectedDatabaseId, client.getDatabaseId());
    }

    @Test
    void getAccountId() {
        final String expectedAccountId = "test-account-id";
        assertEquals(expectedAccountId, client.getAccountId());
    }

    @Test
    @SuppressWarnings("unchecked")
    void createDatabase() throws IOException, InterruptedException {
        var httpClient = Mockito.mock(HttpClient.class);
        var httpResponse = (HttpResponse<Object>) Mockito.mock(HttpResponse.class);

        Mockito.when(httpResponse.statusCode()).thenReturn(200);
        Mockito.when(httpResponse.body()).thenReturn("{}");

        Mockito.when(httpClient.send(Mockito.any(HttpRequest.class), Mockito.any()))
                .thenReturn(httpResponse);

        var response = client.createDatabase(CreateDatabaseRequest.builder().build());

        assertNotNull(response);
    }

    @Test
    void deleteDatabase() {
    }

    @Test
    void updateDatabasePartially() {
    }

    @Test
    void exportDatabaseAsSQL() {
    }

    @Test
    void getDatabase() {
    }

    @Test
    void importSQLIntoDatabase() {
    }

    @Test
    void listDatabases() {
    }

    @Test
    void queryDatabase() {
    }

    @Test
    void rawQueryDatabase() {
    }

    @Test
    void builder() {
    }
}