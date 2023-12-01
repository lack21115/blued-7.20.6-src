package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/HalfCircle.class */
public class HalfCircle extends View {

    /* renamed from: a  reason: collision with root package name */
    public Paint f14301a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public Context f14302c;

    public HalfCircle(Context context) {
        super(context);
        this.b = -1;
        this.f14302c = context;
        a();
    }

    public HalfCircle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -1;
        this.f14302c = context;
        a();
    }

    public HalfCircle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = -1;
        this.f14302c = context;
        a();
    }

    public void a() {
        Paint paint = new Paint(1);
        this.f14301a = paint;
        paint.setStyle(Paint.Style.FILL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i = this.b;
        if (i != -1) {
            this.f14301a.setColor(i);
        } else {
            this.f14301a.setColor(this.f14302c.getResources().getColor(R.color.black));
        }
        canvas.drawArc(new RectF(0.0f, 0.0f, getWidth() * 2, getHeight()), 90.0f, 180.0f, false, this.f14301a);
    }

    public void setColor(int i) {
        this.b = i;
    }
}
