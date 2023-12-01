package com.anythink.expressad.foundation.h;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.expressad.out.p;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/s.class */
public final class s extends f {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f7972a = false;
    public static char[] b = {'a', 'n', 'd', 'r', 'o', 'i', 'd', 'c', 'o', 'n', 't', 'e', 'n', 't', 'p', 'm', 'g', 'e', 't', 'C', 'o', 'n', 't', 'e', 'x', 't'};

    /* renamed from: c  reason: collision with root package name */
    private static final String f7973c = "SDKUtil";

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/s$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final String f7974a = "com.android.vending";
        public static final String b = "market";

        /* renamed from: c  reason: collision with root package name */
        public static final String f7975c = "play.google.com";
        public static final String d = "market.android.com";
        public static final String e = "google.com";
        public static final String f = "market://";
        public static final String g = "details?id=";
        public static final String h = "market://details?id=com.package.name";

        private static Intent a() {
            return new Intent("android.intent.action.VIEW", Uri.parse(h));
        }

        private static List<ResolveInfo> a(Context context) {
            try {
                return context.getPackageManager().queryIntentActivities(a(), 0);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        public static boolean a(Context context, String str, p.c cVar) {
            try {
                if (!b(str)) {
                    str = c(str) ? "market://".concat(String.valueOf(str.substring(str.indexOf(g)))) : null;
                }
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                Intent a2 = a();
                a2.setData(Uri.parse(str));
                a2.addFlags(268435456);
                context.startActivity(a2);
                s.a(cVar);
                return true;
            } catch (Throwable th) {
                o.d(s.f7973c, Log.getStackTraceString(th));
                return false;
            }
        }

        public static boolean a(String str) {
            return b(str) || c(str);
        }

        private static boolean b(Context context) {
            List<ResolveInfo> a2 = a(context);
            return a2 != null && a2.size() > 0;
        }

        public static boolean b(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return Uri.parse(str).getScheme().equals("market");
            } catch (Throwable th) {
                o.d(s.f7973c, Log.getStackTraceString(th));
                return false;
            }
        }

        private static boolean c(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                Uri parse = Uri.parse(str);
                if (parse.getHost().equals("play.google.com")) {
                    return true;
                }
                return parse.getHost().equals("market.android.com");
            } catch (Throwable th) {
                o.d(s.f7973c, Log.getStackTraceString(th));
                return false;
            }
        }

        private static String d(String str) {
            if (b(str)) {
                return str;
            }
            if (c(str)) {
                return "market://".concat(String.valueOf(str.substring(str.indexOf(g))));
            }
            return null;
        }
    }

    private static String a() {
        return com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.AD_ANYTHINK_700);
    }

    public static String a(String str) {
        String sb;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File a2 = com.anythink.expressad.foundation.g.c.d.a(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_IMG);
        if (TextUtils.isEmpty(str)) {
            sb = "";
        } else if (str.lastIndexOf(BridgeUtil.SPLIT_MARK) == -1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str.hashCode());
            sb = sb2.toString();
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str.hashCode() + str.substring(str.lastIndexOf(BridgeUtil.SPLIT_MARK) + 1).hashCode());
            sb = sb3.toString();
        }
        return new File(a2, sb).getAbsolutePath();
    }

    public static void a(Context context, String str, com.anythink.expressad.foundation.d.c cVar, p.c cVar2) {
        if (context == null) {
            return;
        }
        if (f7972a) {
            a(context, str, cVar2);
            return;
        }
        String str2 = str;
        try {
            Class.forName("com.anythink.expressad.activity.ATCommonActivity");
            Intent intent = new Intent(context, Class.forName("com.anythink.expressad.activity.ATCommonActivity"));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String str3 = str;
            if (a.b(str)) {
                str3 = "https://play.google.com/store/apps/details?id=".concat(String.valueOf(str.replace(BaseConstants.MARKET_PREFIX, "")));
            }
            String str4 = str3;
            intent.putExtra("url", str3);
            String str5 = str3;
            o.b("url", "webview url = ".concat(String.valueOf(str3)));
            String str6 = str3;
            intent.setFlags(268435456);
            String str7 = str3;
            intent.putExtra("mvcommon", cVar);
            str2 = str3;
            context.startActivity(intent);
        } catch (Exception e) {
            a(context, str2, cVar2);
        }
    }

    public static void a(Context context, String str, p.c cVar) {
        if (str == null || context == null) {
            return;
        }
        String str2 = str;
        String str3 = str;
        try {
            if (a.b(str)) {
                str2 = "https://play.google.com/store/apps/details?id=".concat(String.valueOf(str.replace(BaseConstants.MARKET_PREFIX, "")));
            }
            String str4 = str2;
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
            String str5 = str2;
            intent.addFlags(268435456);
            String str6 = str2;
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            if (resolveActivity != null) {
                intent.setClassName(resolveActivity.activityInfo.packageName, resolveActivity.activityInfo.name);
            }
            String str7 = str2;
            context.startActivity(intent);
            str3 = str2;
            a(cVar);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str3));
                intent2.addFlags(268468224);
                context.startActivity(intent2);
                a(cVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(p.c cVar) {
        if (cVar instanceof p.e) {
            ((p.e) cVar).b();
        }
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.lastIndexOf(BridgeUtil.SPLIT_MARK) == -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.hashCode());
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str.hashCode() + str.substring(str.lastIndexOf(BridgeUtil.SPLIT_MARK) + 1).hashCode());
        return sb2.toString();
    }

    private static void b(Context context, String str, p.c cVar) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            boolean z = false;
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities.size() > 0) {
                z = true;
            }
            if (!str.startsWith("market://")) {
                if (str.startsWith("https://play.google.com/")) {
                    b(context, BaseConstants.MARKET_PREFIX.concat(String.valueOf(str.replace("https://play.google.com/store/apps/details?id=", ""))), cVar);
                }
            } else if (!z) {
                a(context, "https://play.google.com/store/apps/details?id=".concat(String.valueOf(str.replace(BaseConstants.MARKET_PREFIX, ""))), cVar);
            } else {
                Iterator<ResolveInfo> it = queryIntentActivities.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next().activityInfo.packageName.equals("com.android.vending")) {
                        intent.setClassName("com.android.vending", "com.android.vending.AssetBrowserActivity");
                        break;
                    }
                }
                try {
                    context.startActivity(intent);
                    a(cVar);
                } catch (Exception e) {
                    a(context, "https://play.google.com/store/apps/details?id=".concat(String.valueOf(str.replace(BaseConstants.MARKET_PREFIX, ""))), cVar);
                }
            }
        } catch (Exception e2) {
            o.d(f7973c, e2.getMessage());
        }
    }
}
