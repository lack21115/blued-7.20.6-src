package com.tencent.tmsbeacon.a.a;

import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/a/a/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public int f25769a;
    public Map<String, Object> b;

    public c(int i) {
        this.f25769a = i;
    }

    public c(int i, Map<String, Object> map) {
        this.f25769a = i;
        this.b = map;
    }

    public String toString() {
        return "BusEvent{channel=" + this.f25769a + ", params=" + this.b + '}';
    }
}
