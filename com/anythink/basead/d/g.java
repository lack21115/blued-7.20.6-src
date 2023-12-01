package com.anythink.basead.d;

import android.content.Context;
import android.view.ViewGroup;
import com.anythink.basead.d.b;
import com.anythink.basead.ui.AsseblemSplashAdView;
import com.anythink.basead.ui.BaseSdkSplashAdView;
import com.anythink.basead.ui.BaseSplashAdView;
import com.anythink.basead.ui.MraidSplashAdView;
import com.anythink.basead.ui.SinglePictureSplashAdView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.u;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/g.class */
public final class g extends b {

    /* renamed from: a  reason: collision with root package name */
    BaseSplashAdView f5966a;
    boolean k;

    public g(Context context, b.a aVar, j jVar) {
        super(context, aVar, jVar);
    }

    public final void a() {
        this.k = true;
    }

    public final void a(final ViewGroup viewGroup) {
        if (super.c()) {
            u.a(false);
            n.a().a(new Runnable() { // from class: com.anythink.basead.d.g.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (g.this.f instanceof com.anythink.expressad.splash.d.c) {
                        ((com.anythink.expressad.splash.d.c) g.this.f).a(new com.anythink.expressad.out.e() { // from class: com.anythink.basead.d.g.1.1
                            @Override // com.anythink.expressad.out.e
                            public final void a() {
                                if (g.this.h != null) {
                                    g.this.h.onAdShow();
                                }
                            }

                            @Override // com.anythink.expressad.out.e
                            public final void a(com.anythink.expressad.foundation.d.c cVar) {
                                if (g.this.g != null) {
                                    com.anythink.basead.d.a.b.a(g.this.g.b(), cVar);
                                    com.anythink.basead.c.i iVar = new com.anythink.basead.c.i(g.this.f5937c.d, "");
                                    iVar.g = new com.anythink.basead.c.a();
                                    g.this.g.a(iVar);
                                }
                            }

                            @Override // com.anythink.expressad.out.e
                            public final void a(String str) {
                                if (g.this.h != null) {
                                    g.this.h.onShowFailed(com.anythink.basead.c.f.a(com.anythink.basead.c.f.k, str));
                                }
                            }

                            @Override // com.anythink.expressad.out.e
                            public final void b() {
                                if (g.this.h != null) {
                                    g.this.h.onAdClosed();
                                }
                            }

                            @Override // com.anythink.expressad.out.e
                            public final void c() {
                            }

                            @Override // com.anythink.expressad.out.e
                            public final void d() {
                            }

                            @Override // com.anythink.expressad.out.e
                            public final void e() {
                            }
                        });
                        ((com.anythink.expressad.splash.d.c) g.this.f).a(viewGroup);
                        return;
                    }
                    if (g.this.e.g()) {
                        g.this.f5966a = new MraidSplashAdView(viewGroup.getContext(), g.this.f5937c, g.this.e, g.this.h);
                    } else if (BaseSdkSplashAdView.isSinglePicture(g.this.e, g.this.f5937c.m)) {
                        g.this.f5966a = new SinglePictureSplashAdView(viewGroup.getContext(), g.this.f5937c, g.this.e, g.this.h);
                    } else {
                        g.this.f5966a = new AsseblemSplashAdView(viewGroup.getContext(), g.this.f5937c, g.this.e, g.this.h);
                    }
                    g.this.f5966a.setDontCountDown(g.this.k);
                    viewGroup.addView(g.this.f5966a);
                }
            });
        }
    }

    @Override // com.anythink.basead.d.b
    public final void b() {
        BaseSplashAdView baseSplashAdView = this.f5966a;
        if (baseSplashAdView != null) {
            baseSplashAdView.destroy();
            this.f5966a = null;
        }
        if (this.f == null || !(this.f instanceof com.anythink.expressad.splash.d.c)) {
            return;
        }
        ((com.anythink.expressad.splash.d.c) this.f).g();
    }

    public final boolean e() {
        return this.f == null;
    }
}
