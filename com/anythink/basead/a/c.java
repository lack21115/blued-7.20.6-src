package com.anythink.basead.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.anythink.basead.handler.OfferClickHandler;
import com.anythink.core.api.IExHandler;
import com.anythink.core.api.IOfferClickHandler;
import com.anythink.core.basead.ui.web.WebLandPageActivity;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.ab;
import com.anythink.core.common.e.ak;
import com.anythink.core.common.e.k;
import com.anythink.core.common.e.s;
import com.anythink.core.common.e.z;
import com.anythink.core.common.k.l;
import com.anythink.core.common.p;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/c.class */
public final class c {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 6;
    public static final int f = 0;
    public static final int g = 1;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    com.anythink.core.common.e.i l;
    boolean m;
    boolean n;
    Context o;
    boolean p;
    com.anythink.core.common.e.j q;
    b r;
    IOfferClickHandler s;
    a t;
    boolean u;
    private final String w = getClass().getSimpleName();
    private final int x = 0;
    private final int y = 1;
    private final int z = 2;
    private final int A = 10;
    boolean v = false;

    /* renamed from: com.anythink.basead.a.c$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/c$1.class */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ com.anythink.basead.c.i a;

        AnonymousClass1(com.anythink.basead.c.i iVar) {
            this.a = iVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (c.a(c.this, this.a)) {
                return;
            }
            int i = 0;
            if (c.this.q.m.l() != 2) {
                i = c.this.b(this.a, false) ? 1 : 2;
            }
            if (i == 1 && c.this.q.m.l() == 1) {
                return;
            }
            IExHandler b = n.a().b();
            if (c.this.l.D() != 4 || 1 != c.this.q.m.o() || b == null || i == 1) {
                c.a(c.this, i, this.a);
                return;
            }
            final int i2 = i;
            b.openApkConfirmDialog(c.this.o, c.this.l, c.this.q, new com.anythink.core.common.f.a() { // from class: com.anythink.basead.a.c.1.1
                @Override // com.anythink.core.common.f.a
                public final void a(boolean z) {
                    if (z) {
                        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.basead.a.c.1.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                c.a(c.this, i2, AnonymousClass1.this.a);
                            }
                        });
                    } else {
                        c.this.m = false;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.basead.a.c$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/c$2.class */
    public final class AnonymousClass2 implements Runnable {
        final /* synthetic */ boolean a;

        AnonymousClass2(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (c.this.r != null && !this.a) {
                c.this.r.a();
            }
            if (c.this.r != null) {
                c.this.r.b();
            }
            if (c.this.r != null) {
                c.this.r.a(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.basead.a.c$4  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/c$4.class */
    public final class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (c.this.r != null) {
                c.this.r.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/c$a.class */
    public static final class a {
        long a;
        long b;
        String c;

        a() {
        }

        final boolean a() {
            return System.currentTimeMillis() - this.a <= this.b;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/c$b.class */
    public interface b {
        void a();

        void a(boolean z);

        void b();
    }

    public c(Context context, com.anythink.core.common.e.j jVar, com.anythink.core.common.e.i iVar) {
        this.l = iVar;
        this.q = jVar;
        this.o = context.getApplicationContext();
        k kVar = jVar.m;
        this.p = !(iVar instanceof com.anythink.core.common.e.g) ? !((iVar instanceof s) && ((s) iVar).O() == 1) : !((kVar instanceof ab) && ((ab) kVar).Y() == 1);
        this.l.g(jVar.d);
        this.s = new OfferClickHandler();
        this.u = this.q.m.Q() != 2;
    }

    private void a(int i2, com.anythink.basead.c.i iVar) {
        String str;
        String str2;
        String str3;
        com.anythink.basead.c.d a2;
        if (i2 != 1) {
            n.a().a(new AnonymousClass4());
        }
        str = "";
        String a3 = j.a((this.l.A() != null ? this.l.A() : "").replaceAll("\\{req_id\\}", this.q.d == null ? "" : this.q.d), iVar, System.currentTimeMillis());
        com.anythink.basead.c.d dVar = (g() && this.l.D() == 4) ? new com.anythink.basead.c.d("", "", "") : new com.anythink.basead.c.d(a3, "", "");
        a(dVar);
        int D = this.l.D();
        if (D == 1) {
            if (!a3.startsWith("http")) {
                a(a3, i2, iVar);
                return;
            }
            a aVar = this.t;
            boolean z = aVar != null && aVar.a();
            boolean z2 = true;
            if (this.p) {
                String y = this.l.y();
                if (z) {
                    y = this.t.c;
                }
                z2 = true;
                if (!TextUtils.isEmpty(y)) {
                    a(y, i2, iVar);
                    z2 = false;
                }
            }
            if (z) {
                str2 = this.t.c;
            } else {
                String b2 = b(a3);
                str2 = b2;
                if (!TextUtils.isEmpty(b2)) {
                    a(b2);
                    str2 = b2;
                }
            }
            if (z2) {
                String str4 = str2;
                if (TextUtils.isEmpty(str2)) {
                    str4 = dVar.a;
                }
                a(str4, i2, iVar);
            }
        } else if (D == 2 || D == 3) {
            String str5 = str;
            if (g()) {
                str5 = str;
                if (!TextUtils.isEmpty(this.l.z())) {
                    str5 = b(a3);
                    String a4 = com.anythink.basead.d.b.a.a.a(str5);
                    dVar.b = str5;
                    dVar.c = a4;
                    a(dVar);
                }
            }
            String str6 = str5;
            if (TextUtils.isEmpty(str5)) {
                str6 = dVar.a;
            }
            a(str6, i2, iVar);
        } else if (D != 4) {
            a(TextUtils.isEmpty("") ? dVar.a : "", i2, iVar);
        } else {
            if (g() && TextUtils.isEmpty(dVar.a) && (a2 = com.anythink.basead.d.b.a.a.a(this.q, this.l, a3)) != null) {
                dVar.a = a2.a;
                dVar.c = a2.c;
            }
            a aVar2 = this.t;
            if (aVar2 == null || !aVar2.a()) {
                String b3 = b(dVar.a);
                str3 = b3;
                if (!TextUtils.isEmpty(b3)) {
                    a(b3);
                    str3 = b3;
                }
            } else {
                str3 = this.t.c;
            }
            dVar.b = str3;
            a(dVar);
            if (TextUtils.isEmpty(str3)) {
                str3 = dVar.a;
            } else {
                iVar.j = true;
            }
            a(str3, i2, iVar);
        }
    }

    static /* synthetic */ void a(c cVar, int i2, com.anythink.basead.c.i iVar) {
        String str;
        String str2;
        String str3;
        com.anythink.basead.c.d a2;
        if (i2 != 1) {
            n.a().a(new AnonymousClass4());
        }
        str = "";
        String a3 = j.a((cVar.l.A() != null ? cVar.l.A() : "").replaceAll("\\{req_id\\}", cVar.q.d == null ? "" : cVar.q.d), iVar, System.currentTimeMillis());
        com.anythink.basead.c.d dVar = (cVar.g() && cVar.l.D() == 4) ? new com.anythink.basead.c.d("", "", "") : new com.anythink.basead.c.d(a3, "", "");
        cVar.a(dVar);
        int D = cVar.l.D();
        if (D == 1) {
            if (!a3.startsWith("http")) {
                cVar.a(a3, i2, iVar);
                return;
            }
            a aVar = cVar.t;
            boolean z = aVar != null && aVar.a();
            boolean z2 = true;
            if (cVar.p) {
                String y = cVar.l.y();
                if (z) {
                    y = cVar.t.c;
                }
                z2 = true;
                if (!TextUtils.isEmpty(y)) {
                    cVar.a(y, i2, iVar);
                    z2 = false;
                }
            }
            if (z) {
                str2 = cVar.t.c;
            } else {
                String b2 = cVar.b(a3);
                str2 = b2;
                if (!TextUtils.isEmpty(b2)) {
                    cVar.a(b2);
                    str2 = b2;
                }
            }
            if (z2) {
                String str4 = str2;
                if (TextUtils.isEmpty(str2)) {
                    str4 = dVar.a;
                }
                cVar.a(str4, i2, iVar);
            }
        } else if (D == 2 || D == 3) {
            String str5 = str;
            if (cVar.g()) {
                str5 = str;
                if (!TextUtils.isEmpty(cVar.l.z())) {
                    str5 = cVar.b(a3);
                    String a4 = com.anythink.basead.d.b.a.a.a(str5);
                    dVar.b = str5;
                    dVar.c = a4;
                    cVar.a(dVar);
                }
            }
            String str6 = str5;
            if (TextUtils.isEmpty(str5)) {
                str6 = dVar.a;
            }
            cVar.a(str6, i2, iVar);
        } else if (D != 4) {
            cVar.a(TextUtils.isEmpty("") ? dVar.a : "", i2, iVar);
        } else {
            if (cVar.g() && TextUtils.isEmpty(dVar.a) && (a2 = com.anythink.basead.d.b.a.a.a(cVar.q, cVar.l, a3)) != null) {
                dVar.a = a2.a;
                dVar.c = a2.c;
            }
            a aVar2 = cVar.t;
            if (aVar2 == null || !aVar2.a()) {
                String b3 = cVar.b(dVar.a);
                str3 = b3;
                if (!TextUtils.isEmpty(b3)) {
                    cVar.a(b3);
                    str3 = b3;
                }
            } else {
                str3 = cVar.t.c;
            }
            dVar.b = str3;
            cVar.a(dVar);
            if (TextUtils.isEmpty(str3)) {
                str3 = dVar.a;
            } else {
                iVar.j = true;
            }
            cVar.a(str3, i2, iVar);
        }
    }

    private void a(com.anythink.basead.c.d dVar) {
        d.a().a(this.l.d(), this.l.p(), dVar);
    }

    private void a(String str) {
        synchronized (this) {
            if (this.t == null) {
                this.t = new a();
            }
            this.t.c = str;
            this.t.b = this.q.m.P();
            this.t.a = System.currentTimeMillis();
        }
    }

    private void a(String str, int i2, com.anythink.basead.c.i iVar) {
        b bVar;
        b bVar2;
        boolean z = true;
        if (i2 == 1) {
            return;
        }
        if (this.n) {
            this.m = false;
            if ((!TextUtils.isEmpty(this.l.o()) || !TextUtils.isEmpty(this.l.z())) && (bVar2 = this.r) != null) {
                bVar2.a(false);
            }
            b(iVar);
            n.a().a(new Runnable() { // from class: com.anythink.basead.a.c.5
                @Override // java.lang.Runnable
                public final void run() {
                    if (c.this.r != null) {
                        c.this.r.b();
                    }
                }
            });
        } else if (i2 == 0 && b(iVar, true)) {
        } else {
            if ((!TextUtils.isEmpty(this.l.o()) || !TextUtils.isEmpty(this.l.z())) && (bVar = this.r) != null) {
                bVar.a(false);
            }
            if (!TextUtils.isEmpty(this.l.B()) && (this.l.D() == 1 || this.l.D() == 4)) {
                boolean a2 = a(this.o, this.l.B());
                iVar.i = new com.anythink.basead.c.b();
                com.anythink.basead.c.d e2 = e();
                iVar.i.a = e2 != null ? e2.c : "";
                if (iVar.g != null) {
                    iVar.g.j = a2 ? 5 : iVar.g.j;
                }
                if (a2) {
                    b(iVar);
                    com.anythink.basead.a.b.a(25, this.l, iVar);
                    this.m = false;
                    n.a().a(new Runnable() { // from class: com.anythink.basead.a.c.6
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (c.this.r != null) {
                                c.this.r.b();
                            }
                        }
                    });
                    return;
                }
                com.anythink.basead.a.b.a(26, this.l, iVar);
            }
            if (iVar.g != null && this.l.D() == 4) {
                if (iVar.j) {
                    IExHandler b2 = n.a().b();
                    iVar.g.j = b2 != null ? b2.checkDownloadType(this.l, this.q) : iVar.g.j;
                } else {
                    iVar.g.j = 3;
                }
            }
            b(iVar);
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = this.l.y();
            }
            if (TextUtils.isEmpty(str2)) {
                Log.e(com.anythink.core.common.b.g.n, "Offer click result is null.");
                n.a().a(new Runnable() { // from class: com.anythink.basead.a.c.7
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            if (TextUtils.isEmpty(c.this.l.A())) {
                                Toast.makeText(c.this.o, com.anythink.core.common.k.h.a(c.this.o, "basead_click_empty", "string"), 0).show();
                            } else {
                                Toast.makeText(c.this.o, com.anythink.core.common.k.h.a(c.this.o, "basead_click_fail", "string"), 0).show();
                            }
                        } catch (Throwable th) {
                        }
                    }
                });
                this.m = false;
                n.a().a(new Runnable() { // from class: com.anythink.basead.a.c.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (c.this.r != null) {
                            c.this.r.b();
                        }
                    }
                });
                return;
            }
            int D = this.l.D();
            if (D == 1) {
                if (str2 == null || str2.startsWith("http")) {
                    z = false;
                }
                if (!com.anythink.core.basead.a.a.a(this.o, str2, z) && !z) {
                    if (this.q.m.k() == 2) {
                        com.anythink.core.basead.b.a aVar = new com.anythink.core.basead.b.a();
                        aVar.c = this.l;
                        aVar.h = this.q;
                        aVar.f = str2;
                        aVar.g = this.s;
                        WebLandPageActivity.a(this.o, aVar);
                    } else {
                        l.a(this.o, str2);
                    }
                }
            } else if (D == 2) {
                l.a(this.o, str2);
            } else if (D == 3) {
                com.anythink.core.basead.b.a aVar2 = new com.anythink.core.basead.b.a();
                aVar2.c = this.l;
                aVar2.h = this.q;
                aVar2.f = str2;
                aVar2.g = this.s;
                WebLandPageActivity.a(this.o, aVar2);
            } else if (D == 4) {
                a(str2, iVar);
            } else if (D != 6) {
                if (this.q.m.k() == 2) {
                    com.anythink.core.basead.b.a aVar3 = new com.anythink.core.basead.b.a();
                    aVar3.c = this.l;
                    aVar3.h = this.q;
                    aVar3.f = str2;
                    aVar3.g = this.s;
                    WebLandPageActivity.a(this.o, aVar3);
                } else {
                    l.a(this.o, str2);
                }
            } else if (!f()) {
                com.anythink.core.basead.b.a aVar4 = new com.anythink.core.basead.b.a();
                aVar4.c = this.l;
                aVar4.h = this.q;
                aVar4.f = str2;
                aVar4.g = this.s;
                WebLandPageActivity.a(this.o, aVar4);
            }
            this.m = false;
            n.a().a(new Runnable() { // from class: com.anythink.basead.a.c.9
                @Override // java.lang.Runnable
                public final void run() {
                    if (c.this.r != null) {
                        c.this.r.b();
                    }
                }
            });
        }
    }

    private void a(String str, com.anythink.basead.c.i iVar) {
        if (iVar.j) {
            if (TextUtils.isEmpty(str)) {
                l.a(this.o, str);
                return;
            } else if (com.anythink.basead.a.b.a(this.o, this.q, this.l, e(), str, new i())) {
                return;
            }
        }
        l.a(this.o, str);
    }

    public static boolean a(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268435456);
                context.startActivity(launchIntentForPackage);
                return true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    static /* synthetic */ boolean a(c cVar, com.anythink.basead.c.i iVar) {
        iVar.i = new com.anythink.basead.c.b();
        com.anythink.basead.c.d e2 = cVar.e();
        iVar.i.a = e2 != null ? e2.c : "";
        if (TextUtils.isEmpty(cVar.l.o())) {
            return false;
        }
        String replaceAll = cVar.l.o().replaceAll("\\{req_id\\}", cVar.q.d == null ? "" : cVar.q.d);
        if (!com.anythink.core.basead.a.a.a(cVar.o, replaceAll, false)) {
            com.anythink.core.common.j.c.a(cVar.q, cVar.l, replaceAll, "0", 1);
            return false;
        }
        if (iVar.g != null) {
            iVar.g.i = true;
        }
        cVar.b(iVar);
        com.anythink.core.common.j.c.a(cVar.q, cVar.l, replaceAll, "1", 1);
        cVar.m = false;
        n.a().a(new AnonymousClass2(false));
        return true;
    }

    private boolean a(com.anythink.basead.c.i iVar, boolean z) {
        iVar.i = new com.anythink.basead.c.b();
        com.anythink.basead.c.d e2 = e();
        iVar.i.a = e2 != null ? e2.c : "";
        if (TextUtils.isEmpty(this.l.o())) {
            return false;
        }
        String replaceAll = this.l.o().replaceAll("\\{req_id\\}", this.q.d == null ? "" : this.q.d);
        if (!com.anythink.core.basead.a.a.a(this.o, replaceAll, false)) {
            com.anythink.core.common.j.c.a(this.q, this.l, replaceAll, "0", 1);
            return false;
        }
        if (iVar.g != null) {
            iVar.g.i = true;
        }
        b(iVar);
        com.anythink.core.common.j.c.a(this.q, this.l, replaceAll, "1", 1);
        this.m = false;
        n.a().a(new AnonymousClass2(z));
        return true;
    }

    private String b(String str) {
        String str2;
        HttpURLConnection httpURLConnection;
        Exception e2;
        HttpURLConnection httpURLConnection2;
        String str3;
        int responseCode;
        boolean z;
        String str4;
        String str5 = str;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 10) {
                return "";
            }
            HttpURLConnection httpURLConnection3 = null;
            try {
                try {
                    httpURLConnection2 = (HttpURLConnection) new URL(str5).openConnection();
                    str3 = str5;
                    try {
                        httpURLConnection2.setRequestMethod("GET");
                        String str6 = str5;
                        httpURLConnection2.setInstanceFollowRedirects(false);
                        String str7 = str5;
                        if (this.q.m != null) {
                            String str8 = str5;
                            if (com.anythink.basead.a.b.a(9, this.q.m)) {
                                String str9 = str5;
                                String i4 = com.anythink.core.common.k.d.i();
                                String str10 = str5;
                                if (!TextUtils.isEmpty(i4)) {
                                    String str11 = str5;
                                    httpURLConnection2.addRequestProperty("User-Agent", i4);
                                }
                            }
                        }
                        String str12 = str5;
                        httpURLConnection2.setConnectTimeout(30000);
                        String str13 = str5;
                        httpURLConnection2.connect();
                        String str14 = str5;
                        responseCode = httpURLConnection2.getResponseCode();
                        if (responseCode != 302 && responseCode != 301) {
                            z = false;
                            str4 = str5;
                            if (responseCode != 307) {
                                break;
                            }
                        }
                        str5 = httpURLConnection2.getHeaderField("Location");
                        if (com.anythink.core.basead.a.a.b(str5) || str5.contains(com.anythink.china.common.a.a.g) || !str5.startsWith("http")) {
                            break;
                        }
                        httpURLConnection2.disconnect();
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        i2 = i3 + 1;
                    } catch (Exception e3) {
                        e2 = e3;
                        httpURLConnection = httpURLConnection2;
                        str2 = str3;
                        httpURLConnection3 = httpURLConnection;
                        com.anythink.core.common.j.c.a(this.q, this.l, str, str2, "", e2.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            return "";
                        }
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection3 = httpURLConnection2;
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e4) {
                str2 = str5;
                httpURLConnection = null;
                e2 = e4;
            }
        }
        z = true;
        str4 = str5;
        if (z || responseCode == 200) {
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return str4;
        }
        str3 = str4;
        com.anythink.core.common.j.c.a(this.q, this.l, str, str4, String.valueOf(responseCode), "");
        if (httpURLConnection2 != null) {
            httpURLConnection2.disconnect();
            return "";
        }
        return "";
    }

    private void b(com.anythink.basead.c.i iVar) {
        if (this.u || !this.v) {
            this.v = true;
            com.anythink.basead.a.b.a(9, this.l, iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(com.anythink.basead.c.i iVar, final boolean z) {
        iVar.i = new com.anythink.basead.c.b();
        com.anythink.basead.c.d e2 = e();
        iVar.i.a = e2 != null ? e2.c : "";
        com.anythink.basead.a.b.a(23, this.l, iVar);
        if (TextUtils.isEmpty(this.l.z())) {
            return false;
        }
        String replaceAll = this.l.z().replaceAll("\\{req_id\\}", this.q.d == null ? "" : this.q.d);
        p.a().a(this.l);
        if (!com.anythink.core.basead.a.a.a(this.o, replaceAll, false)) {
            p.a().b(this.l);
            if (com.anythink.basead.a.b.a(this.o, this.l.B())) {
                com.anythink.basead.a.b.a(28, this.l, iVar);
            } else {
                com.anythink.basead.a.b.a(29, this.l, iVar);
            }
            com.anythink.core.common.j.c.a(this.q, this.l, replaceAll, "0", 0);
            return false;
        }
        if (iVar.g != null) {
            iVar.g.i = true;
        }
        b(iVar);
        com.anythink.core.common.j.c.a(this.q, this.l, replaceAll, "1", 0);
        this.m = false;
        n.a().a(new Runnable() { // from class: com.anythink.basead.a.c.3
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.r != null && !z) {
                    c.this.r.a();
                }
                if (c.this.r != null) {
                    c.this.r.b();
                }
                if (c.this.r != null) {
                    c.this.r.a(true);
                }
            }
        });
        com.anythink.basead.a.b.a(24, this.l, iVar);
        return true;
    }

    private com.anythink.basead.c.d e() {
        return d.a().a(this.l.d(), this.l.p());
    }

    private boolean f() {
        ak L = n.a().L();
        boolean z = L.b() == 1;
        boolean z2 = L.a() == 1;
        String l = com.anythink.core.common.k.d.l();
        if (TextUtils.isEmpty(l)) {
            com.anythink.core.common.j.c.a(this.q, this.l, 5);
            return false;
        } else if (!z) {
            com.anythink.core.common.j.c.a(this.q, this.l, 3);
            return false;
        } else if (!z2) {
            com.anythink.core.common.j.c.a(this.q, this.l, 1);
            return false;
        } else {
            String e2 = this.l.e();
            String f2 = this.l.f();
            if (TextUtils.isEmpty(e2) || TextUtils.isEmpty(f2)) {
                com.anythink.core.common.j.c.a(this.q, this.l, 4);
                return false;
            }
            try {
                Object c2 = com.anythink.core.common.k.d.c(l);
                Class<?> cls = Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
                Object newInstance = cls.newInstance();
                cls.getField("userName").set(newInstance, e2);
                cls.getField("path").set(newInstance, f2);
                cls.getField("miniprogramType").set(newInstance, cls.getField("MINIPTOGRAM_TYPE_RELEASE").get(null));
                Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("sendReq", Class.forName("com.tencent.mm.opensdk.modelbase.BaseReq")).invoke(c2, newInstance);
                com.anythink.core.common.j.c.a(this.q, this.l, 0);
                return true;
            } catch (Throwable th) {
                com.anythink.core.common.e.j jVar = this.q;
                com.anythink.core.common.e.i iVar = this.l;
                th.getMessage();
                com.anythink.core.common.j.c.a(jVar, iVar, 2);
                return false;
            }
        }
    }

    private boolean g() {
        if (this.l.n() != 42) {
            com.anythink.core.common.e.i iVar = this.l;
            return (iVar instanceof z) && ((z) iVar).a() == 42;
        }
        return true;
    }

    private void h() {
        this.n = true;
    }

    public final void a(b bVar) {
        this.r = bVar;
    }

    public final void a(com.anythink.basead.c.i iVar) {
        if (this.m) {
            return;
        }
        this.m = true;
        this.n = false;
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass1(iVar));
    }

    public final boolean a() {
        return this.m;
    }

    public final com.anythink.core.common.e.i b() {
        return this.l;
    }

    public final com.anythink.core.common.e.j c() {
        return this.q;
    }

    public final void d() {
        this.r = null;
    }
}
