package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/graphics/drawable/DrawerArrowDrawable.class */
public class DrawerArrowDrawable extends Drawable {
    public static final int ARROW_DIRECTION_END = 3;
    public static final int ARROW_DIRECTION_LEFT = 0;
    public static final int ARROW_DIRECTION_RIGHT = 1;
    public static final int ARROW_DIRECTION_START = 2;
    private static final float b = (float) Math.toRadians(45.0d);

    /* renamed from: c  reason: collision with root package name */
    private float f1632c;
    private float d;
    private float e;
    private float f;
    private boolean g;
    private final int i;
    private float k;
    private float l;

    /* renamed from: a  reason: collision with root package name */
    private final Paint f1631a = new Paint();
    private final Path h = new Path();
    private boolean j = false;
    private int m = 2;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/graphics/drawable/DrawerArrowDrawable$ArrowDirection.class */
    public @interface ArrowDirection {
    }

    public DrawerArrowDrawable(Context context) {
        this.f1631a.setStyle(Paint.Style.STROKE);
        this.f1631a.setStrokeJoin(Paint.Join.MITER);
        this.f1631a.setStrokeCap(Paint.Cap.BUTT);
        this.f1631a.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        setColor(obtainStyledAttributes.getColor(R.styleable.DrawerArrowToggle_color, 0));
        setBarThickness(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f));
        setSpinEnabled(obtainStyledAttributes.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
        setGapSize(Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.d = Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.f1632c = Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.e = obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private static float a(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
        if (androidx.core.graphics.drawable.DrawableCompat.getLayoutDirection(r6) == 0) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
        if (androidx.core.graphics.drawable.DrawableCompat.getLayoutDirection(r6) == 1) goto L11;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void draw(android.graphics.Canvas r7) {
        /*
            Method dump skipped, instructions count: 486
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawerArrowDrawable.draw(android.graphics.Canvas):void");
    }

    public float getArrowHeadLength() {
        return this.f1632c;
    }

    public float getArrowShaftLength() {
        return this.e;
    }

    public float getBarLength() {
        return this.d;
    }

    public float getBarThickness() {
        return this.f1631a.getStrokeWidth();
    }

    public int getColor() {
        return this.f1631a.getColor();
    }

    public int getDirection() {
        return this.m;
    }

    public float getGapSize() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final Paint getPaint() {
        return this.f1631a;
    }

    public float getProgress() {
        return this.k;
    }

    public boolean isSpinEnabled() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.f1631a.getAlpha()) {
            this.f1631a.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setArrowHeadLength(float f) {
        if (this.f1632c != f) {
            this.f1632c = f;
            invalidateSelf();
        }
    }

    public void setArrowShaftLength(float f) {
        if (this.e != f) {
            this.e = f;
            invalidateSelf();
        }
    }

    public void setBarLength(float f) {
        if (this.d != f) {
            this.d = f;
            invalidateSelf();
        }
    }

    public void setBarThickness(float f) {
        if (this.f1631a.getStrokeWidth() != f) {
            this.f1631a.setStrokeWidth(f);
            this.l = (float) ((f / 2.0f) * Math.cos(b));
            invalidateSelf();
        }
    }

    public void setColor(int i) {
        if (i != this.f1631a.getColor()) {
            this.f1631a.setColor(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1631a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDirection(int i) {
        if (i != this.m) {
            this.m = i;
            invalidateSelf();
        }
    }

    public void setGapSize(float f) {
        if (f != this.f) {
            this.f = f;
            invalidateSelf();
        }
    }

    public void setProgress(float f) {
        if (this.k != f) {
            this.k = f;
            invalidateSelf();
        }
    }

    public void setSpinEnabled(boolean z) {
        if (this.g != z) {
            this.g = z;
            invalidateSelf();
        }
    }

    public void setVerticalMirror(boolean z) {
        if (this.j != z) {
            this.j = z;
            invalidateSelf();
        }
    }
}
