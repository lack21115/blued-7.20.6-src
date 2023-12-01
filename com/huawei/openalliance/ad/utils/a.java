package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.ads.ge;
import com.huawei.hms.analytics.HiAnalytics;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/a.class */
public class a {
    private static final String Code = "AaidUtil";

    public static String Code(final Context context) {
        if (Code()) {
            final am Code2 = am.Code(context);
            String D = Code2.D();
            if (TextUtils.isEmpty(D)) {
                f.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            Task aaid = HiAnalytics.getInstance(Context.this).getAAID();
                            if (aaid != null) {
                                Code2.I((String) aaid.getResult());
                            }
                        } catch (Throwable th) {
                            ge.I(a.Code, "error getAgcAaid: " + th.getClass().getSimpleName());
                        }
                    }
                });
            }
            return D;
        }
        return "";
    }

    public static boolean Code() {
        return an.I(com.huawei.openalliance.ad.constant.t.bM);
    }
}
