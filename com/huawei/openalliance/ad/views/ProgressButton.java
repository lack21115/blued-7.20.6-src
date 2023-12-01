package com.huawei.openalliance.ad.views;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.utils.ay;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/ProgressButton.class */
public abstract class ProgressButton extends View implements View.OnClickListener {
    String Code;
    int I;
    int V;

    /* renamed from: a  reason: collision with root package name */
    private Rect f9428a;
    private Paint b;

    /* renamed from: c  reason: collision with root package name */
    private int f9429c;
    private CharSequence d;
    private boolean e;
    private int f;
    private int g;
    private int h;
    private float i;
    private int j;
    private int k;
    private Drawable l;
    private Drawable m;
    private long n;
    private final byte[] o;
    private boolean p;

    public ProgressButton(Context context) {
        this(context, null);
        Code();
    }

    public ProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.progressBarStyle);
        Code(context, attributeSet);
        Code();
    }

    public ProgressButton(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
        Code(context, attributeSet);
        Code();
    }

    public ProgressButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.f9428a = new Rect();
        this.e = false;
        this.h = -1;
        this.i = 12.0f;
        this.Code = null;
        this.V = -1;
        this.I = -1;
        this.j = 0;
        this.k = 100;
        this.o = new byte[0];
        setOnClickListener(this);
        Code(context, attributeSet);
        Code();
    }

    private CharSequence Code(CharSequence charSequence, int i, int i2) {
        int length = getText().length();
        int ceil = (int) Math.ceil(((i - i2) / getPromptRect().width()) * length);
        int ceil2 = (int) Math.ceil((this.f9429c * length) / getPromptRect().width());
        int i3 = length - ceil;
        if (i3 - ceil2 > 0) {
            return charSequence.toString().substring(0, length - (ceil + ceil2)) + "...";
        }
        String str = charSequence;
        if (i3 > 0) {
            str = charSequence.toString().substring(0, i3);
        }
        return str;
    }

    private void Code() {
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.b.setTextSize(this.i);
        this.b.setColor(this.h);
        if (this.I != -1) {
            this.Code = null;
        }
        Code(this.Code, this.V, this.I);
        setClickable(true);
        Paint paint2 = new Paint();
        paint2.setTextSize(this.i);
        Rect rect = new Rect();
        paint2.getTextBounds("...", 0, 3, rect);
        this.f9429c = rect.width();
        this.p = ay.C();
    }

    private void Code(int i) {
        synchronized (this.o) {
            float f = this.k > 0 ? i / this.k : 0.0f;
            Drawable drawable = this.m;
            if (drawable != null) {
                drawable.setLevel((int) (f * 10000.0f));
            } else {
                invalidate();
            }
        }
    }

    private void Code(int i, int i2) {
        synchronized (this.o) {
            if (this.l != null) {
                this.l.setBounds(0, 0, i, i2);
            }
        }
    }

    private void Code(Context context, AttributeSet attributeSet) {
        synchronized (this.o) {
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button);
                try {
                    this.e = obtainStyledAttributes.getBoolean(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_fixedWidth, false);
                    this.f = obtainStyledAttributes.getDimensionPixelSize(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_maxWidth, 0);
                    this.g = obtainStyledAttributes.getDimensionPixelSize(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_minWidth, 0);
                    this.i = obtainStyledAttributes.getDimension(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_textSize, 0.0f);
                    this.h = obtainStyledAttributes.getColor(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_textColor, -1);
                    this.Code = obtainStyledAttributes.getString(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_fontFamily);
                    this.I = obtainStyledAttributes.getInt(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_styleIndex, -1);
                    this.V = obtainStyledAttributes.getInt(com.huawei.hms.ads.nativead.R.styleable.hiad_progress_button_hiad_typefaceIndex, -1);
                } catch (UnsupportedOperationException e) {
                    ge.I("ProgressButton", "initButtonAttr UnsupportedOperationException");
                } catch (RuntimeException e2) {
                    ge.I("ProgressButton", "initButtonAttr RuntimeException");
                } catch (Exception e3) {
                    ge.I("ProgressButton", "initButtonAttr error");
                }
                obtainStyledAttributes.recycle();
            }
        }
    }

    private void Code(Canvas canvas) {
        synchronized (this.o) {
            if (this.d != null && this.d.length() > 0) {
                String intern = this.d.toString().intern();
                canvas.drawText((CharSequence) intern, 0, intern.length(), (getWidth() / 2) - this.f9428a.centerX(), (getHeight() / 2) - this.f9428a.centerY(), this.b);
            }
        }
    }

    private void Code(String str, int i, int i2) {
        Typeface typeface;
        ge.Code("ProgressButton", "setTypefaceFromAttrs");
        if (str != null) {
            Typeface create = Typeface.create(str, i2);
            typeface = create;
            if (create != null) {
                ge.Code("ProgressButton", "setTypeface");
                setPaintTypeface(create);
                this.b.setTypeface(create);
                return;
            }
        } else {
            typeface = null;
        }
        if (i == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i == 2) {
            typeface = Typeface.SERIF;
        } else if (i == 3) {
            typeface = Typeface.MONOSPACE;
        }
        Code(typeface, i2);
    }

    private boolean Code(Drawable drawable) {
        Drawable findDrawableByLayerId;
        if (drawable == null || !(drawable instanceof LayerDrawable) || (findDrawableByLayerId = ((LayerDrawable) drawable).findDrawableByLayerId(R.id.progress)) == null) {
            return false;
        }
        if ((findDrawableByLayerId instanceof f) || (findDrawableByLayerId instanceof g)) {
            return this.p;
        }
        return false;
    }

    private void I() {
        synchronized (this.o) {
            int[] drawableState = getDrawableState();
            if (this.l != null && this.l.isStateful()) {
                this.l.setState(drawableState);
            }
        }
    }

    private void V() {
        Paint paint = new Paint();
        paint.setTextSize(this.i);
        Rect rect = new Rect();
        paint.getTextBounds("...", 0, 3, rect);
        this.f9429c = rect.width();
    }

    private void V(int i, boolean z) {
        synchronized (this.o) {
            Code(i);
        }
    }

    private CharSequence getText() {
        CharSequence charSequence;
        synchronized (this.o) {
            charSequence = this.d;
        }
        return charSequence;
    }

    protected void C() {
        int i;
        ViewGroup.LayoutParams layoutParams;
        synchronized (this.o) {
            if (this.d != null && this.d.length() > 0) {
                this.b.getTextBounds(this.d.toString(), 0, this.d.length(), this.f9428a);
                int paddingStart = getPaddingStart();
                int i2 = paddingStart;
                if (paddingStart <= 0) {
                    i2 = getPaddingLeft();
                }
                int paddingEnd = getPaddingEnd();
                int i3 = paddingEnd;
                if (paddingEnd <= 0) {
                    i3 = getPaddingRight();
                }
                int width = this.f9428a.width() + i2 + i3;
                if (this.e) {
                    layoutParams = getLayoutParams();
                    int width2 = getWidth();
                    int i4 = width2;
                    if (width2 <= 0) {
                        i4 = layoutParams.width;
                    }
                    if (width > i4) {
                        CharSequence Code = Code(this.d, width, i4);
                        this.d = Code;
                        this.b.getTextBounds(Code.toString(), 0, this.d.length(), this.f9428a);
                    }
                    if (layoutParams.height <= 0) {
                        layoutParams.height = ((int) this.i) + getPaddingTop() + getPaddingBottom();
                        setLayoutParams(layoutParams);
                    }
                } else {
                    ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
                    if (layoutParams2 == null) {
                        return;
                    }
                    if (width != layoutParams2.width) {
                        if (width <= this.f || this.f <= 0) {
                            i = width;
                            if (width < this.g) {
                                i = this.g;
                            }
                        } else {
                            CharSequence Code2 = Code(this.d, width, this.f);
                            this.d = Code2;
                            this.b.getTextBounds(Code2.toString(), 0, this.d.length(), this.f9428a);
                            i = this.f;
                        }
                        layoutParams2.width = i;
                        layoutParams = layoutParams2;
                        if (layoutParams2.height <= 0) {
                            layoutParams2.height = ((int) this.i) + getPaddingTop() + getPaddingBottom();
                            layoutParams = layoutParams2;
                        }
                        setLayoutParams(layoutParams);
                    }
                }
            }
        }
    }

    void Code(int i, boolean z) {
        synchronized (this.o) {
            int i2 = i;
            if (i < 0) {
                i2 = 0;
            }
            int i3 = i2;
            if (i2 > this.k) {
                i3 = this.k;
            }
            if (i3 != this.j) {
                this.j = i3;
                V(i3, z);
            }
        }
    }

    public void Code(Typeface typeface, int i) {
        float f = 0.0f;
        boolean z = false;
        if (i <= 0) {
            this.b.setFakeBoldText(false);
            this.b.setTextSkewX(0.0f);
            setPaintTypeface(typeface);
            return;
        }
        Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i) : Typeface.create(typeface, i);
        setPaintTypeface(defaultFromStyle);
        int style = (defaultFromStyle != null ? defaultFromStyle.getStyle() : 0) & i;
        Paint paint = this.b;
        if ((style & 1) != 0) {
            z = true;
        }
        paint.setFakeBoldText(z);
        Paint paint2 = this.b;
        if ((style & 2) != 0) {
            f = -0.25f;
        }
        paint2.setTextSkewX(f);
    }

    public void Code(Drawable drawable, int i) {
        boolean z;
        synchronized (this.o) {
            if (this.l == null || drawable == this.l) {
                z = false;
            } else {
                this.l.setCallback(null);
                z = true;
            }
            if (drawable != null) {
                drawable.setCallback(this);
            }
            this.l = drawable;
            this.m = drawable;
            if (z) {
                Code(getWidth(), getHeight());
                int i2 = i;
                if (i < 0) {
                    i2 = 0;
                }
                int i3 = i2;
                if (i2 > this.k) {
                    i3 = this.k;
                }
                this.j = i3;
                Code(i3);
            } else {
                setProgress(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean S() {
        if (System.currentTimeMillis() - this.n < 500) {
            return true;
        }
        this.n = System.currentTimeMillis();
        return false;
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        I();
    }

    public Rect getPromptRect() {
        Rect rect;
        synchronized (this.o) {
            rect = this.f9428a;
        }
        return rect;
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        synchronized (this.o) {
            super.jumpDrawablesToCurrentState();
            if (this.l != null) {
                this.l.jumpToCurrentState();
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        synchronized (this.o) {
            super.onDraw(canvas);
            Drawable drawable = this.m;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            if (Code(drawable)) {
                canvas.scale(-1.0f, 1.0f, getWidth() / 2.0f, getHeight() / 2.0f);
            }
            Code(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        Code(i, i2);
    }

    public void setFixedWidth(boolean z) {
        this.e = z;
    }

    public void setFontFamily(String str) {
        this.Code = str;
        Code(str, this.V, this.I);
    }

    public void setMaxWidth(int i) {
        synchronized (this.o) {
            this.f = i;
        }
    }

    public void setMinWidth(int i) {
        synchronized (this.o) {
            this.g = i;
        }
    }

    public void setPaintTypeface(Typeface typeface) {
        synchronized (this.o) {
            this.b.setTypeface(typeface);
        }
    }

    public void setProgress(int i) {
        synchronized (this.o) {
            Code(i, false);
        }
    }

    public void setProgressDrawable(Drawable drawable) {
        Code(drawable, 0);
    }

    public void setText(CharSequence charSequence) {
        ge.Code("ProgressButton", "setText:" + ((Object) charSequence));
        synchronized (this.o) {
            this.d = String.valueOf(charSequence).toUpperCase(Locale.getDefault());
            C();
            invalidate();
        }
    }

    public void setTextColor(int i) {
        this.h = i;
        Paint paint = this.b;
        if (paint != null) {
            paint.setColor(i);
        }
    }

    public void setTextSize(float f) {
        this.i = f;
        Paint paint = this.b;
        if (paint != null) {
            paint.setAntiAlias(true);
            this.b.setTextSize(this.i);
        }
        V();
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        boolean z;
        synchronized (this.o) {
            if (drawable != this.l && !super.verifyDrawable(drawable)) {
                z = false;
            }
            z = true;
        }
        return z;
    }
}
