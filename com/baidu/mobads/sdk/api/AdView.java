package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.ax;
import com.baidu.mobads.sdk.internal.bq;
import com.baidu.mobads.sdk.internal.co;
import com.baidu.mobads.sdk.internal.cp;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/AdView.class */
public final class AdView extends RelativeLayout {
    private static final boolean AUTOPLAY = true;
    private static final float HEIGHT_FACTOR = 0.15f;
    protected static final String P_VERSION = "3.61";
    private AtomicBoolean hasCalledRequestMethod;
    private cp mAdProd;

    public AdView(Context context) {
        super(context);
        this.hasCalledRequestMethod = new AtomicBoolean(false);
    }

    public AdView(Context context, AttributeSet attributeSet, boolean z, AdSize adSize, String str) {
        super(context, attributeSet);
        this.hasCalledRequestMethod = new AtomicBoolean(false);
        co coVar = new co(context);
        this.mAdProd = new cp(this, context, coVar, str, z);
        coVar.a(new co.a() { // from class: com.baidu.mobads.sdk.api.AdView.1
            @Override // com.baidu.mobads.sdk.internal.co.a
            public void onAttachedToWindow() {
                AdView.this.callRequest();
                AdView.this.mAdProd.o();
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            public void onDetachedFromWindow() {
                AdView.this.mAdProd.p();
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            public boolean onKeyDown(int i, KeyEvent keyEvent) {
                return AdView.this.mAdProd.a(i, keyEvent);
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            public void onLayoutComplete(int i, int i2) {
                AdView.this.callRequest();
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            public void onWindowFocusChanged(boolean z2) {
                AdView.this.mAdProd.a(z2);
            }

            @Override // com.baidu.mobads.sdk.internal.co.a
            public void onWindowVisibilityChanged(int i) {
                AdView.this.mAdProd.b(i);
            }
        });
        addView(coVar, new ViewGroup.LayoutParams(-1, -1));
    }

    public AdView(Context context, AdSize adSize, String str) {
        this(context, true, adSize, str);
    }

    public AdView(Context context, String str) {
        this(context, true, AdSize.Banner, str);
    }

    AdView(Context context, boolean z, AdSize adSize, String str) {
        this(context, null, z, adSize, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callRequest() {
        if (this.hasCalledRequestMethod.get()) {
            return;
        }
        this.hasCalledRequestMethod.set(true);
        this.mAdProd.a();
    }

    public void destroy() {
        cp cpVar = this.mAdProd;
        if (cpVar != null) {
            cpVar.e();
        }
    }

    public void setAppSid(String str) {
        cp cpVar = this.mAdProd;
        if (cpVar != null) {
            cpVar.g(str);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        int i;
        int i2;
        bq.a().a("AdView.setLayoutParams=", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
        int i3 = layoutParams.width;
        int i4 = layoutParams.height;
        DisplayMetrics f = ax.f(getContext());
        int i5 = f.widthPixels;
        int i6 = f.heightPixels;
        float f2 = f.density;
        bq.a().a("AdView.setLayoutParams", Integer.valueOf(i5), Integer.valueOf(i6), Float.valueOf(f2));
        if (i3 <= 0) {
            i = Math.min(i5, i6);
        } else {
            i = i3;
            if (i3 > 0) {
                float f3 = i3;
                float f4 = 200.0f * f2;
                i = i3;
                if (f3 < f4) {
                    i = (int) f4;
                }
            }
        }
        if (i4 <= 0) {
            i2 = (int) (Math.min(i5, i6) * HEIGHT_FACTOR);
        } else {
            i2 = i4;
            if (i4 > 0) {
                float f5 = i4;
                float f6 = f2 * 30.0f;
                i2 = i4;
                if (f5 < f6) {
                    i2 = (int) f6;
                }
            }
        }
        layoutParams.width = i;
        layoutParams.height = i2;
        cp cpVar = this.mAdProd;
        if (cpVar != null) {
            cpVar.a(i);
            this.mAdProd.c(i2);
        }
        bq.a().a("AdView.setLayoutParams adapter", Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height));
        super.setLayoutParams(layoutParams);
    }

    public void setListener(AdViewListener adViewListener) {
        cp cpVar = this.mAdProd;
        if (cpVar != null) {
            cpVar.a(adViewListener);
        }
    }
}
