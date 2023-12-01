package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.internal.m9;
import com.tencent.mapsdk.internal.n9;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/s9.class */
public abstract class s9<D extends n9> extends l9<D> {

    /* renamed from: c  reason: collision with root package name */
    private static c f38000c = new a();
    private d b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/s9$a.class */
    public static final class a implements c {
        @Override // com.tencent.mapsdk.internal.s9.c
        public String a(String str) {
            return q9.a(str);
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/s9$b.class */
    public enum b {
        DISK,
        DB
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/s9$c.class */
    public interface c {
        String a(String str);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/s9$d.class */
    public static abstract class d implements m9.a {
        private b b;

        /* renamed from: c  reason: collision with root package name */
        private int f38002c = 104857600;
        private c d = s9.f38000c;

        public d(b bVar) {
            this.b = bVar;
        }

        @Override // com.tencent.mapsdk.internal.m9.a
        public int a() {
            return this.f38002c;
        }

        public d a(int i) {
            this.f38002c = i;
            return this;
        }

        public d a(c cVar) {
            this.d = cVar;
            return this;
        }

        public b b() {
            return this.b;
        }

        public c c() {
            return this.d;
        }

        public String toString() {
            return "Options{mType=" + this.b + ", mCacheSize=" + this.f38002c + ", keyGenerator=" + this.d + '}';
        }
    }

    public s9(d dVar) {
        this.b = dVar;
    }

    public d i() {
        return this.b;
    }
}
