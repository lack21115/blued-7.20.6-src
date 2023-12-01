package com.huawei.hms.hatool;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/v.class */
public class v {
    public static f1 a(String str, String str2) {
        f1 f1Var = new f1();
        f1Var.a(a1.a().a(str, str2));
        return f1Var;
    }

    public static g1 a(String str, String str2, String str3, String str4) {
        g1 g1Var = new g1();
        g1Var.a(str);
        g1Var.b(b.f());
        g1Var.e(str2);
        g1Var.c(str4);
        StringBuffer stringBuffer = new StringBuffer("hmshi");
        stringBuffer.append(str3);
        stringBuffer.append("qrt");
        g1Var.d(stringBuffer.toString());
        return g1Var;
    }

    public static h1 a(String str, String str2, String str3) {
        h1 h1Var = new h1();
        h1Var.c(b.j());
        h1Var.e(b.l());
        h1Var.a(str3);
        h1Var.b(a1.a().b(str2, str));
        return h1Var;
    }

    public static C1138r b(String str, String str2) {
        z.c("hmsSdk", "generate UploadData EventModelHandlerBase");
        y.d().a(str, str2);
        if (TextUtils.isEmpty(y.d().a())) {
            z.f("hmsSdk", "event chifer is empty");
            return null;
        }
        return new C1138r(y.d().c());
    }

    public static Map<String, String> c(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", b.f());
        hashMap.put("App-Ver", b.g());
        hashMap.put("Sdk-Name", "hianalytics");
        hashMap.put("Sdk-Ver", "2.2.0.313");
        hashMap.put("Device-Type", Build.MODEL);
        hashMap.put("servicetag", str);
        z.a("hmsSdk", "sendData RequestId : %s", str2);
        hashMap.put("Request-Id", str2);
        return hashMap;
    }
}
