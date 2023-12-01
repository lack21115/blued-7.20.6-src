package com.opos.mobad.ad.e;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.expressad.video.module.a.a.m;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/ad/e/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public final long f11992a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final String f11993c;
    public final boolean d;
    public final d e;
    public final boolean f;
    public final e g;
    public final boolean h;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/ad/e/f$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private long f11994a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f11995c;
        private boolean d;
        private d e;
        private boolean f;
        private Context g;
        private boolean h;
        private boolean i;
        private e j;

        private a() {
            this.f11994a = 5000L;
            this.d = true;
            this.e = null;
            this.f = false;
            this.g = null;
            this.h = true;
            this.i = true;
        }

        public a(Context context) {
            this.f11994a = 5000L;
            this.d = true;
            this.e = null;
            this.f = false;
            this.g = null;
            this.h = true;
            this.i = true;
            if (context != null) {
                this.g = context.getApplicationContext();
            }
        }

        public a a(long j) {
            if (j >= m.ag && j <= 5000) {
                this.f11994a = j;
            }
            return this;
        }

        public a a(d dVar) {
            if (dVar != null) {
                this.e = dVar;
            }
            return this;
        }

        public a a(e eVar) {
            this.j = eVar;
            return this;
        }

        public a a(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.b = str;
            }
            return this;
        }

        public a a(boolean z) {
            this.d = z;
            return this;
        }

        public f a() throws NullPointerException {
            if (this.g != null) {
                return new f(this);
            }
            throw null;
        }

        public a b(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f11995c = str;
            }
            return this;
        }

        public a b(boolean z) {
            this.f = z;
            return this;
        }

        public a c(boolean z) {
            this.h = z;
            return this;
        }

        public a d(boolean z) {
            this.i = z;
            return this;
        }
    }

    public f(a aVar) {
        this.f11992a = aVar.f11994a;
        this.b = aVar.b;
        this.f11993c = aVar.f11995c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.h = aVar.h;
        this.g = aVar.j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SplashAdParams{fetchTimeout=");
        sb.append(this.f11992a);
        sb.append(", title='");
        sb.append(this.b);
        sb.append('\'');
        sb.append(", desc='");
        sb.append(this.f11993c);
        sb.append('\'');
        sb.append(", showPreLoadPage=");
        sb.append(this.d);
        sb.append(", bottomArea=");
        d dVar = this.e;
        if (dVar == null) {
            dVar = com.igexin.push.core.b.l;
        }
        sb.append(dVar);
        sb.append(", isUseSurfaceView='");
        sb.append(this.f);
        sb.append('\'');
        sb.append(", isVertical=");
        sb.append(this.h);
        sb.append('}');
        return sb.toString();
    }
}
