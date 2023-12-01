package com.opos.mobad.f.a;

import android.content.Context;
import android.view.View;
import android.widget.ViewSwitcher;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/i.class */
public class i extends ViewSwitcher {

    /* renamed from: a  reason: collision with root package name */
    private volatile a f12422a;
    private final b b;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/i$a.class */
    public interface a {
        void a(int i, int i2);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/f/a/i$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f12423a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12424c;
        public final int d;
        public final float e;

        public b(int i, int i2, float f) {
            this.e = f <= 0.0f ? 6.315f : f;
            int i3 = i > 0 ? i : 171;
            this.b = i3;
            this.f12423a = (int) (i3 / this.e);
            int i4 = i;
            if (i2 <= i3) {
                i4 = i;
                if (i2 > 0) {
                    i4 = i2;
                }
            }
            this.d = i4;
            this.f12424c = (int) (i4 / this.e);
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
            int i3 = this.f12424c;
            if (i <= i3) {
                i2 = i3;
            } else {
                int i4 = this.f12423a;
                if (i < i4) {
                    return i;
                }
                i2 = i4;
            }
            return i2;
        }

        public String toString() {
            return "maxH = " + this.f12423a + ",maxW = " + this.b + ",minH = " + this.f12424c + ",minW = " + this.d;
        }
    }

    public i(Context context, b bVar) {
        super(context);
        this.b = bVar;
    }

    public void a(int i, int i2, int i3, int i4) {
        if (i == i3 && i2 == i4) {
            return;
        }
        if (this.f12422a != null) {
            this.f12422a.a(i, i2);
        }
        com.opos.cmn.an.f.a.b("switcher", "w = " + i + ",h = " + i2 + ",oldw = " + i3 + ",oldh = " + i4);
    }

    public void a(a aVar) {
        this.f12422a = aVar;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int b2 = this.b.b(size);
        int a2 = this.b.a(size2);
        int i3 = (int) (a2 / this.b.e);
        int i4 = (int) (b2 * this.b.e);
        if (mode2 != 1073741824 && mode == 1073741824) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(b2, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(a2, 1073741824);
            makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        super.onMeasure(makeMeasureSpec, makeMeasureSpec2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.opos.cmn.an.f.a.b("switcher", "onSizeChanged w = " + i + ",h = " + i2 + ",oldw = " + i3 + ",oldh = " + i4);
        a(i, i2, i3, i4);
    }
}
