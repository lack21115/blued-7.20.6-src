package com.tencent.tmsqmsp.oaid2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/v.class */
public class v extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z;
        if (context == null || intent == null) {
            return;
        }
        boolean z2 = false;
        int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
        x.b("shouldUpdateId, notifyFlag : " + intExtra);
        if (intExtra != 1) {
            if (intExtra == 2) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
                if (stringArrayListExtra == null) {
                    return;
                }
                z = stringArrayListExtra.contains(context.getPackageName());
                if (z) {
                    w a2 = x.a().a(intent.getStringExtra("openIdType"));
                    if (a2 != null) {
                        a2.b();
                        return;
                    }
                    return;
                }
            } else {
                z = true;
            }
            z2 = z;
            if (intExtra == 0) {
                z2 = z;
                if (z) {
                    w a3 = x.a().a(intent.getStringExtra("openIdType"));
                    if (a3 != null) {
                        a3.b();
                        return;
                    }
                    return;
                }
            }
        } else if (TextUtils.equals(intent.getStringExtra("openIdPackage"), context.getPackageName())) {
            z2 = true;
        }
        if (z2) {
            w a4 = x.a().a(intent.getStringExtra("openIdType"));
            if (a4 != null) {
                a4.b();
            }
        }
    }
}
