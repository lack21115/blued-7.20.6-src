package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.R;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/utils/widget/ImageFilterButton.class */
public class ImageFilterButton extends AppCompatImageButton {

    /* renamed from: a  reason: collision with root package name */
    ViewOutlineProvider f2178a;
    RectF b;

    /* renamed from: c  reason: collision with root package name */
    Drawable[] f2179c;
    LayerDrawable d;
    private ImageFilterView.ImageMatrix e;
    private float f;
    private float g;
    private float h;
    private Path i;
    private boolean j;
    private Drawable k;
    private Drawable l;
    private float m;
    private float n;
    private float o;
    private float p;

    public ImageFilterButton(Context context) {
        super(context);
        this.e = new ImageFilterView.ImageMatrix();
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = Float.NaN;
        this.f2179c = new Drawable[2];
        this.j = true;
        this.k = null;
        this.l = null;
        this.m = Float.NaN;
        this.n = Float.NaN;
        this.o = Float.NaN;
        this.p = Float.NaN;
        a(context, null);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new ImageFilterView.ImageMatrix();
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = Float.NaN;
        this.f2179c = new Drawable[2];
        this.j = true;
        this.k = null;
        this.l = null;
        this.m = Float.NaN;
        this.n = Float.NaN;
        this.o = Float.NaN;
        this.p = Float.NaN;
        a(context, attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new ImageFilterView.ImageMatrix();
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = Float.NaN;
        this.f2179c = new Drawable[2];
        this.j = true;
        this.k = null;
        this.l = null;
        this.m = Float.NaN;
        this.n = Float.NaN;
        this.o = Float.NaN;
        this.p = Float.NaN;
        a(context, attributeSet);
    }

    private void a() {
        if (Float.isNaN(this.m) && Float.isNaN(this.n) && Float.isNaN(this.o) && Float.isNaN(this.p)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            b();
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
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
                    this.f = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
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
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.m));
                } else if (index == R.styleable.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.n));
                } else if (index == R.styleable.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.p));
                } else if (index == R.styleable.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.o));
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
                    Drawable[] drawableArr = this.f2179c;
                    Drawable mutate = drawable2.mutate();
                    this.l = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.f2179c;
            Drawable mutate2 = getDrawable().mutate();
            this.l = mutate2;
            drawableArr2[0] = mutate2;
            this.f2179c[1] = this.k.mutate();
            LayerDrawable layerDrawable = new LayerDrawable(this.f2179c);
            this.d = layerDrawable;
            layerDrawable.getDrawable(1).setAlpha((int) (this.f * 255.0f));
            if (!this.j) {
                this.d.getDrawable(0).setAlpha((int) ((1.0f - this.f) * 255.0f));
            }
            super.setImageDrawable(this.d);
        }
    }

    private void b() {
        if (Float.isNaN(this.m) && Float.isNaN(this.n) && Float.isNaN(this.o) && Float.isNaN(this.p)) {
            return;
        }
        float f = 0.0f;
        float f2 = Float.isNaN(this.m) ? 0.0f : this.m;
        float f3 = Float.isNaN(this.n) ? 0.0f : this.n;
        float f4 = Float.isNaN(this.o) ? 1.0f : this.o;
        if (!Float.isNaN(this.p)) {
            f = this.p;
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
        if (Build.VERSION.SDK_INT >= 21 || this.h == 0.0f || this.i == null) {
            z = false;
        } else {
            z = true;
            canvas.save();
            canvas.clipPath(this.i);
        }
        super.draw(canvas);
        if (z) {
            canvas.restore();
        }
    }

    public float getContrast() {
        return this.e.f;
    }

    public float getCrossfade() {
        return this.f;
    }

    public float getImagePanX() {
        return this.m;
    }

    public float getImagePanY() {
        return this.n;
    }

    public float getImageRotate() {
        return this.p;
    }

    public float getImageZoom() {
        return this.o;
    }

    public float getRound() {
        return this.h;
    }

    public float getRoundPercent() {
        return this.g;
    }

    public float getSaturation() {
        return this.e.e;
    }

    public float getWarmth() {
        return this.e.g;
    }

    @Override // android.view.View
    public void layout(int i, int i2, int i3, int i4) {
        super.layout(i, i2, i3, i4);
        b();
    }

    public void setAltImageResource(int i) {
        Drawable mutate = AppCompatResources.getDrawable(getContext(), i).mutate();
        this.k = mutate;
        Drawable[] drawableArr = this.f2179c;
        drawableArr[0] = this.l;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f2179c);
        this.d = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f);
    }

    public void setBrightness(float f) {
        this.e.d = f;
        this.e.a(this);
    }

    public void setContrast(float f) {
        this.e.f = f;
        this.e.a(this);
    }

    public void setCrossfade(float f) {
        this.f = f;
        if (this.f2179c != null) {
            if (!this.j) {
                this.d.getDrawable(0).setAlpha((int) ((1.0f - this.f) * 255.0f));
            }
            this.d.getDrawable(1).setAlpha((int) (this.f * 255.0f));
            super.setImageDrawable(this.d);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.k == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        Drawable mutate = drawable.mutate();
        this.l = mutate;
        Drawable[] drawableArr = this.f2179c;
        drawableArr[0] = mutate;
        drawableArr[1] = this.k;
        LayerDrawable layerDrawable = new LayerDrawable(this.f2179c);
        this.d = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f);
    }

    public void setImagePanX(float f) {
        this.m = f;
        a();
    }

    public void setImagePanY(float f) {
        this.n = f;
        a();
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(int i) {
        if (this.k == null) {
            super.setImageResource(i);
            return;
        }
        Drawable mutate = AppCompatResources.getDrawable(getContext(), i).mutate();
        this.l = mutate;
        Drawable[] drawableArr = this.f2179c;
        drawableArr[0] = mutate;
        drawableArr[1] = this.k;
        LayerDrawable layerDrawable = new LayerDrawable(this.f2179c);
        this.d = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f);
    }

    public void setImageRotate(float f) {
        this.p = f;
        a();
    }

    public void setImageZoom(float f) {
        this.o = f;
        a();
    }

    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.h = f;
            float f2 = this.g;
            this.g = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.h != f;
        this.h = f;
        if (f != 0.0f) {
            if (this.i == null) {
                this.i = new Path();
            }
            if (this.b == null) {
                this.b = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f2178a == null) {
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterButton.2
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.h);
                        }
                    };
                    this.f2178a = viewOutlineProvider;
                    setOutlineProvider(viewOutlineProvider);
                }
                setClipToOutline(true);
            }
            this.b.set(0.0f, 0.0f, getWidth(), getHeight());
            this.i.reset();
            Path path = this.i;
            RectF rectF = this.b;
            float f3 = this.h;
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
        boolean z = this.g != f;
        this.g = f;
        if (f != 0.0f) {
            if (this.i == null) {
                this.i = new Path();
            }
            if (this.b == null) {
                this.b = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f2178a == null) {
                    ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.ImageFilterButton.1
                        @Override // android.view.ViewOutlineProvider
                        public void getOutline(View view, Outline outline) {
                            int width = ImageFilterButton.this.getWidth();
                            int height = ImageFilterButton.this.getHeight();
                            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * ImageFilterButton.this.g) / 2.0f);
                        }
                    };
                    this.f2178a = viewOutlineProvider;
                    setOutlineProvider(viewOutlineProvider);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.g) / 2.0f;
            this.b.set(0.0f, 0.0f, width, height);
            this.i.reset();
            this.i.addRoundRect(this.b, min, min, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (!z || Build.VERSION.SDK_INT < 21) {
            return;
        }
        invalidateOutline();
    }

    public void setSaturation(float f) {
        this.e.e = f;
        this.e.a(this);
    }

    public void setWarmth(float f) {
        this.e.g = f;
        this.e.a(this);
    }
}
