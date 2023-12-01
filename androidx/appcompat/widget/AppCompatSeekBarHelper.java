package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/AppCompatSeekBarHelper.class */
class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {

    /* renamed from: a  reason: collision with root package name */
    private final SeekBar f1778a;
    private Drawable b;

    /* renamed from: c  reason: collision with root package name */
    private ColorStateList f1779c;
    private PorterDuff.Mode d;
    private boolean e;
    private boolean f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        this.f1779c = null;
        this.d = null;
        this.e = false;
        this.f = false;
        this.f1778a = seekBar;
    }

    private void d() {
        if (this.b != null) {
            if (this.e || this.f) {
                Drawable wrap = DrawableCompat.wrap(this.b.mutate());
                this.b = wrap;
                if (this.e) {
                    DrawableCompat.setTintList(wrap, this.f1779c);
                }
                if (this.f) {
                    DrawableCompat.setTintMode(this.b, this.d);
                }
                if (this.b.isStateful()) {
                    this.b.setState(this.f1778a.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        if (this.b == null) {
            return;
        }
        int max = this.f1778a.getMax();
        int i = 1;
        if (max <= 1) {
            return;
        }
        int intrinsicWidth = this.b.getIntrinsicWidth();
        int intrinsicHeight = this.b.getIntrinsicHeight();
        int i2 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
        if (intrinsicHeight >= 0) {
            i = intrinsicHeight / 2;
        }
        this.b.setBounds(-i2, -i, i2, i);
        float width = ((this.f1778a.getWidth() - this.f1778a.getPaddingLeft()) - this.f1778a.getPaddingRight()) / max;
        int save = canvas.save();
        canvas.translate(this.f1778a.getPaddingLeft(), this.f1778a.getHeight() / 2);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 > max) {
                canvas.restoreToCount(save);
                return;
            }
            this.b.draw(canvas);
            canvas.translate(width, 0.0f);
            i3 = i4 + 1;
        }
    }

    void a(Drawable drawable) {
        Drawable drawable2 = this.b;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1778a);
            DrawableCompat.setLayoutDirection(drawable, ViewCompat.getLayoutDirection(this.f1778a));
            if (drawable.isStateful()) {
                drawable.setState(this.f1778a.getDrawableState());
            }
            d();
        }
        this.f1778a.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.widget.AppCompatProgressBarHelper
    public void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.f1778a.getContext(), attributeSet, R.styleable.AppCompatSeekBar, i, 0);
        SeekBar seekBar = this.f1778a;
        ViewCompat.saveAttributeDataForStyleable(seekBar, seekBar.getContext(), R.styleable.AppCompatSeekBar, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(R.styleable.AppCompatSeekBar_android_thumb);
        if (drawableIfKnown != null) {
            this.f1778a.setThumb(drawableIfKnown);
        }
        a(obtainStyledAttributes.getDrawable(R.styleable.AppCompatSeekBar_tickMark));
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.d = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.d);
            this.f = true;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f1779c = obtainStyledAttributes.getColorStateList(R.styleable.AppCompatSeekBar_tickMarkTint);
            this.e = true;
        }
        obtainStyledAttributes.recycle();
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        Drawable drawable = this.b;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Drawable drawable = this.b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1778a.getDrawableState())) {
            this.f1778a.invalidateDrawable(drawable);
        }
    }
}
