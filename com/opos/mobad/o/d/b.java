package com.opos.mobad.o.d;

import android.content.Context;
import android.net.http.SslError;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.widget.RelativeLayout;
import com.opos.cmn.biz.web.b.a.b;
import com.opos.mobad.o.d.e;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/d/b.class */
public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.cmn.biz.web.b.a.a f13406a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private e.b f13407c;

    public b(Context context, e.b bVar) {
        Context a2 = com.opos.mobad.service.b.a(context);
        this.b = a2;
        this.f13407c = bVar;
        this.f13406a = new com.opos.cmn.biz.web.b.a.a(a2, new b.a().a((com.opos.cmn.biz.web.b.a.a.b) null).a((Map<String, Object>) null).a(false).a(new com.opos.cmn.biz.web.b.a.a.a() { // from class: com.opos.mobad.o.d.b.1
            @Override // com.opos.cmn.biz.web.b.a.a.a
            public void a(final SslErrorHandler sslErrorHandler, SslError sslError) {
                com.opos.cmn.an.f.a.b("privacyTool", "onReceivedSslError");
                try {
                    com.opos.cmn.e.a.b.b.c cVar = new com.opos.cmn.e.a.b.b.c(b.this.b, 0.1f);
                    final View b = cVar.b();
                    cVar.a((CharSequence) "SSL证书验证错误，是否继续？");
                    cVar.b("取消");
                    cVar.a("继续");
                    cVar.a(new com.opos.cmn.e.a.b.c.a() { // from class: com.opos.mobad.o.d.b.1.1
                        @Override // com.opos.cmn.e.a.b.c.a
                        public void a(View view, int[] iArr) {
                            ViewGroup viewGroup;
                            sslErrorHandler.cancel();
                            View b2 = b.this.f13406a.b();
                            if (b2 != null && (viewGroup = (ViewGroup) b2.getParent()) != null && viewGroup.indexOfChild(b) > 0) {
                                viewGroup.removeView(b);
                            }
                            if (b.this.f13407c != null) {
                                b.this.f13407c.a();
                            }
                        }

                        @Override // com.opos.cmn.e.a.b.c.a
                        public void b(View view, int[] iArr) {
                            ViewGroup viewGroup;
                            sslErrorHandler.proceed();
                            View b2 = b.this.f13406a.b();
                            if (b2 == null || (viewGroup = (ViewGroup) b2.getParent()) == null || viewGroup.indexOfChild(b) <= 0) {
                                return;
                            }
                            viewGroup.removeView(b);
                        }
                    });
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13);
                    ((ViewGroup) b.this.f13406a.b().getParent()).addView(b, layoutParams);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("ComplianceWebView", "", e);
                }
            }
        }).a());
    }

    @Override // com.opos.mobad.o.d.d
    public int a() {
        return 0;
    }

    @Override // com.opos.mobad.o.d.d
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f13406a.a(str);
    }

    @Override // com.opos.mobad.o.d.d
    public void a(Map<String, String> map) {
    }

    @Override // com.opos.mobad.o.d.d
    public View b() {
        return this.f13406a.b();
    }

    @Override // com.opos.mobad.o.d.d
    public void c() {
        this.f13406a.a();
    }
}
