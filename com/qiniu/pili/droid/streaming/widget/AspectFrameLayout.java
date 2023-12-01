package com.qiniu.pili.droid.streaming.widget;

import a.a.a.a.a.e.e;
import a.a.a.a.a.e.h;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/widget/AspectFrameLayout.class */
public class AspectFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public double f27847a;
    public SHOW_MODE b;

    /* renamed from: c  reason: collision with root package name */
    public Point f27848c;
    public int d;
    public int e;
    public Rect f;
    public int g;
    public int h;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/widget/AspectFrameLayout$SHOW_MODE.class */
    public enum SHOW_MODE {
        FULL,
        REAL
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/widget/AspectFrameLayout$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AspectFrameLayout.this.requestLayout();
        }
    }

    public AspectFrameLayout(Context context) {
        super(context);
        this.f27847a = -1.0d;
        this.b = SHOW_MODE.REAL;
        this.d = 0;
        this.e = 0;
        this.f = new Rect();
        this.f27848c = h.d(context);
    }

    public AspectFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27847a = -1.0d;
        this.b = SHOW_MODE.REAL;
        this.d = 0;
        this.e = 0;
        this.f = new Rect();
        this.f27848c = h.d(context);
    }

    public void a(Point point) {
        this.f27848c = point;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        double d;
        double d2;
        double d3;
        double d4;
        e.f1361c.b("AspectFrameLayout", "onMeasure target=" + this.f27847a + " width=[" + View.MeasureSpec.toString(i) + "] height=[" + View.MeasureSpec.toString(i2) + "],x:" + this.f27848c.x + ",y:" + this.f27848c.y);
        getWindowVisibleDisplayFrame(this.f);
        if (this.e == 0 && this.d == 0) {
            this.e = getRootView().getWidth();
            this.d = getRootView().getHeight();
        }
        Point point = this.f27848c;
        if (point.x > point.y) {
            int i6 = this.e;
            int i7 = this.d;
            i3 = i6;
            if (i6 > i7) {
                i3 = i7;
            }
        } else {
            int i8 = this.e;
            int i9 = this.d;
            i3 = i8;
            if (i8 < i9) {
                i3 = i9;
            }
        }
        Rect rect = this.f;
        if (i3 - (rect.bottom - rect.top) > i3 / 4) {
            e.f1361c.c("AspectFrameLayout", "soft keyboard show");
            super.onMeasure(this.g, this.h);
            return;
        }
        e.f1361c.c("AspectFrameLayout", "soft keyboard hide");
        if (this.f27847a > 0.0d) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int i10 = size - paddingLeft;
            int i11 = size2 - paddingTop;
            double d5 = i10;
            double d6 = i11;
            double d7 = (this.f27847a / (d5 / d6)) - 1.0d;
            if (Math.abs(d7) < 0.01d) {
                e.f1361c.b("AspectFrameLayout", "aspect ratio is good (target=" + this.f27847a + ", view=" + i10 + "x" + i11 + ")");
            } else {
                if (this.b == SHOW_MODE.REAL) {
                    if (d7 > 0.0d) {
                        i11 = (int) (d5 / this.f27847a);
                    } else {
                        i10 = (int) (d6 * this.f27847a);
                    }
                    i4 = i10 + paddingLeft;
                    i5 = i11 + paddingTop;
                } else {
                    Point point2 = this.f27848c;
                    int i12 = point2.x;
                    int i13 = point2.y;
                    if (i12 > i13) {
                        if (i10 == i12) {
                            d = i13;
                            d2 = this.f27847a;
                            i4 = (int) (d * d2);
                            i5 = i13;
                        } else {
                            i4 = i10;
                            i5 = i11;
                            if (i10 < i12) {
                                d3 = i12;
                                d4 = this.f27847a;
                                i5 = (int) (d3 / d4);
                                i4 = i12;
                            }
                        }
                    } else if (i10 == i12) {
                        d3 = i12;
                        d4 = this.f27847a;
                        i5 = (int) (d3 / d4);
                        i4 = i12;
                    } else {
                        i4 = i10;
                        i5 = i11;
                        if (i10 < i12) {
                            d = i13;
                            d2 = this.f27847a;
                            i4 = (int) (d * d2);
                            i5 = i13;
                        }
                    }
                }
                e.f1361c.b("AspectFrameLayout", "new size=" + i4 + "x" + i5 + " + padding " + paddingLeft + "x" + paddingTop);
                i = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
            }
        }
        this.g = i;
        this.h = i2;
        super.onMeasure(i, i2);
    }

    public void setAspectRatio(double d) {
        if (d < 0.0d) {
            throw new IllegalArgumentException();
        }
        e eVar = e.f1361c;
        eVar.c("AspectFrameLayout", "Setting aspect ratio to " + d + " (was " + this.f27847a + ")");
        if (this.f27847a != d) {
            this.f27847a = d;
            if (getHandler() != null) {
                getHandler().post(new a());
            }
        }
    }

    public void setShowMode(SHOW_MODE show_mode) {
        this.b = show_mode;
    }
}
