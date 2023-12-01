package com.anythink.basead.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.anythink.core.common.k.h;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/ui/RoundCornerRelativeLayout.class */
public class RoundCornerRelativeLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private Path f6166a;
    private Paint b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f6167c;
    private float d;

    public RoundCornerRelativeLayout(Context context) {
        super(context);
        this.d = 0.0f;
        a();
    }

    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0.0f;
        a();
    }

    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = 0.0f;
        a();
    }

    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.d = 0.0f;
        a();
    }

    private void a() {
        this.d = h.a(getContext(), 12.0f);
        this.f6166a = new Path();
        this.b = new Paint(1);
        this.f6167c = new RectF();
        this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    private Path b() {
        this.f6166a.reset();
        Path path = this.f6166a;
        RectF rectF = this.f6167c;
        float f = this.d;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        return this.f6166a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        this.f6166a.reset();
        Path path = this.f6166a;
        RectF rectF = this.f6167c;
        float f = this.d;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        canvas.clipPath(this.f6166a);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f6167c.set(0.0f, 0.0f, i, i2);
    }
}
