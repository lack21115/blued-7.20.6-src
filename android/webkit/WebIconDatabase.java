package android.webkit;

import android.content.ContentResolver;
import android.graphics.Bitmap;

@Deprecated
/* loaded from: source-4181928-dex2jar.jar:android/webkit/WebIconDatabase.class */
public abstract class WebIconDatabase {

    @Deprecated
    /* loaded from: source-4181928-dex2jar.jar:android/webkit/WebIconDatabase$IconListener.class */
    public interface IconListener {
        void onReceivedIcon(String str, Bitmap bitmap);
    }

    public static WebIconDatabase getInstance() {
        return WebViewFactory.getProvider().getWebIconDatabase();
    }

    public abstract void bulkRequestIconForPageUrl(ContentResolver contentResolver, String str, IconListener iconListener);

    public abstract void close();

    public abstract void open(String str);

    public abstract void releaseIconForPageUrl(String str);

    public abstract void removeAllIcons();

    public abstract void requestIconForPageUrl(String str, IconListener iconListener);

    public abstract void retainIconForPageUrl(String str);
}
