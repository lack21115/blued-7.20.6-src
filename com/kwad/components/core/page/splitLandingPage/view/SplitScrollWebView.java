package com.kwad.components.core.page.splitLandingPage.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.kwad.components.core.r.d;
import com.kwad.sdk.core.webview.KsAdWebView;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/splitLandingPage/view/SplitScrollWebView.class */
public class SplitScrollWebView extends KsAdWebView {
    private int MQ;
    private boolean Nn;
    private a No;
    private float Np;
    private boolean Nq;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/page/splitLandingPage/view/SplitScrollWebView$a.class */
    public interface a {
        void d(float f);

        boolean oR();
    }

    public SplitScrollWebView(Context context) {
        super(context);
        this.Nn = false;
        oL();
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Nn = false;
        oL();
    }

    public SplitScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Nn = false;
        oL();
    }

    private void oL() {
        this.MQ = 0;
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.MQ != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(((getContext() instanceof Activity ? com.kwad.sdk.c.kwai.a.d((Activity) getContext()) : com.kwad.sdk.c.kwai.a.getScreenHeight(getContext())) - (d.pO() ? com.kwad.sdk.c.kwai.a.getStatusBarHeight(getContext()) : 0)) - this.MQ, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0082, code lost:
        if (r4.Nq != false) goto L28;
     */
    @Override // android.webkit.WebView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            r0 = r5
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r0)
            r11 = r0
            r0 = r4
            boolean r0 = r0.Nn
            if (r0 == 0) goto L14
            r0 = r4
            r1 = r11
            boolean r0 = super.onTouchEvent(r1)
            return r0
        L14:
            r0 = r5
            int r0 = androidx.core.view.MotionEventCompat.getActionMasked(r0)
            r8 = r0
            r0 = r5
            float r0 = r0.getY()
            r6 = r0
            r0 = 0
            r10 = r0
            r0 = r8
            if (r0 == 0) goto L9c
            r0 = r8
            r1 = 1
            if (r0 == r1) goto L64
            r0 = r8
            r1 = 2
            if (r0 == r1) goto L3b
            r0 = r8
            r1 = 3
            if (r0 == r1) goto L64
            r0 = 0
            return r0
        L3b:
            r0 = r4
            float r0 = r0.Np
            r7 = r0
            r0 = r4
            com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView$a r0 = r0.No
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L5d
            r0 = r6
            r1 = r7
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L5d
            r0 = r4
            r1 = 1
            r0.Nq = r1
            r0 = r5
            r1 = r7
            r2 = r6
            float r1 = r1 - r2
            r0.d(r1)
        L5d:
            r0 = r4
            r1 = r11
            boolean r0 = super.onTouchEvent(r1)
            return r0
        L64:
            r0 = r10
            r9 = r0
            r0 = r4
            com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView$a r0 = r0.No
            if (r0 == 0) goto Lad
            r0 = r4
            float r0 = r0.Np
            r1 = r6
            float r0 = r0 - r1
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L85
            r0 = r10
            r9 = r0
            r0 = r4
            boolean r0 = r0.Nq
            if (r0 == 0) goto Lad
        L85:
            r0 = r10
            r9 = r0
            r0 = r4
            com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView$a r0 = r0.No
            boolean r0 = r0.oR()
            if (r0 == 0) goto Lad
            r0 = r4
            r1 = 1
            r0.Nn = r1
            r0 = 0
            return r0
        L9c:
            r0 = r4
            r1 = r6
            r0.Np = r1
            r0 = r4
            r1 = 0
            r0.Nq = r1
            r0 = r4
            r1 = r5
            boolean r0 = super.onTouchEvent(r1)
            r9 = r0
        Lad:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setDisableAnimation(boolean z) {
        this.Nn = z;
    }

    public void setSplitScrollWebViewListener(a aVar) {
        this.No = aVar;
    }
}
