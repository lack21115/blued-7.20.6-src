package com.tencent.bugly.idasc.proguard;

import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/proguard/t.class */
public final class t implements Serializable, Comparable<t> {

    /* renamed from: a  reason: collision with root package name */
    public long f21649a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public long f21650c;
    public int d;
    public String e;
    public String f;
    public long g;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(t tVar) {
        return (int) (this.f21650c - tVar.f21650c);
    }
}
