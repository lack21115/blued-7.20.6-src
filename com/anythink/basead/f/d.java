package com.anythink.basead.f;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.e.b;
import com.anythink.basead.ui.BaseAdActivity;
import com.anythink.core.common.e.j;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/f/d.class */
public class d extends c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5993a = d.class.getSimpleName();
    private com.anythink.basead.e.g k;

    public d(Context context, j jVar, String str, boolean z) {
        super(context, jVar, str, z);
    }

    @Override // com.anythink.basead.f.a
    public final void a(Activity activity, Map<String, Object> map) {
        try {
            if (this.f5991c == null) {
                if (this.k != null) {
                    this.k.onShowFailed(com.anythink.basead.c.f.a(com.anythink.basead.c.f.i, com.anythink.basead.c.f.B));
                    return;
                }
                return;
            }
            map.get(c.h);
            String obj = map.get("extra_scenario").toString();
            int intValue = ((Integer) map.get(c.j)).intValue();
            final String str = this.d.b + this.e + System.currentTimeMillis();
            com.anythink.basead.e.b.a().a(str, new b.InterfaceC0079b() { // from class: com.anythink.basead.f.d.1
                @Override // com.anythink.basead.e.b.InterfaceC0079b
                public final void a() {
                    String str2 = d.f5993a;
                    if (d.this.k != null) {
                        d.this.k.onAdShow();
                    }
                }

                @Override // com.anythink.basead.e.b.InterfaceC0079b
                public final void a(int i) {
                    String str2 = d.f5993a;
                    if (d.this.k != null) {
                        d.this.k.onAdClick(i);
                    }
                }

                @Override // com.anythink.basead.e.b.InterfaceC0079b
                public final void a(com.anythink.basead.c.e eVar) {
                    String str2 = d.f5993a;
                    new StringBuilder("onVideoShowFailed.......").append(eVar.c());
                    if (d.this.k != null) {
                        d.this.k.onShowFailed(eVar);
                    }
                }

                @Override // com.anythink.basead.e.b.InterfaceC0079b
                public final void a(boolean z) {
                    String str2 = d.f5993a;
                    if (d.this.k != null) {
                        d.this.k.onDeeplinkCallback(z);
                    }
                }

                @Override // com.anythink.basead.e.b.InterfaceC0079b
                public final void b() {
                    String str2 = d.f5993a;
                    if (d.this.k != null) {
                        d.this.k.onVideoAdPlayStart();
                    }
                }

                @Override // com.anythink.basead.e.b.InterfaceC0079b
                public final void c() {
                    String str2 = d.f5993a;
                    if (d.this.k != null) {
                        d.this.k.onVideoAdPlayEnd();
                    }
                }

                @Override // com.anythink.basead.e.b.InterfaceC0079b
                public final void d() {
                }

                @Override // com.anythink.basead.e.b.InterfaceC0079b
                public final void e() {
                    String str2 = d.f5993a;
                    if (d.this.k != null) {
                        d.this.k.onAdClosed();
                    }
                    com.anythink.basead.e.b.a().b(str);
                }
            });
            com.anythink.core.basead.b.a aVar = new com.anythink.core.basead.b.a();
            aVar.f6395c = this.g;
            aVar.d = str;
            aVar.f6394a = 3;
            aVar.h = this.d;
            aVar.e = intValue;
            aVar.b = obj;
            BaseAdActivity.a(activity, aVar);
        } catch (Exception e) {
            e.printStackTrace();
            com.anythink.basead.e.g gVar = this.k;
            if (gVar != null) {
                gVar.onShowFailed(com.anythink.basead.c.f.a("-9999", e.getMessage()));
            }
        }
    }

    public final void a(com.anythink.basead.e.g gVar) {
        this.k = gVar;
    }
}
