package com.anythink.expressad.exoplayer.j.a;

import com.anythink.expressad.exoplayer.j.a.a;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Iterator;
import java.util.TreeSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/j/a/g.class */
public final class g {

    /* renamed from: c  reason: collision with root package name */
    private static final int f4723c = 2;
    private static final int d = Integer.MAX_VALUE;

    /* renamed from: a  reason: collision with root package name */
    public final int f4724a;
    public final String b;
    private boolean g;
    private l f = l.b;
    private final TreeSet<n> e = new TreeSet<>();

    public g(int i, String str) {
        this.f4724a = i;
        this.b = str;
    }

    public static g a(int i, DataInputStream dataInputStream) {
        g gVar = new g(dataInputStream.readInt(), dataInputStream.readUTF());
        if (i >= 2) {
            gVar.f = l.a(dataInputStream);
            return gVar;
        }
        long readLong = dataInputStream.readLong();
        k kVar = new k();
        j.a(kVar, readLong);
        gVar.a(kVar);
        return gVar;
    }

    public final int a(int i) {
        int i2;
        int hashCode;
        int hashCode2 = (this.f4724a * 31) + this.b.hashCode();
        if (i < 2) {
            long a2 = j.a(this.f);
            i2 = hashCode2 * 31;
            hashCode = (int) (a2 ^ (a2 >>> 32));
        } else {
            i2 = hashCode2 * 31;
            hashCode = this.f.hashCode();
        }
        return i2 + hashCode;
    }

    public final long a(long j, long j2) {
        n a2 = a(j);
        if (a2.b()) {
            return -Math.min(a2.a() ? Long.MAX_VALUE : a2.f4719c, j2);
        }
        long j3 = j + j2;
        long j4 = a2.b + a2.f4719c;
        long j5 = j4;
        if (j4 < j3) {
            Iterator<n> it = this.e.tailSet(a2, false).iterator();
            do {
                j5 = j4;
                if (!it.hasNext()) {
                    break;
                }
                n next = it.next();
                j5 = j4;
                if (next.b > j4) {
                    break;
                }
                j5 = Math.max(j4, next.b + next.f4719c);
                j4 = j5;
            } while (j5 < j3);
        }
        return Math.min(j5 - j, j2);
    }

    public final i a() {
        return this.f;
    }

    public final n a(long j) {
        n a2 = n.a(this.b, j);
        n floor = this.e.floor(a2);
        if (floor == null || floor.b + floor.f4719c <= j) {
            n ceiling = this.e.ceiling(a2);
            return ceiling == null ? n.b(this.b, j) : n.a(this.b, j, ceiling.b - j);
        }
        return floor;
    }

    public final void a(n nVar) {
        this.e.add(nVar);
    }

    public final void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.f4724a);
        dataOutputStream.writeUTF(this.b);
        this.f.a(dataOutputStream);
    }

    public final void a(boolean z) {
        this.g = z;
    }

    public final boolean a(e eVar) {
        if (this.e.remove(eVar)) {
            eVar.e.delete();
            return true;
        }
        return false;
    }

    public final boolean a(k kVar) {
        l lVar = this.f;
        l a2 = lVar.a(kVar);
        this.f = a2;
        return !a2.equals(lVar);
    }

    public final n b(n nVar) {
        com.anythink.expressad.exoplayer.k.a.b(this.e.remove(nVar));
        n a2 = nVar.a(this.f4724a);
        if (nVar.e.renameTo(a2.e)) {
            this.e.add(a2);
            return a2;
        }
        throw new a.C0067a("Renaming of " + nVar.e + " to " + a2.e + " failed.");
    }

    public final boolean b() {
        return this.g;
    }

    public final TreeSet<n> c() {
        return this.e;
    }

    public final boolean d() {
        return this.e.isEmpty();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f4724a == gVar.f4724a && this.b.equals(gVar.b) && this.e.equals(gVar.e) && this.f.equals(gVar.f);
    }

    public final int hashCode() {
        return (a(Integer.MAX_VALUE) * 31) + this.e.hashCode();
    }
}
