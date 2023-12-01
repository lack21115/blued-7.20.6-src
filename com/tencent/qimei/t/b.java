package com.tencent.qimei.t;

import com.tencent.qimei.shellapi.IDependency;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/t/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<String, IDependency> f24725a = new HashMap<>();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/t/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f24726a = new b(null);
    }

    public /* synthetic */ b(com.tencent.qimei.t.a aVar) {
    }

    public static b a() {
        return a.f24726a;
    }

    public IDependency a(String str) {
        return f24725a.get(str);
    }

    public void a(String str, IDependency iDependency) {
        f24725a.put(str, iDependency);
    }
}
