package com.unikuwei.mianmi.account.shield.tencent.c;

import android.content.Context;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
import com.unikuwei.mianmi.account.shield.tencent.ResultListener;
import com.unikuwei.mianmi.account.shield.tencent.c.a;
import com.unikuwei.mianmi.account.shield.tencent.e.f;
import com.unikuwei.mianmi.account.shield.tencent.e.g;
import com.unikuwei.mianmi.account.shield.tencent.e.h;
import com.unikuwei.mianmi.account.shield.tencent.e.i;
import com.unikuwei.mianmi.account.shield.tencent.e.m;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/unikuwei/mianmi/account/shield/tencent/c/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f27304a;

    private c() {
    }

    private int a(String str, String str2) {
        try {
            byte[] bytes = str.getBytes();
            byte[] bytes2 = str2.getBytes();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 5) {
                    return 1;
                }
                int i3 = 5 + i2;
                if (bytes[i3] != bytes2[i3]) {
                    return 0;
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            return 0;
        }
    }

    public static c a() {
        if (f27304a == null) {
            synchronized (c.class) {
                try {
                    if (f27304a == null) {
                        f27304a = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f27304a;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0108 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(android.content.Context r5) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unikuwei.mianmi.account.shield.tencent.c.c.a(android.content.Context):boolean");
    }

    public static String b() {
        return "5.2.0AK002B1125";
    }

    private void b(Context context, String str, String str2) {
        try {
            Class loadClass = i.a().loadClass(new String(m.b("Y29tLnVuaWNvbS54aWFvd28ubG9naW5jb3JlLlVuaUF1dGhIZWxwZXI=")));
            loadClass.getMethod("init", Context.class, String.class, String.class).invoke(loadClass.getMethod("getInstance", new Class[0]).invoke(loadClass, new Object[0]), context, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            i.d(context);
        }
    }

    public void a(Context context, int i, int i2, final ResultListener resultListener) {
        new a().a(context, i, i2, new a.InterfaceC0921a() { // from class: com.unikuwei.mianmi.account.shield.tencent.c.c.1
            @Override // com.unikuwei.mianmi.account.shield.tencent.c.a.InterfaceC0921a
            public void a(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt(ProcessBridgeProvider.KEY_RESULT_CODE);
                    String optString = jSONObject.optString(ProcessBridgeProvider.KEY_RESULT_MSG);
                    if (optInt >= 10000 && optInt <= 10099) {
                        if (optInt == 10000) {
                            optString = "" + h.c();
                        }
                        new f().a("" + optInt, optString);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                resultListener.onResult(str);
            }
        });
    }

    public void a(Context context, String str, String str2) {
        try {
            if (a(context)) {
                b(context, str, str2);
            } else {
                i.d(context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(boolean z) {
        g.a(z);
    }
}
