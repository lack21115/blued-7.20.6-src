package com.huawei.hms.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsSession;
import com.huawei.hms.ads.base.R;
import java.util.ArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/kv.class */
public class kv {
    private static final int B = 1;
    private static final int C = 110002100;
    private static final String Code = "HwCustomTabsHelper";
    private static final String D = "com.huawei.browser.cct_page_can_go_back";
    private static final String F = "com.huawei.browser.cct_only_show_title";
    private static final String I = "com.android.browser";
    private static final String L = "com.huawei.browser.cct_horizontal_menu_items";
    private static final int S = 110008300;
    private static final String V = "com.huawei.browser";
    private static final String Z = "cct_extension_version";

    /* renamed from: a  reason: collision with root package name */
    private static final String f22515a = "com.huawei.browser.cct_vertical_menu_items";
    private static final String b = "com.huawei.browser.cct_auto_refresh";

    /* renamed from: c  reason: collision with root package name */
    private static final String f22516c = "com.huawei.browser.cct_emui_style";
    private static final String d = "com.huawei.browser.cct_enable_pps";
    private static final String e = "com.huawei.browser.cct_show_open_in_browser_menu";
    private static final String f = "com.huawei.browser.cct_copy_link";
    private static final String g = "com.huawei.browser.cct_tranlate_disable";
    private static final kv h = new kv();

    private kv() {
    }

    private static boolean B(Context context) {
        PackageManager packageManager = context.getPackageManager();
        boolean z = false;
        if (packageManager == null) {
            return false;
        }
        if (!Code(context, "com.android.browser", (int) S)) {
            ge.V(Code, "isSupportAndroidCustomizedCustom current browser no support");
            return false;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo("com.android.browser", 128);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                int i = bundle != null ? bundle.getInt(Z, 0) : 0;
                ge.V(Code, "isSupportAndroidCustomizedCustom: " + i);
                if (i >= 1) {
                    z = true;
                }
                return z;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            ge.Z(Code, "getApplicationInfo failed due to name not found");
            return false;
        }
    }

    private CustomTabsIntent Code(Activity activity, boolean z) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(V());
        CustomTabsIntent build = builder.build();
        builder.setCloseButtonIcon(BitmapFactory.decodeResource(activity.getResources(), R.drawable.hiad_hm_close_btn));
        builder.addDefaultShareMenuItem();
        build.intent.putExtra(F, true);
        build.intent.putExtra(D, true);
        build.intent.putExtra(b, true);
        build.intent.putExtra(f22516c, true);
        build.intent.putExtra(e, false);
        build.intent.putExtra(d, z);
        build.intent.putExtra(f, true);
        build.intent.putExtra(g, true);
        ArrayList<String> arrayList = new ArrayList<>(10);
        arrayList.add(kw.REFRESH.Code());
        build.intent.putStringArrayListExtra(f22515a, arrayList);
        build.intent.putStringArrayListExtra(L, new ArrayList<>(10));
        return build;
    }

    public static kv Code() {
        kv kvVar;
        synchronized (kv.class) {
            try {
                kvVar = h;
            } catch (Throwable th) {
                throw th;
            }
        }
        return kvVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (Z(r3) != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean Code(android.content.Context r3) {
        /*
            r0 = 0
            r4 = r0
            r0 = r3
            boolean r0 = I(r0)     // Catch: java.lang.Throwable -> L1f
            if (r0 != 0) goto L12
            r0 = r3
            boolean r0 = Z(r0)     // Catch: java.lang.Throwable -> L1f
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L14
        L12:
            r0 = 1
            r4 = r0
        L14:
            r0 = r4
            return r0
        L16:
            java.lang.String r0 = "HwCustomTabsHelper"
            java.lang.String r1 = "not support customTab"
            com.huawei.hms.ads.ge.I(r0, r1)
            r0 = 0
            return r0
        L1f:
            r3 = move-exception
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ads.kv.Code(android.content.Context):boolean");
    }

    private static boolean Code(Context context, String str, int i) {
        PackageManager packageManager;
        boolean z = false;
        if (TextUtils.isEmpty(str) || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 16384);
            if ((packageInfo != null ? packageInfo.versionCode : 0) >= i) {
                z = true;
            }
            return z;
        } catch (PackageManager.NameNotFoundException e2) {
            ge.Z(Code, "getTargetApkInfo failed due to name not found");
            return false;
        }
    }

    private static boolean I(Context context) {
        ArrayList arrayList = new ArrayList(10);
        arrayList.add("com.huawei.browser");
        return "com.huawei.browser".equals(CustomTabsClient.getPackageName(context, arrayList, true)) && Code(context, "com.huawei.browser", (int) C);
    }

    private static Activity V(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return V(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private static boolean Z(Context context) {
        ArrayList arrayList = new ArrayList(10);
        arrayList.add("com.android.browser");
        return "com.android.browser".equals(CustomTabsClient.getPackageName(context, arrayList, true)) && B(context);
    }

    public void Code(Context context, Uri uri, boolean z) {
        ge.Code(Code, "openCustomTab begin");
        Activity V2 = V(context);
        boolean I2 = I(V2);
        CustomTabsIntent Code2 = Code(V2, z);
        Code2.intent.setPackage(I2 ? "com.huawei.browser" : "com.android.browser");
        Code2.intent.setData(uri);
        try {
            if (Code2.intent != null) {
                Code2.intent.setClipData(com.huawei.openalliance.ad.constant.t.cF);
            }
            V2.startActivityForResult(Code2.intent, 0);
        } catch (ActivityNotFoundException e2) {
            ge.Z(Code, "openCustomTab ActivityNotFoundException");
        }
    }

    public CustomTabsSession V() {
        return null;
    }
}
