package com.soft.blued.ui.user.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.graphics.drawable.DrawableKt;
import com.blued.android.framework.utils.DensityUtils;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/VipGradeProgress.class */
public final class VipGradeProgress extends View {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f20715a = new Companion(null);
    private final int A;
    private final int B;
    private final int C;
    private Paint b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f20716c;
    private Paint d;
    private Paint e;
    private int f;
    private int g;
    private int h;
    private List<String> i;
    private List<Rect> j;
    private float k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private int p;
    private float q;
    private float r;
    private Bitmap s;
    private OnDropLickListener t;
    private int u;
    private final int v;
    private final int w;
    private final int x;
    private final int y;
    private final int z;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/VipGradeProgress$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/views/VipGradeProgress$OnDropLickListener.class */
    public interface OnDropLickListener {
        void a(int i, float f);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipGradeProgress(Context context) {
        super(context);
        Intrinsics.e(context, "context");
        this.f = Color.parseColor("#379FFB");
        this.g = Color.parseColor("#1270E5");
        this.o = true;
        this.v = Color.parseColor("#85CCFD");
        this.w = Color.parseColor("#1270E5");
        this.x = Color.parseColor("#E4C29D");
        this.y = Color.parseColor("#E9894D");
        this.z = Color.parseColor("#808080");
        this.A = Color.parseColor("#445771");
        this.B = Color.parseColor("#CDCDCD");
        this.C = Color.parseColor("#7D7D7D");
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipGradeProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.e(context, "context");
        Intrinsics.e(attributeSet, "attrs");
        this.f = Color.parseColor("#379FFB");
        this.g = Color.parseColor("#1270E5");
        this.o = true;
        this.v = Color.parseColor("#85CCFD");
        this.w = Color.parseColor("#1270E5");
        this.x = Color.parseColor("#E4C29D");
        this.y = Color.parseColor("#E9894D");
        this.z = Color.parseColor("#808080");
        this.A = Color.parseColor("#445771");
        this.B = Color.parseColor("#CDCDCD");
        this.C = Color.parseColor("#7D7D7D");
        a(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipGradeProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        Intrinsics.e(attributeSet, "attrs");
        this.f = Color.parseColor("#379FFB");
        this.g = Color.parseColor("#1270E5");
        this.o = true;
        this.v = Color.parseColor("#85CCFD");
        this.w = Color.parseColor("#1270E5");
        this.x = Color.parseColor("#E4C29D");
        this.y = Color.parseColor("#E9894D");
        this.z = Color.parseColor("#808080");
        this.A = Color.parseColor("#445771");
        this.B = Color.parseColor("#CDCDCD");
        this.C = Color.parseColor("#7D7D7D");
        a(context);
    }

    private final void a(Context context) {
        this.l = DensityUtil.a(70.0f);
        this.k = DensityUtil.a(3.0f);
        this.h = DensityUtil.a(45.0f);
        Paint paint = new Paint(1);
        this.b = paint;
        if (paint != null) {
            paint.setColor(this.f);
        }
        Paint paint2 = this.b;
        if (paint2 != null) {
            paint2.setStyle(Paint.Style.FILL);
        }
        Paint paint3 = new Paint(1);
        this.f20716c = paint3;
        if (paint3 != null) {
            paint3.setColor(this.g);
        }
        Paint paint4 = this.f20716c;
        if (paint4 != null) {
            paint4.setStyle(Paint.Style.FILL);
        }
        Paint paint5 = new Paint(1);
        this.d = paint5;
        if (paint5 != null) {
            paint5.setColor(this.g);
        }
        Paint paint6 = this.d;
        if (paint6 != null) {
            paint6.setTextSize(DensityUtils.d(context, 10.0f));
        }
        Paint paint7 = new Paint(1);
        this.e = paint7;
        if (paint7 != null) {
            paint7.setFilterBitmap(true);
        }
        Paint paint8 = this.e;
        if (paint8 == null) {
            return;
        }
        paint8.setDither(true);
    }

    private final void e() {
        int i = this.u;
        Bitmap bitmap = null;
        if (i == 1) {
            int i2 = this.f;
            int i3 = this.x;
            if (i2 != i3) {
                this.f = i3;
                Paint paint = this.b;
                if (paint != null) {
                    paint.setColor(i3);
                }
            }
            int i4 = this.g;
            int i5 = this.y;
            if (i4 != i5) {
                this.g = i5;
                Paint paint2 = this.f20716c;
                if (paint2 != null) {
                    paint2.setColor(i5);
                }
                Paint paint3 = this.d;
                if (paint3 != null) {
                    paint3.setColor(this.g);
                }
            }
            Drawable drawable = getContext().getDrawable(R.drawable.icon_vip_arrow);
            this.s = drawable == null ? null : DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null);
        } else if (i == 2) {
            int i6 = this.f;
            int i7 = this.v;
            if (i6 != i7) {
                this.f = i7;
                Paint paint4 = this.b;
                if (paint4 != null) {
                    paint4.setColor(i7);
                }
            }
            int i8 = this.g;
            int i9 = this.w;
            if (i8 != i9) {
                this.g = i9;
                Paint paint5 = this.f20716c;
                if (paint5 != null) {
                    paint5.setColor(i9);
                }
                Paint paint6 = this.d;
                if (paint6 != null) {
                    paint6.setColor(this.g);
                }
            }
            Drawable drawable2 = getContext().getDrawable(R.drawable.icon_svip_arrow);
            this.s = drawable2 == null ? null : DrawableKt.toBitmap$default(drawable2, 0, 0, null, 7, null);
        } else if (i == 3) {
            int i10 = this.f;
            int i11 = this.B;
            if (i10 != i11) {
                this.f = i11;
                Paint paint7 = this.b;
                if (paint7 != null) {
                    paint7.setColor(i11);
                }
            }
            int i12 = this.g;
            int i13 = this.C;
            if (i12 != i13) {
                this.g = i13;
                Paint paint8 = this.f20716c;
                if (paint8 != null) {
                    paint8.setColor(i13);
                }
                Paint paint9 = this.d;
                if (paint9 != null) {
                    paint9.setColor(this.g);
                }
            }
            Drawable drawable3 = getContext().getDrawable(R.drawable.icon_expire_vip_arrow);
            this.s = drawable3 == null ? null : DrawableKt.toBitmap$default(drawable3, 0, 0, null, 7, null);
        } else if (i != 4) {
        } else {
            int i14 = this.f;
            int i15 = this.z;
            if (i14 != i15) {
                this.f = i15;
                Paint paint10 = this.b;
                if (paint10 != null) {
                    paint10.setColor(i15);
                }
            }
            int i16 = this.g;
            int i17 = this.A;
            if (i16 != i17) {
                this.g = i17;
                Paint paint11 = this.f20716c;
                if (paint11 != null) {
                    paint11.setColor(i17);
                }
                Paint paint12 = this.d;
                if (paint12 != null) {
                    paint12.setColor(this.g);
                }
            }
            Drawable drawable4 = getContext().getDrawable(R.drawable.icon_expire_svip_arrow);
            if (drawable4 != null) {
                bitmap = DrawableKt.toBitmap$default(drawable4, 0, 0, null, 7, null);
            }
            this.s = bitmap;
        }
    }

    private final void f() {
        this.j = new ArrayList();
        List<String> list = this.i;
        if (list == null) {
            return;
        }
        for (String str : list) {
            Rect rect = new Rect();
            Paint paint = this.d;
            if (paint != null) {
                paint.getTextBounds(str, 0, str.length(), rect);
            }
            List<Rect> list2 = this.j;
            if (list2 != null) {
                list2.add(rect);
            }
        }
    }

    public final void a() {
        this.u = 1;
    }

    public final void b() {
        this.u = 2;
    }

    public final void c() {
        this.u = 3;
    }

    public final void d() {
        this.u = 4;
    }

    public final OnDropLickListener getOnDropLickListener() {
        return this.t;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Paint paint;
        Paint paint2;
        OnDropLickListener onDropLickListener;
        Paint paint3;
        Paint paint4;
        Bitmap bitmap;
        int i;
        Intrinsics.e(canvas, "canvas");
        super.onDraw(canvas);
        List<String> list = this.i;
        if (list == null || list.isEmpty()) {
            return;
        }
        e();
        List<String> list2 = this.i;
        if (list2 == null || (paint = this.b) == null || (paint2 = this.f20716c) == null || list2.isEmpty()) {
            return;
        }
        if (this.r == 0.0f) {
            this.r = (list2.size() - 1) * this.l;
        }
        if ((this.q == 0.0f) && (i = this.p) != 0) {
            this.q = (i - this.r) / 2;
        }
        paint.setStrokeWidth(this.k / 2.0f);
        canvas.drawLine(this.q, getHeight() / 2.0f, this.q + this.r, getHeight() / 2.0f, paint);
        paint2.setStrokeWidth(this.k / 2.0f);
        Iterator<T> it = list2.iterator();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                return;
            }
            Object next = it.next();
            if (i3 < 0) {
                CollectionsKt.c();
            }
            String str = (String) next;
            if (i3 <= this.m || i3 == this.n) {
                if (i3 == this.n) {
                    canvas.drawCircle(this.q + (this.l * i3), getHeight() / 2.0f, DensityUtil.a(3.5f), paint2);
                } else {
                    canvas.drawCircle(this.q + (this.l * i3), getHeight() / 2.0f, this.k, paint2);
                }
                if (i3 == this.m) {
                    if (this.o && (onDropLickListener = getOnDropLickListener()) != null) {
                        onDropLickListener.a(this.m, this.q + this.k + (this.l * i3));
                    }
                    canvas.drawLine(this.q, getHeight() / 2.0f, this.q + (this.l * i3), getHeight() / 2.0f, paint2);
                }
            } else {
                canvas.drawCircle(this.q + (this.l * i3), getHeight() / 2.0f, this.k, paint);
            }
            List<Rect> list3 = this.j;
            if (list3 != null && (paint3 = this.d) != null && (paint4 = this.e) != null && i3 == this.n && (bitmap = this.s) != null) {
                int width = list3.get(i3).width();
                float f = (this.q + (this.l * i3)) - this.k;
                float height = (getHeight() / 2) - (list3.get(i3).height() / 2);
                float f2 = this.k;
                float f3 = f - (width / 2);
                if (f3 < 0.0f) {
                    f3 = this.q - f2;
                } else if (this.n == list2.size() - 1) {
                    f3 = (f - width) + this.k;
                }
                canvas.drawText(list2.get(i3), f3, getHeight() - (this.k * 2.5f), paint3);
                canvas.drawBitmap(bitmap, (f + this.k) - (bitmap.getWidth() / 2), (height - (0.5f * f2)) - bitmap.getHeight(), paint4);
            }
            i2 = i3 + 1;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(i, i2);
        List<String> list = this.i;
        if (list == null || list.isEmpty()) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        this.p = (int) ((this.l * (list.size() - 1)) + (this.k * list.size()));
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(this.p, this.h);
        } else if (mode == Integer.MIN_VALUE) {
            setMeasuredDimension(this.p, size);
        } else if (mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(this.p, this.h);
        } else {
            setMeasuredDimension(this.p, size);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Intrinsics.e(motionEvent, "event");
        if (motionEvent.getAction() == 1) {
            float x = motionEvent.getX() / this.l;
            int i = (int) (x + (((double) (x - ((float) ((int) x)))) > 0.5d ? 1 : 0));
            this.n = i;
            OnDropLickListener onDropLickListener = this.t;
            if (onDropLickListener != null) {
                onDropLickListener.a(i, this.q + this.k + (this.l * i));
            }
            this.o = false;
        }
        invalidate();
        return true;
    }

    public final void setData(List<String> list) {
        Intrinsics.e(list, "list");
        List<String> list2 = list;
        if (!list2.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            this.i = arrayList;
            Intrinsics.a(arrayList);
            arrayList.addAll(list2);
        }
        f();
        invalidate();
    }

    public final void setOnDropLickListener(OnDropLickListener onDropLickListener) {
        this.t = onDropLickListener;
    }

    public final void setSelectIndex(int i) {
        if (i < 0) {
            this.m = 0;
            this.n = 0;
        } else {
            this.m = i;
            this.n = i;
        }
        invalidate();
    }
}
