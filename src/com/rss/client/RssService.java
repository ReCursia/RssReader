package com.rss.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.rss.shared.Feed;

import java.io.IOException;
import java.util.List;

@RemoteServiceRelativePath("rssService")
public interface RssService extends RemoteService {

    /**
     * Function to get all feeds
     *
     * @return list of feed
     * @throws IOException error, when try to load remote data
     */
    List<Feed> getAllFeeds() throws IOException;

    /**
     * Add new RSS-feed
     *
     * @param url RSS-feed url
     * @throws IOException error, when try to check correctness of url
     */
    void addFeed(String url) throws IOException;

    class App {
        private static RssServiceAsync ourInstance = GWT.create(RssService.class);

        static synchronized RssServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
