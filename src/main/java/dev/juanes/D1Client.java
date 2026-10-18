package dev.juanes;

import dev.juanes.exception.D1ApiException;
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
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

public class D1Client {
    public static final String BASE_URL = "https://api.cloudflare.com/client/v4/";
    private final String databaseId;
    private final String accountId;
    private final String accessToken;

    private final ObjectMapper objectMapper;
    private final HttpClient client;

    public String getDatabaseId() {
        return this.databaseId;
    }

    public String getAccountId() {
        return this.accountId;
    }

    private HttpRequest.Builder getRequest(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Authorization", "Bearer " + this.accessToken)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json");
    }

    private String resolveDatabaseId(String requestDatabaseId) {
        final String resolved = (requestDatabaseId != null && !requestDatabaseId.isBlank())
                ? requestDatabaseId
                : this.databaseId;
        if (resolved == null || resolved.isBlank()) {
            throw new IllegalArgumentException("databaseId is required");
        }
        return resolved;
    }

    private String toJson(Object body) {
        return objectMapper.writeValueAsString(body);
    }

    private String withQuery(String url, String query) {
        if (query == null || query.isBlank()) {
            return url;
        }
        return url + "?" + query;
    }

    private <T> T send(HttpRequest request, Class<T> responseType) {
        try {
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() < 200 || response.statusCode() >= 300) {
                throw new D1ApiException(response.statusCode(), response.body());
            }
            return objectMapper.readValue(response.body(), responseType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    public CreateDatabaseResponse createDatabase(CreateDatabaseRequest body) {
        final String url = String.format("%saccounts/%s/d1/database", BASE_URL, accountId);
        final HttpRequest request = getRequest(url)
                .POST(HttpRequest.BodyPublishers.ofString(toJson(body)))
                .build();
        return send(request, CreateDatabaseResponse.class);
    }

    public DeleteDatabaseResponse deleteDatabase(DeleteDatabaseRequest body) {
        final String url = String.format("%saccounts/%s/d1/database/%s", BASE_URL, accountId,
                resolveDatabaseId(body.getDatabaseId()));
        final HttpRequest request = getRequest(url)
                .DELETE()
                .build();
        return send(request, DeleteDatabaseResponse.class);
    }

    public UndeleteDatabaseResponse undeleteDatabase(UndeleteDatabaseRequest body) {
        final String url = String.format("%saccounts/%s/d1/database/%s/undelete", BASE_URL, accountId,
                resolveDatabaseId(body.getDatabaseId()));
        final HttpRequest request = getRequest(url)
                .POST(HttpRequest.BodyPublishers.ofString(toJson(body)))
                .build();
        return send(request, UndeleteDatabaseResponse.class);
    }

    public UpdateDatabasePartiallyResponse updateDatabasePartially(UpdateDatabasePartiallyRequest body) {
        final String url = String.format("%saccounts/%s/d1/database/%s", BASE_URL, accountId,
                resolveDatabaseId(body.getDatabaseId()));
        final HttpRequest request = getRequest(url)
                .method("PATCH", HttpRequest.BodyPublishers.ofString(toJson(body)))
                .build();
        return send(request, UpdateDatabasePartiallyResponse.class);
    }

    public ExportDatabaseAsSQLResponse exportDatabaseAsSQL(ExportDatabaseAsSQLRequest body) {
        final String url = String.format("%saccounts/%s/d1/database/%s/export", BASE_URL, accountId,
                resolveDatabaseId(body.getDatabaseId()));
        final HttpRequest request = getRequest(url)
                .POST(HttpRequest.BodyPublishers.ofString(toJson(body)))
                .build();
        return send(request, ExportDatabaseAsSQLResponse.class);
    }

    public GetDatabaseResponse getDatabase(GetDatabaseRequest body) {
        final String url = String.format("%saccounts/%s/d1/database/%s", BASE_URL, accountId,
                resolveDatabaseId(body.getDatabaseId()));
        final HttpRequest request = getRequest(url)
                .GET()
                .build();
        return send(request, GetDatabaseResponse.class);
    }

    public ImportSQLIntoDatabaseResponse importSQLIntoDatabase(ImportSQLIntoDatabaseRequest body) {
        final String url = String.format("%saccounts/%s/d1/database/%s/import", BASE_URL, accountId,
                resolveDatabaseId(body.getDatabaseId()));
        final HttpRequest request = getRequest(url)
                .POST(HttpRequest.BodyPublishers.ofString(toJson(body)))
                .build();
        return send(request, ImportSQLIntoDatabaseResponse.class);
    }

    public ListDatabasesResponse listDatabases(ListDatabasesRequest body) {
        final String url = withQuery(
                String.format("%saccounts/%s/d1/database", BASE_URL, accountId),
                body.query());
        final HttpRequest request = getRequest(url)
                .GET()
                .build();
        return send(request, ListDatabasesResponse.class);
    }

    public QueryDatabaseResponse queryDatabase(QueryDatabaseRequest body) {
        final String url = String.format("%saccounts/%s/d1/database/%s/query", BASE_URL, accountId,
                resolveDatabaseId(body.getDatabaseId()));
        final HttpRequest request = getRequest(url)
                .POST(HttpRequest.BodyPublishers.ofString(toJson(body)))
                .build();
        return send(request, QueryDatabaseResponse.class);
    }

    public RawQueryDatabaseResponse rawQueryDatabase(RawQueryDatabaseRequest body) {
        final String url = String.format("%saccounts/%s/d1/database/%s/raw", BASE_URL, accountId,
                resolveDatabaseId(body.getDatabaseId()));
        final HttpRequest request = getRequest(url)
                .POST(HttpRequest.BodyPublishers.ofString(toJson(body)))
                .build();
        return send(request, RawQueryDatabaseResponse.class);
    }

    public UpdateDatabaseResponse updateDatabase(UpdateDatabaseRequest body) {
        final String url = String.format("%saccounts/%s/d1/database/%s", BASE_URL, accountId,
                resolveDatabaseId(body.getDatabaseId()));
        final HttpRequest request = getRequest(url)
                .PUT(HttpRequest.BodyPublishers.ofString(toJson(body)))
                .build();
        return send(request, UpdateDatabaseResponse.class);
    }

    public GetDatabaseBookmarkResponse getDatabaseBookmark(GetDatabaseBookmarkRequest body) {
        final String url = withQuery(
                String.format("%saccounts/%s/d1/database/%s/time_travel/bookmark", BASE_URL, accountId,
                        resolveDatabaseId(body.getDatabaseId())),
                body.query());
        final HttpRequest request = getRequest(url)
                .GET()
                .build();
        return send(request, GetDatabaseBookmarkResponse.class);
    }

    public RestoreDatabaseResponse restoreDatabase(RestoreDatabaseRequest body) {
        final String url = withQuery(
                String.format("%saccounts/%s/d1/database/%s/time_travel/restore", BASE_URL, accountId,
                        resolveDatabaseId(body.getDatabaseId())),
                body.query());
        final HttpRequest request = getRequest(url)
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();
        return send(request, RestoreDatabaseResponse.class);
    }

    private D1Client(Builder builder) {
        this.databaseId = builder.databaseId;
        this.accountId = builder.accountId;
        this.accessToken = builder.accessToken;
        this.objectMapper = JsonMapper.builder()
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .build();
        this.client = Objects.nonNull(builder.httpClient) ? builder.httpClient : HttpClient.newHttpClient();
    }

    public static class Builder {
        private String databaseId;
        private String accountId;
        private String accessToken;
        private HttpClient httpClient;

        public Builder withDatabaseId(String databaseId) {
            this.databaseId = databaseId;
            return this;
        }

        public Builder withAccountId(String accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder withAccessToken(String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public Builder withHttpClient(HttpClient httpClient) {
            this.httpClient = httpClient;
            return this;
        }

        public D1Client build() {
            return new D1Client(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}
