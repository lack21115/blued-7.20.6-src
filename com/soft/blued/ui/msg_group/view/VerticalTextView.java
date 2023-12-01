package com.soft.blued.ui.msg_group.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.soft.blued.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/view/VerticalTextView.class */
public final class VerticalTextView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    private final int f19145a;
    private Paint b;

    /* renamed from: c  reason: collision with root package name */
    private int f19146c;
    private int d;
    private int e;
    private int f;
    private int g;
    private float h;
    private int i;
    private int j;
    private int k;
    private int l;
    private String m;
    private Handler n;
    private int o;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VerticalTextView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VerticalTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerticalTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.f19145a = 1;
        Paint paint = new Paint();
        this.b = paint;
        this.g = 22;
        this.h = 28.0f;
        this.m = "";
        this.o = 6;
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        this.g = (int) (Math.ceil(fontMetrics.descent - fontMetrics.top) * 1.8d);
        this.b.setTextAlign(Paint.Align.CENTER);
        this.b.setAntiAlias(true);
        this.b.setColor(BluedSkinUtils.a(context, 2131102264));
        if (attributeSet == null) {
            return;
        }
        try {
            String attributeValue = attributeSet.getAttributeValue(null, "textSize");
            Intrinsics.c(attributeValue, "it.getAttributeValue(null, \"textSize\")");
            this.h = Float.parseFloat(attributeValue);
        } catch (Exception e) {
        }
    }

    private final int a(int i) {
        Logger.c("VerticalTextView", "measureHeight : f " + this.g + " +  tl " + this.k);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int a2 = BluedViewExtKt.a(124);
        if (mode == Integer.MIN_VALUE) {
            a2 = Math.min(size, a2);
        } else if (mode == 1073741824) {
            int i2 = this.g;
            a2 = size;
            if (i2 != 0) {
                int i3 = this.k;
                a2 = Math.min(size, (i2 * (i3 + 1)) + (this.o * (i3 - 1)));
            }
        }
        this.f = a2;
        return a2;
    }

    private final void a(Canvas canvas, String str) {
        this.d = 0;
        this.f19146c = this.j / 2;
        int i = 0;
        while (i < this.k) {
            char charAt = str.charAt(i);
            if (charAt == '\n') {
                this.f19146c -= this.j;
                this.d = 0;
            } else {
                int i2 = this.d + this.g;
                this.d = i2;
                if (i2 > this.f) {
                    this.f19146c += this.j;
                    i--;
                    this.d = 0;
                } else {
                    canvas.drawText(String.valueOf(charAt), this.f19146c, this.d, this.b);
                }
            }
            i++;
            this.d += this.o;
        }
    }

    private final void getTextInfo() {
        int i;
        float[] fArr;
        this.b.setTextSize(this.h);
        Logger.c("VerticalTextView", Intrinsics.a("mFontSize :  ", Float.valueOf(this.h)));
        if (this.j == 0) {
            this.b.getTextWidths("正", new float[1]);
            this.j = (int) Math.ceil(fArr[0] * 1.1d);
        }
        this.i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.k) {
            if (this.m.charAt(i2) == '\n') {
                this.i++;
            } else {
                int i4 = i3 + this.g;
                if (i4 > this.f) {
                    this.i++;
                    i2--;
                } else {
                    i = i2;
                    i3 = i4;
                    if (i2 == this.k - 1) {
                        this.i++;
                        i3 = i4;
                        i = i2;
                    }
                    i2 = i + 1;
                }
            }
            i3 = 0;
            i = i2;
            i2 = i + 1;
        }
        Logger.c("VerticalTextView", Intrinsics.a("mRealLine : ", Integer.valueOf(this.i)));
        Logger.c("VerticalTextView", Intrinsics.a("mLineWidth : ", Integer.valueOf(this.j)));
        int i5 = this.j * this.i;
        this.e = i5;
        measure(i5, getHeight());
        layout(getLeft(), getTop(), getLeft() + this.e, getBottom());
    }

    public final int getTextWidth() {
        return this.e;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.e(canvas, "canvas");
        super.onDraw(canvas);
        a(canvas, this.m);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int a2 = a(i2);
        if (this.e == 0) {
            getTextInfo();
        }
        setMeasuredDimension(this.e, a2);
        if (this.l != getWidth()) {
            this.l = getWidth();
            Handler handler = this.n;
            if (handler == null) {
                return;
            }
            handler.sendEmptyMessage(this.f19145a);
        }
    }

    public final void setHandler(Handler handler) {
        this.n = handler;
    }

    public final void setLineWidth(int i) {
        this.j = i;
    }

    public final void setText(String str) {
        Intrinsics.e(str, "text");
        this.m = str;
        this.k = str.length();
        if (this.f > 0) {
            getTextInfo();
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        this.b.setColor(i);
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        if (f == this.b.getTextSize()) {
            return;
        }
        this.h = f;
        if (this.f > 0) {
            getTextInfo();
        }
    }
}
