package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/CookieManager.class */
public class CookieManager {
    public static String LOGTAG = "CookieManager";
    private static CookieManager d;

    /* renamed from: a  reason: collision with root package name */
    CopyOnWriteArrayList<b> f25001a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    a f25002c = a.MODE_NONE;
    private boolean e = false;
    private boolean f = false;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/CookieManager$a.class */
    public enum a {
        MODE_NONE,
        MODE_KEYS,
        MODE_ALL
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/CookieManager$b.class */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        int f25005a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        String f25006c;
        ValueCallback<Boolean> d;

        b() {
        }
    }

    private CookieManager() {
    }

    public static CookieManager getInstance() {
        if (d == null) {
            synchronized (CookieManager.class) {
                try {
                    if (d == null) {
                        d = new CookieManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    public static int getROMCookieDBVersion(Context context) {
        return context.getSharedPreferences("cookiedb_info", Build.VERSION.SDK_INT >= 11 ? 4 : 0).getInt("db_version", -1);
    }

    public static void setROMCookieDBVersion(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("cookiedb_info", Build.VERSION.SDK_INT >= 11 ? 4 : 0).edit();
        edit.putInt("db_version", i);
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        synchronized (this) {
            this.f = true;
            if (this.f25001a != null && this.f25001a.size() != 0) {
                w a2 = w.a();
                if (a2 == null || !a2.b()) {
                    Iterator<b> it = this.f25001a.iterator();
                    while (it.hasNext()) {
                        b next = it.next();
                        int i = next.f25005a;
                        if (i != 1) {
                            if (i == 2) {
                                android.webkit.CookieManager.getInstance().setCookie(next.b, next.f25006c);
                            }
                        } else if (Build.VERSION.SDK_INT >= 21) {
                            com.tencent.smtt.utils.i.a(android.webkit.CookieManager.getInstance(), "setCookie", new Class[]{String.class, String.class, android.webkit.ValueCallback.class}, next.b, next.f25006c, next.d);
                        }
                    }
                } else {
                    Iterator<b> it2 = this.f25001a.iterator();
                    while (it2.hasNext()) {
                        b next2 = it2.next();
                        int i2 = next2.f25005a;
                        if (i2 == 1) {
                            setCookie(next2.b, next2.f25006c, next2.d);
                        } else if (i2 == 2) {
                            setCookie(next2.b, next2.f25006c);
                        }
                    }
                }
                this.f25001a.clear();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ef A[Catch: all -> 0x0252, TRY_ENTER, TryCatch #0 {, blocks: (B:4:0x0002, B:8:0x0010, B:10:0x001c, B:13:0x0026, B:15:0x002e, B:17:0x0068, B:19:0x006e, B:22:0x0077, B:25:0x0081, B:28:0x0090, B:31:0x0099, B:37:0x00ef, B:39:0x0102, B:41:0x010c, B:49:0x0124, B:52:0x0133, B:71:0x01a0, B:78:0x01e9, B:74:0x01b2, B:75:0x01bd, B:56:0x0153, B:59:0x0162, B:62:0x017d, B:76:0x01de), top: B:93:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r7, boolean r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 616
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.CookieManager.a(android.content.Context, boolean, boolean):void");
    }

    public boolean acceptCookie() {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.CookieManager.getInstance().acceptCookie() : a2.c().d();
    }

    public boolean acceptThirdPartyCookies(WebView webView) {
        synchronized (this) {
            w a2 = w.a();
            if (a2 != null && a2.b()) {
                Object invokeStaticMethod = a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[]{Object.class}, webView.getView());
                if (invokeStaticMethod != null) {
                    return ((Boolean) invokeStaticMethod).booleanValue();
                }
                return true;
            } else if (Build.VERSION.SDK_INT < 21) {
                return true;
            } else {
                Object a3 = com.tencent.smtt.utils.i.a(android.webkit.CookieManager.getInstance(), "acceptThirdPartyCookies", new Class[]{android.webkit.WebView.class}, webView.getView());
                if (a3 != null) {
                    return ((Boolean) a3).booleanValue();
                }
                return false;
            }
        }
    }

    public void flush() {
        w a2 = w.a();
        if (a2 != null && a2.b()) {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
        } else if (Build.VERSION.SDK_INT < 21) {
        } else {
            com.tencent.smtt.utils.i.a(android.webkit.CookieManager.getInstance(), "flush", new Class[0], new Object[0]);
        }
    }

    public String getCookie(String str) {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            try {
                return android.webkit.CookieManager.getInstance().getCookie(str);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return a2.c().a(str);
    }

    public boolean hasCookies() {
        w a2 = w.a();
        return (a2 == null || !a2.b()) ? android.webkit.CookieManager.getInstance().hasCookies() : a2.c().h();
    }

    @Deprecated
    public void removeAllCookie() {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = this.f25001a;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            android.webkit.CookieManager.getInstance().removeAllCookie();
        } else {
            a2.c().e();
        }
    }

    public void removeAllCookies(ValueCallback<Boolean> valueCallback) {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = this.f25001a;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        w a2 = w.a();
        if (a2 != null && a2.b()) {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        } else if (Build.VERSION.SDK_INT < 21) {
        } else {
            com.tencent.smtt.utils.i.a(android.webkit.CookieManager.getInstance(), "removeAllCookies", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        }
    }

    @Deprecated
    public void removeExpiredCookie() {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            android.webkit.CookieManager.getInstance().removeExpiredCookie();
        } else {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
        }
    }

    @Deprecated
    public void removeSessionCookie() {
        w a2 = w.a();
        if (a2 == null || !a2.b()) {
            android.webkit.CookieManager.getInstance().removeSessionCookie();
        } else {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
        }
    }

    public void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        w a2 = w.a();
        if (a2 != null && a2.b()) {
            a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        } else if (Build.VERSION.SDK_INT < 21) {
        } else {
            com.tencent.smtt.utils.i.a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new Class[]{android.webkit.ValueCallback.class}, valueCallback);
        }
    }

    public void setAcceptCookie(boolean z) {
        synchronized (this) {
            w a2 = w.a();
            if (a2 == null || !a2.b()) {
                android.webkit.CookieManager.getInstance().setAcceptCookie(z);
            } else {
                a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            }
        }
    }

    public void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        synchronized (this) {
            w a2 = w.a();
            if (a2 != null && a2.b()) {
                a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[]{Object.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
            } else if (Build.VERSION.SDK_INT < 21) {
            } else {
                com.tencent.smtt.utils.i.a(android.webkit.CookieManager.getInstance(), "setAcceptThirdPartyCookies", new Class[]{android.webkit.WebView.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
            }
        }
    }

    public void setCookie(String str, String str2) {
        synchronized (this) {
            setCookie(str, str2, false);
        }
    }

    public void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        synchronized (this) {
            w a2 = w.a();
            if (a2 == null || !a2.b()) {
                if (!w.a().d()) {
                    b bVar = new b();
                    bVar.f25005a = 1;
                    bVar.b = str;
                    bVar.f25006c = str2;
                    bVar.d = valueCallback;
                    if (this.f25001a == null) {
                        this.f25001a = new CopyOnWriteArrayList<>();
                    }
                    this.f25001a.add(bVar);
                }
                if (this.f) {
                    if (Build.VERSION.SDK_INT < 21) {
                        return;
                    }
                    com.tencent.smtt.utils.i.a(android.webkit.CookieManager.getInstance(), "setCookie", new Class[]{String.class, String.class, android.webkit.ValueCallback.class}, str, str2, valueCallback);
                }
            } else {
                a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class, android.webkit.ValueCallback.class}, str, str2, valueCallback);
            }
        }
    }

    public void setCookie(String str, String str2, boolean z) {
        synchronized (this) {
            w a2 = w.a();
            if (a2 == null || !a2.b()) {
                if (this.f || z) {
                    android.webkit.CookieManager.getInstance().setCookie(str, str2);
                }
                if (!w.a().d()) {
                    b bVar = new b();
                    bVar.f25005a = 2;
                    bVar.b = str;
                    bVar.f25006c = str2;
                    bVar.d = null;
                    if (this.f25001a == null) {
                        this.f25001a = new CopyOnWriteArrayList<>();
                    }
                    this.f25001a.add(bVar);
                }
            } else {
                a2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class}, str, str2);
            }
        }
    }

    public boolean setCookieCompatialbeMode(Context context, a aVar, String str, boolean z) {
        System.currentTimeMillis();
        if (context == null || !TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME)) {
            return false;
        }
        this.f25002c = aVar;
        if (str != null) {
            this.b = str;
        }
        if (this.f25002c == a.MODE_NONE || !z || w.a().d()) {
            return true;
        }
        w.a().a(context);
        return true;
    }

    public void setCookies(Map<String, String[]> map) {
        w a2 = w.a();
        if ((a2 == null || !a2.b()) ? false : a2.c().a(map)) {
            return;
        }
        for (String str : map.keySet()) {
            String[] strArr = map.get(str);
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < length) {
                    setCookie(str, strArr[i2]);
                    i = i2 + 1;
                }
            }
        }
    }
}
