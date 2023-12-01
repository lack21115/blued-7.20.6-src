package com.tencent.tmsbeacon.c;

import com.tencent.tmsbeacon.module.ModuleName;
import com.tencent.tmsbeacon.module.StatModule;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/c/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Long> f25840a = new HashMap();

    public static void a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        f25840a.put(str, Long.valueOf(currentTimeMillis));
        com.tencent.tmsbeacon.base.util.c.a("[page] onPageIn cost time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public static void b(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, Long> map = f25840a;
        if (map == null) {
            com.tencent.tmsbeacon.base.util.c.e("[page] please call 'onPageIn' first!", new Object[0]);
            return;
        }
        Long l = map.get(str);
        if (l == null) {
            com.tencent.tmsbeacon.base.util.c.e("[page] please call 'onPageIn' first!", new Object[0]);
            return;
        }
        ((StatModule) com.tencent.tmsbeacon.a.c.c.d().a(ModuleName.STAT)).a(str, currentTimeMillis - l.longValue(), currentTimeMillis);
        f25840a.remove(str);
        com.tencent.tmsbeacon.base.util.c.a("[page] onPageOut cost time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }
}
