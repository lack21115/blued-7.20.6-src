package com.anythink.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.anythink.basead.a.b.c;
import com.anythink.basead.c.e;
import com.anythink.basead.mraid.MraidWebView;
import com.anythink.basead.mraid.d;
import com.anythink.basead.ui.ClickToReLoadView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.k.h;
import com.anythink.core.common.k.u;
import com.anythink.expressad.atsignalcommon.mraid.CallMraidJS;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/MraidContainerView.class */
public class MraidContainerView extends FrameLayout {
    private static final String h = MraidContainerView.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    protected i f6128a;
    protected k b;

    /* renamed from: c  reason: collision with root package name */
    protected j f6129c;
    protected b d;
    protected ClickToReLoadView e;
    protected MraidWebView f;
    protected a g;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/MraidContainerView$a.class */
    public interface a {
        void a();

        void a(String str);

        void b();
    }

    public MraidContainerView(Context context) {
        super(context);
    }

    public MraidContainerView(Context context, i iVar, j jVar, a aVar) {
        super(context);
        this.f6128a = iVar;
        this.b = jVar.m;
        this.f6129c = jVar;
        this.g = aVar;
        setBackgroundColor(getResources().getColor(h.a(context, "color_99000000", "color")));
    }

    static /* synthetic */ boolean a(MraidContainerView mraidContainerView) {
        mraidContainerView.k = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        MraidWebView b = c.b(c.a(this.f6129c, this.f6128a));
        this.f = b;
        if (b != null) {
            this.l = true;
            if (this.j) {
                b.setNeedRegisterVolumeChangeReceiver(true);
            }
            this.f.prepare(getContext(), new com.anythink.basead.mraid.b() { // from class: com.anythink.basead.ui.MraidContainerView.1
                @Override // com.anythink.basead.mraid.b
                public final void a() {
                    if (MraidContainerView.this.g != null) {
                        MraidContainerView.this.g.b();
                    }
                }

                @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
                public final void close() {
                }

                @Override // com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge
                public final void open(String str) {
                    if (MraidContainerView.this.g != null) {
                        MraidContainerView.this.g.a(str);
                    }
                }
            });
            addView(this.f, new FrameLayout.LayoutParams(-1, -1));
            a aVar = this.g;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.e == null) {
            ClickToReLoadView clickToReLoadView = new ClickToReLoadView(getContext());
            this.e = clickToReLoadView;
            clickToReLoadView.setListener(new ClickToReLoadView.a() { // from class: com.anythink.basead.ui.MraidContainerView.3
                @Override // com.anythink.basead.ui.ClickToReLoadView.a
                public final void a() {
                    MraidContainerView.this.loadMraidWebView();
                }
            });
        }
        addView(this.e, new FrameLayout.LayoutParams(-1, -1));
    }

    private void d() {
        ClickToReLoadView clickToReLoadView = this.e;
        if (clickToReLoadView != null) {
            removeView(clickToReLoadView);
        }
    }

    private void e() {
        b bVar = this.d;
        if (bVar != null) {
            bVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        b bVar = this.d;
        if (bVar != null) {
            bVar.c();
        }
    }

    private void g() {
        if (this.b.V()) {
            return;
        }
        loadMraidWebView();
    }

    public void fireAudioVolumeChange(boolean z) {
        try {
            if (!this.l || this.f == null) {
                return;
            }
            if (z) {
                CallMraidJS.getInstance().fireAudioVolumeChange(this.f, 0.0d);
            } else {
                CallMraidJS.getInstance().fireAudioVolumeChange(this.f, 1.0d);
            }
        } catch (Exception e) {
        }
    }

    public void fireMraidIsViewable(boolean z) {
        try {
            if (!this.l || this.f == null) {
                return;
            }
            if (z) {
                com.anythink.expressad.mbbanner.a.a.a.a(this.f, true);
            } else {
                com.anythink.expressad.mbbanner.a.a.a.a(this.f, false);
            }
        } catch (Throwable th) {
        }
    }

    public void init() {
        if (this.b.V()) {
            b();
            return;
        }
        b bVar = new b(this);
        this.d = bVar;
        bVar.a();
    }

    public void loadMraidWebView() {
        if (this.k || this.l) {
            return;
        }
        this.k = true;
        ClickToReLoadView clickToReLoadView = this.e;
        if (clickToReLoadView != null) {
            removeView(clickToReLoadView);
        }
        b bVar = this.d;
        if (bVar != null) {
            bVar.b();
        }
        final String a2 = d.a(this.f6129c, this.f6128a);
        if (!TextUtils.isEmpty(a2)) {
            final String a3 = c.a(this.f6129c, this.f6128a);
            n.a().a(new Runnable() { // from class: com.anythink.basead.ui.MraidContainerView.2
                @Override // java.lang.Runnable
                public final void run() {
                    MraidContainerView.this.f = new MraidWebView(n.a().g());
                    d.a(a3, a2, MraidContainerView.this.f, new d.a() { // from class: com.anythink.basead.ui.MraidContainerView.2.1
                        @Override // com.anythink.basead.mraid.d.a
                        public final void a() {
                            String unused = MraidContainerView.h;
                            MraidContainerView.a(MraidContainerView.this);
                            MraidContainerView.this.b();
                            MraidContainerView.this.f();
                        }

                        @Override // com.anythink.basead.mraid.d.a
                        public final void a(e eVar) {
                            MraidContainerView.a(MraidContainerView.this);
                            String unused = MraidContainerView.h;
                            new StringBuilder("onFailed: ").append(eVar.c());
                            MraidContainerView.this.c();
                            MraidContainerView.this.f();
                        }
                    });
                }
            });
            return;
        }
        this.k = false;
        c();
        f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.i = true;
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i = false;
    }

    public void release() {
        try {
            if (this.l && this.f != null) {
                u.a(this.f);
                this.f.release();
                com.anythink.core.common.res.d.a(n.a().g()).a(this.f6129c, this.f6128a);
            }
            u.a(this);
        } catch (Throwable th) {
        }
    }

    public void setNeedRegisterVolumeChangeReceiver(boolean z) {
        this.j = z;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.i) {
            g();
        }
    }
}
