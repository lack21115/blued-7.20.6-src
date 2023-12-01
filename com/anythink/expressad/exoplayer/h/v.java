package com.anythink.expressad.exoplayer.h;

import com.anythink.expressad.exoplayer.h.s;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/v.class */
public final class v extends f<Integer> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f7510a = -1;
    private final s[] b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<s> f7511c;
    private final h d;
    private com.anythink.expressad.exoplayer.ae e;
    private Object f;
    private int g;
    private a h;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/v$a.class */
    public static final class a extends IOException {

        /* renamed from: a  reason: collision with root package name */
        public static final int f7512a = 0;
        public final int b = 0;

        @Retention(RetentionPolicy.SOURCE)
        /* renamed from: com.anythink.expressad.exoplayer.h.v$a$a  reason: collision with other inner class name */
        /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/v$a$a.class */
        public @interface InterfaceC0134a {
        }
    }

    private v(h hVar, s... sVarArr) {
        this.b = sVarArr;
        this.d = hVar;
        this.f7511c = new ArrayList<>(Arrays.asList(sVarArr));
        this.g = -1;
    }

    private v(s... sVarArr) {
        this(new j(), sVarArr);
    }

    private a a(com.anythink.expressad.exoplayer.ae aeVar) {
        if (this.g == -1) {
            this.g = aeVar.c();
            return null;
        } else if (aeVar.c() != this.g) {
            return new a();
        } else {
            return null;
        }
    }

    private void a(s sVar, com.anythink.expressad.exoplayer.ae aeVar, Object obj) {
        a aVar;
        if (this.h == null) {
            if (this.g == -1) {
                this.g = aeVar.c();
            } else if (aeVar.c() != this.g) {
                aVar = new a();
                this.h = aVar;
            }
            aVar = null;
            this.h = aVar;
        }
        if (this.h != null) {
            return;
        }
        this.f7511c.remove(sVar);
        if (sVar == this.b[0]) {
            this.e = aeVar;
            this.f = obj;
        }
        if (this.f7511c.isEmpty()) {
            a(this.e, this.f);
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final r a(s.a aVar, com.anythink.expressad.exoplayer.j.b bVar) {
        int length = this.b.length;
        r[] rVarArr = new r[length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return new u(this.d, rVarArr);
            }
            rVarArr[i2] = this.b[i2].a(aVar, bVar);
            i = i2 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a() {
        super.a();
        this.e = null;
        this.f = null;
        this.g = -1;
        this.h = null;
        this.f7511c.clear();
        Collections.addAll(this.f7511c, this.b);
    }

    @Override // com.anythink.expressad.exoplayer.h.s
    public final void a(r rVar) {
        u uVar = (u) rVar;
        int i = 0;
        while (true) {
            int i2 = i;
            s[] sVarArr = this.b;
            if (i2 >= sVarArr.length) {
                return;
            }
            sVarArr[i2].a(uVar.f7508a[i2]);
            i = i2 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.c
    public final void a(com.anythink.expressad.exoplayer.h hVar, boolean z) {
        super.a(hVar, z);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.b.length) {
                return;
            }
            a((v) Integer.valueOf(i2), this.b[i2]);
            i = i2 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.f
    protected final /* synthetic */ void a(Integer num, s sVar, com.anythink.expressad.exoplayer.ae aeVar, Object obj) {
        a aVar;
        if (this.h == null) {
            if (this.g == -1) {
                this.g = aeVar.c();
            } else if (aeVar.c() != this.g) {
                aVar = new a();
                this.h = aVar;
            }
            aVar = null;
            this.h = aVar;
        }
        if (this.h == null) {
            this.f7511c.remove(sVar);
            if (sVar == this.b[0]) {
                this.e = aeVar;
                this.f = obj;
            }
            if (this.f7511c.isEmpty()) {
                a(this.e, this.f);
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.h.f, com.anythink.expressad.exoplayer.h.s
    public final void b() {
        a aVar = this.h;
        if (aVar != null) {
            throw aVar;
        }
        super.b();
    }
}
