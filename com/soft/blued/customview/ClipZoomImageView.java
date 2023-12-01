package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.blued.android.core.imagecache.MemoryRequest;
import com.soft.blued.utils.Logger;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/ClipZoomImageView.class */
public class ClipZoomImageView extends AppCompatImageView implements ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {
    private float d;
    private boolean e;
    private final float[] f;
    private ScaleGestureDetector g;
    private final Matrix h;
    private GestureDetector i;
    private boolean j;
    private int k;
    private float l;
    private float m;
    private boolean n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private static final String b = ClipZoomImageView.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public static float f28392a = 4.0f;

    /* renamed from: c  reason: collision with root package name */
    private static float f28393c = 2.0f;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/ClipZoomImageView$AutoScaleRunnable.class */
    class AutoScaleRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ClipZoomImageView f28395a;
        private float b;

        /* renamed from: c  reason: collision with root package name */
        private float f28396c;
        private float d;
        private float e;

        @Override // java.lang.Runnable
        public void run() {
            Matrix matrix = this.f28395a.h;
            float f = this.f28396c;
            matrix.postScale(f, f, this.d, this.e);
            this.f28395a.b();
            ClipZoomImageView clipZoomImageView = this.f28395a;
            clipZoomImageView.setImageMatrix(clipZoomImageView.h);
            float scale = this.f28395a.getScale();
            if ((this.f28396c > 1.0f && scale < this.b) || (this.f28396c < 1.0f && this.b < scale)) {
                this.f28395a.postDelayed(this, 16L);
                return;
            }
            float f2 = this.b / scale;
            this.f28395a.h.postScale(f2, f2, this.d, this.e);
            this.f28395a.b();
            ClipZoomImageView clipZoomImageView2 = this.f28395a;
            clipZoomImageView2.setImageMatrix(clipZoomImageView2.h);
            this.f28395a.j = false;
        }
    }

    public ClipZoomImageView(Context context) {
        this(context, null);
    }

    public ClipZoomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 1.0f;
        this.e = true;
        this.f = new float[9];
        this.g = null;
        this.h = new Matrix();
        this.r = true;
        setScaleType(ImageView.ScaleType.MATRIX);
        this.i = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.soft.blued.customview.ClipZoomImageView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                return true;
            }
        });
        this.g = new ScaleGestureDetector(context, this);
        setOnTouchListener(this);
    }

    private boolean a(float f, float f2) {
        return Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        float f;
        RectF matrixRectF = getMatrixRectF();
        int width = getWidth();
        int height = getHeight();
        Logger.e(b, "rect.width() =  ", Float.valueOf(matrixRectF.width()), " , width - 2 * mHorizontalPadding =", Integer.valueOf(width - (this.p * 2)));
        float f2 = 0.0f;
        if (matrixRectF.width() + 0.01d >= width - (this.p * 2)) {
            f = matrixRectF.left > ((float) this.p) ? (-matrixRectF.left) + this.p : 0.0f;
            float f3 = matrixRectF.right;
            int i = this.p;
            if (f3 < width - i) {
                f = (width - i) - matrixRectF.right;
            }
        } else {
            f = 0.0f;
        }
        if (matrixRectF.height() + 0.01d >= height - (this.q * 2)) {
            f2 = 0.0f;
            if (matrixRectF.top > this.q) {
                f2 = (-matrixRectF.top) + this.q;
            }
            float f4 = matrixRectF.bottom;
            int i2 = this.q;
            if (f4 < height - i2) {
                f2 = (height - i2) - matrixRectF.bottom;
            }
        }
        this.h.postTranslate(f, f2);
    }

    private RectF getMatrixRectF() {
        Matrix matrix = this.h;
        RectF rectF = new RectF();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(rectF);
        }
        return rectF;
    }

    public Bitmap a() {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
            draw(new Canvas(createBitmap));
            try {
                return this.r ? Bitmap.createBitmap(createBitmap, this.p, this.q, getWidth() - (this.p * 2), getWidth() - (this.p * 2)) : Bitmap.createBitmap(createBitmap, this.p, this.q, getWidth() - (this.p * 2), getHeight() - (this.q * 2));
            } catch (OutOfMemoryError e) {
                MemoryRequest.a().b();
                return createBitmap;
            }
        } catch (OutOfMemoryError e2) {
            MemoryRequest.a().b();
            return null;
        }
    }

    public final float getScale() {
        this.h.getValues(this.f);
        return this.f[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Drawable drawable;
        if (!this.e || (drawable = getDrawable()) == null) {
            return;
        }
        if (this.q == 0) {
            this.q = (getHeight() - (getWidth() - (this.p * 2))) / 2;
        }
        int width = getWidth();
        int height = getHeight();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float width2 = (intrinsicWidth >= getWidth() - (this.p * 2) || intrinsicHeight <= getHeight() - (this.q * 2)) ? 1.0f : ((getWidth() * 1.0f) - (this.p * 2)) / intrinsicWidth;
        float f = width2;
        if (intrinsicHeight < getHeight() - (this.q * 2)) {
            f = width2;
            if (intrinsicWidth > getWidth() - (this.p * 2)) {
                f = ((getHeight() * 1.0f) - (this.q * 2)) / intrinsicHeight;
            }
        }
        this.d = f;
        f28393c = 2.0f * f;
        f28392a = 4.0f * f;
        this.h.postTranslate((width - intrinsicWidth) / 2, (height - intrinsicHeight) / 2);
        this.h.postScale(f, f, getWidth() / 2, getHeight() / 2);
        setImageMatrix(this.h);
        this.e = false;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scale = getScale();
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (getDrawable() == null) {
            return true;
        }
        if ((scale >= f28392a || scaleFactor <= 1.0f) && (scale <= this.d || scaleFactor >= 1.0f)) {
            return true;
        }
        float f = this.d;
        float f2 = scaleFactor;
        if (scaleFactor * scale < f) {
            f2 = f / scale;
        }
        float f3 = f28392a;
        float f4 = f2;
        if (f2 * scale > f3) {
            f4 = f3 / scale;
        }
        this.h.postScale(f4, f4, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        b();
        setImageMatrix(this.h);
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            if (this.i.onTouchEvent(motionEvent)) {
                return true;
            }
            this.g.onTouchEvent(motionEvent);
            int pointerCount = motionEvent.getPointerCount();
            float f = 0.0f;
            float f2 = 0.0f;
            for (int i = 0; i < pointerCount; i++) {
                f += motionEvent.getX(i);
                f2 += motionEvent.getY(i);
            }
            float f3 = pointerCount;
            float f4 = f / f3;
            float f5 = f2 / f3;
            if (pointerCount != this.o) {
                this.n = false;
                this.l = f4;
                this.m = f5;
            }
            this.o = pointerCount;
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2) {
                    float f6 = f4 - this.l;
                    float f7 = f5 - this.m;
                    if (!this.n) {
                        this.n = a(f6, f7);
                    }
                    if (this.n && getDrawable() != null) {
                        RectF matrixRectF = getMatrixRectF();
                        if (matrixRectF.width() <= getWidth() - (this.p * 2)) {
                            f6 = 0.0f;
                        }
                        if (matrixRectF.height() <= getHeight() - (this.q * 2)) {
                            f7 = 0.0f;
                        }
                        this.h.postTranslate(f6, f7);
                        b();
                        setImageMatrix(this.h);
                    }
                    this.l = f4;
                    this.m = f5;
                    return true;
                } else if (action != 3) {
                    return true;
                }
            }
            this.o = 0;
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    public void setHorizontalPadding(int i) {
        this.p = i;
    }

    public void setVerticalPadding(int i) {
        this.q = i;
        this.r = false;
    }
}
