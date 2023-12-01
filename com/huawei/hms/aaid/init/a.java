package com.huawei.hms.aaid.init;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.opendevice.l;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/aaid/init/a.class */
public class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Context f22395a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.f22395a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            int internalCode = ErrorEnum.SUCCESS.getInternalCode();
            String str = null;
            try {
                String token = HmsInstanceId.getInstance(this.f22395a).getToken(Util.getAppId(this.f22395a), null);
                HMSLog.i("AutoInit", "Push init succeed");
                str = token;
                str = token;
                if (TextUtils.isEmpty(token)) {
                    return;
                }
            } catch (ApiException e) {
                internalCode = e.getStatusCode();
                HMSLog.e("AutoInit", "new Push init failed");
            }
            try {
                Bundle bundle = this.f22395a.getPackageManager().getApplicationInfo(this.f22395a.getPackageName(), 128).metaData;
                if (bundle == null || bundle.getString("com.huawei.hms.client.service.name:push") == null) {
                    HMSLog.i("AutoInit", "push kit sdk not exists");
                    return;
                }
                Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
                intent.setPackage(this.f22395a.getPackageName());
                Bundle bundle2 = new Bundle();
                bundle2.putString("message_type", "new_token");
                bundle2.putString(RemoteMessageConst.DEVICE_TOKEN, str);
                bundle2.putInt("error", internalCode);
                if (new l().a(this.f22395a, bundle2, intent)) {
                    return;
                }
                HMSLog.e("AutoInit", "start service failed");
            } catch (PackageManager.NameNotFoundException e2) {
                HMSLog.i("AutoInit", "push kit sdk not exists");
            }
        } catch (Exception e3) {
            HMSLog.e("AutoInit", "Push init failed", e3);
        }
    }
}
