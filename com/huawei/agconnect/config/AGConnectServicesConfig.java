package com.huawei.agconnect.config;

import android.content.Context;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.config.impl.c;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/config/AGConnectServicesConfig.class */
public abstract class AGConnectServicesConfig implements AGConnectOptions {
    private static final Map<String, AGConnectServicesConfig> INSTANCES = new HashMap();
    private static final Object INSTANCES_LOCK = new Object();

    public static AGConnectServicesConfig fromContext(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return fromContext(context, context.getPackageName());
    }

    public static AGConnectServicesConfig fromContext(Context context, String str) {
        c cVar;
        synchronized (INSTANCES_LOCK) {
            AGConnectServicesConfig aGConnectServicesConfig = INSTANCES.get(str);
            cVar = aGConnectServicesConfig;
            if (aGConnectServicesConfig == null) {
                cVar = new c(context, str);
                INSTANCES.put(str, cVar);
            }
        }
        return cVar;
    }

    public abstract void overlayWith(LazyInputStream lazyInputStream);

    public abstract void overlayWith(InputStream inputStream);

    public abstract void setParam(String str, String str2);

    public abstract void setRoutePolicy(AGCRoutePolicy aGCRoutePolicy);
}
