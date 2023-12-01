package com.blued.android.module.common.widget.emoji.manager;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import java.lang.ref.WeakReference;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoji/manager/EmojiconSpan.class */
class EmojiconSpan extends DynamicDrawableSpan {

    /* renamed from: a  reason: collision with root package name */
    private final Context f11149a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f11150c;
    private final int d;
    private int e;
    private int f;
    private int g;
    private Drawable h;
    private WeakReference<Drawable> i;

    public EmojiconSpan(Context context, int i, int i2, int i3, int i4) {
        super(i3);
        this.f11149a = context;
        this.b = i;
        this.f11150c = i2;
        this.e = i2;
        this.f = i2;
        this.d = i4;
    }

    private Drawable a() {
        WeakReference<Drawable> weakReference = this.i;
        if (weakReference == null || weakReference.get() == null) {
            this.i = new WeakReference<>(getDrawable());
        }
        return this.i.get();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable a2 = a();
        canvas.save();
        int i6 = i5 - a2.getBounds().bottom;
        if (this.mVerticalAlignment == 1) {
            i6 = ((i3 + ((i5 - i3) / 2)) - ((a2.getBounds().bottom - a2.getBounds().top) / 2)) - this.g;
        }
        canvas.translate(f, i6);
        a2.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() {
        if (this.h == null) {
            try {
                Drawable drawable = this.f11149a.getResources().getDrawable(this.b);
                this.h = drawable;
                int i = this.f11150c;
                this.e = i;
                int intrinsicWidth = (i * drawable.getIntrinsicWidth()) / this.h.getIntrinsicHeight();
                this.f = intrinsicWidth;
                int i2 = (this.d - this.e) / 2;
                this.g = i2;
                this.h.setBounds(0, i2, intrinsicWidth, this.e + i2);
            } catch (Exception e) {
            }
        }
        return this.h;
    }
}
