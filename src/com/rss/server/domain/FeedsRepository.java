package com.rss.server.domain;

import com.rss.shared.Feed;

import java.io.IOException;
import java.util.List;

public interface FeedsRepository {

    List<Feed> getAllFeeds() throws IOException;

    void addFeed(String url) throws IOException;

}
