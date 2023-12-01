package android.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.android.internal.R;

/* loaded from: source-9557208-dex2jar.jar:android/preference/PreferenceFrameLayout.class */
public class PreferenceFrameLayout extends FrameLayout {
    private static final int DEFAULT_BORDER_BOTTOM = 0;
    private static final int DEFAULT_BORDER_LEFT = 0;
    private static final int DEFAULT_BORDER_RIGHT = 0;
    private static final int DEFAULT_BORDER_TOP = 0;
    private final int mBorderBottom;
    private final int mBorderLeft;
    private final int mBorderRight;
    private final int mBorderTop;
    private boolean mPaddingApplied;

    /* loaded from: source-9557208-dex2jar.jar:android/preference/PreferenceFrameLayout$LayoutParams.class */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        public boolean removeBorders;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.removeBorders = false;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.removeBorders = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PreferenceFrameLayout_Layout);
            this.removeBorders = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
    }

    public PreferenceFrameLayout(Context context) {
        this(context, null);
    }

    public PreferenceFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 18219047);
    }

    public PreferenceFrameLayout(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreferenceFrameLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PreferenceFrameLayout, i, i2);
        float f = context.getResources().getDisplayMetrics().density;
        int i3 = (int) ((f * 0.0f) + 0.5f);
        int i4 = (int) ((f * 0.0f) + 0.5f);
        this.mBorderTop = obtainStyledAttributes.getDimensionPixelSize(0, i3);
        this.mBorderBottom = obtainStyledAttributes.getDimensionPixelSize(1, i4);
        this.mBorderLeft = obtainStyledAttributes.getDimensionPixelSize(2, (int) ((f * 0.0f) + 0.5f));
        this.mBorderRight = obtainStyledAttributes.getDimensionPixelSize(3, (int) ((f * 0.0f) + 0.5f));
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        LayoutParams layoutParams = view.getLayoutParams() instanceof LayoutParams ? (LayoutParams) view.getLayoutParams() : null;
        if (layoutParams == null || !layoutParams.removeBorders) {
            i = paddingBottom;
            i2 = paddingLeft;
            i3 = paddingRight;
            i4 = paddingTop;
            if (!this.mPaddingApplied) {
                i4 = paddingTop + this.mBorderTop;
                i = paddingBottom + this.mBorderBottom;
                i2 = paddingLeft + this.mBorderLeft;
                i3 = paddingRight + this.mBorderRight;
                this.mPaddingApplied = true;
            }
        } else {
            i = paddingBottom;
            i2 = paddingLeft;
            i3 = paddingRight;
            i4 = paddingTop;
            if (this.mPaddingApplied) {
                i4 = paddingTop - this.mBorderTop;
                i = paddingBottom - this.mBorderBottom;
                i2 = paddingLeft - this.mBorderLeft;
                i3 = paddingRight - this.mBorderRight;
                this.mPaddingApplied = false;
            }
        }
        int paddingTop2 = getPaddingTop();
        int paddingBottom2 = getPaddingBottom();
        int paddingLeft2 = getPaddingLeft();
        int paddingRight2 = getPaddingRight();
        if (paddingTop2 != i4 || paddingBottom2 != i || paddingLeft2 != i2 || paddingRight2 != i3) {
            setPadding(i2, i4, i3, i);
        }
        super.addView(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
