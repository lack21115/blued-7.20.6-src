package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/k1.class */
public class k1 {

    /* renamed from: a  reason: collision with root package name */
    public String f22762a;
    public m b;

    public k1(String str) {
        this.f22762a = str;
        this.b = new m(str);
        i.c().a(this.f22762a, this.b);
    }

    public void a(int i) {
        z.d("hmsSdk", "onReport. TAG: " + this.f22762a + ", TYPE: " + i);
        j1.a().a(this.f22762a, i);
    }

    public void a(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        z.d("hmsSdk", "onEvent. TAG: " + this.f22762a + ", TYPE: " + i + ", eventId : " + str);
        if (t0.a(str) || !c(i)) {
            z.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f22762a + ", TYPE: " + i);
            return;
        }
        LinkedHashMap<String, String> linkedHashMap2 = linkedHashMap;
        if (!t0.a(linkedHashMap)) {
            z.e("hmsSdk", "onEvent() parameter mapValue will be cleared.TAG: " + this.f22762a + ", TYPE: " + i);
            linkedHashMap2 = null;
        }
        j1.a().a(this.f22762a, i, str, linkedHashMap2);
    }

    public void a(Context context, String str, String str2) {
        z.d("hmsSdk", "onEvent(context). TAG: " + this.f22762a + ", eventId : " + str);
        if (context == null) {
            z.e("hmsSdk", "context is null in onevent ");
        } else if (t0.a(str) || !c(0)) {
            z.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f22762a);
        } else {
            String str3 = str2;
            if (!t0.a("value", str2, 65536)) {
                z.e("hmsSdk", "onEvent() parameter VALUE is overlong, content will be cleared.TAG: " + this.f22762a);
                str3 = "";
            }
            j1.a().a(this.f22762a, context, str, str3);
        }
    }

    public void a(k kVar) {
        z.c("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : " + this.f22762a);
        if (kVar != null) {
            this.b.a(kVar);
            return;
        }
        z.e("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
        this.b.a((k) null);
    }

    public final k b(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return this.b.a();
                }
                return this.b.d();
            }
            return this.b.b();
        }
        return this.b.c();
    }

    public void b(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        z.d("hmsSdk", "onStreamEvent. TAG: " + this.f22762a + ", TYPE: " + i + ", eventId : " + str);
        if (t0.a(str) || !c(i)) {
            z.e("hmsSdk", "onStreamEvent() parameters check fail. Nothing will be recorded.TAG: " + this.f22762a + ", TYPE: " + i);
            return;
        }
        LinkedHashMap<String, String> linkedHashMap2 = linkedHashMap;
        if (!t0.a(linkedHashMap)) {
            z.e("hmsSdk", "onStreamEvent() parameter mapValue will be cleared.TAG: " + this.f22762a + ", TYPE: " + i);
            linkedHashMap2 = null;
        }
        j1.a().b(this.f22762a, i, str, linkedHashMap2);
    }

    public void b(k kVar) {
        z.c("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: " + this.f22762a);
        if (kVar != null) {
            this.b.b(kVar);
            return;
        }
        this.b.b(null);
        z.e("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
    }

    public final boolean c(int i) {
        String str;
        if (i != 2) {
            k b = b(i);
            if (b != null && !TextUtils.isEmpty(b.h())) {
                return true;
            }
            str = "verifyURL(): URL check failed. type: " + i;
        } else if ("_default_config_tag".equals(this.f22762a)) {
            return true;
        } else {
            str = "verifyURL(): type: preins. Only default config can report Pre-install data.";
        }
        z.e("hmsSdk", str);
        return false;
    }
}
