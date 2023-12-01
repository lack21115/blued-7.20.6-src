package com.blued.android.framework.view.badgeview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.blued.android.framework.view.badgeview.Badge;
import com.google.android.material.badge.BadgeDrawable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/badgeview/QBadgeView.class */
public class QBadgeView extends View implements Badge {
    protected Paint.FontMetrics A;
    protected PointF B;
    protected PointF C;
    protected PointF D;
    protected PointF E;
    protected List<PointF> F;
    protected View G;
    protected int H;
    protected int I;
    protected TextPaint J;
    protected Paint K;
    protected Paint L;
    protected BadgeAnimator M;
    protected Badge.OnDragStateChangedListener N;
    protected ViewGroup O;
    public long P;

    /* renamed from: a  reason: collision with root package name */
    protected int f10207a;
    protected int b;

    /* renamed from: c  reason: collision with root package name */
    protected int f10208c;
    protected Drawable d;
    protected Bitmap e;
    protected boolean f;
    protected float g;
    protected float h;
    protected float i;
    protected int j;
    protected String k;
    protected boolean l;
    protected boolean m;
    protected boolean n;
    protected boolean o;
    protected int p;
    protected float q;
    protected float r;
    protected float s;
    protected float t;
    protected float u;
    protected int v;
    protected boolean w;
    protected RectF x;
    protected RectF y;
    protected Path z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/badgeview/QBadgeView$BadgeContainer.class */
    public class BadgeContainer extends ViewGroup {
        public BadgeContainer(Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= getChildCount()) {
                    return;
                }
                View childAt = getChildAt(i6);
                childAt.layout(0, 0, childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
                i5 = i6 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.view.View
        public void onMeasure(int i, int i2) {
            View view = null;
            View view2 = null;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= getChildCount()) {
                    break;
                }
                View childAt = getChildAt(i4);
                if (childAt instanceof QBadgeView) {
                    view2 = childAt;
                } else {
                    view = childAt;
                }
                i3 = i4 + 1;
            }
            if (view == null) {
                super.onMeasure(i, i2);
                return;
            }
            view.measure(i, i2);
            if (view2 != null) {
                view2.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824));
            }
            setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public QBadgeView(Context context) {
        this(context, null);
    }

    private QBadgeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private QBadgeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.s = 0.0f;
        this.P = 0L;
        c();
    }

    private void a(Canvas canvas) {
        this.K.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        int i = (int) this.y.left;
        int i2 = (int) this.y.top;
        int i3 = (int) this.y.right;
        int i4 = (int) this.y.bottom;
        if (this.f) {
            i3 = this.e.getWidth() + i;
            i4 = this.e.getHeight() + i2;
            canvas.saveLayer(i, i2, i3, i4, null, 31);
        }
        this.d.setBounds(i, i2, i3, i4);
        this.d.draw(canvas);
        if (!this.f) {
            canvas.drawRect(this.y, this.L);
            return;
        }
        this.K.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(this.e, i, i2, this.K);
        canvas.restore();
        this.K.setXfermode(null);
        if (this.k.isEmpty() || this.k.length() == 1) {
            canvas.drawCircle(this.y.centerX(), this.y.centerY(), this.y.width() / 2.0f, this.L);
            return;
        }
        RectF rectF = this.y;
        canvas.drawRoundRect(rectF, rectF.height() / 2.0f, this.y.height() / 2.0f, this.L);
    }

    private void a(Canvas canvas, float f, float f2) {
        float f3;
        float f4;
        float f5;
        float f6 = this.C.y;
        float f7 = this.D.y;
        float f8 = this.C.x - this.D.x;
        this.F.clear();
        if (f8 != 0.0f) {
            double d = (-1.0d) / ((f6 - f7) / f8);
            MathUtil.a(this.C, f2, Double.valueOf(d), this.F);
            MathUtil.a(this.D, f, Double.valueOf(d), this.F);
        } else {
            MathUtil.a(this.C, f2, Double.valueOf(0.0d), this.F);
            MathUtil.a(this.D, f, Double.valueOf(0.0d), this.F);
        }
        this.z.reset();
        Path path = this.z;
        float f9 = this.D.x;
        float f10 = this.D.y;
        int i = this.v;
        path.addCircle(f9, f10, f, (i == 1 || i == 2) ? Path.Direction.CCW : Path.Direction.CW);
        this.E.x = (this.D.x + this.C.x) / 2.0f;
        this.E.y = (this.D.y + this.C.y) / 2.0f;
        this.z.moveTo(this.F.get(2).x, this.F.get(2).y);
        this.z.quadTo(this.E.x, this.E.y, this.F.get(0).x, this.F.get(0).y);
        this.z.lineTo(this.F.get(1).x, this.F.get(1).y);
        this.z.quadTo(this.E.x, this.E.y, this.F.get(3).x, this.F.get(3).y);
        this.z.lineTo(this.F.get(2).x, this.F.get(2).y);
        this.z.close();
        canvas.drawPath(this.z, this.K);
        if (this.b == 0 || this.g <= 0.0f) {
            return;
        }
        this.z.reset();
        this.z.moveTo(this.F.get(2).x, this.F.get(2).y);
        this.z.quadTo(this.E.x, this.E.y, this.F.get(0).x, this.F.get(0).y);
        this.z.moveTo(this.F.get(1).x, this.F.get(1).y);
        this.z.quadTo(this.E.x, this.E.y, this.F.get(3).x, this.F.get(3).y);
        int i2 = this.v;
        if (i2 == 1 || i2 == 2) {
            f3 = this.F.get(2).x - this.D.x;
            f4 = this.D.y;
            f5 = this.F.get(2).y;
        } else {
            f3 = this.F.get(3).x - this.D.x;
            f4 = this.D.y;
            f5 = this.F.get(3).y;
        }
        double atan = Math.atan((f4 - f5) / f3);
        int i3 = this.v;
        float a2 = 360.0f - ((float) MathUtil.a(MathUtil.a(atan, i3 - 1 == 0 ? 4 : i3 - 1)));
        if (Build.VERSION.SDK_INT >= 21) {
            this.z.addArc(this.D.x - f, this.D.y - f, this.D.x + f, this.D.y + f, a2, 180.0f);
        } else {
            this.z.addArc(new RectF(this.D.x - f, this.D.y - f, this.D.x + f, this.D.y + f), a2, 180.0f);
        }
        canvas.drawPath(this.z, this.L);
    }

    private void a(Canvas canvas, PointF pointF, float f) {
        if (pointF.x == -1000.0f && pointF.y == -1000.0f) {
            return;
        }
        if (this.k.isEmpty() || this.k.length() == 1) {
            float f2 = (int) f;
            this.y.left = pointF.x - f2;
            this.y.top = pointF.y - f2;
            this.y.right = pointF.x + f2;
            this.y.bottom = pointF.y + f2;
            if (this.d != null) {
                a(canvas);
            } else {
                canvas.drawCircle(pointF.x, pointF.y, f, this.K);
                if (this.b != 0 && this.g > 0.0f) {
                    canvas.drawCircle(pointF.x, pointF.y, f, this.L);
                }
            }
        } else {
            this.y.left = pointF.x - ((this.x.width() / 2.0f) + this.i);
            this.y.top = pointF.y - ((this.x.height() / 2.0f) + (this.i * 0.3f));
            this.y.right = pointF.x + (this.x.width() / 2.0f) + this.i;
            this.y.bottom = pointF.y + (this.x.height() / 2.0f) + (this.i * 0.3f);
            float height = this.y.height() / 2.0f;
            if (this.d != null) {
                a(canvas);
            } else {
                canvas.drawRoundRect(this.y, height, height, this.K);
                if (this.b != 0 && this.g > 0.0f) {
                    canvas.drawRoundRect(this.y, height, height, this.L);
                }
            }
        }
        if (this.k.isEmpty()) {
            return;
        }
        canvas.drawText(this.k, pointF.x, (((this.y.bottom + this.y.top) - this.A.bottom) - this.A.top) / 2.0f, this.J);
    }

    private void b(View view) {
        if (view.getParent() != null && (view.getParent() instanceof View)) {
            b((View) view.getParent());
        } else if (view instanceof ViewGroup) {
            this.O = (ViewGroup) view;
        }
    }

    private void c() {
        setLayerType(1, null);
        this.x = new RectF();
        this.y = new RectF();
        this.z = new Path();
        this.B = new PointF();
        this.C = new PointF();
        this.D = new PointF();
        this.E = new PointF();
        this.F = new ArrayList();
        TextPaint textPaint = new TextPaint();
        this.J = textPaint;
        textPaint.setAntiAlias(true);
        this.J.setSubpixelText(true);
        this.J.setFakeBoldText(true);
        this.J.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Paint paint = new Paint();
        this.K = paint;
        paint.setAntiAlias(true);
        this.K.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.L = paint2;
        paint2.setAntiAlias(true);
        this.L.setStyle(Paint.Style.STROKE);
        this.f10207a = -1552832;
        this.f10208c = -1;
        this.h = DisplayUtil.a(getContext(), 11.0f);
        this.i = DisplayUtil.a(getContext(), 5.0f);
        this.j = 0;
        this.p = BadgeDrawable.TOP_END;
        this.q = DisplayUtil.a(getContext(), 5.0f);
        this.r = DisplayUtil.a(getContext(), 5.0f);
        this.s = DisplayUtil.a(getContext(), 10.0f);
        this.u = DisplayUtil.a(getContext(), 90.0f);
        this.o = false;
        this.f = false;
        if (Build.VERSION.SDK_INT >= 21) {
            setTranslationZ(1000.0f);
        }
    }

    private void d() {
        if (this.w) {
            a(this.C, true);
            return;
        }
        b();
        e(4);
    }

    private void d(boolean z) {
        int a2 = DisplayUtil.a(getContext(), 1.0f);
        int a3 = DisplayUtil.a(getContext(), 1.5f);
        int i = this.v;
        if (i == 1) {
            a2 = DisplayUtil.a(getContext(), 1.0f);
            a3 = DisplayUtil.a(getContext(), -1.5f);
        } else if (i == 2) {
            a2 = DisplayUtil.a(getContext(), -1.0f);
            a3 = DisplayUtil.a(getContext(), -1.5f);
        } else if (i == 3) {
            a2 = DisplayUtil.a(getContext(), -1.0f);
            a3 = DisplayUtil.a(getContext(), 1.5f);
        } else if (i == 4) {
            a2 = DisplayUtil.a(getContext(), 1.0f);
            a3 = DisplayUtil.a(getContext(), 1.5f);
        }
        this.K.setShadowLayer(z ? DisplayUtil.a(getContext(), 2.0f) : 0.0f, a2, a3, 855638016);
    }

    private void e() {
        d(this.o);
        this.K.setColor(this.f10207a);
        this.L.setColor(this.b);
        this.L.setStrokeWidth(this.g);
        this.J.setColor(this.f10208c);
        this.J.setTextAlign(Paint.Align.CENTER);
    }

    private void f() {
        if (this.k != null && this.f) {
            Bitmap bitmap = this.e;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.e.recycle();
            }
            float badgeCircleRadius = getBadgeCircleRadius();
            if (this.k.isEmpty() || this.k.length() == 1) {
                int i = ((int) badgeCircleRadius) * 2;
                this.e = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(this.e);
                canvas.drawCircle(canvas.getWidth() / 2.0f, canvas.getHeight() / 2.0f, canvas.getWidth() / 2.0f, this.K);
                return;
            }
            this.e = Bitmap.createBitmap((int) (this.x.width() + (this.i * 2.0f)), (int) (this.x.height() + this.i), Bitmap.Config.ARGB_4444);
            Canvas canvas2 = new Canvas(this.e);
            if (Build.VERSION.SDK_INT >= 21) {
                canvas2.drawRoundRect(0.0f, 0.0f, canvas2.getWidth(), canvas2.getHeight(), canvas2.getHeight() / 2.0f, canvas2.getHeight() / 2.0f, this.K);
            } else {
                canvas2.drawRoundRect(new RectF(0.0f, 0.0f, canvas2.getWidth(), canvas2.getHeight()), canvas2.getHeight() / 2.0f, canvas2.getHeight() / 2.0f, this.K);
            }
        }
    }

    private void g() {
        float height = this.x.height() > this.x.width() ? this.x.height() : this.x.width();
        switch (this.p) {
            case 17:
                this.B.x = this.H / 2.0f;
                this.B.y = this.I / 2.0f;
                break;
            case 49:
                this.B.x = this.H / 2.0f;
                this.B.y = this.r + this.i + (this.x.height() / 2.0f);
                break;
            case 81:
                this.B.x = this.H / 2.0f;
                this.B.y = this.I - ((this.r + this.i) + (this.x.height() / 2.0f));
                break;
            case 8388627:
                this.B.x = this.q + this.i + (height / 2.0f);
                this.B.y = this.I / 2.0f;
                break;
            case 8388629:
                this.B.x = this.H - ((this.q + this.i) + (height / 2.0f));
                this.B.y = this.I / 2.0f;
                break;
            case BadgeDrawable.TOP_START /* 8388659 */:
                this.B.x = this.q + this.i + (height / 2.0f);
                this.B.y = this.r + this.i + (this.x.height() / 2.0f);
                break;
            case BadgeDrawable.TOP_END /* 8388661 */:
                this.B.x = this.H - ((this.q + this.i) + (height / 2.0f));
                this.B.y = this.r + this.i + (this.x.height() / 2.0f);
                break;
            case BadgeDrawable.BOTTOM_START /* 8388691 */:
                this.B.x = this.q + this.i + (height / 2.0f);
                this.B.y = this.I - ((this.r + this.i) + (this.x.height() / 2.0f));
                break;
            case BadgeDrawable.BOTTOM_END /* 8388693 */:
                this.B.x = this.H - ((this.q + this.i) + (height / 2.0f));
                this.B.y = this.I - ((this.r + this.i) + (this.x.height() / 2.0f));
                break;
        }
        i();
    }

    private float getBadgeCircleRadius() {
        float width;
        float f;
        if (this.k.isEmpty()) {
            return this.i;
        }
        if (this.k.length() == 1) {
            if (this.x.height() > this.x.width()) {
                width = this.x.height() / 2.0f;
                f = this.i;
            } else {
                width = this.x.width() / 2.0f;
                f = this.i;
            }
            return width + (f * 0.5f);
        }
        return this.y.height() / 2.0f;
    }

    private void h() {
        this.x.left = 0.0f;
        this.x.top = 0.0f;
        if (TextUtils.isEmpty(this.k)) {
            this.x.right = 0.0f;
            this.x.bottom = 0.0f;
        } else {
            this.J.setTextSize(this.h);
            this.x.right = this.J.measureText(this.k);
            Paint.FontMetrics fontMetrics = this.J.getFontMetrics();
            this.A = fontMetrics;
            this.x.bottom = fontMetrics.descent - this.A.ascent;
        }
        f();
    }

    private void i() {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        this.D.x = this.B.x + iArr[0];
        this.D.y = this.B.y + iArr[1];
    }

    protected Bitmap a() {
        Bitmap createBitmap = Bitmap.createBitmap(((int) this.y.width()) + DisplayUtil.a(getContext(), 3.0f), ((int) this.y.height()) + DisplayUtil.a(getContext(), 3.0f), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        a(canvas, new PointF(canvas.getWidth() / 2.0f, canvas.getHeight() / 2.0f), getBadgeCircleRadius());
        return createBitmap;
    }

    public Badge a(float f, float f2, boolean z) {
        float f3 = f;
        if (z) {
            f3 = DisplayUtil.a(getContext(), f);
        }
        this.q = f3;
        float f4 = f2;
        if (z) {
            f4 = DisplayUtil.a(getContext(), f2);
        }
        this.r = f4;
        invalidate();
        return this;
    }

    public Badge a(float f, boolean z) {
        float f2 = f;
        if (z) {
            f2 = DisplayUtil.a(getContext(), f);
        }
        this.h = f2;
        h();
        invalidate();
        return this;
    }

    public Badge a(int i) {
        this.j = i;
        if (i < 0) {
            this.k = "";
        } else if (i > 99) {
            this.k = this.n ? String.valueOf(i) : "99+";
        } else if (i > 0 && i <= 99) {
            this.k = String.valueOf(i);
        } else if (this.j == 0) {
            this.k = null;
        }
        h();
        invalidate();
        return this;
    }

    public Badge a(int i, float f, boolean z) {
        this.b = i;
        float f2 = f;
        if (z) {
            f2 = DisplayUtil.a(getContext(), f);
        }
        this.g = f2;
        invalidate();
        return this;
    }

    public Badge a(View view) {
        if (view != null) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
            ViewParent parent = view.getParent();
            if (parent == null || !(parent instanceof ViewGroup)) {
                throw new IllegalStateException("targetView must have a parent");
            }
            this.G = view;
            if (parent instanceof BadgeContainer) {
                ((BadgeContainer) parent).addView(this);
                return this;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            int indexOfChild = viewGroup.indexOfChild(view);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            viewGroup.removeView(view);
            BadgeContainer badgeContainer = new BadgeContainer(getContext());
            badgeContainer.setId(view.getId());
            viewGroup.addView(badgeContainer, indexOfChild, layoutParams);
            badgeContainer.addView(view);
            badgeContainer.addView(this);
            return this;
        }
        throw new IllegalStateException("targetView can not be null");
    }

    public Badge a(Badge.OnDragStateChangedListener onDragStateChangedListener) {
        this.l = onDragStateChangedListener != null;
        this.N = onDragStateChangedListener;
        return this;
    }

    public Badge a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.k = null;
        } else {
            this.k = str;
        }
        this.j = 1;
        h();
        invalidate();
        return this;
    }

    protected void a(PointF pointF, boolean z) {
        if (this.k == null) {
            a(0);
            return;
        }
        BadgeAnimator badgeAnimator = this.M;
        if (badgeAnimator == null || !badgeAnimator.isRunning()) {
            a(true);
            BadgeAnimator badgeAnimator2 = new BadgeAnimator(a(), pointF, this, z);
            this.M = badgeAnimator2;
            badgeAnimator2.start();
            a(0);
        }
    }

    protected void a(boolean z) {
        if (getParent() != null) {
            ((ViewGroup) getParent()).removeView(this);
        }
        if (z) {
            this.O.addView(this, new FrameLayout.LayoutParams(-1, -1));
        } else {
            a(this.G);
        }
    }

    public Badge b(float f, boolean z) {
        float f2 = f;
        if (z) {
            f2 = DisplayUtil.a(getContext(), f);
        }
        this.i = f2;
        f();
        invalidate();
        return this;
    }

    public Badge b(int i) {
        this.f10207a = i;
        if (i == 0) {
            this.J.setXfermode(null);
        } else {
            this.J.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        }
        invalidate();
        return this;
    }

    public void b() {
        this.C.x = -1000.0f;
        this.C.y = -1000.0f;
        this.v = 4;
        this.M = null;
        a(false);
        getParent().requestDisallowInterceptTouchEvent(false);
        invalidate();
    }

    public void b(boolean z) {
        i();
        if (!z || this.O == null) {
            a(0);
        } else {
            a(this.D, false);
        }
    }

    public Badge c(int i) {
        this.f10208c = i;
        invalidate();
        return this;
    }

    public Badge c(boolean z) {
        this.n = z;
        int i = this.j;
        if (i > 99) {
            a(i);
        }
        return this;
    }

    public Badge d(int i) {
        if (i == 8388659 || i == 8388661 || i == 8388691 || i == 8388693 || i == 17 || i == 49 || i == 81 || i == 8388627 || i == 8388629) {
            this.p = i;
            invalidate();
            return this;
        }
        throw new IllegalStateException("only support Gravity.START | Gravity.TOP , Gravity.END | Gravity.TOP , Gravity.START | Gravity.BOTTOM , Gravity.END | Gravity.BOTTOM , Gravity.CENTER , Gravity.CENTER | Gravity.TOP , Gravity.CENTER | Gravity.BOTTOM ,Gravity.CENTER | Gravity.START , Gravity.CENTER | Gravity.END");
    }

    public void e(int i) {
        Badge.OnDragStateChangedListener onDragStateChangedListener = this.N;
        if (onDragStateChangedListener != null) {
            onDragStateChangedListener.a(i, this, this.G);
        }
    }

    public Drawable getBadgeBackground() {
        return this.d;
    }

    public int getBadgeBackgroundColor() {
        return this.f10207a;
    }

    public int getBadgeGravity() {
        return this.p;
    }

    public int getBadgeNumber() {
        return this.j;
    }

    public String getBadgeText() {
        return this.k;
    }

    public int getBadgeTextColor() {
        return this.f10208c;
    }

    public PointF getDragCenter() {
        if (this.l && this.m) {
            return this.C;
        }
        return null;
    }

    public View getTargetView() {
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.O == null) {
            b(this.G);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        BadgeAnimator badgeAnimator = this.M;
        if (badgeAnimator != null && badgeAnimator.isRunning()) {
            this.M.a(canvas);
        } else if (this.k != null) {
            e();
            float badgeCircleRadius = getBadgeCircleRadius();
            float b = this.t * (1.0f - (MathUtil.b(this.D, this.C) / this.u));
            if (!this.l || !this.m) {
                g();
                a(canvas, this.B, badgeCircleRadius);
                return;
            }
            this.v = MathUtil.a(this.C, this.D);
            d(this.o);
            boolean z = b < ((float) DisplayUtil.a(getContext(), 1.5f));
            this.w = z;
            if (z) {
                e(3);
                a(canvas, this.C, badgeCircleRadius);
                return;
            }
            e(2);
            a(canvas, b, badgeCircleRadius);
            a(canvas, this.C, badgeCircleRadius);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.H = i;
        this.I = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
        if (r0 != 6) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0122  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.view.badgeview.QBadgeView.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
