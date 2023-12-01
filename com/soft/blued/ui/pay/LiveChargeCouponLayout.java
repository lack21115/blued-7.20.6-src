package com.soft.blued.ui.pay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/pay/LiveChargeCouponLayout.class */
public class LiveChargeCouponLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f19294a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f19295c;
    private Paint d;
    private Paint e;
    private Path f;
    private Path g;
    private PathEffect h;
    private int i;

    public LiveChargeCouponLayout(Context context) {
        this(context, null);
    }

    public LiveChargeCouponLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveChargeCouponLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new Paint();
        this.f = new Path();
        this.g = new Path();
        this.i = 0;
        this.f19294a = context;
        a();
    }

    private void a() {
        this.f19295c = DisplayUtil.a(this.f19294a, 6.0f);
        this.b = DisplayUtil.a(this.f19294a, 0.5f);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setAntiAlias(true);
        this.d.setDither(true);
        this.d.setStrokeWidth(this.b);
        if (LiveRoomInfo.a().h()) {
            this.d.setColor(Color.parseColor("#2C2C2C"));
        } else {
            this.d.setColor(Color.parseColor("#E5E5E5"));
        }
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{DisplayUtil.a(this.f19294a, 4.0f), DisplayUtil.a(this.f19294a, 4.0f)}, 0.0f);
        this.h = dashPathEffect;
        this.d.setPathEffect(dashPathEffect);
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setDither(true);
        if (LiveRoomInfo.a().h()) {
            this.e.setColor(Color.parseColor("#151515"));
        } else {
            this.e.setColor(-1);
        }
        this.e.setStrokeWidth(this.b);
        this.e.setStyle(Paint.Style.FILL);
        setBackgroundResource(2131102388);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getMeasuredWidth() > 0) {
            canvas.drawPath(this.f, this.e);
            canvas.drawLine(this.f19295c, this.i, getMeasuredWidth() - this.f19295c, this.i, this.d);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.i = getMeasuredHeight() - DisplayUtil.a(this.f19294a, 40.0f);
            this.g.reset();
            this.g.addCircle(0.0f, this.i, this.f19295c, Path.Direction.CW);
            this.g.addCircle(getMeasuredWidth(), this.i, this.f19295c, Path.Direction.CW);
            this.g.close();
            this.f.reset();
            Path path = this.f;
            float measuredWidth = getMeasuredWidth();
            float measuredHeight = getMeasuredHeight();
            int i5 = this.f19295c;
            path.addRoundRect(0.0f, 0.0f, measuredWidth, measuredHeight, i5, i5, Path.Direction.CW);
            this.f.op(this.g, Path.Op.DIFFERENCE);
            this.f.close();
        }
    }
}
