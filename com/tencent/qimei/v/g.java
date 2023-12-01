package com.tencent.qimei.v;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/v/g.class */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, String> f38426a = new ConcurrentHashMap();

    public static String a(String str) {
        return f38426a.get(str);
    }
}
