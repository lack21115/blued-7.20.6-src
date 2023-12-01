package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/graphics/drawable/RoundedBitmapDrawable.class */
public abstract class RoundedBitmapDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final Bitmap f2423a;

    /* renamed from: c  reason: collision with root package name */
    private int f2424c;
    private final BitmapShader f;
    private float h;
    private boolean k;
    private int l;
    private int m;
    private int d = 119;
    private final Paint e = new Paint(3);
    private final Matrix g = new Matrix();
    final Rect b = new Rect();
    private final RectF i = new RectF();
    private boolean j = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        this.f2424c = 160;
        if (resources != null) {
            this.f2424c = resources.getDisplayMetrics().densityDpi;
        }
        this.f2423a = bitmap;
        if (bitmap != null) {
            b();
            this.f = new BitmapShader(this.f2423a, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            return;
        }
        this.m = -1;
        this.l = -1;
        this.f = null;
    }

    private static boolean a(float f) {
        return f > 0.05f;
    }

    private void b() {
        this.l = this.f2423a.getScaledWidth(this.f2424c);
        this.m = this.f2423a.getScaledHeight(this.f2424c);
    }

    private void c() {
        this.h = Math.min(this.m, this.l) / 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (this.j) {
            if (this.k) {
                int min = Math.min(this.l, this.m);
                a(this.d, min, min, getBounds(), this.b);
                int min2 = Math.min(this.b.width(), this.b.height());
                this.b.inset(Math.max(0, (this.b.width() - min2) / 2), Math.max(0, (this.b.height() - min2) / 2));
                this.h = min2 * 0.5f;
            } else {
                a(this.d, this.l, this.m, getBounds(), this.b);
            }
            this.i.set(this.b);
            if (this.f != null) {
                this.g.setTranslate(this.i.left, this.i.top);
                this.g.preScale(this.i.width() / this.f2423a.getWidth(), this.i.height() / this.f2423a.getHeight());
                this.f.setLocalMatrix(this.g);
                this.e.setShader(this.f);
            }
            this.j = false;
        }
    }

    void a(int i, int i2, int i3, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f2423a;
        if (bitmap == null) {
            return;
        }
        a();
        if (this.e.getShader() == null) {
            canvas.drawBitmap(bitmap, (Rect) null, this.b, this.e);
            return;
        }
        RectF rectF = this.i;
        float f = this.h;
        canvas.drawRoundRect(rectF, f, f, this.e);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.e.getAlpha();
    }

    public final Bitmap getBitmap() {
        return this.f2423a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.e.getColorFilter();
    }

    public float getCornerRadius() {
        return this.h;
    }

    public int getGravity() {
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        int i = -3;
        if (this.d == 119) {
            if (this.k) {
                return -3;
            }
            Bitmap bitmap = this.f2423a;
            i = -3;
            if (bitmap != null) {
                i = -3;
                if (!bitmap.hasAlpha()) {
                    i = -3;
                    if (this.e.getAlpha() >= 255) {
                        if (a(this.h)) {
                            return -3;
                        }
                        i = -1;
                    }
                }
            }
        }
        return i;
    }

    public final Paint getPaint() {
        return this.e;
    }

    public boolean hasAntiAlias() {
        return this.e.isAntiAlias();
    }

    public boolean hasMipMap() {
        throw new UnsupportedOperationException();
    }

    public boolean isCircular() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.k) {
            c();
        }
        this.j = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.e.getAlpha()) {
            this.e.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setAntiAlias(boolean z) {
        this.e.setAntiAlias(z);
        invalidateSelf();
    }

    public void setCircular(boolean z) {
        this.k = z;
        this.j = true;
        if (!z) {
            setCornerRadius(0.0f);
            return;
        }
        c();
        this.e.setShader(this.f);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setCornerRadius(float f) {
        if (this.h == f) {
            return;
        }
        this.k = false;
        if (a(f)) {
            this.e.setShader(this.f);
        } else {
            this.e.setShader(null);
        }
        this.h = f;
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

    public void setGravity(int i) {
        if (this.d != i) {
            this.d = i;
            this.j = true;
            invalidateSelf();
        }
    }

    public void setMipMap(boolean z) {
        throw new UnsupportedOperationException();
    }

    public void setTargetDensity(int i) {
        if (this.f2424c != i) {
            int i2 = i;
            if (i == 0) {
                i2 = 160;
            }
            this.f2424c = i2;
            if (this.f2423a != null) {
                b();
            }
            invalidateSelf();
        }
    }

    public void setTargetDensity(Canvas canvas) {
        setTargetDensity(canvas.getDensity());
    }

    public void setTargetDensity(DisplayMetrics displayMetrics) {
        setTargetDensity(displayMetrics.densityDpi);
    }
}
