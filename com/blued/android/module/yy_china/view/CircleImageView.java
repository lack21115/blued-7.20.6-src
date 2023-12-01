package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.blued.android.module.yy_china.R;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/CircleImageView.class */
public class CircleImageView extends AppCompatImageView {
    private static final ImageView.ScaleType a = ImageView.ScaleType.CENTER_CROP;
    private static final Bitmap.Config b = Bitmap.Config.ARGB_8888;
    private final RectF c;
    private final RectF d;
    private final Matrix e;
    private final Paint f;
    private final Paint g;
    private final Paint h;
    private int i;
    private int j;
    private int k;
    private int l;
    private Bitmap m;
    private Canvas n;
    private float o;
    private float p;
    private ColorFilter q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/CircleImageView$OutlineProvider.class */
    public class OutlineProvider extends ViewOutlineProvider {
        private OutlineProvider() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (CircleImageView.this.v) {
                ViewOutlineProvider.BACKGROUND.getOutline(view, outline);
                return;
            }
            Rect rect = new Rect();
            CircleImageView.this.d.roundOut(rect);
            outline.setRoundRect(rect, rect.width() / 2.0f);
        }
    }

    public CircleImageView(Context context) {
        super(context);
        this.c = new RectF();
        this.d = new RectF();
        this.e = new Matrix();
        this.f = new Paint();
        this.g = new Paint();
        this.h = new Paint();
        this.i = View.MEASURED_STATE_MASK;
        this.j = 0;
        this.k = 0;
        this.l = 255;
        a();
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new RectF();
        this.d = new RectF();
        this.e = new Matrix();
        this.f = new Paint();
        this.g = new Paint();
        this.h = new Paint();
        this.i = View.MEASURED_STATE_MASK;
        this.j = 0;
        this.k = 0;
        this.l = 255;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleImageView, i, 0);
        this.j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CircleImageView_civ_border_width, 0);
        this.i = obtainStyledAttributes.getColor(R.styleable.CircleImageView_civ_border_color, View.MEASURED_STATE_MASK);
        this.u = obtainStyledAttributes.getBoolean(R.styleable.CircleImageView_civ_border_overlay, false);
        this.k = obtainStyledAttributes.getColor(R.styleable.CircleImageView_civ_circle_background_color, 0);
        obtainStyledAttributes.recycle();
        a();
    }

    private Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = drawable instanceof ColorDrawable ? Bitmap.createBitmap(2, 2, b) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), b);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void a() {
        this.r = true;
        super.setScaleType(a);
        this.f.setAntiAlias(true);
        this.f.setDither(true);
        this.f.setFilterBitmap(true);
        this.f.setAlpha(this.l);
        this.f.setColorFilter(this.q);
        this.g.setStyle(Paint.Style.STROKE);
        this.g.setAntiAlias(true);
        this.g.setColor(this.i);
        this.g.setStrokeWidth(this.j);
        this.h.setStyle(Paint.Style.FILL);
        this.h.setAntiAlias(true);
        this.h.setColor(this.k);
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new OutlineProvider());
        }
    }

    private boolean a(float f, float f2) {
        return this.d.isEmpty() || Math.pow((double) (f - this.d.centerX()), 2.0d) + Math.pow((double) (f2 - this.d.centerY()), 2.0d) <= Math.pow((double) this.p, 2.0d);
    }

    private void b() {
        Bitmap a2 = a(getDrawable());
        this.m = a2;
        if (a2 == null || !a2.isMutable()) {
            this.n = null;
        } else {
            this.n = new Canvas(this.m);
        }
        if (this.r) {
            if (this.m != null) {
                e();
            } else {
                this.f.setShader(null);
            }
        }
    }

    private void c() {
        int i;
        this.d.set(d());
        this.p = Math.min((this.d.height() - this.j) / 2.0f, (this.d.width() - this.j) / 2.0f);
        this.c.set(this.d);
        if (!this.u && (i = this.j) > 0) {
            this.c.inset(i - 1.0f, i - 1.0f);
        }
        this.o = Math.min(this.c.height() / 2.0f, this.c.width() / 2.0f);
        e();
    }

    private RectF d() {
        int width;
        int height;
        int min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        float paddingLeft = getPaddingLeft() + ((width - min) / 2.0f);
        float paddingTop = getPaddingTop() + ((height - min) / 2.0f);
        float f = min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f, f + paddingTop);
    }

    private void e() {
        float width;
        float height;
        if (this.m == null) {
            return;
        }
        this.e.set(null);
        int height2 = this.m.getHeight();
        float width2 = this.m.getWidth();
        float f = height2;
        float f2 = 0.0f;
        if (this.c.height() * width2 > this.c.width() * f) {
            width = this.c.height() / f;
            f2 = (this.c.width() - (width2 * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = this.c.width() / width2;
            height = (this.c.height() - (f * width)) * 0.5f;
        }
        this.e.setScale(width, width);
        this.e.postTranslate(((int) (f2 + 0.5f)) + this.c.left, ((int) (height + 0.5f)) + this.c.top);
        this.s = true;
    }

    public int getBorderColor() {
        return this.i;
    }

    public int getBorderWidth() {
        return this.j;
    }

    public int getCircleBackgroundColor() {
        return this.k;
    }

    public ColorFilter getColorFilter() {
        return this.q;
    }

    public int getImageAlpha() {
        return this.l;
    }

    public void invalidateDrawable(Drawable drawable) {
        this.t = true;
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        if (this.v) {
            super.onDraw(canvas);
            return;
        }
        if (this.k != 0) {
            canvas.drawCircle(this.c.centerX(), this.c.centerY(), this.o, this.h);
        }
        if (this.m != null) {
            if (this.t && this.n != null) {
                this.t = false;
                Drawable drawable = getDrawable();
                drawable.setBounds(0, 0, this.n.getWidth(), this.n.getHeight());
                drawable.draw(this.n);
            }
            if (this.s) {
                this.s = false;
                BitmapShader bitmapShader = new BitmapShader(this.m, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
                bitmapShader.setLocalMatrix(this.e);
                this.f.setShader(bitmapShader);
            }
            canvas.drawCircle(this.c.centerX(), this.c.centerY(), this.o, this.f);
        }
        if (this.j > 0) {
            canvas.drawCircle(this.d.centerX(), this.d.centerY(), this.p, this.g);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        c();
        invalidate();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.v ? super.onTouchEvent(motionEvent) : a(motionEvent.getX(), motionEvent.getY()) && super.onTouchEvent(motionEvent);
    }

    public void setAdjustViewBounds(boolean z) {
        if (z) {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    public void setBorderColor(int i) {
        if (i == this.i) {
            return;
        }
        this.i = i;
        this.g.setColor(i);
        invalidate();
    }

    public void setBorderOverlay(boolean z) {
        if (z == this.u) {
            return;
        }
        this.u = z;
        c();
        invalidate();
    }

    public void setBorderWidth(int i) {
        if (i == this.j) {
            return;
        }
        this.j = i;
        this.g.setStrokeWidth(i);
        c();
        invalidate();
    }

    public void setCircleBackgroundColor(int i) {
        if (i == this.k) {
            return;
        }
        this.k = i;
        this.h.setColor(i);
        invalidate();
    }

    @Deprecated
    public void setCircleBackgroundColorResource(int i) {
        setCircleBackgroundColor(getContext().getResources().getColor(i));
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter == this.q) {
            return;
        }
        this.q = colorFilter;
        if (this.r) {
            this.f.setColorFilter(colorFilter);
            invalidate();
        }
    }

    public void setDisableCircularTransformation(boolean z) {
        if (z == this.v) {
            return;
        }
        this.v = z;
        if (z) {
            this.m = null;
            this.n = null;
            this.f.setShader(null);
        } else {
            b();
        }
        invalidate();
    }

    public void setImageAlpha(int i) {
        int i2 = i & 255;
        if (i2 == this.l) {
            return;
        }
        this.l = i2;
        if (this.r) {
            this.f.setAlpha(i2);
            invalidate();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        b();
        invalidate();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        b();
        invalidate();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        b();
        invalidate();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        b();
        invalidate();
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        c();
        invalidate();
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        c();
        invalidate();
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }
}
