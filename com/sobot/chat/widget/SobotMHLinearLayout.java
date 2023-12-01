package com.sobot.chat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.sobot.chat.R;
import com.sobot.chat.utils.LogUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/SobotMHLinearLayout.class */
public class SobotMHLinearLayout extends LinearLayout {
    private static final float DEFAULT_MAX_HEIGHT = 0.0f;
    private static final float DEFAULT_MAX_H_RATIO = 1.0f;
    private static final float DEFAULT_MAX_V_RATIO = 0.8f;
    private float mMaxHHeight;
    private float mMaxHRatio;
    private float mMaxVHeight;
    private float mMaxVRatio;

    public SobotMHLinearLayout(Context context) {
        this(context, null);
    }

    public SobotMHLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SobotMHLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxVRatio = 0.8f;
        this.mMaxHRatio = 1.0f;
        initAttrs(context, attributeSet);
        this.mMaxVHeight = dip2px(context, 0.0f);
        this.mMaxHHeight = dip2px(context, 0.0f);
        init();
    }

    private int getHHeightSize(int i, int i2) {
        int i3 = i2;
        if (i == 1073741824) {
            float f = this.mMaxHHeight;
            i3 = ((float) i2) <= f ? i2 : (int) f;
        }
        int i4 = i3;
        if (i == 0) {
            float f2 = i3;
            float f3 = this.mMaxHHeight;
            i4 = f2 <= f3 ? i3 : (int) f3;
        }
        int i5 = i4;
        if (i == Integer.MIN_VALUE) {
            float f4 = i4;
            float f5 = this.mMaxHHeight;
            if (f4 <= f5) {
                return i4;
            }
            i5 = (int) f5;
        }
        return i5;
    }

    private int getScreenHeight(Context context) {
        return ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getHeight();
    }

    private int getVHeightSize(int i, int i2) {
        int i3 = i2;
        if (i == 1073741824) {
            float f = this.mMaxVHeight;
            i3 = ((float) i2) <= f ? i2 : (int) f;
        }
        int i4 = i3;
        if (i == 0) {
            float f2 = i3;
            float f3 = this.mMaxVHeight;
            i4 = f2 <= f3 ? i3 : (int) f3;
        }
        int i5 = i4;
        if (i == Integer.MIN_VALUE) {
            float f4 = i4;
            float f5 = this.mMaxVHeight;
            if (f4 <= f5) {
                return i4;
            }
            i5 = (int) f5;
        }
        return i5;
    }

    private void init() {
        float f = this.mMaxVHeight;
        if (f <= 0.0f) {
            this.mMaxVHeight = this.mMaxVRatio * getScreenHeight(getContext());
        } else {
            this.mMaxVHeight = Math.min(f, this.mMaxVRatio * getScreenHeight(getContext()));
        }
        float f2 = this.mMaxHHeight;
        if (f2 <= 0.0f) {
            this.mMaxHHeight = this.mMaxHRatio * getScreenHeight(getContext());
        } else {
            this.mMaxHHeight = Math.min(f2, this.mMaxHRatio * getScreenHeight(getContext()));
        }
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.sobot_MHLinearLayout);
        this.mMaxVRatio = obtainStyledAttributes.getFloat(R.styleable.sobot_MHLinearLayout_sobot_mhv_HeightRatio, 0.8f);
        this.mMaxVHeight = obtainStyledAttributes.getDimension(R.styleable.sobot_MHLinearLayout_sobot_mhv_HeightDimen, 0.0f);
        this.mMaxHRatio = obtainStyledAttributes.getFloat(R.styleable.sobot_MHLinearLayout_sobot_mhH_HeightRatio, 1.0f);
        this.mMaxHHeight = obtainStyledAttributes.getDimension(R.styleable.sobot_MHLinearLayout_sobot_mhH_HeightDimen, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public static boolean isScreenOriatationPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    public int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        View.MeasureSpec.getSize(i);
        LogUtils.e(size + "\t" + this.mMaxHHeight);
        int vHeightSize = isScreenOriatationPortrait(getContext()) ? getVHeightSize(mode, size) : getHHeightSize(mode, size);
        LogUtils.e(vHeightSize + "\t" + this.mMaxHHeight);
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(vHeightSize, Integer.MIN_VALUE));
    }
}
