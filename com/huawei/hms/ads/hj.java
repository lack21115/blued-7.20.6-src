package com.huawei.hms.ads;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.huawei.openalliance.ad.activity.PPSNotificationActivity;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/hj.class */
public class hj extends ho {
    private static final int C = 1;
    private static final String I = "AppInstalledNotification";
    private AdContentData B;
    private int S;
    private AppInfo Z;

    public hj(Context context, AdContentData adContentData, String str) {
        super(context);
        AppInfo appInfo;
        this.B = adContentData;
        this.Z = adContentData.u();
        if (TextUtils.isEmpty(str) || (appInfo = this.Z) == null) {
            return;
        }
        appInfo.V(str);
    }

    private PendingIntent Code(String str) {
        if (F()) {
            Intent intent = new Intent();
            intent.setAction(str);
            intent.setPackage(this.Code.getPackageName());
            intent.putExtra("type", 1);
            intent.putExtra("appInfo", this.Z);
            intent.putExtra(hl.I, this.S);
            intent.putExtra("contentRecord", this.B);
            return PendingIntent.getBroadcast(this.Code, Code(), intent, 201326592);
        }
        return null;
    }

    private boolean D() {
        AppInfo appInfo = this.Z;
        return (appInfo == null || appInfo.l() != 1 || TextUtils.isEmpty(this.Z.m())) ? false : true;
    }

    private boolean F() {
        AppInfo appInfo = this.Z;
        return (appInfo == null || TextUtils.isEmpty(appInfo.Code())) ? false : true;
    }

    private PendingIntent V(String str) {
        if (F()) {
            Intent intent = new Intent(this.Code, PPSNotificationActivity.class);
            intent.setAction(str);
            intent.putExtra("type", 1);
            intent.putExtra("appInfo", this.Z);
            intent.putExtra(hl.I, this.S);
            intent.putExtra("contentRecord", this.B);
            return PendingIntent.getActivity(this.Code, Code(), intent, 201326592);
        }
        return null;
    }

    private void V(Notification.Builder builder) {
        Drawable loadIcon;
        if (!F() || this.Code == null) {
            return;
        }
        PackageInfo V = com.huawei.openalliance.ad.utils.e.V(this.Code, this.Z.Code());
        if (V.applicationInfo == null || (loadIcon = V.applicationInfo.loadIcon(this.Code.getPackageManager())) == null) {
            return;
        }
        builder.setLargeIcon(com.huawei.openalliance.ad.utils.y.Code(loadIcon));
    }

    @Override // com.huawei.hms.ads.ho
    protected String B() {
        return I;
    }

    @Override // com.huawei.hms.ads.ho
    protected String C() {
        AppInfo appInfo = this.Z;
        return appInfo != null ? com.huawei.openalliance.ad.utils.au.V(appInfo.m()) : "";
    }

    @Override // com.huawei.hms.ads.ho
    int Code() {
        if (F()) {
            return this.Z.Code().hashCode();
        }
        return 1;
    }

    public void Code(int i) {
        this.S = i;
    }

    @Override // com.huawei.hms.ads.ho
    void Code(Notification.Builder builder) {
        if (builder == null || !F()) {
            return;
        }
        V(builder);
        builder.setDeleteIntent(Code(hq.V));
    }

    @Override // com.huawei.hms.ads.ho
    public void I() {
        if (D()) {
            hq.Code(this.Code).Code(this.Z.Code());
            super.I();
            if (this.B == null || !com.huawei.openalliance.ad.utils.ay.d(this.Code)) {
                return;
            }
            hn.I(this.Code, this.B);
        }
    }

    @Override // com.huawei.hms.ads.ho
    protected PendingIntent S() {
        return V(hq.Code);
    }

    public int V() {
        return this.S;
    }

    @Override // com.huawei.hms.ads.ho
    protected String Z() {
        AppInfo appInfo = this.Z;
        return appInfo != null ? appInfo.L() : "";
    }
}
