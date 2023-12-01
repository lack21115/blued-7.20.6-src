package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.blued.das.live.LiveProtos;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/Bugly.class */
public class Bugly {
    public static final String SDK_IS_DEV = "false";

    /* renamed from: a  reason: collision with root package name */
    private static boolean f21411a = false;
    public static Context applicationContext;
    private static String[] b = {"BuglyCrashModule", "BuglyRqdModule", "BuglyBetaModule"};

    /* renamed from: c  reason: collision with root package name */
    private static String[] f21412c = {"BuglyRqdModule", "BuglyCrashModule", "BuglyBetaModule"};
    public static boolean enable = true;
    public static Boolean isDev;

    public static String getAppChannel() {
        byte[] bArr;
        synchronized (Bugly.class) {
            try {
                com.tencent.bugly.crashreport.common.info.a b2 = com.tencent.bugly.crashreport.common.info.a.b();
                if (b2 == null) {
                    return null;
                }
                if (TextUtils.isEmpty(b2.m)) {
                    p a2 = p.a();
                    if (a2 == null) {
                        return b2.m;
                    }
                    Map<String, byte[]> a3 = a2.a(LiveProtos.Event.LIVE_SCREEN_BARRAGE_CLICK_VALUE, (o) null, true);
                    if (a3 != null && (bArr = a3.get("app_channel")) != null) {
                        return new String(bArr);
                    }
                }
                return b2.m;
            } finally {
            }
        }
    }

    public static void init(Context context, String str, boolean z) {
        init(context, str, z, null);
    }

    public static void init(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        synchronized (Bugly.class) {
            try {
                if (f21411a) {
                    return;
                }
                f21411a = true;
                Context a2 = z.a(context);
                applicationContext = a2;
                if (a2 == null) {
                    Log.e(x.f21723a, "init arg 'context' should not be null!");
                    return;
                }
                if (isDev()) {
                    b = f21412c;
                }
                String[] strArr = b;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        b.f21417a = enable;
                        b.a(applicationContext, str, z, buglyStrategy);
                        return;
                    }
                    String str2 = strArr[i2];
                    if (str2.equals("BuglyCrashModule")) {
                        b.a(CrashModule.getInstance());
                    } else if (!str2.equals("BuglyBetaModule") && !str2.equals("BuglyRqdModule")) {
                        str2.equals("BuglyFeedbackModule");
                    }
                    i = i2 + 1;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean isDev() {
        if (isDev == null) {
            isDev = Boolean.valueOf(Boolean.parseBoolean("false".replace("@", "")));
        }
        return isDev.booleanValue();
    }
}
