package com.tencent.qmsp.sdk.b;

import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/b/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f24838a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f24839c;
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
