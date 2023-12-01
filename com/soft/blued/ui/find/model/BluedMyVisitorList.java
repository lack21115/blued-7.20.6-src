package com.soft.blued.ui.find.model;

import com.blued.android.module.common.adx.banner.AdxNativeUnifiedManager;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.kwad.sdk.api.KsNativeAd;
import com.soft.blued.ui.ab_test.models.NativeAdExtra;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/BluedMyVisitorList.class */
public class BluedMyVisitorList extends UserBasicModel implements Cloneable {
    public NativeAdExtra adx;
    public transient AdxNativeUnifiedManager adxNativeManager;
    public String fuzzy_profile_picture;
    public int is_interested;
    public int is_vip;
    public KsNativeAd ksNativeAd;
    public String[] label;
    public String last_visit_time;
    public List<ProfilePicture> profile_picture;
    public TTNativeAd ttNativeAdData;
    public String visited_time;
    public String visitors_time;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/model/BluedMyVisitorList$ProfilePicture.class */
    public static class ProfilePicture extends BluedMyVisitorList {
        public String url;

        @Override // com.soft.blued.ui.find.model.BluedMyVisitorList
        /* renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo9108clone() throws CloneNotSupportedException {
            return super.mo9108clone();
        }
    }

    @Override // 
    /* renamed from: clone */
    public BluedMyVisitorList mo9108clone() {
        try {
            return (BluedMyVisitorList) super.clone();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean isAdx() {
        NativeAdExtra nativeAdExtra = this.adx;
        return (nativeAdExtra == null || nativeAdExtra.serial_parallel == null || this.adx.connect_type != 1) ? false : true;
    }
}
