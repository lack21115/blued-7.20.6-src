package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.services.core.AMapException;
import com.anythink.basead.c.f;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.h;
import com.anythink.core.common.res.b;
import com.anythink.core.common.res.e;
import com.anythink.core.common.ui.component.RoundImageView;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/SinglePictureSplashAdView.class */
public class SinglePictureSplashAdView extends BaseSdkSplashAdView {
    public SinglePictureSplashAdView(Context context) {
        super(context);
    }

    public SinglePictureSplashAdView(Context context, j jVar, i iVar, com.anythink.basead.e.a aVar) {
        super(context, jVar, iVar, aVar);
    }

    @Override // com.anythink.basead.ui.BaseAdView
    protected final void a() {
        if (this.c.m.q() == 2) {
            LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_splash_ad_layout_single_land", "layout"), this);
        } else {
            LayoutInflater.from(getContext()).inflate(h.a(getContext(), "myoffer_splash_ad_layout_single_port", "layout"), this);
        }
        o();
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashAdView
    protected final void b() {
        TextView textView = (TextView) findViewById(h.a(getContext(), "myoffer_splash_ad_install_btn", "id"));
        final RoundImageView roundImageView = (RoundImageView) findViewById(h.a(getContext(), "myoffer_splash_bg", "id"));
        com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.d.u()), getResources().getDisplayMetrics().widthPixels, (getResources().getDisplayMetrics().widthPixels * 627) / AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS, new b.a() { // from class: com.anythink.basead.ui.SinglePictureSplashAdView.1
            @Override // com.anythink.core.common.res.b.a
            public final void onFail(String str, String str2) {
            }

            @Override // com.anythink.core.common.res.b.a
            public final void onSuccess(String str, final Bitmap bitmap) {
                if (TextUtils.equals(str, SinglePictureSplashAdView.this.d.u())) {
                    SinglePictureSplashAdView singlePictureSplashAdView = SinglePictureSplashAdView.this;
                    final WrapRoundImageView wrapRoundImageView = (WrapRoundImageView) singlePictureSplashAdView.findViewById(h.a(singlePictureSplashAdView.getContext(), "myoffer_splash_ad_content_image_area", "id"));
                    if (SinglePictureSplashAdView.this.c.m.j() == 2) {
                        wrapRoundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                        wrapRoundImageView.setImageBitmap(bitmap);
                    } else {
                        wrapRoundImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        wrapRoundImageView.post(new Runnable() { // from class: com.anythink.basead.ui.SinglePictureSplashAdView.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                wrapRoundImageView.setBitmapAndResize(bitmap, SinglePictureSplashAdView.this.getWidth(), SinglePictureSplashAdView.this.getHeight());
                            }
                        });
                    }
                    if (roundImageView != null) {
                        roundImageView.setImageBitmap(com.anythink.core.common.k.b.a(SinglePictureSplashAdView.this.getContext(), bitmap));
                    }
                }
            }
        });
        if (this.c.m == null || textView == null) {
            return;
        }
        if (this.c.m.x() == 0 || m()) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        if (TextUtils.isEmpty(this.d.w())) {
            textView.setText(com.anythink.basead.a.e.a(getContext(), this.d));
        } else {
            textView.setText(this.d.w());
        }
        this.r.add(textView);
    }

    @Override // com.anythink.basead.ui.BaseSdkSplashAdView
    protected final void c() {
        super.a(this.c.m.R() < 0 ? 100 : this.c.m.R(), new Runnable() { // from class: com.anythink.basead.ui.SinglePictureSplashAdView.2
            @Override // java.lang.Runnable
            public final void run() {
                if (SinglePictureSplashAdView.this.F == null) {
                    return;
                }
                int width = SinglePictureSplashAdView.this.getWidth();
                int height = SinglePictureSplashAdView.this.getHeight();
                int i = SinglePictureSplashAdView.this.getResources().getDisplayMetrics().widthPixels;
                int i2 = (int) (i * 0.5d);
                int i3 = (int) (SinglePictureSplashAdView.this.getResources().getDisplayMetrics().heightPixels * 0.5d);
                if (width < i2) {
                    SinglePictureSplashAdView.this.a(f.a(f.k, "Splash display width is less than 50% of screen width!"));
                    Log.e(g.n, "Splash display width is less than 50% of screen width!");
                } else if (height >= i3) {
                    SinglePictureSplashAdView.super.h();
                } else {
                    SinglePictureSplashAdView.this.a(f.a(f.k, "Splash display height is less than 50% of screen height!"));
                    Log.e(g.n, "Splash display height is less than 50% of screen height!");
                }
            }
        });
    }
}
