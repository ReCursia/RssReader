package com.rss.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

public class Rss implements EntryPoint {

    public void onModuleLoad() {
        final Label eventLabel = new Label();
        final TextBox textBox = new TextBox();
        final Button submitButton = new Button("Submit");
        submitButton.addClickHandler(event -> RssService.App.getInstance().addFeed(textBox.getText(), new AddFeedAsyncCallback(eventLabel)));


        final HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.add(textBox);
        horizontalPanel.add(submitButton);

        final VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.add(eventLabel);
        verticalPanel.add(horizontalPanel);
        RootPanel.get("slot1").add(verticalPanel);
    }

    private static class AddFeedAsyncCallback implements AsyncCallback<Void> {
        final private Label label;

        AddFeedAsyncCallback(Label label) {
            this.label = label;
        }

        @Override
        public void onFailure(Throwable caught) {
            label.setText(caught.getLocalizedMessage());
        }

        @Override
        public void onSuccess(Void result) {
            label.setText("Успешно добавлено!"); //TODO add const
        }
    }
}
