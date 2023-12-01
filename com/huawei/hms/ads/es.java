package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/es.class */
public abstract class es {
    protected Context Code;
    private es I;
    private a V;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/es$a.class */
    public interface a {
        void Code(AppInfo appInfo);

        void V(AppInfo appInfo);
    }

    public es(Context context) {
        this.Code = context;
    }

    public Context Code() {
        return this.Code;
    }

    public void Code(a aVar) {
        this.V = aVar;
    }

    public void Code(es esVar) {
        this.I = esVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Code(AppInfo appInfo) {
        a aVar = this.V;
        if (aVar != null) {
            aVar.Code(appInfo);
        }
    }

    public abstract void Code(AppInfo appInfo, AdContentData adContentData, long j);

    /* JADX INFO: Access modifiers changed from: protected */
    public void V(AppInfo appInfo) {
        a aVar = this.V;
        if (aVar != null) {
            aVar.V(appInfo);
        }
    }

    protected void V(AppInfo appInfo, AdContentData adContentData, long j) {
        es esVar = this.I;
        if (esVar == null) {
            V(appInfo);
            return;
        }
        esVar.Code(this.V);
        this.I.Code(appInfo, adContentData, j);
    }
}
