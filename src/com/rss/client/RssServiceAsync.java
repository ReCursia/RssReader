package com.rss.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RssServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
