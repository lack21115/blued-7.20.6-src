package com.cmic.gen.sdk.tencent.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/view/LoadingImageView.class */
public class LoadingImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Animation f8094a;
    private LinearInterpolator b;

    public LoadingImageView(Context context) {
        super(context);
        this.f8094a = null;
        this.b = null;
        a();
    }

    public LoadingImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8094a = null;
        this.b = null;
        a();
    }

    public LoadingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8094a = null;
        this.b = null;
        a();
    }

    protected void a() {
        this.f8094a = AnimationUtils.loadAnimation(getContext(), c.c(getContext(), "umcsdk_anim_loading"));
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        this.b = linearInterpolator;
        this.f8094a.setInterpolator(linearInterpolator);
    }
}
