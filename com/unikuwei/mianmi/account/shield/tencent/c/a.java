package com.unikuwei.mianmi.account.shield.tencent.c;

import android.content.Context;
import android.content.res.ThemeConfig;
import android.net.Network;
import android.os.Build;
import android.text.TextUtils;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.huawei.hms.framework.common.ContainerUtils;
import com.igexin.sdk.PushConsts;
import com.unikuwei.mianmi.account.shield.tencent.e.c;
import com.unikuwei.mianmi.account.shield.tencent.e.e;
import com.unikuwei.mianmi.account.shield.tencent.e.h;
import com.unikuwei.mianmi.account.shield.tencent.e.j;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/unikuwei/mianmi/account/shield/tencent/c/a.class */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private b f27296c;
    private String d;
    private ExecutorService b = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with root package name */
    private ScheduledExecutorService f27295a = Executors.newScheduledThreadPool(1);

    /* renamed from: com.unikuwei.mianmi.account.shield.tencent.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/unikuwei/mianmi/account/shield/tencent/c/a$a.class */
    public interface InterfaceC0921a {
        void a(String str);
    }

    private String a(Context context, int i, String str) {
        try {
            String packageName = context.getPackageName();
            String b = j.b(context, context.getPackageName());
            String str2 = packageName;
            if (packageName == null) {
                str2 = "";
            }
            String str3 = b;
            if (b == null) {
                str3 = "";
            }
            String a2 = h.a();
            String str4 = i != 2 ? "1" : "";
            String str5 = "" + System.currentTimeMillis();
            String a3 = com.unikuwei.mianmi.account.shield.tencent.a.b.a(j.c(context).getBytes());
            String d = j.d(str);
            String a4 = j.a(str4 + a2 + "30100jsonp" + a3 + d + str2 + str3 + str5 + "5.2.0AK002B1125" + h.b());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("client_id", a2);
            jSONObject.put("client_type", "30100");
            jSONObject.put("format", com.unikuwei.mianmi.account.shield.tencent.a.b.a("jsonp"));
            jSONObject.put("version", com.unikuwei.mianmi.account.shield.tencent.a.b.a("5.2.0AK002B1125"));
            if (i != 2) {
                jSONObject.put("business_type", com.unikuwei.mianmi.account.shield.tencent.a.b.a(str4));
            }
            jSONObject.put("packname", com.unikuwei.mianmi.account.shield.tencent.a.b.a(str2));
            jSONObject.put("packsign", com.unikuwei.mianmi.account.shield.tencent.a.b.a(str3));
            jSONObject.put("timeStamp", com.unikuwei.mianmi.account.shield.tencent.a.b.a(str5));
            jSONObject.put("key", com.unikuwei.mianmi.account.shield.tencent.a.b.a(d));
            jSONObject.put("fp", com.unikuwei.mianmi.account.shield.tencent.a.b.a(a3));
            jSONObject.put(com.anythink.expressad.d.a.b.d, com.unikuwei.mianmi.account.shield.tencent.a.b.a(a4));
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            if (this.f27295a != null) {
                this.f27295a.shutdownNow();
                this.f27295a = null;
            }
        } catch (Exception e) {
        }
    }

    private void a(Context context, int i) {
        this.d = com.unikuwei.mianmi.account.shield.tencent.a.a.a();
        a(context, i, new com.unikuwei.mianmi.account.shield.tencent.d.a() { // from class: com.unikuwei.mianmi.account.shield.tencent.c.a.2
            @Override // com.unikuwei.mianmi.account.shield.tencent.d.a
            public void a(int i2, String str) {
                synchronized (a.this) {
                    if (a.this.f27296c == null) {
                        return;
                    }
                    if (i2 == 0) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            int optInt = jSONObject.optInt("code", 1);
                            String optString = jSONObject.optString("msg", "未知错误");
                            String optString2 = jSONObject.optString("data");
                            if (optInt == 0) {
                                String decode = URLDecoder.decode(com.unikuwei.mianmi.account.shield.tencent.a.a.a(optString2, a.this.d), "UTF-8");
                                if (a.this.f27296c != null) {
                                    a.this.f27296c.a(optString, decode);
                                }
                            } else if (a.this.f27296c != null) {
                                a.this.f27296c.a(optInt, optString, optString2);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            if (a.this.f27296c != null) {
                                b bVar = a.this.f27296c;
                                bVar.a(10002, "异常" + e.getMessage(), str);
                            }
                        }
                    } else if (a.this.f27296c != null) {
                        a.this.f27296c.a(i2, str);
                    }
                    a.this.f27296c = null;
                    a.this.a();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, int i, String str, final Network network, final com.unikuwei.mianmi.account.shield.tencent.d.a aVar) {
        synchronized (this) {
            if (this.b == null || this.f27296c == null) {
                return;
            }
            try {
                final String str2 = str + e.a(a(context, i, this.d), ContainerUtils.FIELD_DELIMITER);
                this.b.submit(new Runnable() { // from class: com.unikuwei.mianmi.account.shield.tencent.c.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            String a2 = new com.unikuwei.mianmi.account.shield.tencent.d.b().a(str2, a.this.b(), network);
                            if (TextUtils.isEmpty(a2)) {
                                aVar.a(10022, "网络请求响应为空");
                            } else {
                                aVar.a(0, a2);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (Exception e) {
                aVar.a(PushConsts.SET_TAG_RESULT, "10009" + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("model", Build.MODEL);
        hashMap.put(ThemeConfig.SYSTEM_DEFAULT, Build.VERSION.RELEASE);
        hashMap.put("woodcock", h.i());
        return hashMap;
    }

    public void a(Context context, int i, int i2, InterfaceC0921a interfaceC0921a) {
        this.f27296c = new b(interfaceC0921a);
        try {
            a();
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
            this.f27295a = newScheduledThreadPool;
            newScheduledThreadPool.schedule(new Runnable() { // from class: com.unikuwei.mianmi.account.shield.tencent.c.a.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (a.this) {
                        if (a.this.f27296c != null) {
                            a.this.f27296c.a(10000, "请求超时");
                            a.this.f27296c = null;
                            a.this.a();
                        }
                    }
                }
            }, i, TimeUnit.MILLISECONDS);
            a(context, i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(final Context context, final int i, final com.unikuwei.mianmi.account.shield.tencent.d.a aVar) {
        try {
            int a2 = j.a(context.getApplicationContext());
            h.b(a2);
            if (a2 == 1) {
                com.unikuwei.mianmi.account.shield.tencent.e.c.a().a(context, "https://opencloud.wostore.cn/openapi/netauth/precheck/wp?", new c.a() { // from class: com.unikuwei.mianmi.account.shield.tencent.c.a.4
                    @Override // com.unikuwei.mianmi.account.shield.tencent.e.c.a
                    public void a(boolean z, Network network) {
                        if (a.this.f27296c == null) {
                            return;
                        }
                        if (z) {
                            a.this.a(context, i, "https://opencloud.wostore.cn/openapi/netauth/precheck/wp?", network, aVar);
                        } else {
                            aVar.a(GLMapStaticValue.AM_CALLBACK_INDOOR_NETWORK_ERR, "无法切换至数据网络");
                        }
                    }
                });
            } else if (a2 == 0) {
                a(context, i, "https://opencloud.wostore.cn/openapi/netauth/precheck/wp?", null, aVar);
            } else {
                aVar.a(10004, "数据网络未开启");
            }
        } catch (Exception e) {
            e.printStackTrace();
            aVar.a(PushConsts.CHECK_CLIENTID, "网络判断异常" + e.getMessage());
        }
    }

    public void finalize() {
        ScheduledExecutorService scheduledExecutorService = this.f27295a;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdownNow();
            this.f27295a = null;
        }
        ExecutorService executorService = this.b;
        if (executorService != null) {
            executorService.shutdownNow();
            this.b = null;
        }
        this.f27296c = null;
        this.d = null;
    }
}
