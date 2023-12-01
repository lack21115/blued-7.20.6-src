package com.bytedance.pangle.e;

import android.os.SystemClock;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.i;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/e/f.class */
public final class f {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/e/f$a.class */
    public interface a {
        boolean a(String str, int i);
    }

    public static void a() {
        if ((i.d() || i.f() || i.b()) && com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            com.bytedance.pangle.d.e.a(new Runnable() { // from class: com.bytedance.pangle.e.f.1
                @Override // java.lang.Runnable
                public final void run() {
                    SystemClock.sleep(GlobalParam.getInstance().getDexOptDelayTime());
                    f.b();
                }
            });
        }
    }

    public static void b() {
        synchronized (f.class) {
            try {
                Map<String, ?> all = b.a(Zeus.getAppApplication()).getAll();
                if (all.size() > 0) {
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        if ((i.f() ? new e() : i.d() ? new d() : i.b() ? new c() : new a() { // from class: com.bytedance.pangle.e.f.2
                            @Override // com.bytedance.pangle.e.f.a
                            public final boolean a(String str, int i) {
                                return true;
                            }
                        }).a(entry.getKey(), ((Integer) entry.getValue()).intValue())) {
                            b.a(Zeus.getAppApplication()).edit().remove(entry.getKey()).apply();
                            ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat:" + entry.getKey());
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
