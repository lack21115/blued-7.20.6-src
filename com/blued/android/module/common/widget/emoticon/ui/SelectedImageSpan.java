package com.blued.android.module.common.widget.emoticon.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoticon/ui/SelectedImageSpan.class */
public class SelectedImageSpan extends ImageSpan {
    public int a;
    private WeakReference<Drawable> b;

    public SelectedImageSpan(Drawable drawable, int i) {
        super(drawable, i);
        this.a = 0;
    }

    private Drawable a() {
        WeakReference<Drawable> weakReference = this.b;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        Drawable drawable2 = drawable;
        if (drawable == null) {
            drawable2 = getDrawable();
            this.b = new WeakReference<>(drawable2);
        }
        return drawable2;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        if (this.a != 0) {
            Rect bounds = a().getBounds();
            paint.setColor(this.a);
            canvas.drawRect(f, i3, (bounds.right + f) - bounds.left, i5, paint);
        } else {
            paint.setColor(0);
        }
        super.draw(canvas, charSequence, i, i2, f, i3, i4, i5, paint);
    }
}
