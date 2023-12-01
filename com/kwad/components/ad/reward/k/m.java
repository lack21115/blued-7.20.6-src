package com.kwad.components.ad.reward.k;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.kwad.components.ad.reward.widget.KSCouponLabelTextView;
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bb;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k/m.class */
public final class m extends d implements View.OnClickListener {
    private ViewGroup gv;
    private ViewGroup yR;
    private KSCornerImageView yX;
    private TextView yY;
    private LinearLayout yZ;
    private KsPriceView za;
    private TextView zb;
    private View zc;
    private KSCornerImageView zd;
    private b ze;
    private a zf;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/k/m$a.class */
    public interface a {
        void hu();
    }

    public m(ViewGroup viewGroup, b bVar) {
        this.gv = viewGroup;
        this.ze = bVar;
        initView();
    }

    private static View a(Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        KSCouponLabelTextView kSCouponLabelTextView = (KSCouponLabelTextView) com.kwad.sdk.j.k.a(context, R.layout.ksad_reward_order_card_coupon, viewGroup, false);
        kSCouponLabelTextView.setText(couponInfo.getDisplayName());
        return kSCouponLabelTextView;
    }

    static /* synthetic */ View a(m mVar, Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        return a(context, couponInfo, viewGroup);
    }

    private void a(final AdProductInfo adProductInfo, AdTemplate adTemplate) {
        KSImageLoader.loadImage(this.yX, adProductInfo.getIcon(), adTemplate);
        this.yY.setText(adProductInfo.getName());
        if (adProductInfo.isCouponListEmpty()) {
            this.yZ.setVisibility(8);
            this.zf.hu();
        } else {
            this.yZ.setVisibility(0);
            this.yZ.post(new Runnable() { // from class: com.kwad.components.ad.reward.k.m.1
                @Override // java.lang.Runnable
                public final void run() {
                    for (CouponInfo couponInfo : adProductInfo.getCouponList()) {
                        m mVar = m.this;
                        View a2 = m.a(mVar, mVar.yZ.getContext(), couponInfo, m.this.yZ);
                        ViewGroup.LayoutParams layoutParams = a2.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-2, -1);
                        } else {
                            layoutParams.width = -2;
                            layoutParams.height = -1;
                        }
                        m.this.yZ.addView(a2, layoutParams);
                        com.kwad.components.core.r.g.a(new com.kwad.components.core.widget.e(), m.this.yZ);
                    }
                    if (m.this.zf != null) {
                        if (m.this.yZ.getChildCount() > 0) {
                            m.this.yZ.getChildAt(0).post(new Runnable() { // from class: com.kwad.components.ad.reward.k.m.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    m.this.zf.hu();
                                }
                            });
                        } else {
                            m.this.zf.hu();
                        }
                    }
                }
            });
        }
        this.za.f(adProductInfo.getPrice(), adProductInfo.getOriginPrice());
        String aj = com.kwad.components.ad.c.b.aj();
        if (bb.isNullString(aj)) {
            return;
        }
        KSImageLoader.loadImage(this.zd, aj, adTemplate);
    }

    private void initView() {
        this.yR = (ViewGroup) this.gv.findViewById(R.id.ksad_reward_order_root);
        this.yX = (KSCornerImageView) this.gv.findViewById(R.id.ksad_reward_order_icon);
        this.yY = (TextView) this.gv.findViewById(R.id.ksad_reward_order_title);
        this.yZ = (LinearLayout) this.gv.findViewById(R.id.ksad_reward_order_coupon_list);
        this.za = (KsPriceView) this.gv.findViewById(R.id.ksad_reward_order_price);
        this.zb = (TextView) this.gv.findViewById(R.id.ksad_reward_order_btn_buy);
        this.zc = this.gv.findViewById(R.id.ksad_reward_order_text_area);
        this.zd = (KSCornerImageView) this.gv.findViewById(R.id.ksad_reward_order_kwai_logo);
        this.zb.setText(com.kwad.components.ad.c.b.ai());
        this.zb.setOnClickListener(this);
        this.yX.setOnClickListener(this);
        this.zc.setOnClickListener(this);
        Context context = this.gv.getContext();
        if (ai.DL()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.gv.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_follow_card_width_horizontal);
            this.gv.setLayoutParams(layoutParams2);
        }
    }

    public final void a(a aVar) {
        this.zf = aVar;
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final void a(v vVar) {
        super.a(vVar);
        a(com.kwad.sdk.core.response.a.a.ct(com.kwad.sdk.core.response.a.d.cb(vVar.getAdTemplate())), vVar.getAdTemplate());
    }

    @Override // com.kwad.components.ad.reward.k.d
    public final ViewGroup gK() {
        return this.yR;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tracker.onClick(view);
        if (this.ze == null) {
            return;
        }
        if (view.equals(this.zb)) {
            this.ze.gO();
        } else if (view.equals(this.yX)) {
            this.ze.ic();
        } else if (view.equals(this.zc)) {
            this.ze.id();
        }
    }
}
