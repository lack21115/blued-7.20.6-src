package com.meizu.cloud.pushsdk.notification.c;

import android.content.Context;
import android.content.res.AssetManager;
import com.meizu.cloud.pushinternal.DebugLogger;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/notification/c/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f24171a;
    private AssetManager b;

    private d(Context context) {
        b(context);
    }

    public static d a(Context context) {
        if (f24171a == null) {
            f24171a = new d(context);
        }
        return f24171a;
    }

    private void b(Context context) {
        this.b = context.getAssets();
    }

    public int a(Context context, String str, String str2) {
        DebugLogger.i("ResourceReader", "Get resource type " + str2 + " " + str);
        return context.getResources().getIdentifier(str, str2, context.getApplicationInfo().packageName);
    }
}
