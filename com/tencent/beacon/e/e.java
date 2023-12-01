package com.tencent.beacon.e;

import java.util.Map;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/e/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final int f21327a;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    private boolean f21328c = false;
    private Map<String, String> d = null;
    private Set<String> e = null;
    private Set<String> f = null;

    public e(int i) {
        this.f21327a = i;
    }

    public Map<String, String> a() {
        return this.d;
    }

    public void a(Map<String, String> map) {
        this.d = map;
    }

    public void a(Set<String> set) {
        this.e = set;
    }

    public void a(boolean z) {
        this.f21328c = z;
    }

    public int b() {
        return this.f21327a;
    }

    public void b(Set<String> set) {
        this.f = set;
    }

    public boolean c() {
        return this.f21328c;
    }
}
