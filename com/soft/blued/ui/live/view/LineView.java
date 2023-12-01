package com.soft.blued.ui.live.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import com.blued.android.module.live_china.model.LiveFansRelationModel;
import com.soft.blued.R;
import com.soft.blued.ui.live.utils.FormatUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/view/LineView.class */
public class LineView extends View {
    private float A;
    private float B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private float I;
    private float J;
    private float K;
    private float L;
    private float M;
    private Float N;
    private Float O;
    private float P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;

    /* renamed from: a  reason: collision with root package name */
    private int f17622a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f17623c;
    private Paint d;
    private Paint e;
    private Paint f;
    private Paint g;
    private Paint h;
    private Paint i;
    private Paint j;
    private Paint k;
    private Paint l;
    private List<Float> m;
    private List<Float> n;
    private List<String> o;
    private float p;
    private float q;
    private float r;
    private float s;
    private float t;
    private int u;
    private int v;
    private int w;
    private int x;
    private Rect y;
    private Rect z;

    public LineView(Context context) {
        this(context, null);
    }

    public LineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = 15.0f;
        this.q = 2.0f;
        this.r = 8.0f;
        this.s = 3.0f;
        this.t = 10.0f;
        this.C = 6;
        this.D = 2171195;
        this.E = 10;
        this.F = -3750202;
        this.G = -10994177;
        this.H = -7368815;
        this.I = 1.5f;
        this.M = 10.0f;
        this.P = 2.0f;
        this.Q = -866030849;
        this.R = -10392833;
        this.S = -11842454;
        this.V = -1;
        a();
    }

    private int a(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    private Float a(Float f, int i, boolean z) {
        return Float.valueOf(z ? new BigDecimal(f.floatValue()).setScale(i, 0).floatValue() : new BigDecimal(f.floatValue()).setScale(i, 1).floatValue());
    }

    private Float a(List<Float> list, boolean z) {
        return (Float) (z ? Collections.max(list) : Collections.min(list));
    }

    private void a() {
        Paint paint = new Paint();
        this.f17623c = paint;
        paint.setAntiAlias(true);
        this.f17623c.setDither(true);
        this.f17623c.setColor(this.D);
        Paint paint2 = new Paint();
        this.d = paint2;
        paint2.setAntiAlias(true);
        this.d.setDither(true);
        this.d.setTextAlign(Paint.Align.CENTER);
        this.d.setTextSize(b(getContext(), this.E));
        this.d.setColor(this.F);
        Paint paint3 = new Paint();
        this.e = paint3;
        paint3.setAntiAlias(true);
        this.e.setDither(true);
        this.e.setTextAlign(Paint.Align.CENTER);
        this.e.setTextSize(b(getContext(), this.E));
        this.e.setColor(this.G);
        Paint paint4 = new Paint();
        this.k = paint4;
        paint4.setAntiAlias(true);
        this.k.setDither(true);
        this.k.setTextAlign(Paint.Align.CENTER);
        this.k.setTextSize(b(getContext(), 9.0f));
        this.k.setColor(this.H);
        Paint paint5 = new Paint();
        this.f = paint5;
        paint5.setAntiAlias(true);
        this.f.setDither(true);
        this.f.setColor(this.G);
        this.f.setStrokeWidth(a(getContext(), this.I));
        this.f.setStyle(Paint.Style.STROKE);
        Paint paint6 = new Paint();
        this.g = paint6;
        paint6.setAntiAlias(true);
        this.g.setDither(true);
        this.g.setColor(this.F);
        this.g.setStrokeWidth(a(getContext(), this.P));
        this.g.setStyle(Paint.Style.STROKE);
        this.T = a(getContext(), 2.0f);
        this.U = a(getContext(), 5.0f);
        this.p = a(getContext(), this.p);
        this.q = a(getContext(), this.q);
        this.r = a(getContext(), this.r);
        this.t = a(getContext(), this.t);
        this.s = a(getContext(), this.s);
        Rect rect = new Rect();
        this.y = rect;
        this.d.getTextBounds("2.0-", 0, 4, rect);
        this.u = this.y.width();
        this.d.getTextBounds("03-14", 0, 5, this.y);
        this.v = this.y.height();
        this.z = new Rect();
        this.k.getTextBounds(getContext().getString(R.string.live_fans_join), 0, getContext().getString(R.string.live_fans_join).length(), this.z);
        this.w = this.z.width();
        this.k.getTextBounds(getContext().getString(R.string.live_fans_join), 0, getContext().getString(R.string.live_fans_join).length(), this.z);
        int height = this.z.height();
        this.x = height;
        this.K = height;
        this.h = new Paint();
        this.i = new Paint(this.h);
        this.h.setColor(this.Q);
        this.h.setAntiAlias(true);
        this.i.setColor(this.R);
        Paint paint7 = new Paint();
        this.j = paint7;
        paint7.setStyle(Paint.Style.STROKE);
        this.j.setColor(this.S);
        this.j.setStrokeWidth(3.0f);
        this.j.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
        Paint paint8 = new Paint();
        this.l = paint8;
        paint8.setStyle(Paint.Style.FILL);
    }

    private void a(float f, Canvas canvas) {
        canvas.save();
        canvas.drawText(FormatUtils.a(f), this.L, this.M - b(getContext(), this.E + 2), this.e);
        canvas.restore();
    }

    private void a(Canvas canvas) {
        List<String> list = this.o;
        if (list == null || list.size() == 0) {
            return;
        }
        this.O = a(a(this.m, true), 0, true);
        this.N = a(a(this.m, false), 0, false);
        for (int i = 0; i < this.m.size(); i++) {
            this.L = a(i);
            this.M = a(this.m.get(i));
            if (i <= this.m.size() - 2) {
                int a2 = (int) a(i);
                int a3 = (int) a(this.m.get(i));
                int i2 = i + 1;
                int a4 = (int) a(i2);
                int a5 = (int) a(this.m.get(i2));
                int i3 = (a2 + a4) / 2;
                Point point = new Point();
                Point point2 = new Point();
                point.y = a3;
                point.x = i3;
                point2.y = a5;
                point2.x = i3;
                Path path = new Path();
                path.moveTo(a2, a3);
                path.cubicTo(point.x, point.y, point2.x, point2.y, a4, a5);
                canvas.drawPath(path, this.f);
            }
            a(this.m.get(i).floatValue(), canvas);
        }
    }

    private int b(Context context, float f) {
        return (int) TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }

    private void b(Canvas canvas) {
        List<String> list = this.o;
        if (list == null || list.size() == 0) {
            return;
        }
        canvas.save();
        canvas.translate(this.f17622a - this.A, this.B + this.p + (this.q / 2.0f));
        float size = this.A / (this.o.size() + 1);
        this.J = size;
        canvas.drawLine(size - this.u, 0.0f, (size * this.o.size()) + this.u, 0.0f, this.g);
        canvas.translate(0.0f, (this.q / 2.0f) + this.r + (this.v / 2));
        for (String str : this.o) {
            canvas.translate(this.J, 0.0f);
            canvas.drawText(str, 0.0f, 0.0f, this.d);
        }
        if (this.V >= 0) {
            canvas.translate(((-this.J) * this.o.size()) - b(getContext(), 2.0f), (this.v / 2) + this.s + (this.x / 2));
            canvas.translate(this.J * (this.V + 1), a(getContext(), 1.0f));
            canvas.drawText(getContext().getString(R.string.live_fans_join), 0.0f, 0.0f, this.d);
        }
        canvas.restore();
    }

    public float a(int i) {
        return (this.f17622a - this.A) + (this.J * (i + 1));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0077, code lost:
        if (r0 < r0) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public float a(java.lang.Float r7) {
        /*
            Method dump skipped, instructions count: 178
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.live.view.LineView.a(java.lang.Float):float");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.A = this.f17622a;
        this.B = (((((this.b - this.p) - this.q) - this.r) - this.v) - this.s) - this.x;
        b(canvas);
        a(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        this.f17622a = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            this.b = a(getContext(), 350.0f);
        } else if (mode == 1073741824) {
            this.b = size;
        }
        setMeasuredDimension(this.f17622a, this.b);
    }

    public void setData(List<LiveFansRelationModel> list) {
        if (list == null) {
            return;
        }
        this.o.clear();
        this.m.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                invalidate();
                return;
            }
            LiveFansRelationModel liveFansRelationModel = list.get(i2);
            this.o.add(liveFansRelationModel.date);
            this.m.add(Float.valueOf(liveFansRelationModel.value));
            if (liveFansRelationModel.is_join == 1) {
                this.V = i2;
            }
            i = i2 + 1;
        }
    }
}
