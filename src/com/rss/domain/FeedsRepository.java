package com.rss.domain;

import com.rss.domain.models.Feed;

import java.util.List;

public interface FeedsRepository {

    List<Feed> getAllFeeds();

    void addFeed(String url);

}
