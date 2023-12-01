package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.yy_china.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYKtvProView.class */
public final class YYKtvProView extends View {
    private final Paint a;
    private final Paint b;
    private Path c;
    private int d;
    private int e;
    private int f;
    private Bitmap g;
    private int h;
    private int i;
    private int j;

    public YYKtvProView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYKtvProView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.black_alpha30));
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.a = paint;
        Paint paint2 = new Paint();
        paint2.setColor(getResources().getColor(R.color.purple_200));
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        this.b = paint2;
        this.d = 10;
        this.e = 100;
        this.h = R.color.syc_ffd000;
        this.i = R.color.syc_8e5100;
        TypedArray obtainStyledAttributes = context == null ? null : context.obtainStyledAttributes(attributeSet, R.styleable.YYKtvProView, i, 0);
        if (obtainStyledAttributes == null) {
            return;
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.YYKtvProView_is_ktv_giftormusic, false)) {
            this.g = BitmapFactory.decodeResource(getResources(), R.drawable.icon_yy_ktv_gift_pro);
            this.h = R.color.syc_ffd000;
            this.i = R.color.syc_8e5100;
            return;
        }
        this.g = BitmapFactory.decodeResource(getResources(), R.drawable.icon_yy_ktv_music_pro);
        this.h = R.color.syc_ff1e1e;
        this.i = R.color.syc_740000;
    }

    private final Path getStripPath() {
        if (this.c == null) {
            this.c = new Path();
        }
        Path path = this.c;
        if (path != null) {
            path.reset();
        }
        Path path2 = this.c;
        Path path3 = path2;
        if (path2 == null) {
            path3 = new Path();
        }
        return path3;
    }

    public final int getMaxPro() {
        return this.e;
    }

    public final int getPro() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.g;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.g = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        float f = 5;
        float width = (getWidth() * 4.0f) / f;
        float height = getHeight() - (getWidth() * 1.0f);
        this.a.setStrokeWidth(width);
        this.a.setColor(getResources().getColor(R.color.black_alpha30));
        Integer valueOf = canvas == null ? null : Integer.valueOf(canvas.saveLayer(0.0f, 0.0f, getWidth() * 1.0f, getHeight() * 1.0f, null));
        if (canvas != null) {
            canvas.drawCircle(getWidth() / 2.0f, getHeight() - (getWidth() / 2.0f), getWidth() / 2.0f, this.a);
        }
        this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        if (canvas != null) {
            canvas.drawLine(getWidth() / 2.0f, getWidth() / 2.0f, getWidth() / 2.0f, height, this.a);
        }
        this.a.setXfermode(null);
        if (canvas != null) {
            Intrinsics.a(valueOf);
            canvas.restoreToCount(valueOf.intValue());
        }
        if (this.f != 0) {
            Integer valueOf2 = canvas == null ? null : Integer.valueOf(canvas.saveLayer(0.0f, 0.0f, getWidth() * 1.0f, getHeight() * 1.0f, null));
            this.b.setStrokeWidth((getWidth() * 3.0f) / f);
            float f2 = (i - this.f) / (this.e * 1.0f);
            float f3 = height - 15;
            float width2 = (f2 * (f3 - (getWidth() / 2.0f))) + (getWidth() / 2.0f);
            float width3 = (getWidth() * 1.0f) / f;
            float f4 = (height - width2) / 2.0f;
            this.b.setShader(new LinearGradient(width3, f4, (getWidth() * 4.0f) / f, f4, getResources().getColor(this.h), getResources().getColor(this.i), Shader.TileMode.CLAMP));
            if (canvas != null) {
                canvas.drawLine(getWidth() / 2.0f, width2, getWidth() / 2.0f, f3, this.b);
            }
            this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
            int width4 = getWidth();
            double tan = width4 / Math.tan(Math.toRadians(80.0d));
            Path stripPath = getStripPath();
            int i2 = this.j;
            while (true) {
                int i3 = i2;
                if (i3 < (-tan)) {
                    break;
                }
                float f5 = width4;
                float f6 = i3;
                stripPath.moveTo(f5, f6);
                stripPath.lineTo(f5, f6);
                double d = f6 - tan;
                stripPath.lineTo(0.0f, (float) d);
                stripPath.lineTo(0.0f, (float) (d - this.d));
                stripPath.lineTo(f5, f6 - this.d);
                stripPath.lineTo(f5, f6);
                i2 = i3 - (this.d * 2);
            }
            int i4 = this.j;
            while (i4 <= getHeight() + tan) {
                float f7 = width4;
                float f8 = i4;
                stripPath.moveTo(f7, f8);
                stripPath.lineTo(f7, f8);
                double d2 = f8 - tan;
                stripPath.lineTo(0.0f, (float) d2);
                stripPath.lineTo(0.0f, (float) (d2 - this.d));
                stripPath.lineTo(f7, f8 - this.d);
                stripPath.lineTo(f7, f8);
                i4 += this.d * 2;
            }
            stripPath.close();
            this.b.setShader(new LinearGradient(0.0f, f4, (getWidth() * 3.0f) / f, f4, getResources().getColor(R.color.black_alpha00), getResources().getColor(R.color.black_alpha30), Shader.TileMode.CLAMP));
            if (canvas != null) {
                canvas.drawPath(stripPath, this.b);
            }
            this.b.setXfermode(null);
            if (canvas != null) {
                Intrinsics.a(valueOf2);
                canvas.restoreToCount(valueOf2.intValue());
            }
        }
        Bitmap bitmap = this.g;
        if (bitmap == null) {
            return;
        }
        float width5 = (getWidth() - bitmap.getWidth()) / 2.0f;
        this.a.setColor(getResources().getColor(R.color.black));
        if (canvas == null) {
            return;
        }
        canvas.drawBitmap(bitmap, width5, height + width5, this.a);
    }

    public final void setMaxPro(int i) {
        if (i <= 0) {
            this.e = 100;
        } else {
            this.e = i;
        }
        setPro(0);
        invalidate();
    }

    public final void setPro(int i) {
        int i2 = this.e;
        int i3 = i;
        if (i >= i2) {
            i3 = i2;
        }
        this.f = i3;
        invalidate();
    }
}
