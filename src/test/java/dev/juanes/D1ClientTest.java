package dev.juanes;

import dev.juanes.request.CreateDatabaseRequest;
import dev.juanes.request.DeleteDatabaseRequest;
import dev.juanes.request.ExportDatabaseAsSQLRequest;
import dev.juanes.request.GetDatabaseRequest;
import dev.juanes.request.ImportSQLIntoDatabaseRequest;
import dev.juanes.request.ListDatabasesRequest;
import dev.juanes.request.QueryDatabaseRequest;
import dev.juanes.request.RawQueryDatabaseRequest;
import dev.juanes.request.UpdateDatabasePartiallyRequest;
import dev.juanes.response.CreateDatabaseResponse;
import dev.juanes.response.DeleteDatabaseResponse;
import dev.juanes.response.ExportDatabaseAsSQLResponse;
import dev.juanes.response.GetDatabaseResponse;
import dev.juanes.response.ImportSQLIntoDatabaseResponse;
import dev.juanes.response.ListDatabasesResponse;
import dev.juanes.response.QueryDatabaseResponse;
import dev.juanes.response.RawQueryDatabaseResponse;
import dev.juanes.response.UpdateDatabasePartiallyResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class D1ClientTest {
    @SuppressWarnings("unchecked")
    private D1Client getClientMock() {
        try {
            var httpClient = Mockito.mock(HttpClient.class);
            var httpResponse = (HttpResponse<Object>) Mockito.mock(HttpResponse.class);

            Mockito.when(httpResponse.statusCode()).thenReturn(200);
            Mockito.when(httpResponse.body()).thenReturn("""
                {
                    "success": true
                }
                """);

            Mockito.when(httpClient.send(Mockito.any(HttpRequest.class), Mockito.any()))
                    .thenReturn(httpResponse);

            return D1Client.builder()
                    .withDatabaseId("test-database-id")
                    .withAccountId("test-account-id")
                    .withAccessToken("test-access-token")
                    .withHttpClient(httpClient)
                    .build();
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Test
    void getDatabaseId() {
        final String expectedDatabaseId = "test-database-id";
        var client = getClientMock();
        assertEquals(expectedDatabaseId, client.getDatabaseId());
    }

    @Test
    void getAccountId() {
        final String expectedAccountId = "test-account-id";
        var client = getClientMock();
        assertEquals(expectedAccountId, client.getAccountId());
    }

    @Test
    void createDatabase() {
        var finalClient = getClientMock();
        CreateDatabaseResponse response = finalClient.createDatabase(CreateDatabaseRequest.builder().build());
        assertNotNull(response);
    }

    @Test
    void deleteDatabase() {
        var finalClient = getClientMock();
        DeleteDatabaseResponse response = finalClient.deleteDatabase(DeleteDatabaseRequest.builder().build());
        assertNotNull(response);
    }

    @Test
    void updateDatabasePartially() {
        var finalClient = getClientMock();
        UpdateDatabasePartiallyResponse response = finalClient.updateDatabasePartially(UpdateDatabasePartiallyRequest.builder().build());
        assertNotNull(response);
    }

    @Test
    void exportDatabaseAsSQL() {
        var finalClient = getClientMock();
        ExportDatabaseAsSQLResponse response = finalClient.exportDatabaseAsSQL(ExportDatabaseAsSQLRequest.builder().build());
        assertNotNull(response);
    }

    @Test
    void getDatabase() {
        var finalClient = getClientMock();
        GetDatabaseResponse response = finalClient.getDatabase(GetDatabaseRequest.builder().build());
        assertNotNull(response);
    }

    @Test
    void importSQLIntoDatabase() {
        var finalClient = getClientMock();
        ImportSQLIntoDatabaseResponse response = finalClient.importSQLIntoDatabase(ImportSQLIntoDatabaseRequest.builder().build());
        assertNotNull(response);
    }

    @Test
    void listDatabases() {
        var finalClient = getClientMock();
        ListDatabasesResponse response = finalClient.listDatabases(ListDatabasesRequest.builder().build());
        assertNotNull(response);
    }

    @Test
    void queryDatabase() {
        var finalClient = getClientMock();
        QueryDatabaseResponse response = finalClient.queryDatabase(QueryDatabaseRequest.builder().build());
        assertNotNull(response);
    }

    @Test
    void rawQueryDatabase() {
        var finalClient = getClientMock();
        RawQueryDatabaseResponse response = finalClient.rawQueryDatabase(RawQueryDatabaseRequest.builder().build());
        assertNotNull(response);
    }
}