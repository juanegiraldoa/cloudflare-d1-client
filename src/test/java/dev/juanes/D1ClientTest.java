package dev.juanes;

import dev.juanes.request.CreateDatabaseRequest;
import dev.juanes.request.DeleteDatabaseRequest;
import dev.juanes.request.ExportDatabaseAsSQLRequest;
import dev.juanes.request.GetDatabaseBookmarkRequest;
import dev.juanes.request.GetDatabaseRequest;
import dev.juanes.request.ImportSQLIntoDatabaseRequest;
import dev.juanes.request.ListDatabasesRequest;
import dev.juanes.request.QueryDatabaseRequest;
import dev.juanes.request.RawQueryDatabaseRequest;
import dev.juanes.request.RestoreDatabaseRequest;
import dev.juanes.request.UndeleteDatabaseRequest;
import dev.juanes.request.UpdateDatabasePartiallyRequest;
import dev.juanes.request.UpdateDatabaseRequest;
import dev.juanes.request.commons.Ingest;
import dev.juanes.request.commons.Init;
import dev.juanes.request.commons.Query;
import dev.juanes.commons.ReadReplication;
import dev.juanes.datatype.Jurisdiction;
import dev.juanes.datatype.Location;
import dev.juanes.datatype.Mode;
import dev.juanes.datatype.Region;
import dev.juanes.response.CreateDatabaseResponse;
import dev.juanes.response.DeleteDatabaseResponse;
import dev.juanes.response.ExportDatabaseAsSQLResponse;
import dev.juanes.response.GetDatabaseBookmarkResponse;
import dev.juanes.response.GetDatabaseResponse;
import dev.juanes.response.ImportSQLIntoDatabaseResponse;
import dev.juanes.response.ListDatabasesResponse;
import dev.juanes.response.QueryDatabaseResponse;
import dev.juanes.response.RawQueryDatabaseResponse;
import dev.juanes.response.RestoreDatabaseResponse;
import dev.juanes.response.UndeleteDatabaseResponse;
import dev.juanes.response.UpdateDatabasePartiallyResponse;
import dev.juanes.response.UpdateDatabaseResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    void updateDatabase() {
        var finalClient = getClientMock();
        UpdateDatabaseResponse response = finalClient.updateDatabase(UpdateDatabaseRequest.builder().build());
        assertNotNull(response);
    }

    @Test
    void getDatabaseBookmark() {
        var finalClient = getClientMock();
        GetDatabaseBookmarkResponse response = finalClient.getDatabaseBookmark(GetDatabaseBookmarkRequest.builder().build());
        assertNotNull(response);
    }

    @Test
    void restoreDatabase() {
        var finalClient = getClientMock();
        RestoreDatabaseResponse response = finalClient.restoreDatabase(RestoreDatabaseRequest.builder().build());
        assertNotNull(response);
    }

    @Test
    void undeleteDatabase() {
        var finalClient = getClientMock();
        UndeleteDatabaseResponse response = finalClient.undeleteDatabase(
                UndeleteDatabaseRequest.builder().build());
        assertNotNull(response);
    }

    @Test
    void updateDatabasePartiallySerializesBody() {
        var mapper = JsonMapper.builder().build();
        var body = UpdateDatabasePartiallyRequest.builder()
                .withDatabaseId("db-1")
                .withReadReplication(ReadReplication.builder().withMode(Mode.AUTO).build())
                .build();

        String json = mapper.writeValueAsString(body);

        assertTrue(json.contains("\"read_replication\":{\"mode\":\"auto\"}"));
        assertFalse(json.contains("databaseId"));
        assertFalse(json.contains("uuid"));
    }

    @Test
    void createDatabaseSerializesNewFields() {
        var mapper = JsonMapper.builder().build();
        var body = CreateDatabaseRequest.builder()
                .withName("my-db")
                .withJurisdiction(Jurisdiction.EU)
                .withPrimaryLocationHint(Location.WEUR)
                .withReadReplication(ReadReplication.builder().withMode(Mode.AUTO).build())
                .build();

        String json = mapper.writeValueAsString(body);

        assertTrue(json.contains("\"name\":\"my-db\""));
        assertTrue(json.contains("\"jurisdiction\":\"eu\""));
        assertTrue(json.contains("\"primary_location_hint\":\"weur\""));
        assertTrue(json.contains("\"read_replication\":{\"mode\":\"auto\"}"));
    }

    @Test
    void importRequestIsFlat() {
        var mapper = JsonMapper.builder().build();
        var init = ImportSQLIntoDatabaseRequest.builder()
                .withInit(Init.builder().withETag("etag-1").build())
                .build();
        var ingest = ImportSQLIntoDatabaseRequest.builder()
                .withIngest(Ingest.builder().withETag("etag-1").withFilename("dump.sql").build())
                .build();

        assertEquals("{\"action\":\"init\",\"etag\":\"etag-1\"}", mapper.writeValueAsString(init));
        assertEquals("{\"action\":\"ingest\",\"etag\":\"etag-1\",\"filename\":\"dump.sql\"}",
                mapper.writeValueAsString(ingest));
    }

    @Test
    void queryBatchIsSerialized() {
        var mapper = JsonMapper.builder().build();
        var body = QueryDatabaseRequest.builder()
                .withBatch(List.of(Query.builder().withSql("SELECT 1").build()))
                .build();

        assertEquals("{\"batch\":[{\"sql\":\"SELECT 1\"}]}", mapper.writeValueAsString(body));
    }

    @Test
    void restoreAndBookmarkUseQueryParameters() {
        var restore = RestoreDatabaseRequest.builder()
                .withBookmark("book mark")
                .withTimestamp("2026-01-01T00:00:00Z")
                .build();
        assertEquals("bookmark=book+mark&timestamp=2026-01-01T00%3A00%3A00Z", restore.query());

        var bookmark = GetDatabaseBookmarkRequest.builder()
                .withTimestamp("2026-01-01T00:00:00Z")
                .build();
        assertEquals("timestamp=2026-01-01T00%3A00%3A00Z", bookmark.query());
    }

    @Test
    void metaUsesOfficialFieldNames() {
        var mapper = JsonMapper.builder().build();
        var response = mapper.readValue("""
                {
                  "success": true,
                  "result": [
                    {
                      "success": true,
                      "meta": {
                        "served_by_colo": "LHR",
                        "served_by_region": "EEUR",
                        "served_by_primary": true,
                        "rows_read": 3,
                        "rows_written": 1,
                        "size_after": 1024
                      },
                      "results": []
                    }
                  ]
                }
                """, QueryDatabaseResponse.class);

        var meta = response.getResult().get(0).getMeta();
        assertEquals("LHR", meta.getServedByColo());
        assertEquals(Region.EEUR, meta.getServedByRegion());
        assertEquals(3L, meta.getRowsRead());
        assertEquals(1L, meta.getRowsWritten());
        assertEquals(1024L, meta.getSizeAfter());
        assertTrue(meta.getServedByPrimary());
    }
}