package com.blued.android.core.imagecache.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.blued.android.core.imagecache.drawable.IRecyclingDrawable;
import com.blued.android.core.imagecache.drawable.RoundedDrawable;
import com.blued.android.core.utils.Log;
import com.blued.blued_core.R;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/view/RoundedImageView.class */
public class RoundedImageView extends AutoAttachRecyclingImageView {
    private static final ImageView.ScaleType[] o = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private int h;
    private int i;
    private int j;
    private boolean k;
    private Drawable l;
    private Drawable m;
    private ImageView.ScaleType n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.core.imagecache.view.RoundedImageView$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/view/RoundedImageView$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f9659a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0059 -> B:33:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x005d -> B:43:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0061 -> B:39:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0065 -> B:35:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0069 -> B:31:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x006d -> B:41:0x004c). Please submit an issue!!! */
        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f9659a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9659a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f9659a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f9659a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f9659a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f9659a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f9659a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundedImageView, i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.RoundedImageView_android_scaleType, -1);
        if (i2 >= 0) {
            setScaleType(o[i2]);
        }
        this.h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_corner_radius, -1);
        this.i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedImageView_border_width, -1);
        Log.b("jason", " mcor " + this.h);
        if (this.h < 0) {
            this.h = 0;
        }
        if (this.i < 0) {
            this.i = 0;
        }
        this.j = obtainStyledAttributes.getColor(R.styleable.RoundedImageView_border_color, -16777216);
        this.k = obtainStyledAttributes.getBoolean(R.styleable.RoundedImageView_round_background, false);
        obtainStyledAttributes.recycle();
    }

    public int getBorder() {
        return this.i;
    }

    public int getBorderColor() {
        return this.j;
    }

    public int getCornerRadius() {
        return this.h;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.n;
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        if (!this.k || drawable == null) {
            this.m = drawable;
        } else {
            this.m = RoundedDrawable.a(drawable, this.n, this.h, this.i, this.j);
        }
        super.setBackgroundDrawable(this.m);
    }

    public void setBorderColor(int i) {
        if (this.j == i) {
            return;
        }
        this.j = i;
        Drawable drawable = this.l;
        if (drawable instanceof RoundedDrawable) {
            ((RoundedDrawable) drawable).b(i);
        }
        if (this.k) {
            Drawable drawable2 = this.m;
            if (drawable2 instanceof RoundedDrawable) {
                ((RoundedDrawable) drawable2).b(i);
            }
        }
        if (this.i > 0) {
            invalidate();
        }
    }

    public void setBorderWidth(int i) {
        if (this.i == i) {
            return;
        }
        this.i = i;
        Drawable drawable = this.l;
        if (drawable instanceof RoundedDrawable) {
            ((RoundedDrawable) drawable).a(i);
        }
        if (this.k) {
            Drawable drawable2 = this.m;
            if (drawable2 instanceof RoundedDrawable) {
                ((RoundedDrawable) drawable2).a(i);
            }
        }
        invalidate();
    }

    public void setCornerRadius(int i) {
        if (this.h == i) {
            return;
        }
        this.h = i;
        Drawable drawable = this.l;
        if (drawable instanceof RoundedDrawable) {
            ((RoundedDrawable) drawable).a(i);
        }
        if (this.k) {
            Drawable drawable2 = this.m;
            if (drawable2 instanceof RoundedDrawable) {
                ((RoundedDrawable) drawable2).a(i);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            RoundedDrawable roundedDrawable = new RoundedDrawable(bitmap, this.h, this.i, this.j);
            this.l = roundedDrawable;
            ImageView.ScaleType scaleType = this.n;
            if (scaleType != null) {
                roundedDrawable.a(scaleType);
            }
        } else {
            this.l = null;
        }
        super.setImageDrawable(this.l);
    }

    @Override // com.blued.android.core.imagecache.view.RecyclingImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != null) {
            Drawable a2 = RoundedDrawable.a(drawable, this.n, this.h, this.i, this.j);
            this.l = a2;
            if ((drawable instanceof IRecyclingDrawable) && (a2 instanceof IRecyclingDrawable) && drawable != a2) {
                ((IRecyclingDrawable) a2).a(((IRecyclingDrawable) drawable).b());
            }
        } else {
            this.l = null;
        }
        super.setImageDrawable(this.l);
    }

    public void setRoundBackground(boolean z) {
        if (this.k == z) {
            return;
        }
        this.k = z;
        if (z) {
            Drawable drawable = this.m;
            if (drawable instanceof RoundedDrawable) {
                ((RoundedDrawable) drawable).a(this.n);
                ((RoundedDrawable) this.m).a(this.h);
                ((RoundedDrawable) this.m).a(this.i);
                ((RoundedDrawable) this.m).b(this.j);
            } else {
                setBackgroundDrawable(drawable);
            }
        } else {
            Drawable drawable2 = this.m;
            if (drawable2 instanceof RoundedDrawable) {
                ((RoundedDrawable) drawable2).a(0);
                ((RoundedDrawable) this.m).a(0.0f);
            }
        }
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            throw null;
        }
        if (this.n != scaleType) {
            this.n = scaleType;
            switch (AnonymousClass1.f9659a[scaleType.ordinal()]) {
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
            Drawable drawable = this.l;
            if ((drawable instanceof RoundedDrawable) && ((RoundedDrawable) drawable).f() != scaleType) {
                ((RoundedDrawable) this.l).a(scaleType);
            }
            Drawable drawable2 = this.m;
            if ((drawable2 instanceof RoundedDrawable) && ((RoundedDrawable) drawable2).f() != scaleType) {
                ((RoundedDrawable) this.m).a(scaleType);
            }
            setWillNotCacheDrawing(true);
            requestLayout();
            invalidate();
        }
    }
}
