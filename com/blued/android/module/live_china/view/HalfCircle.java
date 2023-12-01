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
    public Paint a;
    public int b;
    public Context c;

    public HalfCircle(Context context) {
        super(context);
        this.b = -1;
        this.c = context;
        a();
    }

    public HalfCircle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -1;
        this.c = context;
        a();
    }

    public HalfCircle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = -1;
        this.c = context;
        a();
    }

    public void a() {
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setStyle(Paint.Style.FILL);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i = this.b;
        if (i != -1) {
            this.a.setColor(i);
        } else {
            this.a.setColor(this.c.getResources().getColor(R.color.black));
        }
        canvas.drawArc(new RectF(0.0f, 0.0f, getWidth() * 2, getHeight()), 90.0f, 180.0f, false, this.a);
    }

    public void setColor(int i) {
        this.b = i;
    }
}
