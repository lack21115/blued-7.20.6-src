package com.blued.android.core.imagecache.drawable;

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
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;
import com.blued.android.core.utils.Log;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/drawable/RoundedDrawable.class */
public class RoundedDrawable extends Drawable implements IRecyclingDrawable {
    private String a;
    private Set<RecyclingBitmapDrawable> b;
    private float e;
    private final BitmapShader g;
    private final Paint h;
    private final int i;
    private final int j;
    private final Paint l;
    private int m;
    private int n;
    private final RectF c = new RectF();
    private final RectF d = new RectF();
    private final RectF f = new RectF();
    private final RectF k = new RectF();
    private ImageView.ScaleType o = ImageView.ScaleType.FIT_XY;
    private final Matrix p = new Matrix();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.core.imagecache.drawable.RoundedDrawable$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/drawable/RoundedDrawable$1.class */
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

    public RoundedDrawable(Bitmap bitmap, float f, int i, int i2) {
        this.m = i;
        this.n = i2;
        this.i = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.j = height;
        this.f.set(0.0f, 0.0f, this.i, height);
        this.e = f;
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        this.g = bitmapShader;
        bitmapShader.setLocalMatrix(this.p);
        Paint paint = new Paint();
        this.h = paint;
        paint.setAntiAlias(true);
        this.h.setShader(this.g);
        Paint paint2 = new Paint();
        this.l = paint2;
        paint2.setAntiAlias(true);
        this.l.setColor(this.n);
        this.l.setStrokeWidth(i);
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

    public static Drawable a(Drawable drawable, ImageView.ScaleType scaleType, float f, int i, int i2) {
        if (drawable != null) {
            if (drawable instanceof TransitionDrawable) {
                TransitionDrawable transitionDrawable = (TransitionDrawable) drawable;
                int numberOfLayers = transitionDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= numberOfLayers) {
                        try {
                            return new TransitionDrawable(drawableArr);
                        } catch (OutOfMemoryError e) {
                            e.printStackTrace();
                            return drawable;
                        }
                    }
                    Drawable drawable2 = transitionDrawable.getDrawable(i4);
                    if (drawable2 instanceof ColorDrawable) {
                        drawableArr[i4] = drawable2;
                    } else if (drawable2 instanceof RoundedDrawable) {
                        drawableArr[i4] = drawable2;
                    } else {
                        Bitmap a = a(drawable2);
                        if (a != null) {
                            drawableArr[i4] = new RoundedDrawable(a, f, i, i2);
                            if (drawable2 instanceof RecyclingBitmapDrawable) {
                                ((RoundedDrawable) drawableArr[i4]).a((RecyclingBitmapDrawable) drawable2);
                            }
                            if (scaleType != null) {
                                ((RoundedDrawable) drawableArr[i4]).a(scaleType);
                            }
                        }
                    }
                    i3 = i4 + 1;
                }
            } else {
                Bitmap a2 = a(drawable);
                if (a2 != null) {
                    RoundedDrawable roundedDrawable = new RoundedDrawable(a2, f, i, i2);
                    if (drawable instanceof RecyclingBitmapDrawable) {
                        roundedDrawable.a((RecyclingBitmapDrawable) drawable);
                    }
                    if (scaleType != null) {
                        roundedDrawable.a(scaleType);
                    }
                    return roundedDrawable;
                }
                Log.d("RoundedDrawable", "Failed to create bitmap from drawable!");
            }
        }
        return drawable;
    }

    private void g() {
        float width;
        float height;
        this.k.set(this.c);
        RectF rectF = this.d;
        int i = this.m;
        rectF.set(i + 0, i + 0, this.k.width() - this.m, this.k.height() - this.m);
        switch (AnonymousClass1.a[this.o.ordinal()]) {
            case 1:
                this.k.set(this.c);
                RectF rectF2 = this.d;
                int i2 = this.m;
                rectF2.set(i2 + 0, i2 + 0, this.k.width() - this.m, this.k.height() - this.m);
                this.p.set(null);
                this.p.setTranslate((int) (((this.d.width() - this.i) * 0.5f) + 0.5f), (int) (((this.d.height() - this.j) * 0.5f) + 0.5f));
                break;
            case 2:
                this.k.set(this.c);
                RectF rectF3 = this.d;
                int i3 = this.m;
                rectF3.set(i3 + 0, i3 + 0, this.k.width() - this.m, this.k.height() - this.m);
                this.p.set(null);
                float f = 0.0f;
                if (this.i * this.d.height() > this.d.width() * this.j) {
                    width = this.d.height() / this.j;
                    f = (this.d.width() - (this.i * width)) * 0.5f;
                    height = 0.0f;
                } else {
                    width = this.d.width() / this.i;
                    height = (this.d.height() - (this.j * width)) * 0.5f;
                }
                this.p.setScale(width, width);
                int i4 = this.m;
                this.p.postTranslate(((int) (f + 0.5f)) + i4, ((int) (height + 0.5f)) + i4);
                break;
            case 3:
                this.p.set(null);
                float min = (((float) this.i) > this.c.width() || ((float) this.j) > this.c.height()) ? Math.min(this.c.width() / this.i, this.c.height() / this.j) : 1.0f;
                float width2 = (int) (((this.c.width() - (this.i * min)) * 0.5f) + 0.5f);
                float height2 = (int) (((this.c.height() - (this.j * min)) * 0.5f) + 0.5f);
                this.p.setScale(min, min);
                this.p.postTranslate(width2, height2);
                this.k.set(this.f);
                this.p.mapRect(this.k);
                this.d.set(this.k.left + this.m, this.k.top + this.m, this.k.right - this.m, this.k.bottom - this.m);
                this.p.setRectToRect(this.f, this.d, Matrix.ScaleToFit.FILL);
                break;
            case 4:
                this.k.set(this.f);
                this.p.setRectToRect(this.f, this.c, Matrix.ScaleToFit.CENTER);
                this.p.mapRect(this.k);
                this.d.set(this.k.left + this.m, this.k.top + this.m, this.k.right - this.m, this.k.bottom - this.m);
                this.p.setRectToRect(this.f, this.d, Matrix.ScaleToFit.FILL);
                break;
            case 5:
                this.k.set(this.f);
                this.p.setRectToRect(this.f, this.c, Matrix.ScaleToFit.END);
                this.p.mapRect(this.k);
                this.d.set(this.k.left + this.m, this.k.top + this.m, this.k.right - this.m, this.k.bottom - this.m);
                this.p.setRectToRect(this.f, this.d, Matrix.ScaleToFit.FILL);
                break;
            case 6:
                this.k.set(this.f);
                this.p.setRectToRect(this.f, this.c, Matrix.ScaleToFit.START);
                this.p.mapRect(this.k);
                this.d.set(this.k.left + this.m, this.k.top + this.m, this.k.right - this.m, this.k.bottom - this.m);
                this.p.setRectToRect(this.f, this.d, Matrix.ScaleToFit.FILL);
                break;
            default:
                this.k.set(this.c);
                RectF rectF4 = this.d;
                int i5 = this.m;
                rectF4.set(i5 + 0, i5 + 0, this.k.width() - this.m, this.k.height() - this.m);
                this.p.set(null);
                this.p.setRectToRect(this.f, this.d, Matrix.ScaleToFit.FILL);
                break;
        }
        this.g.setLocalMatrix(this.p);
    }

    public void a(float f) {
        this.e = f;
    }

    public void a(int i) {
        this.m = i;
        this.l.setStrokeWidth(i);
    }

    public void a(ImageView.ScaleType scaleType) {
        ImageView.ScaleType scaleType2 = scaleType;
        if (scaleType == null) {
            scaleType2 = ImageView.ScaleType.FIT_XY;
        }
        if (this.o != scaleType2) {
            this.o = scaleType2;
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
        this.a = str;
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
        return this.a;
    }

    public void b(int i) {
        this.n = i;
        this.l.setColor(i);
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

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.m <= 0) {
            RectF rectF = this.d;
            float f = this.e;
            canvas.drawRoundRect(rectF, f, f, this.h);
            return;
        }
        RectF rectF2 = this.k;
        float f2 = this.e;
        canvas.drawRoundRect(rectF2, f2, f2, this.l);
        canvas.drawRoundRect(this.d, Math.max(this.e - this.m, 0.0f), Math.max(this.e - this.m, 0.0f), this.h);
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public int e() {
        return 1;
    }

    public ImageView.ScaleType f() {
        return this.o;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.c.set(rect);
        g();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.h.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.h.setColorFilter(colorFilter);
    }
}
