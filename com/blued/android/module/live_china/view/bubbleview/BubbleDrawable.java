package com.blued.android.module.live_china.view.bubbleview;

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
import android.graphics.drawable.Drawable;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/bubbleview/BubbleDrawable.class */
public class BubbleDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private RectF f15323a;
    private Path b;

    /* renamed from: c  reason: collision with root package name */
    private BitmapShader f15324c;
    private Paint d;
    private float e;
    private float f;
    private float g;
    private float h;
    private int i;
    private Bitmap j;
    private ArrowLocation k;
    private BubbleType l;
    private boolean m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.view.bubbleview.BubbleDrawable$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/bubbleview/BubbleDrawable$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15325a;
        static final /* synthetic */ int[] b;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0055 -> B:32:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0059 -> B:6:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x005d -> B:38:0x0033). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0061 -> B:34:0x003e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0065 -> B:30:0x0049). Please submit an issue!!! */
        static {
            int[] iArr = new int[BubbleType.values().length];
            b = iArr;
            try {
                iArr[BubbleType.COLOR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[BubbleType.BITMAP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            int[] iArr2 = new int[ArrowLocation.values().length];
            f15325a = iArr2;
            try {
                iArr2[ArrowLocation.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f15325a[ArrowLocation.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f15325a[ArrowLocation.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f15325a[ArrowLocation.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/bubbleview/BubbleDrawable$ArrowLocation.class */
    public enum ArrowLocation {
        LEFT(0),
        RIGHT(1),
        TOP(2),
        BOTTOM(3);
        
        private int e;

        ArrowLocation(int i) {
            this.e = i;
        }

        public static ArrowLocation a() {
            return LEFT;
        }

        public static ArrowLocation a(int i) {
            ArrowLocation[] values = values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return a();
                }
                ArrowLocation arrowLocation = values[i3];
                if (i == arrowLocation.b()) {
                    return arrowLocation;
                }
                i2 = i3 + 1;
            }
        }

        public int b() {
            return this.e;
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/bubbleview/BubbleDrawable$BubbleType.class */
    public enum BubbleType {
        COLOR,
        BITMAP
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/bubbleview/BubbleDrawable$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public static float f15330a = 25.0f;
        public static float b = 25.0f;

        /* renamed from: c  reason: collision with root package name */
        public static float f15331c = 20.0f;
        public static float d = 50.0f;
        public static int e = -65536;
        private RectF f;
        private Bitmap l;
        private boolean o;
        private float g = f15330a;
        private float h = f15331c;
        private float i = b;
        private float j = d;
        private int k = e;
        private BubbleType m = BubbleType.COLOR;
        private ArrowLocation n = ArrowLocation.LEFT;

        public Builder a(float f) {
            this.g = f;
            return this;
        }

        public Builder a(int i) {
            this.k = i;
            a(BubbleType.COLOR);
            return this;
        }

        public Builder a(RectF rectF) {
            this.f = rectF;
            return this;
        }

        public Builder a(ArrowLocation arrowLocation) {
            this.n = arrowLocation;
            return this;
        }

        public Builder a(BubbleType bubbleType) {
            this.m = bubbleType;
            return this;
        }

        public Builder a(boolean z) {
            this.o = z;
            return this;
        }

        public BubbleDrawable a() {
            if (this.f != null) {
                return new BubbleDrawable(this, null);
            }
            throw new IllegalArgumentException("BubbleDrawable Rect can not be null");
        }

        public Builder b(float f) {
            this.h = f * 2.0f;
            return this;
        }

        public Builder c(float f) {
            this.i = f;
            return this;
        }

        public Builder d(float f) {
            this.j = f;
            return this;
        }
    }

    private BubbleDrawable(Builder builder) {
        this.b = new Path();
        this.d = new Paint(1);
        this.f15323a = builder.f;
        this.f = builder.h;
        this.g = builder.i;
        this.e = builder.g;
        this.h = builder.j;
        this.i = builder.k;
        this.j = builder.l;
        this.k = builder.n;
        this.l = builder.m;
        this.m = builder.o;
    }

    /* synthetic */ BubbleDrawable(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private void a() {
        Matrix matrix = new Matrix();
        matrix.set(null);
        matrix.postScale(getIntrinsicWidth() / this.j.getWidth(), getIntrinsicHeight() / this.j.getHeight());
        matrix.postTranslate(this.f15323a.left, this.f15323a.top);
        this.f15324c.setLocalMatrix(matrix);
    }

    private void a(Canvas canvas) {
        int i = AnonymousClass1.b[this.l.ordinal()];
        if (i == 1) {
            this.d.setColor(this.i);
        } else if (i == 2) {
            if (this.j == null) {
                return;
            }
            if (this.f15324c == null) {
                this.f15324c = new BitmapShader(this.j, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            }
            this.d.setShader(this.f15324c);
            a();
        }
        a(this.k, this.b);
        canvas.drawPath(this.b, this.d);
    }

    private void a(RectF rectF, Path path) {
        if (this.m) {
            this.h = ((rectF.bottom - rectF.top) / 2.0f) - (this.e / 2.0f);
        }
        path.moveTo(this.e + rectF.left + this.f, rectF.top);
        path.lineTo(rectF.width() - this.f, rectF.top);
        path.arcTo(new RectF(rectF.right - this.f, rectF.top, rectF.right, this.f + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.f);
        path.arcTo(new RectF(rectF.right - this.f, rectF.bottom - this.f, rectF.right, rectF.bottom), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.e + this.f, rectF.bottom);
        float f = rectF.left;
        float f2 = this.e;
        float f3 = rectF.bottom;
        float f4 = this.f;
        path.arcTo(new RectF(f + f2, f3 - f4, f4 + rectF.left + this.e, rectF.bottom), 90.0f, 90.0f);
        path.lineTo(rectF.left + this.e, this.g + this.h);
        path.lineTo(rectF.left, this.h + (this.g / 2.0f));
        path.lineTo(rectF.left + this.e, this.h);
        path.lineTo(rectF.left + this.e, rectF.top + this.f);
        path.arcTo(new RectF(rectF.left + this.e, rectF.top, this.f + rectF.left + this.e, this.f + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void a(ArrowLocation arrowLocation, Path path) {
        int i = AnonymousClass1.f15325a[arrowLocation.ordinal()];
        if (i == 1) {
            a(this.f15323a, path);
        } else if (i == 2) {
            c(this.f15323a, path);
        } else if (i == 3) {
            b(this.f15323a, path);
        } else if (i != 4) {
        } else {
            d(this.f15323a, path);
        }
    }

    private void b(RectF rectF, Path path) {
        if (this.m) {
            this.h = ((rectF.right - rectF.left) / 2.0f) - (this.e / 2.0f);
        }
        path.moveTo(rectF.left + Math.min(this.h, this.f), rectF.top + this.g);
        path.lineTo(rectF.left + this.h, rectF.top + this.g);
        path.lineTo(rectF.left + (this.e / 2.0f) + this.h, rectF.top);
        path.lineTo(rectF.left + this.e + this.h, rectF.top + this.g);
        path.lineTo(rectF.right - this.f, rectF.top + this.g);
        path.arcTo(new RectF(rectF.right - this.f, rectF.top + this.g, rectF.right, this.f + rectF.top + this.g), 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF.bottom - this.f);
        path.arcTo(new RectF(rectF.right - this.f, rectF.bottom - this.f, rectF.right, rectF.bottom), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f, rectF.bottom);
        float f = rectF.left;
        float f2 = rectF.bottom;
        float f3 = this.f;
        path.arcTo(new RectF(f, f2 - f3, f3 + rectF.left, rectF.bottom), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.g + this.f);
        path.arcTo(new RectF(rectF.left, rectF.top + this.g, this.f + rectF.left, this.f + rectF.top + this.g), 180.0f, 90.0f);
        path.close();
    }

    private void c(RectF rectF, Path path) {
        if (this.m) {
            this.h = ((rectF.bottom - rectF.top) / 2.0f) - (this.e / 2.0f);
        }
        path.moveTo(rectF.left + this.f, rectF.top);
        path.lineTo((rectF.width() - this.f) - this.e, rectF.top);
        path.arcTo(new RectF((rectF.right - this.f) - this.e, rectF.top, rectF.right - this.e, this.f + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right - this.e, this.h);
        path.lineTo(rectF.right, this.h + (this.g / 2.0f));
        path.lineTo(rectF.right - this.e, this.h + this.g);
        path.lineTo(rectF.right - this.e, rectF.bottom - this.f);
        path.arcTo(new RectF((rectF.right - this.f) - this.e, rectF.bottom - this.f, rectF.right - this.e, rectF.bottom), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.e, rectF.bottom);
        float f = rectF.left;
        float f2 = rectF.bottom;
        float f3 = this.f;
        path.arcTo(new RectF(f, f2 - f3, f3 + rectF.left, rectF.bottom), 90.0f, 90.0f);
        path.arcTo(new RectF(rectF.left, rectF.top, this.f + rectF.left, this.f + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    private void d(RectF rectF, Path path) {
        if (this.m) {
            this.h = ((rectF.right - rectF.left) / 2.0f) - (this.e / 2.0f);
        }
        path.moveTo(rectF.left + this.f, rectF.top);
        path.lineTo(rectF.width() - this.f, rectF.top);
        path.arcTo(new RectF(rectF.right - this.f, rectF.top, rectF.right, this.f + rectF.top), 270.0f, 90.0f);
        path.lineTo(rectF.right, (rectF.bottom - this.g) - this.f);
        path.arcTo(new RectF(rectF.right - this.f, (rectF.bottom - this.f) - this.g, rectF.right, rectF.bottom - this.g), 0.0f, 90.0f);
        path.lineTo(rectF.left + this.e + this.h, rectF.bottom - this.g);
        path.lineTo(rectF.left + this.h + (this.e / 2.0f), rectF.bottom);
        path.lineTo(rectF.left + this.h, rectF.bottom - this.g);
        path.lineTo(rectF.left + Math.min(this.f, this.h), rectF.bottom - this.g);
        float f = rectF.left;
        float f2 = rectF.bottom;
        float f3 = this.f;
        path.arcTo(new RectF(f, (f2 - f3) - this.g, f3 + rectF.left, rectF.bottom - this.g), 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF.top + this.f);
        path.arcTo(new RectF(rectF.left, rectF.top, this.f + rectF.left, this.f + rectF.top), 180.0f, 90.0f);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        a(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f15323a.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f15323a.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.d.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
    }
}
