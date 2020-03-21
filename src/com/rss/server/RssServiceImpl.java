package com.rss.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.rss.client.RssService;
import com.rss.server.data.repositories.FeedsRepositoryImpl;
import com.rss.server.domain.FeedsRepository;
import com.rss.shared.Feed;

import java.util.List;

public class RssServiceImpl extends RemoteServiceServlet implements RssService {

    private FeedsRepository feedsRepository = new FeedsRepositoryImpl();

    @Override
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }

    @Override
    public List<Feed> getAllFeeds() {
        return feedsRepository.getAllFeeds();
    }

    @Override
    public void addFeed(String url) {
        feedsRepository.addFeed(url);
    }
}