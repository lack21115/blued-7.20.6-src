package com.unikuwei.mianmi.account.shield.tencent.e;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.bc;
import com.umeng.analytics.pro.bh;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/unikuwei/mianmi/account/shield/tencent/e/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private ExecutorService f41005a;

    public f() {
        this.f41005a = null;
        this.f41005a = Executors.newFixedThreadPool(1);
    }

    public void a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appId", h.a());
            jSONObject.put("deviceId", h.i());
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put(bh.x, "" + Build.VERSION.SDK_INT);
            jSONObject.put(bc.e.l, str);
            jSONObject.put("message", str2);
            jSONObject.put("sdkVersion", "5.2.0AK002B1125");
            jSONObject.put("apn", h.d());
            jSONObject.put("appName", h.h());
            jSONObject.put("pip", h.e());
            jSONObject.put("netType", "" + h.g());
            jSONObject.put("userTimeout", "" + h.f());
            jSONObject.put("operateTime", "0");
            final String jSONObject2 = jSONObject.toString();
            if (TextUtils.isEmpty(jSONObject2)) {
                return;
            }
            if (this.f41005a == null) {
                this.f41005a = Executors.newFixedThreadPool(1);
            }
            this.f41005a.submit(new Runnable() { // from class: com.unikuwei.mianmi.account.shield.tencent.e.f.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        new com.unikuwei.mianmi.account.shield.tencent.d.b().a("https://opencloud.wostore.cn/client/sdk/receive", jSONObject2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void finalize() {
        ExecutorService executorService = this.f41005a;
        if (executorService != null) {
            executorService.shutdownNow();
            this.f41005a = null;
        }
    }
}
