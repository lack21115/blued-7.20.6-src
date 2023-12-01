package android.webkit;

import android.content.Context;

/* loaded from: source-4181928-dex2jar.jar:android/webkit/WebViewDatabase.class */
public abstract class WebViewDatabase {
    protected static final String LOGTAG = "webviewdatabase";

    public static WebViewDatabase getInstance(Context context) {
        return WebViewFactory.getProvider().getWebViewDatabase(context);
    }

    public abstract void clearFormData();

    public abstract void clearHttpAuthUsernamePassword();

    @Deprecated
    public abstract void clearUsernamePassword();

    public abstract boolean hasFormData();

    public abstract boolean hasHttpAuthUsernamePassword();

    @Deprecated
    public abstract boolean hasUsernamePassword();
}
