package com.soft.blued.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.blued.android.core.imagecache.drawable.IRecyclingDrawable;
import com.soft.blued.R;
import com.soft.blued.customview.drawable.XRoundedDrawable;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/XRoundedImageView.class */
public class XRoundedImageView extends AppCompatImageView {
    private static final ImageView.ScaleType[] k = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: a  reason: collision with root package name */
    private int f14855a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f14856c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private Drawable h;
    private Drawable i;
    private ImageView.ScaleType j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.customview.XRoundedImageView$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/XRoundedImageView$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14857a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0059 -> B:33:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005d -> B:43:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0061 -> B:39:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0065 -> B:35:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0069 -> B:31:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x006d -> B:41:0x004c). Please submit an issue!!! */
        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f14857a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14857a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14857a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f14857a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f14857a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f14857a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f14857a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public XRoundedImageView(Context context) {
        super(context);
        this.e = 0;
        this.f = -16777216;
    }

    public XRoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XRoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        boolean z = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.XRoundedImageView, i, 0);
        int i2 = obtainStyledAttributes.getInt(0, -1);
        if (i2 >= 0) {
            setScaleType(k[i2]);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        if (dimensionPixelSize > 0) {
            this.f14855a = dimensionPixelSize;
            this.b = dimensionPixelSize;
            this.f14856c = dimensionPixelSize;
            this.d = dimensionPixelSize;
        }
        this.f14855a = obtainStyledAttributes.getDimensionPixelSize(5, dimensionPixelSize);
        this.b = obtainStyledAttributes.getDimensionPixelSize(4, dimensionPixelSize);
        this.f14856c = obtainStyledAttributes.getDimensionPixelSize(7, dimensionPixelSize);
        this.d = obtainStyledAttributes.getDimensionPixelSize(6, dimensionPixelSize);
        this.e = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f = obtainStyledAttributes.getColor(1, -16777216);
        obtainStyledAttributes.recycle();
        this.g = ((this.f14855a + this.b) + this.f14856c) + this.d > 0 ? true : z;
    }

    public int getBorder() {
        return this.e;
    }

    public int getBorderColor() {
        return this.f;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.j;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        if (!this.g || drawable == null) {
            this.i = drawable;
        } else {
            this.i = XRoundedDrawable.a(drawable, this.j, this.e, this.f, this.f14855a, this.b, this.f14856c, this.d);
        }
        super.setBackgroundDrawable(this.i);
    }

    public void setBorderColor(int i) {
        if (this.f == i) {
            return;
        }
        this.f = i;
        Drawable drawable = this.h;
        if (drawable instanceof XRoundedDrawable) {
            ((XRoundedDrawable) drawable).b(i);
        }
        if (this.g) {
            Drawable drawable2 = this.i;
            if (drawable2 instanceof XRoundedDrawable) {
                ((XRoundedDrawable) drawable2).b(i);
            }
        }
        if (this.e > 0) {
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.e == i) {
            return;
        }
        this.e = i;
        Drawable drawable = this.h;
        if (drawable instanceof XRoundedDrawable) {
            ((XRoundedDrawable) drawable).a(i);
        }
        if (this.g) {
            Drawable drawable2 = this.i;
            if (drawable2 instanceof XRoundedDrawable) {
                ((XRoundedDrawable) drawable2).a(i);
            }
        }
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.f14855a = i;
        this.b = i;
        this.f14856c = i;
        this.d = i;
        Drawable drawable = this.h;
        if (drawable instanceof XRoundedDrawable) {
            ((XRoundedDrawable) drawable).c(i);
        }
        if (this.g) {
            Drawable drawable2 = this.i;
            if (drawable2 instanceof XRoundedDrawable) {
                ((XRoundedDrawable) drawable2).c(i);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            XRoundedDrawable xRoundedDrawable = new XRoundedDrawable(bitmap, this.e, this.f, this.f14855a, this.b, this.f14856c, this.d);
            this.h = xRoundedDrawable;
            ImageView.ScaleType scaleType = this.j;
            if (scaleType != null) {
                xRoundedDrawable.a(scaleType);
            }
        } else {
            this.h = null;
        }
        super.setImageDrawable(this.h);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != null) {
            IRecyclingDrawable a2 = XRoundedDrawable.a(drawable, this.j, this.e, this.f, this.f14855a, this.b, this.f14856c, this.d);
            this.h = a2;
            if ((drawable instanceof IRecyclingDrawable) && (a2 instanceof IRecyclingDrawable) && drawable != a2) {
                a2.a(((IRecyclingDrawable) drawable).b());
            }
        } else {
            this.h = null;
        }
        super.setImageDrawable(this.h);
    }

    public void setRound(boolean z) {
        if (this.g == z) {
            return;
        }
        this.g = z;
        if (z) {
            Drawable drawable = this.i;
            if (drawable instanceof XRoundedDrawable) {
                ((XRoundedDrawable) drawable).a(this.j);
                ((XRoundedDrawable) this.i).a(this.e);
                ((XRoundedDrawable) this.i).b(this.f);
                ((XRoundedDrawable) this.i).g(this.f14855a);
                ((XRoundedDrawable) this.i).f(this.b);
                ((XRoundedDrawable) this.i).e(this.f14856c);
                ((XRoundedDrawable) this.i).d(this.d);
            } else {
                setBackgroundDrawable(drawable);
            }
        } else {
            Drawable drawable2 = this.i;
            if (drawable2 instanceof XRoundedDrawable) {
                ((XRoundedDrawable) drawable2).a(0);
                ((XRoundedDrawable) this.i).c(0);
            }
        }
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            throw null;
        }
        if (this.j != scaleType) {
            this.j = scaleType;
            switch (AnonymousClass1.f14857a[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    super.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }
            Drawable drawable = this.h;
            if ((drawable instanceof XRoundedDrawable) && ((XRoundedDrawable) drawable).f() != scaleType) {
                ((XRoundedDrawable) this.h).a(scaleType);
            }
            Drawable drawable2 = this.i;
            if ((drawable2 instanceof XRoundedDrawable) && ((XRoundedDrawable) drawable2).f() != scaleType) {
                ((XRoundedDrawable) this.i).a(scaleType);
            }
            setWillNotCacheDrawing(true);
            requestLayout();
            invalidate();
        }
    }
}
