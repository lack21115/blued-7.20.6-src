package com.anythink.basead.ui;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.anythink.basead.ui.BaseMediaAdView;
import com.anythink.basead.ui.MraidContainerView;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/MraidMediaView.class */
public class MraidMediaView extends BaseMediaAdView {
    private MraidContainerView g;
    private a h;

    /* renamed from: com.anythink.basead.ui.MraidMediaView$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/MraidMediaView$1.class */
    final class AnonymousClass1 implements MraidContainerView.a {
        AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a() {
            if (MraidMediaView.this.h != null) {
                MraidMediaView.this.h.a();
            }
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void a(String str) {
            if (MraidMediaView.this.h != null) {
                MraidMediaView.this.h.a(str);
            }
        }

        @Override // com.anythink.basead.ui.MraidContainerView.a
        public final void b() {
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/MraidMediaView$a.class */
    public interface a {
        void a();

        void a(String str);
    }

    public MraidMediaView(Context context) {
        this(context, null, null, false, null);
    }

    public MraidMediaView(Context context, i iVar, j jVar, boolean z, BaseMediaAdView.a aVar) {
        super(context, iVar, jVar, z, aVar);
    }

    private void a() {
        MraidContainerView mraidContainerView = new MraidContainerView(getContext(), this.a, this.c, new AnonymousClass1());
        this.g = mraidContainerView;
        mraidContainerView.init();
        if (this.f == null || this.g == null) {
            return;
        }
        this.f.removeAllViews();
        this.f.addView(this.g, new ViewGroup.LayoutParams(-1, -1));
    }

    private static void a(String str) {
        Log.d("MraidMediaView", str);
    }

    @Override // com.anythink.basead.ui.BaseMediaAdView
    public void destroy() {
        super.destroy();
        MraidContainerView mraidContainerView = this.g;
        if (mraidContainerView != null) {
            mraidContainerView.release();
        }
    }

    public void fireAudioVolumeChange(boolean z) {
        MraidContainerView mraidContainerView = this.g;
        if (mraidContainerView != null) {
            mraidContainerView.fireAudioVolumeChange(z);
        }
    }

    @Override // com.anythink.basead.ui.BaseMediaAdView
    public void init(int i, int i2) {
        super.init(i, i2);
        MraidContainerView mraidContainerView = new MraidContainerView(getContext(), this.a, this.c, new AnonymousClass1());
        this.g = mraidContainerView;
        mraidContainerView.init();
        if (this.f == null || this.g == null) {
            return;
        }
        this.f.removeAllViews();
        this.f.addView(this.g, new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        MraidContainerView mraidContainerView = this.g;
        if (mraidContainerView != null) {
            mraidContainerView.fireMraidIsViewable(z);
        }
    }

    public void setMraidWebViewListener(a aVar) {
        this.h = aVar;
    }
}
