package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.he;
import com.huawei.hms.ads.hf;
import com.huawei.openalliance.ad.inter.data.n;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/NativeMediaView.class */
public abstract class NativeMediaView extends AutoScaleSizeRelativeLayout {
    private static final String S = NativeMediaView.class.getSimpleName();
    protected n B;
    protected he C;
    private hf D;
    boolean I;
    boolean V;

    public NativeMediaView(Context context) {
        super(context);
        this.V = false;
        this.I = false;
        this.C = new he(this) { // from class: com.huawei.openalliance.ad.views.NativeMediaView.1
            @Override // com.huawei.hms.ads.he
            public void Code() {
                NativeMediaView.this.Code();
            }

            @Override // com.huawei.hms.ads.he
            public void Code(int i) {
                NativeMediaView.this.Code(i);
            }

            @Override // com.huawei.hms.ads.he
            public void Code(long j, int i) {
                NativeMediaView.this.Code(0);
            }
        };
    }

    public NativeMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.V = false;
        this.I = false;
        this.C = new he(this) { // from class: com.huawei.openalliance.ad.views.NativeMediaView.1
            @Override // com.huawei.hms.ads.he
            public void Code() {
                NativeMediaView.this.Code();
            }

            @Override // com.huawei.hms.ads.he
            public void Code(int i) {
                NativeMediaView.this.Code(i);
            }

            @Override // com.huawei.hms.ads.he
            public void Code(long j, int i) {
                NativeMediaView.this.Code(0);
            }
        };
    }

    public NativeMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.V = false;
        this.I = false;
        this.C = new he(this) { // from class: com.huawei.openalliance.ad.views.NativeMediaView.1
            @Override // com.huawei.hms.ads.he
            public void Code() {
                NativeMediaView.this.Code();
            }

            @Override // com.huawei.hms.ads.he
            public void Code(int i2) {
                NativeMediaView.this.Code(i2);
            }

            @Override // com.huawei.hms.ads.he
            public void Code(long j, int i2) {
                NativeMediaView.this.Code(0);
            }
        };
    }

    protected void B() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Code() {
    }

    void Code(int i) {
        String str = S;
        ge.V(str, "visiblePercentage is " + i);
        hf hfVar = this.D;
        if (hfVar != null) {
            hfVar.Code(i);
        }
        if (i >= getAutoPlayAreaPercentageThresshold()) {
            this.I = false;
            if (this.V) {
                return;
            }
            this.V = true;
            V();
            return;
        }
        this.V = false;
        int hiddenAreaPercentageThreshhold = getHiddenAreaPercentageThreshhold();
        String str2 = S;
        ge.V(str2, "HiddenAreaPercentageThreshhold is " + hiddenAreaPercentageThreshhold);
        if (i > 100 - hiddenAreaPercentageThreshhold) {
            if (this.I) {
                B();
            }
            this.I = false;
        } else if (this.I) {
        } else {
            this.I = true;
            I();
        }
    }

    protected void I() {
    }

    protected void V() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getAutoPlayAreaPercentageThresshold() {
        return 100;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getHiddenAreaPercentageThreshhold() {
        return 10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        he heVar = this.C;
        if (heVar != null) {
            heVar.D();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        he heVar = this.C;
        if (heVar != null) {
            heVar.L();
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        he heVar = this.C;
        if (heVar != null) {
            heVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNativeAd(com.huawei.openalliance.ad.inter.data.g gVar) {
        this.B = gVar instanceof n ? (n) gVar : null;
    }

    public void setViewShowAreaListener(hf hfVar) {
        this.D = hfVar;
    }
}
