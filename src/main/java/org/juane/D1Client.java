package org.juane;

import com.google.gson.Gson;
import org.juane.request.CreateDatabaseRequest;
import org.juane.request.DeleteDatabaseRequest;
import org.juane.request.GetDatabaseRequest;
import org.juane.request.ListDatabasesRequest;
import org.juane.request.QueryDatabaseRequest;
import org.juane.request.RawQueryDatabaseRequest;
import org.juane.response.CreateDatabaseResponse;
import org.juane.response.DeleteDatabaseResponse;
import org.juane.response.GetDatabaseResponse;
import org.juane.response.ListDatabasesResponse;
import org.juane.response.QueryDatabaseResponse;
import org.juane.response.RawQueryDatabaseResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class D1Client {
    public static String BASE_URL = "https://api.cloudflare.com/client/v4/";
    private final String databaseId;
    private final String accountId;
    private final String accessToken;

    private final Gson gson;
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

    public ListDatabasesResponse listDatabases(ListDatabasesRequest body) {
        try {
            final String url = String.format("%s/accounts/%s/d1/database", BASE_URL, this.accountId);
            final HttpRequest request = getRequest(url).build();
            final HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), ListDatabasesResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public CreateDatabaseResponse createDatabase(CreateDatabaseRequest body) {
        try {
            final String url = String.format("%s/accounts/%s/d1/database", BASE_URL, this.accountId);
            final HttpRequest request = getRequest(url).POST(HttpRequest.BodyPublishers.ofString(this.gson.toJson(body))).build();
            final HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), CreateDatabaseResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public DeleteDatabaseResponse deleteDatabase(DeleteDatabaseRequest body) {
        try {
            final String url = String.format("%s/accounts/%s/d1/database/%s", BASE_URL, this.accountId, body.getDatabaseId());
            final HttpRequest request = getRequest(url).DELETE().build();
            final HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), DeleteDatabaseResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public GetDatabaseResponse getDatabase(GetDatabaseRequest body) {
        try {
            final String url = String.format("%s/accounts/%s/d1/database/%s", BASE_URL, this.accountId, body.getDatabaseId());
            final HttpRequest request = getRequest(url).build();
            final HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), GetDatabaseResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public QueryDatabaseResponse queryDatabase(QueryDatabaseRequest body) {
        try {
            final String url = String.format("%s/accounts/%s/d1/database/%s/query", BASE_URL, this.accountId, this.databaseId);
            final HttpRequest request = getRequest(url).POST(HttpRequest.BodyPublishers.ofString(this.gson.toJson(body))).build();
            final HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), QueryDatabaseResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public RawQueryDatabaseResponse rawQueryDatabase(RawQueryDatabaseRequest body) {
        try {
            final String url = String.format("%s/accounts/%s/d1/database/%s/raw", BASE_URL, this.accountId, this.databaseId);
            final HttpRequest request = getRequest(url).POST(HttpRequest.BodyPublishers.ofString(this.gson.toJson(body))).build();
            final HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), RawQueryDatabaseResponse.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private D1Client(Builder builder) {
        this.databaseId = builder.databaseId;
        this.accountId = builder.accountId;
        this.accessToken = builder.accessToken;
        this.gson = new Gson();
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
