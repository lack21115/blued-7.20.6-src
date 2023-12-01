package com.tencent.beacon.base.util;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/util/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static AtomicBoolean f35000a = new AtomicBoolean(false);

    public static void a(String str) {
        c.b("[strict]  " + str, new Object[0]);
        if (f35000a.get()) {
            throw new IllegalStateException("[strict] " + str);
        }
    }

    public static void a(Map map) {
        if (!f35000a.get() || map == null) {
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

    private static boolean a() {
        return f35000a.get() || com.tencent.beacon.a.c.b.d(com.tencent.beacon.a.c.c.d().c());
    }

    public static boolean a(String str, Object obj) {
        boolean isEmpty = obj instanceof String ? TextUtils.isEmpty((String) obj) : obj == null;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" ");
        sb.append(obj == null ? "=" : "!");
        sb.append("= null!");
        c.a(sb.toString(), new Object[0]);
        if (isEmpty && a()) {
            throw new NullPointerException(str + " == null!");
        }
        return isEmpty;
    }
}
