package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.yy_china.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYKtvPro2View.class */
public final class YYKtvPro2View extends View {
    private final Paint a;
    private final Paint b;
    private int c;
    private int d;
    private int e;
    private OnKtvProChangeNumHeightListening f;
    private int g;
    private int h;
    private Bitmap i;
    private int j;
    private int k;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYKtvPro2View$OnKtvProChangeNumHeightListening.class */
    public interface OnKtvProChangeNumHeightListening {
        void a(float f);
    }

    public YYKtvPro2View(Context context) {
        this(context, null);
    }

    public YYKtvPro2View(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYKtvPro2View(Context context, AttributeSet attributeSet, int i) {
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
        this.c = 20;
        this.d = 20;
        this.g = 100;
        this.j = R.color.syc_ffd000;
        this.k = R.color.syc_8e5100;
        TypedArray obtainStyledAttributes = context == null ? null : context.obtainStyledAttributes(attributeSet, R.styleable.YYKtvProView, i, 0);
        if (obtainStyledAttributes == null) {
            return;
        }
        if (obtainStyledAttributes.getBoolean(R.styleable.YYKtvProView_is_ktv_giftormusic, false)) {
            this.i = BitmapFactory.decodeResource(getResources(), R.drawable.icon_bg_yy_ktv_gift_pro);
            this.j = R.color.syc_FF5D7E;
            this.k = R.color.syc_FFC05B;
            this.e = 10;
            Bitmap bitmap = this.i;
            Integer valueOf = bitmap == null ? null : Integer.valueOf(bitmap.getHeight());
            Intrinsics.a(valueOf);
            int intValue = valueOf.intValue();
            Bitmap bitmap2 = this.i;
            Integer valueOf2 = bitmap2 == null ? null : Integer.valueOf(bitmap2.getWidth());
            Intrinsics.a(valueOf2);
            this.d = (((intValue - valueOf2.intValue()) - this.c) + 20) - this.e;
            return;
        }
        this.i = BitmapFactory.decodeResource(getResources(), R.drawable.icon_bg_yy_ktv_music_pro);
        this.j = R.color.syc_52B0FF;
        this.k = R.color.syc_FF56F0;
        this.e = 10;
        Bitmap bitmap3 = this.i;
        Integer valueOf3 = bitmap3 == null ? null : Integer.valueOf(bitmap3.getHeight());
        Intrinsics.a(valueOf3);
        int intValue2 = valueOf3.intValue();
        Bitmap bitmap4 = this.i;
        Integer valueOf4 = bitmap4 == null ? null : Integer.valueOf(bitmap4.getWidth());
        Intrinsics.a(valueOf4);
        this.d = (((intValue2 - valueOf4.intValue()) - this.c) + 20) - this.e;
    }

    public final int getMaxPro() {
        return this.g;
    }

    public final OnKtvProChangeNumHeightListening getOnKtvProChangeNumHeightListening() {
        return this.f;
    }

    public final int getPro() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.i;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.i = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        Integer valueOf;
        super.onDraw(canvas);
        Bitmap bitmap = this.i;
        if (bitmap != null) {
            this.a.setColor(getResources().getColor(R.color.black));
            if (canvas != null) {
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.a);
            }
        }
        float f = (((i - this.h) / (this.g * 1.0f)) * this.d) + this.c;
        Bitmap bitmap2 = this.i;
        Integer valueOf2 = bitmap2 == null ? null : Integer.valueOf(bitmap2.getWidth());
        Intrinsics.a(valueOf2);
        int intValue = valueOf2.intValue();
        Bitmap bitmap3 = this.i;
        Intrinsics.a(bitmap3 == null ? null : Integer.valueOf(bitmap3.getHeight()));
        float f2 = intValue;
        float f3 = f2 / 2.0f;
        float intValue2 = 20 + (valueOf.intValue() - f2);
        this.b.setShader(new LinearGradient(f3, f, f3, intValue2, getResources().getColor(this.j), getResources().getColor(this.k), Shader.TileMode.CLAMP));
        if (canvas != null) {
            float f4 = 6;
            canvas.drawRoundRect(f3 - f4, f, f3 + f4, intValue2, 6.0f, 6.0f, this.b);
        }
        OnKtvProChangeNumHeightListening onKtvProChangeNumHeightListening = this.f;
        if (onKtvProChangeNumHeightListening == null) {
            return;
        }
        onKtvProChangeNumHeightListening.a(f);
    }

    public final void setMaxPro(int i) {
        if (i <= 0) {
            this.g = 100;
        } else {
            this.g = i;
        }
        setPro(0);
        invalidate();
    }

    public final void setOnKtvProChangeNumHeightListening(OnKtvProChangeNumHeightListening onKtvProChangeNumHeightListening) {
        this.f = onKtvProChangeNumHeightListening;
    }

    public final void setPro(int i) {
        int i2 = this.g;
        int i3 = i;
        if (i >= i2) {
            i3 = i2;
        }
        this.h = i3;
        invalidate();
    }
}
