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
    BaseBannerAdView a;
    private final String k;
    private com.anythink.expressad.out.h l;

    public a(Context context, b.a aVar, j jVar) {
        super(context, aVar, jVar);
        this.k = getClass().getSimpleName();
        this.l = new com.anythink.expressad.out.h() { // from class: com.anythink.basead.d.a.1
            public final void a() {
            }

            public final void a(final com.anythink.expressad.foundation.d.c cVar) {
                com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.basead.d.a.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.a(cVar, "");
                    }
                });
            }

            public final void a(String str) {
            }

            public final void b() {
                if (a.this.h != null) {
                    a.this.h.onAdShow();
                }
            }

            public final void c() {
            }

            public final void d() {
            }

            public final void e() {
            }

            public final void f() {
                if (a.this.h != null) {
                    a.this.h.onAdClosed();
                }
            }
        };
    }

    public final View a() {
        if ((this.f instanceof TemplateBannerView) && this.f != null) {
            this.f.setBannerAdListener(this.l);
            return this.f;
        }
        if (this.a == null && super.c()) {
            if (this.e.g()) {
                this.a = new MraidBannerAdView(this.b, this.c, this.e, this.h);
            } else {
                this.a = new SdkBannerAdView(this.b, this.c, this.e, this.h);
            }
        }
        return this.a;
    }

    @Override // com.anythink.basead.d.b
    public final void b() {
        super.b();
        if (this.f instanceof TemplateBannerView) {
            this.f.release();
        }
        this.f = null;
        this.h = null;
    }
}
