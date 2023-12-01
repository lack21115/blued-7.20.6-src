package mtopsdk.a.a;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import mtopsdk.mtop.global.SDKConfig;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/a/a/a.class */
public final class a {
    private static volatile boolean a = false;
    private static CookieManager b;

    static {
        a(SDKConfig.a().b());
    }

    public static String a(String str) {
        synchronized (a.class) {
            try {
                if (a) {
                    return b.getCookie(str);
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void a(Context context) {
        synchronized (a.class) {
            try {
                if (a || context == null) {
                    return;
                }
                CookieSyncManager.createInstance(context);
                CookieManager cookieManager = CookieManager.getInstance();
                b = cookieManager;
                cookieManager.setAcceptCookie(true);
                b.removeExpiredCookie();
                a = true;
            } finally {
            }
        }
    }

    public static void a(String str, String str2) {
        synchronized (a.class) {
            try {
                if (a) {
                    b.setCookie(str, str2);
                    CookieSyncManager.getInstance().sync();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
