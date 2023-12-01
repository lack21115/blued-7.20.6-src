package com.scwang.smartrefresh.layout.internal;

import android.R;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalClassics;
import com.scwang.smartrefresh.layout.util.DensityUtil;

/* loaded from: source-8303388-dex2jar.jar:com/scwang/smartrefresh/layout/internal/InternalClassics.class */
public abstract class InternalClassics<T extends InternalClassics> extends InternalAbstract implements RefreshInternal {
    protected ImageView A;
    protected ImageView B;
    protected LinearLayout C;
    protected RefreshKernel D;
    protected PaintDrawable E;
    protected PaintDrawable F;
    protected Integer G;
    protected Integer H;
    protected int I;
    protected int J;
    protected int K;
    protected int L;
    protected int M;
    protected TextView z;

    public InternalClassics(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.J = 500;
        this.K = 20;
        this.L = 20;
        this.M = 0;
        this.x = SpinnerStyle.Translate;
        this.A = new ImageView(context);
        this.B = new ImageView(context);
        TextView textView = new TextView(context);
        this.z = textView;
        textView.setTextColor(-10066330);
        LinearLayout linearLayout = new LinearLayout(context);
        this.C = linearLayout;
        linearLayout.setGravity(1);
        this.C.setOrientation(1);
        ImageView imageView = this.A;
        TextView textView2 = this.z;
        ImageView imageView2 = this.B;
        LinearLayout linearLayout2 = this.C;
        DensityUtil densityUtil = new DensityUtil();
        textView2.setId(1);
        imageView.setId(2);
        imageView2.setId(3);
        linearLayout2.setId(R.id.widget_frame);
        linearLayout2.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(linearLayout2, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(densityUtil.b(20.0f), densityUtil.b(20.0f));
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, R.id.widget_frame);
        addView(imageView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((ViewGroup.LayoutParams) layoutParams2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(0, R.id.widget_frame);
        imageView2.animate().setInterpolator(new LinearInterpolator());
        addView(imageView2, layoutParams3);
        if (getPaddingTop() == 0) {
            if (getPaddingBottom() == 0) {
                int paddingLeft = getPaddingLeft();
                int b = densityUtil.b(20.0f);
                this.K = b;
                int paddingRight = getPaddingRight();
                int b2 = densityUtil.b(20.0f);
                this.L = b2;
                setPadding(paddingLeft, b, paddingRight, b2);
            } else {
                int paddingLeft2 = getPaddingLeft();
                int b3 = densityUtil.b(20.0f);
                this.K = b3;
                int paddingRight2 = getPaddingRight();
                int paddingBottom = getPaddingBottom();
                this.L = paddingBottom;
                setPadding(paddingLeft2, b3, paddingRight2, paddingBottom);
            }
        } else if (getPaddingBottom() == 0) {
            int paddingLeft3 = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.K = paddingTop;
            int paddingRight3 = getPaddingRight();
            int b4 = densityUtil.b(20.0f);
            this.L = b4;
            setPadding(paddingLeft3, paddingTop, paddingRight3, b4);
        } else {
            this.K = getPaddingTop();
            this.L = getPaddingBottom();
        }
        if (isInEditMode()) {
            imageView.setVisibility(8);
        } else {
            imageView2.setVisibility(8);
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int a(RefreshLayout refreshLayout, boolean z) {
        ImageView imageView = this.B;
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        } else {
            imageView.animate().rotation(0.0f).setDuration(0L);
        }
        imageView.setVisibility(8);
        return this.J;
    }

    protected T a() {
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void a(RefreshKernel refreshKernel, int i, int i2) {
        this.D = refreshKernel;
        refreshKernel.a(this, this.I);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void a(RefreshLayout refreshLayout, int i, int i2) {
        ImageView imageView = this.B;
        if (imageView.getVisibility() != 0) {
            imageView.setVisibility(0);
            Drawable drawable = this.B.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            } else {
                imageView.animate().rotation(36000.0f).setDuration(100000L);
            }
        }
    }

    public T b(int i) {
        this.G = Integer.valueOf(i);
        this.z.setTextColor(i);
        PaintDrawable paintDrawable = this.E;
        if (paintDrawable != null) {
            paintDrawable.a(i);
            this.A.invalidateDrawable(this.E);
        }
        PaintDrawable paintDrawable2 = this.F;
        if (paintDrawable2 != null) {
            paintDrawable2.a(i);
            this.B.invalidateDrawable(this.F);
        }
        return a();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void b(RefreshLayout refreshLayout, int i, int i2) {
        a(refreshLayout, i, i2);
    }

    public T c(int i) {
        Integer valueOf = Integer.valueOf(i);
        this.H = valueOf;
        this.I = valueOf.intValue();
        RefreshKernel refreshKernel = this.D;
        if (refreshKernel != null) {
            refreshKernel.a(this, this.H.intValue());
        }
        return a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT >= 14) {
            ImageView imageView = this.A;
            ImageView imageView2 = this.B;
            imageView.animate().cancel();
            imageView2.animate().cancel();
        }
        Drawable drawable = this.B.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            int size = View.MeasureSpec.getSize(i2);
            int i3 = this.M;
            if (size < i3) {
                int i4 = (size - i3) / 2;
                setPadding(getPaddingLeft(), i4, getPaddingRight(), i4);
            } else {
                setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
            }
        } else {
            setPadding(getPaddingLeft(), this.K, getPaddingRight(), this.L);
        }
        super.onMeasure(i, i2);
        if (this.M != 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= getChildCount()) {
                return;
            }
            int measuredHeight = getChildAt(i6).getMeasuredHeight();
            if (this.M < measuredHeight) {
                this.M = measuredHeight;
            }
            i5 = i6 + 1;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable) && this.H == null) {
                c(iArr[0]);
                this.H = null;
            }
            if (this.G == null) {
                if (iArr.length > 1) {
                    b(iArr[1]);
                }
                this.G = null;
            }
        }
    }
}
