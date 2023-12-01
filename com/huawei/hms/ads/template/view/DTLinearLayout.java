package com.huawei.hms.ads.template.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.LinearLayout;
import com.huawei.hms.ads.cc;
import com.huawei.hms.ads.ci;
import com.huawei.hms.ads.cq;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/template/view/DTLinearLayout.class */
public class DTLinearLayout extends LinearLayout implements a, b {
    private cc Code;
    private c V;

    public DTLinearLayout(Context context) {
        super(context);
        this.V = new c(this);
    }

    public DTLinearLayout(Context context, AttributeSet attributeSet) {
        super(context);
        this.V = new c(this);
        if (attributeSet != null) {
            cc ccVar = new cc(this);
            this.Code = ccVar;
            ccVar.Code((ci) new cq(this));
            this.Code.Code(attributeSet);
        }
    }

    @Override // com.huawei.hms.ads.template.view.a
    public void Code(JSONObject jSONObject) {
        cc ccVar = this.Code;
        if (ccVar != null) {
            ccVar.Code(jSONObject);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.V.Code(canvas);
        super.draw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Pair<Integer, Integer> Code = com.huawei.hms.ads.template.util.a.Code(attributeSet, getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Code.first.intValue(), Code.second.intValue());
        layoutParams.gravity = com.huawei.hms.ads.template.util.a.V(attributeSet.getAttributeValue(null, "layout_gravity"));
        layoutParams.weight = attributeSet.getAttributeFloatValue(null, "layout_weight", 0.0f);
        com.huawei.hms.ads.template.util.a.Code(getContext(), layoutParams, attributeSet);
        return layoutParams;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.V.Code(z, i, i2, i3, i4);
    }

    @Override // com.huawei.hms.ads.template.view.b
    public void setRectRoundCornerRadius(float f) {
        this.V.Code(f);
    }
}
