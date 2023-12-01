package com.blued.android.module.live_china.view.shimmer;

import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/shimmer/ShimmerViewHelper.class */
public class ShimmerViewHelper {

    /* renamed from: a  reason: collision with root package name */
    private View f15459a;
    private Paint b;

    /* renamed from: c  reason: collision with root package name */
    private float f15460c;
    private LinearGradient d;
    private Matrix e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private AnimationSetupCallback j;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/shimmer/ShimmerViewHelper$AnimationSetupCallback.class */
    public interface AnimationSetupCallback {
        void a(View view);
    }

    public ShimmerViewHelper(View view, Paint paint, AttributeSet attributeSet) {
        this.f15459a = view;
        this.b = paint;
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        this.g = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.f15459a.getContext().obtainStyledAttributes(attributeSet, R.styleable.ShimmerView, 0, 0);
            try {
                if (obtainStyledAttributes != null) {
                    try {
                        this.g = obtainStyledAttributes.getColor(R.styleable.ShimmerView_reflectionColor, -1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.e = new Matrix();
    }

    private void g() {
        float f = -this.f15459a.getWidth();
        int i = this.f;
        LinearGradient linearGradient = new LinearGradient(f, 0.0f, 0.0f, 0.0f, new int[]{i, this.g, i}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP);
        this.d = linearGradient;
        this.b.setShader(linearGradient);
    }

    public float a() {
        return this.f15460c;
    }

    public void a(float f) {
        this.f15460c = f;
        this.f15459a.invalidate();
    }

    public void a(int i) {
        this.f = i;
        if (this.i) {
            g();
        }
    }

    public void a(AnimationSetupCallback animationSetupCallback) {
        this.j = animationSetupCallback;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void b(int i) {
        this.g = i;
        if (this.i) {
            g();
        }
    }

    public boolean b() {
        return this.i;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        g();
        if (this.i) {
            return;
        }
        this.i = true;
        AnimationSetupCallback animationSetupCallback = this.j;
        if (animationSetupCallback != null) {
            animationSetupCallback.a(this.f15459a);
        }
    }

    public void f() {
        if (!this.h) {
            this.b.setShader(null);
            return;
        }
        if (this.b.getShader() == null) {
            this.b.setShader(this.d);
        }
        this.e.setTranslate(this.f15460c * 2.0f, 0.0f);
        this.d.setLocalMatrix(this.e);
    }
}
