package com.huawei.openalliance.ad.uriaction;

import android.content.Context;
import com.huawei.hms.ads.kx;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/uriaction/q.class */
public abstract class q {
    protected kx B;
    private String Code = null;
    protected Context I;
    private q V;
    protected AdContentData Z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Context context, AdContentData adContentData) {
        this.I = context;
        this.Z = adContentData;
    }

    public void Code(kx kxVar) {
        this.B = kxVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Code(q qVar) {
        this.V = qVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Code(String str) {
        this.Code = str;
    }

    public abstract boolean Code();

    public String I() {
        q qVar;
        return (this.Code != null || (qVar = this.V) == null) ? this.Code : qVar.I();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean V() {
        q qVar = this.V;
        if (qVar != null) {
            return qVar.Code();
        }
        return false;
    }
}
