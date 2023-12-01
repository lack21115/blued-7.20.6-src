package com.anythink.basead.f;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.anythink.basead.ui.MraidBannerAdView;
import com.anythink.basead.ui.SdkBannerAdView;
import com.anythink.core.common.e.j;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/f/b.class */
public final class b extends c {
    com.anythink.basead.e.a a;
    private final String k;

    public b(Context context, j jVar, String str, boolean z) {
        super(context, jVar, str, z);
        this.k = getClass().getSimpleName();
    }

    @Override // com.anythink.basead.f.a
    public final void a(Activity activity, Map<String, Object> map) {
    }

    public final void a(com.anythink.basead.e.a aVar) {
        this.a = aVar;
    }

    public final View b() {
        if (a()) {
            return this.g.g() ? new MraidBannerAdView(this.c, this.d, this.g, this.a) : new SdkBannerAdView(this.c, this.d, this.g, this.a);
        }
        return null;
    }

    @Override // com.anythink.basead.f.c
    public final void c() {
        this.a = null;
    }
}
