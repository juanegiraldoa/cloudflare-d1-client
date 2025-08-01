package dev.juanes;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.juanes.request.CreateDatabaseRequest;
import dev.juanes.request.DeleteDatabaseRequest;
import dev.juanes.request.GetDatabaseRequest;
import dev.juanes.request.ListDatabasesRequest;
import dev.juanes.request.QueryDatabaseRequest;
import dev.juanes.request.RawQueryDatabaseRequest;
import dev.juanes.response.CreateDatabaseResponse;
import dev.juanes.response.DeleteDatabaseResponse;
import dev.juanes.response.GetDatabaseResponse;
import dev.juanes.response.ListDatabasesResponse;
import dev.juanes.response.QueryDatabaseResponse;
import dev.juanes.response.RawQueryDatabaseResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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
                .header("Authorization", "Bearer " + this.accessToken);
    }

    public CreateDatabaseResponse createDatabase(CreateDatabaseRequest body) {
        try {
            final String url = String.format("%s/accounts/%s/d1/database", BASE_URL, accountId);
            final HttpRequest request = getRequest(url)
                    .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(body)))
                    .build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), CreateDatabaseResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public DeleteDatabaseResponse deleteDatabase(DeleteDatabaseRequest body) {
        try {
            final String url = String.format("%s/accounts/%s/d1/database/%s", BASE_URL, accountId, body.getDatabaseId());
            final HttpRequest request = getRequest(url)
                    .DELETE()
                    .build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), DeleteDatabaseResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // TODO: Update database partially

    // TODO: Export database as SQL

    public GetDatabaseResponse getDatabase(GetDatabaseRequest body) {
        try {
            final String url = String.format("%s/accounts/%s/d1/database/%s", BASE_URL, accountId, body.getDatabaseId());
            final HttpRequest request = getRequest(url)
                    .GET()
                    .build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), GetDatabaseResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // TODO: Import SQL into database

    public ListDatabasesResponse listDatabases(ListDatabasesRequest body) {
        try {
            final String url = String.format("%s/accounts/%s/d1/database?%s", BASE_URL, accountId, body.query());
            final HttpRequest request = getRequest(url)
                    .GET()
                    .build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), ListDatabasesResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public QueryDatabaseResponse queryDatabase(QueryDatabaseRequest body) {
        try {
            final String url = String.format("%s/accounts/%s/d1/database/%s/query", BASE_URL, accountId, databaseId);
            final HttpRequest request = getRequest(url)
                    .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(body)))
                    .build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), QueryDatabaseResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public RawQueryDatabaseResponse rawQueryDatabase(RawQueryDatabaseRequest body) {
        try {
            final String url = String.format("%s/accounts/%s/d1/database/%s/raw", BASE_URL, accountId, databaseId);
            final HttpRequest request = getRequest(url)
                    .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(body)))
                    .build();
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), RawQueryDatabaseResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private D1Client(Builder builder) {
        this.databaseId = builder.databaseId;
        this.accountId = builder.accountId;
        this.accessToken = builder.accessToken;
        this.objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.client = HttpClient.newHttpClient();
    }

    public static class Builder {
        private String databaseId;
        private String accountId;
        private String accessToken;

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

        public D1Client build() {
            return new D1Client(this);
        }
    }
}
