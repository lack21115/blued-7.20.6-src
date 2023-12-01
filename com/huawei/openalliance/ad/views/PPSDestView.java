package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.huawei.hms.ads.hr;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSDestView.class */
public class PPSDestView extends FrameLayout implements hr {
    public PPSDestView(Context context) {
        super(context);
    }

    public PPSDestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PPSDestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.huawei.hms.ads.hr
    public View getOpenMeasureView() {
        return this;
    }
}
