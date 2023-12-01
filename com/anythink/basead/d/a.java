package com.anythink.basead.d;

import android.content.Context;
import android.view.View;
import com.anythink.basead.d.b;
import com.anythink.basead.ui.BaseBannerAdView;
import com.anythink.basead.ui.MraidBannerAdView;
import com.anythink.basead.ui.SdkBannerAdView;
import com.anythink.core.common.e.j;
import com.anythink.expressad.out.TemplateBannerView;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/a.class */
public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    BaseBannerAdView f5913a;
    private final String k;
    private com.anythink.expressad.out.h l;

    public a(Context context, b.a aVar, j jVar) {
        super(context, aVar, jVar);
        this.k = getClass().getSimpleName();
        this.l = new com.anythink.expressad.out.h() { // from class: com.anythink.basead.d.a.1
            @Override // com.anythink.expressad.out.h
            public final void a() {
            }

            @Override // com.anythink.expressad.out.h
            public final void a(final com.anythink.expressad.foundation.d.c cVar) {
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.basead.d.a.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.a(cVar, "");
                    }
                });
            }

            @Override // com.anythink.expressad.out.h
            public final void a(String str) {
            }

            @Override // com.anythink.expressad.out.h
            public final void b() {
                if (a.this.h != null) {
                    a.this.h.onAdShow();
                }
            }

            @Override // com.anythink.expressad.out.h
            public final void c() {
            }

            @Override // com.anythink.expressad.out.h
            public final void d() {
            }

            @Override // com.anythink.expressad.out.h
            public final void e() {
            }

            @Override // com.anythink.expressad.out.h
            public final void f() {
                if (a.this.h != null) {
                    a.this.h.onAdClosed();
                }
            }
        };
    }

    public final View a() {
        if ((this.f instanceof TemplateBannerView) && this.f != null) {
            ((TemplateBannerView) this.f).setBannerAdListener(this.l);
            return (TemplateBannerView) this.f;
        }
        if (this.f5913a == null && super.c()) {
            if (this.e.g()) {
                this.f5913a = new MraidBannerAdView(this.b, this.f5937c, this.e, this.h);
            } else {
                this.f5913a = new SdkBannerAdView(this.b, this.f5937c, this.e, this.h);
            }
        }
        return this.f5913a;
    }

    @Override // com.anythink.basead.d.b
    public final void b() {
        super.b();
        if (this.f instanceof TemplateBannerView) {
            ((TemplateBannerView) this.f).release();
        }
        this.f = null;
        this.h = null;
    }
}
