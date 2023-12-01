package com.tencent.qimei.t;

import com.tencent.qimei.shellapi.IDependency;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/t/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, IDependency> f38416a = new HashMap<>();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/t/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f38417a = new b(null);
    }

    public /* synthetic */ b(com.tencent.qimei.t.a aVar) {
    }

    public static b a() {
        return a.f38417a;
    }

    public IDependency a(String str) {
        return f38416a.get(str);
    }

    public void a(String str, IDependency iDependency) {
        f38416a.put(str, iDependency);
    }
}
