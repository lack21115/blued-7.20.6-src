package com.anythink.basead.d;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.d.b;
import com.anythink.basead.e.b;
import com.anythink.basead.ui.BaseAdActivity;
import com.anythink.core.common.e.j;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/d.class */
public class d extends b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5957a = d.class.getSimpleName();

    public d(Context context, b.a aVar, j jVar) {
        super(context, aVar, jVar);
    }

    public final void a(Activity activity, Map<String, Object> map) {
        try {
            if (!c()) {
                if (this.h != null) {
                    this.h.onShowFailed(com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, com.anythink.basead.c.f.x));
                }
                this.e = null;
                return;
            }
            final String obj = map.get("extra_scenario").toString();
            int intValue = ((Integer) map.get(com.anythink.basead.f.c.j)).intValue();
            final String a2 = a(this.e);
            if (this.f instanceof com.anythink.expressad.reward.b.a) {
                ((com.anythink.expressad.reward.b.a) this.f).a(new com.anythink.expressad.videocommon.d.a() { // from class: com.anythink.basead.d.d.1
                    @Override // com.anythink.expressad.videocommon.d.a
                    public final void a() {
                    }

                    @Override // com.anythink.expressad.videocommon.d.a
                    public final void a(final com.anythink.expressad.foundation.d.c cVar) {
                        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.basead.d.d.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                d.this.a(cVar, obj);
                            }
                        });
                    }

                    @Override // com.anythink.expressad.videocommon.d.a
                    public final void a(String str) {
                    }

                    @Override // com.anythink.expressad.videocommon.d.a
                    public final void a(boolean z, String str, float f) {
                        if (d.this.h != null) {
                            d.this.h.onAdClosed();
                        }
                        if (d.this.g != null) {
                            d.this.g.d();
                        }
                    }

                    @Override // com.anythink.expressad.videocommon.d.a
                    public final void b() {
                    }

                    @Override // com.anythink.expressad.videocommon.d.a
                    public final void b(String str) {
                        if (d.this.h != null) {
                            d.this.h.onShowFailed(com.anythink.basead.c.f.a(com.anythink.basead.c.f.k, str));
                        }
                        d.this.e = null;
                    }

                    @Override // com.anythink.expressad.videocommon.d.a
                    public final void c() {
                        if (d.this.h != null) {
                            d.this.h.onAdShow();
                        }
                        d.this.e = null;
                    }

                    @Override // com.anythink.expressad.videocommon.d.a
                    public final void d() {
                        if (d.this.h == null || !(d.this.h instanceof com.anythink.basead.e.g)) {
                            return;
                        }
                        ((com.anythink.basead.e.g) d.this.h).onVideoAdPlayEnd();
                    }

                    @Override // com.anythink.expressad.videocommon.d.a
                    public final void e() {
                    }

                    @Override // com.anythink.expressad.videocommon.d.a
                    public final void f() {
                    }
                });
                ((com.anythink.expressad.reward.b.a) this.f).a(activity, "", "", "", this.f5937c);
                return;
            }
            com.anythink.basead.e.b.a().a(a2, new b.InterfaceC0079b() { // from class: com.anythink.basead.d.d.2
                @Override // com.anythink.basead.e.b.InterfaceC0079b
                public final void a() {
                    if (d.this.h != null) {
                        d.this.h.onAdShow();
                    }
                    d.this.e = null;
                }

                @Override // com.anythink.basead.e.b.InterfaceC0079b
                public final void a(int i) {
                    String str = d.f5957a;
                    if (d.this.h != null) {
                        d.this.h.onAdClick(i);
                    }
                }

                @Override // com.anythink.basead.e.b.InterfaceC0079b
                public final void a(com.anythink.basead.c.e eVar) {
                    if (d.this.h != null) {
                        d.this.h.onShowFailed(eVar);
                    }
                    d.this.e = null;
                }

                @Override // com.anythink.basead.e.b.InterfaceC0079b
                public final void a(boolean z) {
                    String str = d.f5957a;
                    if (d.this.h != null) {
                        d.this.h.onDeeplinkCallback(z);
                    }
                }

                @Override // com.anythink.basead.e.b.InterfaceC0079b
                public final void b() {
                    if (d.this.h == null || !(d.this.h instanceof com.anythink.basead.e.g)) {
                        return;
                    }
                    ((com.anythink.basead.e.g) d.this.h).onVideoAdPlayStart();
                }

                @Override // com.anythink.basead.e.b.InterfaceC0079b
                public final void c() {
                    if (d.this.h == null || !(d.this.h instanceof com.anythink.basead.e.g)) {
                        return;
                    }
                    ((com.anythink.basead.e.g) d.this.h).onVideoAdPlayEnd();
                }

                @Override // com.anythink.basead.e.b.InterfaceC0079b
                public final void d() {
                }

                @Override // com.anythink.basead.e.b.InterfaceC0079b
                public final void e() {
                    String str = d.f5957a;
                    if (d.this.h != null) {
                        d.this.h.onAdClosed();
                    }
                    com.anythink.basead.e.b.a().b(a2);
                }
            });
            com.anythink.core.basead.b.a aVar = new com.anythink.core.basead.b.a();
            aVar.f6395c = this.e;
            aVar.d = a2;
            aVar.f6394a = 3;
            aVar.h = this.f5937c;
            aVar.e = intValue;
            aVar.b = obj;
            BaseAdActivity.a(activity, aVar);
        } catch (Exception e) {
            e.printStackTrace();
            if (this.h != null) {
                this.h.onShowFailed(com.anythink.basead.c.f.a("-9999", e.getMessage()));
            }
            this.e = null;
        }
    }

    @Override // com.anythink.basead.d.b
    public final void b() {
        super.b();
        this.h = null;
    }
}
