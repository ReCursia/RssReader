package com.rss.server.domain;

import com.rss.shared.Feed;

import java.io.IOException;
import java.util.List;

public interface FeedsRepository {

    /**
     * Get all RSS-feeds
     *
     * @return list of feeds
     * @throws IOException error when try to fetch remote data
     */
    List<Feed> getAllFeeds() throws IOException;

    /**
     * Add new RSS-feed
     *
     * @param url rss feed url
     * @throws IOException error when try to check rss correctness
     */
    void addFeed(String url) throws IOException;

}
