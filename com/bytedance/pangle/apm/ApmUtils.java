package com.bytedance.pangle.apm;

import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/apm/ApmUtils.class */
public class ApmUtils {
    private static volatile AbsApm sApm;

    public static AbsApm getApmInstance() {
        if (sApm == null) {
            synchronized (AbsApm.class) {
                try {
                    if (sApm == null) {
                        sApm = new AbsApm() { // from class: com.bytedance.pangle.apm.ApmUtils.1
                            @Override // com.bytedance.pangle.apm.AbsApm
                            public final String getDid() {
                                return "0";
                            }

                            @Override // com.bytedance.pangle.apm.AbsApm
                            public final void init() {
                            }

                            @Override // com.bytedance.pangle.apm.AbsApm
                            public final void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
                            }

                            @Override // com.bytedance.pangle.apm.AbsApm
                            public final void reportError(String str, Throwable th) {
                            }
                        };
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sApm;
    }

    public static void register(AbsApm absApm) {
        synchronized (ApmUtils.class) {
            try {
                sApm = absApm;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
