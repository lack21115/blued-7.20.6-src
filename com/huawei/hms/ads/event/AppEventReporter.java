package com.huawei.hms.ads.event;

import android.content.Context;
import com.huawei.hms.ads.eg;
import com.huawei.openalliance.ad.ipc.g;
import com.huawei.openalliance.ad.utils.z;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/event/AppEventReporter.class */
public class AppEventReporter {
    public static void reportEventData(Context context, Map<String, String> map) {
        g.V(context).Code(eg.S, z.V(map), null, null);
    }
}
