package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import com.blued.android.module.yy_china.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/FansFontSpan.class */
public final class FansFontSpan extends ReplacementSpan {
    private final Context a;
    private final int b;
    private final String c;
    private final boolean d;
    private Paint e;
    private Paint f;
    private Drawable g;
    private Drawable h;

    public FansFontSpan(Context mContext, int i, String levelName, boolean z) {
        Intrinsics.e(mContext, "mContext");
        Intrinsics.e(levelName, "levelName");
        this.a = mContext;
        this.b = i;
        this.c = levelName;
        this.d = z;
        this.e = new Paint();
        this.f = new Paint();
        this.e.setTextSize(this.a.getResources().getDimensionPixelOffset(R.dimen.sp_8));
        this.e.setColor(this.a.getResources().getColor(R.color.white));
        this.f.setTextSize(this.a.getResources().getDimensionPixelOffset(R.dimen.sp_11));
        if (this.d) {
            this.f.setColor(this.a.getResources().getColor(c(this.b)));
            this.g = this.a.getResources().getDrawable(a(this.b));
            this.h = this.a.getResources().getDrawable(b(this.b));
        } else {
            this.f.setColor(this.a.getResources().getColor(R.color.syc_dark_777777));
            this.g = this.a.getResources().getDrawable(R.drawable.icon_yy_fans_unavailable);
            this.h = this.a.getResources().getDrawable(R.drawable.icon_yy_fans_heart_unavailable);
        }
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setBounds(0, 0, this.a.getResources().getDimensionPixelSize(R.dimen.dp_57), this.a.getResources().getDimensionPixelSize(R.dimen.dp_16));
        }
        Drawable drawable2 = this.h;
        if (drawable2 == null) {
            return;
        }
        drawable2.setBounds(0, 0, this.a.getResources().getDimensionPixelSize(R.dimen.dp_12), this.a.getResources().getDimensionPixelSize(R.dimen.dp_12));
    }

    private final int a(int i) {
        return i <= 10 ? R.drawable.icon_yy_fans_less_10 : i <= 20 ? R.drawable.icon_yy_fans_less_20 : R.drawable.icon_yy_fans_less_30;
    }

    private final int b(int i) {
        return i <= 10 ? R.drawable.icon_yy_fans_heart_10 : i <= 20 ? R.drawable.icon_yy_fans_heart_20 : R.drawable.icon_yy_fans_heart_30;
    }

    private final int c(int i) {
        return i <= 10 ? R.color.syc_00AEE5 : i <= 20 ? R.color.syc_2979F7 : R.color.syc_F7295B;
    }

    public final Context a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final int d() {
        return this.a.getResources().getDimensionPixelSize(R.dimen.dp_57);
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        float f2;
        Intrinsics.e(canvas, "canvas");
        Intrinsics.e(text, "text");
        Intrinsics.e(paint, "paint");
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i6 = (i4 + fontMetricsInt.descent) - ((fontMetricsInt.descent - fontMetricsInt.ascent) / 2);
        int dimensionPixelOffset = this.a.getResources().getDimensionPixelOffset(R.dimen.dp_12);
        Drawable drawable = this.g;
        if (drawable == null) {
            f2 = f;
        } else {
            canvas.save();
            canvas.translate(f, i6 - ((drawable.getBounds().bottom - drawable.getBounds().top) / 2));
            drawable.draw(canvas);
            canvas.restore();
            f2 = (drawable.getBounds().right / 2) + f;
        }
        Drawable drawable2 = this.h;
        if (drawable2 != null) {
            canvas.save();
            canvas.translate(a().getResources().getDimensionPixelOffset(R.dimen.dp_3) + f, i6 - ((drawable2.getBounds().bottom - drawable2.getBounds().top) / 2));
            drawable2.draw(canvas);
            canvas.restore();
            f2 += drawable2.getBounds().right / 2;
            dimensionPixelOffset = drawable2.getBounds().right;
        }
        Paint paint2 = this.e;
        Paint.FontMetricsInt fontMetricsInt2 = paint2.getFontMetricsInt();
        int i7 = (fontMetricsInt2.descent + fontMetricsInt2.ascent) / 2;
        float measureText = paint2.measureText(String.valueOf(b()));
        float f3 = 2;
        canvas.drawText(String.valueOf(b()), f + a().getResources().getDimensionPixelOffset(R.dimen.dp_3) + ((dimensionPixelOffset - measureText) / f3), i6 - i7, paint2);
        Paint paint3 = this.f;
        Paint.FontMetricsInt fontMetricsInt3 = paint3.getFontMetricsInt();
        canvas.drawText(c().toString(), f2 - (paint3.measureText(c().toString()) / f3), i6 - ((fontMetricsInt3.descent + fontMetricsInt3.ascent) / 2), paint3);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.e(paint, "paint");
        return this.a.getResources().getDimensionPixelSize(R.dimen.dp_57);
    }
}
