package com.huawei.openalliance.ad.uriaction;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.ko;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.constant.ac;
import com.huawei.openalliance.ad.constant.t;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/uriaction/a.class */
public class a extends q {
    private static final String Code = "AppAction";

    public a(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    private void Code(Intent intent) {
        String I = com.huawei.openalliance.ad.inter.b.Code().I();
        ge.V(Code, "at is null ? " + TextUtils.isEmpty(I));
        if (TextUtils.isEmpty(I)) {
            return;
        }
        if (!V(intent.getDataString())) {
            ge.V(Code, "isHwPPSUri false.");
        } else if (com.huawei.openalliance.ad.utils.e.Code(this.I)) {
            intent.putExtra(t.cN, I);
        } else {
            ge.V(Code, "isHMSInstalled false.");
        }
    }

    private void Code(Intent intent, String str) {
        if (intent == null || TextUtils.isEmpty(str) || str.indexOf("hwpps") <= 0) {
            return;
        }
        intent.addFlags(268435456);
    }

    private static void Code(final AppInfo appInfo) {
        if (appInfo == null) {
            ge.V(Code, "appInfo is empty.");
            return;
        }
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.uriaction.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.huawei.openalliance.ad.download.a Code2 = com.huawei.openalliance.ad.download.a.Code();
                if (Code2 != null) {
                    Code2.Code(AppInfo.this.Code());
                }
            }
        });
        com.huawei.openalliance.ad.utils.f.I(new Runnable() { // from class: com.huawei.openalliance.ad.uriaction.a.2
            @Override // java.lang.Runnable
            public void run() {
                com.huawei.openalliance.ad.download.a Code2 = com.huawei.openalliance.ad.download.a.Code();
                if (Code2 != null) {
                    Code2.Code(AppInfo.this);
                }
            }
        });
    }

    private boolean V(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            boolean z = false;
            if (TextUtils.equals("hwpps", parse.getScheme())) {
                z = false;
                if (TextUtils.equals(t.cP, host)) {
                    z = true;
                }
            }
            return z;
        } catch (Throwable th) {
            ge.I(Code, "isHwPPSUri exception." + th.getClass().getSimpleName());
            return false;
        }
    }

    private void Z() {
        String str;
        try {
            MetaData Z = this.Z.Z();
            boolean z = false;
            if (Z != null) {
                ApkInfo c2 = Z.c();
                z = false;
                if (c2 != null) {
                    z = false;
                    if (com.huawei.openalliance.ad.utils.e.V(this.I, c2.Code()) != null) {
                        z = true;
                    }
                }
            }
            ko.Code(this.I, this.Z, ac.D, (Integer) 1, Integer.valueOf(z ? 2 : 1));
        } catch (IllegalStateException e) {
            str = "recordOpenFailEvent IllegalStateException";
            ge.I(Code, str);
        } catch (Exception e2) {
            str = "recordOpenFailEvent " + e2.getClass().getSimpleName();
            ge.I(Code, str);
        }
    }

    @Override // com.huawei.openalliance.ad.uriaction.q
    public boolean Code() {
        String str;
        String i;
        Intent V;
        ge.V(Code, "handle app action");
        try {
            AppInfo u = this.Z.u();
            String Code2 = u == null ? null : u.Code();
            i = this.Z.i();
            V = com.huawei.openalliance.ad.utils.e.V(this.I, i, Code2);
        } catch (ActivityNotFoundException e) {
            str = "activity not exist";
            ge.I(Code, str);
            Z();
            return V();
        } catch (Exception e2) {
            str = "handle intent url fail";
            ge.I(Code, str);
            Z();
            return V();
        }
        if (V == null) {
            ge.I(Code, "cannot find target activity");
            Z();
            return V();
        }
        if (!(this.I instanceof Activity)) {
            V.addFlags(268435456);
        }
        Code(V, i);
        V.setClipData(t.cF);
        Code(V);
        this.I.startActivity(V);
        Code("app");
        Code(this.Z.u());
        ko.Code(this.I, this.Z, "intentSuccess", (Integer) 1, (Integer) null);
        return true;
    }
}
