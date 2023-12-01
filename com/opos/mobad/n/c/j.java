package com.opos.mobad.n.c;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/c/j.class */
public class j extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private final a f26614a;
    private float b;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/c/j$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f26615a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f26616c;
        public final int d;
        public final int e;
        public final float f;

        public a(int i, int i2, float f) {
            this(i, i2, i, f);
        }

        public a(int i, int i2, int i3, float f) {
            this.f = f <= 0.0f ? 6.315f : f;
            int i4 = i > 0 ? i : 171;
            this.b = i4;
            this.f26615a = (int) (i4 / this.f);
            int i5 = i;
            if (i2 <= i4) {
                i5 = i;
                if (i2 > 0) {
                    i5 = i2;
                }
            }
            this.d = i5;
            this.f26616c = (int) (i5 / this.f);
            this.e = a(i3);
        }

        public int a(int i) {
            int i2;
            int i3 = this.d;
            if (i <= i3) {
                i2 = i3;
            } else {
                int i4 = this.b;
                if (i < i4) {
                    return i;
                }
                i2 = i4;
            }
            return i2;
        }

        public int b(int i) {
            int i2;
            int i3 = this.f26616c;
            if (i <= i3) {
                i2 = i3;
            } else {
                int i4 = this.f26615a;
                if (i < i4) {
                    return i;
                }
                i2 = i4;
            }
            return i2;
        }

        public String toString() {
            return "maxH = " + this.f26615a + ",maxW = " + this.b + ",minH = " + this.f26616c + ",minW = " + this.d;
        }
    }

    public j(Context context, AttributeSet attributeSet, int i, a aVar) {
        super(context, attributeSet, i);
        this.b = 1.0f;
        this.f26614a = aVar;
    }

    public j(Context context, AttributeSet attributeSet, a aVar) {
        this(context, attributeSet, 0, aVar);
    }

    public j(Context context, a aVar) {
        this(context, null, aVar);
    }

    private void a(View view, float f) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams.width != -2 && layoutParams.width != -1) {
            layoutParams.width = (int) (layoutParams.width * f);
        }
        if (layoutParams.height != -2 && layoutParams.height != -1) {
            layoutParams.height = (int) (layoutParams.height * f);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams.bottomMargin != 0) {
                marginLayoutParams.bottomMargin = (int) (marginLayoutParams.bottomMargin * f);
            }
            if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = (int) (marginLayoutParams.topMargin * f);
            }
            if (marginLayoutParams.leftMargin != 0) {
                marginLayoutParams.leftMargin = (int) (marginLayoutParams.leftMargin * f);
            }
            if (marginLayoutParams.rightMargin != 0) {
                marginLayoutParams.rightMargin = (int) (marginLayoutParams.rightMargin * f);
            }
        }
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setTextSize(0, textView.getTextSize() * f);
            float lineSpacingExtra = textView.getLineSpacingExtra();
            float f2 = lineSpacingExtra;
            if (0.0f != lineSpacingExtra) {
                f2 = lineSpacingExtra * f;
            }
            textView.setLineSpacing(f2, textView.getLineSpacingMultiplier());
            textView.setPadding((int) (textView.getPaddingLeft() * f), (int) (textView.getPaddingTop() * f), (int) (textView.getPaddingRight() * f), (int) (textView.getPaddingBottom() * f));
            if (textView.getMaxWidth() > 0) {
                textView.setMaxWidth((int) (textView.getMaxWidth() * f));
            }
        }
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(viewGroup.getChildAt(i), f);
            }
        }
    }

    private void a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        float width = viewGroup.getWidth() / this.f26614a.e;
        float f = this.b;
        if (f == width) {
            com.opos.cmn.an.f.a.b("SizeView", "size not change");
            return;
        }
        this.b = width;
        com.opos.cmn.an.f.a.b("SizeView", "scale view = " + viewGroup + ",scale = " + width);
        float f2 = width / f;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= viewGroup.getChildCount()) {
                return;
            }
            a(viewGroup.getChildAt(i2), f2);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int b = this.f26614a.b(size);
        int a2 = this.f26614a.a(size2);
        a aVar = this.f26614a;
        int a3 = aVar.a(aVar.e);
        int i3 = (int) (a3 / this.f26614a.f);
        int i4 = (int) (a2 / this.f26614a.f);
        int i5 = (int) (b * this.f26614a.f);
        if (mode2 != 1073741824) {
            if (mode == 1073741824) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(b, 1073741824);
            } else if (mode2 == Integer.MIN_VALUE && mode == Integer.MIN_VALUE) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(a3, 1073741824);
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            }
            super.onMeasure(makeMeasureSpec, makeMeasureSpec2);
        }
        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(a2, 1073741824);
        makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec2);
    }
}
