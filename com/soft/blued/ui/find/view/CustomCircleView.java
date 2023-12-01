package com.soft.blued.ui.find.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.blued.android.core.AppInfo;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/CustomCircleView.class */
public class CustomCircleView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f16985a;
    private Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private Canvas f16986c;

    public CustomCircleView(Context context) {
        this(context, null);
    }

    public CustomCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Paint paint = new Paint();
        this.f16985a = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f16985a.setAntiAlias(true);
        this.b = Bitmap.createBitmap(AppInfo.l, AppInfo.m + 150, Bitmap.Config.ARGB_8888);
        this.f16986c = new Canvas(this.b);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.e("liangYunLong", "onDetachedFromWindow");
        this.b.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        int i = width > height ? height / 2 : width / 2;
        if (this.b.isRecycled()) {
            this.b = Bitmap.createBitmap(AppInfo.l, AppInfo.m + 150, Bitmap.Config.ARGB_8888);
        }
        this.b.eraseColor(0);
        this.f16986c.drawColor(getResources().getColor(2131101312));
        this.f16986c.drawCircle(width / 2, height / 2, i - 60, this.f16985a);
        canvas.drawBitmap(this.b, 0.0f, 0.0f, (Paint) null);
        super.onDraw(canvas);
        Log.e("liangYunLong", "onDraw");
    }
}
