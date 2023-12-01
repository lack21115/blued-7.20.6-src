package com.youzan.androidsdk;

import android.content.Context;
import android.text.TextUtils;
import com.igexin.push.core.b;
import com.youzan.androidsdk.tool.HttpCookie;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/HtmlStorage.class */
public final class HtmlStorage {

    /* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/HtmlStorage$Manager.class */
    public static class Manager {
        public static void clear(Context context) {
            clearCookie(context);
            clearLocalStorage();
        }

        public static void clear(Context context, List<String> list) {
            clearCookie(context, list);
            clearLocalStorage();
        }

        public static void clearCookie(Context context) {
            m9176(context, "koudaitong.com");
            m9176(context, "youzan.com");
        }

        public static void clearCookie(Context context, List<String> list) {
            if (list != null && list.size() > 0) {
                for (String str : list) {
                    m9176(context, str);
                }
            }
            m9176(context, "koudaitong.com");
            m9176(context, "youzan.com");
        }

        public static void clearLocalStorage() {
            YouzanSDK.getSDKAdapter().clearLocalStorage();
        }

        public static void save(Context context, List<HttpCookie> list) {
            YouzanSDK.getSDKAdapter().saveCookies(context, list);
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        static /* synthetic */ List m9174(String str, String str2) {
            ArrayList arrayList = new ArrayList();
            if (YouzanSDK.getSDKAdapter() != null && YouzanSDK.getSDKAdapter().getHostList() != null) {
                List<String> hostList = YouzanSDK.getSDKAdapter().getHostList();
                if (hostList.size() > 0) {
                    for (String str3 : hostList) {
                        arrayList.add(new HttpCookie.Builder().domain(str3).name(str).value(str2).build());
                    }
                }
            }
            arrayList.add(new HttpCookie.Builder().domain("koudaitong.com").name(str).value(str2).build());
            arrayList.add(new HttpCookie.Builder().domain("youzan.com").name(str).value(str2).build());
            return arrayList;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        static /* synthetic */ List m9175(List list, String str, String str2) {
            ArrayList arrayList = new ArrayList((list != null ? list.size() : 0) + 2);
            arrayList.add(new HttpCookie.Builder().domain("koudaitong.com").name(str).value(str2).build());
            arrayList.add(new HttpCookie.Builder().domain("youzan.com").name(str).value(str2).build());
            if (list != null && list.size() > 0) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new HttpCookie.Builder().domain((String) it.next()).name(str).value(str2).build());
                }
            }
            return arrayList;
        }

        /* renamed from: ˊ  reason: contains not printable characters */
        private static void m9176(Context context, String str) {
            YouzanSDK.getSDKAdapter().clearCookieByHost(context, str);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/HtmlStorage$Synchronize.class */
    public static class Synchronize {
        public static void aliPay(Context context) {
            Manager.save(context, Manager.m9174("alipay_installed", "1"));
        }

        public static void hideBar(Context context, boolean z) {
            Manager.save(context, Manager.m9174("hide_app_topbar", z ? "1" : "0"));
        }

        public static void sdkVersion(Context context, String str) {
            Manager.save(context, Manager.m9174("yz_app_sdk_version", str));
        }

        public static void sessionId(Context context, String str) {
            Manager.save(context, Manager.m9174("KDTSESSIONID", str));
        }

        public static void set(Context context, String str, String str2) {
            if ((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) && !b.l.equalsIgnoreCase(str)) {
                return;
            }
            Manager.save(context, Manager.m9174(str, str2));
        }

        public static void set(Context context, List<String> list, String str, String str2) {
            if ((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) && !b.l.equalsIgnoreCase(str)) {
                return;
            }
            Manager.save(context, Manager.m9175(list, str, str2));
        }

        public static void userId(Context context, String str) {
            Manager.save(context, Manager.m9174("youzan_user_id", str));
        }
    }
}
