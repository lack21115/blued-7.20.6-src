package com.anythink.basead.d;

import android.content.Context;
import com.anythink.basead.d.b;
import com.anythink.core.common.e.j;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d/e.class */
public final class e extends b {
    public e(Context context, b.a aVar, j jVar) {
        super(context, aVar, jVar);
    }

    public final void a(final com.anythink.basead.e.d dVar) {
        super.a(new com.anythink.basead.e.c() { // from class: com.anythink.basead.d.e.1
            @Override // com.anythink.basead.e.c
            public final void onAdCacheLoaded() {
                h hVar = new h(e.this.b, e.this.e, e.this.c, e.this.f);
                com.anythink.basead.e.d dVar2 = dVar;
                if (dVar2 != null) {
                    dVar2.onNativeAdLoaded(hVar);
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
            }

            @Override // com.anythink.basead.e.c
            public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
                com.anythink.basead.e.d dVar2 = dVar;
                if (dVar2 != null) {
                    dVar2.onNativeAdLoadError(eVar);
                }
            }
        });
    }
}
