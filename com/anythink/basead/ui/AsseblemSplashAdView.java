package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.h;
import com.anythink.core.common.res.b;
import com.anythink.core.common.res.e;
import com.anythink.core.common.ui.component.RoundImageView;
import com.blued.das.live.LiveProtos;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/AsseblemSplashAdView.class */
public class AsseblemSplashAdView extends BaseSdkSplashAdView {

    /* renamed from: a  reason: collision with root package name */
    View f6036a;

    public AsseblemSplashAdView(Context context) {
        super(context);
    }

    public AsseblemSplashAdView(Context context, j jVar, i iVar, com.anythink.basead.e.a aVar) {
        super(context, jVar, iVar, aVar);
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void a() {
        if (this.f6049c.m.q() == 2) {
            LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_splash_ad_layout_asseblem_vertical_land", "layout"), this);
        } else {
            LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_splash_ad_layout_asseblem_vertical_port", "layout"), this);
        }
        o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseSdkSplashAdView
    public void b() {
        TextView textView = (TextView) findViewById(h.a(getContext(), "myoffer_splash_ad_title", "id"));
        TextView textView2 = (TextView) findViewById(h.a(getContext(), "myoffer_splash_ad_install_btn", "id"));
        TextView textView3 = (TextView) findViewById(h.a(getContext(), "myoffer_splash_desc", "id"));
        final FrameLayout frameLayout = (FrameLayout) findViewById(h.a(getContext(), "myoffer_splash_ad_content_image_area", "id"));
        final RoundImageView roundImageView = (RoundImageView) findViewById(h.a(getContext(), "myoffer_splash_bg", "id"));
        final RoundImageView roundImageView2 = (RoundImageView) findViewById(h.a(getContext(), "myoffer_splash_icon", "id"));
        this.f6036a = textView2;
        if (TextUtils.isEmpty(this.d.t())) {
            com.anythink.basead.ui.a.a.a(roundImageView2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) roundImageView2.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.rightMargin = 0;
                roundImageView2.setLayoutParams(layoutParams);
            }
            if (textView != null) {
                textView.setGravity(17);
            }
            if (textView3 != null) {
                textView3.setGravity(17);
            }
        } else {
            roundImageView2.setVisibility(0);
            roundImageView2.setNeedRadiu(true);
            roundImageView2.setRadiusInDip(12);
            int i = roundImageView2.getLayoutParams().width;
            com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.d.t()), i, i, new b.a() { // from class: com.anythink.basead.ui.AsseblemSplashAdView.1
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, Bitmap bitmap) {
                    if (TextUtils.equals(str, AsseblemSplashAdView.this.d.t())) {
                        roundImageView2.setImageBitmap(bitmap);
                    }
                }
            });
        }
        this.r.add(roundImageView2);
        frameLayout.removeAllViews();
        final WrapRoundImageView wrapRoundImageView = new WrapRoundImageView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        wrapRoundImageView.setLayoutParams(layoutParams2);
        wrapRoundImageView.setNeedRadiu(false);
        wrapRoundImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        wrapRoundImageView.setVisibility(4);
        frameLayout.addView(wrapRoundImageView, layoutParams2);
        frameLayout.setVisibility(0);
        roundImageView.setNeedRadiu(false);
        if (TextUtils.isEmpty(this.d.u())) {
            roundImageView.setBackgroundColor(Color.parseColor("#EFEFEF"));
        } else {
            com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.d.u()), getResources().getDisplayMetrics().widthPixels, (getResources().getDisplayMetrics().widthPixels * LiveProtos.Event.LIVE_BATTLE_PASS_NOTICE_TOP_SHOW_VALUE) / 1200, new b.a() { // from class: com.anythink.basead.ui.AsseblemSplashAdView.2
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, final Bitmap bitmap) {
                    if (TextUtils.equals(str, AsseblemSplashAdView.this.d.u())) {
                        frameLayout.post(new Runnable() { // from class: com.anythink.basead.ui.AsseblemSplashAdView.2.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                wrapRoundImageView.setBitmapAndResize(bitmap, frameLayout.getWidth(), frameLayout.getHeight());
                                wrapRoundImageView.setVisibility(0);
                            }
                        });
                        roundImageView.setImageBitmap(com.anythink.core.common.k.b.a(AsseblemSplashAdView.this.getContext(), bitmap));
                    }
                }
            });
            this.r.add(wrapRoundImageView);
        }
        if (TextUtils.isEmpty(this.d.r())) {
            textView.setVisibility(4);
        } else {
            textView.setText(this.d.r());
            textView.setVisibility(0);
        }
        this.r.add(textView);
        if (TextUtils.isEmpty(this.d.w())) {
            textView2.setText(com.anythink.basead.a.e.a(getContext(), this.d));
        } else {
            textView2.setText(this.d.w());
        }
        this.r.add(textView2);
        if (textView3 != null) {
            if (TextUtils.isEmpty(this.d.s())) {
                textView3.setVisibility(8);
            } else {
                textView3.setText(this.d.s());
            }
            this.r.add(textView3);
        }
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashAdView
    protected void c() {
        super.a(this.f6049c.m.R() < 0 ? 100 : this.f6049c.m.R(), new Runnable() { // from class: com.anythink.basead.ui.AsseblemSplashAdView.3
            @Override // java.lang.Runnable
            public final void run() {
                if (AsseblemSplashAdView.this.F == null) {
                    return;
                }
                AsseblemSplashAdView.super.h();
            }
        });
    }
}
