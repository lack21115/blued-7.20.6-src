package com.tencent.tmsbeacon.d;

import java.util.Map;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/d/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final int f39544a;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    private boolean f39545c = false;
    private Map<String, String> d = null;
    private Set<String> e = null;
    private Set<String> f = null;

    public d(int i) {
        this.f39544a = i;
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
        this.f39545c = z;
    }

    public int b() {
        return this.f39544a;
    }

    public void b(Set<String> set) {
        this.f = set;
    }

    public boolean c() {
        return this.f39545c;
    }
}
