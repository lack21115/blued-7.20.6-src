package com.blued.android.module.live_china.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.UiUtils;
import com.blued.android.module.live_china.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/TriangleView.class */
public final class TriangleView extends View {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final float e;
    private final float f;
    private final int g;
    private Paint h;
    private int i;
    private int j;
    private int k;
    private int l;
    private Path m;

    public TriangleView(Context context) {
        this(context, null);
    }

    public TriangleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TriangleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 1;
        this.c = 2;
        this.d = 3;
        this.e = 10.0f;
        this.f = 6.0f;
        this.g = R.color.syc_dark_922CEE;
        a();
        Intrinsics.a(context);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.TriangleView, 0, 0);
        Intrinsics.c(obtainStyledAttributes, "context!!.theme.obtainSt…eable.TriangleView, 0, 0)");
        this.i = obtainStyledAttributes.getColor(R.styleable.TriangleView_trv_color, ContextCompat.getColor(getContext(), this.g));
        this.l = obtainStyledAttributes.getInt(R.styleable.TriangleView_trv_direction, this.l);
        obtainStyledAttributes.recycle();
        Paint paint = this.h;
        Intrinsics.a(paint);
        paint.setColor(this.i);
    }

    public final void a() {
        Paint paint = new Paint();
        this.h = paint;
        if (paint != null) {
            paint.setAntiAlias(true);
        }
        Paint paint2 = this.h;
        if (paint2 != null) {
            paint2.setStyle(Paint.Style.FILL);
        }
        this.m = new Path();
        this.l = this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.e(canvas, "canvas");
        super.onDraw(canvas);
        int i = this.l;
        if (i == this.a) {
            Path path = this.m;
            Intrinsics.a(path);
            path.moveTo(0.0f, this.k);
            Path path2 = this.m;
            Intrinsics.a(path2);
            path2.lineTo(this.j, this.k);
            Path path3 = this.m;
            Intrinsics.a(path3);
            path3.lineTo(this.j / 2, 0.0f);
        } else if (i == this.b) {
            Path path4 = this.m;
            Intrinsics.a(path4);
            path4.moveTo(0.0f, 0.0f);
            Path path5 = this.m;
            Intrinsics.a(path5);
            path5.lineTo(this.j / 2, this.k);
            Path path6 = this.m;
            Intrinsics.a(path6);
            path6.lineTo(this.j, 0.0f);
        } else if (i == this.c) {
            Path path7 = this.m;
            Intrinsics.a(path7);
            path7.moveTo(0.0f, 0.0f);
            Path path8 = this.m;
            Intrinsics.a(path8);
            path8.lineTo(0.0f, this.k);
            Path path9 = this.m;
            Intrinsics.a(path9);
            path9.lineTo(this.j, this.k / 2);
        } else if (i == this.d) {
            Path path10 = this.m;
            Intrinsics.a(path10);
            path10.moveTo(0.0f, this.k / 2);
            Path path11 = this.m;
            Intrinsics.a(path11);
            path11.lineTo(this.j, this.k);
            Path path12 = this.m;
            Intrinsics.a(path12);
            path12.lineTo(this.j, 0.0f);
        }
        Path path13 = this.m;
        Intrinsics.a(path13);
        path13.close();
        Path path14 = this.m;
        Intrinsics.a(path14);
        Paint paint = this.h;
        Intrinsics.a(paint);
        canvas.drawPath(path14, paint);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.j = View.MeasureSpec.getSize(i);
        this.k = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.j == 0 || mode != 1073741824) {
            this.j = UiUtils.a(AppInfo.d(), this.e);
        }
        if (this.k == 0 || mode2 != 1073741824) {
            this.k = UiUtils.a(AppInfo.d(), this.f);
        }
        setMeasuredDimension(this.j, this.k);
    }

    public final void setColor(int i) {
        Paint paint = this.h;
        if (paint != null) {
            paint.setColor(i);
        }
        postInvalidate();
    }
}
