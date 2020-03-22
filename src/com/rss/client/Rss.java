package com.rss.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.rss.shared.Feed;
import com.rss.shared.FeedItem;

import java.util.ArrayList;
import java.util.List;

public class Rss implements EntryPoint {

    private static final int TABLE_SIZE = 200;

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
        verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        final CellTable<FeedItem> table = createCellTable();
        table.setVisible(false);

        final Button getNewsButton = new Button("Get news");
        getNewsButton.addClickHandler(event -> RssService.App.getInstance().getAllFeeds(new GetFeedsAsyncCallBack(eventLabel, table)));
        horizontalPanel.add(getNewsButton);

        verticalPanel.add(table);
        RootPanel.get("slot1").add(verticalPanel);
    }

    private CellTable<FeedItem> createCellTable() {
        CellTable<FeedItem> table = new CellTable<>();
        table.setVisibleRange(0, TABLE_SIZE);
        table.addColumn(new TextColumn<FeedItem>() {
            @Override
            public String getValue(FeedItem object) {
                return object.getTitle();
            }
        }, "Title");
        table.addColumn(new TextColumn<FeedItem>() {
            @Override
            public String getValue(FeedItem object) {
                return object.getDescription();
            }
        }, "Description");
        table.addColumn(new TextColumn<FeedItem>() {
            @Override
            public String getValue(FeedItem object) {
                return object.getPubDate();
            }
        }, "Pub date");
        return table;
    }

    private static class GetFeedsAsyncCallBack implements AsyncCallback<List<Feed>> {
        private final Label label;
        private final CellTable<FeedItem> table;

        GetFeedsAsyncCallBack(Label label, CellTable<FeedItem> table) {
            this.label = label;
            this.table = table;
        }

        @Override
        public void onFailure(Throwable caught) {
            label.setText("Произошла ошибка! Сообщение: " + caught.getLocalizedMessage());
        }

        @Override
        public void onSuccess(List<Feed> feeds) {
            boolean hasItems = !feeds.isEmpty();
            table.setVisible(hasItems);
            if (hasItems) {
                label.setText("Новости получены! Новостные ленты: " + feeds);
            } else {
                label.setText("Новостей нет! Добавьте RSS-канал.");
            }

            List<FeedItem> items = new ArrayList<>();
            for (Feed feed : feeds) {
                items.addAll(feed.getFeedItems());
            }
            table.setRowCount(items.size());
            table.setRowData(0, items);
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
            label.setText("Успешно добавлено!");
        }
    }
}
