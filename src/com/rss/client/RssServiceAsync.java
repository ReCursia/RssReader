package com.rss.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.rss.shared.Feed;

import java.util.List;

public interface RssServiceAsync {
    /**
     * Get all feeds
     *
     * @param async callback function
     */
    void getAllFeeds(AsyncCallback<List<Feed>> async);

    /**
     * Add new RSS-feed
     *
     * @param url   RSS-url
     * @param async callback function
     */
    void addFeed(String url, AsyncCallback<Void> async);

}