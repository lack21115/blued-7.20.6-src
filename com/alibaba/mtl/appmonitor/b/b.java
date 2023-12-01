package com.alibaba.mtl.appmonitor.b;

import android.content.Context;
import com.alibaba.mtl.appmonitor.SdkMeta;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.a.h;
import com.alibaba.mtl.appmonitor.c.d;
import com.alibaba.mtl.appmonitor.c.e;
import com.alibaba.mtl.appmonitor.f.c;
import com.amap.api.maps.model.MyLocationStyle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/b/b.class */
public class b {
    private static String a(Throwable th) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(th.getClass().getName());
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null) {
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                sb.append(stackTrace[i2].toString());
                i = i2 + 1;
            }
        }
        String sb2 = sb.toString();
        String str = sb2;
        if (com.alibaba.mtl.appmonitor.f.b.isBlank(sb2)) {
            str = th.toString();
        }
        return str;
    }

    private static JSONObject a(Context context, Throwable th) throws IOException {
        JSONObject jSONObject = (JSONObject) com.alibaba.mtl.appmonitor.c.a.a().a(e.class, new Object[0]);
        if (context != null) {
            try {
                jSONObject.put("pname", com.alibaba.mtl.log.e.b.a(context));
            } catch (Exception e) {
                return jSONObject;
            }
        }
        jSONObject.put("page", "APPMONITOR");
        jSONObject.put("monitorPoint", "sdk-exception");
        jSONObject.put("arg", th.getClass().getSimpleName());
        jSONObject.put("successCount", 0);
        jSONObject.put("failCount", 1);
        ArrayList arrayList = new ArrayList();
        String a = a(th);
        if (a != null) {
            JSONObject jSONObject2 = (JSONObject) com.alibaba.mtl.appmonitor.c.a.a().a(e.class, new Object[0]);
            jSONObject2.put(MyLocationStyle.ERROR_CODE, a);
            jSONObject2.put("errorCount", 1);
            arrayList.add(jSONObject2);
        }
        jSONObject.put("errors", arrayList);
        return jSONObject;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m8586a(Context context, Throwable th) {
        if (th != null) {
            try {
                h hVar = (h) com.alibaba.mtl.appmonitor.c.a.a().a(h.class, new Object[0]);
                hVar.e = f.ALARM.m8582a();
                HashMap hashMap = new HashMap();
                hashMap.put("meta", SdkMeta.getSDKMetaData());
                d dVar = (d) com.alibaba.mtl.appmonitor.c.a.a().a(d.class, new Object[0]);
                dVar.put(a(context, th));
                hashMap.put("data", dVar);
                hVar.k.put(f.ALARM.m8583a(), new JSONObject(hashMap).toString());
                hVar.v = "APPMONITOR";
                hVar.w = "sdk-exception";
                c.a(hVar);
                com.alibaba.mtl.appmonitor.c.a.a().a((com.alibaba.mtl.appmonitor.c.a) dVar);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m8587a(Throwable th) {
        m8586a((Context) null, th);
    }
}
