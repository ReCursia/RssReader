package com.rss.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.rss.shared.Feed;

import java.util.List;

public class Rss implements EntryPoint {

    public void onModuleLoad() {
        final Label eventLabel = new Label();
        eventLabel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        final TextBox textBox = new TextBox();
        final Button submitButton = new Button("Submit");
        submitButton.addClickHandler(event -> RssService.App.getInstance().addFeed(textBox.getText(), new AddFeedAsyncCallback(eventLabel)));


        final HorizontalPanel horizontalPanel = new HorizontalPanel();
        horizontalPanel.add(textBox);
        horizontalPanel.add(submitButton);

        final VerticalPanel verticalPanel = new VerticalPanel();
        verticalPanel.add(eventLabel);
        verticalPanel.add(horizontalPanel);
        final CellTable<Feed> table = createCellTable();
        final Button getNewsButton = new Button("Get news");
        submitButton.addClickHandler(event -> RssService.App.getInstance().getAllFeeds(new GetFeedsAsyncCallBack(eventLabel, table)));
        verticalPanel.add(getNewsButton);
        verticalPanel.add(table);
        RootPanel.get("slot1").add(verticalPanel);
    }

    private CellTable<Feed> createCellTable() {
        CellTable<Feed> table = new CellTable<>();
        //TODO implement
    }

    private static class GetFeedsAsyncCallBack implements AsyncCallback<List<Feed>> {
        private final Label label;
        private final CellTable<Feed> table;

        GetFeedsAsyncCallBack(Label label, CellTable<Feed> table) {
            this.label = label;
            this.table = table;
        }

        @Override
        public void onFailure(Throwable caught) {
            label.setText(caught.getLocalizedMessage());
        }

        @Override
        public void onSuccess(List<Feed> result) {
            label.setText("Новости получены!");
            table.setRowCount(result.size());
            table.setRowData(0, result);
        }
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
