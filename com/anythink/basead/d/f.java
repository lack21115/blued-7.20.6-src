package com.anythink.basead.d;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.d.b;
import com.anythink.basead.e.b;
import com.anythink.basead.ui.BaseAdActivity;
import com.anythink.core.common.e.j;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/f.class */
public class f extends b {
    public static final String a = f.class.getSimpleName();

    public f(Context context, b.a aVar, j jVar) {
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
                this.f.a(new com.anythink.expressad.videocommon.d.a() { // from class: com.anythink.basead.d.f.1
                    public final void a() {
                    }

                    public final void a(final com.anythink.expressad.foundation.d.c cVar) {
                        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.basead.d.f.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                f.this.a(cVar, obj);
                            }
                        });
                    }

                    public final void a(String str) {
                    }

                    public final void a(boolean z, String str, float f) {
                        if (z && f.this.h != null && (f.this.h instanceof com.anythink.basead.e.g)) {
                            ((com.anythink.basead.e.g) f.this.h).onRewarded();
                        }
                        if (f.this.h != null) {
                            f.this.h.onAdClosed();
                        }
                        if (f.this.g != null) {
                            f.this.g.d();
                        }
                    }

                    public final void b() {
                    }

                    public final void b(String str) {
                        if (f.this.h != null) {
                            f.this.h.onShowFailed(com.anythink.basead.c.f.a(com.anythink.basead.c.f.k, str));
                        }
                        f.this.e = null;
                    }

                    public final void c() {
                        if (f.this.h != null) {
                            f.this.h.onAdShow();
                        }
                        if (f.this.h != null && (f.this.h instanceof com.anythink.basead.e.g)) {
                            ((com.anythink.basead.e.g) f.this.h).onVideoAdPlayStart();
                        }
                        f.this.e = null;
                    }

                    public final void d() {
                        if (f.this.h == null || !(f.this.h instanceof com.anythink.basead.e.g)) {
                            return;
                        }
                        ((com.anythink.basead.e.g) f.this.h).onVideoAdPlayEnd();
                    }

                    public final void e() {
                    }

                    public final void f() {
                    }
                });
                this.f.a(activity, "", "", "", this.c);
                return;
            }
            com.anythink.basead.e.b.a().a(a2, new b.InterfaceC0039b() { // from class: com.anythink.basead.d.f.2
                @Override // com.anythink.basead.e.b.InterfaceC0039b
                public final void a() {
                    if (f.this.h != null) {
                        f.this.h.onAdShow();
                    }
                    f.this.e = null;
                }

                @Override // com.anythink.basead.e.b.InterfaceC0039b
                public final void a(int i) {
                    String str = f.a;
                    if (f.this.h != null) {
                        f.this.h.onAdClick(i);
                    }
                }

                @Override // com.anythink.basead.e.b.InterfaceC0039b
                public final void a(com.anythink.basead.c.e eVar) {
                    if (f.this.h != null) {
                        f.this.h.onShowFailed(eVar);
                    }
                    f.this.e = null;
                }

                @Override // com.anythink.basead.e.b.InterfaceC0039b
                public final void a(boolean z) {
                    String str = f.a;
                    if (f.this.h != null) {
                        f.this.h.onDeeplinkCallback(z);
                    }
                }

                @Override // com.anythink.basead.e.b.InterfaceC0039b
                public final void b() {
                    if (f.this.h == null || !(f.this.h instanceof com.anythink.basead.e.g)) {
                        return;
                    }
                    ((com.anythink.basead.e.g) f.this.h).onVideoAdPlayStart();
                }

                @Override // com.anythink.basead.e.b.InterfaceC0039b
                public final void c() {
                    if (f.this.h == null || !(f.this.h instanceof com.anythink.basead.e.g)) {
                        return;
                    }
                    ((com.anythink.basead.e.g) f.this.h).onVideoAdPlayEnd();
                }

                @Override // com.anythink.basead.e.b.InterfaceC0039b
                public final void d() {
                    if (f.this.h == null || !(f.this.h instanceof com.anythink.basead.e.g)) {
                        return;
                    }
                    ((com.anythink.basead.e.g) f.this.h).onRewarded();
                }

                @Override // com.anythink.basead.e.b.InterfaceC0039b
                public final void e() {
                    String str = f.a;
                    if (f.this.h != null) {
                        f.this.h.onAdClosed();
                    }
                    com.anythink.basead.e.b.a().b(a2);
                }
            });
            com.anythink.core.basead.b.a aVar = new com.anythink.core.basead.b.a();
            aVar.c = this.e;
            aVar.d = a2;
            aVar.a = 1;
            aVar.h = this.c;
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
