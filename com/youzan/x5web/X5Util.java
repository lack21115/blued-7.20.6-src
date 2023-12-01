package com.youzan.x5web;

import android.content.Context;
import android.util.Log;
import com.tencent.smtt.sdk.QbSdk;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/x5web/X5Util.class */
public class X5Util {
    public static void preinitX5Environment(Context context) {
        QbSdk.initX5Environment(context.getApplicationContext(), new QbSdk.PreInitCallback() { // from class: com.youzan.x5web.X5Util.1
            @Override // com.tencent.smtt.sdk.QbSdk.PreInitCallback
            public void onCoreInitFinished() {
            }

            @Override // com.tencent.smtt.sdk.QbSdk.PreInitCallback
            public void onViewInitFinished(boolean z) {
                Log.d("app", " onViewInitFinished is " + z);
            }
        });
    }
}
