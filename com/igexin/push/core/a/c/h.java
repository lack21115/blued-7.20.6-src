package com.igexin.push.core.a.c;

import android.os.Bundle;
import java.net.ServerSocket;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/c/h.class */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23420a = "ReportCidAction";
    private static final int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final int f23421c = 1;
    private static final int d = 2;
    private static final int e = 51688;
    private static final int f = 180000;
    private static h i;
    private Long g;
    private ServerSocket h;

    private h() {
    }

    public static h a() {
        if (i == null) {
            i = new h();
        }
        return i;
    }

    public final void a(boolean z) {
        JSONArray jSONArray;
        if (z) {
            try {
                if (com.igexin.push.core.e.p && com.igexin.push.core.e.s) {
                    int i2 = 0;
                    try {
                        if (this.h == null) {
                            this.h = new ServerSocket(e);
                        }
                    } catch (Exception e2) {
                        com.igexin.c.a.c.a.a("ReportCidAction|port 51688 has occupy by others", new Object[0]);
                    }
                    if (this.h != null) {
                        if (com.igexin.push.core.e.aG < 180000) {
                            com.igexin.push.core.e.aG = 180000L;
                        }
                        if (com.igexin.push.core.e.aF < 180000) {
                            com.igexin.push.core.e.aF = 180000L;
                        }
                        if (this.g == null) {
                            long currentTimeMillis = System.currentTimeMillis() - com.igexin.push.core.e.aH;
                            if (currentTimeMillis < com.igexin.push.core.e.aG) {
                                com.igexin.c.a.c.a.a("ReportCidAction|lastReportInterval < reportCidRestartThreshold not report", new Object[0]);
                                return;
                            } else if (currentTimeMillis < com.igexin.push.core.e.aF) {
                                i2 = 2;
                            }
                        } else if (System.currentTimeMillis() - this.g.longValue() < com.igexin.push.core.e.aF) {
                            com.igexin.c.a.c.a.a("ReportCidAction|offline time < reportCidOfflineThreshold not report", new Object[0]);
                            return;
                        } else {
                            i2 = 1;
                        }
                        List<JSONObject> h = com.igexin.push.f.j.h();
                        if (h == null) {
                            jSONArray = new JSONArray();
                        } else if (h.size() <= 0) {
                            return;
                        } else {
                            jSONArray = new JSONArray((Collection) h);
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("appinfo", jSONArray);
                        jSONObject.put("deviceid", "ANDROID-" + com.igexin.push.core.e.H);
                        jSONObject.put("type", i2);
                        jSONObject.put("pkg", com.igexin.push.core.e.l.getPackageName());
                        Bundle bundle = new Bundle();
                        bundle.putString("action", "sendMessage");
                        StringBuilder sb = new StringBuilder(com.igexin.push.core.b.T);
                        sb.append(com.igexin.c.b.a.b(com.igexin.push.core.e.A + System.currentTimeMillis()));
                        bundle.putString("taskid", sb.toString());
                        bundle.putByteArray("extraData", jSONObject.toString().getBytes());
                        com.igexin.push.core.a.b.d();
                        com.igexin.push.core.a.b.a(bundle);
                        com.igexin.push.config.a.a().a(System.currentTimeMillis());
                    }
                }
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
                return;
            }
        }
        if (z) {
            return;
        }
        this.g = Long.valueOf(System.currentTimeMillis());
    }
}
