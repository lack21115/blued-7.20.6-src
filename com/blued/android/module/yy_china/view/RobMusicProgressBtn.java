package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.module.yy_china.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/RobMusicProgressBtn.class */
public final class RobMusicProgressBtn extends View {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f17983a;
    private Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private long f17984c;
    private boolean d;
    private View.OnClickListener e;
    private int f;
    private View.OnClickListener g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RobMusicProgressBtn(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RobMusicProgressBtn(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobMusicProgressBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.f17983a = new Paint();
        this.f17984c = -1L;
        this.f = -1;
        this.b = BitmapFactory.decodeResource(getResources(), R.drawable.icon_bor_music_btn);
        this.f17983a.setColor(getResources().getColor(R.color.syc_C8EEFF));
        this.f17983a.setStrokeWidth(10.0f);
        this.f17983a.setAntiAlias(true);
        this.f17983a.setStyle(Paint.Style.STROKE);
        this.f17983a.setStrokeCap(Paint.Cap.ROUND);
    }

    public final View.OnClickListener getAniStopLi() {
        return this.e;
    }

    public final int getNumMax() {
        return this.f;
    }

    public final View.OnClickListener getOnClickList() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f < 0) {
            if (this.d) {
                View.OnClickListener onClickListener = this.e;
                if (onClickListener != null) {
                    onClickListener.onClick(null);
                }
                this.e = null;
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f17984c;
        if (currentTimeMillis > this.f * 1000) {
            View.OnClickListener onClickListener2 = this.g;
            if (onClickListener2 == null) {
                return;
            }
            onClickListener2.onClick(null);
            return;
        }
        double sin = (Math.sin(Math.toRadians((((float) (currentTimeMillis % 1500)) / 1500.0f) * 360.0d)) * getMeasuredHeight() * 0.05f) + (getMeasuredHeight() * 0.85f);
        int measuredHeight = (int) ((getMeasuredHeight() - sin) / 2.0f);
        int i = (int) (measuredHeight + sin);
        Rect rect = new Rect(measuredHeight, measuredHeight, i, i);
        Bitmap bitmap = this.b;
        if (bitmap != null && canvas != null) {
            canvas.drawBitmap(bitmap, (Rect) null, rect, this.f17983a);
        }
        if (canvas != null) {
            canvas.drawArc(new RectF(this.f17983a.getStrokeWidth() + 0.0f, this.f17983a.getStrokeWidth() + 0.0f, getMeasuredHeight() - this.f17983a.getStrokeWidth(), getMeasuredHeight() - this.f17983a.getStrokeWidth()), -90.0f, 360.0f - ((((float) currentTimeMillis) / (this.f * 1000.0f)) * 360.0f), false, this.f17983a);
        }
        invalidate();
    }

    public final void setAniStopLi(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    public final void setNumMax(int i) {
        this.f17984c = System.currentTimeMillis();
        this.f = i;
        this.d = true;
        invalidate();
    }

    public final void setOnClickList(View.OnClickListener onClickListener) {
        this.g = onClickListener;
    }
}
