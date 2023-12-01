package com.soft.blued.customview.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;
import com.blued.android.core.imagecache.drawable.IRecyclingDrawable;
import com.blued.android.core.imagecache.drawable.RecyclingBitmapDrawable;
import com.soft.blued.utils.Logger;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/drawable/XRoundedDrawable.class */
public class XRoundedDrawable extends Drawable implements IRecyclingDrawable {

    /* renamed from: a  reason: collision with root package name */
    private String f28576a;
    private Set<RecyclingBitmapDrawable> b;
    private float e;
    private float f;
    private float g;
    private float h;
    private final BitmapShader j;
    private final Paint k;
    private final int l;
    private final int m;
    private final Paint o;
    private int p;
    private int q;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f28577c = new RectF();
    private final RectF d = new RectF();
    private final RectF i = new RectF();
    private final RectF n = new RectF();
    private ImageView.ScaleType r = ImageView.ScaleType.FIT_XY;
    private final Matrix s = new Matrix();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.customview.drawable.XRoundedDrawable$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/drawable/XRoundedDrawable$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28578a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0059 -> B:33:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005d -> B:43:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0061 -> B:39:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0065 -> B:35:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0069 -> B:31:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x006d -> B:41:0x004c). Please submit an issue!!! */
        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f28578a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f28578a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f28578a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f28578a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f28578a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f28578a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f28578a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public XRoundedDrawable(Bitmap bitmap, int i, int i2, float f, float f2, float f3, float f4) {
        this.p = i;
        this.q = i2;
        this.l = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.m = height;
        this.i.set(0.0f, 0.0f, this.l, height);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.j = bitmapShader;
        bitmapShader.setLocalMatrix(this.s);
        Paint paint = new Paint();
        this.k = paint;
        paint.setAntiAlias(true);
        this.k.setShader(this.j);
        Paint paint2 = new Paint();
        this.o = paint2;
        paint2.setAntiAlias(true);
        this.o.setColor(this.q);
        this.o.setStrokeWidth(i);
        this.e = f;
        this.f = f2;
        this.g = f3;
        this.h = f4;
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            if (createBitmap == null) {
                return null;
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Drawable a(Drawable drawable, ImageView.ScaleType scaleType, int i, int i2, float f, float f2, float f3, float f4) {
        if (drawable != null) {
            if (drawable instanceof TransitionDrawable) {
                TransitionDrawable transitionDrawable = (TransitionDrawable) drawable;
                int numberOfLayers = transitionDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i3 = 0; i3 < numberOfLayers; i3++) {
                    Drawable drawable2 = transitionDrawable.getDrawable(i3);
                    if (drawable2 instanceof ColorDrawable) {
                        drawableArr[i3] = drawable2;
                    } else if (drawable2 instanceof XRoundedDrawable) {
                        drawableArr[i3] = drawable2;
                    } else {
                        Bitmap a2 = a(drawable2);
                        if (a2 != null) {
                            drawableArr[i3] = new XRoundedDrawable(a2, i, i2, f, f2, f3, f4);
                            if (drawable2 instanceof RecyclingBitmapDrawable) {
                                ((XRoundedDrawable) drawableArr[i3]).a((RecyclingBitmapDrawable) drawable2);
                            }
                            if (scaleType != null) {
                                ((XRoundedDrawable) drawableArr[i3]).a(scaleType);
                            }
                        }
                    }
                }
                try {
                    return new TransitionDrawable(drawableArr);
                } catch (OutOfMemoryError e) {
                    e.printStackTrace();
                    return drawable;
                }
            }
            Bitmap a3 = a(drawable);
            if (a3 != null) {
                XRoundedDrawable xRoundedDrawable = new XRoundedDrawable(a3, i, i2, f, f2, f3, f4);
                if (drawable instanceof RecyclingBitmapDrawable) {
                    xRoundedDrawable.a((RecyclingBitmapDrawable) drawable);
                }
                if (scaleType != null) {
                    xRoundedDrawable.a(scaleType);
                }
                return xRoundedDrawable;
            }
            Logger.d("RoundedDrawable", "Failed to create bitmap from drawable!");
        }
        return drawable;
    }

    private void a(Canvas canvas, RectF rectF, Paint paint, int i) {
        canvas.save();
        float f = i;
        canvas.translate(f, f);
        Path path = new Path();
        path.moveTo(this.e, 0.0f);
        path.lineTo(rectF.width() - this.g, 0.0f);
        path.arcTo(new RectF(rectF.width() - (this.g * 2.0f), 0.0f, rectF.width(), this.g * 2.0f), 270.0f, 90.0f);
        path.lineTo(rectF.width(), rectF.height() - this.h);
        path.arcTo(new RectF(rectF.width() - (this.h * 2.0f), rectF.height() - (this.h * 2.0f), rectF.width(), rectF.height()), 0.0f, 90.0f);
        path.lineTo(this.f, rectF.height());
        float height = rectF.height();
        float f2 = this.f;
        path.arcTo(new RectF(0.0f, height - (f2 * 2.0f), f2 * 2.0f, rectF.height()), 90.0f, 90.0f);
        path.lineTo(0.0f, this.e);
        float f3 = this.e;
        path.arcTo(new RectF(0.0f, 0.0f, f3 * 2.0f, f3 * 2.0f), 180.0f, 90.0f);
        path.close();
        canvas.drawPath(path, paint);
        canvas.restore();
    }

    private void g() {
        float width;
        float height;
        this.n.set(this.f28577c);
        RectF rectF = this.d;
        int i = this.p;
        rectF.set(i + 0, i + 0, this.n.width() - this.p, this.n.height() - this.p);
        switch (AnonymousClass1.f28578a[this.r.ordinal()]) {
            case 1:
                this.n.set(this.f28577c);
                RectF rectF2 = this.d;
                int i2 = this.p;
                rectF2.set(i2 + 0, i2 + 0, this.n.width() - this.p, this.n.height() - this.p);
                this.s.set(null);
                this.s.setTranslate((int) (((this.d.width() - this.l) * 0.5f) + 0.5f), (int) (((this.d.height() - this.m) * 0.5f) + 0.5f));
                break;
            case 2:
                this.n.set(this.f28577c);
                RectF rectF3 = this.d;
                int i3 = this.p;
                rectF3.set(i3 + 0, i3 + 0, this.n.width() - this.p, this.n.height() - this.p);
                this.s.set(null);
                float f = 0.0f;
                if (this.l * this.d.height() > this.d.width() * this.m) {
                    width = this.d.height() / this.m;
                    f = (this.d.width() - (this.l * width)) * 0.5f;
                    height = 0.0f;
                } else {
                    width = this.d.width() / this.l;
                    height = (this.d.height() - (this.m * width)) * 0.5f;
                }
                this.s.setScale(width, width);
                int i4 = this.p;
                this.s.postTranslate(((int) (f + 0.5f)) + i4, ((int) (height + 0.5f)) + i4);
                break;
            case 3:
                this.s.set(null);
                float min = (((float) this.l) > this.f28577c.width() || ((float) this.m) > this.f28577c.height()) ? Math.min(this.f28577c.width() / this.l, this.f28577c.height() / this.m) : 1.0f;
                float width2 = (int) (((this.f28577c.width() - (this.l * min)) * 0.5f) + 0.5f);
                float height2 = (int) (((this.f28577c.height() - (this.m * min)) * 0.5f) + 0.5f);
                this.s.setScale(min, min);
                this.s.postTranslate(width2, height2);
                this.n.set(this.i);
                this.s.mapRect(this.n);
                this.d.set(this.n.left + this.p, this.n.top + this.p, this.n.right - this.p, this.n.bottom - this.p);
                this.s.setRectToRect(this.i, this.d, Matrix.ScaleToFit.FILL);
                break;
            case 4:
                this.n.set(this.i);
                this.s.setRectToRect(this.i, this.f28577c, Matrix.ScaleToFit.CENTER);
                this.s.mapRect(this.n);
                this.d.set(this.n.left + this.p, this.n.top + this.p, this.n.right - this.p, this.n.bottom - this.p);
                this.s.setRectToRect(this.i, this.d, Matrix.ScaleToFit.FILL);
                break;
            case 5:
                this.n.set(this.i);
                this.s.setRectToRect(this.i, this.f28577c, Matrix.ScaleToFit.END);
                this.s.mapRect(this.n);
                this.d.set(this.n.left + this.p, this.n.top + this.p, this.n.right - this.p, this.n.bottom - this.p);
                this.s.setRectToRect(this.i, this.d, Matrix.ScaleToFit.FILL);
                break;
            case 6:
                this.n.set(this.i);
                this.s.setRectToRect(this.i, this.f28577c, Matrix.ScaleToFit.START);
                this.s.mapRect(this.n);
                this.d.set(this.n.left + this.p, this.n.top + this.p, this.n.right - this.p, this.n.bottom - this.p);
                this.s.setRectToRect(this.i, this.d, Matrix.ScaleToFit.FILL);
                break;
            default:
                this.n.set(this.f28577c);
                RectF rectF4 = this.d;
                int i5 = this.p;
                rectF4.set(i5 + 0, i5 + 0, this.n.width() - this.p, this.n.height() - this.p);
                this.s.set(null);
                this.s.setRectToRect(this.i, this.d, Matrix.ScaleToFit.FILL);
                break;
        }
        this.j.setLocalMatrix(this.s);
    }

    public void a(int i) {
        this.p = i;
        this.o.setStrokeWidth(i);
    }

    public void a(ImageView.ScaleType scaleType) {
        ImageView.ScaleType scaleType2 = scaleType;
        if (scaleType == null) {
            scaleType2 = ImageView.ScaleType.FIT_XY;
        }
        if (this.r != scaleType2) {
            this.r = scaleType2;
            g();
        }
    }

    public void a(RecyclingBitmapDrawable recyclingBitmapDrawable) {
        if (recyclingBitmapDrawable == null) {
            return;
        }
        if (this.b == null) {
            this.b = new HashSet();
        }
        this.b.add(recyclingBitmapDrawable);
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public void a(String str) {
        this.f28576a = str;
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public void a(boolean z) {
        Set<RecyclingBitmapDrawable> set = this.b;
        if (set != null) {
            for (RecyclingBitmapDrawable recyclingBitmapDrawable : set) {
                recyclingBitmapDrawable.a(z);
            }
        }
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public boolean a() {
        return true;
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public String b() {
        return this.f28576a;
    }

    public void b(int i) {
        this.q = i;
        this.o.setColor(i);
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public void b(boolean z) {
        Set<RecyclingBitmapDrawable> set = this.b;
        if (set != null) {
            for (RecyclingBitmapDrawable recyclingBitmapDrawable : set) {
                recyclingBitmapDrawable.b(z);
            }
        }
    }

    public void c(int i) {
        float f = i;
        this.h = f;
        this.g = f;
        this.f = f;
        this.e = f;
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public boolean c() {
        Set<RecyclingBitmapDrawable> set = this.b;
        if (set != null) {
            for (RecyclingBitmapDrawable recyclingBitmapDrawable : set) {
                if (!recyclingBitmapDrawable.c()) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public void d() {
        Set<RecyclingBitmapDrawable> set = this.b;
        if (set != null) {
            for (RecyclingBitmapDrawable recyclingBitmapDrawable : set) {
                recyclingBitmapDrawable.d();
            }
            this.b = null;
        }
    }

    public void d(int i) {
        this.h = i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.p <= 0) {
            a(canvas, this.d, this.k, 0);
            return;
        }
        a(canvas, this.n, this.o, 0);
        a(canvas, this.d, this.k, this.p);
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public int e() {
        return 1;
    }

    public void e(int i) {
        this.g = i;
    }

    public ImageView.ScaleType f() {
        return this.r;
    }

    public void f(int i) {
        this.f = i;
    }

    public void g(int i) {
        this.e = i;
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
        return -3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f28577c.set(rect);
        g();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.k.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.k.setColorFilter(colorFilter);
    }
}
