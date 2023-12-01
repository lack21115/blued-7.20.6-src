package com.tencent.bugly.proguard;

import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/proguard/m.class */
public final class m implements Serializable, Comparable<m> {

    /* renamed from: a  reason: collision with root package name */
    public long f35389a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public long f35390c;
    public int d;
    public String e;
    public String f;
    public long g;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(m mVar) {
        return (int) (this.f35390c - mVar.f35390c);
    }
}
