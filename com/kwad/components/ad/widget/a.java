package com.kwad.components.ad.widget;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/widget/a.class */
public abstract class a implements ValueAnimator.AnimatorUpdateListener {
    private WeakReference<View> GI;

    public a(View view) {
        this.GI = new WeakReference<>(view);
    }

    public abstract void a(ViewGroup.LayoutParams layoutParams, Object obj);

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        WeakReference<View> weakReference = this.GI;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = this.GI.get();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        a(layoutParams, valueAnimator.getAnimatedValue());
        view.setLayoutParams(layoutParams);
    }
}
