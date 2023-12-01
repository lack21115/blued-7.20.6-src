package com.youzan.x5web;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.WebStorage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import okhttp3.Cookie;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/x5web/StorageManager.class */
public class StorageManager {
    private static final String COOKIE_DIVIDE = ";";
    private static final String COOKIE_KEY_ALIPAY_INSTALLED = "alipay_installed";
    private static final String COOKIE_KEY_HIDE_TOPBAR = "hide_app_topbar";
    private static final String COOKIE_KEY_KDT_SESSION_ID = "KDTSESSIONID";
    private static final String COOKIE_KEY_NOBODY_SIGN = "nobody_sign";
    private static final String COOKIE_KEY_USER_ID = "youzan_user_id";
    private static final String EXPIRES_TIME = "Sat, 31 Dec 2016 23:59:59 GMT";
    private static final String HOST_KDT = "koudaitong.com";
    private static final String HOST_YZ = "youzan.com";
    private static final String RESPONSE_KEY_SET_COOKIE = "Set-Cookie";

    /* loaded from: source-8829756-dex2jar.jar:com/youzan/x5web/StorageManager$Manager.class */
    public static class Manager {
        /* JADX INFO: Access modifiers changed from: private */
        public static List<Cookie> buildYouzanCookie(String str, String str2) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(new Cookie.Builder().domain(StorageManager.HOST_KDT).name(str).value(str2).build());
            arrayList.add(new Cookie.Builder().domain(StorageManager.HOST_YZ).name(str).value(str2).build());
            return arrayList;
        }

        public static void clear(Context context) {
            clearCookie(context);
            clearLocalStorage();
        }

        public static void clearAllCookie(Context context) {
            if (Build.VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().removeAllCookies(null);
                CookieManager.getInstance().flush();
                return;
            }
            CookieSyncManager createInstance = CookieSyncManager.createInstance(context);
            createInstance.startSync();
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.removeAllCookie();
            cookieManager.removeSessionCookie();
            createInstance.stopSync();
            createInstance.sync();
        }

        public static void clearCookie(Context context) {
            try {
                clearAllCookie(context);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public static void clearCookie(String str) {
            CookieManager cookieManager = CookieManager.getInstance();
            String str2 = "https://." + str;
            Set<String> filterFiled = filterFiled(cookieManager.getCookie(str2));
            if (filterFiled != null) {
                for (String str3 : filterFiled) {
                    cookieManager.setCookie(str2, str3 + "=; Expires=" + StorageManager.EXPIRES_TIME);
                }
            }
        }

        public static void clearLocalStorage() {
            try {
                WebStorage.getInstance().deleteAllData();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private static Set<String> filterFiled(String str) {
            HashSet hashSet;
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split(";");
                HashSet hashSet2 = new HashSet(split.length);
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    hashSet = hashSet2;
                    if (i2 >= length) {
                        break;
                    }
                    String str2 = split[i2];
                    if (str2.contains("=")) {
                        hashSet2.add(str2.split("=", 2)[0].trim());
                    }
                    i = i2 + 1;
                }
            } else {
                hashSet = null;
            }
            return hashSet;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0052  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.String filterHeader(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r4) throws java.lang.IllegalStateException {
            /*
                r0 = r4
                if (r0 == 0) goto L70
                r0 = r4
                java.util.Set r0 = r0.entrySet()
                java.util.Iterator r0 = r0.iterator()
                r4 = r0
            L10:
                r0 = r4
                boolean r0 = r0.hasNext()
                if (r0 == 0) goto L70
                r0 = r4
                java.lang.Object r0 = r0.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                r5 = r0
                java.lang.String r0 = "Set-Cookie"
                r1 = r5
                java.lang.Object r1 = r1.getKey()
                java.lang.String r1 = (java.lang.String) r1
                boolean r0 = r0.equalsIgnoreCase(r1)
                if (r0 == 0) goto L10
                r0 = r5
                java.lang.Object r0 = r0.getValue()
                java.util.List r0 = (java.util.List) r0
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L10
                r0 = r5
                java.util.Iterator r0 = r0.iterator()
                r5 = r0
            L49:
                r0 = r5
                boolean r0 = r0.hasNext()
                if (r0 == 0) goto L10
                r0 = r5
                java.lang.Object r0 = r0.next()
                java.lang.String r0 = (java.lang.String) r0
                r6 = r0
                r0 = r6
                java.lang.String r1 = "KDTSESSIONID"
                boolean r0 = r0.contains(r1)
                if (r0 != 0) goto L6e
                r0 = r6
                java.lang.String r1 = "nobody_sign"
                boolean r0 = r0.contains(r1)
                if (r0 == 0) goto L49
            L6e:
                r0 = r6
                return r0
            L70:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                r1 = r0
                java.lang.String r2 = "Response header haven't cookie"
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.youzan.x5web.StorageManager.Manager.filterHeader(java.util.Map):java.lang.String");
        }

        public static void save(Context context, List<Cookie> list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            try {
                if (Build.VERSION.SDK_INT < 21 && context != null) {
                    CookieSyncManager.createInstance(context);
                }
                CookieManager cookieManager = CookieManager.getInstance();
                cookieManager.setAcceptCookie(true);
                for (Cookie cookie : list) {
                    cookieManager.setCookie("https://." + cookie.domain(), cookie.toString());
                }
                if (Build.VERSION.SDK_INT < 21) {
                    CookieSyncManager.getInstance().sync();
                } else {
                    cookieManager.flush();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public static void save(Context context, Cookie... cookieArr) {
            save(context, Arrays.asList(cookieArr));
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/youzan/x5web/StorageManager$Synchronize.class */
    public static class Synchronize {
        public static void hideBar(Context context, boolean z) {
            Manager.save(context, Manager.buildYouzanCookie(StorageManager.COOKIE_KEY_HIDE_TOPBAR, z ? "1" : "0"));
        }

        public static void sessionId(Context context, String str) {
            Manager.save(context, Manager.buildYouzanCookie(StorageManager.COOKIE_KEY_KDT_SESSION_ID, str));
        }
    }

    public static void setCookie(Context context, String str, List<String> list) {
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return;
        }
        if (context != null) {
            try {
                CookieSyncManager.createInstance(context);
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        for (String str2 : list) {
            cookieManager.setCookie(str, str2);
        }
    }
}
