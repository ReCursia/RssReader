package com.rss.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.rss.domain.models.Feed;

import java.util.List;

public interface RssServiceAsync {
    void getAllFeeds(AsyncCallback<List<Feed>> async);

    void addFeed(String url, AsyncCallback<Void> async);

    void getMessage(String msg, AsyncCallback<String> async);
}