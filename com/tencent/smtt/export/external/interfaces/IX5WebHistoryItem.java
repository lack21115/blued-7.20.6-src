package com.tencent.smtt.export.external.interfaces;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/interfaces/IX5WebHistoryItem.class */
public interface IX5WebHistoryItem {
    boolean canDrawBaseLayer();

    boolean drawBaseLayer(Canvas canvas, boolean z);

    Object getCustomData();

    Bitmap getFavicon();

    int getId();

    boolean getIsSubmitForm();

    String getOriginalUrl();

    String getTitle();

    String getTouchIconUrl();

    String getUrl();

    void setCustomData(Object obj);

    void setFavicon(Bitmap bitmap);

    void setUrl(String str);
}
