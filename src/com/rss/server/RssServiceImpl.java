package com.rss.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.rss.client.RssService;

public class RssServiceImpl extends RemoteServiceServlet implements RssService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}