package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.os.Bundle;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/af.class */
public final class af implements ah {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8935a = "dl_PreferDecompress";

    @Override // com.huawei.hms.ads.uiengineloader.ah
    public final q a(Context context, Bundle bundle) throws com.huawei.hms.ads.dynamicloader.j {
        String string = bundle.getString("module_name");
        try {
            if (o.b(context, string).f8964c > 0) {
                aa.b(f8935a, "Choose the decompressedModuleVersion");
                return new o();
            } else if (p.b(context, string) > 0) {
                aa.b(f8935a, "Choose the HMSLoadStrategy");
                return new p();
            } else {
                aa.c(f8935a, "No available module version.");
                return null;
            }
        } catch (com.huawei.hms.ads.dynamicloader.j e) {
            throw e;
        } catch (Exception e2) {
            aa.c(f8935a, "getLoadingStrategy other exception." + e2.getClass().getSimpleName());
            return null;
        }
    }
}
