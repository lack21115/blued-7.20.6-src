package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.gz;
import com.huawei.hms.ads.splash.ChoicesView;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.l;
import com.huawei.openalliance.ad.utils.v;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSWLSView.class */
public class PPSWLSView extends RelativeLayout {
    private ChoicesView B;
    private gz C;
    private Integer D;
    private Integer F;
    private TextView I;
    private View.OnClickListener L;
    private WeakReference<PPSLinkedView> S;
    private PPSSplashLabelView V;

    public PPSWLSView(Context context) {
        super(context, null);
        Code(context);
    }

    public PPSWLSView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public PPSWLSView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
    }

    public PPSWLSView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        Code(context);
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

    private void Code(AdContentData adContentData) {
        MetaData Z = adContentData.Z();
        if (Z != null) {
            String V = au.V(Z.F());
            if (TextUtils.isEmpty(V)) {
                this.I.setVisibility(8);
                return;
            }
            this.I.setText(V);
            this.I.setVisibility(0);
            I(adContentData.o());
        }
    }

    private void Code(AdContentData adContentData, String str) {
        PPSSplashLabelView pPSSplashLabelView;
        V(str);
        String n = adContentData.n();
        int i = 0;
        if (TextUtils.isEmpty(n)) {
            ViewGroup.LayoutParams layoutParams = this.V.getLayoutParams();
            layoutParams.width = 0;
            this.V.setLayoutParams(layoutParams);
            pPSSplashLabelView = this.V;
            i = 4;
        } else {
            this.V.Code(null, n, this.F, this.D, this.C);
            pPSSplashLabelView = this.V;
        }
        pPSSplashLabelView.setVisibility(i);
    }

    private void Code(String str) {
        Resources resources = getResources();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.B.getLayoutParams();
        if ("tr".equals(str)) {
            layoutParams.addRule(10);
            layoutParams.addRule(21);
            layoutParams.setMarginStart(resources.getDimensionPixelSize(R.dimen.hiad_8_dp));
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(20);
            layoutParams.setMarginEnd(resources.getDimensionPixelSize(R.dimen.hiad_8_dp));
        }
        this.B.setLayoutParams(layoutParams);
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

    private void I(String str) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.I.getLayoutParams();
        layoutParams.addRule(6, R.id.hiad_ad_label_wls);
        layoutParams.addRule(8, R.id.hiad_ad_label_wls);
        layoutParams.addRule("tr".equals(str) ? 16 : 17, R.id.hiad_ad_label_wls);
        this.I.setLayoutParams(layoutParams);
    }

    private void V(final AdContentData adContentData, String str) {
        Code(str);
        String V = au.V(adContentData.X());
        String V2 = au.V(adContentData.Y());
        if (!TextUtils.isEmpty(V)) {
            if (TextUtils.isEmpty(V2)) {
                this.B.I();
            } else {
                this.B.setAdChoiceIcon(V2);
            }
        }
        this.B.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.views.PPSWLSView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (ge.Code()) {
                    ge.Code("PPSWLSView", "choiceView onclick");
                }
                if (PPSWLSView.this.L != null) {
                    PPSWLSView.this.L.onClick(view);
                    return;
                }
                String V3 = au.V(adContentData.X());
                String str2 = V3;
                if (TextUtils.isEmpty(V3)) {
                    str2 = au.V(adContentData.W());
                }
                if (v.Code(PPSWLSView.this.getContext(), str2)) {
                    if (PPSWLSView.this.C != null) {
                        PPSWLSView.this.C.Z();
                    }
                    if (PPSWLSView.this.getPpsLinkedView() != null) {
                        PPSWLSView.this.getPpsLinkedView().Code((Integer) 10, true);
                    }
                }
            }
        });
    }

    private void V(String str) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.V.getLayoutParams();
        layoutParams.addRule(15);
        layoutParams.addRule("tr".equals(str) ? 16 : 17, R.id.splash_why_this_ad);
        this.V.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PPSLinkedView getPpsLinkedView() {
        WeakReference<PPSLinkedView> weakReference = this.S;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public void Code(Context context) {
        inflate(context, R.layout.hiad_wls_view, this);
        ChoicesView choicesView = (ChoicesView) findViewById(R.id.splash_why_this_ad);
        this.B = choicesView;
        choicesView.setVisibility(8);
        PPSSplashLabelView pPSSplashLabelView = (PPSSplashLabelView) findViewById(R.id.hiad_ad_label_wls);
        this.V = pPSSplashLabelView;
        pPSSplashLabelView.setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.hiad_ad_source_wls);
        this.I = textView;
        textView.setVisibility(8);
    }

    public void Code(AdContentData adContentData, boolean z, int i, int i2, boolean z2) {
        ge.V("PPSWLSView", "positionAndSet. ");
        String o = adContentData.o() == null ? "ll" : adContentData.o();
        this.B.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Resources resources = getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.hiad_splash_wls_side_margin);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.hiad_splash_wls_vertical_margin);
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if ("tr".equals(o)) {
                Code(i, i2, z2, dimensionPixelSize, dimensionPixelSize2, layoutParams2);
            } else {
                Code(z, i, i2, z2, dimensionPixelSize, dimensionPixelSize2, layoutParams2);
            }
            setLayoutParams(layoutParams2);
        }
        V(adContentData, o);
        Code(adContentData, o);
        Code(adContentData);
    }

    public void Code(Integer num, Integer num2) {
        this.F = num;
        this.D = num2;
    }

    public int[] getChoiceViewLoc() {
        return ay.I(this.B);
    }

    public int[] getChoiceViewSize() {
        return ay.Z(this.B);
    }

    public void setAdMediator(gz gzVar) {
        this.C = gzVar;
    }

    public void setChoiceViewOnClickListener(View.OnClickListener onClickListener) {
        this.L = onClickListener;
    }

    public void setPpsLinkedView(PPSLinkedView pPSLinkedView) {
        this.S = new WeakReference<>(pPSLinkedView);
    }
}
