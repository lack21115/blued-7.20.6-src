package com.anythink.basead.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.k.h;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/BaseMediaAdView.class */
public abstract class BaseMediaAdView extends FrameLayout {
    protected i a;
    protected k b;
    protected j c;
    protected a d;
    protected boolean e;
    protected FrameLayout f;
    private int g;
    private int h;
    private CloseImageView i;

    /* renamed from: com.anythink.basead.ui.BaseMediaAdView$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/BaseMediaAdView$1.class */
    final class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Tracker.onClick(view);
            if (BaseMediaAdView.this.d != null) {
                BaseMediaAdView.this.d.onClickCloseView();
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/BaseMediaAdView$a.class */
    public interface a {
        void onClickCloseView();
    }

    public BaseMediaAdView(Context context) {
        super(context);
        this.g = 0;
        this.h = 0;
    }

    public BaseMediaAdView(Context context, i iVar, j jVar, boolean z, a aVar) {
        super(context);
        this.g = 0;
        this.h = 0;
        this.a = iVar;
        this.b = jVar.m;
        this.e = z;
        this.d = aVar;
        this.c = jVar;
        LayoutInflater.from(getContext()).inflate(h.a(getContext(), "base_myoffer_media_ad_view", "layout"), this);
        this.f = (FrameLayout) findViewById(h.a(getContext(), "base_media_view_content", "id"));
        this.i = (CloseImageView) findViewById(h.a(getContext(), "base_media_ad_close", "id"));
    }

    private void a() {
        CloseImageView closeImageView = this.i;
        if (closeImageView == null) {
            return;
        }
        if (this.e) {
            closeImageView.setVisibility(0);
        } else {
            closeImageView.setVisibility(8);
        }
        a(this.i, this.b.h());
        this.i.setOnClickListener(new AnonymousClass1());
    }

    private static void a(com.anythink.basead.ui.a aVar, int i) {
        if (aVar != null) {
            aVar.setClickAreaScaleFactor(i != 2 ? i != 3 ? i != 4 ? 1.0f : 0.5f : 0.75f : 1.5f);
        }
    }

    public void destroy() {
    }

    public List<View> getClickViews() {
        return new ArrayList();
    }

    public int getMediaViewHeight() {
        return this.h;
    }

    public int getMediaViewWidth() {
        return this.g;
    }

    public View getMonitorClickView() {
        return null;
    }

    public void init(int i, int i2) {
        this.g = i;
        this.h = i2;
        CloseImageView closeImageView = this.i;
        if (closeImageView != null) {
            if (this.e) {
                closeImageView.setVisibility(0);
            } else {
                closeImageView.setVisibility(8);
            }
            a(this.i, this.b.h());
            this.i.setOnClickListener(new AnonymousClass1());
        }
    }

    public void notifyClick() {
        k kVar;
        CloseImageView closeImageView = this.i;
        if (closeImageView == null || (kVar = this.b) == null) {
            return;
        }
        a(closeImageView, kVar.g());
    }
}
