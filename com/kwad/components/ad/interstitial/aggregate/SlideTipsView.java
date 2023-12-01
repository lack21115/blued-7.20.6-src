package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.j.k;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/interstitial/aggregate/SlideTipsView.class */
public class SlideTipsView extends FrameLayout {
    public SlideTipsView(Context context) {
        this(context, null);
    }

    public SlideTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_SlideTipsView, i, 0);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.ksad_SlideTipsView_ksad_is_left_slide, true);
        obtainStyledAttributes.recycle();
        k.inflate(context, z ? R.layout.ksad_interstitial_left_slide_to_next : R.layout.ksad_interstitial_right_slide_to_return, this);
    }
}
