package com.anythink.basead.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.anythink.basead.a.e;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.h;
import com.anythink.core.common.ui.component.RoundImageView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/FullScreenAdView.class */
public class FullScreenAdView extends BaseScreenAdView {
    public static final String TAG = FullScreenAdView.class.getSimpleName();
    private GuideToClickView ae;

    public FullScreenAdView(Context context) {
        super(context);
    }

    public FullScreenAdView(Context context, j jVar, i iVar, String str, int i, int i2) {
        super(context, jVar, iVar, str, i, i2);
        setId(h.a(getContext(), "myoffer_full_screen_view_id", "id"));
        this.G = 0;
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void A() {
        if (this.u) {
            C();
        } else if (1 != this.f6062a || this.v) {
            B();
            p();
        } else {
            double ceil = Math.ceil(this.f6049c.m.e() / 1000.0d);
            double d = ceil;
            if (this.x != null) {
                double ceil2 = Math.ceil(this.x.getVideoLength() / 1000.0d);
                d = ceil;
                if (ceil > ceil2) {
                    d = ceil2;
                }
            }
            RewardExitConfirmDialogActivity.a(getContext(), String.valueOf((int) d), new Runnable() { // from class: com.anythink.basead.ui.FullScreenAdView.2
                @Override // java.lang.Runnable
                public final void run() {
                    FullScreenAdView.this.B();
                    FullScreenAdView.this.C();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseScreenAdView
    public final void D() {
        super.D();
        a(this.R, this.S);
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void H() {
        if (this.w == null || this.z == null) {
            return;
        }
        this.z.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (n()) {
            this.w.addView(this.z, 3);
            return;
        }
        if (c(this.Q)) {
            int i = this.Q;
            if (i != 1) {
                if (i != 2) {
                    if (i == 5) {
                        int i2 = (int) (this.D * 0.5f);
                        this.z.setLayoutParams(new RelativeLayout.LayoutParams(-1, this.D - i2));
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.y.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = this.C;
                            layoutParams.height = i2;
                            this.y.setLayoutParams(layoutParams);
                            this.y.removeAllViews();
                            this.y.setLayoutType(this.Q);
                        }
                    } else if (i != 6) {
                        if (i == 8) {
                            if (this.f6049c.m.x() != 0) {
                                if (this.R != null) {
                                    this.R.setVisibility(8);
                                }
                                if (this.S != null) {
                                    this.S.setVisibility(8);
                                }
                                View shakeView = this.y.getShakeView();
                                if (m()) {
                                    if (shakeView != null) {
                                        shakeView.setVisibility(0);
                                    }
                                } else if (shakeView != null) {
                                    shakeView.setVisibility(8);
                                }
                            } else if (m()) {
                                if (this.S != null) {
                                    this.S.setVisibility(0);
                                }
                            } else if (this.S != null) {
                                this.S.setVisibility(8);
                            }
                        }
                    }
                }
                int a2 = h.a(getContext(), 300.0f);
                this.z.setLayoutParams(new RelativeLayout.LayoutParams(this.C - a2, -1));
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.y.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.width = a2;
                    layoutParams2.height = -1;
                    this.y.setLayoutParams(layoutParams2);
                    this.y.removeAllViews();
                    this.y.setLayoutType(this.Q);
                }
            } else {
                this.w.setBackgroundColor(-1);
                int i3 = (int) (this.D * 0.5f);
                int a3 = TextUtils.isEmpty(this.d.t()) ? this.D - i3 : (this.D - i3) + h.a(getContext(), 50.0f);
                this.z.setLayoutParams(new RelativeLayout.LayoutParams(-1, i3));
                this.z.setNeedArc(true);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.y.getLayoutParams();
                if (layoutParams3 != null) {
                    layoutParams3.width = this.C;
                    layoutParams3.height = a3;
                    this.y.setLayoutParams(layoutParams3);
                    this.y.removeAllViews();
                    this.y.setLayoutType(this.Q);
                }
            }
        }
        this.w.addView(this.z, 3);
        if (this.f6062a == 1) {
            RoundImageView roundImageView = new RoundImageView(getContext());
            roundImageView.setImageResource(h.a(getContext(), "myoffer_reward_icon", com.anythink.expressad.foundation.h.i.f7952c));
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(h.a(getContext(), 60.0f), h.a(getContext(), 60.0f));
            if (c(this.Q)) {
                int i4 = this.Q;
                if (i4 == 2 || i4 == 6) {
                    layoutParams4.leftMargin = this.C - h.a(getContext(), 330.0f);
                    layoutParams4.topMargin = h.a(getContext(), 22.0f);
                } else {
                    layoutParams4.leftMargin = h.a(getContext(), 12.0f);
                    layoutParams4.topMargin = h.a(getContext(), 12.0f);
                }
            } else {
                layoutParams4.leftMargin = h.a(getContext(), 12.0f);
                layoutParams4.topMargin = h.a(getContext(), 12.0f);
            }
            roundImageView.setLayoutParams(layoutParams4);
            this.w.addView(roundImageView, this.w.getChildCount() - 2);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void I() {
        GuideToClickView guideToClickView;
        if (this.x != null) {
            this.w.removeView(this.x);
            this.x = null;
        }
        if (this.H != null) {
            this.H.setVisibility(8);
        }
        this.I.setClickAreaScaleFactor(this.N);
        if (this.K != null) {
            this.K.setVisibility(8);
        }
        if (this.R != null) {
            this.R.setVisibility(8);
        }
        if (this.S != null && this.Q != 8) {
            this.S.setVisibility(8);
        }
        if (this.f6049c.m.i() == 1 && !getHasPerformClick() && (guideToClickView = this.ae) != null) {
            guideToClickView.setVisibility(0);
            this.ae.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.FullScreenAdView.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Tracker.onClick(view);
                    FullScreenAdView.this.b(1);
                }
            });
        }
        if (n()) {
            if (this.y != null) {
                this.y.setVisibility(8);
            }
            if (!m() || this.S == null) {
                return;
            }
            this.S.setVisibility(0);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void J() {
        this.O = this.C;
        this.P = this.D;
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView, com.anythink.basead.ui.BaseAdView
    protected final void a() {
        LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_full_screen", "layout"), this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseScreenAdView, com.anythink.basead.ui.BaseAdView
    public final void b(int i) {
        super.b(i);
        GuideToClickView guideToClickView = this.ae;
        if (guideToClickView != null) {
            guideToClickView.setVisibility(8);
        }
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final boolean c(int i) {
        return (i == 0 || i == 1 || i == 2 || i == 5 || i == 6) ? e.a(this.d) : i == 8;
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    public void init() {
        this.R = (BaseShakeView) findViewById(h.a(getContext(), "myoffer_shake_view", "id"));
        this.S = (BaseShakeView) findViewById(h.a(getContext(), "myoffer_shake_border_view", "id"));
        o();
        this.ae = (GuideToClickView) findViewById(h.a(getContext(), "myoffer_guide_to_click_view", "id"));
        super.init();
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final int q() {
        return this.Q == 8 ? this.Q : this.C < this.D ? this.ac >= this.ad ? 1 : 5 : this.ac < this.ad ? 2 : 6;
    }

    @Override // com.anythink.basead.ui.BaseScreenAdView
    protected final void w() {
        if (this.y != null) {
            if (e.a(this.d)) {
                this.Q = 0;
            } else {
                this.Q = 8;
            }
            this.y.setLayoutType(this.Q);
            if (this.Q == 8 && this.f6049c.m.x() == 0) {
                this.y.getCTAButton().setVisibility(8);
            }
        }
    }
}
