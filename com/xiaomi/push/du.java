package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/du.class */
public final class du {

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/du$a.class */
    public static final class a extends e {

        /* renamed from: a  reason: collision with other field name */
        private boolean f314a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f315b;
        private boolean d;
        private boolean e;

        /* renamed from: a  reason: collision with root package name */
        private int f41345a = 0;

        /* renamed from: c  reason: collision with other field name */
        private boolean f316c = false;
        private int b = 0;
        private boolean f = false;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f313a = Collections.emptyList();

        /* renamed from: c  reason: collision with root package name */
        private int f41346c = -1;

        public static a a(byte[] bArr) {
            return (a) new a().a(bArr);
        }

        public static a b(b bVar) {
            return new a().a(bVar);
        }

        @Override // com.xiaomi.push.e
        public final int a() {
            if (this.f41346c < 0) {
                b();
            }
            return this.f41346c;
        }

        public final a a(int i) {
            this.f314a = true;
            this.f41345a = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public final a a(b bVar) {
            while (true) {
                int m11518a = bVar.m11518a();
                if (m11518a == 0) {
                    return this;
                }
                if (m11518a == 8) {
                    a(bVar.c());
                } else if (m11518a == 16) {
                    a(bVar.m11524a());
                } else if (m11518a == 24) {
                    b(bVar.m11527b());
                } else if (m11518a == 32) {
                    b(bVar.m11524a());
                } else if (m11518a == 42) {
                    a(bVar.m11521a());
                } else if (!a(bVar, m11518a)) {
                    return this;
                }
            }
        }

        public final a a(String str) {
            if (str != null) {
                if (this.f313a.isEmpty()) {
                    this.f313a = new ArrayList();
                }
                this.f313a.add(str);
                return this;
            }
            throw null;
        }

        public final a a(boolean z) {
            this.f315b = true;
            this.f316c = z;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final List<String> m11630a() {
            return this.f313a;
        }

        @Override // com.xiaomi.push.e
        public final void a(c cVar) {
            if (m11631a()) {
                cVar.m11575b(1, c());
            }
            if (m11633c()) {
                cVar.m11567a(2, m11632b());
            }
            if (m11634d()) {
                cVar.m11562a(3, d());
            }
            if (f()) {
                cVar.m11567a(4, m11635e());
            }
            for (String str : m11630a()) {
                cVar.m11566a(5, str);
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m11631a() {
            return this.f314a;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int b = m11631a() ? c.b(1, c()) + 0 : 0;
            int i = b;
            if (m11633c()) {
                i = b + c.a(2, m11632b());
            }
            int i2 = i;
            if (m11634d()) {
                i2 = i + c.a(3, d());
            }
            int i3 = i2;
            if (f()) {
                i3 = i2 + c.a(4, m11635e());
            }
            Iterator<String> it = m11630a().iterator();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (!it.hasNext()) {
                    int size = i3 + i5 + (m11630a().size() * 1);
                    this.f41346c = size;
                    return size;
                }
                i4 = i5 + c.a(it.next());
            }
        }

        public final a b(int i) {
            this.d = true;
            this.b = i;
            return this;
        }

        public final a b(boolean z) {
            this.e = true;
            this.f = z;
            return this;
        }

        /* renamed from: b  reason: collision with other method in class */
        public final boolean m11632b() {
            return this.f316c;
        }

        public final int c() {
            return this.f41345a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public final boolean m11633c() {
            return this.f315b;
        }

        public final int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public final boolean m11634d() {
            return this.d;
        }

        public final int e() {
            return this.f313a.size();
        }

        /* renamed from: e  reason: collision with other method in class */
        public final boolean m11635e() {
            return this.f;
        }

        public final boolean f() {
            return this.e;
        }
    }
}
