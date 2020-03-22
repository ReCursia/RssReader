package com.rss.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.rss.server.exceptions.IncorrectFeedUrl;
import com.rss.shared.Feed;

import java.io.IOException;
import java.util.List;

@RemoteServiceRelativePath("rssService")
public interface RssService extends RemoteService {

    List<Feed> getAllFeeds() throws IOException;

    void addFeed(String url) throws IOException, IncorrectFeedUrl;

    class App {
        private static RssServiceAsync ourInstance = GWT.create(RssService.class);

        public static synchronized RssServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
