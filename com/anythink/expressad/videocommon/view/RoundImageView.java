package com.anythink.expressad.videocommon.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.widget.ATImageView;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/view/RoundImageView.class */
public class RoundImageView extends ATImageView {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5935a = "RoundImageView";

    /* renamed from: c  reason: collision with root package name */
    private static final int f5936c = 0;
    private static final int d = 1;
    private static final int e = 5;
    private static final String m = "state_instance";
    private static final String n = "state_type";
    private static final String o = "state_border_radius";
    private int b;
    private int f;
    private Paint g;
    private int h;
    private Matrix i;
    private BitmapShader j;
    private int k;
    private RectF l;

    public RoundImageView(Context context) {
        super(context);
        this.i = new Matrix();
        Paint paint = new Paint();
        this.g = paint;
        paint.setAntiAlias(true);
        this.f = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.b = 1;
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new Matrix();
        Paint paint = new Paint();
        this.g = paint;
        paint.setAntiAlias(true);
        this.f = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.b = 1;
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new Matrix();
        Paint paint = new Paint();
        this.g = paint;
        paint.setAntiAlias(true);
        this.f = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.b = 1;
    }

    private static Bitmap a(Drawable drawable) {
        try {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable th) {
            o.d("View", th.getMessage());
            return null;
        }
    }

    private void a() {
        Bitmap a2;
        try {
            Drawable drawable = getDrawable();
            if (drawable == null || (a2 = a(drawable)) == null || a2.isRecycled()) {
                return;
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.j = new BitmapShader(a2, tileMode, tileMode);
            float f = 1.0f;
            if (this.b == 0) {
                f = (this.k * 1.0f) / Math.min(a2.getWidth(), a2.getHeight());
            } else if (this.b == 1) {
                f = Math.max((getWidth() * 1.0f) / a2.getWidth(), (getHeight() * 1.0f) / a2.getHeight());
            }
            this.i.setScale(f, f);
            this.j.setLocalMatrix(this.i);
            this.g.setShader(this.j);
        } catch (Throwable th) {
            o.d(f5935a, th.getMessage());
        }
    }

    @Override // com.anythink.expressad.widget.ATImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap a2;
        try {
            if (getDrawable() == null) {
                return;
            }
            Drawable drawable = getDrawable();
            if (drawable != null && (a2 = a(drawable)) != null && !a2.isRecycled()) {
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.j = new BitmapShader(a2, tileMode, tileMode);
                float f = 1.0f;
                if (this.b == 0) {
                    f = (this.k * 1.0f) / Math.min(a2.getWidth(), a2.getHeight());
                } else if (this.b == 1) {
                    f = Math.max((getWidth() * 1.0f) / a2.getWidth(), (getHeight() * 1.0f) / a2.getHeight());
                }
                this.i.setScale(f, f);
                this.j.setLocalMatrix(this.i);
                this.g.setShader(this.j);
            }
            if (this.b == 1) {
                canvas.drawRoundRect(this.l, this.f, this.f, this.g);
            } else {
                canvas.drawCircle(this.h, this.h, this.h, this.g);
            }
        } catch (Throwable th) {
            o.d(f5935a, th.getMessage());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.b == 0) {
            int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
            this.k = min;
            this.h = min / 2;
            setMeasuredDimension(min, min);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable(m));
        this.b = bundle.getInt(n);
        this.f = bundle.getInt(o);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(m, super.onSaveInstanceState());
        bundle.putInt(n, this.b);
        bundle.putInt(o, this.f);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.b == 1) {
            this.l = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        }
    }

    public void setBorderRadius(int i) {
        int b = t.b(getContext(), i);
        if (this.f != b) {
            this.f = b;
            invalidate();
        }
    }

    public void setType(int i) {
        if (this.b != i) {
            this.b = i;
            if (i != 1 && i != 0) {
                this.b = 0;
            }
            requestLayout();
        }
    }
}
