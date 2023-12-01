package android.webkit;

import android.graphics.Bitmap;

/* loaded from: source-4181928-dex2jar.jar:android/webkit/WebHistoryItem.class */
public abstract class WebHistoryItem implements Cloneable {
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone */
    public abstract WebHistoryItem m66clone();

    public abstract Bitmap getFavicon();

    @Deprecated
    public abstract int getId();

    public abstract String getOriginalUrl();

    public abstract String getTitle();

    public abstract String getUrl();
}
