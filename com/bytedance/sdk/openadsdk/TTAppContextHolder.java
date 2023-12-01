package com.bytedance.sdk.openadsdk;

import android.app.Application;
import android.content.Context;
import java.lang.reflect.Method;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTAppContextHolder.class */
public class TTAppContextHolder {
    private static volatile Context mb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/TTAppContextHolder$mb.class */
    public static class mb {
        private static volatile Application mb;

        static {
            try {
                Object ox = ox();
                mb = (Application) ox.getClass().getMethod("getApplication", new Class[0]).invoke(ox, new Object[0]);
                com.bytedance.sdk.openadsdk.api.mb.hj("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.mb.ox("MyApplication", "application get failed", th);
            }
        }

        public static Application mb() {
            return mb;
        }

        private static Object ox() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.mb.ox("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }

    public static Context getContext() {
        if (mb == null) {
            setContext(null);
        }
        return mb;
    }

    public static void setContext(Context context) {
        synchronized (TTAppContextHolder.class) {
            try {
                if (mb == null) {
                    if (context != null) {
                        mb = context.getApplicationContext();
                    } else if (mb.mb() != null) {
                        try {
                            mb = mb.mb();
                            if (mb != null) {
                            }
                        } catch (Throwable th) {
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
