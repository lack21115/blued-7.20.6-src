package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8110460-dex2jar.jar:com/google/android/material/progressindicator/LinearProgressIndicator.class */
public final class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {
    public static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_LinearProgressIndicator;
    public static final int INDETERMINATE_ANIMATION_TYPE_CONTIGUOUS = 0;
    public static final int INDETERMINATE_ANIMATION_TYPE_DISJOINT = 1;
    public static final int INDICATOR_DIRECTION_END_TO_START = 3;
    public static final int INDICATOR_DIRECTION_LEFT_TO_RIGHT = 0;
    public static final int INDICATOR_DIRECTION_RIGHT_TO_LEFT = 1;
    public static final int INDICATOR_DIRECTION_START_TO_END = 2;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8110460-dex2jar.jar:com/google/android/material/progressindicator/LinearProgressIndicator$IndeterminateAnimationType.class */
    public @interface IndeterminateAnimationType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8110460-dex2jar.jar:com/google/android/material/progressindicator/LinearProgressIndicator$IndicatorDirection.class */
    public @interface IndicatorDirection {
    }

    public LinearProgressIndicator(Context context) {
        this(context, null);
    }

    public LinearProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, DEF_STYLE_RES);
        initializeDrawables();
    }

    private void initializeDrawables() {
        setIndeterminateDrawable(IndeterminateDrawable.createLinearDrawable(getContext(), (LinearProgressIndicatorSpec) this.spec));
        setProgressDrawable(DeterminateDrawable.createLinearDrawable(getContext(), (LinearProgressIndicatorSpec) this.spec));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public LinearProgressIndicatorSpec createSpec(Context context, AttributeSet attributeSet) {
        return new LinearProgressIndicatorSpec(context, attributeSet);
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.spec).indicatorDirection;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0040, code lost:
        if (((com.google.android.material.progressindicator.LinearProgressIndicatorSpec) r7.spec).indicatorDirection != 2) goto L7;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            super.onLayout(r1, r2, r3, r4, r5)
            r0 = r7
            S extends com.google.android.material.progressindicator.BaseProgressIndicatorSpec r0 = r0.spec
            com.google.android.material.progressindicator.LinearProgressIndicatorSpec r0 = (com.google.android.material.progressindicator.LinearProgressIndicatorSpec) r0
            r14 = r0
            r0 = r7
            S extends com.google.android.material.progressindicator.BaseProgressIndicatorSpec r0 = r0.spec
            com.google.android.material.progressindicator.LinearProgressIndicatorSpec r0 = (com.google.android.material.progressindicator.LinearProgressIndicatorSpec) r0
            int r0 = r0.indicatorDirection
            r9 = r0
            r0 = 1
            r13 = r0
            r0 = r13
            r8 = r0
            r0 = r9
            r1 = 1
            if (r0 == r1) goto L60
            r0 = r7
            int r0 = androidx.core.view.ViewCompat.getLayoutDirection(r0)
            r1 = 1
            if (r0 != r1) goto L43
            r0 = r13
            r8 = r0
            r0 = r7
            S extends com.google.android.material.progressindicator.BaseProgressIndicatorSpec r0 = r0.spec
            com.google.android.material.progressindicator.LinearProgressIndicatorSpec r0 = (com.google.android.material.progressindicator.LinearProgressIndicatorSpec) r0
            int r0 = r0.indicatorDirection
            r1 = 2
            if (r0 == r1) goto L60
        L43:
            r0 = r7
            int r0 = androidx.core.view.ViewCompat.getLayoutDirection(r0)
            if (r0 != 0) goto L5e
            r0 = r7
            S extends com.google.android.material.progressindicator.BaseProgressIndicatorSpec r0 = r0.spec
            com.google.android.material.progressindicator.LinearProgressIndicatorSpec r0 = (com.google.android.material.progressindicator.LinearProgressIndicatorSpec) r0
            int r0 = r0.indicatorDirection
            r1 = 3
            if (r0 != r1) goto L5e
            r0 = r13
            r8 = r0
            goto L60
        L5e:
            r0 = 0
            r8 = r0
        L60:
            r0 = r14
            r1 = r8
            r0.drawHorizontallyInverse = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.progressindicator.LinearProgressIndicator.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingLeft = i - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i2 - (getPaddingTop() + getPaddingBottom());
        IndeterminateDrawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        DeterminateDrawable progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    public void setIndeterminateAnimationType(int i) {
        if (((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType == i) {
            return;
        }
        if (visibleToUser() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        ((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType = i;
        ((LinearProgressIndicatorSpec) this.spec).validateSpec();
        if (i == 0) {
            getIndeterminateDrawable().setAnimatorDelegate(new LinearIndeterminateContiguousAnimatorDelegate((LinearProgressIndicatorSpec) this.spec));
        } else {
            getIndeterminateDrawable().setAnimatorDelegate(new LinearIndeterminateDisjointAnimatorDelegate(getContext(), (LinearProgressIndicatorSpec) this.spec));
        }
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(int... iArr) {
        super.setIndicatorColor(iArr);
        ((LinearProgressIndicatorSpec) this.spec).validateSpec();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0032, code lost:
        if (((com.google.android.material.progressindicator.LinearProgressIndicatorSpec) r3.spec).indicatorDirection != 2) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setIndicatorDirection(int r4) {
        /*
            r3 = this;
            r0 = r3
            S extends com.google.android.material.progressindicator.BaseProgressIndicatorSpec r0 = r0.spec
            com.google.android.material.progressindicator.LinearProgressIndicatorSpec r0 = (com.google.android.material.progressindicator.LinearProgressIndicatorSpec) r0
            r1 = r4
            r0.indicatorDirection = r1
            r0 = r3
            S extends com.google.android.material.progressindicator.BaseProgressIndicatorSpec r0 = r0.spec
            com.google.android.material.progressindicator.LinearProgressIndicatorSpec r0 = (com.google.android.material.progressindicator.LinearProgressIndicatorSpec) r0
            r7 = r0
            r0 = 1
            r6 = r0
            r0 = r6
            r5 = r0
            r0 = r4
            r1 = 1
            if (r0 == r1) goto L48
            r0 = r3
            int r0 = androidx.core.view.ViewCompat.getLayoutDirection(r0)
            r1 = 1
            if (r0 != r1) goto L35
            r0 = r6
            r5 = r0
            r0 = r3
            S extends com.google.android.material.progressindicator.BaseProgressIndicatorSpec r0 = r0.spec
            com.google.android.material.progressindicator.LinearProgressIndicatorSpec r0 = (com.google.android.material.progressindicator.LinearProgressIndicatorSpec) r0
            int r0 = r0.indicatorDirection
            r1 = 2
            if (r0 == r1) goto L48
        L35:
            r0 = r3
            int r0 = androidx.core.view.ViewCompat.getLayoutDirection(r0)
            if (r0 != 0) goto L46
            r0 = r4
            r1 = 3
            if (r0 != r1) goto L46
            r0 = r6
            r5 = r0
            goto L48
        L46:
            r0 = 0
            r5 = r0
        L48:
            r0 = r7
            r1 = r5
            r0.drawHorizontallyInverse = r1
            r0 = r3
            r0.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.progressindicator.LinearProgressIndicator.setIndicatorDirection(int):void");
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setProgressCompat(int i, boolean z) {
        if (this.spec != 0 && ((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType == 0 && isIndeterminate()) {
            return;
        }
        super.setProgressCompat(i, z);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int i) {
        super.setTrackCornerRadius(i);
        ((LinearProgressIndicatorSpec) this.spec).validateSpec();
        invalidate();
    }
}
