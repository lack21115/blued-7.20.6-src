package com.blued.android.framework.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.R;
import com.blued.android.framework.utils.DensityUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/HoleRelativeLayout.class */
public class HoleRelativeLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private List<RoundRect> f10174a;
    private Paint b;

    /* renamed from: c  reason: collision with root package name */
    private Xfermode f10175c;
    private Activity d;
    private boolean e;
    private boolean f;
    private View.OnClickListener g;
    private int h;

    /* renamed from: com.blued.android.framework.view.HoleRelativeLayout$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/HoleRelativeLayout$1.class */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f10176a;
        final /* synthetic */ Activity b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ HoleRelativeLayout f10177c;

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr;
            this.f10176a.getLocationInWindow(new int[2]);
            RoundRect roundRect = new RoundRect();
            roundRect.f10179c = (this.f10176a.getWidth() - this.f10176a.getPaddingLeft()) - this.f10176a.getPaddingRight();
            roundRect.d = (this.f10176a.getHeight() - this.f10176a.getPaddingTop()) - this.f10176a.getPaddingBottom();
            roundRect.f10178a = iArr[0] + this.f10176a.getPaddingLeft();
            if (this.f10177c.b()) {
                roundRect.b = iArr[1] + this.f10176a.getPaddingTop();
            } else {
                roundRect.b = (iArr[1] + this.f10176a.getPaddingTop()) - DensityUtils.a(this.b);
            }
            float f = roundRect.f10178a;
            float f2 = roundRect.f10179c;
            float f3 = roundRect.b;
            float f4 = roundRect.d;
            if (roundRect.f10179c < roundRect.d) {
                roundRect.f10179c = roundRect.d;
            }
            float paddingRight = (this.f10176a.getPaddingLeft() > this.f10176a.getPaddingRight() ? this.f10176a.getPaddingRight() : this.f10176a.getPaddingLeft()) * 0.7f;
            float paddingBottom = (this.f10176a.getPaddingTop() > this.f10176a.getPaddingBottom() ? this.f10176a.getPaddingBottom() : this.f10176a.getPaddingTop()) * 0.7f;
            roundRect.f10178a = ((f + (f2 * 0.5f)) - (roundRect.f10179c * 0.5f)) - paddingRight;
            roundRect.b = ((f3 + (f4 * 0.5f)) - (roundRect.d * 0.5f)) - paddingBottom;
            roundRect.f10179c += paddingRight * 2.0f;
            roundRect.d += paddingBottom * 2.0f;
            roundRect.a(roundRect.d * 0.5f);
            this.f10177c.a(roundRect);
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/HoleRelativeLayout$RoundRect.class */
    public static class RoundRect {

        /* renamed from: a  reason: collision with root package name */
        public float f10178a;
        public float b;

        /* renamed from: c  reason: collision with root package name */
        public float f10179c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;

        public void a(float f) {
            this.e = f;
            this.f = f;
            this.g = f;
            this.h = f;
        }

        public String toString() {
            return "RoundRect{x=" + this.f10178a + ", y=" + this.b + ", width=" + this.f10179c + ", height=" + this.d + ", leftTopRadius=" + this.e + ", rightTopRadius=" + this.f + ", leftBottomRadius=" + this.g + ", rightBottomRadius=" + this.h + '}';
        }
    }

    public HoleRelativeLayout(Context context) {
        this(context, null);
    }

    public HoleRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HoleRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = false;
        this.f = true;
        this.h = Color.parseColor("#D91E2327");
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HoleRelativeLayout);
        this.h = obtainStyledAttributes.getColor(R.styleable.HoleRelativeLayout_bgColor, this.h);
        obtainStyledAttributes.recycle();
        this.f10174a = new ArrayList();
        Paint paint = new Paint();
        this.b = paint;
        paint.setAntiAlias(true);
        this.f10175c = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
    }

    private void a(Canvas canvas, RoundRect roundRect) {
        Path path = new Path();
        path.moveTo(roundRect.f10178a + roundRect.e, roundRect.b);
        path.lineTo((roundRect.f10178a + roundRect.f10179c) - roundRect.f, roundRect.b);
        path.arcTo(new RectF((roundRect.f10178a + roundRect.f10179c) - (roundRect.f * 2.0f), roundRect.b, roundRect.f10178a + roundRect.f10179c, roundRect.b + (roundRect.f * 2.0f)), 270.0f, 90.0f);
        path.lineTo(roundRect.f10178a + roundRect.f10179c, (roundRect.b + roundRect.d) - roundRect.h);
        path.arcTo(new RectF((roundRect.f10178a + roundRect.f10179c) - (roundRect.h * 2.0f), (roundRect.b + roundRect.d) - (roundRect.h * 2.0f), roundRect.f10178a + roundRect.f10179c, roundRect.b + roundRect.d), 0.0f, 90.0f);
        path.lineTo(roundRect.f10178a + roundRect.g, roundRect.b + roundRect.d);
        path.arcTo(new RectF(roundRect.f10178a, (roundRect.b + roundRect.d) - (roundRect.g * 2.0f), roundRect.f10178a + (roundRect.g * 2.0f), roundRect.b + roundRect.d), 90.0f, 90.0f);
        path.lineTo(roundRect.f10178a, roundRect.b + roundRect.e);
        path.arcTo(new RectF(roundRect.f10178a, roundRect.b, roundRect.f10178a + (roundRect.e * 2.0f), roundRect.b + (roundRect.e * 2.0f)), 180.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        Activity activity = this.d;
        if (activity != null) {
            return AppInfo.m == activity.findViewById(16908290).getHeight();
        }
        return false;
    }

    public void a() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeView(this);
        View.OnClickListener onClickListener = this.g;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void a(RoundRect roundRect) {
        this.f10174a.add(roundRect);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        canvas.drawColor(this.h);
        this.b.setXfermode(this.f10175c);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f10174a.size()) {
                this.b.setXfermode(null);
                canvas.restoreToCount(saveLayer);
                return;
            }
            a(canvas, this.f10174a.get(i2));
            i = i2 + 1;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.e) {
            if (motionEvent.getAction() != 1) {
                return true;
            }
            a();
            return true;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f10174a.size()) {
                return true;
            }
            RoundRect roundRect = this.f10174a.get(i2);
            if (motionEvent.getX() >= roundRect.f10178a && motionEvent.getX() <= roundRect.f10178a + roundRect.f10179c && motionEvent.getY() >= roundRect.b && motionEvent.getY() <= roundRect.b + roundRect.d) {
                if (this.f) {
                    return super.onTouchEvent(motionEvent);
                }
                return true;
            }
            i = i2 + 1;
        }
    }

    public void setCanDetachOnTouched(boolean z) {
        this.e = z;
    }

    public void setIfHoleCanDetach(boolean z) {
        this.f = z;
    }

    public void setOnDetachLisnter(View.OnClickListener onClickListener) {
        this.g = onClickListener;
    }
}
