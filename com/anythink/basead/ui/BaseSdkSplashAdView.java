package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.e.s;
import com.anythink.core.common.e.u;
import com.anythink.core.common.k.h;
import com.anythink.core.common.k.l;
import com.anythink.core.common.res.b;
import com.anythink.core.common.res.e;
import com.anythink.core.common.ui.component.RoundImageView;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/BaseSdkSplashAdView.class */
public abstract class BaseSdkSplashAdView extends BaseSplashAdView {
    public static final int TYPE_ASSEBLEM = 1;
    public static final int TYPE_SINGLE_PICTURE = 0;
    protected RoundImageView t;
    ViewGroup u;
    TextView v;
    TextView w;
    TextView x;
    TextView y;
    protected final View.OnClickListener z;

    public BaseSdkSplashAdView(Context context) {
        super(context);
        this.z = new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseSdkSplashAdView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (BaseSdkSplashAdView.this.c.m == null || BaseSdkSplashAdView.this.c.m.x() != 0) {
                    return;
                }
                BaseSdkSplashAdView.super.b(1);
            }
        };
    }

    public BaseSdkSplashAdView(Context context, j jVar, i iVar, com.anythink.basead.e.a aVar) {
        super(context, jVar, iVar, aVar);
        this.z = new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseSdkSplashAdView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Tracker.onClick(view);
                if (BaseSdkSplashAdView.this.c.m == null || BaseSdkSplashAdView.this.c.m.x() != 0) {
                    return;
                }
                BaseSdkSplashAdView.super.b(1);
            }
        };
        c();
        p();
        a(this.B, this.c.m.h());
    }

    public static boolean isSinglePicture(i iVar, k kVar) {
        return ((iVar instanceof s) && (kVar instanceof u)) ? 2 == ((u) kVar).X() : (iVar instanceof aa) && 1 == ((aa) iVar).Y();
    }

    @Override // com.anythink.basead.ui.BaseSplashAdView, com.anythink.basead.ui.BaseAdView
    protected final void a(int i) {
        if (this.F != null) {
            this.F.onAdClick(i);
        }
        if (this.J != null) {
            this.J.setVisibility(8);
        }
    }

    protected abstract void b();

    protected abstract void c();

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        b();
        this.u = (ViewGroup) findViewById(h.a(getContext(), "myoffer_four_element_container", "id"));
        this.v = (TextView) findViewById(h.a(getContext(), "myoffer_publisher_name", "id"));
        this.w = (TextView) findViewById(h.a(getContext(), "myoffer_privacy_agreement", "id"));
        this.x = (TextView) findViewById(h.a(getContext(), "myoffer_permission_manage", "id"));
        this.y = (TextView) findViewById(h.a(getContext(), "myoffer_version_name", "id"));
        if (this.d.K()) {
            ViewGroup viewGroup = this.u;
            if (viewGroup != null) {
                viewGroup.setVisibility(0);
            }
            TextView textView = this.v;
            if (textView != null) {
                textView.setVisibility(0);
                this.v.setText(this.d.F());
                this.r.add(this.v);
            }
            TextView textView2 = this.w;
            if (textView2 != null) {
                textView2.setVisibility(0);
                this.w.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseSdkSplashAdView.2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Tracker.onClick(view);
                        l.b(n.a().g(), BaseSdkSplashAdView.this.d.H());
                    }
                });
            }
            TextView textView3 = this.x;
            if (textView3 != null) {
                textView3.setVisibility(0);
                this.x.setOnClickListener(new View.OnClickListener() { // from class: com.anythink.basead.ui.BaseSdkSplashAdView.3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Tracker.onClick(view);
                        l.b(n.a().g(), BaseSdkSplashAdView.this.d.I());
                    }
                });
            }
            TextView textView4 = this.y;
            if (textView4 != null) {
                textView4.setVisibility(0);
                this.y.setText(getContext().getResources().getString(h.a(getContext(), "myoffer_panel_version", "string"), this.d.G()));
                this.r.add(this.y);
            }
        } else {
            ViewGroup viewGroup2 = this.u;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(8);
            }
            TextView textView5 = this.y;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            TextView textView6 = this.v;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
            TextView textView7 = this.w;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
            TextView textView8 = this.x;
            if (textView8 != null) {
                textView8.setVisibility(8);
            }
            try {
                View findViewById = findViewById(h.a(getContext(), "myoffer_four_element_container_bg", "id"));
                if (findViewById != null) {
                    findViewById.setBackgroundDrawable(null);
                }
            } catch (Throwable th) {
            }
        }
        RoundImageView roundImageView = (RoundImageView) findViewById(h.a(getContext(), "myoffer_ad_logo", "id"));
        this.t = roundImageView;
        final ViewGroup.LayoutParams layoutParams = roundImageView.getLayoutParams();
        if (!TextUtils.isEmpty(this.d.v())) {
            this.t.setVisibility(0);
            int i = layoutParams.width;
            com.anythink.core.common.res.b.a(getContext()).a(new e(1, this.d.v()), i, i, new b.a() { // from class: com.anythink.basead.ui.BaseSdkSplashAdView.4
                @Override // com.anythink.core.common.res.b.a
                public final void onFail(String str, String str2) {
                    BaseSdkSplashAdView.this.t.setVisibility(8);
                }

                @Override // com.anythink.core.common.res.b.a
                public final void onSuccess(String str, Bitmap bitmap) {
                    if (TextUtils.equals(str, BaseSdkSplashAdView.this.d.v())) {
                        float width = (bitmap.getWidth() * 1.0f) / bitmap.getHeight();
                        int i2 = layoutParams.height;
                        layoutParams.width = (int) (i2 * width);
                        layoutParams.height = i2;
                        BaseSdkSplashAdView.this.t.setLayoutParams(layoutParams);
                        BaseSdkSplashAdView.this.t.setScaleType(ImageView.ScaleType.FIT_XY);
                        BaseSdkSplashAdView.this.t.setImageBitmap(bitmap);
                        BaseSdkSplashAdView.this.t.setVisibility(0);
                    }
                }
            });
        } else if (this.d.J() != null) {
            Bitmap J = this.d.J();
            float width = (J.getWidth() * 1.0f) / J.getHeight();
            int i2 = layoutParams.height;
            layoutParams.width = (int) (i2 * width);
            layoutParams.height = i2;
            this.t.setLayoutParams(layoutParams);
            this.t.setScaleType(ImageView.ScaleType.FIT_XY);
            this.t.setImageBitmap(J);
            this.t.setImageBitmap(this.d.J());
            this.t.setVisibility(0);
        } else {
            this.t.setVisibility(8);
        }
        this.r.add(this.t);
        q();
        r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseSplashAdView, com.anythink.basead.ui.BaseAdView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseSplashAdView, com.anythink.basead.ui.BaseAdView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.basead.ui.BaseSplashAdView
    public void p() {
        super.p();
        setOnClickListener(this.z);
    }
}
