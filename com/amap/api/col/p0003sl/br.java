package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.bx;
import com.amap.api.col.p0003sl.hx;
import com.amap.api.col.p0003sl.jw;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.MapsInitializer;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.amap.api.col.3sl.br  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/br.class */
public final class br implements jw.a {
    bs a;
    long d;
    bm f;
    a h;
    private Context i;
    private bx j;
    private String k;
    private kd l;
    private bn m;
    long b = 0;
    long c = 0;
    boolean e = true;
    long g = 0;
    private boolean n = false;

    /* renamed from: com.amap.api.col.3sl.br$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/br$a.class */
    public interface a {
        void c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.col.3sl.br$b */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/br$b.class */
    public static final class b extends da {
        private final String a;

        public b(String str) {
            this.a = str;
        }

        @Override // com.amap.api.col.p0003sl.kb
        public final String getIPV6URL() {
            return getURL();
        }

        @Override // com.amap.api.col.p0003sl.kb
        public final Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.col.p0003sl.kb
        public final String getURL() {
            return this.a;
        }

        @Override // com.amap.api.col.p0003sl.kb
        public final boolean isSupportIPV6() {
            return false;
        }
    }

    public br(bs bsVar, String str, Context context, bx bxVar) throws IOException {
        this.a = null;
        this.f = bm.a(context.getApplicationContext());
        this.a = bsVar;
        this.i = context;
        this.k = str;
        this.j = bxVar;
        d();
    }

    private void a(long j) {
        bx bxVar;
        long j2 = this.d;
        if (j2 <= 0 || (bxVar = this.j) == null) {
            return;
        }
        bxVar.a(j2, j);
        this.g = System.currentTimeMillis();
    }

    private void c() throws IOException {
        by byVar = new by(this.k);
        byVar.setConnectionTimeout(30000);
        byVar.setSoTimeout(30000);
        this.l = new kd(byVar, this.b, this.c, MapsInitializer.getProtocol() == 2);
        this.m = new bn(this.a.b() + File.separator + this.a.c(), this.b);
    }

    private void d() {
        File file = new File(this.a.b() + this.a.c());
        if (!file.exists()) {
            this.b = 0L;
            this.c = 0L;
            return;
        }
        this.e = false;
        this.b = file.length();
        try {
            long g = g();
            this.d = g;
            this.c = g;
        } catch (IOException e) {
            bx bxVar = this.j;
            if (bxVar != null) {
                bxVar.a(bx.a.file_io_exception);
            }
        }
    }

    private boolean e() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a.b());
        sb.append(File.separator);
        sb.append(this.a.c());
        return new File(sb.toString()).length() >= 10;
    }

    private void f() throws AMapException {
        if (hp.a == 1) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return;
            }
            try {
                hp.a(this.i, dw.a(), "", (Map<String, String>) null);
            } catch (Throwable th) {
                iw.c(th, "SiteFileFetch", "authOffLineDownLoad");
                th.printStackTrace();
            }
            if (hp.a == 1) {
                return;
            }
            i = i2 + 1;
        }
    }

    private long g() throws IOException {
        if (hx.a(this.i, dw.a()).a != hx.c.SuccessCode) {
            return -1L;
        }
        String a2 = this.a.a();
        Map<String, String> map = null;
        try {
            ka.b();
            map = ka.d((kb) new b(a2), MapsInitializer.getProtocol() == 2);
        } catch (hn e) {
            e.printStackTrace();
        }
        int i = -1;
        int i2 = -1;
        if (map != null) {
            Iterator<String> it = map.keySet().iterator();
            while (true) {
                i2 = i;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if ("Content-Length".equalsIgnoreCase(next)) {
                    i = Integer.parseInt(map.get(next));
                }
            }
        }
        return i2;
    }

    private void h() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.a == null || currentTimeMillis - this.g <= 500) {
            return;
        }
        i();
        this.g = currentTimeMillis;
        a(this.b);
    }

    private void i() {
        this.f.a(this.a.e(), this.a.d(), this.d, this.b, this.c);
    }

    public final void a() {
        try {
            if (!dw.d(this.i)) {
                if (this.j != null) {
                    this.j.a(bx.a.network_exception);
                    return;
                }
                return;
            }
            f();
            if (hp.a != 1) {
                if (this.j != null) {
                    this.j.a(bx.a.amap_exception);
                    return;
                }
                return;
            }
            if (!e()) {
                this.e = true;
            }
            if (this.e) {
                long g = g();
                this.d = g;
                if (g != -1 && g != -2) {
                    this.c = g;
                }
                this.b = 0L;
            }
            if (this.j != null) {
                this.j.m();
            }
            if (this.b >= this.c) {
                onFinish();
                return;
            }
            c();
            this.l.a(this);
        } catch (AMapException e) {
            iw.c(e, "SiteFileFetch", "download");
            bx bxVar = this.j;
            if (bxVar != null) {
                bxVar.a(bx.a.amap_exception);
            }
        } catch (IOException e2) {
            bx bxVar2 = this.j;
            if (bxVar2 != null) {
                bxVar2.a(bx.a.file_io_exception);
            }
        }
    }

    public final void a(a aVar) {
        this.h = aVar;
    }

    public final void b() {
        kd kdVar = this.l;
        if (kdVar != null) {
            kdVar.a();
        }
    }

    @Override // com.amap.api.col.p0003sl.jw.a
    public final void onDownload(byte[] bArr, long j) {
        try {
            this.m.a(bArr);
            this.b = j;
            h();
        } catch (IOException e) {
            e.printStackTrace();
            iw.c(e, "fileAccessI", "fileAccessI.write(byte[] data)");
            bx bxVar = this.j;
            if (bxVar != null) {
                bxVar.a(bx.a.file_io_exception);
            }
            kd kdVar = this.l;
            if (kdVar != null) {
                kdVar.a();
            }
        }
    }

    @Override // com.amap.api.col.p0003sl.jw.a
    public final void onException(Throwable th) {
        bn bnVar;
        this.n = true;
        b();
        bx bxVar = this.j;
        if (bxVar != null) {
            bxVar.a(bx.a.network_exception);
        }
        if ((th instanceof IOException) || (bnVar = this.m) == null) {
            return;
        }
        bnVar.a();
    }

    @Override // com.amap.api.col.p0003sl.jw.a
    public final void onFinish() {
        h();
        bx bxVar = this.j;
        if (bxVar != null) {
            bxVar.n();
        }
        bn bnVar = this.m;
        if (bnVar != null) {
            bnVar.a();
        }
        a aVar = this.h;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.amap.api.col.p0003sl.jw.a
    public final void onStop() {
        if (this.n) {
            return;
        }
        bx bxVar = this.j;
        if (bxVar != null) {
            bxVar.o();
        }
        i();
    }
}
