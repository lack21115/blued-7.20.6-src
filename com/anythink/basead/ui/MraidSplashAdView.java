package com.anythink.basead.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.basead.ui.MraidContainerView;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.h;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/MraidSplashAdView.class */
public class MraidSplashAdView extends BaseSplashAdView {

    /* renamed from: a  reason: collision with root package name */
    MraidContainerView f6137a;

    /* renamed from: com.anythink.basead.ui.MraidSplashAdView$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/MraidSplashAdView$1.class */
    final class AnonymousClass1 implements MraidContainerView.a {
        AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a() {
            try {
                MraidSplashAdView.a(MraidSplashAdView.this);
            } catch (Throwable th) {
            }
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a(String str) {
            MraidSplashAdView.this.d.v(str);
            MraidSplashAdView.this.b(1);
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void b() {
            MraidSplashAdView.this.q();
            MraidSplashAdView.this.r();
            MraidSplashAdView.this.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.basead.ui.MraidSplashAdView$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/MraidSplashAdView$2.class */
    public final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (MraidSplashAdView.this.F == null) {
                return;
            }
            MraidSplashAdView.super.h();
        }
    }

    public MraidSplashAdView(Context context) {
        super(context);
    }

    public MraidSplashAdView(Context context, j jVar, i iVar, com.anythink.basead.e.a aVar) {
        super(context, jVar, iVar, aVar);
    }

    static /* synthetic */ void a(MraidSplashAdView mraidSplashAdView) {
        if (mraidSplashAdView.d.g() && mraidSplashAdView.f6137a == null) {
            return;
        }
        super.a(mraidSplashAdView.f6049c.m.R() < 0 ? 100 : mraidSplashAdView.f6049c.m.R(), new AnonymousClass2());
    }

    private void b() {
        MraidContainerView mraidContainerView = new MraidContainerView(getContext(), this.d, this.f6049c, new AnonymousClass1());
        this.f6137a = mraidContainerView;
        mraidContainerView.setNeedRegisterVolumeChangeReceiver(true);
        this.f6137a.init();
        FrameLayout frameLayout = (FrameLayout) findViewById(h.a(getContext(), "myoffer_splash_web", "id"));
        if (frameLayout != null) {
            frameLayout.addView(this.f6137a, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    private void c() {
        if (this.d.g() && this.f6137a == null) {
            return;
        }
        super.a(this.f6049c.m.R() < 0 ? 100 : this.f6049c.m.R(), new AnonymousClass2());
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void a() {
        LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_web_splash_ad_layout", "layout"), this);
        MraidContainerView mraidContainerView = new MraidContainerView(getContext(), this.d, this.f6049c, new AnonymousClass1());
        this.f6137a = mraidContainerView;
        mraidContainerView.setNeedRegisterVolumeChangeReceiver(true);
        this.f6137a.init();
        FrameLayout frameLayout = (FrameLayout) findViewById(h.a(getContext(), "myoffer_splash_web", "id"));
        if (frameLayout != null) {
            frameLayout.addView(this.f6137a, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.anythink.basead.ui.BaseSplashAdView, com.anythink.basead.ui.BaseAdView
    public void destroy() {
        super.destroy();
        MraidContainerView mraidContainerView = this.f6137a;
        if (mraidContainerView != null) {
            mraidContainerView.release();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        MraidContainerView mraidContainerView = this.f6137a;
        if (mraidContainerView != null) {
            mraidContainerView.fireMraidIsViewable(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseSplashAdView
    public final void p() {
        int size = this.r.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            View view = this.r.get(i2);
            if (view != null) {
                view.setOnClickListener(this.K);
            }
            i = i2 + 1;
        }
    }
}
