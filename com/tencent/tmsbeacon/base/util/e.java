package com.tencent.tmsbeacon.base.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/util/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static AtomicBoolean f39530a = new AtomicBoolean(false);

    public static void a(Context context) {
        if (f39530a.get()) {
            if (com.tencent.tmsbeacon.a.c.b.b(context, "android.permission.INTERNET") && com.tencent.tmsbeacon.a.c.b.b(context, "android.permission.ACCESS_NETWORK_STATE")) {
                return;
            }
            a("当前无网络相关权限！");
        }
    }

    public static void a(String str) {
        c.b("[strict]  " + str, new Object[0]);
        if (f39530a.get()) {
            throw new IllegalStateException("[strict] " + str);
        }
    }

    public static void a(Map map) {
        if (!f39530a.get() || map == null) {
            return;
        }
        for (Object obj : map.keySet()) {
            if (!(obj instanceof String)) {
                a("Key必须为String类型!");
            }
            if (!(map.get(obj) instanceof String)) {
                a("Value必须为String类型!");
            }
        }
    }

    public static boolean a(String str, Object obj) {
        boolean isEmpty = obj instanceof String ? TextUtils.isEmpty((String) obj) : obj == null;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" ");
        sb.append(obj == null ? "=" : "!");
        sb.append("= null!");
        c.a(sb.toString(), new Object[0]);
        if (isEmpty && f39530a.get()) {
            throw new NullPointerException(str + " == null!");
        }
        return isEmpty;
    }
}
