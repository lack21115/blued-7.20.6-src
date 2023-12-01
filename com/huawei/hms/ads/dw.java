package com.huawei.hms.ads;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dw.class */
public class dw extends dv {
    private static final int B = 0;
    private static final String I = "BaseHwnDeviceImpl";
    private static final String Z = "display_notch_status";

    /* JADX INFO: Access modifiers changed from: protected */
    public dw(Context context) {
        super(context);
    }

    @Override // com.huawei.hms.ads.dv, com.huawei.hms.ads.ee
    public boolean Code(Context context) {
        try {
            int i = Settings.Secure.getInt(context.getContentResolver(), Z);
            ge.Code(I, "isNotchEnable, displayNotch: %s", Integer.valueOf(i));
            return i == 0;
        } catch (Throwable th) {
            ge.V(I, "isNotchEnable err:" + th.getClass().getSimpleName());
            return Build.VERSION.SDK_INT >= 26 && Code((View) null) > 0;
        }
    }

    @Override // com.huawei.hms.ads.dv, com.huawei.hms.ads.ee
    public boolean V() {
        String Code = com.huawei.openalliance.ad.utils.ay.Code("ro.product.locale.region");
        if (TextUtils.isEmpty(Code)) {
            String Code2 = com.huawei.openalliance.ad.utils.ay.Code("ro.product.locale");
            if (TextUtils.isEmpty(Code2)) {
                String Z2 = com.huawei.openalliance.ad.utils.ay.Z();
                if (TextUtils.isEmpty(Z2)) {
                    return false;
                }
                return AdvanceSetting.CLEAR_NOTIFICATION.equalsIgnoreCase(Z2);
            }
            return Code2.toLowerCase(Locale.ENGLISH).contains(AdvanceSetting.CLEAR_NOTIFICATION);
        }
        return AdvanceSetting.CLEAR_NOTIFICATION.equalsIgnoreCase(Code);
    }
}
