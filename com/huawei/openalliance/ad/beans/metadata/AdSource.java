package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.utils.aa;
import java.io.Serializable;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/beans/metadata/AdSource.class */
public class AdSource implements Serializable {
    private static final long serialVersionUID = 30457300;
    private int displayPosition;
    private String dspLogo;
    private String dspName;

    public static AdSource Code(List<AdSource> list) {
        if (aa.Code(list)) {
            return null;
        }
        for (AdSource adSource : list) {
            if (Code(adSource)) {
                return adSource;
            }
        }
        return null;
    }

    private static boolean Code(AdSource adSource) {
        return adSource != null && adSource.I() == 1;
    }

    public static AdSource V(List<AdSource> list) {
        if (aa.Code(list)) {
            return null;
        }
        for (AdSource adSource : list) {
            if (V(adSource)) {
                return adSource;
            }
        }
        return null;
    }

    private static boolean V(AdSource adSource) {
        return adSource != null && adSource.I() == 2;
    }

    public String Code() {
        return this.dspName;
    }

    public void Code(int i) {
        this.displayPosition = i;
    }

    public void Code(String str) {
        this.dspName = str;
    }

    public int I() {
        return this.displayPosition;
    }

    public String V() {
        return this.dspLogo;
    }

    public void V(String str) {
        this.dspLogo = str;
    }
}
