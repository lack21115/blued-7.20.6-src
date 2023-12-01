package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;

/* loaded from: source-8110460-dex2jar.jar:com/google/android/material/snackbar/SnackbarContentLayout.class */
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {
    private Button actionView;
    private int maxInlineActionWidth;
    private TextView messageView;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static void updateTopBottomPadding(View view, int i, int i2) {
        if (ViewCompat.isPaddingRelative(view)) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i, ViewCompat.getPaddingEnd(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    private boolean updateViewsWithinLayout(int i, int i2, int i3) {
        boolean z;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.messageView.getPaddingTop() == i2 && this.messageView.getPaddingBottom() == i3) {
            return z;
        }
        updateTopBottomPadding(this.messageView, i2, i3);
        return true;
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentIn(int i, int i2) {
        this.messageView.setAlpha(0.0f);
        long j = i2;
        ViewPropertyAnimator duration = this.messageView.animate().alpha(1.0f).setDuration(j);
        long j2 = i;
        duration.setStartDelay(j2).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(0.0f);
            this.actionView.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentOut(int i, int i2) {
        this.messageView.setAlpha(1.0f);
        long j = i2;
        ViewPropertyAnimator duration = this.messageView.animate().alpha(0.0f).setDuration(j);
        long j2 = i;
        duration.setStartDelay(j2).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(1.0f);
            this.actionView.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    public Button getActionView() {
        return this.actionView;
    }

    public TextView getMessageView() {
        return this.messageView;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.messageView = (TextView) findViewById(R.id.snackbar_text);
        this.actionView = (Button) findViewById(R.id.snackbar_action);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0060, code lost:
        if (updateViewsWithinLayout(1, r10, r10 - r0) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007d, code lost:
        if (updateViewsWithinLayout(0, r10, r10) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0080, code lost:
        r9 = true;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r7, int r8) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r2 = r8
            super.onMeasure(r1, r2)
            r0 = r6
            android.content.res.Resources r0 = r0.getResources()
            int r1 = com.google.android.material.R.dimen.design_snackbar_padding_vertical_2lines
            int r0 = r0.getDimensionPixelSize(r1)
            r10 = r0
            r0 = r6
            android.content.res.Resources r0 = r0.getResources()
            int r1 = com.google.android.material.R.dimen.design_snackbar_padding_vertical
            int r0 = r0.getDimensionPixelSize(r1)
            r12 = r0
            r0 = r6
            android.widget.TextView r0 = r0.messageView
            android.text.Layout r0 = r0.getLayout()
            int r0 = r0.getLineCount()
            r9 = r0
            r0 = 0
            r11 = r0
            r0 = r9
            r1 = 1
            if (r0 <= r1) goto L36
            r0 = 1
            r9 = r0
            goto L38
        L36:
            r0 = 0
            r9 = r0
        L38:
            r0 = r9
            if (r0 == 0) goto L66
            r0 = r6
            int r0 = r0.maxInlineActionWidth
            if (r0 <= 0) goto L66
            r0 = r6
            android.widget.Button r0 = r0.actionView
            int r0 = r0.getMeasuredWidth()
            r1 = r6
            int r1 = r1.maxInlineActionWidth
            if (r0 <= r1) goto L66
            r0 = r11
            r9 = r0
            r0 = r6
            r1 = 1
            r2 = r10
            r3 = r10
            r4 = r12
            int r3 = r3 - r4
            boolean r0 = r0.updateViewsWithinLayout(r1, r2, r3)
            if (r0 == 0) goto L82
            goto L80
        L66:
            r0 = r9
            if (r0 == 0) goto L6d
            goto L71
        L6d:
            r0 = r12
            r10 = r0
        L71:
            r0 = r11
            r9 = r0
            r0 = r6
            r1 = 0
            r2 = r10
            r3 = r10
            boolean r0 = r0.updateViewsWithinLayout(r1, r2, r3)
            if (r0 == 0) goto L82
        L80:
            r0 = 1
            r9 = r0
        L82:
            r0 = r9
            if (r0 == 0) goto L8c
            r0 = r6
            r1 = r7
            r2 = r8
            super.onMeasure(r1, r2)
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }

    public void setMaxInlineActionWidth(int i) {
        this.maxInlineActionWidth = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateActionTextColorAlphaIfNeeded(float f) {
        if (f != 1.0f) {
            this.actionView.setTextColor(MaterialColors.layer(MaterialColors.getColor(this, R.attr.colorSurface), this.actionView.getCurrentTextColor(), f));
        }
    }
}
