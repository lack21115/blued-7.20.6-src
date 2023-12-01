package com.efs.sdk.base.core.config.a;

import android.text.TextUtils;
import com.efs.sdk.base.core.controller.ControllerCenter;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/core/config/a/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public int f8143a = -1;
    String b = "https://";

    /* renamed from: c  reason: collision with root package name */
    String f8144c = "errlog.umeng.com";
    long d = 480;
    private Boolean g = null;
    public Map<String, Double> e = new HashMap();
    public Map<String, String> f = new HashMap();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a() {
        b bVar = new b();
        if (ControllerCenter.getGlobalEnvStruct().isIntl()) {
            bVar.f8144c = "errlogos.umeng.com";
            return bVar;
        }
        bVar.f8144c = "errlog.umeng.com";
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Map<String, String> map) {
        if (map.containsKey("gate_way")) {
            String str = map.get("gate_way");
            if (!TextUtils.isEmpty(str)) {
                this.f8144c = str;
            }
        }
        if (map.containsKey("gate_way_https")) {
            String str2 = map.get("gate_way_https");
            if (!TextUtils.isEmpty(str2)) {
                this.b = Boolean.parseBoolean(str2) ? "https://" : "http://";
            }
        }
        try {
            if (map.containsKey("updateInteval")) {
                String str3 = map.get("updateInteval");
                if (!TextUtils.isEmpty(str3)) {
                    this.d = Long.parseLong(str3);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.startsWith("data_sampling_rate_") || key.startsWith("file_sampling_rate_")) {
                String replace = key.replace("data_sampling_rate_", "").replace("file_sampling_rate_", "");
                double d = 100.0d;
                try {
                    d = Double.parseDouble(entry.getValue());
                } catch (Throwable th2) {
                }
                hashMap.put(replace, Double.valueOf(d));
            }
        }
        this.e = hashMap;
        this.f = map;
    }
}
