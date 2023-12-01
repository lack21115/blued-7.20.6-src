package com.blued.android.module.device_identity.library;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import cn.shuzilm.core.Listener;
import cn.shuzilm.core.Main;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.framework.utils.SharedPreferencesUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.statistics.BluedStatistics;
import com.google.gson.Gson;
import com.ishumei.smantifraud.SmAntiFraud;
import com.tencent.ugc.datereport.UGCDataReportDef;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/device_identity/library/BluedDeviceIdentity.class */
public class BluedDeviceIdentity {

    /* renamed from: a  reason: collision with root package name */
    private static BluedDeviceIdentity f11232a;
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11233c = false;
    private String d = null;
    private Map<String, String> e = new ConcurrentHashMap();
    private Map<String, Boolean> f = new ConcurrentHashMap();
    private int g = 0;

    public static BluedDeviceIdentity a() {
        if (f11232a == null) {
            f11232a = new BluedDeviceIdentity();
        }
        return f11232a;
    }

    private void a(Context context) {
        Log.v("BluedDeviceIdentity", "initShumengSDK()");
        try {
            Main.init(context, "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKrxd6xg3i6OL6j34xOS3aGZZqxFKBj7eeDqJ44coQFoNi7KxZ8h6OkZCRMX0S8Btodi/NFlb57gsk/kowjfBAcCAwEAAQ==");
            if (TextUtils.equals("1", AppInfo.e())) {
                Main.setConfig("pkglist", "1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Main.getQueryID(context, AppInfo.f9487c, "optionMessage", 1, new Listener() { // from class: com.blued.android.module.device_identity.library.BluedDeviceIdentity.1
            @Override // cn.shuzilm.core.Listener
            public void handler(String str) {
                Log.v("BluedDeviceIdentity", "get shumengid:" + str);
                if (!TextUtils.isEmpty(str)) {
                    BluedDeviceIdentity.this.a("szlm_id", str);
                    BluedStatistics.a().k(str);
                }
                Log.v("BluedDeviceIdentity", "Main.getDeviceLabel");
                Main.getDeviceLabel(0, new Listener() { // from class: com.blued.android.module.device_identity.library.BluedDeviceIdentity.1.1
                    @Override // cn.shuzilm.core.Listener
                    public void handler(String str2) {
                        Log.v("BluedDeviceIdentity", "get shumeng device label:" + str2);
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        BluedDeviceIdentity.this.a("szlm_lable", str2);
                    }
                });
            }
        });
        Log.v("BluedDeviceIdentity", "wait shumeng sdk callback");
        if (TextUtils.equals("1", AppInfo.e()) || TextUtils.equals("7", AppInfo.e())) {
            Main.getOpenAnmsID(context, new Listener() { // from class: com.blued.android.module.device_identity.library.BluedDeviceIdentity.2
                @Override // cn.shuzilm.core.Listener
                public void handler(String str) {
                    Log.v("BluedDeviceIdentity", "get oaid:" + str);
                    if ("NA".equalsIgnoreCase(str)) {
                        return;
                    }
                    BluedDeviceIdentity.this.e.put("oaid", str);
                    BluedDeviceIdentity.this.a(str);
                    BluedStatistics.a().m(str);
                }
            });
            Log.v("BluedDeviceIdentity", "wait shumeng-oaid sdk callback");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        SharedPreferencesUtils.a().edit().putString("SM_OAID", str).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        String str3 = this.e.get(str);
        Boolean bool = this.f.get(str);
        if (((bool == null ? false : bool.booleanValue()) && TextUtils.equals(str3, str2)) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.e.put(str, str2);
        if (this.f11233c) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", str);
            hashMap.put(UGCDataReportDef.DR_KEY_DEV_ID, str2);
            Log.v("BluedDeviceIdentity", "upload deviceId, type:" + str + ", id:" + str2);
            Map<String, String> a2 = BluedHttpTools.a();
            Gson f = AppInfo.f();
            try {
                a2.put(BridgeUtil.UNDERLINE_STR, this.g != 2 ? AesCrypto.b(f.toJson(hashMap)) : AesCrypto2.b(f.toJson(hashMap)));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(this.d)) {
                return;
            }
            this.f.put(str, true);
            BluedStatistics.c().a("PUSH_TOKEN", 0L, 0, str2);
            HttpManager.b(this.d).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(a2)).h();
        }
    }

    private void i() {
        Log.v("BluedDeviceIdentity", "initShumeiSDK()");
        try {
            SmAntiFraud.SmOption smOption = new SmAntiFraud.SmOption();
            smOption.setOrganization("qRLrIEyYwqE1vOhOACQy");
            smOption.setChannel(AppInfo.f9487c);
            smOption.setAppId(AppInfo.e());
            smOption.setPublicKey("MIIDOzCCAiOgAwIBAgIBMDANBgkqhkiG9w0BAQUFADA4MQswCQYDVQQGEwJDTjENMAsGA1UECwwEQ05DQjEaMBgGA1UEAwwRZS5iYW5rLmVjaXRpYy5jb20wHhcNMTgwMjExMDg0NTIyWhcNMzgwMjA2MDg0NTIyWjA4MQswCQYDVQQGEwJDTjENMAsGA1UECwwEQ05DQjEaMBgGA1UEAwwRZS5iYW5rLmVjaXRpYy5jb20wggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCkF+2AicVKj7SaHw3dbJt3i6fkL1WfLw1WRqe8r8Cc7qJOshaqNvCzW1qRX6E5H/umtl1Uj99V07uewUFk96xY/+s/GuBnbGoSrcu3OAHDgEGuY5atZo+umIk7LufAif2VUcNGY3nWxGcig20ExO/6nAf/G3Xxo4QL8fBdPG/prOXxSvtJiPls1Qg9zzSgAH+HMCAINMsuJmzDQiTt6Me8k7YHts+jWQF7KF25plITcW1Qmy3Aw8qYjVhbHn8KTAEeuQhmM5RS6KP1Hu71q4DYOWcx44QThSbiAYwG1JQBBwM8XnBfVYMpr6Qi0owibNYoZ/S6xwfRFGB0W1HeG9WfAgMBAAGjUDBOMB0GA1UdDgQWBBT0iLEXY9HIKNy5DG4d72l+R7Nf1zAfBgNVHSMEGDAWgBT0iLEXY9HIKNy5DG4d72l+R7Nf1zAMBgNVHRMEBTADAQH/MA0GCSqGSIb3DQEBBQUAA4IBAQB5MWz1RGFG537rJCtHp+LqxR9iJSFsHiW3ZoLIAeyD0oJ69RcL2gE/TNWmE9zYUkd9TdNtXqxlNPpj1P1/+x781neWnGou/n/XFS82T5S339X3DIjHc/IqOzwnxEOKH2V0NmK9iKgx6H05Q9MMvUXFsL3QK2hDMAVY28roRiC4S1yfJJaA08DfvXZf6cVx1xfWl+ks57+3knkoWap1rjwh1RdGk5ChPbzD0AnAcWTMWRCbjuJnttlmWZnI1I6mhcQUKUEMoj8sR8m11YJ5woscYPsIle/rJOOosuMghczD1vRcg3eLUaWn1A5rsBa82RyxhiuYocEQVX59Hy6v3npT");
            if (TextUtils.equals("2", AppInfo.e())) {
                smOption.setArea(SmAntiFraud.AREA_XJP);
            }
            if (TextUtils.equals("1", AppInfo.e())) {
                HashSet hashSet = new HashSet();
                hashSet.add("imei");
                hashSet.add("apps");
                hashSet.add("riskapp");
                smOption.setNotCollect(hashSet);
            }
            smOption.setServerIdCallback(new SmAntiFraud.IServerSmidCallback() { // from class: com.blued.android.module.device_identity.library.BluedDeviceIdentity.3
                @Override // com.ishumei.smantifraud.SmAntiFraud.IServerSmidCallback
                public void onError(int i) {
                    Log.v("BluedDeviceIdentity", "get shumeiBoxId failed:" + i);
                }

                @Override // com.ishumei.smantifraud.SmAntiFraud.IServerSmidCallback
                public void onSuccess(String str) {
                    Log.v("BluedDeviceIdentity", "get shumeiBoxId:" + str);
                    BluedStatistics.a().j(str);
                    BluedDeviceIdentity.this.a("boxid", str);
                }
            });
            SmAntiFraud.create(AppInfo.d(), smOption);
            Log.v("BluedDeviceIdentity", "wait shumei sdk callback");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void j() {
        Log.v("BluedDeviceIdentity", "upload all id");
        a("szlm_id", this.e.get("szlm_id"));
        a("boxid", this.e.get("boxid"));
        a("oaid", this.e.get("oaid"));
        a("push_token", this.e.get("push_token"));
    }

    private String k() {
        return SharedPreferencesUtils.a().getString("SM_OAID", "");
    }

    public void a(Context context, String str, int i) {
        Log.v("BluedDeviceIdentity", "init, app:" + AppInfo.e());
        if (this.b) {
            return;
        }
        this.b = true;
        this.d = str;
        this.g = i;
        i();
        a(context);
        Log.v("BluedDeviceIdentity", "init end");
    }

    public void b() {
        if (this.f11233c) {
            return;
        }
        this.f11233c = true;
        j();
    }

    public void c() {
        this.f11233c = false;
        this.f.clear();
    }

    public String d() {
        String str = this.e.get("szlm_id");
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    public String e() {
        String str = this.e.get("szlm_lable");
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    @Deprecated
    public String f() {
        return "";
    }

    public String g() {
        if (this.b) {
            String str = this.e.get("boxid");
            String str2 = str;
            if (TextUtils.isEmpty(str)) {
                str2 = str;
                try {
                    String deviceId = SmAntiFraud.getDeviceId();
                    StringBuilder sb = new StringBuilder();
                    sb.append("get local shumeiBoxId : ");
                    sb.append(deviceId);
                    Log.v("BluedDeviceIdentity", sb.toString());
                    str2 = deviceId;
                    BluedStatistics.a().j(deviceId);
                    str2 = deviceId;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return str2 == null ? "" : str2;
        }
        return "";
    }

    public String h() {
        String str = this.e.get("oaid");
        String str2 = str;
        if (TextUtils.isEmpty(str)) {
            String k = k();
            Log.v("BluedDeviceIdentity", "get cached oaid:" + k);
            str2 = k;
            if (!TextUtils.isEmpty(k)) {
                this.e.put("oaid", k);
                str2 = k;
            }
        }
        return str2;
    }
}
