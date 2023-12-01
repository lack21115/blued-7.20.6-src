package com.anythink.expressad.splash.c;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.p;
import com.anythink.expressad.foundation.h.x;
import com.anythink.expressad.splash.a.b;
import com.anythink.expressad.splash.c.a;
import com.anythink.expressad.splash.c.e;
import com.anythink.expressad.splash.view.ATSplashView;
import com.anythink.expressad.videocommon.b.i;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/c/c.class */
public final class c {

    /* renamed from: c  reason: collision with root package name */
    private static String f5354c = "SplashLoadManager";
    private static final int l = 1;
    private static final int m = 2;
    private static final int n = 3;
    private int B;
    com.anythink.expressad.foundation.d.c b;
    private String d;
    private String e;
    private long f;
    private long g;
    private com.anythink.expressad.splash.b.c h;
    private ATSplashView j;
    private com.anythink.expressad.d.c k;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private String s;
    private int t;
    private boolean u;
    private volatile boolean v;
    private com.anythink.expressad.videocommon.d.b w;
    private i.d x;
    private String y;
    private int z;
    private String A = "";
    private Handler C = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.splash.c.c.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                Object obj = message.obj;
                int i2 = message.arg1;
                if (obj instanceof com.anythink.expressad.foundation.d.c) {
                    com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) obj;
                    c.a(c.this, i.a().c(cVar.c()), cVar, i2);
                }
            } else if (i != 2) {
                if (i != 3) {
                    return;
                }
                Object obj2 = message.obj;
                if (obj2 instanceof com.anythink.expressad.foundation.d.c) {
                    com.anythink.expressad.foundation.d.c cVar2 = (com.anythink.expressad.foundation.d.c) obj2;
                    c cVar3 = c.this;
                    cVar3.b(cVar2, cVar3.t);
                }
            } else {
                Object obj3 = message.obj;
                if (obj3 instanceof String) {
                    c cVar4 = c.this;
                    String obj4 = obj3.toString();
                    String unused = c.this.s;
                    int unused2 = c.this.t;
                    cVar4.a(obj4);
                }
            }
        }
    };
    private Runnable D = new Runnable() { // from class: com.anythink.expressad.splash.c.c.2
        @Override // java.lang.Runnable
        public final void run() {
            c cVar = c.this;
            String unused = cVar.s;
            int unused2 = c.this.t;
            cVar.a("load timeout");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    boolean f5355a = false;
    private Context i = n.a().g();

    /* renamed from: com.anythink.expressad.splash.c.c$4  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/c/c$4.class */
    final class AnonymousClass4 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.anythink.expressad.foundation.d.c f5360a;
        final /* synthetic */ int b;

        AnonymousClass4(com.anythink.expressad.foundation.d.c cVar, int i) {
            this.f5360a = cVar;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            File file;
            FileOutputStream fileOutputStream;
            File file2;
            FileOutputStream fileOutputStream2 = null;
            FileOutputStream fileOutputStream3 = null;
            try {
                try {
                    try {
                        File file3 = new File(this.f5360a.d());
                        File file4 = file3;
                        try {
                            if (!file3.exists()) {
                                String b = com.anythink.expressad.foundation.g.c.d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_HTML);
                                String a2 = p.a(x.a(this.f5360a.d()));
                                String str = a2;
                                if (TextUtils.isEmpty(a2)) {
                                    str = String.valueOf(System.currentTimeMillis());
                                }
                                file = new File(b, str.concat(".html"));
                                FileOutputStream fileOutputStream4 = null;
                                try {
                                    if (!file.exists()) {
                                        fileOutputStream4 = new FileOutputStream(file);
                                        try {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("<script>");
                                            com.anythink.expressad.d.b.a.a();
                                            sb.append(com.anythink.expressad.d.b.a.b());
                                            sb.append("</script>");
                                            sb.append(this.f5360a.d());
                                            fileOutputStream4.write(sb.toString().getBytes());
                                            fileOutputStream4.flush();
                                        } catch (Exception e) {
                                            fileOutputStream = fileOutputStream4;
                                            e = e;
                                            e.printStackTrace();
                                            FileOutputStream fileOutputStream5 = fileOutputStream;
                                            this.f5360a.j("");
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            file2 = file;
                                            if (!file2.exists()) {
                                            }
                                            c cVar = c.this;
                                            String unused = c.this.s;
                                            cVar.a("html file write failed");
                                        } catch (Throwable th) {
                                            th = th;
                                            fileOutputStream3 = fileOutputStream4;
                                            if (fileOutputStream3 != null) {
                                                fileOutputStream3.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    fileOutputStream2 = fileOutputStream4;
                                    file4 = file;
                                } catch (Exception e2) {
                                    e = e2;
                                    fileOutputStream = null;
                                }
                            }
                            file2 = file4;
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                                file2 = file4;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            file = file3;
                            fileOutputStream = null;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        file = null;
                        fileOutputStream = null;
                    }
                    if (!file2.exists() && file2.isFile() && file2.canRead()) {
                        this.f5360a.b(file2.getAbsolutePath());
                        final File file5 = file2;
                        n.a().a(new Runnable() { // from class: com.anythink.expressad.splash.c.c.4.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                c cVar2 = c.this;
                                c.a(cVar2, "file:////" + file5.getAbsolutePath(), AnonymousClass4.this.f5360a, AnonymousClass4.this.b);
                            }
                        });
                        return;
                    }
                    c cVar2 = c.this;
                    String unused2 = c.this.s;
                    cVar2.a("html file write failed");
                } catch (Exception e5) {
                    c cVar3 = c.this;
                    String message = e5.getMessage();
                    String unused3 = c.this.s;
                    cVar3.a(message);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* renamed from: com.anythink.expressad.splash.c.c$5  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/c/c$5.class */
    final class AnonymousClass5 implements i.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.anythink.expressad.foundation.d.c f5363a;
        final /* synthetic */ int b;

        AnonymousClass5(com.anythink.expressad.foundation.d.c cVar, int i) {
            this.f5363a = cVar;
            this.b = i;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = this.f5363a;
            obtain.arg1 = this.b;
            c.this.C.sendMessage(obtain);
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str, String str2) {
            c cVar = c.this;
            String unused = cVar.s;
            cVar.a(str);
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = str;
            c.this.C.sendMessage(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.splash.c.c$6  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/c/c$6.class */
    public final class AnonymousClass6 implements com.anythink.expressad.splash.b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.anythink.expressad.foundation.d.c f5365a;
        final /* synthetic */ int b;

        AnonymousClass6(com.anythink.expressad.foundation.d.c cVar, int i) {
            this.f5365a = cVar;
            this.b = i;
        }

        @Override // com.anythink.expressad.splash.b.a
        public final void a(View view) {
            if (c.this.j != null) {
                c.this.j.setDynamicView(true);
                c.this.j.setSplashNativeView(view);
                c.this.b(this.f5365a, this.b);
            }
        }

        @Override // com.anythink.expressad.splash.b.a
        public final void a(String str) {
            c cVar = c.this;
            String unused = cVar.s;
            cVar.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.splash.c.c$7  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/c/c$7.class */
    public final class AnonymousClass7 implements e.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.anythink.expressad.foundation.d.c f5367a;
        final /* synthetic */ int b;

        AnonymousClass7(com.anythink.expressad.foundation.d.c cVar, int i) {
            this.f5367a = cVar;
            this.b = i;
        }

        @Override // com.anythink.expressad.splash.c.e.b
        public final void a() {
            if (this.f5367a.s()) {
                return;
            }
            c.c(c.this, this.f5367a, this.b);
        }

        @Override // com.anythink.expressad.splash.c.e.b
        public final void a(int i) {
            if (i == 1) {
                c.c(c.this, this.f5367a, this.b);
            } else {
                c.this.a("readyState 2");
            }
        }

        @Override // com.anythink.expressad.splash.c.e.b
        public final void a(String str) {
            c.this.a(str);
        }
    }

    /* renamed from: com.anythink.expressad.splash.c.c$8  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/c/c$8.class */
    final class AnonymousClass8 implements com.anythink.expressad.videocommon.d.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.anythink.expressad.foundation.d.c f5369a;

        AnonymousClass8(com.anythink.expressad.foundation.d.c cVar) {
            this.f5369a = cVar;
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(String str) {
            c.this.j.setVideoReady(true);
            o.a(c.f5354c, "========VIDEO SUC");
            Message obtain = Message.obtain();
            obtain.obj = this.f5369a;
            obtain.what = 3;
            c.this.C.sendMessage(obtain);
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(String str, String str2) {
            c.this.j.setVideoReady(false);
            o.a(c.f5354c, "========VIDEO FAI");
            Message obtain = Message.obtain();
            obtain.obj = str;
            obtain.what = 2;
            c.this.C.sendMessage(obtain);
        }
    }

    public c(String str, String str2, long j) {
        this.e = str;
        this.d = str2;
        this.g = j;
    }

    private void a(long j) {
        this.C.postDelayed(this.D, j);
    }

    private void a(com.anythink.expressad.foundation.d.c cVar, int i) {
        ATSplashView aTSplashView = this.j;
        if (aTSplashView != null) {
            aTSplashView.setDynamicView(false);
        }
        if (cVar.j()) {
            d(cVar, i);
        }
        if (b.a(this.j, cVar)) {
            b(cVar, i);
            return;
        }
        this.j.clearResState();
        if (!TextUtils.isEmpty(cVar.c()) && !cVar.j()) {
            this.x = new AnonymousClass5(cVar, i);
            i.a().b(cVar.c(), (i.a) this.x);
        }
        if (cVar.j()) {
            return;
        }
        if (!TextUtils.isEmpty(cVar.d())) {
            com.anythink.core.common.k.b.a.a().a(new AnonymousClass4(cVar, i));
        }
        if (!TextUtils.isEmpty(cVar.S())) {
            this.w = new AnonymousClass8(cVar);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            com.anythink.expressad.videocommon.b.e.a().a(this.d, arrayList, 297, this.w);
            if (com.anythink.expressad.videocommon.b.e.a().a(297, this.d, cVar.A())) {
                this.j.setVideoReady(true);
                b(cVar, i);
            } else {
                com.anythink.expressad.videocommon.b.e.a().d(this.d);
            }
        }
        if (TextUtils.isEmpty(cVar.be())) {
            return;
        }
        d(cVar, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0055, code lost:
        if (android.text.TextUtils.isEmpty(r0.d()) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.anythink.expressad.foundation.d.d r8, int r9) {
        /*
            Method dump skipped, instructions count: 597
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.splash.c.c.a(com.anythink.expressad.foundation.d.d, int):void");
    }

    static /* synthetic */ void a(c cVar, String str, com.anythink.expressad.foundation.d.c cVar2, int i) {
        e.c cVar3 = new e.c();
        cVar3.c(cVar.d);
        cVar3.b(cVar.e);
        cVar3.a(cVar2);
        cVar3.a(str);
        cVar3.b(cVar.o);
        cVar3.a(cVar.p);
        cVar3.a(cVar.f5355a);
        e.a.a().a(cVar.j, cVar3, new AnonymousClass7(cVar2, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.u) {
            this.u = false;
        } else {
            b(str);
        }
    }

    private void a(String str, com.anythink.expressad.foundation.d.c cVar, int i) {
        e.c cVar2 = new e.c();
        cVar2.c(this.d);
        cVar2.b(this.e);
        cVar2.a(cVar);
        cVar2.a(str);
        cVar2.b(this.o);
        cVar2.a(this.p);
        cVar2.a(this.f5355a);
        e.a.a().a(this.j, cVar2, new AnonymousClass7(cVar, i));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0052, code lost:
        if (android.text.TextUtils.isEmpty(r0.d()) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.anythink.expressad.foundation.d.c> b(com.anythink.expressad.foundation.d.d r4) {
        /*
            r3 = this;
            r0 = r4
            if (r0 == 0) goto Lb4
            r0 = r4
            java.util.ArrayList<com.anythink.expressad.foundation.d.c> r0 = r0.J
            if (r0 == 0) goto Lb4
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r4
            java.util.ArrayList<com.anythink.expressad.foundation.d.c> r0 = r0.J
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.anythink.expressad.foundation.d.c r0 = (com.anythink.expressad.foundation.d.c) r0
            r7 = r0
            r0 = r7
            r1 = r3
            java.lang.String r1 = r1.d
            r0.l(r1)
            r0 = r3
            r1 = r4
            java.lang.String r1 = r1.c()
            r0.y = r1
            r0 = r6
            r4 = r0
            r0 = r7
            int r0 = r0.O()
            r1 = 99
            if (r0 == r1) goto Lb6
            r0 = r7
            java.lang.String r0 = r0.c()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L55
            r0 = r6
            r4 = r0
            r0 = r7
            java.lang.String r0 = r0.d()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lb6
        L55:
            r0 = r7
            boolean r0 = com.anythink.expressad.foundation.h.t.a(r0)
            if (r0 == 0) goto L79
            r0 = r3
            android.content.Context r0 = r0.i
            r1 = r7
            java.lang.String r1 = r1.ba()
            boolean r0 = com.anythink.expressad.foundation.h.t.a(r0, r1)
            if (r0 == 0) goto L71
            r0 = 1
            r5 = r0
            goto L73
        L71:
            r0 = 2
            r5 = r0
        L73:
            r0 = r7
            r1 = r5
            r0.i(r1)
        L79:
            r0 = r7
            int r0 = r0.ae()
            r1 = 1
            if (r0 == r1) goto La9
            r0 = r3
            android.content.Context r0 = r0.i
            r1 = r7
            java.lang.String r1 = r1.ba()
            boolean r0 = com.anythink.expressad.foundation.h.t.a(r0, r1)
            if (r0 != 0) goto L94
            goto La9
        L94:
            r0 = r6
            r4 = r0
            r0 = r7
            boolean r0 = com.anythink.expressad.foundation.h.t.a(r0)
            if (r0 == 0) goto Lb6
            r0 = r6
            r1 = r7
            boolean r0 = r0.add(r1)
            r0 = r6
            return r0
        La9:
            r0 = r6
            r1 = r7
            boolean r0 = r0.add(r1)
            r0 = r6
            return r0
        Lb4:
            r0 = 0
            r4 = r0
        Lb6:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.splash.c.c.b(com.anythink.expressad.foundation.d.d):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.anythink.expressad.foundation.d.c cVar, int i) {
        if (!b.a(this.j, cVar) || this.v) {
            return;
        }
        l();
        this.b = cVar;
        this.v = true;
        com.anythink.expressad.splash.b.c cVar2 = this.h;
        if (cVar2 != null) {
            cVar2.a(cVar, i);
        }
    }

    static /* synthetic */ void b(c cVar, com.anythink.expressad.foundation.d.c cVar2, int i) {
        if (cVar2.j()) {
            b.a aVar = new b.a();
            aVar.b(cVar.d).a(cVar.e).a(cVar.o).a(cVar2).a(cVar.p).h(cVar.B);
            try {
                if (!TextUtils.isEmpty(cVar2.c())) {
                    Uri parse = Uri.parse(cVar2.c());
                    String queryParameter = parse.getQueryParameter("hdbtn");
                    String queryParameter2 = parse.getQueryParameter(com.anythink.expressad.video.dynview.a.a.Q);
                    String queryParameter3 = parse.getQueryParameter("hdinfo");
                    String queryParameter4 = parse.getQueryParameter("shake_show");
                    String queryParameter5 = parse.getQueryParameter("shake_strength");
                    String queryParameter6 = parse.getQueryParameter("shake_time");
                    String queryParameter7 = parse.getQueryParameter("n_logo");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        aVar.b(Integer.parseInt(queryParameter));
                    }
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        aVar.c(Integer.parseInt(queryParameter2));
                    }
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        aVar.d(Integer.parseInt(queryParameter3));
                    }
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        aVar.e(Integer.parseInt(queryParameter4));
                    }
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        aVar.f(Integer.parseInt(queryParameter5));
                    }
                    if (!TextUtils.isEmpty(queryParameter6)) {
                        aVar.g(Integer.parseInt(queryParameter6));
                    }
                    if (!TextUtils.isEmpty(queryParameter7)) {
                        aVar.i(Integer.parseInt(queryParameter7) == 0 ? 0 : 1);
                    }
                }
            } catch (Throwable th) {
                o.d(f5354c, th.getMessage());
            }
            a.C0085a.a();
            a.a(cVar.j, new com.anythink.expressad.splash.a.b(aVar), new AnonymousClass6(cVar2, i));
        }
    }

    private void b(String str) {
        if (this.v) {
            return;
        }
        l();
        o.d(f5354c, "real failed ");
        this.v = true;
        com.anythink.expressad.splash.b.c cVar = this.h;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    private void c(com.anythink.expressad.foundation.d.c cVar, int i) {
        this.j.clearResState();
        if (!TextUtils.isEmpty(cVar.c()) && !cVar.j()) {
            this.x = new AnonymousClass5(cVar, i);
            i.a().b(cVar.c(), (i.a) this.x);
        }
        if (cVar.j()) {
            return;
        }
        if (!TextUtils.isEmpty(cVar.d())) {
            com.anythink.core.common.k.b.a.a().a(new AnonymousClass4(cVar, i));
        }
        if (!TextUtils.isEmpty(cVar.S())) {
            this.w = new AnonymousClass8(cVar);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            com.anythink.expressad.videocommon.b.e.a().a(this.d, arrayList, 297, this.w);
            if (com.anythink.expressad.videocommon.b.e.a().a(297, this.d, cVar.A())) {
                this.j.setVideoReady(true);
                b(cVar, i);
            } else {
                com.anythink.expressad.videocommon.b.e.a().d(this.d);
            }
        }
        if (TextUtils.isEmpty(cVar.be())) {
            return;
        }
        d(cVar, i);
    }

    static /* synthetic */ void c(c cVar, com.anythink.expressad.foundation.d.c cVar2, int i) {
        if (cVar.j.isH5Ready()) {
            return;
        }
        cVar.j.setH5Ready(true);
        cVar.b(cVar2, i);
    }

    private void c(String str) {
        a(str);
    }

    private void d(final com.anythink.expressad.foundation.d.c cVar, final int i) {
        b.a(this.j, cVar, new com.anythink.expressad.splash.view.a() { // from class: com.anythink.expressad.splash.c.c.3
            @Override // com.anythink.expressad.splash.view.a
            public final void a() {
                if (cVar.j() && c.this.j != null) {
                    c.this.j.setImageReady(true);
                    c.b(c.this, cVar, i);
                }
                c.this.b(cVar, i);
            }

            @Override // com.anythink.expressad.splash.view.a
            public final void b() {
                if (!cVar.j() || c.this.j == null) {
                    return;
                }
                c.this.j.setImageReady(false);
                c cVar2 = c.this;
                String unused = cVar2.s;
                cVar2.a("Image resource load faile");
            }
        });
    }

    private void e(com.anythink.expressad.foundation.d.c cVar, int i) {
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass4(cVar, i));
    }

    private boolean e() {
        return this.o;
    }

    private int f() {
        return this.p;
    }

    private void f(com.anythink.expressad.foundation.d.c cVar, int i) {
        if (cVar.j()) {
            return;
        }
        this.x = new AnonymousClass5(cVar, i);
        i.a().b(cVar.c(), (i.a) this.x);
    }

    private void g() {
        try {
            int i = this.z + 1;
            this.z = i;
            if (this.k == null || i > this.k.t()) {
                o.b(f5354c, "onload 重置offset为0");
                this.z = 0;
            }
            String str = f5354c;
            o.b(str, "onload 算出 下次的offset是:" + this.z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void g(com.anythink.expressad.foundation.d.c cVar, int i) {
        if (cVar.j()) {
            b.a aVar = new b.a();
            aVar.b(this.d).a(this.e).a(this.o).a(cVar).a(this.p).h(this.B);
            try {
                if (!TextUtils.isEmpty(cVar.c())) {
                    Uri parse = Uri.parse(cVar.c());
                    String queryParameter = parse.getQueryParameter("hdbtn");
                    String queryParameter2 = parse.getQueryParameter(com.anythink.expressad.video.dynview.a.a.Q);
                    String queryParameter3 = parse.getQueryParameter("hdinfo");
                    String queryParameter4 = parse.getQueryParameter("shake_show");
                    String queryParameter5 = parse.getQueryParameter("shake_strength");
                    String queryParameter6 = parse.getQueryParameter("shake_time");
                    String queryParameter7 = parse.getQueryParameter("n_logo");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        aVar.b(Integer.parseInt(queryParameter));
                    }
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        aVar.c(Integer.parseInt(queryParameter2));
                    }
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        aVar.d(Integer.parseInt(queryParameter3));
                    }
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        aVar.e(Integer.parseInt(queryParameter4));
                    }
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        aVar.f(Integer.parseInt(queryParameter5));
                    }
                    if (!TextUtils.isEmpty(queryParameter6)) {
                        aVar.g(Integer.parseInt(queryParameter6));
                    }
                    if (!TextUtils.isEmpty(queryParameter7)) {
                        aVar.i(Integer.parseInt(queryParameter7) == 0 ? 0 : 1);
                    }
                }
            } catch (Throwable th) {
                o.d(f5354c, th.getMessage());
            }
            a.C0085a.a();
            a.a(this.j, new com.anythink.expressad.splash.a.b(aVar), new AnonymousClass6(cVar, i));
        }
    }

    private static void h() {
    }

    private void h(com.anythink.expressad.foundation.d.c cVar, int i) {
        if (this.j.isH5Ready()) {
            return;
        }
        this.j.setH5Ready(true);
        b(cVar, i);
    }

    private static void i() {
    }

    private void i(com.anythink.expressad.foundation.d.c cVar, int i) {
        this.w = new AnonymousClass8(cVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        com.anythink.expressad.videocommon.b.e.a().a(this.d, arrayList, 297, this.w);
        if (!com.anythink.expressad.videocommon.b.e.a().a(297, this.d, cVar.A())) {
            com.anythink.expressad.videocommon.b.e.a().d(this.d);
            return;
        }
        this.j.setVideoReady(true);
        b(cVar, i);
    }

    private void j() {
        this.z = 0;
    }

    private static void k() {
    }

    private void l() {
        this.C.removeCallbacks(this.D);
    }

    public final String a() {
        return this.A;
    }

    public final void a(int i) {
        this.B = i;
    }

    public final void a(int i, int i2) {
        this.r = i;
        this.q = i2;
    }

    public final void a(com.anythink.expressad.d.c cVar) {
        this.k = cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0062, code lost:
        if (android.text.TextUtils.isEmpty(r0.d()) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.anythink.expressad.foundation.d.d r8) {
        /*
            Method dump skipped, instructions count: 597
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.splash.c.c.a(com.anythink.expressad.foundation.d.d):void");
    }

    public final void a(com.anythink.expressad.splash.b.c cVar) {
        this.h = cVar;
    }

    public final void a(ATSplashView aTSplashView) {
        this.j = aTSplashView;
    }

    public final void a(boolean z) {
        this.f5355a = z;
    }

    public final void b() {
        if (this.h != null) {
            this.h = null;
        }
        if (this.w != null) {
            this.w = null;
        }
        if (this.x != null) {
            this.x = null;
        }
    }

    public final void b(int i) {
        this.p = i;
    }

    public final void b(boolean z) {
        this.o = z;
    }

    public final com.anythink.expressad.foundation.d.c c() {
        return this.b;
    }
}
