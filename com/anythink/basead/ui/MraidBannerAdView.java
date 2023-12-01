package com.anythink.basead.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.anythink.basead.ui.MraidContainerView;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.k.h;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/MraidBannerAdView.class */
public class MraidBannerAdView extends BaseBannerAdView {
    MraidContainerView u;

    /* renamed from: com.anythink.basead.ui.MraidBannerAdView$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/MraidBannerAdView$1.class */
    final class AnonymousClass1 implements MraidContainerView.a {
        AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a() {
            try {
                MraidBannerAdView.this.b();
            } catch (Throwable th) {
            }
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a(String str) {
            MraidBannerAdView.this.d.v(str);
            MraidBannerAdView.this.b(1);
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void b() {
        }
    }

    public MraidBannerAdView(Context context) {
        super(context);
    }

    public MraidBannerAdView(Context context, j jVar, i iVar, com.anythink.basead.e.a aVar) {
        super(context, jVar, iVar, aVar);
        c();
    }

    private void o() {
        boolean z;
        int a;
        String r = this.c.m.r();
        LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_web_banner_ad_layout", "layout"), this);
        int a2 = h.a(getContext(), 50.0f);
        int a3 = h.a(getContext(), 320.0f);
        int hashCode = r.hashCode();
        if (hashCode == -559799608) {
            if (r.equals(k.c)) {
                z = true;
            }
            z = true;
        } else if (hashCode != 1507809854) {
            if (hashCode == 1622564786 && r.equals(k.d)) {
                z = true;
            }
            z = true;
        } else {
            if (r.equals(k.b)) {
                z = false;
            }
            z = true;
        }
        if (!z) {
            a3 = h.a(getContext(), 320.0f);
            a = h.a(getContext(), 90.0f);
        } else if (z) {
            a3 = h.a(getContext(), 720.0f);
            a = h.a(getContext(), 90.0f);
        } else if (!z) {
            a = a2;
        } else {
            a3 = h.a(getContext(), 300.0f);
            a = h.a(getContext(), 250.0f);
        }
        int min = Math.min(a3, getResources().getDisplayMetrics().widthPixels);
        MraidContainerView mraidContainerView = new MraidContainerView(getContext(), this.d, this.c, new AnonymousClass1());
        this.u = mraidContainerView;
        mraidContainerView.init();
        FrameLayout frameLayout = (FrameLayout) findViewById(h.a(getContext(), "myoffer_banner_web", "id"));
        this.u.setMinimumHeight(h.a(getContext(), 50.0f));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(min, a);
        layoutParams.gravity = 17;
        frameLayout.addView(this.u, 0, layoutParams);
        setLayoutParams(new ViewGroup.LayoutParams(min, a));
        this.t = (CloseImageView) findViewById(h.a(getContext(), "myoffer_banner_close", "id"));
        if (this.c.m.s() != 0) {
            this.t.setVisibility(8);
            return;
        }
        this.t.setVisibility(0);
        a(this.t, this.c.m.h());
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void a() {
        boolean z;
        int a;
        String r = this.c.m.r();
        LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_web_banner_ad_layout", "layout"), this);
        int a2 = h.a(getContext(), 50.0f);
        int a3 = h.a(getContext(), 320.0f);
        int hashCode = r.hashCode();
        if (hashCode == -559799608) {
            if (r.equals(k.c)) {
                z = true;
            }
            z = true;
        } else if (hashCode != 1507809854) {
            if (hashCode == 1622564786 && r.equals(k.d)) {
                z = true;
            }
            z = true;
        } else {
            if (r.equals(k.b)) {
                z = false;
            }
            z = true;
        }
        if (!z) {
            a3 = h.a(getContext(), 320.0f);
            a = h.a(getContext(), 90.0f);
        } else if (z) {
            a3 = h.a(getContext(), 720.0f);
            a = h.a(getContext(), 90.0f);
        } else if (!z) {
            a = a2;
        } else {
            a3 = h.a(getContext(), 300.0f);
            a = h.a(getContext(), 250.0f);
        }
        int min = Math.min(a3, getResources().getDisplayMetrics().widthPixels);
        MraidContainerView mraidContainerView = new MraidContainerView(getContext(), this.d, this.c, new AnonymousClass1());
        this.u = mraidContainerView;
        mraidContainerView.init();
        FrameLayout frameLayout = (FrameLayout) findViewById(h.a(getContext(), "myoffer_banner_web", "id"));
        this.u.setMinimumHeight(h.a(getContext(), 50.0f));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(min, a);
        layoutParams.gravity = 17;
        frameLayout.addView(this.u, 0, layoutParams);
        setLayoutParams(new ViewGroup.LayoutParams(min, a));
        this.t = (CloseImageView) findViewById(h.a(getContext(), "myoffer_banner_close", "id"));
        if (this.c.m.s() != 0) {
            this.t.setVisibility(8);
            return;
        }
        this.t.setVisibility(0);
        a(this.t, this.c.m.h());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseBannerAdView
    public final void b() {
        if (this.u == null) {
            return;
        }
        super.b();
    }

    @Override // com.anythink.basead.ui.BaseAdView
    public void destroy() {
        super.destroy();
        MraidContainerView mraidContainerView = this.u;
        if (mraidContainerView != null) {
            mraidContainerView.release();
        }
    }
}
