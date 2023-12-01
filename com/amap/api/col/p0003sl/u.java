package com.amap.api.col.p0003sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.p0003sl.hx;
import com.amap.api.col.p0003sl.jw;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.u  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/u.class */
public final class u implements jw.a {
    a a;
    private final Context b;
    private RandomAccessFile c;
    private kd d;
    private String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.u$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/u$a.class */
    public static class a {
        protected String a;
        protected String b;
        protected String c;
        protected String d;
        protected String e;
        protected c f;

        public a(String str, String str2, String str3, String str4) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4 + ".tmp";
            this.e = str4;
        }

        public final String a() {
            return this.a;
        }

        public final void a(c cVar) {
            this.f = cVar;
        }

        public final String b() {
            return this.b;
        }

        public final String c() {
            return this.d;
        }

        public final String d() {
            return this.e;
        }

        public final c e() {
            return this.f;
        }
    }

    /* renamed from: com.amap.api.col.3sl.u$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/u$b.class */
    static final class b extends da {
        private final a a;

        b(a aVar) {
            this.a = aVar;
        }

        @Override // com.amap.api.col.p0003sl.kb
        public final String getIPV6URL() {
            return getURL();
        }

        @Override // com.amap.api.col.p0003sl.da, com.amap.api.col.p0003sl.kb
        public final Map<String, String> getParams() {
            return null;
        }

        @Override // com.amap.api.col.p0003sl.kb
        public final Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.col.p0003sl.kb
        public final String getURL() {
            a aVar = this.a;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        }

        @Override // com.amap.api.col.p0003sl.kb
        public final boolean isSupportIPV6() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.u$c */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/u$c.class */
    public static final class c {
        protected String a;
        protected String b;

        public c(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public final String a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }

        public final boolean c() {
            return (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b)) ? false : true;
        }
    }

    /* renamed from: com.amap.api.col.3sl.u$d */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/u$d.class */
    static final class d extends a {
        public d(String str, String str2, String str3, String str4) {
            super(str, str2, str3, str4);
        }

        public final void a(String str, String str2) {
            a(new c(str, str2));
        }
    }

    public u(Context context, a aVar) {
        this.b = context.getApplicationContext();
        this.a = aVar;
        this.d = new kd(new b(aVar));
        this.e = aVar.c();
    }

    private boolean b() {
        c e = this.a.e();
        return (e != null && e.c() && dm.a(this.b, e.a(), e.b(), "").equalsIgnoreCase(this.a.b())) ? false : true;
    }

    public final void a() {
        if (aa.a == null || hx.a(aa.a, dw.a()).a == hx.c.SuccessCode) {
            try {
                if (!b() || this.d == null) {
                    return;
                }
                this.d.a(this);
            } catch (Throwable th) {
                iw.c(th, "AuthTaskDownload", "startDownload()");
            }
        }
    }

    @Override // com.amap.api.col.p0003sl.jw.a
    public final void onDownload(byte[] bArr, long j) {
        try {
            if (this.c == null) {
                File file = new File(this.e);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.c = new RandomAccessFile(file, "rw");
            }
            this.c.seek(j);
            this.c.write(bArr);
        } catch (Throwable th) {
            iw.c(th, "AuthTaskDownload", "onDownload()");
        }
    }

    @Override // com.amap.api.col.p0003sl.jw.a
    public final void onException(Throwable th) {
        try {
            if (this.c == null) {
                return;
            }
            this.c.close();
        } catch (Throwable th2) {
            iw.c(th2, "AuthTaskDownload", "onException()");
        }
    }

    @Override // com.amap.api.col.p0003sl.jw.a
    public final void onFinish() {
        try {
            if (this.c == null) {
                return;
            }
            this.c.close();
            String b2 = this.a.b();
            String a2 = hw.a(this.e);
            if (a2 == null || !b2.equalsIgnoreCase(a2)) {
                new File(this.e).delete();
                return;
            }
            String d2 = this.a.d();
            bo boVar = new bo();
            File file = new File(this.e);
            boVar.a(file, new File(d2), -1L, bu.a(file), null);
            c e = this.a.e();
            if (e != null && e.c()) {
                dm.a(this.b, e.a(), e.b(), (Object) a2);
            }
            new File(this.e).delete();
        } catch (Throwable th) {
            iw.c(th, "AuthTaskDownload", "onFinish()");
        }
    }

    @Override // com.amap.api.col.p0003sl.jw.a
    public final void onStop() {
    }
}
