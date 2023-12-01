package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import com.huawei.openalliance.ad.utils.ay;
import java.lang.ref.WeakReference;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/b.class */
public class b extends ImageSpan {
    int Code;
    private WeakReference<Drawable> I;
    int V;

    public b(Context context, Bitmap bitmap, int i, int i2, int i3) {
        super(context, bitmap, i);
        Code(i2, i3);
    }

    public b(Drawable drawable, int i, int i2, int i3) {
        super(drawable, i);
        Code(i2, i3);
    }

    private Drawable Code() {
        WeakReference<Drawable> weakReference = this.I;
        Drawable drawable = weakReference != null ? weakReference.get() : null;
        Drawable drawable2 = drawable;
        if (drawable == null) {
            drawable2 = getDrawable();
            this.I = new WeakReference<>(drawable2);
        }
        return drawable2;
    }

    private void Code(int i, int i2) {
        if (ay.I()) {
            this.Code = i2;
            this.V = i;
            return;
        }
        this.Code = i;
        this.V = i2;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable Code = Code();
        canvas.save();
        canvas.translate(this.Code + f, (i3 + ((i5 - i3) / 2)) - (Code.getBounds().height() / 2));
        Code.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return this.Code + super.getSize(paint, charSequence, i, i2, fontMetricsInt) + this.V;
    }
}
