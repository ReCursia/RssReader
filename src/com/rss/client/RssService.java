package com.rss.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.rss.domain.models.Feed;

import java.util.List;

@RemoteServiceRelativePath("rssService")
public interface RssService extends RemoteService {

    String getMessage(String msg);

    List<Feed> getAllFeeds();

    void addFeed(String url);

    class App {
        private static RssServiceAsync ourInstance = GWT.create(RssService.class);

        public static synchronized RssServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
