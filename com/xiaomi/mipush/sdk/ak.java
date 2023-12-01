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
        l.a m8437a = l.m8437a(eVar);
        if (m8437a == null || TextUtils.isEmpty(m8437a.f27538a) || TextUtils.isEmpty(m8437a.b)) {
            return null;
        }
        return (AbstractPushManager) bi.a(m8437a.f27538a, m8437a.b, context);
    }
}
