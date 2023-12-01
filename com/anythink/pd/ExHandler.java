package com.anythink.pd;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.china.activity.ApkConfirmDialogActivity;
import com.anythink.china.b.a;
import com.anythink.china.common.c;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.p;
import com.tencent.tendinsv.a.b;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/pd/ExHandler.class */
public class ExHandler implements IExHandler {
    public static final String JSON_REQUEST_BOOT_MARK = "boot_mark";
    public static final String JSON_REQUEST_CPU = "cpu";
    public static final String JSON_REQUEST_IMEI = "imei";
    public static final String JSON_REQUEST_INSTALL_TS = "install_ts";
    public static final String JSON_REQUEST_ISAGENT = "isagent";
    public static final String JSON_REQUEST_ISROOT = "isroot";
    public static final String JSON_REQUEST_MAC = "mac";
    public static final String JSON_REQUEST_OAID = "oaid";
    public static final String JSON_REQUEST_SSID = "wifi_name";
    public static final String JSON_REQUEST_UPDATE_MARK = "update_mark";
    public static final String JSON_REQUEST_UPDATE_TS = "update_ts";
    int macOpen = 1;
    int imeiOpen = 1;

    public boolean checkDebuggerDevice(Context context, String str) {
        String b = a.b();
        String str2 = b;
        if (TextUtils.isEmpty(b)) {
            str2 = p.b(context, "anythink_sdk", "oaid", "");
        }
        return TextUtils.equals(str, str2);
    }

    public int checkDownloadType(i iVar, j jVar) {
        return com.anythink.china.common.a.a(n.a().g()).b(iVar);
    }

    public ATEventInterface createDownloadListener(ATBaseAdAdapter aTBaseAdAdapter, BaseAd baseAd, ATEventInterface aTEventInterface) {
        return new c(aTBaseAdAdapter, baseAd, aTEventInterface);
    }

    public String fillCDataParam(String str) {
        if (str == null) {
            return "";
        }
        String d = this.imeiOpen == 1 ? a.d(n.a().g()) : "";
        String a2 = this.macOpen == 1 ? a.a() : "";
        String b = a.b();
        String str2 = d;
        if (d == null) {
            str2 = "";
        }
        String replaceAll = str.replaceAll("at_device1", str2);
        String str3 = a2;
        if (a2 == null) {
            str3 = "";
        }
        return replaceAll.replaceAll("at_device2", str3).replaceAll("at_device3", b == null ? "" : b);
    }

    public void fillRequestData(JSONObject jSONObject, com.anythink.core.c.a aVar) {
        String F = aVar != null ? aVar.F() : "";
        if (TextUtils.isEmpty(F)) {
            try {
                jSONObject.put("mac", a.a());
                jSONObject.put(JSON_REQUEST_IMEI, a.d(n.a().g()));
                jSONObject.put("oaid", a.b());
                return;
            } catch (Exception e) {
                return;
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject(F);
            this.macOpen = jSONObject2.optInt("m");
            this.imeiOpen = jSONObject2.optInt("i");
        } catch (Exception e2) {
        }
        try {
            jSONObject.put("mac", this.macOpen == 1 ? a.a() : "");
            jSONObject.put(JSON_REQUEST_IMEI, this.imeiOpen == 1 ? a.d(n.a().g()) : "");
            jSONObject.put("oaid", a.b());
        } catch (Exception e3) {
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0092 -> B:47:0x001d). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x009a -> B:53:0x003d). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x009e -> B:41:0x0053). Please submit an issue!!! */
    public void fillRequestDeviceData(JSONObject jSONObject, int i) {
        if ((i & 1) == 1) {
            try {
                if (!TextUtils.isEmpty(a.d())) {
                    jSONObject.put(JSON_REQUEST_ISROOT, Integer.parseInt(a.d()));
                }
            } catch (Throwable th) {
            }
            try {
                if (!TextUtils.isEmpty(a.e())) {
                    jSONObject.put(JSON_REQUEST_ISAGENT, Integer.parseInt(a.e()));
                }
            } catch (Throwable th2) {
            }
            try {
                jSONObject.put(JSON_REQUEST_SSID, a.c());
            } catch (Throwable th3) {
            }
            try {
                if (!TextUtils.isEmpty(a.f())) {
                    jSONObject.put(JSON_REQUEST_INSTALL_TS, Long.parseLong(a.f()));
                }
            } catch (Throwable th4) {
            }
            try {
                if (!TextUtils.isEmpty(a.g())) {
                    jSONObject.put(JSON_REQUEST_UPDATE_TS, Long.parseLong(a.g()));
                }
            } catch (Throwable th5) {
            }
            try {
                jSONObject.put("cpu", a.h());
            } catch (Throwable th6) {
            }
        }
        if ((i & 2) == 2) {
            try {
                jSONObject.put(JSON_REQUEST_BOOT_MARK, a.i());
                jSONObject.put(JSON_REQUEST_UPDATE_MARK, a.j());
            } catch (Throwable th7) {
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00a0 -> B:38:0x0063). Please submit an issue!!! */
    public void fillTestDeviceData(JSONObject jSONObject, com.anythink.core.c.a aVar) {
        String str = "";
        String F = aVar != null ? aVar.F() : "";
        if (TextUtils.isEmpty(F)) {
            try {
                String d = a.d(n.a().g());
                if (!TextUtils.isEmpty(d)) {
                    str = d;
                }
                jSONObject.put(b.a.f25299c, str);
                jSONObject.put("OAID", a.c(n.a().g()));
                return;
            } catch (Exception e) {
                return;
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject(F);
            this.macOpen = jSONObject2.optInt("m");
            this.imeiOpen = jSONObject2.optInt("i");
        } catch (Exception e2) {
        }
        try {
            String d2 = a.d(n.a().g());
            String str2 = str;
            if (this.imeiOpen == 1) {
                str2 = str;
                if (!TextUtils.isEmpty(d2)) {
                    str2 = d2;
                }
            }
            jSONObject.put(b.a.f25299c, str2);
            jSONObject.put("OAID", a.c(n.a().g()));
        } catch (Exception e3) {
        }
    }

    public String getUniqueId(Context context) {
        return a.b(context);
    }

    public void handleOfferClick(Context context, j jVar, i iVar, String str, String str2, Runnable runnable, com.anythink.core.common.f.b bVar) {
        com.anythink.china.common.a.a(context).a(context, jVar, iVar, str, str2, runnable, bVar);
    }

    public void initDeviceInfo(Context context) {
        a.a(context);
    }

    public void openApkConfirmDialog(Context context, i iVar, j jVar, com.anythink.core.common.f.a aVar) {
        ApkConfirmDialogActivity.a(context, iVar, aVar);
    }
}
