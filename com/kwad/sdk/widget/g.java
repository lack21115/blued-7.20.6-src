package com.kwad.sdk.widget;

import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.utils.bk;
import com.kwad.sdk.utils.k;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/widget/g.class */
public final class g {
    private final i aDp;
    private boolean aDr;
    private boolean aDs;
    private ViewTreeObserver.OnScrollChangedListener aDu;
    private final bk aov;
    private final int mA;
    private final View mView;
    private float aDq = 0.1f;
    private boolean aDt = true;

    public g(View view, i iVar) {
        this.mView = view;
        this.aDp = iVar;
        this.aov = new bk(view);
        this.mA = k.getScreenHeight(view.getContext());
    }

    private void FC() {
        if (FD()) {
            aw();
            return;
        }
        yS();
        yR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FD() {
        return this.aov.Fa() && ((float) Math.abs(this.aov.aBy.height() - this.mView.getHeight())) <= ((float) this.mView.getHeight()) * (1.0f - this.aDq) && this.mView.getHeight() > 0 && this.mView.getWidth() > 0 && this.aov.aBy.bottom > 0 && this.aov.aBy.top < this.mA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aw() {
        yS();
        i iVar = this.aDp;
        if (iVar != null) {
            iVar.onFirstVisible(this.mView);
        }
    }

    private void yN() {
        if (this.aDt) {
            FC();
        }
    }

    private void yR() {
        if (this.aDu == null) {
            this.aDu = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.g.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (g.this.FD()) {
                        g.this.aw();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.aDu);
            }
        }
    }

    private void yS() {
        if (this.aDu == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.aDu);
            }
            this.aDu = null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
        }
    }

    public final void FB() {
        if (this.aDs) {
            yN();
        }
    }

    public final void b(int i, int i2, int i3, int i4) {
        this.aDs = false;
        if (this.aDr || (i3 | i4) != 0 || (i | i2) == 0) {
            return;
        }
        this.aDs = true;
        this.aDr = true;
    }

    public final void bJ(boolean z) {
        this.aDt = z;
    }

    public final float getVisiblePercent() {
        return this.aDq;
    }

    public final void onAttachedToWindow() {
        yR();
    }

    public final void onDetachedFromWindow() {
        yS();
        this.aDr = false;
    }

    public final void resetPvAfterDataChange() {
        FC();
    }

    public final void setVisiblePercent(float f) {
        this.aDq = f;
    }
}
