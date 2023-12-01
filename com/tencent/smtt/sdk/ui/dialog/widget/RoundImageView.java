package com.tencent.smtt.sdk.ui.dialog.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/ui/dialog/widget/RoundImageView.class */
public class RoundImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Paint f38904a;
    private Xfermode b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f38905c;
    private float[] d;
    private RectF e;
    private int f;
    private WeakReference<Bitmap> g;
    private float h;
    private Path i;

    public RoundImageView(Context context) {
        this(context, null);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.f = Color.parseColor("#eaeaea");
        Paint paint = new Paint();
        this.f38904a = paint;
        paint.setAntiAlias(true);
        this.i = new Path();
        this.d = new float[8];
        this.e = new RectF();
        this.h = com.tencent.smtt.sdk.ui.dialog.c.a(context, 16.46f);
        int i = 0;
        while (true) {
            int i2 = i;
            float[] fArr = this.d;
            if (i2 >= fArr.length) {
                return;
            }
            fArr[i2] = this.h;
            i = i2 + 1;
        }
    }

    private Bitmap a() {
        Bitmap bitmap = null;
        try {
            Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint(1);
            paint.setColor(-16777216);
            bitmap = createBitmap;
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), this.h, this.h, paint);
            return createBitmap;
        } catch (Throwable th) {
            th.printStackTrace();
            return bitmap;
        }
    }

    private void a(int i, int i2) {
        this.i.reset();
        this.f38904a.setStrokeWidth(i);
        this.f38904a.setColor(i2);
        this.f38904a.setStyle(Paint.Style.STROKE);
    }

    private void a(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        a(i, i2);
        this.i.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.i, this.f38904a);
    }

    @Override // android.view.View
    public void invalidate() {
        this.g = null;
        Bitmap bitmap = this.f38905c;
        if (bitmap != null) {
            bitmap.recycle();
            this.f38905c = null;
        }
        super.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        WeakReference<Bitmap> weakReference = this.g;
        Bitmap bitmap = weakReference == null ? null : weakReference.get();
        if (bitmap == null || bitmap.isRecycled()) {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                float f = intrinsicWidth;
                float f2 = intrinsicHeight;
                float max = Math.max((getWidth() * 1.0f) / f, (getHeight() * 1.0f) / f2);
                drawable.setBounds(0, 0, (int) (f * max), (int) (max * f2));
                drawable.draw(canvas2);
                Bitmap bitmap2 = this.f38905c;
                if (bitmap2 == null || bitmap2.isRecycled()) {
                    this.f38905c = a();
                }
                this.f38904a.reset();
                this.f38904a.setFilterBitmap(false);
                this.f38904a.setXfermode(this.b);
                Bitmap bitmap3 = this.f38905c;
                if (bitmap3 != null) {
                    canvas2.drawBitmap(bitmap3, 0.0f, 0.0f, this.f38904a);
                }
                this.f38904a.setXfermode(null);
                canvas.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
                this.g = new WeakReference<>(createBitmap);
            }
        } else {
            this.f38904a.setXfermode(null);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f38904a);
        }
        a(canvas, 1, this.f, this.e, this.d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.e.set(0.5f, 0.5f, i - 0.5f, i2 - 0.5f);
    }
}
