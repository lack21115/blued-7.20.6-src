package com.kwad.components.ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.kwad.sdk.widget.KSFrameLayout;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/widget/b.class */
public abstract class b extends KSFrameLayout {
    private Animator EH;
    private boolean EI;

    public b(Context context) {
        this(context, null, 0);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.EI = false;
        init(context, attributeSet, i);
        lb();
    }

    protected abstract int getAnimationDelayTime();

    protected abstract View getInteractionView();

    protected void init(Context context, AttributeSet attributeSet, int i) {
    }

    public final void kT() {
        Animator animator = this.EH;
        if (animator != null) {
            animator.cancel();
            this.EH = null;
        }
        Animator lt = lt();
        this.EH = lt;
        if (lt != null) {
            lt.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.b.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    b.this.lu();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (b.this.EI) {
                        return;
                    }
                    b.this.getInteractionView().postDelayed(new Runnable() { // from class: com.kwad.components.ad.splashscreen.widget.b.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.EH.start();
                        }
                    }, b.this.getAnimationDelayTime());
                }
            });
            this.EH.start();
        }
    }

    protected abstract void lb();

    protected abstract Animator lt();

    protected abstract void lu();

    public final void lv() {
        this.EI = true;
        Animator animator = this.EH;
        if (animator != null) {
            animator.cancel();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void onViewDetached() {
        super.onViewDetached();
        Animator animator = this.EH;
        if (animator != null) {
            animator.cancel();
        }
    }
}
