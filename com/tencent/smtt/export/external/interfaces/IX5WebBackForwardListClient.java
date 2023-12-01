package com.tencent.smtt.export.external.interfaces;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/interfaces/IX5WebBackForwardListClient.class */
public interface IX5WebBackForwardListClient {
    void onIndexChanged(IX5WebHistoryItem iX5WebHistoryItem, int i);

    void onNewHistoryItem(IX5WebHistoryItem iX5WebHistoryItem);

    void onRemoveHistoryItem(IX5WebHistoryItem iX5WebHistoryItem);
}
