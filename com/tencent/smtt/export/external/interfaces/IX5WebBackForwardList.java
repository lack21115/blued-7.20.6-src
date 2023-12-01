package com.tencent.smtt.export.external.interfaces;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/interfaces/IX5WebBackForwardList.class */
public interface IX5WebBackForwardList {
    int getCurrentIndex();

    IX5WebHistoryItem getCurrentItem();

    IX5WebHistoryItem getItemAtIndex(int i);

    int getSize();
}
