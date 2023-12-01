package com.huawei.hms.ads;

import android.content.Context;
import android.content.res.Resources;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.jsb.inner.data.DeviceInfo;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.c;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/ak.class */
public class ak extends af {
    public static final String Z = "JsbReqSettings";

    public ak() {
        super(ai.Code);
    }

    private String V(Context context) {
        Resources resources = context.getResources();
        return com.huawei.openalliance.ad.constant.ao.ad + ":" + resources.getString(R.string.hiad_ad_label) + ",download:" + resources.getString(R.string.hiad_download_download) + ",resume:" + resources.getString(R.string.hiad_download_resume) + "," + com.huawei.openalliance.ad.constant.ao.ah + ":" + resources.getString(R.string.hiad_download_installing) + ",install:" + resources.getString(R.string.hiad_download_install) + ",open:" + resources.getString(R.string.hiad_download_open) + "," + com.huawei.openalliance.ad.constant.ao.aj + ":" + resources.getString(R.string.hiad_choices_whythisad) + "," + com.huawei.openalliance.ad.constant.ao.ak + ":" + resources.getString(R.string.hiad_choices_hide) + "," + com.huawei.openalliance.ad.constant.ao.al + ":" + resources.getString(R.string.hiad_choices_ad_no_interest) + "," + com.huawei.openalliance.ad.constant.ao.am + ":" + resources.getString(R.string.hiad_app_preorder) + "," + com.huawei.openalliance.ad.constant.ao.an + ":" + resources.getString(R.string.hiad_app_preordered);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.Code(dt.Code(context).V());
        deviceInfo.Code(c.Code());
        deviceInfo.V(V(context));
        Code(remoteCallResultCallback, this.Code, 1000, com.huawei.openalliance.ad.utils.z.Code(deviceInfo), true);
    }
}
