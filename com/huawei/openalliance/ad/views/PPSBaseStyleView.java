package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.ad.utils.ay;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSBaseStyleView.class */
public class PPSBaseStyleView extends RelativeLayout {
    protected boolean B;
    protected int C;
    protected View Code;
    protected TextView I;
    protected TextView V;

    public PPSBaseStyleView(Context context) {
        super(context);
        this.C = 1;
    }

    public PPSBaseStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.C = 1;
    }

    public PPSBaseStyleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.C = 1;
    }

    protected void Code() {
        if (this.B || this.C != 1) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.bottomMargin += ay.I(getContext());
            setLayoutParams(layoutParams2);
        }
    }

    public void Code(String str, String str2) {
        if (this.V != null && !TextUtils.isEmpty(str)) {
            this.V.setText(str);
        }
        if (this.I == null || TextUtils.isEmpty(str2)) {
            return;
        }
        this.I.setText(str2);
    }

    public void setOrientation(int i) {
        this.C = i;
    }

    public void setShowLogo(boolean z) {
        this.B = z;
        Code();
    }
}
