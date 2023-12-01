package com.tencent.beacon.a.a;

import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/a/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public int f21229a;
    public Map<String, Object> b;

    public c(int i) {
        this.f21229a = i;
    }

    public c(int i, Map<String, Object> map) {
        this.f21229a = i;
        this.b = map;
    }

    public String toString() {
        return "BusEvent{channel=" + this.f21229a + ", params=" + this.b + '}';
    }
}
