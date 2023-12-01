package com.github.mikephil.charting.components;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.FSize;
import com.github.mikephil.charting.utils.MPPointF;
import java.lang.ref.WeakReference;

/* loaded from: source-8110460-dex2jar.jar:com/github/mikephil/charting/components/MarkerImage.class */
public class MarkerImage implements IMarker {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f22108a;
    private MPPointF b;

    /* renamed from: c  reason: collision with root package name */
    private MPPointF f22109c;
    private WeakReference<Chart> d;
    private FSize e;
    private Rect f;

    public MPPointF a() {
        return this.b;
    }

    public MPPointF a(float f, float f2) {
        MPPointF a2 = a();
        this.f22109c.f22204a = a2.f22204a;
        this.f22109c.b = a2.b;
        Chart b = b();
        float f3 = this.e.f22200a;
        float f4 = this.e.b;
        float f5 = f3;
        if (f3 == 0.0f) {
            Drawable drawable = this.f22108a;
            f5 = f3;
            if (drawable != null) {
                f5 = drawable.getIntrinsicWidth();
            }
        }
        float f6 = f4;
        if (f4 == 0.0f) {
            Drawable drawable2 = this.f22108a;
            f6 = f4;
            if (drawable2 != null) {
                f6 = drawable2.getIntrinsicHeight();
            }
        }
        if (this.f22109c.f22204a + f < 0.0f) {
            this.f22109c.f22204a = -f;
        } else if (b != null && f + f5 + this.f22109c.f22204a > b.getWidth()) {
            this.f22109c.f22204a = (b.getWidth() - f) - f5;
        }
        if (this.f22109c.b + f2 < 0.0f) {
            this.f22109c.b = -f2;
        } else if (b != null && f2 + f6 + this.f22109c.b > b.getHeight()) {
            this.f22109c.b = (b.getHeight() - f2) - f6;
        }
        return this.f22109c;
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void a(Canvas canvas, float f, float f2) {
        if (this.f22108a == null) {
            return;
        }
        MPPointF a2 = a(f, f2);
        float f3 = this.e.f22200a;
        float f4 = this.e.b;
        float f5 = f3;
        if (f3 == 0.0f) {
            f5 = this.f22108a.getIntrinsicWidth();
        }
        float f6 = f4;
        if (f4 == 0.0f) {
            f6 = this.f22108a.getIntrinsicHeight();
        }
        this.f22108a.copyBounds(this.f);
        this.f22108a.setBounds(this.f.left, this.f.top, this.f.left + ((int) f5), this.f.top + ((int) f6));
        int save = canvas.save();
        canvas.translate(f + a2.f22204a, f2 + a2.b);
        this.f22108a.draw(canvas);
        canvas.restoreToCount(save);
        this.f22108a.setBounds(this.f);
    }

    @Override // com.github.mikephil.charting.components.IMarker
    public void a(Entry entry, Highlight highlight) {
    }

    public Chart b() {
        WeakReference<Chart> weakReference = this.d;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
