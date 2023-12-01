package com.huawei.openalliance.ad.augreality.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.em;
import com.huawei.hms.ads.en;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.views.AutoScaleSizeRelativeLayout;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/augreality/views/AugmentedRealityView.class */
public class AugmentedRealityView extends AutoScaleSizeRelativeLayout implements a {
    private static final String I = "AugmentedRealityView";
    private em B;
    protected Context Code;
    protected AdContentData V;

    public AugmentedRealityView(Context context) {
        super(context);
        Code(context);
    }

    public AugmentedRealityView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public AugmentedRealityView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
    }

    private void Code(Context context) {
        this.Code = context;
        LayoutInflater.from(context).inflate(R.layout.hiad_ar_view, this);
        this.B = new em(this.Code, this);
    }

    @Override // com.huawei.openalliance.ad.augreality.views.a
    public en getPresenter() {
        return this.B;
    }

    @Override // com.huawei.openalliance.ad.augreality.views.a
    public void setAdContentData(AdContentData adContentData) {
        if (adContentData != null) {
            if (this.V == null) {
                this.V = adContentData;
            }
            this.B.Code(this.V);
        }
    }
}
