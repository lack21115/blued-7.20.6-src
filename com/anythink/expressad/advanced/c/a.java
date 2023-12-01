package com.anythink.expressad.advanced.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.anythink.core.common.b.n;
import com.anythink.expressad.advanced.js.NativeAdvancedJSBridgeImpl;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.anythink.expressad.advanced.view.ATNativeAdvancedView;
import com.anythink.expressad.advanced.view.ATNativeAdvancedWebview;
import com.anythink.expressad.foundation.g.c.d;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.p;
import com.anythink.expressad.foundation.h.x;
import com.anythink.expressad.videocommon.b.e;
import com.anythink.expressad.videocommon.b.i;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/c/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f6994a = "NativeAdvancedLoadManager";
    private static final int j = 1;
    private static final int k = 2;
    private static final int l = 3;
    private static final int m = 4;
    private static final int n = 5;
    private int A;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f6995c;
    private long d;
    private com.anythink.expressad.advanced.b.a e;
    private ATNativeAdvancedView g;
    private com.anythink.expressad.d.c h;
    private com.anythink.expressad.foundation.d.c i;
    private int o;
    private int p;
    private int q;
    private int r;
    private String s;
    private int t;
    private boolean u;
    private volatile boolean v;
    private com.anythink.expressad.videocommon.d.b w;
    private i.d x;
    private i.d y;
    private String z;
    private String B = "";
    private Handler C = new Handler(Looper.getMainLooper()) { // from class: com.anythink.expressad.advanced.c.a.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Object obj;
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                Object obj2 = message.obj;
                int i2 = message.arg1;
                if (obj2 == null || !(obj2 instanceof com.anythink.expressad.foundation.d.c)) {
                    return;
                }
                com.anythink.expressad.foundation.d.c cVar = (com.anythink.expressad.foundation.d.c) obj2;
                a.a(a.this, i.a().c(cVar.c()), cVar, i2);
            } else if (i == 2) {
                Object obj3 = message.obj;
                if (obj3 == null || !(obj3 instanceof String)) {
                    return;
                }
                a aVar = a.this;
                String obj4 = obj3.toString();
                String unused = a.this.s;
                aVar.b(obj4, a.this.t);
            } else if (i == 3) {
                Object obj5 = message.obj;
                if (obj5 == null || !(obj5 instanceof com.anythink.expressad.foundation.d.c)) {
                    return;
                }
                com.anythink.expressad.foundation.d.c cVar2 = (com.anythink.expressad.foundation.d.c) obj5;
                a aVar2 = a.this;
                aVar2.a(cVar2, aVar2.t);
            } else if (i != 4) {
                if (i == 5 && (obj = message.obj) != null && (obj instanceof com.anythink.expressad.foundation.d.c)) {
                    if (a.this.g != null) {
                        a.this.g.setVideoReady(true);
                    }
                    com.anythink.expressad.foundation.d.c cVar3 = (com.anythink.expressad.foundation.d.c) obj;
                    a aVar3 = a.this;
                    aVar3.a(cVar3, aVar3.t);
                }
            } else {
                Object obj6 = message.obj;
                if (obj6 == null || !(obj6 instanceof com.anythink.expressad.foundation.d.c)) {
                    return;
                }
                if (a.this.g != null) {
                    a.this.g.setEndCardReady(true);
                }
                com.anythink.expressad.foundation.d.c cVar4 = (com.anythink.expressad.foundation.d.c) obj6;
                a aVar4 = a.this;
                aVar4.a(cVar4, aVar4.t);
            }
        }
    };
    private Runnable D = new Runnable() { // from class: com.anythink.expressad.advanced.c.a.3
        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            String unused = aVar.s;
            aVar.b("load timeout", a.this.t);
        }
    };
    private Context f = n.a().g();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.advanced.c.a$10  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/c/a$10.class */
    public final class AnonymousClass10 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ATNativeAdvancedWebview f6997a;
        final /* synthetic */ String b;

        AnonymousClass10(ATNativeAdvancedWebview aTNativeAdvancedWebview, String str) {
            this.f6997a = aTNativeAdvancedWebview;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f6997a.loadUrl(x.c(this.b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.advanced.c.a$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/c/a$2.class */
    public final class AnonymousClass2 implements com.anythink.expressad.videocommon.d.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.anythink.expressad.foundation.d.c f6999a;

        AnonymousClass2(com.anythink.expressad.foundation.d.c cVar) {
            this.f6999a = cVar;
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(String str) {
            o.a(a.f6994a, "Video 下载成功： ".concat(String.valueOf(str)));
            Message obtain = Message.obtain();
            obtain.obj = this.f6999a;
            obtain.what = 5;
            a.this.C.sendMessage(obtain);
        }

        @Override // com.anythink.expressad.videocommon.d.b
        public final void a(String str, String str2) {
            o.a(a.f6994a, "Video 下载失败： ".concat(String.valueOf(str)));
            Message obtain = Message.obtain();
            obtain.obj = str;
            obtain.what = 2;
            a.this.C.sendMessage(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.advanced.c.a$4  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/c/a$4.class */
    public final class AnonymousClass4 implements com.anythink.expressad.foundation.g.d.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.anythink.expressad.foundation.d.c f7001a;
        final /* synthetic */ int b = 2;

        AnonymousClass4(com.anythink.expressad.foundation.d.c cVar) {
            this.f7001a = cVar;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            o.a(a.f6994a, "giturl 下载成功： ".concat(String.valueOf(str)));
            if (a.this.C != null) {
                a.this.C.post(new Runnable() { // from class: com.anythink.expressad.advanced.c.a.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.a(AnonymousClass4.this.f7001a, AnonymousClass4.this.b);
                    }
                });
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
            o.a(a.f6994a, "gifurl 下载失败： ".concat(String.valueOf(str2)));
            if (a.this.C != null) {
                a.this.C.post(new Runnable() { // from class: com.anythink.expressad.advanced.c.a.4.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.a(AnonymousClass4.this.f7001a, AnonymousClass4.this.b);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.advanced.c.a$5  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/c/a$5.class */
    public final class AnonymousClass5 implements i.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.anythink.expressad.foundation.d.c f7005a;
        final /* synthetic */ int b = 2;

        AnonymousClass5(com.anythink.expressad.foundation.d.c cVar) {
            this.f7005a = cVar;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str) {
            o.a(a.f6994a, "endcard 下载成功： ".concat(String.valueOf(str)));
            if (a.this.C != null) {
                Message obtain = Message.obtain();
                obtain.what = 4;
                obtain.obj = this.f7005a;
                obtain.arg1 = this.b;
                a.this.C.sendMessage(obtain);
            }
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str, String str2) {
            o.a(a.f6994a, "endcard 下载失败： ".concat(String.valueOf(str2)));
            if (a.this.g != null) {
                a.this.g.setEndCardReady(false);
            }
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = str;
            a.this.C.sendMessage(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.advanced.c.a$6  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/c/a$6.class */
    public final class AnonymousClass6 implements com.anythink.expressad.foundation.g.d.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.anythink.expressad.foundation.d.c f7007a;
        final /* synthetic */ int b = 2;

        AnonymousClass6(com.anythink.expressad.foundation.d.c cVar) {
            this.f7007a = cVar;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(Bitmap bitmap, String str) {
            o.a(a.f6994a, "image 下载成功： ".concat(String.valueOf(str)));
            if (a.this.C != null) {
                a.this.C.post(new Runnable() { // from class: com.anythink.expressad.advanced.c.a.6.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.a(AnonymousClass6.this.f7007a, AnonymousClass6.this.b);
                    }
                });
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(String str, String str2) {
            o.a(a.f6994a, "image 下载失败： ".concat(String.valueOf(str2)));
            if (a.this.C != null) {
                a.this.C.post(new Runnable() { // from class: com.anythink.expressad.advanced.c.a.6.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.a(AnonymousClass6.this.f7007a, AnonymousClass6.this.b);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.advanced.c.a$7  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/c/a$7.class */
    public final class AnonymousClass7 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.anythink.expressad.foundation.d.c f7011a;
        final /* synthetic */ int b = 2;

        AnonymousClass7(com.anythink.expressad.foundation.d.c cVar) {
            this.f7011a = cVar;
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
                        File file3 = new File(this.f7011a.d());
                        File file4 = file3;
                        try {
                            if (!file3.exists()) {
                                String b = d.b(com.anythink.expressad.foundation.g.c.a.ANYTHINK_700_HTML);
                                String a2 = p.a(x.a(this.f7011a.d()));
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
                                            sb.append(this.f7011a.d());
                                            fileOutputStream4.write(sb.toString().getBytes());
                                            fileOutputStream4.flush();
                                        } catch (Exception e) {
                                            fileOutputStream = fileOutputStream4;
                                            e = e;
                                            e.printStackTrace();
                                            FileOutputStream fileOutputStream5 = fileOutputStream;
                                            this.f7011a.j("");
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            file2 = file;
                                            if (!file2.exists()) {
                                            }
                                            o.a(a.f6994a, "渲染 HTML 失败： html file write failed");
                                            a aVar = a.this;
                                            String unused = a.this.s;
                                            aVar.b("html file write failed", this.b);
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
                        this.f7011a.b(file2.getAbsolutePath());
                        o.a(a.f6994a, "开始渲染 HTML： ");
                        final File file5 = file2;
                        n.a().a(new Runnable() { // from class: com.anythink.expressad.advanced.c.a.7.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                a aVar2 = a.this;
                                a.a(aVar2, "file:////" + file5.getAbsolutePath(), AnonymousClass7.this.f7011a, AnonymousClass7.this.b);
                            }
                        });
                        return;
                    }
                    o.a(a.f6994a, "渲染 HTML 失败： html file write failed");
                    a aVar2 = a.this;
                    String unused2 = a.this.s;
                    aVar2.b("html file write failed", this.b);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e5) {
                a aVar3 = a.this;
                String message = e5.getMessage();
                String unused3 = a.this.s;
                aVar3.b(message, this.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.advanced.c.a$8  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/c/a$8.class */
    public final class AnonymousClass8 implements i.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.anythink.expressad.foundation.d.c f7014a;
        final /* synthetic */ int b = 2;

        AnonymousClass8(com.anythink.expressad.foundation.d.c cVar) {
            this.f7014a = cVar;
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str) {
            o.a(a.f6994a, "zip 下载成功： ".concat(String.valueOf(str)));
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = this.f7014a;
            obtain.arg1 = this.b;
            a.this.C.sendMessage(obtain);
        }

        @Override // com.anythink.expressad.videocommon.b.i.a
        public final void a(String str, String str2) {
            String str3 = a.f6994a;
            o.a(str3, "zip 下载失败： " + str2 + " " + str);
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = str;
            a.this.C.sendMessage(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.expressad.advanced.c.a$9  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/c/a$9.class */
    public final class AnonymousClass9 extends com.anythink.expressad.atsignalcommon.a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.anythink.expressad.foundation.d.c f7016a;
        final /* synthetic */ int b;

        AnonymousClass9(com.anythink.expressad.foundation.d.c cVar, int i) {
            this.f7016a = cVar;
            this.b = i;
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            o.d("NativeAdvancedLoadManager", "onPageFinished");
            if (!this.f7016a.s()) {
                a.this.g.setH5Ready(true);
                o.d("NativeAdvancedLoadManager", "=======onPageFinished OK");
                com.anythink.expressad.advanced.a.a.a(this.f7016a.Z());
                a.b(a.this, this.f7016a, this.b);
            }
            NativeAdvancedJsUtils.fireOnJSBridgeConnected(webView);
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            o.d("NativeAdvancedLoadManager", "onReceivedError： " + i + "  " + str + "  " + str2);
            a.this.b(str, this.b);
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            o.d("NativeAdvancedLoadManager", "onReceivedSslError: " + sslError.getPrimaryError());
            a aVar = a.this;
            aVar.b("onReceivedSslError:" + sslError.getUrl(), this.b);
        }

        @Override // com.anythink.expressad.atsignalcommon.a.b, com.anythink.expressad.atsignalcommon.windvane.e
        public final void readyState(WebView webView, int i) {
            super.readyState(webView, i);
            o.d("NativeAdvancedLoadManager", "=========readyState: ".concat(String.valueOf(i)));
            if (i != 1) {
                a.this.b("readyState 2", this.b);
                return;
            }
            a.this.g.setH5Ready(true);
            com.anythink.expressad.advanced.a.a.a(this.f7016a.Z());
            a.b(a.this, this.f7016a, this.b);
        }
    }

    public a(String str, String str2) {
        this.f6995c = str;
        this.b = str2;
    }

    private void a(long j2) {
        this.C.postDelayed(this.D, j2);
    }

    static /* synthetic */ void a(a aVar, String str, com.anythink.expressad.foundation.d.c cVar, int i) {
        ATNativeAdvancedView aTNativeAdvancedView = aVar.g;
        if (aTNativeAdvancedView == null || aTNativeAdvancedView.getAdvancedNativeWebview() == null) {
            return;
        }
        NativeAdvancedJSBridgeImpl nativeAdvancedJSBridgeImpl = new NativeAdvancedJSBridgeImpl(aVar.g.getContext(), aVar.f6995c, aVar.b);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        nativeAdvancedJSBridgeImpl.setCampaignList(arrayList);
        nativeAdvancedJSBridgeImpl.setAllowSkip(aVar.o);
        nativeAdvancedJSBridgeImpl.setCountdownS(aVar.p);
        aVar.g.setAdvancedNativeJSBridgeImpl(nativeAdvancedJSBridgeImpl);
        System.currentTimeMillis();
        ATNativeAdvancedWebview advancedNativeWebview = aVar.g.getAdvancedNativeWebview();
        if (advancedNativeWebview == null) {
            aVar.b("webview is null", i);
        } else if (advancedNativeWebview != null && advancedNativeWebview.isDestroyed()) {
            aVar.b("webview is destroyed", i);
        } else {
            advancedNativeWebview.setWebViewListener(new AnonymousClass9(cVar, i));
            if (advancedNativeWebview.isDestroyed()) {
                aVar.b("webview has destory", i);
                return;
            }
            o.d(f6994a, "=======开始渲染: ".concat(String.valueOf(str)));
            Handler handler = aVar.C;
            if (handler != null) {
                handler.post(new AnonymousClass10(advancedNativeWebview, str));
            }
        }
    }

    private void a(com.anythink.expressad.foundation.d.c cVar) {
        this.i = cVar;
        if (c.a(this.g, cVar)) {
            a(cVar, 2);
            return;
        }
        ATNativeAdvancedView aTNativeAdvancedView = this.g;
        if (aTNativeAdvancedView != null) {
            aTNativeAdvancedView.clearResState();
        }
        if (!TextUtils.isEmpty(cVar.c())) {
            String str = f6994a;
            o.a(str, "开始下载zip： " + cVar.c());
            this.x = new AnonymousClass8(cVar);
            i.a().b(cVar.c(), (i.a) this.x);
        }
        if (!TextUtils.isEmpty(cVar.d())) {
            String str2 = f6994a;
            o.a(str2, "开始下载HTML： " + cVar.d());
            com.anythink.core.common.k.b.a.a().a(new AnonymousClass7(cVar));
        }
        if (!TextUtils.isEmpty(cVar.S())) {
            String str3 = f6994a;
            o.a(str3, "开始下载Video： " + cVar.S());
            this.w = new AnonymousClass2(cVar);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            e.a().a(this.b, arrayList, 298, this.w);
            if (e.a().a(298, this.b, cVar.A())) {
                o.a(f6994a, " load Video isReady true");
                this.g.setVideoReady(true);
                a(cVar, 2);
            } else {
                o.a(f6994a, " load Video");
                e.a().d(this.b);
            }
        }
        if (!TextUtils.isEmpty(cVar.be())) {
            String str4 = f6994a;
            o.a(str4, "开始下载image： " + cVar.be());
            com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar.be(), new AnonymousClass6(cVar));
        }
        if (!TextUtils.isEmpty(cVar.I())) {
            String str5 = f6994a;
            o.a(str5, "开始下载EndCard： " + cVar.I());
            this.y = new AnonymousClass5(cVar);
            i.a().b(cVar.I(), (i.a) this.y);
        }
        if (TextUtils.isEmpty(cVar.y())) {
            return;
        }
        String str6 = f6994a;
        o.a(str6, "开始下载gitUrl： " + cVar.y());
        com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar.y(), new AnonymousClass4(cVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.anythink.expressad.foundation.d.c cVar, int i) {
        if (!c.a(this.g, cVar) || this.v) {
            return;
        }
        i();
        this.v = true;
        com.anythink.expressad.advanced.b.a aVar = this.e;
        if (aVar != null) {
            aVar.a(cVar, i);
        }
    }

    private void a(String str, int i) {
        b(str, i);
    }

    private void a(String str, com.anythink.expressad.foundation.d.c cVar, int i) {
        ATNativeAdvancedView aTNativeAdvancedView = this.g;
        if (aTNativeAdvancedView == null || aTNativeAdvancedView.getAdvancedNativeWebview() == null) {
            return;
        }
        NativeAdvancedJSBridgeImpl nativeAdvancedJSBridgeImpl = new NativeAdvancedJSBridgeImpl(this.g.getContext(), this.f6995c, this.b);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        nativeAdvancedJSBridgeImpl.setCampaignList(arrayList);
        nativeAdvancedJSBridgeImpl.setAllowSkip(this.o);
        nativeAdvancedJSBridgeImpl.setCountdownS(this.p);
        this.g.setAdvancedNativeJSBridgeImpl(nativeAdvancedJSBridgeImpl);
        System.currentTimeMillis();
        ATNativeAdvancedWebview advancedNativeWebview = this.g.getAdvancedNativeWebview();
        if (advancedNativeWebview == null) {
            b("webview is null", i);
        } else if (advancedNativeWebview != null && advancedNativeWebview.isDestroyed()) {
            b("webview is destroyed", i);
        } else {
            advancedNativeWebview.setWebViewListener(new AnonymousClass9(cVar, i));
            if (advancedNativeWebview.isDestroyed()) {
                b("webview has destory", i);
                return;
            }
            o.d(f6994a, "=======开始渲染: ".concat(String.valueOf(str)));
            Handler handler = this.C;
            if (handler != null) {
                handler.post(new AnonymousClass10(advancedNativeWebview, str));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0052, code lost:
        if (android.text.TextUtils.isEmpty(r0.d()) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.List<com.anythink.expressad.foundation.d.c> b(com.anythink.expressad.foundation.d.d r5) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.advanced.c.a.b(com.anythink.expressad.foundation.d.d):java.util.List");
    }

    private void b(int i) {
        this.p = i;
    }

    static /* synthetic */ void b(a aVar, com.anythink.expressad.foundation.d.c cVar, int i) {
        if (aVar.g.isH5Ready()) {
            aVar.a(cVar, i);
        }
    }

    private void b(com.anythink.expressad.foundation.d.c cVar) {
        ATNativeAdvancedView aTNativeAdvancedView = this.g;
        if (aTNativeAdvancedView != null) {
            aTNativeAdvancedView.clearResState();
        }
        if (!TextUtils.isEmpty(cVar.c())) {
            String str = f6994a;
            o.a(str, "开始下载zip： " + cVar.c());
            this.x = new AnonymousClass8(cVar);
            i.a().b(cVar.c(), (i.a) this.x);
        }
        if (!TextUtils.isEmpty(cVar.d())) {
            String str2 = f6994a;
            o.a(str2, "开始下载HTML： " + cVar.d());
            com.anythink.core.common.k.b.a.a().a(new AnonymousClass7(cVar));
        }
        if (!TextUtils.isEmpty(cVar.S())) {
            String str3 = f6994a;
            o.a(str3, "开始下载Video： " + cVar.S());
            this.w = new AnonymousClass2(cVar);
            ArrayList arrayList = new ArrayList();
            arrayList.add(cVar);
            e.a().a(this.b, arrayList, 298, this.w);
            if (e.a().a(298, this.b, cVar.A())) {
                o.a(f6994a, " load Video isReady true");
                this.g.setVideoReady(true);
                a(cVar, 2);
            } else {
                o.a(f6994a, " load Video");
                e.a().d(this.b);
            }
        }
        if (!TextUtils.isEmpty(cVar.be())) {
            String str4 = f6994a;
            o.a(str4, "开始下载image： " + cVar.be());
            com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar.be(), new AnonymousClass6(cVar));
        }
        if (!TextUtils.isEmpty(cVar.I())) {
            String str5 = f6994a;
            o.a(str5, "开始下载EndCard： " + cVar.I());
            this.y = new AnonymousClass5(cVar);
            i.a().b(cVar.I(), (i.a) this.y);
        }
        if (TextUtils.isEmpty(cVar.y())) {
            return;
        }
        String str6 = f6994a;
        o.a(str6, "开始下载gitUrl： " + cVar.y());
        com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar.y(), new AnonymousClass4(cVar));
    }

    private void b(com.anythink.expressad.foundation.d.c cVar, int i) {
        if (this.g.isH5Ready()) {
            a(cVar, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i) {
        if (this.v) {
            return;
        }
        i();
        o.d(f6994a, "real failed: ".concat(String.valueOf(str)));
        this.v = true;
        com.anythink.expressad.advanced.b.a aVar = this.e;
        if (aVar != null) {
            aVar.a(str, i);
        }
    }

    private void c(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar.y(), new AnonymousClass4(cVar));
    }

    private void c(String str, int i) {
        b(str, i);
    }

    private void d(com.anythink.expressad.foundation.d.c cVar) {
        this.y = new AnonymousClass5(cVar);
        i.a().b(cVar.I(), (i.a) this.y);
    }

    private int e() {
        return this.p;
    }

    private void e(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.expressad.foundation.g.d.b.a(n.a().g()).a(cVar.be(), new AnonymousClass6(cVar));
    }

    private void f() {
        try {
            int i = this.A + 1;
            this.A = i;
            if (this.h == null || i > this.h.t()) {
                o.b(f6994a, "onload 重置offset为0");
                this.A = 0;
            }
            String str = f6994a;
            o.b(str, "onload 算出 下次的offset是:" + this.A);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void f(com.anythink.expressad.foundation.d.c cVar) {
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass7(cVar));
    }

    private static void g() {
    }

    private void g(com.anythink.expressad.foundation.d.c cVar) {
        this.x = new AnonymousClass8(cVar);
        i.a().b(cVar.c(), (i.a) this.x);
    }

    private void h() {
        this.A = 0;
    }

    private void h(com.anythink.expressad.foundation.d.c cVar) {
        this.w = new AnonymousClass2(cVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cVar);
        e.a().a(this.b, arrayList, 298, this.w);
        if (!e.a().a(298, this.b, cVar.A())) {
            o.a(f6994a, " load Video");
            e.a().d(this.b);
            return;
        }
        o.a(f6994a, " load Video isReady true");
        this.g.setVideoReady(true);
        a(cVar, 2);
    }

    private void i() {
        this.C.removeCallbacks(this.D);
    }

    private static void j() {
    }

    public final String a() {
        return this.B;
    }

    public final String a(String str) {
        String str2;
        if (this.i != null) {
            try {
                com.anythink.expressad.videocommon.b.c a2 = e.a().a(this.b, this.i.aZ() + this.i.S() + this.i.B());
                str2 = str;
                if (a2 != null) {
                    int k2 = a2.k();
                    str2 = str;
                    if (k2 == 5) {
                        String e = a2.e();
                        str2 = str;
                        if (new File(e).exists()) {
                            String str3 = f6994a;
                            o.d(str3, "本地已下载完 拿本地播放地址：" + e + " state：" + k2);
                            return e;
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return str;
            }
        } else {
            str2 = "";
        }
        return str2;
    }

    public final void a(int i) {
        this.o = i;
    }

    public final void a(int i, int i2) {
        this.r = i;
        this.q = i2;
    }

    public final void a(com.anythink.expressad.advanced.b.a aVar) {
        this.e = aVar;
    }

    public final void a(ATNativeAdvancedView aTNativeAdvancedView) {
        this.g = aTNativeAdvancedView;
    }

    public final void a(com.anythink.expressad.d.c cVar) {
        this.h = cVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0052, code lost:
        if (android.text.TextUtils.isEmpty(r0.d()) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.anythink.expressad.foundation.d.d r8) {
        /*
            Method dump skipped, instructions count: 997
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.advanced.c.a.a(com.anythink.expressad.foundation.d.d):void");
    }

    public final void b() {
        if (this.e != null) {
            this.e = null;
        }
        b("LoadManager release", this.t);
        if (this.w != null) {
            this.w = null;
        }
        if (this.x != null) {
            this.x = null;
        }
    }

    public final com.anythink.expressad.foundation.d.c c() {
        return this.i;
    }
}
