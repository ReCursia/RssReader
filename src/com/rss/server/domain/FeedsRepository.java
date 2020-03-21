package com.rss.server.domain;

import com.rss.shared.Feed;

import java.util.List;

public interface FeedsRepository {

    List<Feed> getAllFeeds();

    void addFeed(String url);

}
