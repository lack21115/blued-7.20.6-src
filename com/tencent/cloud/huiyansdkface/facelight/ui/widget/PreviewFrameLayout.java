package com.tencent.cloud.huiyansdkface.facelight.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.cloud.huiyansdkface.facelight.c.a.i;
import com.tencent.cloud.huiyansdkface.facelight.common.RotateSetting;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/widget/PreviewFrameLayout.class */
public class PreviewFrameLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.g.c f22081a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private double f22082c;
    private int d;
    private int e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private b i;
    private i j;

    public PreviewFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22082c = 1.3333333333333333d;
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        com.tencent.cloud.huiyansdkface.a.g.c cVar = new com.tencent.cloud.huiyansdkface.a.g.c(context.getApplicationContext());
        this.f22081a = cVar;
        addView(cVar, layoutParams);
        this.j = new i(context);
        ImageView imageView = new ImageView(context.getApplicationContext());
        this.g = imageView;
        imageView.setVisibility(8);
        addView(this.g, layoutParams);
        ImageView imageView2 = new ImageView(context.getApplicationContext());
        this.f = imageView2;
        imageView2.setVisibility(8);
        addView(this.f, layoutParams);
        ImageView imageView3 = new ImageView(context.getApplicationContext());
        this.h = imageView3;
        imageView3.setVisibility(8);
        addView(this.h, layoutParams);
        b bVar = new b(context.getApplicationContext());
        this.i = bVar;
        bVar.setVisibility(8);
        addView(this.i, layoutParams);
    }

    public RectF a(Rect rect) {
        boolean z;
        float left;
        float top;
        int videoRotate = RotateSetting.getVideoRotate();
        if (videoRotate == 0 || videoRotate == 180) {
            WLogger.d("PreviewFrameLayout", "PreviewFrameLayout landscape");
            z = true;
        } else {
            z = false;
        }
        float width = getWidth() / (z ? this.d : this.e);
        Matrix matrix = new Matrix();
        if (z) {
            float height = getHeight() / this.e;
            int left2 = (int) (getLeft() - (((getHeight() * this.f22082c) - getWidth()) / 2.0d));
            int top2 = getTop();
            matrix.postScale(height, height, 0.0f, 0.0f);
            left = left2;
            top = top2;
        } else {
            matrix.postScale(width, width, 0.0f, 0.0f);
            matrix.postScale(-1.0f, 1.0f, getWidth() / 2, getHeight() / 2);
            left = getLeft();
            top = getTop();
        }
        matrix.postTranslate(left, top);
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        return rectF;
    }

    public com.tencent.cloud.huiyansdkface.a.g.c a() {
        return this.f22081a;
    }

    public void a(int i, int i2) {
        this.d = i;
        this.e = i2;
        double d = i / i2;
        WLogger.d("PreviewFrameLayout", "setPreviewSize ratio=" + d);
        setAspectRatio(d);
    }

    public b b() {
        return this.i;
    }

    public void c() {
        this.h.setVisibility(0);
        this.h.setBackgroundColor(-1726803180);
    }

    public i getVirtualPreviewImp() {
        return this.j;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int paddingTop;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i3 = size - paddingLeft;
        int paddingTop2 = size2 - (getPaddingTop() + getPaddingBottom());
        boolean z = i3 > paddingTop2;
        int i4 = z ? i3 : paddingTop2;
        if (z) {
            i3 = paddingTop2;
        }
        double d = i4;
        double d2 = i3;
        double d3 = this.f22082c;
        if (d < d2 * d3) {
            i4 = (int) (d2 * d3);
        } else {
            i3 = (int) (d / d3);
        }
        int i5 = i4;
        int i6 = i3;
        if (z) {
            i6 = i4;
            i5 = i3;
        }
        float f = getContext().getResources().getDisplayMetrics().widthPixels * 0.72f;
        float f2 = this.b;
        if (f2 != 0.0f) {
            f = f2;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) f, 1073741824), View.MeasureSpec.makeMeasureSpec((int) ((i5 + paddingTop) * (f / (i6 + paddingLeft))), 1073741824));
    }

    public void setAspectRatio(double d) {
        WLogger.d("PreviewFrameLayout", "setAspectRatio ratio=" + d);
        if (d <= 0.0d) {
            throw new IllegalArgumentException();
        }
        if (this.f22082c != d) {
            this.f22082c = d;
            requestLayout();
        }
    }

    public void setBlurImageView(Bitmap bitmap) {
        this.g.setVisibility(0);
        this.g.setImageBitmap(bitmap);
    }

    public void setCamViewWidth(float f) {
        if (f < 0.0f) {
            this.b = 0.0f;
        } else {
            this.b = f;
        }
    }
}
