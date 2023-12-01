package com.bytedance.bdtracker;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/y0.class */
public class y0 extends i0 {
    public final Context e;

    public y0(Context context) {
        super(true, false);
        this.e = context;
    }

    @Override // com.bytedance.bdtracker.i0
    public boolean a(JSONObject jSONObject) {
        PackageInfo packageInfo;
        try {
            packageInfo = this.e.getPackageManager().getPackageInfo(this.e.getPackageName(), 64);
        } catch (PackageManager.NameNotFoundException e) {
            z2.c("U SHALL NOT PASS!", e);
            packageInfo = null;
        }
        String str = null;
        if (packageInfo != null) {
            Signature[] signatureArr = packageInfo.signatures;
            str = null;
            if (signatureArr != null) {
                str = null;
                if (signatureArr.length > 0) {
                    Signature signature = signatureArr[0];
                    str = null;
                    if (signature != null) {
                        str = o2.a(signature.toByteArray());
                    }
                }
            }
        }
        if (str != null) {
            jSONObject.put("sig_hash", str);
            return true;
        }
        return true;
    }
}
