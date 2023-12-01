package com.meizu.cloud.pushsdk.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.d.b.a;
import com.meizu.cloud.pushsdk.d.b.f;
import com.meizu.cloud.pushsdk.d.e.a;
import com.meizu.cloud.pushsdk.d.e.c;
import com.meizu.cloud.pushsdk.d.f.b;
import com.meizu.cloud.pushsdk.d.f.e;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;

/* loaded from: source-4169892-dex2jar.jar:com/meizu/cloud/pushsdk/d/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static com.meizu.cloud.pushsdk.d.e.a f24079a;
    private static BroadcastReceiver b;

    public static com.meizu.cloud.pushsdk.d.e.a a(Context context, com.meizu.cloud.pushsdk.c.c.a aVar, f fVar) {
        if (f24079a == null) {
            synchronized (a.class) {
                try {
                    if (f24079a == null) {
                        com.meizu.cloud.pushsdk.d.e.a a2 = a(b(context, aVar, fVar), (c) null, context);
                        f24079a = a2;
                        a(context, a2);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f24079a;
    }

    public static com.meizu.cloud.pushsdk.d.e.a a(Context context, boolean z) {
        if (f24079a == null) {
            synchronized (a.class) {
                try {
                    if (f24079a == null) {
                        f24079a = a(b(context, null, null), (c) null, context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        DebugLogger.i("PushAndroidTracker", "can upload subject " + z);
        if (z) {
            f24079a.a(a(context));
        }
        return f24079a;
    }

    private static com.meizu.cloud.pushsdk.d.e.a a(com.meizu.cloud.pushsdk.d.b.a aVar, c cVar, Context context) {
        return new com.meizu.cloud.pushsdk.d.e.a.a(new a.C0611a(aVar, "PushAndroidTracker", context.getPackageCodePath(), context, com.meizu.cloud.pushsdk.d.e.a.a.class).a(b.VERBOSE).a((Boolean) false).a(cVar).a(4));
    }

    private static c a(Context context) {
        return new c.a().a(context).a();
    }

    private static String a() {
        String str = MzSystemUtils.isOverseas() ? PushConstants.URL_ABROAD_STATICS_DOMAIN : PushConstants.URL_STATICS_DOMAIN;
        DebugLogger.e("QuickTracker", "current statics domain is " + str);
        return str;
    }

    private static void a(Context context, final com.meizu.cloud.pushsdk.d.e.a aVar) {
        if (b != null) {
            return;
        }
        b = new BroadcastReceiver() { // from class: com.meizu.cloud.pushsdk.d.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                if (e.a(context2)) {
                    com.meizu.cloud.pushsdk.d.f.c.a("QuickTracker", "restart track event: %s", "online true");
                    com.meizu.cloud.pushsdk.d.e.a.this.a();
                }
            }
        };
        context.registerReceiver(b, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    private static com.meizu.cloud.pushsdk.d.b.a b(Context context, com.meizu.cloud.pushsdk.c.c.a aVar, f fVar) {
        return new com.meizu.cloud.pushsdk.d.b.a.a(new a.C0608a(a(), context, com.meizu.cloud.pushsdk.d.b.a.a.class).a(fVar).a(aVar).a(1).a(com.meizu.cloud.pushsdk.d.b.b.DefaultGroup).b(com.meizu.cloud.pushsdk.d.b.b.DefaultGroup.a()).c(2));
    }
}
