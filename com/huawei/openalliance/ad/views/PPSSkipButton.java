package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.gz;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ax;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.l;
import com.huawei.openalliance.ad.utils.v;
import java.util.IllegalFormatException;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSSkipButton.class */
public class PPSSkipButton extends FrameLayout {
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f23026c;
    private String d;
    private int e;
    private int f;
    private int g;
    private final String h;
    private gz i;
    private boolean j;
    private Resources k;
    private TextView l;
    private boolean m;
    private int n;
    private float o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private static final String Code = PPSSkipButton.class.getSimpleName();
    private static int V = 16;
    private static int I = 16;
    private static int B = 4;
    private static int C = 16;
    private static int S = 16;
    private static int F = 24;
    private static int D = 24;

    public PPSSkipButton(Context context, String str, int i, int i2, int i3, String str2, boolean z, int i4, float f, int i5, boolean z2) {
        super(context);
        this.g = 0;
        this.m = false;
        this.q = false;
        this.r = true;
        this.s = false;
        this.b = context;
        this.k = context.getResources();
        V();
        this.e = i;
        this.f = i2;
        this.g = i3;
        this.h = str2 == null ? "tr" : str2;
        this.f23026c = context.getString(R.string.hiad_default_skip_text);
        this.d = Code(str);
        this.j = z;
        this.n = i4;
        this.o = f;
        this.p = i5;
        this.q = z2;
        this.r = dt.V(context);
        I();
        this.s = false;
        Z();
    }

    private int Code(boolean z) {
        int i = z ? F : I;
        if (5 == this.f) {
            i = z ? D : S;
        }
        return i;
    }

    private String Code(String str) {
        String V2 = au.V(str);
        String str2 = V2;
        if (au.Code(V2)) {
            str2 = this.b.getString(R.string.hiad_default_skip_text_time);
        }
        return str2;
    }

    private void I() {
        inflate(getContext(), R.layout.hiad_view_skip_button, this);
        TextView textView = (TextView) findViewById(R.id.hiad_skip_text);
        this.l = textView;
        textView.setText(this.f23026c);
        if (this.o > 0.0f) {
            if (v.c(this.b)) {
                this.l.setTextSize(1, 24.0f);
                if (this.p > 0) {
                    this.l.setHeight(v.V(this.b, 48.0f));
                }
            } else {
                this.l.setTextSize(2, this.o);
                int i = this.p;
                if (i > 0) {
                    this.l.setHeight(v.Z(this.b, i));
                }
            }
        }
        this.l.setPadding(getSkipAdPaddingPx(), 0, getSkipAdPaddingPx(), 0);
        setPaddingRelative(getSkipAdLeftPaddingPx(), getSkipAdTopPaddingPx(), getSkipAdRightPaddingPx(), getSkipAdBottomPaddingPx());
        setClickable(true);
        setLayoutParams(getSkipAdLayoutParams());
    }

    private void V() {
        Context context;
        Resources resources = this.k;
        if (resources == null || (context = this.b) == null) {
            return;
        }
        V = v.I(context, resources.getDimension(R.dimen.hiad_splash_skip_phone_margin));
        I = v.I(this.b, this.k.getDimension(R.dimen.hiad_splash_skip_phone_margin_top));
        B = v.I(this.b, this.k.getDimension(R.dimen.hiad_splash_skip_third_margin));
        C = v.I(this.b, this.k.getDimension(R.dimen.hiad_splash_skip_tablet_margin));
        S = v.I(this.b, this.k.getDimension(R.dimen.hiad_splash_skip_tablet_margin_top));
        F = v.I(this.b, this.k.getDimension(R.dimen.hiad_splash_skip_phone_margin_bottom));
        D = v.I(this.b, this.k.getDimension(R.dimen.hiad_splash_skip_tablet_margin_bottom));
    }

    private void Z() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.huawei.openalliance.ad.views.PPSSkipButton.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (motionEvent.getAction() == 0) {
                    if (ge.Code()) {
                        ge.Code(PPSSkipButton.Code, "touch down skipAdButton x=%f, y=%f", Float.valueOf(rawX), Float.valueOf(rawY));
                    }
                    if (PPSSkipButton.this.s || PPSSkipButton.this.i == null) {
                        return true;
                    }
                    PPSSkipButton.this.s = true;
                    PPSSkipButton.this.i.Code((int) rawX, (int) rawY);
                    return true;
                }
                return true;
            }
        });
    }

    private int getHorizontalSideGapDpSize() {
        int i = V;
        if (5 == this.f) {
            i = C;
        }
        if (!this.r) {
            i = B;
        }
        return i;
    }

    private int getHorizontalSideMarginDp() {
        int horizontalSideGapDpSize = getHorizontalSideGapDpSize();
        int i = this.g;
        if (horizontalSideGapDpSize < i) {
            return 0;
        }
        return horizontalSideGapDpSize - i;
    }

    private int getHorizontalSidePaddingDp() {
        return Math.min(getHorizontalSideGapDpSize(), this.g);
    }

    private int getSkipAdBottomMarginPx() {
        int i = 0;
        if ("lr".equals(this.h)) {
            int Code2 = this.j ? 0 : ax.Code(this.b);
            int i2 = Code2;
            if (this.e == 0) {
                i2 = Code2;
                if (5 != this.f) {
                    i2 = Code2;
                    if (!l.S(this.b)) {
                        i2 = Code2;
                        if (!l.B(this.b)) {
                            i2 = 0;
                        }
                    }
                }
            }
            if (!this.j && ge.Code()) {
                ge.Code(Code, "navigation bar h: %d", Integer.valueOf(i2));
            }
            i = ax.Code(this.b, getVerticalSideBottomMarginDp()) + i2;
        }
        return i;
    }

    private int getSkipAdBottomPaddingPx() {
        Context context;
        int i;
        if ("lr".equals(this.h)) {
            context = this.b;
            i = getVerticalSidePaddingDp();
        } else {
            context = this.b;
            i = this.g;
        }
        return ax.Code(context, i);
    }

    private RelativeLayout.LayoutParams getSkipAdLayoutParams() {
        int i;
        int i2;
        int V2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule("lr".equals(this.h) ? 12 : 10);
        layoutParams.addRule(21);
        int skipAdLeftMarginPx = getSkipAdLeftMarginPx();
        int skipAdTopMarginPx = getSkipAdTopMarginPx();
        int skipAdRightMarginPx = getSkipAdRightMarginPx();
        int skipAdBottomMarginPx = getSkipAdBottomMarginPx();
        if (1 == this.e) {
            i = skipAdTopMarginPx;
            i2 = skipAdRightMarginPx;
            if ("tr".equals(this.h)) {
                V2 = this.n;
                i = skipAdTopMarginPx + V2;
                i2 = skipAdRightMarginPx;
            }
        } else {
            int i3 = skipAdRightMarginPx;
            if (!this.q) {
                i3 = skipAdRightMarginPx + this.n;
            }
            skipAdRightMarginPx = this.r ? i3 + ay.I(this.b) : ay.I(this.b);
            i = skipAdTopMarginPx;
            i2 = skipAdRightMarginPx;
            if ("tr".equals(this.h)) {
                V2 = v.V(this.b, 12.0f);
                i = skipAdTopMarginPx + V2;
                i2 = skipAdRightMarginPx;
            }
        }
        layoutParams.setMargins(skipAdLeftMarginPx, i, i2, skipAdBottomMarginPx);
        layoutParams.setMarginEnd(i2);
        return layoutParams;
    }

    private int getSkipAdLeftMarginPx() {
        return 0;
    }

    private int getSkipAdLeftPaddingPx() {
        return this.k.getDimensionPixelOffset(R.dimen.hiad_margin_m);
    }

    private int getSkipAdPaddingPx() {
        return this.k.getDimensionPixelOffset(R.dimen.hiad_margin_l);
    }

    private int getSkipAdRightMarginPx() {
        return ax.Code(this.b, getHorizontalSideMarginDp());
    }

    private int getSkipAdRightPaddingPx() {
        return ax.Code(this.b, getHorizontalSidePaddingDp());
    }

    private int getSkipAdTopMarginPx() {
        if ("lr".equals(this.h)) {
            return 0;
        }
        return ax.Code(this.b, getVerticalSideMarginDp());
    }

    private int getSkipAdTopPaddingPx() {
        Context context;
        int topPaddingDp;
        if ("lr".equals(this.h)) {
            context = this.b;
            topPaddingDp = this.g;
        } else {
            context = this.b;
            topPaddingDp = getTopPaddingDp();
        }
        return ax.Code(context, topPaddingDp);
    }

    private int getTopPaddingDp() {
        return Math.min(5 == this.f ? S : I, this.g);
    }

    private int getVerticalSideBottomMarginDp() {
        int Code2 = Code(true);
        int i = this.g;
        if (Code2 < i) {
            return 0;
        }
        return Code2 - i;
    }

    private int getVerticalSideMarginDp() {
        int Code2 = Code(false);
        int i = this.g;
        if (Code2 < i) {
            return 0;
        }
        return Code2 - i;
    }

    private int getVerticalSidePaddingDp() {
        return Math.min(Code(false), this.g);
    }

    public void Code(int i) {
        if (this.m && !TextUtils.isEmpty(this.d)) {
            try {
                String format = String.format(Locale.getDefault(), this.d, Integer.valueOf(i));
                ge.Code(Code, "updateLeftTime : %s", format);
                this.l.setText(format);
                return;
            } catch (IllegalFormatException e) {
                ge.Z(Code, "updateLeftTime IllegalFormatException");
            }
        }
        this.l.setText(this.f23026c);
    }

    public void setAdMediator(gz gzVar) {
        this.i = gzVar;
    }

    public void setLinkedOnTouchListener(View.OnTouchListener onTouchListener) {
        setOnTouchListener(onTouchListener);
    }

    public void setShowLeftTime(boolean z) {
        this.m = z;
    }
}
