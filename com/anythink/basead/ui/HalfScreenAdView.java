package com.anythink.basead.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.basead.a.e;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.h;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/HalfScreenAdView.class */
public class HalfScreenAdView extends BaseScreenAdView {
    public static final String TAG = HalfScreenAdView.class.getSimpleName();
    private int ae;
    private RelativeLayout af;

    public HalfScreenAdView(Context context) {
        super(context);
    }

    public HalfScreenAdView(Context context, j jVar, i iVar, String str, int i, int i2) {
        super(context, jVar, iVar, str, i, i2);
        setId(h.a(getContext(), "myoffer_half_screen_view_id", "id"));
        this.G = 1;
    }

    private void K() {
        if (!e.a(this.d)) {
            this.ae = 7;
        } else if (L()) {
            this.ae = 3;
        } else {
            this.ae = 4;
        }
    }

    private boolean L() {
        return this.aa <= this.ab;
    }

    private boolean M() {
        return !e.a(this.d);
    }

    private void N() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.y.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
        int i7 = layoutParams2.leftMargin;
        int i8 = layoutParams2.rightMargin;
        int i9 = layoutParams2.topMargin;
        int i10 = layoutParams2.bottomMargin;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.af.getLayoutParams();
        int b = h.b(getContext());
        int i11 = b;
        if (b <= 0) {
            i11 = h.a(getContext(), 25.0f);
        }
        int i12 = this.ae;
        if (i12 != 7) {
            int i13 = 0;
            if (i12 != 3) {
                View findViewById = this.y.findViewById(h.a(getContext(), "myoffer_panel_view_blank", "id"));
                i13 = 0;
                if (findViewById != null) {
                    i13 = ((RelativeLayout.LayoutParams) findViewById.getLayoutParams()).topMargin;
                }
                if (this.t == 1) {
                    i4 = (this.C - i7) - i8;
                    i = (int) (i4 / 1.032258f);
                    this.O = i4;
                    this.P = (int) (this.O / 2.0f);
                    i5 = this.P;
                    i3 = (i - i5) + i13;
                    i2 = i4;
                } else {
                    int i14 = i9;
                    if (i9 < i11) {
                        i14 = (int) (i11 * 1.1f);
                        layoutParams2.topMargin = i14;
                    }
                    i = (this.D - i14) - i10;
                    int i15 = (int) (i * 1.032258f);
                    this.O = i15;
                    this.P = (int) (this.O / 2.0f);
                    int i16 = (i - this.P) + i13;
                    layoutParams2.width = i15;
                    this.w.setLayoutParams(layoutParams2);
                    i2 = i15;
                    i3 = i16;
                }
            } else if (this.t == 1) {
                View findViewById2 = this.y.findViewById(h.a(getContext(), "myoffer_panel_view_blank", "id"));
                if (findViewById2 != null) {
                    i13 = ((RelativeLayout.LayoutParams) findViewById2.getLayoutParams()).topMargin;
                }
                i4 = (this.C - i7) - i8;
                float f = i4;
                i = (int) (f / 0.5714286f);
                if (this.D < (h.a(getContext(), 28.0f) * 2) + i) {
                    i3 = (int) (f / 1.8181819f);
                    this.O = i4;
                    this.P = (i - i3) + i13;
                    i2 = i4;
                } else {
                    this.O = i4;
                    this.P = (int) (this.O / 0.8f);
                    i5 = this.P;
                    i3 = (i - i5) + i13;
                    i2 = i4;
                }
            } else {
                int i17 = i9;
                if (i9 < i11) {
                    i17 = (int) (i11 * 1.1f);
                    layoutParams2.topMargin = i17;
                }
                i = (this.D - i17) - i10;
                i2 = (int) (i * 1.6f);
                this.P = i;
                this.O = (int) (this.P * 0.56f);
                i6 = i2 - this.O;
                layoutParams2.width = i2;
                this.w.setLayoutParams(layoutParams2);
                i3 = i;
            }
            layoutParams4.width = i2;
            layoutParams4.height = i;
            this.af.setLayoutParams(layoutParams4);
            layoutParams3.width = this.O;
            layoutParams3.height = this.P;
            this.x.setLayoutParams(layoutParams3);
            layoutParams.width = i6;
            layoutParams.height = i3;
            this.y.setLayoutParams(layoutParams);
        }
        if (this.t == 2) {
            int i18 = (this.D - i9) - i10;
            i2 = (int) (i18 * 1.75f);
            int a = h.a(getContext(), 120.0f);
            if (i9 < i11) {
                layoutParams2.topMargin = (int) (i11 * 1.1f);
            }
            layoutParams2.width = i2;
            this.w.setLayoutParams(layoutParams2);
            i = i18;
            i3 = a;
        } else if (L()) {
            i2 = (this.C - i7) - i8;
            i = (int) (i2 / 0.5714286f);
            i3 = h.a(getContext(), 240.0f);
        } else {
            i2 = (this.C - i7) - i8;
            i = (int) (i2 / 1.032258f);
            i3 = h.a(getContext(), 120.0f);
        }
        this.O = i2;
        this.P = i;
        i6 = i2;
        layoutParams4.width = i2;
        layoutParams4.height = i;
        this.af.setLayoutParams(layoutParams4);
        layoutParams3.width = this.O;
        layoutParams3.height = this.P;
        this.x.setLayoutParams(layoutParams3);
        layoutParams.width = i6;
        layoutParams.height = i3;
        this.y.setLayoutParams(layoutParams);
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void A() {
        super.B();
        super.C();
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void F() {
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void H() {
        if (this.af == null || this.z == null) {
            return;
        }
        this.af.addView(this.z, 1, this.x.getLayoutParams());
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void I() {
        if (this.x != null) {
            this.af.removeView(this.x);
            this.x = null;
        }
        if (this.H != null) {
            this.H.setVisibility(8);
        }
        this.I.setClickAreaScaleFactor(this.N);
        if (this.K != null) {
            this.K.setVisibility(8);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void J() {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        int i;
        int i2;
        int i3;
        int i4;
        RelativeLayout.LayoutParams layoutParams3;
        RelativeLayout.LayoutParams layoutParams4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        try {
            layoutParams = (RelativeLayout.LayoutParams) this.y.getLayoutParams();
            layoutParams2 = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
            i = layoutParams2.leftMargin;
            i2 = layoutParams2.rightMargin;
            i3 = layoutParams2.topMargin;
            i4 = layoutParams2.bottomMargin;
            layoutParams3 = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
            layoutParams4 = (RelativeLayout.LayoutParams) this.af.getLayoutParams();
            int b = h.b(getContext());
            i5 = b;
            if (b <= 0) {
                i5 = h.a(getContext(), 25.0f);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return;
        }
        if (this.ae != 7) {
            int i12 = 0;
            if (this.ae != 3) {
                View findViewById = this.y.findViewById(h.a(getContext(), "myoffer_panel_view_blank", "id"));
                i12 = 0;
                if (findViewById != null) {
                    i12 = ((RelativeLayout.LayoutParams) findViewById.getLayoutParams()).topMargin;
                }
                if (this.t == 1) {
                    i9 = (this.C - i) - i2;
                    i6 = (int) (i9 / 1.032258f);
                    this.O = i9;
                    this.P = (int) (this.O / 2.0f);
                    i10 = this.P;
                    int i13 = (i6 - i10) + i12;
                    i7 = i9;
                    i8 = i13;
                } else {
                    int i14 = i3;
                    if (i3 < i5) {
                        i14 = (int) (i5 * 1.1f);
                        layoutParams2.topMargin = i14;
                    }
                    i6 = (this.D - i14) - i4;
                    int i15 = (int) (i6 * 1.032258f);
                    this.O = i15;
                    this.P = (int) (this.O / 2.0f);
                    int i16 = (i6 - this.P) + i12;
                    layoutParams2.width = i15;
                    this.w.setLayoutParams(layoutParams2);
                    i7 = i15;
                    i8 = i16;
                }
            } else if (this.t != 1) {
                int i17 = i3;
                if (i3 < i5) {
                    i17 = (int) (i5 * 1.1f);
                    layoutParams2.topMargin = i17;
                }
                i6 = (this.D - i17) - i4;
                i7 = (int) (i6 * 1.6f);
                this.P = i6;
                this.O = (int) (this.P * 0.56f);
                i11 = i7 - this.O;
                layoutParams2.width = i7;
                this.w.setLayoutParams(layoutParams2);
                i8 = i6;
                layoutParams4.width = i7;
                layoutParams4.height = i6;
                this.af.setLayoutParams(layoutParams4);
                layoutParams3.width = this.O;
                layoutParams3.height = this.P;
                this.x.setLayoutParams(layoutParams3);
                layoutParams.width = i11;
                layoutParams.height = i8;
                this.y.setLayoutParams(layoutParams);
            } else {
                View findViewById2 = this.y.findViewById(h.a(getContext(), "myoffer_panel_view_blank", "id"));
                if (findViewById2 != null) {
                    i12 = ((RelativeLayout.LayoutParams) findViewById2.getLayoutParams()).topMargin;
                }
                i9 = (this.C - i) - i2;
                float f = i9;
                i6 = (int) (f / 0.5714286f);
                if (this.D < (h.a(getContext(), 28.0f) * 2) + i6) {
                    int i18 = (int) (f / 1.8181819f);
                    this.O = i9;
                    this.P = (i6 - i18) + i12;
                    i7 = i9;
                    i8 = i18;
                } else {
                    this.O = i9;
                    this.P = (int) (this.O / 0.8f);
                    i10 = this.P;
                    int i132 = (i6 - i10) + i12;
                    i7 = i9;
                    i8 = i132;
                }
            }
            th.printStackTrace();
            return;
        }
        if (this.t == 2) {
            int i19 = (this.D - i3) - i4;
            i7 = (int) (i19 * 1.75f);
            int a = h.a(getContext(), 120.0f);
            if (i3 < i5) {
                layoutParams2.topMargin = (int) (i5 * 1.1f);
            }
            layoutParams2.width = i7;
            this.w.setLayoutParams(layoutParams2);
            i6 = i19;
            i8 = a;
        } else if (L()) {
            i7 = (this.C - i) - i2;
            i6 = (int) (i7 / 0.5714286f);
            i8 = h.a(getContext(), 240.0f);
        } else {
            i7 = (this.C - i) - i2;
            i6 = (int) (i7 / 1.032258f);
            i8 = h.a(getContext(), 120.0f);
        }
        this.O = i7;
        this.P = i6;
        i11 = i7;
        layoutParams4.width = i7;
        layoutParams4.height = i6;
        this.af.setLayoutParams(layoutParams4);
        layoutParams3.width = this.O;
        layoutParams3.height = this.P;
        this.x.setLayoutParams(layoutParams3);
        layoutParams.width = i11;
        layoutParams.height = i8;
        this.y.setLayoutParams(layoutParams);
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView, com.anythink.basead.ui.BaseAdView
    protected final void a() {
        int i = this.ae;
        if (i == 3) {
            LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_half_screen_vertical", "layout"), this);
        } else if (i != 7) {
            LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_half_screen_horizontal", "layout"), this);
        } else {
            LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_half_screen_empty_info", "layout"), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseScreenAdView
    public final void b() {
        super.b();
        this.af = (RelativeLayout) this.w.findViewById(h.a(getContext(), "myoffer_rl_container", "id"));
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final boolean c(int i) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseScreenAdView, com.anythink.basead.ui.BaseAdView
    public final void d() {
        super.d();
        if (!e.a(this.d)) {
            this.ae = 7;
        } else if (L()) {
            this.ae = 3;
        } else {
            this.ae = 4;
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final int q() {
        return this.Q;
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void w() {
        if (this.y != null) {
            this.Q = this.ae;
            this.y.setLayoutType(this.Q);
            if (this.ae == 7) {
                if (this.c.m.x() == 0) {
                    this.y.getCTAButton().setVisibility(8);
                }
                if (m()) {
                    this.R = (BaseShakeView) findViewById(h.a(getContext(), "myoffer_shake_view", "id"));
                    this.S = (BaseShakeView) findViewById(h.a(getContext(), "myoffer_shake_border_view", "id"));
                    o();
                    a(this.R, this.S);
                }
            }
        }
        super.E();
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void y() {
    }
}
