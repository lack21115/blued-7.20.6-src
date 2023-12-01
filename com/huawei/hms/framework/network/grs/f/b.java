package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.AssetsUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/framework/network/grs/f/b.class */
public class b {
    private static final Map<String, b> b = new ConcurrentHashMap(16);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f22692c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private a f22693a;

    public b(Context context, GrsBaseInfo grsBaseInfo, boolean z) {
        a(context, z);
        Map<String, b> map = b;
        map.put(context.getPackageName() + grsBaseInfo.uniqueCode(), this);
    }

    public static b a(String str, GrsBaseInfo grsBaseInfo) {
        Map<String, b> map = b;
        return map.get(str + grsBaseInfo.uniqueCode());
    }

    public static void a(Context context, GrsBaseInfo grsBaseInfo) {
        b a2 = a(context.getPackageName(), grsBaseInfo);
        if (a2 != null) {
            Logger.i("LocalManagerProxy", "appGrs is not null and clear services.");
            synchronized (f22692c) {
                a2.f22693a.a();
            }
        }
    }

    public com.huawei.hms.framework.network.grs.local.model.a a() {
        return this.f22693a.b();
    }

    public String a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z) {
        synchronized (f22692c) {
            String a2 = this.f22693a.a(context, aVar, grsBaseInfo, str, str2, z);
            if (TextUtils.isEmpty(a2) && this.f22693a.d()) {
                a(context, true);
                a(grsBaseInfo);
                Map<String, b> map = b;
                map.put(context.getPackageName() + grsBaseInfo.uniqueCode(), this);
                return this.f22693a.a(context, aVar, grsBaseInfo, str, str2, z);
            }
            return a2;
        }
    }

    public Map<String, String> a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z) {
        synchronized (f22692c) {
            Map<String, String> a2 = this.f22693a.a(context, aVar, grsBaseInfo, str, z);
            if ((a2 == null || a2.isEmpty()) && this.f22693a.d()) {
                a(context, true);
                a(grsBaseInfo);
                Map<String, b> map = b;
                map.put(context.getPackageName() + grsBaseInfo.uniqueCode(), this);
                return this.f22693a.a(context, aVar, grsBaseInfo, str, z);
            }
            return a2;
        }
    }

    public void a(Context context, boolean z) {
        String[] list = AssetsUtil.list(context, GrsApp.getInstance().getBrand(""));
        ArrayList arrayList = list == null ? new ArrayList() : Arrays.asList(list);
        String appConfigName = GrsApp.getInstance().getAppConfigName();
        Logger.i("LocalManagerProxy", "appConfigName is: " + appConfigName);
        this.f22693a = new d(false, z);
        if (arrayList.contains("grs_app_global_route_config.json") || !TextUtils.isEmpty(appConfigName)) {
            this.f22693a = new d(context, appConfigName, z);
        }
        if (!this.f22693a.e() && arrayList.contains("grs_sdk_global_route_config.json")) {
            this.f22693a = new c(context, z);
        }
        this.f22693a.a(context, arrayList);
    }

    public void a(GrsBaseInfo grsBaseInfo) {
        this.f22693a.a(grsBaseInfo);
    }

    public Set<String> b() {
        return this.f22693a.c();
    }
}
