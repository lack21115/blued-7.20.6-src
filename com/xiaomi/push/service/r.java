package com.xiaomi.push.service;

import com.xiaomi.push.hf;
import com.xiaomi.push.hk;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/r.class */
public class r implements hf {

    /* renamed from: a  reason: collision with root package name */
    private final XMPushService f28006a;

    public r(XMPushService xMPushService) {
        this.f28006a = xMPushService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f28006a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    @Override // com.xiaomi.push.hf
    public void a(List<hk> list, String str, String str2) {
        this.f28006a.a(new s(this, 4, str, list, str2));
    }
}
