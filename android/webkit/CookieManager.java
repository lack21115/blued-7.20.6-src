package android.webkit;

import android.net.WebAddress;

/* loaded from: source-4181928-dex2jar.jar:android/webkit/CookieManager.class */
public abstract class CookieManager {
    public static boolean allowFileSchemeCookies() {
        return getInstance().allowFileSchemeCookiesImpl();
    }

    public static CookieManager getInstance() {
        CookieManager cookieManager;
        synchronized (CookieManager.class) {
            try {
                cookieManager = WebViewFactory.getProvider().getCookieManager();
            } catch (Throwable th) {
                throw th;
            }
        }
        return cookieManager;
    }

    public static void setAcceptFileSchemeCookies(boolean z) {
        getInstance().setAcceptFileSchemeCookiesImpl(z);
    }

    public abstract boolean acceptCookie();

    public abstract boolean acceptThirdPartyCookies(WebView webView);

    protected abstract boolean allowFileSchemeCookiesImpl();

    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("doesn't implement Cloneable");
    }

    public abstract void flush();

    public String getCookie(WebAddress webAddress) {
        String cookie;
        synchronized (this) {
            cookie = getCookie(webAddress.toString());
        }
        return cookie;
    }

    public abstract String getCookie(String str);

    public abstract String getCookie(String str, boolean z);

    public abstract boolean hasCookies();

    public abstract boolean hasCookies(boolean z);

    @Deprecated
    public abstract void removeAllCookie();

    public abstract void removeAllCookies(ValueCallback<Boolean> valueCallback);

    @Deprecated
    public abstract void removeExpiredCookie();

    public abstract void removeSessionCookie();

    public abstract void removeSessionCookies(ValueCallback<Boolean> valueCallback);

    public abstract void setAcceptCookie(boolean z);

    protected abstract void setAcceptFileSchemeCookiesImpl(boolean z);

    public abstract void setAcceptThirdPartyCookies(WebView webView, boolean z);

    public abstract void setCookie(String str, String str2);

    public abstract void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback);
}
