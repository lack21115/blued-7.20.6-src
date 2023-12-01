package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.utils.bk;
import com.kwad.sdk.utils.k;
import com.kwad.sdk.widget.j;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/view/AdBasePvFrameLayout.class */
public class AdBasePvFrameLayout extends AdBaseFrameLayout {
    private long aop;
    private float aoq;
    private boolean aor;
    private boolean aos;
    private ViewTreeObserver.OnScrollChangedListener aot;
    private ViewTreeObserver aou;
    private bk aov;
    private j cK;
    private int mA;

    public AdBasePvFrameLayout(Context context) {
        super(context);
        this.aop = 500L;
        this.aoq = 0.1f;
        this.aos = true;
        init();
    }

    public AdBasePvFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aop = 500L;
        this.aoq = 0.1f;
        this.aos = true;
        init();
    }

    public AdBasePvFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aop = 500L;
        this.aoq = 0.1f;
        this.aos = true;
        init();
    }

    private void init() {
        this.aov = new bk(this);
        this.mA = k.getScreenHeight(getContext());
        this.aos = true;
    }

    private void yN() {
        if (this.aos) {
            yO();
        }
    }

    private void yO() {
        if (yQ()) {
            yP();
        } else {
            yR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean yQ() {
        return this.aov.Fa() && ((float) Math.abs(this.aov.aBy.height() - getHeight())) <= ((float) getHeight()) * (1.0f - this.aoq) && getHeight() > 0 && getWidth() > 0 && this.aov.aBy.bottom > 0 && this.aov.aBy.top < this.mA;
    }

    private void yR() {
        if (this.aot == null) {
            this.aot = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.core.view.AdBasePvFrameLayout.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (AdBasePvFrameLayout.this.yQ()) {
                        AdBasePvFrameLayout.this.yP();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            this.aou = viewTreeObserver;
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.aot);
            }
        }
    }

    private void yS() {
        try {
            if (this.aot != null && this.aou != null && this.aou.isAlive()) {
                this.aou.removeOnScrollChangedListener(this.aot);
            }
            this.aot = null;
        } catch (Exception e) {
            b.printStackTrace(e);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        yR();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        yS();
        this.aor = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        boolean z = true;
        if (this.aor || (i3 | i4) != 0 || (i | i2) == 0) {
            z = false;
        } else {
            this.aor = true;
        }
        super.onSizeChanged(i, i2, i3, i4);
        if (z) {
            yN();
        }
    }

    public void setCheckDefaultImpressionLogThreshold(float f) {
        this.aoq = f;
    }

    public void setVisibleListener(j jVar) {
        this.cK = jVar;
    }

    protected final void yP() {
        yS();
        j jVar = this.cK;
        if (jVar != null) {
            jVar.aw();
        }
    }
}
