package com.soft.blued.ui.find.view;

import android.content.Context;
import android.util.AttributeSet;
import com.soft.blued.customview.FloatReddishBag;
import com.soft.blued.log.InstantLog;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/NearbyFloatReddishBag.class */
public class NearbyFloatReddishBag extends FloatReddishBag {
    public NearbyFloatReddishBag(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NearbyFloatReddishBag(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.soft.blued.customview.FloatReddishBag
    public void a() {
        InstantLog.a("nearby_hb_click");
    }

    @Override // com.soft.blued.customview.FloatReddishBag
    public void b() {
        InstantLog.a("nearby_hb_show");
    }
}
