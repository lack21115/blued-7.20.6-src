package com.huawei.hms.ads.unity;

import com.huawei.hms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/unity/UnityNativeAdDelegate.class */
public class UnityNativeAdDelegate {
    private NativeAd Code;
    private UnityImageDelegate Z;
    private List<UnityImageDelegate> V = new ArrayList();
    private List<UnityImageDelegate> I = new ArrayList();

    public UnityNativeAdDelegate(NativeAd nativeAd) {
        this.Code = nativeAd;
    }

    public UnityImageDelegate getIcon() {
        return this.Z;
    }

    public List<UnityImageDelegate> getIcons() {
        return this.Code == null ? new ArrayList() : this.I;
    }

    public List<UnityImageDelegate> getImages() {
        return this.Code == null ? new ArrayList() : this.V;
    }

    public NativeAd getNativeAd() {
        return this.Code;
    }

    public void setIcon(UnityImageDelegate unityImageDelegate) {
        this.Z = unityImageDelegate;
    }

    public void setIconList(List<UnityImageDelegate> list) {
        this.I.addAll(list);
    }

    public void setImageList(List<UnityImageDelegate> list) {
        this.V.addAll(list);
    }
}
