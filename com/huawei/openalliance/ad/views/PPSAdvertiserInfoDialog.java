package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.splash.R;
import com.huawei.openalliance.ad.compliance.ComplianceView;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.l;
import com.huawei.openalliance.ad.utils.v;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSAdvertiserInfoDialog.class */
public class PPSAdvertiserInfoDialog extends RelativeLayout {
    private int C;
    private int D;
    private int F;
    private RelativeLayout L;
    private int S;

    /* renamed from: a  reason: collision with root package name */
    private View f9403a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f9404c;
    private int[] d;
    private ComplianceView e;
    private ComplianceView f;
    private ComplianceView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private Context k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/PPSAdvertiserInfoDialog$a.class */
    public static class a implements View.OnClickListener {
        private WeakReference<View> Code;

        public a(View view) {
            this.Code = new WeakReference<>(view);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            View view2 = this.Code.get();
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
    }

    public PPSAdvertiserInfoDialog(Context context) {
        super(context);
        Code(context);
    }

    public PPSAdvertiserInfoDialog(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public PPSAdvertiserInfoDialog(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
    }

    public PPSAdvertiserInfoDialog(Context context, int[] iArr, int[] iArr2) {
        super(context);
        this.f9404c = iArr == null ? null : Arrays.copyOf(iArr, iArr.length);
        this.d = iArr2 == null ? null : Arrays.copyOf(iArr2, iArr2.length);
        Code(context);
    }

    private void B() {
        if (D() && ay.I()) {
            int[] iArr = this.f9404c;
            iArr[0] = (this.C - iArr[0]) - this.d[0];
            ge.V("PPSAdvertiserInfoDialog", "rtl mAnchorViewLoc[x,y]= %d, %d", Integer.valueOf(iArr[0]), Integer.valueOf(this.f9404c[1]));
        }
    }

    private void C() {
        ImageView imageView;
        float f;
        if (!D()) {
            V();
            return;
        }
        int V = v.V(this.k, 36.0f);
        int i = this.D;
        int i2 = (this.C - i) - V;
        int i3 = (this.f9404c[0] + (this.d[0] / 2)) - (V / 2);
        if (i3 >= i) {
            i = i3;
        }
        if (i > i2) {
            i = i2;
        }
        if (ay.I()) {
            imageView = this.j;
            f = -i;
        } else {
            imageView = this.j;
            f = i;
        }
        imageView.setX(f);
    }

    private void Code() {
        if (!D()) {
            V();
            return;
        }
        RelativeLayout relativeLayout = this.L;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        ComplianceView complianceView = this.g;
        if (complianceView != null) {
            complianceView.Code(this.f9404c, this.d);
        }
        F();
        S();
        C();
        L();
    }

    private void Code(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hiad_advertiser_info_dialog, this);
        this.k = context.getApplicationContext();
        I();
        Z();
        B();
        Code();
    }

    private void Code(boolean z) {
        int i = 8;
        int i2 = z ? 8 : 0;
        if (z) {
            i = 0;
        }
        this.e.setVisibility(i2);
        this.h.setVisibility(i2);
        this.i.setVisibility(i);
        this.f.setVisibility(i);
        this.g = z ? this.f : this.e;
        this.j = z ? this.i : this.h;
    }

    private boolean D() {
        int[] iArr = this.f9404c;
        boolean z = iArr != null && iArr.length == 2;
        int[] iArr2 = this.d;
        return z && (iArr2 != null && iArr2.length == 2);
    }

    private void F() {
        if (!D()) {
            V();
            return;
        }
        boolean z = true;
        if (this.f9404c[1] + (this.d[1] / 2) > this.S / 2) {
            z = false;
        }
        Code(z);
        RelativeLayout.LayoutParams V = V(z);
        ComplianceView complianceView = this.g;
        if (complianceView == null || V == null) {
            return;
        }
        complianceView.setLayoutParams(V);
    }

    private void I() {
        this.C = com.huawei.openalliance.ad.utils.c.V(this.k);
        this.S = com.huawei.openalliance.ad.utils.c.Code(this.k);
        this.F = ay.c(this.k);
        this.D = v.V(this.k, 22.0f);
    }

    private void L() {
        int V;
        if (!D()) {
            V();
            return;
        }
        ge.V("PPSAdvertiserInfoDialog", "getRealOrientation orientation %s", Integer.valueOf(this.F));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.g.getLayoutParams();
        int abs = Math.abs((int) this.j.getX());
        int V2 = v.V(this.k, 36.0f);
        int i = (V2 >> 1) + abs;
        double d = V2 * 0.5d;
        int viewWidthPercent = (int) ((this.C * (1.0f - this.g.getViewWidthPercent()) * 0.5d) + v.V(this.k, 16.0f) + d);
        int viewWidthPercent2 = (int) (((this.C * ((this.g.getViewWidthPercent() * 0.5d) + 0.5d)) - v.V(this.k, 16.0f)) - d);
        ge.Code("PPSAdvertiserInfoDialog", "locationX: %s, locationX2: %s", Integer.valueOf(viewWidthPercent), Integer.valueOf(viewWidthPercent2));
        ge.Code("PPSAdvertiserInfoDialog", "curImgX: %s, curImgWidth: %s, curImgCenter: %s", Integer.valueOf(abs), Integer.valueOf(V2), Integer.valueOf(i));
        int i2 = this.F;
        if (1 != i2 && 9 != i2) {
            layoutParams.removeRule(14);
            this.g.setLayoutParams(layoutParams);
            int i3 = this.C;
            if (i >= i3 / 3) {
                V = i < (i3 * 2) / 3 ? i - (this.g.getViewWith() >> 1) : ((abs + V2) + v.V(this.k, 16.0f)) - this.g.getViewWith();
            }
            V = abs - v.V(this.k, 16.0f);
        } else if (i < viewWidthPercent) {
            ge.Code("PPSAdvertiserInfoDialog", "curImgCenter < locationX");
            layoutParams.removeRule(14);
            this.g.setLayoutParams(layoutParams);
            V = abs - v.V(this.k, 16.0f);
        } else if (i <= viewWidthPercent2) {
            ge.Code("PPSAdvertiserInfoDialog", "locationX =< curImgCenter =< locationX2");
            layoutParams.addRule(14);
            this.g.setLayoutParams(layoutParams);
            return;
        } else {
            ge.Code("PPSAdvertiserInfoDialog", "curImgCenter > locationX2");
            layoutParams.removeRule(14);
            this.g.setLayoutParams(layoutParams);
            V = ((abs + V2) + v.V(this.k, 16.0f)) - this.g.getViewWith();
            ge.Code("PPSAdvertiserInfoDialog", "paddingStart: %s", Integer.valueOf(V));
        }
        this.g.setPaddingStart(V);
    }

    private void S() {
        if (!D()) {
            V();
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f9403a.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = this.f9404c[0];
            layoutParams2.height = this.f9404c[1];
            this.f9403a.setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = this.b.getLayoutParams();
        if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
            layoutParams4.width = this.d[0];
            layoutParams4.height = this.d[1];
            this.b.setLayoutParams(layoutParams4);
        }
    }

    private RelativeLayout.LayoutParams V(boolean z) {
        int i;
        ComplianceView complianceView = this.g;
        if (complianceView == null) {
            return null;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) complianceView.getLayoutParams();
        boolean B = l.B(this.k);
        boolean z2 = true;
        boolean z3 = l.C(this.k) && (1 == (i = this.F) || 9 == i);
        if (!l.S(this.k) || !l.F(this.k)) {
            z2 = false;
        }
        if (z) {
            if (B || z3 || z2) {
                layoutParams.setMargins(0, 0, 0, Math.max(v.V(this.k, 40.0f), ay.S(this.k)));
            }
            return layoutParams;
        }
        int e = v.e(this.k);
        int i2 = e;
        if (dt.Code(this.k).Code(this.k)) {
            i2 = Math.max(e, dt.Code(this.k).Code(this.L));
        }
        layoutParams.setMargins(0, i2, 0, 0);
        return layoutParams;
    }

    private void V() {
        RelativeLayout relativeLayout = this.L;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    private void Z() {
        this.L = (RelativeLayout) findViewById(R.id.haid_advertiser_info_dialog_root);
        this.f9403a = findViewById(R.id.margin_view);
        this.b = findViewById(R.id.anchor_view);
        this.e = (ComplianceView) findViewById(R.id.top_advertiser_view);
        this.h = (ImageView) findViewById(R.id.top_advertiser_iv);
        this.f = (ComplianceView) findViewById(R.id.bottom_advertiser_view);
        this.i = (ImageView) findViewById(R.id.bottom_advertiser_iv);
        if (Build.VERSION.SDK_INT >= 29) {
            this.L.setForceDarkAllowed(false);
        }
        RelativeLayout relativeLayout = this.L;
        relativeLayout.setOnClickListener(new a(relativeLayout));
    }

    public PPSBaseDialogContentView getBottomDialogView() {
        return this.f;
    }

    @Override // android.view.View
    public RelativeLayout getRootView() {
        return this.L;
    }

    public PPSBaseDialogContentView getTopDialogView() {
        return this.e;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        V();
    }

    public void setAdContent(AdContentData adContentData) {
        this.g.setAdContentData(adContentData);
        Code();
    }

    public void setScreenHeight(int i) {
        if (i > 0) {
            this.S = i;
        }
    }

    public void setScreenWidth(int i) {
        if (i > 0) {
            this.C = i;
        }
    }
}
