package cn.com.chinatelecom.account.api.e;

import android.content.Context;
import cn.com.chinatelecom.account.api.CtAuth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:cn/com/chinatelecom/account/api/e/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4095a = f.class.getSimpleName();
    private static int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, e> f4096c = new HashMap();
    private static List<e> d = new ArrayList();
    private static e e = null;

    public static e a(String str) {
        e eVar;
        synchronized (f.class) {
            e eVar2 = null;
            try {
                if (f4096c.containsKey(str)) {
                    eVar2 = f4096c.get(str);
                }
                eVar = eVar2;
                if (eVar2 == null) {
                    eVar = new e(str);
                    f4096c.put(str, eVar);
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    return new e(str);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return eVar;
    }

    public static void a(Context context, String str) {
        cn.com.chinatelecom.account.a.c.a(context, str);
    }

    public static void a(String str, JSONObject jSONObject, String str2) {
        synchronized (f.class) {
            try {
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (f4096c.containsKey(str)) {
                f4096c.get(str).g(str2);
                return;
            }
            if (d.size() > 0) {
                for (e eVar : d) {
                    if (eVar.a() != null && eVar.a().equals(str) && jSONObject != null) {
                        jSONObject.remove("data");
                        eVar.g(jSONObject.toString());
                        eVar.g(str2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context) {
        if (context == null) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            synchronized (f.class) {
                if (e != null) {
                    arrayList.add(e.toString());
                    e = null;
                }
                for (e eVar : d) {
                    arrayList.add(eVar.toString());
                }
                b = 0;
                d.clear();
            }
            if (arrayList.isEmpty()) {
                return;
            }
            cn.com.chinatelecom.account.a.c.a(context, arrayList);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(String str) {
        synchronized (f.class) {
            try {
                if (f4096c.containsKey(str)) {
                    e eVar = f4096c.get(str);
                    e = eVar;
                    eVar.b();
                    f4096c.remove(str);
                }
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static void b(String str, JSONObject jSONObject, String str2) {
        try {
            int optInt = jSONObject.optInt("result");
            String optString = jSONObject.optString("msg");
            if (optInt == 0) {
                a(str).a(optInt).e(optString);
            } else {
                a(str).a(optInt).e(optString).d(str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(String str) {
        try {
            synchronized (f.class) {
                if (f4096c.containsKey(str)) {
                    e eVar = f4096c.get(str);
                    eVar.b();
                    d.add(eVar);
                    f4096c.remove(str);
                }
                if (b != 1 && !d.isEmpty()) {
                    b = 1;
                    new Timer().schedule(new TimerTask() { // from class: cn.com.chinatelecom.account.api.e.f.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            f.b(CtAuth.mContext);
                        }
                    }, 8000L);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
