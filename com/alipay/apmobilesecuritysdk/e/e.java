package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import com.anythink.china.api.ChinaDeviceDataInfo;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/e/e.class */
public final class e {
    public static f a(Context context) {
        if (context == null) {
            return null;
        }
        String a = com.alipay.apmobilesecuritysdk.f.a.a(context, "device_feature_prefs_name", "device_feature_prefs_key");
        String str = a;
        if (com.alipay.security.mobile.module.a.a.a(a)) {
            str = com.alipay.apmobilesecuritysdk.f.a.a("device_feature_file_name", "device_feature_file_key");
        }
        if (com.alipay.security.mobile.module.a.a.a(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            f fVar = new f();
            fVar.a(jSONObject.getString(ChinaDeviceDataInfo.IMEI));
            fVar.b(jSONObject.getString("imsi"));
            fVar.c(jSONObject.getString(ChinaDeviceDataInfo.MAC));
            fVar.d(jSONObject.getString("bluetoothmac"));
            fVar.e(jSONObject.getString("gsi"));
            return fVar;
        } catch (Exception e) {
            com.alipay.apmobilesecuritysdk.c.a.a(e);
            return null;
        }
    }
}
