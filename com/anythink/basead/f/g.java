package com.anythink.basead.f;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.anythink.basead.ui.AsseblemSplashAdView;
import com.anythink.basead.ui.BaseSdkSplashAdView;
import com.anythink.basead.ui.BaseSplashAdView;
import com.anythink.basead.ui.SinglePictureSplashAdView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.j;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/f/g.class */
public final class g extends c {
    com.anythink.basead.e.a a;
    BaseSplashAdView k;
    boolean l;

    public g(Context context, j jVar, String str) {
        super(context, jVar, str, false);
    }

    @Override // com.anythink.basead.f.a
    public final void a(Activity activity, Map<String, Object> map) {
    }

    public final void a(final ViewGroup viewGroup) {
        n.a().a(new Runnable() { // from class: com.anythink.basead.f.g.1
            @Override // java.lang.Runnable
            public final void run() {
                if (BaseSdkSplashAdView.isSinglePicture(g.this.g, g.this.d.m)) {
                    g.this.k = new SinglePictureSplashAdView(viewGroup.getContext(), g.this.d, g.this.g, g.this.a);
                } else {
                    g.this.k = new AsseblemSplashAdView(viewGroup.getContext(), g.this.d, g.this.g, g.this.a);
                }
                g.this.k.setDontCountDown(g.this.l);
                viewGroup.addView(g.this.k);
            }
        });
    }

    public final void a(com.anythink.basead.e.a aVar) {
        this.a = aVar;
    }

    @Override // com.anythink.basead.f.c, com.anythink.basead.f.a
    public final boolean a() {
        try {
            if (d()) {
                return com.anythink.basead.f.a.a.a(this.c).a(this.g, this.d, this.f);
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final void b() {
        this.l = true;
    }

    public final void f() {
        this.a = null;
        BaseSplashAdView baseSplashAdView = this.k;
        if (baseSplashAdView != null) {
            baseSplashAdView.destroy();
            this.k = null;
        }
    }
}
