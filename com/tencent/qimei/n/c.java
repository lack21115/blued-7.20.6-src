package com.tencent.qimei.n;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/n/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f38356a = "";
    public Map<String, Object> b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public String f38357c = "";

    public c a(String str, Object obj) {
        this.b.put(str, obj);
        return this;
    }

    public void a(String str) {
        i.a().b(this.f38357c, this.b, str, this.f38356a);
    }
}
