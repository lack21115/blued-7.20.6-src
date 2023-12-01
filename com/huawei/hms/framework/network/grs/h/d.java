package com.huawei.hms.framework.network.grs.h;

import android.os.SystemClock;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/h/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, a> f9115a = new ConcurrentHashMap(16);

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/h/d$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final long f9116a;
        private final long b;

        public a(long j, long j2) {
            this.f9116a = j;
            this.b = j2;
        }

        public boolean a() {
            return SystemClock.elapsedRealtime() - this.b <= this.f9116a;
        }
    }

    public static a a(String str) {
        Logger.v("RequestUtil", "map size of get is before: " + f9115a.size());
        a aVar = f9115a.get(str);
        Logger.v("RequestUtil", "map size of get is after: " + f9115a.size());
        return aVar;
    }

    public static void a(String str, a aVar) {
        Logger.v("RequestUtil", "map size of put is before: " + f9115a.size());
        f9115a.put(str, aVar);
        Logger.v("RequestUtil", "map size of put is after: " + f9115a.size());
    }
}
