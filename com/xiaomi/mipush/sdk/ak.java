package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.l;
import com.xiaomi.push.bi;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/ak.class */
public class ak {
    public static AbstractPushManager a(Context context, e eVar) {
        return b(context, eVar);
    }

    private static AbstractPushManager b(Context context, e eVar) {
        l.a m11487a = l.m11487a(eVar);
        if (m11487a == null || TextUtils.isEmpty(m11487a.f41229a) || TextUtils.isEmpty(m11487a.b)) {
            return null;
        }
        return (AbstractPushManager) bi.a(m11487a.f41229a, m11487a.b, context);
    }
}
