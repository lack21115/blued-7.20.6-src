package com.opos.mobad.n.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.sina.weibo.sdk.constant.WBConstants;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/a/g.class */
public class g extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f26502a;
    private Paint b;

    public g(Context context) {
        this(context, null);
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f26502a = paint;
        paint.setAntiAlias(true);
        this.f26502a.setStyle(Paint.Style.STROKE);
        this.f26502a.setColor(486539264);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setAntiAlias(true);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setColor(486539264);
    }

    private void a(Canvas canvas, int i, int i2) {
        float b = i / com.opos.cmn.an.h.f.a.b(getContext());
        int i3 = (i2 * 86) / WBConstants.SDK_NEW_PAY_VERSION;
        canvas.save();
        float f = (i * 1157) / 1080;
        float f2 = i3;
        canvas.drawCircle(f, f2, 239.0f * b, this.f26502a);
        canvas.drawCircle(f, f2, 277.0f * b, this.f26502a);
        canvas.drawCircle(f, f2, 316.0f * b, this.f26502a);
        canvas.drawCircle(f, f2, 353.0f * b, this.f26502a);
        canvas.drawCircle(f, f2, 391.0f * b, this.f26502a);
        canvas.drawCircle(f, f2, 429.0f * b, this.f26502a);
        canvas.drawCircle(f, f2, 467.0f * b, this.f26502a);
        canvas.drawCircle(f, f2, b * 505.0f, this.f26502a);
        canvas.restore();
    }

    private void b(Canvas canvas, int i, int i2) {
        float b = i / com.opos.cmn.an.h.f.a.b(getContext());
        int b2 = (com.opos.cmn.an.h.f.a.b(getContext()) * (-296)) / 1080;
        int i3 = (i2 * 1379) / WBConstants.SDK_NEW_PAY_VERSION;
        canvas.save();
        float f = b2;
        float f2 = i3;
        canvas.rotate(45.0f, f, f2);
        float f3 = 241.0f * b;
        canvas.drawRect(f - f3, f2 - f3, f3 + f, f3 + f2, this.b);
        float f4 = 279.0f * b;
        canvas.drawRect(f - f4, f2 - f4, f4 + f, f4 + f2, this.b);
        float f5 = 317.0f * b;
        canvas.drawRect(f - f5, f2 - f5, f5 + f, f5 + f2, this.b);
        float f6 = 355.0f * b;
        canvas.drawRect(f - f6, f2 - f6, f6 + f, f6 + f2, this.b);
        float f7 = 393.0f * b;
        canvas.drawRect(f - f7, f2 - f7, f7 + f, f7 + f2, this.b);
        float f8 = b * 431.0f;
        canvas.drawRect(f - f8, f2 - f8, f8 + f, f8 + f2, this.b);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        a(canvas, width, height);
        b(canvas, width, height);
        super.onDraw(canvas);
    }
}
