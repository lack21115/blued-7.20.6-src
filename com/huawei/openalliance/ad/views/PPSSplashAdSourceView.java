package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.gz;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.l;
import com.huawei.openalliance.ad.utils.v;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSSplashAdSourceView.class */
public class PPSSplashAdSourceView extends RelativeLayout {
    private Integer B;
    private Integer C;
    private PPSSplashLabelView Code;
    private gz I;
    private TextView V;

    public PPSSplashAdSourceView(Context context) {
        super(context, null);
    }

    public PPSSplashAdSourceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PPSSplashAdSourceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public PPSSplashAdSourceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
    }

    private void Code(int i, int i2, boolean z, int i3, int i4, RelativeLayout.LayoutParams layoutParams) {
        int I;
        layoutParams.addRule(10);
        layoutParams.addRule(21);
        layoutParams.rightMargin = i3;
        layoutParams.setMarginEnd(i3);
        layoutParams.topMargin = i4;
        if (i2 != 0) {
            layoutParams.topMargin += i;
            return;
        }
        if (!z) {
            layoutParams.setMarginEnd(layoutParams.rightMargin + i);
            layoutParams.rightMargin += i;
        }
        if (dt.V(getContext())) {
            layoutParams.setMarginEnd(layoutParams.rightMargin + ay.I(getContext()));
            I = layoutParams.rightMargin + ay.I(getContext());
        } else {
            layoutParams.setMarginEnd(ay.I(getContext()));
            I = ay.I(getContext());
        }
        layoutParams.rightMargin = I;
        layoutParams.topMargin += v.V(getContext(), 12.0f);
    }

    private void Code(Context context) {
        inflate(context, getRootLayoutId(), this);
        PPSSplashLabelView pPSSplashLabelView = (PPSSplashLabelView) findViewById(R.id.hiad_ad_label);
        this.Code = pPSSplashLabelView;
        pPSSplashLabelView.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.hiad_ad_source);
        this.V = textView;
        textView.setVisibility(8);
    }

    private void Code(AdContentData adContentData) {
        PPSSplashLabelView pPSSplashLabelView;
        int i;
        String n = adContentData.n();
        MetaData Z = adContentData.Z();
        AdSource Code = (Z == null || Z.i() == null) ? null : AdSource.Code(Z.i());
        if (TextUtils.isEmpty(n)) {
            pPSSplashLabelView = this.Code;
            i = 8;
        } else {
            this.Code.Code(Code, n, this.B, this.C, this.I);
            pPSSplashLabelView = this.Code;
            i = 0;
        }
        pPSSplashLabelView.setVisibility(i);
    }

    private void Code(boolean z, int i, int i2, boolean z2, int i3, int i4, RelativeLayout.LayoutParams layoutParams) {
        layoutParams.addRule(12);
        layoutParams.addRule(20);
        layoutParams.leftMargin = i3;
        layoutParams.setMarginStart(i3);
        layoutParams.bottomMargin = i4;
        if (i2 == 0) {
            if (dt.V(getContext()) && z2) {
                layoutParams.setMarginStart(layoutParams.leftMargin + i);
                layoutParams.leftMargin += i;
            } else if (!dt.V(getContext()) || (dt.V(getContext()) && TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1)) {
                layoutParams.setMarginStart(ay.I(getContext()));
                layoutParams.leftMargin = ay.I(getContext());
            }
            if (z) {
                return;
            }
            if (!l.B(getContext()) && !l.S(getContext())) {
                return;
            }
        } else if (z) {
            return;
        }
        layoutParams.bottomMargin += ay.I(getContext());
    }

    public static boolean Code(Context context, Integer num, Integer num2) {
        if (!dt.Code(context).V() || num == null || num2 == null) {
            return false;
        }
        if ((num.intValue() == 1 || num.intValue() == 4) && (num2.intValue() == 2 || num2.intValue() == 3)) {
            return true;
        }
        if (num.intValue() == 2 || num.intValue() == 3) {
            return num2.intValue() == 1 || num2.intValue() == 3;
        }
        return false;
    }

    private void V(AdContentData adContentData) {
        TextView textView;
        int i;
        MetaData Z = adContentData.Z();
        if (Z == null || this.V == null) {
            return;
        }
        String V = au.V(Z.F());
        if (TextUtils.isEmpty(V)) {
            textView = this.V;
            i = 8;
        } else {
            this.V.setText(V);
            textView = this.V;
            i = 0;
        }
        textView.setVisibility(i);
    }

    public void Code(AdContentData adContentData, boolean z, int i, int i2, boolean z2) {
        Code(getContext());
        String o = adContentData.o() == null ? "ll" : adContentData.o();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.hiad_splash_label_side_margin);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.hiad_splash_label_side_margin);
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if ("tr".equals(o)) {
                Code(i, i2, z2, dimensionPixelSize, dimensionPixelSize2, layoutParams2);
            } else {
                Code(z, i, i2, z2, dimensionPixelSize, dimensionPixelSize2, layoutParams2);
            }
            setLayoutParams(layoutParams2);
        }
        Code(adContentData);
        V(adContentData);
    }

    public void Code(Integer num, Integer num2) {
        this.B = num;
        this.C = num2;
    }

    protected int getRootLayoutId() {
        return Code(getContext(), this.B, this.C) ? R.layout.hiad_splash_ad_source_with_click : R.layout.hiad_splash_ad_source;
    }

    public void setAdMediator(gz gzVar) {
        this.I = gzVar;
    }
}
