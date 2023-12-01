package com.soft.blued.customview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.framework.utils.DensityUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/VoteBar.class */
public class VoteBar extends View {

    /* renamed from: a  reason: collision with root package name */
    private Context f28537a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f28538c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private Paint k;
    private Paint l;

    /* renamed from: com.soft.blued.customview.VoteBar$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/VoteBar$1.class */
    class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f28539a;
        final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f28540c;
        final /* synthetic */ int d;
        final /* synthetic */ VoteBar e;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            VoteBar voteBar = this.e;
            int i = this.f28539a;
            int i2 = this.b;
            voteBar.f28538c = ((int) ((i - i2) * floatValue)) + i2;
            VoteBar voteBar2 = this.e;
            int i3 = this.f28540c;
            int i4 = this.d;
            voteBar2.b = ((int) ((i3 - i4) * floatValue)) + i4;
            this.e.postInvalidate();
        }
    }

    public VoteBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = false;
        a(context);
    }

    public VoteBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = false;
        a(context);
    }

    private Paint a(boolean z) {
        Paint paint = new Paint();
        if (z) {
            paint.setColor(this.f28537a.getResources().getColor(2131101305));
        } else {
            paint.setColor(this.f28537a.getResources().getColor(2131101306));
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(1.0f);
        paint.setAntiAlias(true);
        return paint;
    }

    private Path a(int i) {
        int i2;
        int i3;
        int i4;
        Point point = new Point(this.f, this.g + (this.e * 2));
        Path path = new Path();
        path.moveTo(point.x, point.y);
        float f = this.f;
        float f2 = this.g;
        int i5 = this.e;
        path.arcTo(new RectF(f, f2, i2 + (i5 * 2), i3 + (i5 * 2)), 180.0f, 90.0f);
        Point point2 = new Point(this.f + (this.e * 2) + i, this.g);
        path.lineTo(point2.x, point2.y);
        Point point3 = new Point(getShortLineWidth() + this.f + (this.e * 2) + i, this.i);
        path.lineTo(point3.x, point3.y);
        Point point4 = new Point(this.f + (this.e * 2), this.i);
        path.lineTo(point4.x, point4.y);
        float f3 = this.f;
        int i6 = this.i;
        int i7 = this.e;
        path.arcTo(new RectF(f3, i6 - (i7 * 2), i4 + (i7 * 2), i6), 90.0f, 90.0f);
        path.lineTo(point.x, point.y);
        return path;
    }

    private Path b(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        Point point = new Point(this.h, this.i - (this.e * 2));
        Path path = new Path();
        path.moveTo(point.x, point.y);
        int i6 = this.h;
        path.arcTo(new RectF(i6 - (this.e * 2), i3 - (i2 * 2), i6, this.i), 0.0f, 90.0f);
        Point point2 = new Point((this.h - i) - (this.e * 2), this.i);
        path.lineTo(point2.x, point2.y);
        Point point3 = new Point(((this.h - i) - (this.e * 2)) - getShortLineWidth(), this.g);
        path.lineTo(point3.x, point3.y);
        Point point4 = new Point(this.h - (this.e * 2), this.g);
        path.lineTo(point4.x, point4.y);
        int i7 = this.h;
        path.arcTo(new RectF(i7 - (this.e * 2), this.g, i7, i5 + (i4 * 2)), 270.0f, 90.0f);
        path.lineTo(point.x, point.y);
        return path;
    }

    private Path getRoundSquarePath() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Path path = new Path();
        Point point = new Point(this.f, this.g + (this.e * 2));
        Point point2 = new Point(this.h - (this.e * 2), this.g);
        Point point3 = new Point(this.h, this.i - (this.e * 2));
        Point point4 = new Point(this.f + (this.e * 2), this.i);
        path.moveTo(point.x, point.y);
        float f = this.f;
        float f2 = this.g;
        int i8 = this.e;
        path.arcTo(new RectF(f, f2, i + (i8 * 2), i2 + (i8 * 2)), 180.0f, 90.0f);
        path.lineTo(point2.x, point2.y);
        int i9 = this.h;
        path.arcTo(new RectF(i9 - (this.e * 2), this.g, i9, i4 + (i3 * 2)), 270.0f, 90.0f);
        path.lineTo(point3.x, point3.y);
        int i10 = this.h;
        path.arcTo(new RectF(i10 - (this.e * 2), i6 - (i5 * 2), i10, this.i), 0.0f, 90.0f);
        path.lineTo(point4.x, point4.y);
        float f3 = this.f;
        int i11 = this.i;
        int i12 = this.e;
        path.arcTo(new RectF(f3, i11 - (i12 * 2), i7 + (i12 * 2), i11), 90.0f, 90.0f);
        path.lineTo(point.x, point.y);
        return path;
    }

    private int getShortLineWidth() {
        return (int) ((this.i - this.g) * 0.26794919243112d);
    }

    public void a(Context context) {
        this.f28537a = context;
        if ("en".equals(BlueAppLocal.a())) {
            this.d = DensityUtils.a(this.f28537a, 70.0f);
        } else {
            this.d = DensityUtils.a(this.f28537a, 47.0f);
        }
        this.e = DensityUtils.a(this.f28537a, 5.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.j) {
            this.f = getPaddingLeft();
            this.g = getPaddingTop();
            this.h = getWidth() - getPaddingRight();
            this.i = getHeight() - getPaddingBottom();
            this.k = a(true);
            this.l = a(false);
            int i = this.d;
            this.f28538c = i;
            this.b = i;
            this.j = true;
        }
        int i2 = this.f28538c;
        int i3 = this.d;
        if (i2 == i3 && this.b == i3) {
            canvas.drawPath(a(i2), this.k);
            canvas.drawPath(b(this.b), this.l);
        } else if (this.f28538c == 0) {
            canvas.drawPath(getRoundSquarePath(), this.l);
        } else {
            int i4 = this.b;
            if (i4 == 0) {
                canvas.drawPath(getRoundSquarePath(), this.k);
                return;
            }
            canvas.drawPath(b(i4), this.l);
            canvas.drawPath(a(this.f28538c), this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
