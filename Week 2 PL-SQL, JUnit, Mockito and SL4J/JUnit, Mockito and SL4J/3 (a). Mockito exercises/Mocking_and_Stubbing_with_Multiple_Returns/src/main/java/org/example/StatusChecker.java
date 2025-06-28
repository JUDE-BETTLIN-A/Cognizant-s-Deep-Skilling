package org.example;

public class StatusChecker {

    private ExternalApi api;

    public StatusChecker(ExternalApi api) {
        this.api = api;
    }

    public String checkStatusTwice() {
        String first = api.getStatus();
        String second = api.getStatus();
        return first + " -> " + second;
    }
}
