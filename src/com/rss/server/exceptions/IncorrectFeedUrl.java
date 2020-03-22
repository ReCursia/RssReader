package com.rss.server.exceptions;

public class IncorrectFeedUrl extends Exception {
    private final String message;

    public IncorrectFeedUrl(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getLocalizedMessage() {
        return message;
    }
}
