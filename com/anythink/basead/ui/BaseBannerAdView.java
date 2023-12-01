package com.anythink.basead.ui;

import android.content.Context;
import android.view.View;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/BaseBannerAdView.class */
public abstract class BaseBannerAdView extends BaseAdView {
    public final String TAG;
    protected com.anythink.basead.e.a a;
    protected CloseImageView t;

    public BaseBannerAdView(Context context) {
        super(context);
        this.TAG = getClass().getSimpleName();
    }

    public BaseBannerAdView(Context context, j jVar, i iVar, com.anythink.basead.e.a aVar) {
        super(context, jVar, iVar);
        this.TAG = getClass().getSimpleName();
        this.a = aVar;
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void a(int i) {
        a(this.t, this.c.m.g());
        com.anythink.basead.e.a aVar = this.a;
        if (aVar != null) {
            aVar.onAdClick(i);
        }
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void a(boolean z) {
        com.anythink.basead.e.a aVar = this.a;
        if (aVar != null) {
            aVar.onDeeplinkCallback(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        a(this.c.m.R() < 0 ? 100 : this.c.m.R(), new Runnable() { // from class: com.anythink.basead.ui.BaseBannerAdView.1
            @Override // java.lang.Runnable
            public final void run() {
                BaseBannerAdView.super.h();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.t.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseBannerAdView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (BaseBannerAdView.this.a != null) {
                    BaseBannerAdView.this.a.onAdClosed();
                }
            }
        });
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void e() {
        com.anythink.basead.a.b.a(8, this.d, i());
        com.anythink.basead.e.a aVar = this.a;
        if (aVar != null) {
            aVar.onAdShow();
        }
    }
}
