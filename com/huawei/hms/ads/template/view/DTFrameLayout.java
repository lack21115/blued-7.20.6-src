package com.huawei.hms.ads.template.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.FrameLayout;
import com.huawei.hms.ads.cc;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/template/view/DTFrameLayout.class */
public class DTFrameLayout extends FrameLayout implements a, b {
    private cc Code;
    private c V;

    public DTFrameLayout(Context context) {
        super(context);
        this.V = new c(this);
    }

    public DTFrameLayout(Context context, AttributeSet attributeSet) {
        super(context);
        this.V = new c(this);
        cc ccVar = new cc(this);
        this.Code = ccVar;
        ccVar.Code(attributeSet);
    }

    @Override // com.huawei.hms.ads.template.view.a
    public void Code(JSONObject jSONObject) {
        cc ccVar = this.Code;
        if (ccVar != null) {
            ccVar.Code(jSONObject);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void draw(Canvas canvas) {
        this.V.Code(canvas);
        super.draw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Pair<Integer, Integer> Code = com.huawei.hms.ads.template.util.a.Code(attributeSet, getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(Code.first.intValue(), Code.second.intValue());
        layoutParams.gravity = com.huawei.hms.ads.template.util.a.V(attributeSet.getAttributeValue(null, "layout_gravity"));
        com.huawei.hms.ads.template.util.a.Code(getContext(), layoutParams, attributeSet);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.V.Code(z, i, i2, i3, i4);
    }

    @Override // com.huawei.hms.ads.template.view.b
    public void setRectRoundCornerRadius(float f) {
        this.V.Code(f);
    }
}
