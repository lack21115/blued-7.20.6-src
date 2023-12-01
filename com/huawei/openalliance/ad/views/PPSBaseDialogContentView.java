package com.huawei.openalliance.ad.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import com.huawei.hms.ads.gb;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.l;
import java.util.Arrays;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSBaseDialogContentView.class */
public abstract class PPSBaseDialogContentView extends LinearLayout {
    public static final float D = 16.0f;
    public static final float F = 0.8f;
    public static final float L = 6.0f;
    private static final String e = "PPSBaseDialogContentView";
    private static final float h = 0.86f;
    private static final float i = 0.6f;
    private static final float j = 0.6f;
    protected int[] B;
    protected int[] C;
    protected View Code;
    protected View I;
    protected int S;
    protected View V;

    /* renamed from: a  reason: collision with root package name */
    protected int f23013a;
    protected int b;

    /* renamed from: c  reason: collision with root package name */
    protected Boolean f23014c;
    protected ViewTreeObserver.OnGlobalLayoutListener d;
    private float f;
    private int g;

    public PPSBaseDialogContentView(Context context) {
        super(context);
        this.S = (int) (com.huawei.openalliance.ad.utils.c.Code(getContext()) * 0.8f);
        this.d = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.openalliance.ad.views.PPSBaseDialogContentView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    if (PPSBaseDialogContentView.this.V == null) {
                        return;
                    }
                    PPSBaseDialogContentView.this.V.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    PPSBaseDialogContentView.this.Code(PPSBaseDialogContentView.this.V, Math.min(PPSBaseDialogContentView.this.V.getMeasuredHeight(), PPSBaseDialogContentView.this.S));
                } catch (Throwable th) {
                    ge.I(PPSBaseDialogContentView.e, "onGlobalLayout error: %s", th.getClass().getSimpleName());
                }
            }
        };
        I(context);
    }

    public PPSBaseDialogContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.S = (int) (com.huawei.openalliance.ad.utils.c.Code(getContext()) * 0.8f);
        this.d = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.openalliance.ad.views.PPSBaseDialogContentView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    if (PPSBaseDialogContentView.this.V == null) {
                        return;
                    }
                    PPSBaseDialogContentView.this.V.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    PPSBaseDialogContentView.this.Code(PPSBaseDialogContentView.this.V, Math.min(PPSBaseDialogContentView.this.V.getMeasuredHeight(), PPSBaseDialogContentView.this.S));
                } catch (Throwable th) {
                    ge.I(PPSBaseDialogContentView.e, "onGlobalLayout error: %s", th.getClass().getSimpleName());
                }
            }
        };
        I(context);
    }

    public PPSBaseDialogContentView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.S = (int) (com.huawei.openalliance.ad.utils.c.Code(getContext()) * 0.8f);
        this.d = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.openalliance.ad.views.PPSBaseDialogContentView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    if (PPSBaseDialogContentView.this.V == null) {
                        return;
                    }
                    PPSBaseDialogContentView.this.V.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    PPSBaseDialogContentView.this.Code(PPSBaseDialogContentView.this.V, Math.min(PPSBaseDialogContentView.this.V.getMeasuredHeight(), PPSBaseDialogContentView.this.S));
                } catch (Throwable th) {
                    ge.I(PPSBaseDialogContentView.e, "onGlobalLayout error: %s", th.getClass().getSimpleName());
                }
            }
        };
        I(context);
    }

    public PPSBaseDialogContentView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.S = (int) (com.huawei.openalliance.ad.utils.c.Code(getContext()) * 0.8f);
        this.d = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.huawei.openalliance.ad.views.PPSBaseDialogContentView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    if (PPSBaseDialogContentView.this.V == null) {
                        return;
                    }
                    PPSBaseDialogContentView.this.V.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    PPSBaseDialogContentView.this.Code(PPSBaseDialogContentView.this.V, Math.min(PPSBaseDialogContentView.this.V.getMeasuredHeight(), PPSBaseDialogContentView.this.S));
                } catch (Throwable th) {
                    ge.I(PPSBaseDialogContentView.e, "onGlobalLayout error: %s", th.getClass().getSimpleName());
                }
            }
        };
        I(context);
    }

    private void B(Context context) {
        if (this.I != null) {
            int V = com.huawei.openalliance.ad.utils.c.V(context);
            int Code = com.huawei.openalliance.ad.utils.c.Code(context);
            if (context instanceof Activity) {
                if (Build.VERSION.SDK_INT >= 30) {
                    Activity activity = (Activity) context;
                    V = activity.getWindowManager().getCurrentWindowMetrics().getBounds().width();
                    Code = activity.getWindowManager().getCurrentWindowMetrics().getBounds().height();
                } else {
                    Point point = new Point();
                    ((Activity) context).getWindowManager().getDefaultDisplay().getSize(point);
                    V = point.x;
                    Code = point.y;
                }
            }
            ViewGroup.LayoutParams layoutParams = this.I.getLayoutParams();
            this.g = (int) ((ay.c(context) == 1 ? V : Math.min(V, Code)) * this.f);
            layoutParams.width = this.g;
            this.I.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(View view, int i2) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    private void I(Context context) {
        try {
            Code(context);
            Z(context);
            B(context);
            V(context);
            Code();
        } catch (Throwable th) {
            ge.I(e, "init ex: %s", th.getClass().getSimpleName());
        }
    }

    private void Z(Context context) {
        if (l.B(context) || (l.S(context) && l.F(context))) {
            this.f = 0.6f;
        } else {
            this.f = h;
        }
    }

    protected abstract void Code();

    public void Code(int i2) {
        int i3 = this.f23013a;
        if (i3 > i2) {
            this.f23013a = i3 - i2;
        }
        int i4 = this.b;
        if (i4 > i2) {
            this.b = i4 - i2;
        }
        Code();
    }

    protected abstract void Code(Context context);

    public void Code(int[] iArr, int[] iArr2) {
        if (iArr == null || iArr2 == null) {
            return;
        }
        this.B = Arrays.copyOf(iArr, iArr.length);
        this.C = Arrays.copyOf(iArr2, iArr2.length);
    }

    protected abstract void V(Context context);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean V() {
        return (this.C == null || this.B == null) ? false : true;
    }

    public float getViewWidthPercent() {
        return this.f;
    }

    public int getViewWith() {
        return this.g;
    }

    public void setAdContentData(AdContentData adContentData) {
    }

    public void setFeedbackListener(com.huawei.openalliance.ad.compliance.a aVar) {
    }

    public void setPaddingStart(int i2) {
        if (ay.I()) {
            this.f23013a = 0;
            this.b = i2;
        } else {
            this.f23013a = i2;
            this.b = 0;
        }
        Code();
    }

    public void setShowWhyThisAd(boolean z) {
        this.f23014c = Boolean.valueOf(z);
    }

    public void setViewClickListener(gb gbVar) {
    }
}
