package com.tencent.tmsqmsp.sdk.g.g;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/g/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f26100a;
    public static boolean b;

    public static Context a(Context context) {
        Context context2 = context;
        if (context != null) {
            context2 = context;
            if (context.getApplicationContext() != null) {
                context2 = context.getApplicationContext();
            }
        }
        return context2;
    }
}
