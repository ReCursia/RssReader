package com.rss.domain.models;

import java.io.Serializable;
import java.util.List;

public class Feed implements Serializable {
    private String title;
    private String description;
    private String link;
    private String language;
    private String copyright;
    private String imageUrl;
    private List<FeedItem> feedItems;

    public Feed(String title,
                String description,
                String link,
                String language,
                String copyright,
                String imageUrl,
                List<FeedItem> feedItems) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.language = language;
        this.copyright = copyright;
        this.imageUrl = imageUrl;
        this.feedItems = feedItems;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    public String getLanguage() {
        return language;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<FeedItem> getFeedItems() {
        return feedItems;
    }
}
