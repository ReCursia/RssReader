package com.rss.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.rss.shared.Feed;

import java.util.List;

public interface RssServiceAsync {
    void getAllFeeds(AsyncCallback<List<Feed>> async);

    void addFeed(String url, AsyncCallback<Void> async);

}