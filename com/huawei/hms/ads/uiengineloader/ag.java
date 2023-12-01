package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/ag.class */
public final class ag implements ah {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8936a = "PreHiOrDecompress";

    @Override // com.huawei.hms.ads.uiengineloader.ah
    public final q a(Context context, Bundle bundle) throws com.huawei.hms.ads.dynamicloader.j {
        String string = bundle.getString("module_name");
        aa.b(f8936a, "getLoadingStrategy");
        try {
            int b = p.b(context, string);
            int i = o.b(context, string).f8964c;
            aa.b(f8936a, "3 module_name:" + string + ", hmsModuleVersion:" + b + ", assetModuleVersion:0, decompressedModuleVersion:" + i);
            if (b > 0 && b > i) {
                aa.b(f8936a, "Choose the HMSLoadStrategy");
                return new p();
            } else if (i > 0) {
                aa.b(f8936a, "Choose the DecompressLoadStrategy");
                return new o();
            } else {
                aa.d(f8936a, "PreferHighestOrRemote: Cannot find a valid module version.");
                return null;
            }
        } catch (com.huawei.hms.ads.dynamicloader.j e) {
            throw e;
        } catch (Throwable th) {
            Log.w(f8936a, "getLoadingStrategy other exception.".concat(String.valueOf(th)));
            return null;
        }
    }
}
