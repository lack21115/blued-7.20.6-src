package com.xiaomi.mipush.sdk;

import com.xiaomi.push.hl;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/l.class */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<e, a> f27537a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/l$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f27538a;
        public String b;

        public a(String str, String str2) {
            this.f27538a = str;
            this.b = str2;
        }
    }

    static {
        a(e.ASSEMBLE_PUSH_HUAWEI, new a("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        a(e.ASSEMBLE_PUSH_FCM, new a("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        a(e.ASSEMBLE_PUSH_COS, new a("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        a(e.ASSEMBLE_PUSH_FTOS, new a("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    public static au a(e eVar) {
        int i = m.f27539a[eVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return null;
                    }
                    return au.UPLOAD_FTOS_TOKEN;
                }
                return au.UPLOAD_COS_TOKEN;
            }
            return au.UPLOAD_FCM_TOKEN;
        }
        return au.UPLOAD_HUAWEI_TOKEN;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static a m8437a(e eVar) {
        return f27537a.get(eVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static hl m8438a(e eVar) {
        return hl.AggregatePushSwitch;
    }

    private static void a(e eVar, a aVar) {
        if (aVar != null) {
            f27537a.put(eVar, aVar);
        }
    }
}
