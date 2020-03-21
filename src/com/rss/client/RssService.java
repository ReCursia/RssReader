package com.rss.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("rssService")
public interface RssService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use rssService.App.getInstance() to access static instance of rssServiceAsync
     */
    public static class App {
        private static RssServiceAsync ourInstance = GWT.create(RssService.class);

        public static synchronized RssServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
