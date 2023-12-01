package com.anythink.expressad.exoplayer.j.a;

import java.io.File;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/a/e.class */
public class e implements Comparable<e> {

    /* renamed from: a  reason: collision with root package name */
    public final String f7557a;
    public final long b;

    /* renamed from: c  reason: collision with root package name */
    public final long f7558c;
    public final boolean d;
    public final File e;
    public final long f;

    private e(String str, long j, long j2) {
        this(str, j, j2, com.anythink.expressad.exoplayer.b.b, null);
    }

    public e(String str, long j, long j2, long j3, File file) {
        this.f7557a = str;
        this.b = j;
        this.f7558c = j2;
        this.d = file != null;
        this.e = file;
        this.f = j3;
    }

    private int a(e eVar) {
        if (this.f7557a.equals(eVar.f7557a)) {
            int i = ((this.b - eVar.b) > 0L ? 1 : ((this.b - eVar.b) == 0L ? 0 : -1));
            if (i == 0) {
                return 0;
            }
            return i < 0 ? -1 : 1;
        }
        return this.f7557a.compareTo(eVar.f7557a);
    }

    public final boolean a() {
        return this.f7558c == -1;
    }

    public final boolean b() {
        return !this.d;
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(e eVar) {
        e eVar2 = eVar;
        if (this.f7557a.equals(eVar2.f7557a)) {
            int i = ((this.b - eVar2.b) > 0L ? 1 : ((this.b - eVar2.b) == 0L ? 0 : -1));
            if (i == 0) {
                return 0;
            }
            return i < 0 ? -1 : 1;
        }
        return this.f7557a.compareTo(eVar2.f7557a);
    }
}
