package com.tencent.qimei.v;

import com.tencent.qimei.shellapi.IDependency;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/v/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final b f24731a = new a();

    public static b a(String str) {
        com.tencent.qimei.t.b a2 = com.tencent.qimei.t.b.a();
        IDependency a3 = a2.a("StrategyProvider" + str);
        return a3 instanceof b ? (b) a3 : f24731a;
    }

    public static void a(String str, b bVar) {
        com.tencent.qimei.t.b a2 = com.tencent.qimei.t.b.a();
        a2.a("StrategyProvider" + str, bVar);
    }
}
