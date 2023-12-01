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
        private boolean f267a;

        /* renamed from: b  reason: collision with other field name */
        private boolean f268b;
        private boolean d;
        private boolean e;

        /* renamed from: a  reason: collision with root package name */
        private int f27654a = 0;

        /* renamed from: c  reason: collision with other field name */
        private boolean f269c = false;
        private int b = 0;
        private boolean f = false;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f266a = Collections.emptyList();

        /* renamed from: c  reason: collision with root package name */
        private int f27655c = -1;

        public static a a(byte[] bArr) {
            return (a) new a().a(bArr);
        }

        public static a b(b bVar) {
            return new a().a(bVar);
        }

        @Override // com.xiaomi.push.e
        public final int a() {
            if (this.f27655c < 0) {
                b();
            }
            return this.f27655c;
        }

        public final a a(int i) {
            this.f267a = true;
            this.f27654a = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public final a a(b bVar) {
            while (true) {
                int m8468a = bVar.m8468a();
                if (m8468a == 0) {
                    return this;
                }
                if (m8468a == 8) {
                    a(bVar.c());
                } else if (m8468a == 16) {
                    a(bVar.m8474a());
                } else if (m8468a == 24) {
                    b(bVar.m8477b());
                } else if (m8468a == 32) {
                    b(bVar.m8474a());
                } else if (m8468a == 42) {
                    a(bVar.m8471a());
                } else if (!a(bVar, m8468a)) {
                    return this;
                }
            }
        }

        public final a a(String str) {
            if (str != null) {
                if (this.f266a.isEmpty()) {
                    this.f266a = new ArrayList();
                }
                this.f266a.add(str);
                return this;
            }
            throw null;
        }

        public final a a(boolean z) {
            this.f268b = true;
            this.f269c = z;
            return this;
        }

        /* renamed from: a  reason: collision with other method in class */
        public final List<String> m8580a() {
            return this.f266a;
        }

        @Override // com.xiaomi.push.e
        public final void a(c cVar) {
            if (m8581a()) {
                cVar.m8525b(1, c());
            }
            if (m8583c()) {
                cVar.m8517a(2, m8582b());
            }
            if (m8584d()) {
                cVar.m8512a(3, d());
            }
            if (f()) {
                cVar.m8517a(4, m8585e());
            }
            for (String str : m8580a()) {
                cVar.m8516a(5, str);
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m8581a() {
            return this.f267a;
        }

        @Override // com.xiaomi.push.e
        public final int b() {
            int b = m8581a() ? c.b(1, c()) + 0 : 0;
            int i = b;
            if (m8583c()) {
                i = b + c.a(2, m8582b());
            }
            int i2 = i;
            if (m8584d()) {
                i2 = i + c.a(3, d());
            }
            int i3 = i2;
            if (f()) {
                i3 = i2 + c.a(4, m8585e());
            }
            Iterator<String> it = m8580a().iterator();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (!it.hasNext()) {
                    int size = i3 + i5 + (m8580a().size() * 1);
                    this.f27655c = size;
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
        public final boolean m8582b() {
            return this.f269c;
        }

        public final int c() {
            return this.f27654a;
        }

        /* renamed from: c  reason: collision with other method in class */
        public final boolean m8583c() {
            return this.f268b;
        }

        public final int d() {
            return this.b;
        }

        /* renamed from: d  reason: collision with other method in class */
        public final boolean m8584d() {
            return this.d;
        }

        public final int e() {
            return this.f266a.size();
        }

        /* renamed from: e  reason: collision with other method in class */
        public final boolean m8585e() {
            return this.f;
        }

        public final boolean f() {
            return this.e;
        }
    }
}
