package com.blued.android.module.live_china.view.roundimage;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.ImageView;
import com.blued.android.module.live_china.same.Logger;
import java.util.HashSet;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/roundimage/RoundedDrawable.class */
public class RoundedDrawable extends Drawable {
    private final Bitmap d;
    private final Paint e;
    private final int f;
    private final int g;
    private final Paint i;
    private final RectF a = new RectF();
    private final RectF b = new RectF();
    private final RectF c = new RectF();
    private final RectF h = new RectF();
    private final Matrix j = new Matrix();
    private final RectF k = new RectF();
    private Shader.TileMode l = Shader.TileMode.CLAMP;
    private Shader.TileMode m = Shader.TileMode.CLAMP;
    private boolean n = true;
    private float o = 0.0f;
    private final boolean[] p = {true, true, true, true};
    private boolean q = false;
    private float r = 0.0f;
    private ColorStateList s = ColorStateList.valueOf(View.MEASURED_STATE_MASK);
    private ImageView.ScaleType t = ImageView.ScaleType.FIT_CENTER;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.view.roundimage.RoundedDrawable$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/roundimage/RoundedDrawable$1.class */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0059 -> B:33:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005d -> B:43:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0061 -> B:39:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0065 -> B:35:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0069 -> B:31:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x006d -> B:41:0x004c). Please submit an issue!!! */
        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public RoundedDrawable(Bitmap bitmap) {
        this.d = bitmap;
        this.f = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.g = height;
        this.c.set(0.0f, 0.0f, this.f, height);
        Paint paint = new Paint();
        this.e = paint;
        paint.setStyle(Paint.Style.FILL);
        this.e.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.i.setAntiAlias(true);
        this.i.setColor(this.s.getColorForState(getState(), View.MEASURED_STATE_MASK));
        this.i.setStrokeWidth(this.r);
    }

    public static Drawable a(Drawable drawable) {
        RoundedDrawable roundedDrawable = drawable;
        if (drawable != null) {
            if (drawable instanceof RoundedDrawable) {
                return drawable;
            }
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= numberOfLayers) {
                        return layerDrawable;
                    }
                    layerDrawable.setDrawableByLayerId(layerDrawable.getId(i2), a(layerDrawable.getDrawable(i2)));
                    i = i2 + 1;
                }
            } else {
                Bitmap b = b(drawable);
                roundedDrawable = drawable;
                if (b != null) {
                    roundedDrawable = new RoundedDrawable(b);
                }
            }
        }
        return roundedDrawable;
    }

    public static RoundedDrawable a(Bitmap bitmap) {
        if (bitmap != null) {
            return new RoundedDrawable(bitmap);
        }
        return null;
    }

    private void a() {
        float width;
        float height;
        int i = AnonymousClass1.a[this.t.ordinal()];
        if (i == 1) {
            this.h.set(this.a);
            RectF rectF = this.h;
            float f = this.r;
            rectF.inset(f / 2.0f, f / 2.0f);
            this.j.reset();
            this.j.setTranslate((int) (((this.h.width() - this.f) * 0.5f) + 0.5f), (int) (((this.h.height() - this.g) * 0.5f) + 0.5f));
        } else if (i == 2) {
            this.h.set(this.a);
            RectF rectF2 = this.h;
            float f2 = this.r;
            rectF2.inset(f2 / 2.0f, f2 / 2.0f);
            this.j.reset();
            float f3 = 0.0f;
            if (this.f * this.h.height() > this.h.width() * this.g) {
                width = this.h.height() / this.g;
                f3 = (this.h.width() - (this.f * width)) * 0.5f;
                height = 0.0f;
            } else {
                width = this.h.width() / this.f;
                height = (this.h.height() - (this.g * width)) * 0.5f;
            }
            this.j.setScale(width, width);
            float f4 = this.r;
            this.j.postTranslate(((int) (f3 + 0.5f)) + (f4 / 2.0f), ((int) (height + 0.5f)) + (f4 / 2.0f));
        } else if (i == 3) {
            this.j.reset();
            float min = (((float) this.f) > this.a.width() || ((float) this.g) > this.a.height()) ? Math.min(this.a.width() / this.f, this.a.height() / this.g) : 1.0f;
            float width2 = (int) (((this.a.width() - (this.f * min)) * 0.5f) + 0.5f);
            float height2 = (int) (((this.a.height() - (this.g * min)) * 0.5f) + 0.5f);
            this.j.setScale(min, min);
            this.j.postTranslate(width2, height2);
            this.h.set(this.c);
            this.j.mapRect(this.h);
            RectF rectF3 = this.h;
            float f5 = this.r;
            rectF3.inset(f5 / 2.0f, f5 / 2.0f);
            this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
        } else if (i == 5) {
            this.h.set(this.c);
            this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.END);
            this.j.mapRect(this.h);
            RectF rectF4 = this.h;
            float f6 = this.r;
            rectF4.inset(f6 / 2.0f, f6 / 2.0f);
            this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
        } else if (i == 6) {
            this.h.set(this.c);
            this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.START);
            this.j.mapRect(this.h);
            RectF rectF5 = this.h;
            float f7 = this.r;
            rectF5.inset(f7 / 2.0f, f7 / 2.0f);
            this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
        } else if (i != 7) {
            this.h.set(this.c);
            this.j.setRectToRect(this.c, this.a, Matrix.ScaleToFit.CENTER);
            this.j.mapRect(this.h);
            RectF rectF6 = this.h;
            float f8 = this.r;
            rectF6.inset(f8 / 2.0f, f8 / 2.0f);
            this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
        } else {
            this.h.set(this.a);
            RectF rectF7 = this.h;
            float f9 = this.r;
            rectF7.inset(f9 / 2.0f, f9 / 2.0f);
            this.j.reset();
            this.j.setRectToRect(this.c, this.h, Matrix.ScaleToFit.FILL);
        }
        this.b.set(this.h);
    }

    private void a(Canvas canvas) {
        if (b(this.p) || this.o == 0.0f) {
            return;
        }
        float f = this.b.left;
        float f2 = this.b.top;
        float width = this.b.width() + f;
        float height = this.b.height() + f2;
        float f3 = this.o;
        if (!this.p[0]) {
            this.k.set(f, f2, f + f3, f2 + f3);
            canvas.drawRect(this.k, this.e);
        }
        if (!this.p[1]) {
            this.k.set(width - f3, f2, width, f3);
            canvas.drawRect(this.k, this.e);
        }
        if (!this.p[2]) {
            this.k.set(width - f3, height - f3, width, height);
            canvas.drawRect(this.k, this.e);
        }
        if (this.p[3]) {
            return;
        }
        this.k.set(f, height - f3, f3 + f, height);
        canvas.drawRect(this.k, this.e);
    }

    private static boolean a(boolean[] zArr) {
        int length = zArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (zArr[i2]) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static Bitmap b(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            Logger.c("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    private void b(Canvas canvas) {
        if (b(this.p) || this.o == 0.0f) {
            return;
        }
        float f = this.b.left;
        float f2 = this.b.top;
        float width = f + this.b.width();
        float height = f2 + this.b.height();
        float f3 = this.o;
        float f4 = this.r / 2.0f;
        if (!this.p[0]) {
            canvas.drawLine(f - f4, f2, f + f3, f2, this.i);
            canvas.drawLine(f, f2 - f4, f, f2 + f3, this.i);
        }
        if (!this.p[1]) {
            canvas.drawLine((width - f3) - f4, f2, width, f2, this.i);
            canvas.drawLine(width, f2 - f4, width, f2 + f3, this.i);
        }
        if (!this.p[2]) {
            canvas.drawLine((width - f3) - f4, height, width + f4, height, this.i);
            canvas.drawLine(width, height - f3, width, height, this.i);
        }
        if (this.p[3]) {
            return;
        }
        canvas.drawLine(f - f4, height, f + f3, height, this.i);
        canvas.drawLine(f, height - f3, f, height, this.i);
    }

    private static boolean b(boolean[] zArr) {
        int length = zArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (zArr[i2]) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public RoundedDrawable a(float f) {
        this.r = f;
        this.i.setStrokeWidth(f);
        return this;
    }

    public RoundedDrawable a(float f, float f2, float f3, float f4) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f));
        hashSet.add(Float.valueOf(f2));
        hashSet.add(Float.valueOf(f3));
        hashSet.add(Float.valueOf(f4));
        hashSet.remove(Float.valueOf(0.0f));
        if (hashSet.size() <= 1) {
            if (hashSet.isEmpty()) {
                this.o = 0.0f;
            } else {
                float floatValue = ((Float) hashSet.iterator().next()).floatValue();
                if (Float.isInfinite(floatValue) || Float.isNaN(floatValue) || floatValue < 0.0f) {
                    throw new IllegalArgumentException("Invalid radius value: " + floatValue);
                }
                this.o = floatValue;
            }
            this.p[0] = f > 0.0f;
            this.p[1] = f2 > 0.0f;
            this.p[2] = f3 > 0.0f;
            this.p[3] = f4 > 0.0f;
            return this;
        }
        throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
    }

    public RoundedDrawable a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.s = colorStateList;
        this.i.setColor(colorStateList.getColorForState(getState(), View.MEASURED_STATE_MASK));
        return this;
    }

    public RoundedDrawable a(Shader.TileMode tileMode) {
        if (this.l != tileMode) {
            this.l = tileMode;
            this.n = true;
            invalidateSelf();
        }
        return this;
    }

    public RoundedDrawable a(ImageView.ScaleType scaleType) {
        ImageView.ScaleType scaleType2 = scaleType;
        if (scaleType == null) {
            scaleType2 = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.t != scaleType2) {
            this.t = scaleType2;
            a();
        }
        return this;
    }

    public RoundedDrawable a(boolean z) {
        this.q = z;
        return this;
    }

    public RoundedDrawable b(Shader.TileMode tileMode) {
        if (this.m != tileMode) {
            this.m = tileMode;
            this.n = true;
            invalidateSelf();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.n) {
            BitmapShader bitmapShader = new BitmapShader(this.d, this.l, this.m);
            if (this.l == Shader.TileMode.CLAMP && this.m == Shader.TileMode.CLAMP) {
                bitmapShader.setLocalMatrix(this.j);
            }
            this.e.setShader(bitmapShader);
            this.n = false;
        }
        if (this.q) {
            if (this.r <= 0.0f) {
                canvas.drawOval(this.b, this.e);
                return;
            }
            canvas.drawOval(this.b, this.e);
            canvas.drawOval(this.h, this.i);
        } else if (!a(this.p)) {
            canvas.drawRect(this.b, this.e);
            if (this.r > 0.0f) {
                canvas.drawRect(this.h, this.i);
            }
        } else {
            float f = this.o;
            if (this.r <= 0.0f) {
                canvas.drawRoundRect(this.b, f, f, this.e);
                a(canvas);
                return;
            }
            canvas.drawRoundRect(this.b, f, f, this.e);
            canvas.drawRoundRect(this.h, f, f, this.i);
            a(canvas);
            b(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.e.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.e.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.s.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.a.set(rect);
        a();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.s.getColorForState(iArr, 0);
        if (this.i.getColor() != colorForState) {
            this.i.setColor(colorForState);
            return true;
        }
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.e.setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.e.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.e.setFilterBitmap(z);
        invalidateSelf();
    }
}
