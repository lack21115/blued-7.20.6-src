package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/utils/widget/ImageFilterView.class */
public class ImageFilterView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    ViewOutlineProvider f2182a;
    RectF b;

    /* renamed from: c  reason: collision with root package name */
    Drawable[] f2183c;
    LayerDrawable d;
    float e;
    float f;
    float g;
    float h;
    private ImageMatrix i;
    private boolean j;
    private Drawable k;
    private Drawable l;
    private float m;
    private float n;
    private float o;
    private Path p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/utils/widget/ImageFilterView$ImageMatrix.class */
    public static class ImageMatrix {

        /* renamed from: a  reason: collision with root package name */
        float[] f2186a = new float[20];
        ColorMatrix b = new ColorMatrix();

        /* renamed from: c  reason: collision with root package name */
        ColorMatrix f2187c = new ColorMatrix();
        float d = 1.0f;
        float e = 1.0f;
        float f = 1.0f;
        float g = 1.0f;

        private void a(float f) {
            float f2 = 1.0f - f;
            float f3 = 0.2999f * f2;
            float f4 = 0.587f * f2;
            float f5 = f2 * 0.114f;
            float[] fArr = this.f2186a;
            fArr[0] = f3 + f;
            fArr[1] = f4;
            fArr[2] = f5;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f3;
            fArr[6] = f4 + f;
            fArr[7] = f5;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f3;
            fArr[11] = f4;
            fArr[12] = f5 + f;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void b(float f) {
            float log;
            float f2;
            float f3 = f;
            if (f <= 0.0f) {
                f3 = 0.01f;
            }
            float f4 = (5000.0f / f3) / 100.0f;
            if (f4 > 66.0f) {
                double d = f4 - 60.0f;
                f2 = ((float) Math.pow(d, -0.13320475816726685d)) * 329.69873f;
                log = ((float) Math.pow(d, 0.07551484555006027d)) * 288.12216f;
            } else {
                log = (((float) Math.log(f4)) * 99.4708f) - 161.11957f;
                f2 = 255.0f;
            }
            float log2 = f4 < 66.0f ? f4 > 19.0f ? (((float) Math.log(f4 - 10.0f)) * 138.51773f) - 305.0448f : 0.0f : 255.0f;
            float min = Math.min(255.0f, Math.max(f2, 0.0f));
            float min2 = Math.min(255.0f, Math.max(log, 0.0f));
            float min3 = Math.min(255.0f, Math.max(log2, 0.0f));
            float log3 = (float) Math.log(50.0f);
            float log4 = (float) Math.log(40.0f);
            float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float min5 = Math.min(255.0f, Math.max((log3 * 99.4708f) - 161.11957f, 0.0f));
            float f5 = min / min4;
            float f6 = min2 / min5;
            float min6 = min3 / Math.min(255.0f, Math.max((log4 * 138.51773f) - 305.0448f, 0.0f));
            float[] fArr = this.f2186a;
            fArr[0] = f5;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f6;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void c(float f) {
            float[] fArr = this.f2186a;
            fArr[0] = f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(ImageView imageView) {
            boolean z;
            this.b.reset();
            float f = this.e;
            if (f != 1.0f) {
                a(f);
                this.b.set(this.f2186a);
                z = true;
            } else {
                z = false;
            }
            float f2 = this.f;
            if (f2 != 1.0f) {
                this.f2187c.setScale(f2, f2, f2, 1.0f);
                this.b.postConcat(this.f2187c);
                z = true;
            }
            float f3 = this.g;
            if (f3 != 1.0f) {
                b(f3);
                this.f2187c.set(this.f2186a);
                this.b.postConcat(this.f2187c);
                z = true;
            }
            float f4 = this.d;
            if (f4 != 1.0f) {
                c(f4);
                this.f2187c.set(this.f2186a);
                this.b.postConcat(this.f2187c);
                z = true;
            }
            if (z) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.b));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public ImageFilterView(Context context) {
        super(context);
        this.i = new ImageMatrix();
        this.j = true;
        this.k = null;
        this.l = null;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = Float.NaN;
        this.f2183c = new Drawable[2];
        this.e = Float.NaN;
        this.f = Float.NaN;
        this.g = Float.NaN;
        this.h = Float.NaN;
        a(context, null);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = new ImageMatrix();
        this.j = true;
        this.k = null;
        this.l = null;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = Float.NaN;
        this.f2183c = new Drawable[2];
        this.e = Float.NaN;
        this.f = Float.NaN;
        this.g = Float.NaN;
        this.h = Float.NaN;
        a(context, attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = new ImageMatrix();
        this.j = true;
        this.k = null;
        this.l = null;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = Float.NaN;
        this.f2183c = new Drawable[2];
        this.e = Float.NaN;
        this.f = Float.NaN;
        this.g = Float.NaN;
        this.h = Float.NaN;
        a(context, attributeSet);
    }

    private void a() {
        if (Float.isNaN(this.e) && Float.isNaN(this.f) && Float.isNaN(this.g) && Float.isNaN(this.h)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            b();
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.k = obtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= indexCount) {
                    break;
                }
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.m = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_brightness) {
                    setBrightness(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_round) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                    }
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                    }
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.j));
                } else if (index == R.styleable.ImageFilterView_imagePanX) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.e));
                } else if (index == R.styleable.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.f));
                } else if (index == R.styleable.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.h));
                } else if (index == R.styleable.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.g));
                }
                i = i2 + 1;
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.l = drawable;
            if (this.k == null || drawable == null) {
                Drawable drawable2 = getDrawable();
                this.l = drawable2;
                if (drawable2 != null) {
                    Drawable[] drawableArr = this.f2183c;
                    Drawable mutate = drawable2.mutate();
                    this.l = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.f2183c;
            Drawable mutate2 = getDrawable().mutate();
            this.l = mutate2;
            drawableArr2[0] = mutate2;
            this.f2183c[1] = this.k.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.f2183c);
            this.d = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.m * 255.0f));
            if (!this.j) {
                this.d.getDrawable(0).setAlpha((int) ((1.0f - this.m) * 255.0f));
            }
            super.setImageDrawable(this.d);
        }
    }

    private void b() {
        if (Float.isNaN(this.e) && Float.isNaN(this.f) && Float.isNaN(this.g) && Float.isNaN(this.h)) {
            return;
        }
        float f = 0.0f;
        float f2 = Float.isNaN(this.e) ? 0.0f : this.e;
        float f3 = Float.isNaN(this.f) ? 0.0f : this.f;
        float f4 = Float.isNaN(this.g) ? 1.0f : this.g;
        if (!Float.isNaN(this.h)) {
            f = this.h;
        }
        Matrix matrix = new Matrix();
        matrix.reset();
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float width = getWidth();
        float height = getHeight();
        float f5 = f4 * (intrinsicWidth * height < intrinsicHeight * width ? width / intrinsicWidth : height / intrinsicHeight);
        matrix.postScale(f5, f5);
        float f6 = intrinsicWidth * f5;
        float f7 = f5 * intrinsicHeight;
        matrix.postTranslate((((f2 * (width - f6)) + width) - f6) * 0.5f, (((f3 * (height - f7)) + height) - f7) * 0.5f);
        matrix.postRotate(f, width / 2.0f, height / 2.0f);
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private void setOverlay(boolean z) {
        this.j = z;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        if (Build.VERSION.SDK_INT >= 21 || this.n == 0.0f || this.p == null) {
            z = false;
        } else {
            z = true;
            canvas.save();
            canvas.clipPath(this.p);
        }
        super.draw(canvas);
        if (z) {
            canvas.restore();
        }
    }

    public float getBrightness() {
        return this.i.d;
    }

    public float getContrast() {
        return this.i.f;
    }

    public float getCrossfade() {
        return this.m;
    }

    public float getImagePanX() {
        return this.e;
    }

    public float getImagePanY() {
        return this.f;
    }

    public float getImageRotate() {
        return this.h;
    }

    public float getImageZoom() {
        return this.g;
    }

    public float getRound() {
        return this.o;
    }

    public float getRoundPercent() {
        return this.n;
    }

    public float getSaturation() {
        return this.i.e;
    }

    public float getWarmth() {
        return this.i.g;
    }

    @Override // android.view.View
    public void layout(int i, int i2, int i3, int i4) {
        super.layout(i, i2, i3, i4);
        b();
    }

    public void setAltImageResource(int i) {
        Drawable mutate = AppCompatResources.getDrawable(getContext(), i).mutate();
        this.k = mutate;
        Drawable[] drawableArr = this.f2183c;
        drawableArr[0] = this.l;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f2183c);
        this.d = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.m);
    }

    public void setBrightness(float f) {
        this.i.d = f;
        this.i.a(this);
    }

    public void setContrast(float f) {
        this.i.f = f;
        this.i.a(this);
    }

    public void setCrossfade(float f) {
        this.m = f;
        if (this.f2183c != null) {
            if (!this.j) {
                this.d.getDrawable(0).setAlpha((int) ((1.0f - this.m) * 255.0f));
            }
            this.d.getDrawable(1).setAlpha((int) (this.m * 255.0f));
            super.setImageDrawable(this.d);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.k == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable mutate = drawable.mutate();
        this.l = mutate;
        Drawable[] drawableArr = this.f2183c;
        drawableArr[0] = mutate;
        drawableArr[1] = this.k;
        LayerDrawable layerDrawable = new LayerDrawable(this.f2183c);
        this.d = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.m);
    }

    public void setImagePanX(float f) {
        this.e = f;
        a();
    }

    public void setImagePanY(float f) {
        this.f = f;
        a();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        if (this.k == null) {
            super.setImageResource(i);
            return;
        }
        Drawable mutate = AppCompatResources.getDrawable(getContext(), i).mutate();
        this.l = mutate;
        Drawable[] drawableArr = this.f2183c;
        drawableArr[0] = mutate;
        drawableArr[1] = this.k;
        LayerDrawable layerDrawable = new LayerDrawable(this.f2183c);
        this.d = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.m);
    }

    public void setImageRotate(float f) {
        this.h = f;
        a();
    }

    public void setImageZoom(float f) {
        this.g = f;
        a();
    }

    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.o = f;
            float f2 = this.n;
            this.n = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.o != f;
        this.o = f;
        if (f != 0.0f) {
            if (this.p == null) {
                this.p = new Path();
            }
            if (this.b == null) {
                this.b = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f2182a == null) {
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterView.2
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.o);
                        }
                    };
                    this.f2182a = viewOutlineProvider;
                    setOutlineProvider(viewOutlineProvider);
                }
                setClipToOutline(true);
            }
            this.b.set(0.0f, 0.0f, getWidth(), getHeight());
            this.p.reset();
            Path path = this.p;
            RectF rectF = this.b;
            float f3 = this.o;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (!z || Build.VERSION.SDK_INT < 21) {
            return;
        }
        invalidateOutline();
    }

    public void setRoundPercent(float f) {
        boolean z = this.n != f;
        this.n = f;
        if (f != 0.0f) {
            if (this.p == null) {
                this.p = new Path();
            }
            if (this.b == null) {
                this.b = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f2182a == null) {
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterView.1
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            int width = ImageFilterView.this.getWidth();
                            int height = ImageFilterView.this.getHeight();
                            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * ImageFilterView.this.n) / 2.0f);
                        }
                    };
                    this.f2182a = viewOutlineProvider;
                    setOutlineProvider(viewOutlineProvider);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.n) / 2.0f;
            this.b.set(0.0f, 0.0f, width, height);
            this.p.reset();
            this.p.addRoundRect(this.b, min, min, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (!z || Build.VERSION.SDK_INT < 21) {
            return;
        }
        invalidateOutline();
    }

    public void setSaturation(float f) {
        this.i.e = f;
        this.i.a(this);
    }

    public void setWarmth(float f) {
        this.i.g = f;
        this.i.a(this);
    }
}
