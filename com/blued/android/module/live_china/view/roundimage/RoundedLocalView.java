package com.blued.android.module.live_china.view.roundimage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/roundimage/RoundedLocalView.class */
public class RoundedLocalView extends AppCompatImageView {
    private final float[] d;
    private Drawable e;
    private ColorStateList f;
    private float g;
    private ColorFilter h;
    private boolean i;
    private Drawable j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private int o;
    private ImageView.ScaleType p;
    private Shader.TileMode q;
    private Shader.TileMode r;
    static final /* synthetic */ boolean b = !RoundedLocalView.class.desiredAssertionStatus();
    public static final Shader.TileMode a = Shader.TileMode.CLAMP;
    private static final ImageView.ScaleType[] c = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.view.roundimage.RoundedLocalView$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/roundimage/RoundedLocalView$1.class */
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
                a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    public RoundedLocalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedLocalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.f = ColorStateList.valueOf(View.MEASURED_STATE_MASK);
        this.g = 0.0f;
        this.h = null;
        this.i = false;
        this.k = false;
        this.l = false;
        this.m = false;
        Shader.TileMode tileMode = a;
        this.q = tileMode;
        this.r = tileMode;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundedLocalView, i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.RoundedImageView_android_scaleType, -1);
        if (i2 >= 0) {
            setScaleType(c[i2]);
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        float dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedLocalView_riv_corner_radius, -1);
        this.d[0] = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedLocalView_riv_corner_radius_top_left, -1);
        this.d[1] = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedLocalView_riv_corner_radius_top_right, -1);
        this.d[2] = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedLocalView_riv_corner_radius_bottom_right, -1);
        this.d[3] = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedLocalView_riv_corner_radius_bottom_left, -1);
        int length = this.d.length;
        boolean z = false;
        for (int i3 = 0; i3 < length; i3++) {
            float[] fArr = this.d;
            if (fArr[i3] < 0.0f) {
                fArr[i3] = 0.0f;
            } else {
                z = true;
            }
        }
        if (!z) {
            float f = dimensionPixelSize < 0.0f ? 0.0f : dimensionPixelSize;
            int length2 = this.d.length;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= length2) {
                    break;
                }
                this.d[i5] = f;
                i4 = i5 + 1;
            }
        }
        float dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundedLocalView_riv_border_width, -1);
        this.g = dimensionPixelSize2;
        if (dimensionPixelSize2 < 0.0f) {
            this.g = 0.0f;
        }
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.RoundedLocalView_riv_border_color);
        this.f = colorStateList;
        if (colorStateList == null) {
            this.f = ColorStateList.valueOf(View.MEASURED_STATE_MASK);
        }
        this.m = obtainStyledAttributes.getBoolean(R.styleable.RoundedLocalView_riv_mutate_background, false);
        this.l = obtainStyledAttributes.getBoolean(R.styleable.RoundedLocalView_riv_oval, false);
        int i6 = obtainStyledAttributes.getInt(R.styleable.RoundedLocalView_riv_tile_mode, -2);
        if (i6 != -2) {
            setTileModeX(a(i6));
            setTileModeY(a(i6));
        }
        int i7 = obtainStyledAttributes.getInt(R.styleable.RoundedLocalView_riv_tile_mode_x, -2);
        if (i7 != -2) {
            setTileModeX(a(i7));
        }
        int i8 = obtainStyledAttributes.getInt(R.styleable.RoundedLocalView_riv_tile_mode_y, -2);
        if (i8 != -2) {
            setTileModeY(a(i8));
        }
        c();
        a(true);
        if (this.m) {
            super.setBackgroundDrawable(this.e);
        }
        obtainStyledAttributes.recycle();
    }

    private static Shader.TileMode a(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return Shader.TileMode.MIRROR;
            }
            return Shader.TileMode.REPEAT;
        }
        return Shader.TileMode.CLAMP;
    }

    private Drawable a() {
        Resources resources = getResources();
        if (resources == null) {
            return null;
        }
        int i = this.n;
        Drawable drawable = null;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                this.n = 0;
                drawable = null;
            }
        }
        return RoundedDrawable.a(drawable);
    }

    private void a(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof RoundedDrawable) {
            RoundedDrawable roundedDrawable = (RoundedDrawable) drawable;
            roundedDrawable.a(scaleType).a(this.g).a(this.f).a(this.l).a(this.q).b(this.r);
            float[] fArr = this.d;
            if (fArr != null) {
                roundedDrawable.a(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            d();
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                a(layerDrawable.getDrawable(i), scaleType);
            }
        }
    }

    private void a(boolean z) {
        if (this.m) {
            if (z) {
                this.e = RoundedDrawable.a(this.e);
            }
            a(this.e, ImageView.ScaleType.FIT_XY);
        }
    }

    private Drawable b() {
        Resources resources = getResources();
        if (resources == null) {
            return null;
        }
        int i = this.o;
        Drawable drawable = null;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                this.o = 0;
                drawable = null;
            }
        }
        return RoundedDrawable.a(drawable);
    }

    private void c() {
        a(this.j, this.p);
    }

    private void d() {
        Drawable drawable = this.j;
        if (drawable == null || !this.i) {
            return;
        }
        Drawable mutate = drawable.mutate();
        this.j = mutate;
        if (this.k) {
            mutate.setColorFilter(this.h);
        }
    }

    public void a(float f, float f2, float f3, float f4) {
        float[] fArr = this.d;
        if (fArr[0] == f && fArr[1] == f2 && fArr[2] == f4 && fArr[3] == f3) {
            return;
        }
        float[] fArr2 = this.d;
        fArr2[0] = f;
        fArr2[1] = f2;
        fArr2[3] = f3;
        fArr2[2] = f4;
        c();
        a(false);
        invalidate();
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public int getBorderColor() {
        return this.f.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.f;
    }

    public float getBorderWidth() {
        return this.g;
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float[] fArr = this.d;
        int length = fArr.length;
        float f = 0.0f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return f;
            }
            f = Math.max(fArr[i2], f);
            i = i2 + 1;
        }
    }

    public ImageView.ScaleType getScaleType() {
        return this.p;
    }

    public Shader.TileMode getTileModeX() {
        return this.q;
    }

    public Shader.TileMode getTileModeY() {
        return this.r;
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        this.e = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.e = drawable;
        a(true);
        super.setBackgroundDrawable(this.e);
    }

    public void setBackgroundResource(int i) {
        if (this.o != i) {
            this.o = i;
            Drawable b2 = b();
            this.e = b2;
            setBackgroundDrawable(b2);
        }
    }

    public void setBorderColor(int i) {
        setBorderColor(ColorStateList.valueOf(i));
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.f.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(View.MEASURED_STATE_MASK);
        }
        this.f = colorStateList;
        c();
        a(false);
        if (this.g > 0.0f) {
            invalidate();
        }
    }

    public void setBorderWidth(float f) {
        if (this.g == f) {
            return;
        }
        this.g = f;
        c();
        a(false);
        invalidate();
    }

    public void setBorderWidth(int i) {
        setBorderWidth(getResources().getDimension(i));
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.h != colorFilter) {
            this.h = colorFilter;
            this.k = true;
            this.i = true;
            d();
            invalidate();
        }
    }

    public void setCornerRadius(float f) {
        a(f, f, f, f);
    }

    public void setCornerRadiusDimen(int i) {
        float dimension = getResources().getDimension(i);
        a(dimension, dimension, dimension, dimension);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.n = 0;
        this.j = RoundedDrawable.a(bitmap);
        c();
        super.setImageDrawable(this.j);
    }

    public void setImageDrawable(Drawable drawable) {
        this.n = 0;
        this.j = RoundedDrawable.a(drawable);
        c();
        super.setImageDrawable(this.j);
    }

    public void setImageResource(int i) {
        if (this.n != i) {
            this.n = i;
            this.j = a();
            c();
            super.setImageDrawable(this.j);
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z) {
        this.l = z;
        c();
        a(false);
        invalidate();
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!b && scaleType == null) {
            throw new AssertionError();
        }
        if (this.p != scaleType) {
            this.p = scaleType;
            switch (AnonymousClass1.a[scaleType.ordinal()]) {
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
            c();
            a(false);
            invalidate();
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.q == tileMode) {
            return;
        }
        this.q = tileMode;
        c();
        a(false);
        invalidate();
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.r == tileMode) {
            return;
        }
        this.r = tileMode;
        c();
        a(false);
        invalidate();
    }
}
