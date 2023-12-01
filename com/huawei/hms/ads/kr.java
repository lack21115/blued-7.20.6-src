package com.huawei.hms.ads;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.ads.kn;
import com.huawei.openalliance.ad.constant.bc;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.HashMap;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/kr.class */
public class kr {
    private static final String Code = "TemplateActionProcessor";
    private static kr I;
    private static final byte[] V = new byte[0];
    private String B = null;
    private String C = null;
    private Context Z;

    private kr(Context context) {
        this.Z = context.getApplicationContext();
    }

    public static kr Code(Context context) {
        return V(context);
    }

    private static kr V(Context context) {
        kr krVar;
        synchronized (V) {
            if (I == null) {
                I = new kr(context);
            }
            krVar = I;
        }
        return krVar;
    }

    public void Code(AdContentData adContentData) {
        ge.V(Code, "onPrepare");
        if (HiAd.getInstance(this.Z).getExtensionActionListener() == null || adContentData == null) {
            return;
        }
        HiAd.getInstance(this.Z).getExtensionActionListener().Code(adContentData.T());
    }

    public void Code(AdContentData adContentData, int i) {
        if (HiAd.getInstance(this.Z).getExtensionActionListener() == null || adContentData == null) {
            return;
        }
        String str = this.C;
        if (str == null || !str.equals(adContentData.T())) {
            ge.V(Code, "onFail");
            this.C = adContentData.T();
            HiAd.getInstance(this.Z).getExtensionActionListener().Code(adContentData.T(), i);
        }
    }

    public void Code(AdContentData adContentData, Bundle bundle) {
        ge.V(Code, "onEnd");
        ko.Code(this.Z, adContentData, com.huawei.openalliance.ad.constant.ac.L, Long.valueOf(bundle.getLong("startTime")), Long.valueOf(bundle.getLong("endTime")), Integer.valueOf(bundle.getInt(bc.e.h)), Integer.valueOf(bundle.getInt(bc.e.i)));
        V(adContentData);
    }

    public void Code(AdContentData adContentData, String str) {
        ge.V(Code, "onShow");
        kn.a aVar = new kn.a();
        aVar.Code(str);
        ko.Code(this.Z, adContentData, aVar.Code(), com.huawei.openalliance.ad.constant.ac.b);
        if (HiAd.getInstance(this.Z).getExtensionActionListener() == null || adContentData == null) {
            return;
        }
        HiAd.getInstance(this.Z).getExtensionActionListener().I(adContentData.T());
    }

    public boolean Code(Context context, AdContentData adContentData, Bundle bundle, String str) {
        ge.V(Code, "onClick");
        try {
            int i = bundle.getInt(bc.e.d);
            int i2 = bundle.getInt(bc.e.e);
            int i3 = bundle.getInt(bc.e.j);
            com.huawei.openalliance.ad.uriaction.q Code2 = com.huawei.openalliance.ad.uriaction.r.Code(context, adContentData, new HashMap(0));
            if (Code2.Code()) {
                ko.Code(this.Z, adContentData, i, i2, Code2.I(), i3, (com.huawei.openalliance.ad.inter.data.m) null, str, (int[]) null);
                if (HiAd.getInstance(this.Z).getExtensionActionListener() == null || adContentData == null) {
                    return true;
                }
                HiAd.getInstance(this.Z).getExtensionActionListener().Z(adContentData.T());
                return true;
            }
            return false;
        } catch (Throwable th) {
            ge.V(Code, "deal with click err: %s", th.getClass().getSimpleName());
            return false;
        }
    }

    public void I(AdContentData adContentData, Bundle bundle) {
        int i;
        try {
            i = bundle.getInt(bc.e.l);
        } catch (Throwable th) {
            ge.V(Code, "get errCode err: %s", th.getClass().getSimpleName());
            i = -1;
        }
        Code(adContentData, i);
    }

    public void V(AdContentData adContentData) {
        if (HiAd.getInstance(this.Z).getExtensionActionListener() == null || adContentData == null) {
            if (adContentData != null || HiAd.getInstance(this.Z).getExtensionActionListener() == null) {
                return;
            }
            HiAd.getInstance(this.Z).getExtensionActionListener().V(null);
            return;
        }
        String str = this.B;
        if (str == null || !str.equals(adContentData.T())) {
            ge.V(Code, "onDismiss");
            this.B = adContentData.T();
            HiAd.getInstance(this.Z).getExtensionActionListener().V(adContentData.T());
        }
    }

    public void V(AdContentData adContentData, Bundle bundle) {
        ge.V(Code, "onClose");
        ko.Code(this.Z, adContentData, bundle.getInt(bc.e.d), bundle.getInt(bc.e.e), com.huawei.openalliance.ad.constant.ac.f22938a);
        V(adContentData);
    }
}
