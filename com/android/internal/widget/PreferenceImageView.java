package com.android.internal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/widget/PreferenceImageView.class */
public class PreferenceImageView extends ImageView {
    public PreferenceImageView(Context context) {
        this(context, null);
    }

    public PreferenceImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreferenceImageView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreferenceImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (r0 == 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
        if (r0 == 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0073, code lost:
        if (r0 == 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0011, code lost:
        if (r0 == 0) goto L19;
     */
    @Override // android.widget.ImageView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r5, int r6) {
        /*
            r4 = this;
            r0 = r5
            int r0 = android.view.View.MeasureSpec.getMode(r0)
            r8 = r0
            r0 = r8
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r1) goto L14
            r0 = r5
            r7 = r0
            r0 = r8
            if (r0 != 0) goto L3f
        L14:
            r0 = r5
            int r0 = android.view.View.MeasureSpec.getSize(r0)
            r9 = r0
            r0 = r4
            int r0 = r0.getMaxWidth()
            r10 = r0
            r0 = r5
            r7 = r0
            r0 = r10
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L3f
            r0 = r10
            r1 = r9
            if (r0 < r1) goto L37
            r0 = r5
            r7 = r0
            r0 = r8
            if (r0 != 0) goto L3f
        L37:
            r0 = r10
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r7 = r0
        L3f:
            r0 = r6
            int r0 = android.view.View.MeasureSpec.getMode(r0)
            r8 = r0
            r0 = r8
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r1) goto L53
            r0 = r6
            r5 = r0
            r0 = r8
            if (r0 != 0) goto L7e
        L53:
            r0 = r6
            int r0 = android.view.View.MeasureSpec.getSize(r0)
            r9 = r0
            r0 = r4
            int r0 = r0.getMaxHeight()
            r10 = r0
            r0 = r6
            r5 = r0
            r0 = r10
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L7e
            r0 = r10
            r1 = r9
            if (r0 < r1) goto L76
            r0 = r6
            r5 = r0
            r0 = r8
            if (r0 != 0) goto L7e
        L76:
            r0 = r10
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r5 = r0
        L7e:
            r0 = r4
            r1 = r7
            r2 = r5
            super.onMeasure(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.widget.PreferenceImageView.onMeasure(int, int):void");
    }
}
