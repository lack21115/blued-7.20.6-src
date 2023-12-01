package com.huawei.hms.ads.template.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.cc;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/template/view/DTRelativeLayout.class */
public class DTRelativeLayout extends RelativeLayout implements a, b {
    private cc Code;
    private c V;

    public DTRelativeLayout(Context context) {
        super(context);
        this.V = new c(this);
    }

    public DTRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context);
        this.V = new c(this);
        cc ccVar = new cc(this);
        this.Code = ccVar;
        ccVar.Code(attributeSet);
    }

    private void Code(AttributeSet attributeSet, RelativeLayout.LayoutParams layoutParams) {
        if (attributeSet.getAttributeBooleanValue(null, "layout_centerInParent", false)) {
            layoutParams.addRule(13);
        }
        if (attributeSet.getAttributeBooleanValue(null, "layout_centerVertical", false)) {
            layoutParams.addRule(15);
        }
        if (attributeSet.getAttributeBooleanValue(null, "layout_centerHorizontal", false)) {
            layoutParams.addRule(14);
        }
        if (attributeSet.getAttributeBooleanValue(null, "layout_alignParentTop", false)) {
            layoutParams.addRule(10);
        }
        if (attributeSet.getAttributeBooleanValue(null, "layout_alignParentBottom", false)) {
            layoutParams.addRule(12);
        }
        if (attributeSet.getAttributeBooleanValue(null, "layout_alignParentLeft", false)) {
            layoutParams.addRule(9);
        }
        if (attributeSet.getAttributeBooleanValue(null, "layout_alignParentRight", false)) {
            layoutParams.addRule(11);
        }
        if (attributeSet.getAttributeBooleanValue(null, "layout_alignParentStart", false)) {
            layoutParams.addRule(20);
        }
        if (attributeSet.getAttributeBooleanValue(null, "layout_alignParentEnd", false)) {
            layoutParams.addRule(21);
        }
    }

    private void Code(RelativeLayout.LayoutParams layoutParams, int i, int i2) {
        layoutParams.addRule(i, com.huawei.hms.ads.template.util.a.Code(i2));
    }

    private void V(AttributeSet attributeSet, RelativeLayout.LayoutParams layoutParams) {
        String attributeValue = attributeSet.getAttributeValue(null, "layout_toRightOf");
        if (!TextUtils.isEmpty(attributeValue)) {
            Code(layoutParams, 1, attributeValue.hashCode());
        }
        String attributeValue2 = attributeSet.getAttributeValue(null, "layout_toLeftOf");
        if (!TextUtils.isEmpty(attributeValue2)) {
            Code(layoutParams, 0, attributeValue2.hashCode());
        }
        String attributeValue3 = attributeSet.getAttributeValue(null, "layout_toStartOf");
        if (!TextUtils.isEmpty(attributeValue3)) {
            Code(layoutParams, 16, attributeValue3.hashCode());
        }
        String attributeValue4 = attributeSet.getAttributeValue(null, "layout_toEndOf");
        if (!TextUtils.isEmpty(attributeValue4)) {
            Code(layoutParams, 17, attributeValue4.hashCode());
        }
        String attributeValue5 = attributeSet.getAttributeValue(null, "layout_above");
        if (!TextUtils.isEmpty(attributeValue5)) {
            Code(layoutParams, 2, attributeValue5.hashCode());
        }
        String attributeValue6 = attributeSet.getAttributeValue(null, "layout_below");
        if (!TextUtils.isEmpty(attributeValue6)) {
            Code(layoutParams, 3, attributeValue6.hashCode());
        }
        String attributeValue7 = attributeSet.getAttributeValue(null, "layout_alignStart");
        if (!TextUtils.isEmpty(attributeValue7)) {
            Code(layoutParams, 18, attributeValue7.hashCode());
        }
        String attributeValue8 = attributeSet.getAttributeValue(null, "layout_alignEnd");
        if (!TextUtils.isEmpty(attributeValue8)) {
            Code(layoutParams, 19, attributeValue8.hashCode());
        }
        String attributeValue9 = attributeSet.getAttributeValue(null, "layout_alignLeft");
        if (!TextUtils.isEmpty(attributeValue9)) {
            Code(layoutParams, 5, attributeValue9.hashCode());
        }
        String attributeValue10 = attributeSet.getAttributeValue(null, "layout_alignRight");
        if (!TextUtils.isEmpty(attributeValue10)) {
            Code(layoutParams, 7, attributeValue10.hashCode());
        }
        String attributeValue11 = attributeSet.getAttributeValue(null, "layout_alignTop");
        if (!TextUtils.isEmpty(attributeValue11)) {
            Code(layoutParams, 6, attributeValue11.hashCode());
        }
        String attributeValue12 = attributeSet.getAttributeValue(null, "layout_alignBottom");
        if (!TextUtils.isEmpty(attributeValue12)) {
            Code(layoutParams, 8, attributeValue12.hashCode());
        }
        String attributeValue13 = attributeSet.getAttributeValue(null, "layout_alignBaseline");
        if (TextUtils.isEmpty(attributeValue13)) {
            return;
        }
        Code(layoutParams, 4, attributeValue13.hashCode());
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

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Pair<Integer, Integer> Code = com.huawei.hms.ads.template.util.a.Code(attributeSet, getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Code.first.intValue(), Code.second.intValue());
        Code(attributeSet, layoutParams);
        V(attributeSet, layoutParams);
        com.huawei.hms.ads.template.util.a.Code(getContext(), layoutParams, attributeSet);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.V.Code(z, i, i2, i3, i4);
    }

    @Override // com.huawei.hms.ads.template.view.b
    public void setRectRoundCornerRadius(float f) {
        this.V.Code(f);
    }
}
