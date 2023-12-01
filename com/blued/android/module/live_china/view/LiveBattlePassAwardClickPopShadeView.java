package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.view.View;
import com.blued.android.framework.utils.DensityUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveBattlePassAwardClickPopShadeView.class */
public final class LiveBattlePassAwardClickPopShadeView extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Context f14384a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f14385c;
    private int d;
    private int e;
    private int f;
    private int g;
    private float h;
    private Paint i;
    private Paint j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveBattlePassAwardClickPopShadeView(Context mContext, View atView) {
        super(mContext);
        Intrinsics.e(mContext, "mContext");
        Intrinsics.e(atView, "atView");
        this.f14384a = mContext;
        this.h = DensityUtils.a(getContext(), 6.0f);
        this.i = new Paint();
        this.j = new Paint();
        this.i.setAntiAlias(true);
        this.i.setDither(true);
        this.i.setARGB(204, 0, 0, 0);
        this.i.setStyle(Paint.Style.FILL);
        this.j.setAntiAlias(true);
        this.j.setDither(true);
        this.j.setARGB(255, 0, 0, 0);
        this.j.setStyle(Paint.Style.FILL);
        this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
        int[] iArr = new int[2];
        atView.getLocationOnScreen(iArr);
        int a2 = DensityUtils.a(this.f14384a, 87.0f);
        this.d = iArr[0] - ((a2 - atView.getWidth()) / 2);
        this.e = iArr[1] - ((a2 - atView.getHeight()) / 2);
        this.f = a2;
        this.g = a2;
        this.h = a2 / 2;
    }

    private final void a(int i, int i2) {
        this.b = i;
        this.f14385c = i2;
        invalidate();
    }

    private final void a(Canvas canvas) {
        RectF rectF = new RectF(0.0f, 0.0f, this.b, this.f14385c);
        if (canvas == null) {
            return;
        }
        canvas.drawRect(rectF, this.i);
    }

    private final void b(Canvas canvas) {
        float f = this.d;
        float f2 = this.e;
        RectF rectF = new RectF(f, f2, this.f + f, this.g + f2);
        if (canvas == null) {
            return;
        }
        float f3 = this.h;
        canvas.drawRoundRect(rectF, f3, f3, this.j);
    }

    public final Paint getCutoutPaint() {
        return this.j;
    }

    public final Context getMContext() {
        return this.f14384a;
    }

    public final Paint getShadePaint() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        a(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a(i, i2);
    }

    public final void setCutoutPaint(Paint paint) {
        Intrinsics.e(paint, "<set-?>");
        this.j = paint;
    }

    public final void setShadePaint(Paint paint) {
        Intrinsics.e(paint, "<set-?>");
        this.i = paint;
    }
}
