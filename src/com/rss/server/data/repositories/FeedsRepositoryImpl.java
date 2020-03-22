package com.rss.server.data.repositories;

import com.rss.server.data.parsers.RssFeedParser;
import com.rss.server.domain.FeedsRepository;
import com.rss.shared.Feed;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FeedsRepositoryImpl implements FeedsRepository {

    /**
     * File path to feed urls
     */
    private static final String FILE_PATH = "D:\\Projects\\RssReader\\src\\com\\rss\\server\\data\\feed_urls.txt";

    @Override
    public List<Feed> getAllFeeds() throws IOException {
        List<Feed> result = new ArrayList<>();

        List<String> urls = getFeedsUrls();
        for (String url : urls) {
            result.add(getFeedFromNetwork(url));
        }
        return result;
    }

    /**
     * Getting feed from network
     *
     * @param url url of the feed
     * @return feed
     */
    private Feed getFeedFromNetwork(String url) {
        return new RssFeedParser(url).readFeed();
    }

    @Override
    public void addFeed(String url) throws IOException {
        Feed tryToGetFeed = getFeedFromNetwork(url);
        if (isFeedCorrect(tryToGetFeed)) {
            addUrlToFile(url);
        }
    }

    private void addUrlToFile(String url) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));
        writer.write(url + "\n");
        writer.close();
    }

    /**
     * Check feed correctness
     *
     * @param feed feed
     * @return true if correct, false otherwise
     */
    private boolean isFeedCorrect(Feed feed) {
        return !feed.getFeedItems().isEmpty();
    }

    /**
     * Get feeds urls from file
     *
     * @return list of String
     * @throws IOException error, if IO problems with file read
     */
    private List<String> getFeedsUrls() throws IOException {
        List<String> result = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
        String line;
        while ((line = reader.readLine()) != null) {
            result.add(line);
        }
        reader.close();
        return result;
    }
}
