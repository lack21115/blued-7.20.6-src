package com.tencent.tmsqmsp.sdk.b;

import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/b/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f39687a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f39688c;
    public String d;
    private Object e;

    public b() {
        new HashMap();
    }

    public Object a() {
        Object obj;
        synchronized (this) {
            obj = this.e;
        }
        return obj;
    }

    public void a(Object obj) {
        synchronized (this) {
            this.e = obj;
        }
    }
}
