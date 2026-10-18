package dev.juanes.exception;

/**
 * Thrown when the Cloudflare API responds with a non-2xx status code.
 */
public class D1ApiException extends RuntimeException {
    private final int statusCode;
    private final String responseBody;

    public D1ApiException(int statusCode, String responseBody) {
        super(String.format("Cloudflare D1 API request failed with status %d: %s", statusCode, responseBody));
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }
}
